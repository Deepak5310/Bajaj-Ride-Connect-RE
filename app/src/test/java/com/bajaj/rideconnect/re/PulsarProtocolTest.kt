package com.bajaj.rideconnect.re

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.nio.charset.StandardCharsets

class PulsarProtocolTest {

    @Before
    fun setUp() {
        PulsarProtocol.resetHandlebarCounters()
    }

    @Test
    fun testBatteryLevelCalculation() {
        assertEquals(0, PulsarProtocol.getBatteryLevel(0))
        assertEquals(0, PulsarProtocol.getBatteryLevel(19))
        assertEquals(1, PulsarProtocol.getBatteryLevel(20))
        assertEquals(1, PulsarProtocol.getBatteryLevel(39))
        assertEquals(2, PulsarProtocol.getBatteryLevel(40))
        assertEquals(3, PulsarProtocol.getBatteryLevel(60))
        assertEquals(4, PulsarProtocol.getBatteryLevel(80))
        assertEquals(4, PulsarProtocol.getBatteryLevel(100))
        assertEquals(0, PulsarProtocol.getBatteryLevel(-10))
        assertEquals(4, PulsarProtocol.getBatteryLevel(150))
    }

    @Test
    fun testBuildCompactTelemetryFrameStructure() {
        val frame = PulsarProtocol.buildCompactTelemetryFrame(
            batteryPercent = 85,
            signalBars = 4,
            volumeLevel = 7,
            isHeadset = true,
            seqCounter = 0x2A.toByte()
        )

        assertEquals(55, frame.size)

        val byte0 = frame[0].toInt() and 0xFF
        assertTrue("Byte 0 should have 0xC0 marker bits set", (byte0 and 0xC0) == 0xC0)
        assertEquals("Headset bit should be set in bit 4", 1, (byte0 shr 4) and 0x01)
        assertEquals("Volume should be 7 in lower nibble", 7, byte0 and 0x0F)

        val byte1 = frame[1].toInt() and 0xFF
        val batteryLevel = (byte1 shr 3) and 0x07
        assertEquals("Battery level for 85% should be 4", 4, batteryLevel)

        val byte2 = frame[2].toInt() and 0xFF
        assertEquals("Signal bars should be 4", 4, byte2 and 0x07)

        assertEquals(1, frame[4].toInt())
        assertEquals(0x2A.toByte(), frame[53])
        assertEquals(0x2A.toByte(), frame[54])
    }

    @Test
    fun testBuildCompactTelemetryFrameVolumeClamping() {
        val frameUnder = PulsarProtocol.buildCompactTelemetryFrame(
            batteryPercent = 50, signalBars = 3, volumeLevel = -5, isHeadset = false
        )
        assertEquals(0, frameUnder[0].toInt() and 0x0F)

        val frameOver = PulsarProtocol.buildCompactTelemetryFrame(
            batteryPercent = 50, signalBars = 3, volumeLevel = 15, isHeadset = false
        )
        assertEquals(10, frameOver[0].toInt() and 0x0F)
    }

    @Test
    fun testBuildMediaFrameStructure() {
        val title = "Starboy"
        val artist = "The Weeknd"
        val album = "Starboy"
        val posSec = 75
        val durSec = 230
        val playbackState = 1

        val frame = PulsarProtocol.buildMediaFrame(
            title = title,
            artist = artist,
            album = album,
            positionSec = posSec,
            durationSec = durSec,
            playbackState = playbackState
        )

        assertEquals(105, frame.size)
        assertEquals(0x01.toByte(), frame[0])

        val titleLen = frame[1].toInt() and 0xFF
        assertEquals(title.length, titleLen)
        val extractedTitle = String(frame, 2, titleLen, StandardCharsets.UTF_8)
        assertEquals(title, extractedTitle)

        val artistLen = frame[34].toInt() and 0xFF
        assertEquals(artist.length, artistLen)
        val extractedArtist = String(frame, 35, artistLen, StandardCharsets.UTF_8)
        assertEquals(artist, extractedArtist)

        val albumLen = frame[67].toInt() and 0xFF
        assertEquals(album.length, albumLen)
        val extractedAlbum = String(frame, 68, albumLen, StandardCharsets.UTF_8)
        assertEquals(album, extractedAlbum)

        val extractedPos = ((frame[100].toInt() and 0xFF) shl 8) or (frame[101].toInt() and 0xFF)
        assertEquals(posSec, extractedPos)

        val extractedDur = ((frame[102].toInt() and 0xFF) shl 8) or (frame[103].toInt() and 0xFF)
        assertEquals(durSec, extractedDur)

        assertEquals(playbackState, frame[104].toInt() and 0xFF)
    }

