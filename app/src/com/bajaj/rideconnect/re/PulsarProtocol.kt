package com.bajaj.rideconnect.re

import java.nio.charset.StandardCharsets
import java.util.Locale
import kotlin.math.max
import kotlin.math.min

object PulsarProtocol {

    const val SERVICE_UUID: String = "0010676e-6972-6565-6e69-676e4543544f"
    const val CHAR_TELEMETRY_UUID: String = "0210676e-6972-6565-6e69-676e4543544f"
    const val CHAR_MEDIA_UUID: String = "0610676e-6972-6565-6e69-676e4543544f"
    const val CHAR_CONTROLS_UUID: String = "0a10676e-6972-6565-6e69-676e4543544f"
    const val CCCD_DESCRIPTOR_UUID: String = "00002902-0000-1000-8000-00805f9b34fb"

    // =========================================================================
    // 2. Phone Telemetry & Status Frame (0210 - 55 / 89 Bytes)
    // =========================================================================
    @JvmStatic
    fun getBatteryLevel(percent: Int): Int {
        if (percent < 20) return 0
        if (percent < 40) return 1
        if (percent < 60) return 2
        if (percent < 80) return 3
        return 4
    }

    @JvmStatic
    fun buildTelemetryFrame(
        batteryPercent: Int,
        signalBars: Int,
        callState: Int,
        callerNameOrNumber: String?,
        missedCalls: Int,
        unreadSms: Int,
        seqCounter: Byte,
        phoneModel: String?
    ): ByteArray {
        val frame = ByteArray(89)

        // Byte 0: Audio volume / Headset (0xC0 | volume)
        frame[0] = (0x05 or 0xC0).toByte()

        // Byte 1: (callState & 0x07) | (batteryLevel << 3)
        val batteryLevel = getBatteryLevel(batteryPercent)
        frame[1] = ((callState and 0x07) or ((batteryLevel and 0x07) shl 3)).toByte()

        // Byte 2: Cellular Signal Bars (0-4)
        frame[2] = (min(4, max(0, signalBars)) and 0x07).toByte()
        frame[3] = if (callState == 3) 1.toByte() else 0.toByte()
        frame[4] = if (callState == 3) 0.toByte() else 1.toByte()

        // ACKs
        frame[13] = (missedCalls and 0xFF).toByte()
        frame[15] = (unreadSms and 0xFF).toByte()

        // Caller Info (Bytes 18-51)
        if ((callState == 1 || callState == 2 || callState == 3) && !callerNameOrNumber.isNullOrEmpty()) {
            var cleanCaller = callerNameOrNumber.replace(Regex("[^a-zA-Z0-9 +.\\-]"), "").trim()
            if (cleanCaller.isNotEmpty()) {
                frame[18] = 1.toByte()
                if (cleanCaller.length > 30) cleanCaller = cleanCaller.substring(0, 30)
                val callerBytes = cleanCaller.toByteArray(StandardCharsets.UTF_8)
                val len = min(callerBytes.size, 30)
                frame[20] = len.toByte()
                System.arraycopy(callerBytes, 0, frame, 21, len)
            } else {
                frame[18] = 0.toByte()
                frame[20] = 0.toByte()
            }
        } else {
            frame[18] = 0.toByte()
            frame[20] = 0.toByte()
        }

        // Byte 53: Sequence Heartbeat
        frame[53] = seqCounter
        frame[54] = seqCounter

        // Bytes 55-87: Phone Model Name
        if (!phoneModel.isNullOrEmpty()) {
            var modelStr = phoneModel
            if (modelStr.length > 31) modelStr = modelStr.substring(0, 31)
            frame[55] = modelStr.length.toByte()
            val modelBytes = modelStr.toByteArray(StandardCharsets.UTF_8)
            System.arraycopy(modelBytes, 0, frame, 56, min(modelBytes.size, 32))
        }

        // Byte 88: Additive Checksum
        var sum = 0
        for (i in 0 until 88) {
            sum = (sum + frame[i].toInt()) and 0xFF
        }
        frame[88] = sum.toByte()

        return frame
    }

