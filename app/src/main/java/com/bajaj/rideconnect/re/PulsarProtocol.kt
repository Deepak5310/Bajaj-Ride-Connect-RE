package com.bajaj.rideconnect.re

import java.nio.charset.StandardCharsets

object PulsarProtocol {

    const val SERVICE_UUID: String = "0010676e-6972-6565-6e69-676e4543544f"
    const val CHAR_TELEMETRY_UUID: String = "0210676e-6972-6565-6e69-676e4543544f"
    const val CHAR_MEDIA_UUID: String = "0610676e-6972-6565-6e69-676e4543544f"
    const val CHAR_CONTROLS_UUID: String = "0a10676e-6972-6565-6e69-676e4543544f"
    const val CCCD_DESCRIPTOR_UUID: String = "00002902-0000-1000-8000-00805f9b34fb"

    private const val MAX_MEDIA_FIELD_BYTES = 32
    private val CALLER_CLEANUP_REGEX = Regex("[^a-zA-Z0-9 +.\\-]")

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
            var clean = callerNameOrNumber.replace(CALLER_CLEANUP_REGEX, "").trim()
            if (clean.isNotEmpty()) {
                frame[18] = 1.toByte()
                if (clean.length > 30) clean = clean.substring(0, 30)
                val bytes = clean.toByteArray(StandardCharsets.UTF_8)
                val len = bytes.size.coerceAtMost(30)
                frame[20] = len.toByte()
                System.arraycopy(bytes, 0, frame, 21, len)
            }
        }

        frame[53] = seqCounter
        frame[54] = seqCounter
        return frame
    }

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
        frame: ByteArray, lengthOffset: Int, dataOffset: Int, text: String?, maxBytes: Int = MAX_MEDIA_FIELD_BYTES
    ) {
        if (text.isNullOrEmpty()) return
        val rawBytes = text.toByteArray(StandardCharsets.UTF_8)
        var len = rawBytes.size.coerceAtMost(maxBytes)
        if (rawBytes.size > maxBytes) {
            while (len > 0 && (rawBytes[len].toInt() and 0xC0) == 0x80) {
                len--
            }
        }
        frame[lengthOffset] = len.toByte()
        if (len > 0) {
            System.arraycopy(rawBytes, 0, frame, dataOffset, len)
        }
    }

    data class HandlebarEvent(
        val callAccept: Boolean = false,
        val callReject: Boolean = false,
        val musicPlay: Boolean = false,
        val musicPause: Boolean = false,
        val musicNext: Boolean = false,
        val musicPrev: Boolean = false,
        val musicStop: Boolean = false,
        val volumeChanged: Boolean = false,
        val volumeLevel: Int = 0
    ) {
        fun hasAction(): Boolean =
            callAccept || callReject || musicPlay || musicPause || musicNext || musicPrev || musicStop || volumeChanged
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
    private var lastRawPacket: ByteArray? = null

    @Synchronized
    fun resetHandlebarCounters() {
        handlebarInitialized = false
        lastVolumeNibble = -1
        lastRawPacket = null
    }

    @Synchronized
    fun parseHandlebarPacket(data: ByteArray?): HandlebarEvent? {
        if (data == null || data.size < 11) return null

        val prevRaw = lastRawPacket
        if (prevRaw != null && prevRaw.contentEquals(data)) {
            return null
        }
        lastRawPacket = data.clone()

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

        val accept = callAccept != lastCallAcceptCtr
        if (accept) {
            lastCallAcceptCtr = callAccept
        }

        val reject = callReject != lastCallRejectCtr
        if (reject) {
            lastCallRejectCtr = callReject
        }

        val volChanged = volNibble != lastVolumeNibble
        if (volChanged) {
            lastVolumeNibble = volNibble
        }

        val play = musicPlay != lastMusicPlayCtr
        if (play) {
            lastMusicPlayCtr = musicPlay
        }

        val pause = musicPause != lastMusicPauseCtr
        if (pause) {
            lastMusicPauseCtr = musicPause
        }

        val nextChanged = musicNext != lastMusicNextCtr
        val prevChanged = musicPrev != lastMusicPrevCtr
        val next: Boolean
        val prev: Boolean

        if (nextChanged && prevChanged) {
            next = true
            prev = false
            lastMusicNextCtr = musicNext
            lastMusicPrevCtr = musicPrev
        } else {
            next = nextChanged
            if (next) lastMusicNextCtr = musicNext
            prev = prevChanged
            if (prev) lastMusicPrevCtr = musicPrev
        }

        val stop = musicStop != lastMusicStopCtr
        if (stop) {
            lastMusicStopCtr = musicStop
        }

        return HandlebarEvent(
            callAccept = accept,
            callReject = reject,
            musicPlay = play,
            musicPause = pause,
            musicNext = next,
            musicPrev = prev,
            musicStop = stop,
            volumeChanged = volChanged,
            volumeLevel = volNibble
        )
    }
}