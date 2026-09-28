package com.bajaj.rideconnect.re

import java.nio.charset.StandardCharsets
import kotlin.math.min

object PulsarProtocol {

    const val SERVICE_UUID: String = "0010676e-6972-6565-6e69-676e4543544f"
    const val CHAR_TELEMETRY_UUID: String = "0210676e-6972-6565-6e69-676e4543544f"
    const val CHAR_MEDIA_UUID: String = "0610676e-6972-6565-6e69-676e4543544f"
    const val CHAR_CONTROLS_UUID: String = "0a10676e-6972-6565-6e69-676e4543544f"
    const val CCCD_DESCRIPTOR_UUID: String = "00002902-0000-1000-8000-00805f9b34fb"

    fun getBatteryLevel(percent: Int): Int {
        if (percent < 20) return 0
        if (percent < 40) return 1
        if (percent < 60) return 2
        if (percent < 80) return 3
        return 4
    }

    fun buildCompactTelemetryFrame(
        batteryPercent: Int,
        signalBars: Int,
        callState: Int = 0,
        callerNameOrNumber: String? = null,
        missedCalls: Int = 0,
        unreadSms: Int = 0,
        seqCounter: Byte = 0,
        volumeLevel: Int = 5,
        isHeadset: Boolean = false
    ): ByteArray {
        val frame = ByteArray(55)
        val headsetBit = if (isHeadset) 1 else 0
        val clampedVol = volumeLevel.coerceIn(0, 10)
        frame[0] = ((headsetBit shl 4) or (clampedVol and 0x0F) or 0xC0).toByte()

        val batteryLevel = getBatteryLevel(batteryPercent)
        frame[1] = ((callState and 0x07) or ((batteryLevel and 0x07) shl 3)).toByte()
        frame[2] = (signalBars.coerceIn(0, 4) and 0x07).toByte()

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

    private const val MAX_MEDIA_FIELD_BYTES = 31

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

        writeUtf8Field(frame, lengthOffset = 1, dataOffset = 2, text = title)
        writeUtf8Field(frame, lengthOffset = 34, dataOffset = 35, text = artist)
        writeUtf8Field(frame, lengthOffset = 67, dataOffset = 68, text = album)

        frame[100] = ((positionSec shr 8) and 0xFF).toByte()
        frame[101] = (positionSec and 0xFF).toByte()

        frame[102] = ((durationSec shr 8) and 0xFF).toByte()
        frame[103] = (durationSec and 0xFF).toByte()

        frame[104] = (playbackState and 0xFF).toByte()

        return frame
    }

    private fun writeUtf8Field(
        frame: ByteArray, lengthOffset: Int, dataOffset: Int, text: String?
    ) {
        if (text.isNullOrEmpty()) return
        val rawBytes = text.toByteArray(StandardCharsets.UTF_8)
        var len = min(rawBytes.size, MAX_MEDIA_FIELD_BYTES)
        if (rawBytes.size > MAX_MEDIA_FIELD_BYTES) {
            while (len > 0 && (rawBytes[len].toInt() and 0xC0) == 0x80) {
                len--
            }
        }
        frame[lengthOffset] = len.toByte()
        if (len > 0) {
            System.arraycopy(rawBytes, 0, frame, dataOffset, len)
        }
    }

    class HandlebarEvent {
        var musicPlay: Boolean = false
        var musicPause: Boolean = false
        var musicNext: Boolean = false
        var musicPrev: Boolean = false
        var musicStop: Boolean = false
        var volumeChanged: Boolean = false
        var volumeLevel: Int = 0

        fun hasAction(): Boolean =
            musicPlay || musicPause || musicNext || musicPrev || musicStop || volumeChanged

        override fun toString(): String =
            "HandlebarEvent[play=$musicPlay, pause=$musicPause, next=$musicNext, prev=$musicPrev, stop=$musicStop, vol=$volumeLevel, volChanged=$volumeChanged]"
    }

    private var lastMusicPlayCtr = 0
    private var lastMusicPauseCtr = 0
    private var lastMusicNextCtr = 0
    private var lastMusicPrevCtr = 0
    private var lastMusicStopCtr = 0
    private var lastVolumeNibble = -1
    private var handlebarInitialized = false

    @Synchronized
    fun resetHandlebarCounters() {
        handlebarInitialized = false
        lastVolumeNibble = -1
    }

    @Synchronized
    fun parseHandlebarPacket(data: ByteArray?): HandlebarEvent? {
        if (data == null || data.size < 11) return null

        val musicPlay = data[6].toInt() and 0xFF
        val musicPause = data[7].toInt() and 0xFF
        val musicNext = data[8].toInt() and 0xFF
        val musicPrev = data[9].toInt() and 0xFF
        val musicStop = data[10].toInt() and 0xFF
        val volNibble = data[0].toInt() and 0x0F

        if (!handlebarInitialized) {
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
}