    @JvmOverloads
    @JvmStatic
    fun buildCompactTelemetryFrame(
        batteryPercent: Int,
        signalBars: Int,
        callState: Int,
        callerNameOrNumber: String?,
        missedCalls: Int,
        unreadSms: Int,
        seqCounter: Byte,
        volumeLevel: Int = 5,
        isHeadset: Boolean = false
    ): ByteArray {
        val frame = ByteArray(55)
        val headsetBit = if (isHeadset) 1 else 0
        val clampedVol = max(0, min(volumeLevel, 10))
        frame[0] = ((headsetBit shl 4) or (clampedVol and 0x0F) or 0xC0).toByte()

        val batteryLevel = getBatteryLevel(batteryPercent)
        frame[1] = ((callState and 0x07) or ((batteryLevel and 0x07) shl 3)).toByte()
        frame[2] = (min(4, max(0, signalBars)) and 0x07).toByte()

        frame[3] = if (callState == 3) 1.toByte() else 0.toByte()
        frame[4] = if (callState == 3) 0.toByte() else 1.toByte()

        frame[13] = (missedCalls and 0xFF).toByte()
        frame[15] = (unreadSms and 0xFF).toByte()

        if ((callState == 1 || callState == 2 || callState == 3) && !callerNameOrNumber.isNullOrEmpty()) {
            var clean = callerNameOrNumber.replace(Regex("[^a-zA-Z0-9 +.\\-]"), "").trim()
            if (clean.isNotEmpty()) {
                frame[18] = 1.toByte()
                if (clean.length > 30) clean = clean.substring(0, 30)
                val bytes = clean.toByteArray(StandardCharsets.UTF_8)
                val len = min(bytes.size, 30)
                frame[20] = len.toByte()
                System.arraycopy(bytes, 0, frame, 21, len)
            } else {
                frame[18] = 0.toByte()
                frame[20] = 0.toByte()
            }
        } else {
            frame[18] = 0.toByte()
            frame[20] = 0.toByte()
        }

        frame[53] = seqCounter
        frame[54] = seqCounter
        return frame
    }

    // =========================================================================
    // 3. Now Playing Media Frame (0610 - 105 Bytes)
    // =========================================================================
    @JvmStatic
    fun buildMediaFrame(
        title: String?,
        artist: String?,
        album: String?,
        positionSec: Int,
        durationSec: Int,
        playbackState: Int
    ): ByteArray {
        val frame = ByteArray(105)
        frame[0] = 0x01.toByte()

        // Title (Bytes 1-33)
        if (!title.isNullOrEmpty()) {
            var t = title
            if (t.length > 31) t = t.substring(0, 31)
            frame[1] = t.length.toByte()
            val titleBytes = t.toByteArray(StandardCharsets.UTF_8)
            System.arraycopy(titleBytes, 0, frame, 2, min(titleBytes.size, 32))
        }

        // Artist (Bytes 34-66)
        if (!artist.isNullOrEmpty()) {
            var a = artist
            if (a.length > 31) a = a.substring(0, 31)
            frame[34] = a.length.toByte()
            val artistBytes = a.toByteArray(StandardCharsets.UTF_8)
            System.arraycopy(artistBytes, 0, frame, 35, min(artistBytes.size, 32))
        }

        // Album (Bytes 67-99)
        if (!album.isNullOrEmpty()) {
            var al = album
            if (al.length > 31) al = al.substring(0, 31)
            frame[67] = al.length.toByte()
            val albumBytes = al.toByteArray(StandardCharsets.UTF_8)
            System.arraycopy(albumBytes, 0, frame, 68, min(albumBytes.size, 32))
        }

        // Position (Bytes 100-101 Big-Endian uint16)
        frame[100] = ((positionSec shr 8) and 0xFF).toByte()
        frame[101] = (positionSec and 0xFF).toByte()

        // Duration (Bytes 102-103 Big-Endian uint16)
        frame[102] = ((durationSec shr 8) and 0xFF).toByte()
        frame[103] = (durationSec and 0xFF).toByte()

        // Playback Status (Byte 104: 0=None/Stopped, 1=Paused, 2=Playing)
        frame[104] = (playbackState and 0xFF).toByte()

        return frame
    }

    // =========================================================================
    // 4. Handlebar Controls Event Parser (0a10 - 20 Bytes)
    // =========================================================================
    class HandlebarEvent {
        @JvmField var musicPlay: Boolean = false
        @JvmField var musicPause: Boolean = false
        @JvmField var musicNext: Boolean = false
        @JvmField var musicPrev: Boolean = false
        @JvmField var musicStop: Boolean = false
        @JvmField var callAccept: Boolean = false
        @JvmField var callReject: Boolean = false
        @JvmField var volumeChanged: Boolean = false
        @JvmField var volumeLevel: Int = 0

        fun hasAction(): Boolean =
            musicPlay || musicPause || musicNext || musicPrev || musicStop ||
                callAccept || callReject || volumeChanged

        override fun toString(): String =
            "HandlebarEvent[play=$musicPlay, pause=$musicPause, next=$musicNext, " +
                "prev=$musicPrev, stop=$musicStop, accept=$callAccept, " +
                "reject=$callReject, vol=$volumeLevel, volChanged=$volumeChanged]"
    }

