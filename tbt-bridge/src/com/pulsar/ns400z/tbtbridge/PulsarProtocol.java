package com.pulsar.ns400z.tbtbridge;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Binary Protocol Frame Builder and Parser for Bajaj Pulsar NS400Z Digital Cluster (OTC Engineering).
 */
public final class PulsarProtocol {

    public static final String SERVICE_UUID = "0010676e-6972-6565-6e69-676e4543544f";
    public static final String CHAR_TBT_UUID = "0110676e-6972-6565-6e69-676e4543544f";
    public static final String CHAR_TELEMETRY_UUID = "0210676e-6972-6565-6e69-676e4543544f";
    public static final String CHAR_MEDIA_UUID = "0610676e-6972-6565-6e69-676e4543544f";
    public static final String CHAR_CONTROLS_UUID = "0a10676e-6972-6565-6e69-676e4543544f";
    public static final String CCCD_DESCRIPTOR_UUID = "00002902-0000-1000-8000-00805f9b34fb";

    private PulsarProtocol() {}

    public enum Maneuver {
        STRAIGHT(71, "Continue Straight"),
        TURN_LEFT(73, "Turn Left"),
        TURN_RIGHT(74, "Turn Right"),
        SHARP_LEFT(69, "Sharp Left"),
        SHARP_RIGHT(70, "Sharp Right"),
        SLIGHT_LEFT(67, "Slight Left"),
        SLIGHT_RIGHT(68, "Slight Right"),
        U_TURN_LEFT(79, "U-Turn"),
        U_TURN_RIGHT(80, "U-Turn Right"),
        ROUNDABOUT_CW(78, "Roundabout"),
        ROUNDABOUT_CCW(85, "Roundabout Left"),
        KEEP_LEFT(90, "Keep Left"),
        KEEP_RIGHT(88, "Keep Right"),
        FORK_LEFT(81, "Fork Left"),
        FORK_RIGHT(82, "Fork Right"),
        RAMP_LEFT(75, "Ramp Left"),
        RAMP_RIGHT(76, "Ramp Right"),
        MERGE(86, "Merge"),
        DESTINATION(72, "Destination Reached"),
        WRONG_WAY(66, "Wrong Way");

        public final int code;
        public final String description;