    @Test
    fun testBuildMediaFrameUtf8MultiByteTruncation() {
        val multiByteTitle = "नमस्ते दुनिया नमस्ते दुनिया नमस्ते दुनिया"
        val frame = PulsarProtocol.buildMediaFrame(
            title = multiByteTitle,
            artist = null,
            album = null,
            positionSec = 0,
            durationSec = 0,
            playbackState = 1
        )

        val titleLen = frame[1].toInt() and 0xFF
        assertTrue("Truncated byte length must be <= 32", titleLen <= 32)
        val extracted = String(frame, 2, titleLen, StandardCharsets.UTF_8)
        assertFalse("Decoded string must not contain replacement characters", extracted.contains("�"))
    }

    @Test
    fun testHandlebarPacketParsingAndBaselineInitialization() {
        val initialPacket = ByteArray(20) { 0 }
        initialPacket[0] = 0x05 // Volume 5
        initialPacket[6] = 0x10 // Play ctr 16
        initialPacket[7] = 0x02 // Pause ctr 2
        initialPacket[8] = 0x07 // Next ctr 7
        initialPacket[9] = 0x01 // Prev ctr 1
        initialPacket[10] = 0x00 // Stop ctr 0

        val firstResult = PulsarProtocol.parseHandlebarPacket(initialPacket)
        assertNull("First packet primes baseline and must return null", firstResult)

        val duplicateResult = PulsarProtocol.parseHandlebarPacket(initialPacket)
        assertNull("Duplicate identical packet must return null", duplicateResult)

        val nextPacket = initialPacket.clone()
        nextPacket[8] = 0x08 // Next ctr incremented to 8
        val nextResult = PulsarProtocol.parseHandlebarPacket(nextPacket)
        assertNotNull(nextResult)
        assertTrue(nextResult!!.musicNext)
        assertFalse(nextResult.musicPrev)
        assertFalse(nextResult.musicPlay)
        assertFalse(nextResult.volumeChanged)
    }

    @Test
    fun testHandlebarVolumeChangeParsing() {
        val initialPacket = ByteArray(20) { 0 }
        initialPacket[0] = 0x04
        PulsarProtocol.parseHandlebarPacket(initialPacket)

        val volUpPacket = initialPacket.clone()
        volUpPacket[0] = 0x05
        val volResult = PulsarProtocol.parseHandlebarPacket(volUpPacket)
        assertNotNull(volResult)
        assertTrue(volResult!!.volumeChanged)
        assertEquals(5, volResult.volumeLevel)
    }

    @Test
    fun testAuthoritativeVolumeSyncAfterPulseRejection() {
        val baseline = ByteArray(20) { 0 }
        baseline[0] = 0x03
        PulsarProtocol.parseHandlebarPacket(baseline)

        // Cluster emits release pulse 0
        val pulsePacket = baseline.clone()
        pulsePacket[0] = 0x00
        val pulseResult = PulsarProtocol.parseHandlebarPacket(pulsePacket)
        assertNotNull(pulseResult)
        assertTrue(pulseResult!!.volumeChanged)
        assertEquals(0, pulseResult.volumeLevel)

        // MediaStateListener rejects the pulse and calls syncAuthoritativeVolume(3)
        PulsarProtocol.syncAuthoritativeVolume(3)

        // Rider later intentionally steps down to 0
        val realMutePacket = baseline.clone()
        realMutePacket[0] = 0x00
        val realMuteResult = PulsarProtocol.parseHandlebarPacket(realMutePacket)
        assertNotNull("Intentional mute to 0 must be parsed after authoritative resync", realMuteResult)
        assertTrue(realMuteResult!!.volumeChanged)
        assertEquals(0, realMuteResult.volumeLevel)
    }
}