    private var lastCallAcceptCtr = 0
    private var lastCallRejectCtr = 0
    private var lastMusicPlayCtr = 0
    private var lastMusicPauseCtr = 0
    private var lastMusicNextCtr = 0
    private var lastMusicPrevCtr = 0
    private var lastMusicStopCtr = 0
    private var lastVolumeNibble = -1
    private var handlebarInitialized = false

    @Synchronized
    @JvmStatic
    fun resetHandlebarCounters() {
        handlebarInitialized = false
        lastVolumeNibble = -1
    }

    @Synchronized
    @JvmStatic
    fun parseHandlebarPacket(data: ByteArray?): HandlebarEvent? {
        if (data == null || data.size < 11) return null

        val callAccept = data[1].toInt() and 0xFF
        val callReject = data[2].toInt() and 0xFF
        val musicPlay = data[6].toInt() and 0xFF
        val musicPause = data[7].toInt() and 0xFF
        val musicNext = data[8].toInt() and 0xFF
        val musicPrev = data[9].toInt() and 0xFF
        val musicStop = data[10].toInt() and 0xFF
        val volNibble = data[0].toInt() and 0x0F

        if (!handlebarInitialized) {
            lastCallAcceptCtr = callAccept
            lastCallRejectCtr = callReject
            lastMusicPlayCtr = musicPlay
            lastMusicPauseCtr = musicPause
            lastMusicNextCtr = musicNext
            lastMusicPrevCtr = musicPrev
            lastMusicStopCtr = musicStop
            lastVolumeNibble = volNibble
            handlebarInitialized = true
            return null
        }

        val ev = HandlebarEvent()
        ev.volumeLevel = volNibble

        if (volNibble != lastVolumeNibble) {
            ev.volumeChanged = true
            lastVolumeNibble = volNibble
        }
        if (callAccept != lastCallAcceptCtr) {
            ev.callAccept = true
            lastCallAcceptCtr = callAccept
        }
        if (callReject != lastCallRejectCtr) {
            ev.callReject = true
            lastCallRejectCtr = callReject
        }
        if (musicPlay != lastMusicPlayCtr) {
            ev.musicPlay = true
            lastMusicPlayCtr = musicPlay
        }
        if (musicPause != lastMusicPauseCtr) {
            ev.musicPause = true
            lastMusicPauseCtr = musicPause
        }
        if (musicNext != lastMusicNextCtr) {
            ev.musicNext = true
            lastMusicNextCtr = musicNext
        }
        if (musicPrev != lastMusicPrevCtr) {
            ev.musicPrev = true
            lastMusicPrevCtr = musicPrev
        }
        if (musicStop != lastMusicStopCtr) {
            ev.musicStop = true
            lastMusicStopCtr = musicStop
        }

        return ev
    }

    // =========================================================================
    // 5. Shared Display & Utility Helpers
    // =========================================================================
    @JvmStatic
    fun formatDistance(meters: Double): String {
        if (meters <= 0.0) return "--"
        return if (meters >= 1000.0) {
            String.format(Locale.US, "%.1f km", meters / 1000.0)
        } else {
            String.format(Locale.US, "%.0f m", meters)
        }
    }

    @JvmStatic
    fun formatEta(hour: Int, min: Int, isPm: Boolean): String {
        val h = if (hour in 1..12) hour else 12
        return String.format(Locale.US, "%02d:%02d %s", h, min, if (isPm) "PM" else "AM")
    }

    @JvmStatic
    fun getGlyphIcon(maneuverName: String?): String {
        return when (maneuverName) {
            "TURN_LEFT", "SHARP_LEFT" -> "↰"
            "TURN_RIGHT", "SHARP_RIGHT" -> "↱"
            "SLIGHT_LEFT", "KEEP_LEFT" -> "↖"
            "SLIGHT_RIGHT", "KEEP_RIGHT" -> "↗"
            "U_TURN_LEFT", "U_TURN_RIGHT" -> "↺"
            "ROUNDABOUT_CW", "ROUNDABOUT_CCW" -> "⮡"
            "RAMP_LEFT" -> "↸"
            "RAMP_RIGHT" -> "↹"
            "MERGE" -> "⇶"
            "DESTINATION" -> "🏁"
            else -> "↑"
        }
    }

    @JvmStatic
    fun getGlyphSymbol(maneuverName: String?): String = getGlyphIcon(maneuverName)

    @JvmStatic
    fun bytesToHex(bytes: ByteArray?): String {
        if (bytes == null || bytes.isEmpty()) return ""
        val sb = StringBuilder(bytes.size * 3)
        for (b in bytes) {
            sb.append(String.format(Locale.US, "%02X ", b))
        }
        return sb.toString().trim()
    }
}