        Maneuver(int code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    // =========================================================================
    // 1. Turn-by-Turn Navigation Frame (0110 - 48 Bytes)
    // =========================================================================
    public static byte[] buildTbtFrame(
            Maneuver maneuver,
            double stepDistanceMeters,
            double totalDistanceMeters,
            int etaHour12,
            int etaMinute,
            boolean isPm,
            String streetName,
            boolean gpsActive,
            int roundaboutExit
    ) {
        byte[] frame = new byte[48];
        int glyph = maneuver.code;

        // Imminent turn blinking trigger when closer than 100 meters
        if (stepDistanceMeters > 0 && stepDistanceMeters < 100 && glyph != 72 && glyph != 66) {
            glyph += 32;
        }

        byte[] stepDist = encodeDistance(stepDistanceMeters);
        byte[] totDist = encodeDistance(totalDistanceMeters);

        // Byte 0: Active=1 | StepDistUnit (1=m, 0=km) | isAM (bit7=1 for AM, 0 for PM)
        frame[0] = (byte) (1 | (stepDist[0] << 4) | ((!isPm ? 1 : 0) << 7));
        frame[1] = (byte) (glyph & 0xFF);
        // Distance bytes reversed to match original cluster firmware byte order
        frame[2] = stepDist[4];
        frame[3] = stepDist[3];
        frame[4] = stepDist[2];
        frame[5] = stepDist[1];

        // Byte 6-7: ETA Minute & Hour / Roundabout Exit
        frame[6] = (byte) (etaMinute & 0xFF);
        int h = (etaHour12 >= 1 && etaHour12 <= 12) ? etaHour12 : 12;
        frame[7] = (byte) ((h & 0x0F) | ((roundaboutExit & 0x0F) << 4));

        // Bytes 8-11: Total remaining distance (reversed byte order)
        frame[8] = totDist[4];
        frame[9] = totDist[3];
        frame[10] = totDist[2];
        frame[11] = totDist[1];

        // Byte 12: Total distance unit & GPS status
        int gpsVal = gpsActive ? 1 : 0;
        frame[12] = (byte) ((totDist[0] & 0x03) | ((gpsVal & 0x03) << 2));
        frame[13] = 0; // Take me home ACK

        // Bytes 14-46: Street Name (Sanitized dot-matrix ASCII, max 31 chars)
        if (streetName != null && !streetName.isEmpty()) {
            String clean = streetName.replaceAll("[^a-zA-Z0-9 .\\-]", "").trim();
            if (clean.length() > 31) clean = clean.substring(0, 31);
            frame[14] = (byte) clean.length();
            byte[] asciiBytes = clean.getBytes(StandardCharsets.US_ASCII);
            System.arraycopy(asciiBytes, 0, frame, 15, asciiBytes.length);
        }

        // Byte 47: 8-bit Additive Checksum
        int sum = 0;
        for (int i = 0; i < 47; i++) {
            sum = (sum + frame[i]) & 0xFF;
        }
        frame[47] = (byte) sum;
        return frame;
    }

    public static byte[] buildTbtClearFrame() {
        return new byte[48]; // All zeros clears the cluster navigation mode
    }

    private static byte[] encodeDistance(double meters) {
        byte[] result = new byte[5]; // [unit, decMSB, decLSB, intMSB, intLSB]
        if (meters < 1000) {
            // Unit: Meters (1)
            result[0] = 1;
            int wholeMeters = (int) Math.round(meters);
            result[3] = (byte) ((wholeMeters >> 8) & 0xFF);
            result[4] = (byte) (wholeMeters & 0xFF);
        } else {
            // Unit: Kilometers (0)
            result[0] = 0;
            double km = meters / 1000.0;
            int wholeKm = (int) km;
            int decimals = (int) Math.round((km - wholeKm) * 10.0);
            result[1] = (byte) ((decimals >> 8) & 0xFF);
            result[2] = (byte) (decimals & 0xFF);
            result[3] = (byte) ((wholeKm >> 8) & 0xFF);
            result[4] = (byte) (wholeKm & 0xFF);
        }
        return result;
    }

    // =========================================================================
    // 2. Phone Telemetry & Status Frame (0210 - 55 / 89 Bytes)
    // =========================================================================
    public static byte[] buildTelemetryFrame(
            int batteryPercent,
            int signalBars, // 0-4
            int callState,   // 0=Idle, 1=Ringing, 2=Offhook
            String callerNameOrNumber,
            int missedCalls,
            int unreadSms,
            byte seqCounter,
            String phoneModel
    ) {
        byte[] frame = new byte[89];

        // Byte 0: Audio volume / Headset
        frame[0] = (byte) (0x0F | 0xC0);

        // Byte 1: DND (bit 7), Battery Bars (bits 4-5), Call State (bits 0-3)
        int batteryBars = Math.min(3, Math.max(0, batteryPercent / 25));
        frame[1] = (byte) (((batteryBars & 0x03) << 4) | (callState & 0x0F));

        // Byte 2: Cellular Signal Bars (0-4)
        frame[2] = (byte) (Math.min(4, Math.max(0, signalBars)) & 0x07);
        frame[3] = 0; // Birthday month

        // ACKs
        frame[13] = (byte) (missedCalls & 0xFF);
        frame[15] = (byte) (unreadSms & 0xFF);

        // Caller Info (Bytes 18-51)
        if (callerNameOrNumber != null && !callerNameOrNumber.isEmpty()) {
            frame[18] = 1; // Caller Active
            String cleanCaller = callerNameOrNumber.replaceAll("[^a-zA-Z0-9 +.\\-]", "").trim();
            if (cleanCaller.length() > 31) cleanCaller = cleanCaller.substring(0, 31);
            frame[19] = (byte) cleanCaller.length();
            byte[] callerBytes = cleanCaller.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(callerBytes, 0, frame, 20, Math.min(callerBytes.length, 32));
        } else {
            frame[18] = 0; // No active caller
            frame[19] = 0;
        }

        // Byte 54: Sequence Heartbeat
        frame[54] = seqCounter;

        // Bytes 55-87: Phone Model Name
        if (phoneModel != null && !phoneModel.isEmpty()) {
            if (phoneModel.length() > 31) phoneModel = phoneModel.substring(0, 31);
            frame[55] = (byte) phoneModel.length();
            byte[] modelBytes = phoneModel.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(modelBytes, 0, frame, 56, Math.min(modelBytes.length, 32));
        }

        // Byte 88: Additive Checksum
        int sum = 0;
        for (int i = 0; i < 88; i++) {
            sum = (sum + frame[i]) & 0xFF;
        }
        frame[88] = (byte) sum;

        return frame;
    }

    // 55-Byte compact telemetry variant (supported by NS400Z cluster)
    public static byte[] buildCompactTelemetryFrame(
            int batteryPercent,
            int signalBars,
            int callState,
            String callerNameOrNumber,
            int missedCalls,
            int unreadSms,
            byte seqCounter
    ) {
        byte[] frame = new byte[55];
        frame[0] = (byte) (0x0F | 0xC0);
        int batteryBars = Math.min(3, Math.max(0, batteryPercent / 25));
        frame[1] = (byte) (((batteryBars & 0x03) << 4) | (callState & 0x0F));
        frame[2] = (byte) (Math.min(4, Math.max(0, signalBars)) & 0x07);
        frame[13] = (byte) (missedCalls & 0xFF);
        frame[15] = (byte) (unreadSms & 0xFF);

        if (callerNameOrNumber != null && !callerNameOrNumber.isEmpty()) {
            frame[18] = 1;
            String clean = callerNameOrNumber.replaceAll("[^a-zA-Z0-9 +.\\-]", "").trim();
            if (clean.length() > 31) clean = clean.substring(0, 31);
            frame[19] = (byte) clean.length();
            byte[] bytes = clean.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(bytes, 0, frame, 20, Math.min(bytes.length, 32));
        }

        frame[54] = seqCounter;
        return frame;
    }

    // =========================================================================
    // 3. Now Playing Media Frame (0610 - 105 Bytes)
    // =========================================================================
    public static byte[] buildMediaFrame(
            String title,
            String artist,
            String album,
            int positionSec,
            int durationSec,
            int playbackState // 0=Stopped, 1=Playing, 2=Paused
    ) {
        byte[] frame = new byte[105];
        frame[0] = 0x01; // Header

        // Title (Bytes 1-33)
        if (title != null && !title.isEmpty()) {
            if (title.length() > 31) title = title.substring(0, 31);
            frame[1] = (byte) title.length();
            byte[] titleBytes = title.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(titleBytes, 0, frame, 2, Math.min(titleBytes.length, 32));
        }

        // Album (Bytes 34-66) - Matches decompiled CallFrame.musicInfoFrame
        if (album != null && !album.isEmpty()) {
            if (album.length() > 31) album = album.substring(0, 31);
            frame[34] = (byte) album.length();
            byte[] albumBytes = album.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(albumBytes, 0, frame, 35, Math.min(albumBytes.length, 32));
        }

        // Artist (Bytes 67-99) - Matches decompiled CallFrame.musicInfoFrame
        if (artist != null && !artist.isEmpty()) {
            if (artist.length() > 31) artist = artist.substring(0, 31);
            frame[67] = (byte) artist.length();
            byte[] artistBytes = artist.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(artistBytes, 0, frame, 68, Math.min(artistBytes.length, 32));
        }

        // Position (Bytes 100-101 Big-Endian uint16)
        frame[100] = (byte) ((positionSec >> 8) & 0xFF);
        frame[101] = (byte) (positionSec & 0xFF);

        // Duration (Bytes 102-103 Big-Endian uint16)
        frame[102] = (byte) ((durationSec >> 8) & 0xFF);
        frame[103] = (byte) (durationSec & 0xFF);

        // Playback Status (Byte 104: 0=None/Stopped, 1=Paused, 2=Playing)
        frame[104] = (byte) (playbackState & 0xFF);

        return frame;
    }

    // =========================================================================
    // 4. Handlebar Controls Event Parser (0a10 - 20 Bytes)
    // =========================================================================
    public static class HandlebarEvent {
        public boolean musicPlay;
        public boolean musicPause;
        public boolean musicNext;
        public boolean musicPrev;
        public boolean musicStop;
        public boolean callAccept;
        public boolean callReject;
        public int volumeLevel;
    }

    private static int lastCallAcceptCtr = 0;
    private static int lastCallRejectCtr = 0;
    private static int lastMusicPlayCtr = 0;
    private static int lastMusicPauseCtr = 0;
    private static int lastMusicNextCtr = 0;
    private static int lastMusicPrevCtr = 0;
    private static int lastMusicStopCtr = 0;

    public static HandlebarEvent parseHandlebarPacket(byte[] data) {
        if (data == null || data.length < 11) return null;

        HandlebarEvent ev = new HandlebarEvent();
        ev.volumeLevel = data[0] & 0x0F;

        int callAccept = data[1] & 0xFF;
        int callReject = data[2] & 0xFF;
        int musicPlay = data[6] & 0xFF;
        int musicPause = data[7] & 0xFF;
        int musicNext = data[8] & 0xFF;
        int musicPrev = data[9] & 0xFF;
        int musicStop = data[10] & 0xFF;

        if (callAccept != lastCallAcceptCtr) {
            ev.callAccept = true;
            lastCallAcceptCtr = callAccept;
        }
        if (callReject != lastCallRejectCtr) {
            ev.callReject = true;
            lastCallRejectCtr = callReject;
        }
        if (musicPlay != lastMusicPlayCtr) {
            ev.musicPlay = true;
            lastMusicPlayCtr = musicPlay;
        }
        if (musicPause != lastMusicPauseCtr) {
            ev.musicPause = true;
            lastMusicPauseCtr = musicPause;
        }
        if (musicNext != lastMusicNextCtr) {
            ev.musicNext = true;
            lastMusicNextCtr = musicNext;
        }
        if (musicPrev != lastMusicPrevCtr) {
            ev.musicPrev = true;
            lastMusicPrevCtr = musicPrev;
        }
        if (musicStop != lastMusicStopCtr) {
            ev.musicStop = true;
            lastMusicStopCtr = musicStop;
        }

        return ev;
    }
}
