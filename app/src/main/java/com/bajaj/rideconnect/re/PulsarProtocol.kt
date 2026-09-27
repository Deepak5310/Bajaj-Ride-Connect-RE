package com.bajaj.rideconnect.re

import java.nio.charset.StandardCharsets
import kotlin.math.min

object PulsarProtocol {

    const val SERVICE_UUID: String = "0010676e-6972-6565-6e69-676e4543544f"
    const val CHAR_MEDIA_UUID: String = "0610676e-6972-6565-6e69-676e4543544f"
    const val CHAR_CONTROLS_UUID: String = "0a10676e-6972-6565-6e69-676e4543544f"
    const val CCCD_DESCRIPTOR_UUID: String = "00002902-0000-1000-8000-00805f9b34fb"

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

        if (!title.isNullOrEmpty()) {
            var t = title
            if (t.length > 31) t = t.substring(0, 31)
            frame[1] = t.length.toByte()
            val titleBytes = t.toByteArray(StandardCharsets.UTF_8)
            System.arraycopy(titleBytes, 0, frame, 2, min(titleBytes.size, 32))
        }

        if (!artist.isNullOrEmpty()) {
            var a = artist
            if (a.length > 31) a = a.substring(0, 31)
            frame[34] = a.length.toByte()
            val artistBytes = a.toByteArray(StandardCharsets.UTF_8)
            System.arraycopy(artistBytes, 0, frame, 35, min(artistBytes.size, 32))
        }

        if (!album.isNullOrEmpty()) {
            var al = album
            if (al.length > 31) al = al.substring(0, 31)
            frame[67] = al.length.toByte()
            val albumBytes = al.toByteArray(StandardCharsets.UTF_8)
            System.arraycopy(albumBytes, 0, frame, 68, min(albumBytes.size, 32))
        }

        frame[100] = ((positionSec shr 8) and 0xFF).toByte()
        frame[101] = (positionSec and 0xFF).toByte()

        frame[102] = ((durationSec shr 8) and 0xFF).toByte()
        frame[103] = (durationSec and 0xFF).toByte()

        frame[104] = (playbackState and 0xFF).toByte()

        return frame
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
