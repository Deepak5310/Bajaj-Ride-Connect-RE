package com.bajaj.rideconnect.re;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Binary Protocol Frame Builder and Parser for Bajaj Pulsar NS400Z Digital Cluster (OTC Engineering).
 */
public final class PulsarProtocol {

    public static final String SERVICE_UUID = "0010676e-6972-6565-6e69-676e4543544f";
    public static final String CHAR_TELEMETRY_UUID = "0210676e-6972-6565-6e69-676e4543544f";
    public static final String CHAR_MEDIA_UUID = "0610676e-6972-6565-6e69-676e4543544f";
    public static final String CHAR_CONTROLS_UUID = "0a10676e-6972-6565-6e69-676e4543544f";
    public static final String CCCD_DESCRIPTOR_UUID = "00002902-0000-1000-8000-00805f9b34fb";

    private PulsarProtocol() {}

    // =========================================================================
    // 2. Phone Telemetry & Status Frame (0210 - 55 / 89 Bytes)
    // =========================================================================
    public static int getBatteryLevel(int percent) {
        if (percent < 20) return 0;
        if (percent < 40) return 1;
        if (percent < 60) return 2;
        if (percent < 80) return 3;
        return 4;
    }

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

        // Byte 0: Audio volume / Headset (0xC0 | volume)
        frame[0] = (byte) (0x05 | 0xC0);

        // Byte 1: (callState & 0x07) | (batteryLevel << 3)
        int batteryLevel = getBatteryLevel(batteryPercent);
        frame[1] = (byte) ((callState & 0x07) | ((batteryLevel & 0x07) << 3));

        // Byte 2: Cellular Signal Bars (0-4)
        frame[2] = (byte) (Math.min(4, Math.max(0, signalBars)) & 0x07);
        frame[3] = (byte) (callState == 3 ? 1 : 0);
        frame[4] = (byte) (callState == 3 ? 0 : 1);

        // ACKs
        frame[13] = (byte) (missedCalls & 0xFF);
        frame[15] = (byte) (unreadSms & 0xFF);

        // Caller Info (Bytes 18-51)
        if ((callState == 1 || callState == 2 || callState == 3) && callerNameOrNumber != null && !callerNameOrNumber.isEmpty()) {
            String cleanCaller = callerNameOrNumber.replaceAll("[^a-zA-Z0-9 +.\\-]", "").trim();
            if (!cleanCaller.isEmpty()) {
                frame[18] = 1; // Caller Active
                if (cleanCaller.length() > 30) cleanCaller = cleanCaller.substring(0, 30);
                byte[] callerBytes = cleanCaller.getBytes(StandardCharsets.UTF_8);
                int len = Math.min(callerBytes.length, 30);
                frame[20] = (byte) len;
                System.arraycopy(callerBytes, 0, frame, 21, len);
            } else {
                frame[18] = 0;
                frame[20] = 0;
            }
        } else {
            frame[18] = 0; // No active caller
            frame[20] = 0;
        }

        // Byte 53: Sequence Heartbeat
        frame[53] = seqCounter;
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
            byte seqCounter,
            int volumeLevel,
            boolean isHeadset
    ) {
        byte[] frame = new byte[55];
        // Byte 0: ((isHeadset ? 1 : 0) << 4) | (volumeLevel & 0x0F) | 0xC0
        frame[0] = (byte) (((isHeadset ? 1 : 0) << 4) | (Math.max(0, Math.min(volumeLevel, 10)) & 0x0F) | 0xC0);

        // Byte 1: (callState & 0x07) | (batteryLevel << 3)
        int batteryLevel = getBatteryLevel(batteryPercent);
        frame[1] = (byte) ((callState & 0x07) | ((batteryLevel & 0x07) << 3));

        // Byte 2: Cellular Signal Bars (0-4)
        frame[2] = (byte) (Math.min(4, Math.max(0, signalBars)) & 0x07);

        // Bytes 3-4: Active Call flags
        frame[3] = (byte) (callState == 3 ? 1 : 0);
        frame[4] = (byte) (callState == 3 ? 0 : 1);

        frame[13] = (byte) (missedCalls & 0xFF);
        frame[15] = (byte) (unreadSms & 0xFF);

        // Caller Info (Bytes 18-51)
        if ((callState == 1 || callState == 2 || callState == 3) && callerNameOrNumber != null && !callerNameOrNumber.isEmpty()) {
            String clean = callerNameOrNumber.replaceAll("[^a-zA-Z0-9 +.\\-]", "").trim();
            if (!clean.isEmpty()) {
                frame[18] = 1;
                if (clean.length() > 30) clean = clean.substring(0, 30);
                byte[] bytes = clean.getBytes(StandardCharsets.UTF_8);
                int len = Math.min(bytes.length, 30);
                frame[20] = (byte) len;
                System.arraycopy(bytes, 0, frame, 21, len);
            } else {
                frame[18] = 0;
                frame[20] = 0;
            }
        } else {
            frame[18] = 0;
            frame[20] = 0;
        }

        frame[53] = seqCounter;
        frame[54] = seqCounter;
        return frame;
    }

    public static byte[] buildCompactTelemetryFrame(
            int batteryPercent,
            int signalBars,
            int callState,
            String callerNameOrNumber,
            int missedCalls,
            int unreadSms,
            byte seqCounter
    ) {
        return buildCompactTelemetryFrame(batteryPercent, signalBars, callState, callerNameOrNumber,
                missedCalls, unreadSms, seqCounter, 5, false);
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
            int playbackState // 0=None/Stopped, 1=Paused, 2=Playing
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

        // Artist (Bytes 34-66) — swapped with Album to match reference layout
        if (artist != null && !artist.isEmpty()) {
            if (artist.length() > 31) artist = artist.substring(0, 31);
            frame[34] = (byte) artist.length();
            byte[] artistBytes = artist.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(artistBytes, 0, frame, 35, Math.min(artistBytes.length, 32));
        }

        // Album (Bytes 67-99) — swapped with Artist to match reference layout
        if (album != null && !album.isEmpty()) {
            if (album.length() > 31) album = album.substring(0, 31);
            frame[67] = (byte) album.length();
            byte[] albumBytes = album.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(albumBytes, 0, frame, 68, Math.min(albumBytes.length, 32));
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
        public boolean volumeChanged;
        public int volumeLevel;

        public boolean hasAction() {
            return musicPlay || musicPause || musicNext || musicPrev || musicStop || callAccept || callReject || volumeChanged;
        }

        @Override
        public String toString() {
            return "HandlebarEvent[play=" + musicPlay + ", pause=" + musicPause + ", next=" + musicNext +
                    ", prev=" + musicPrev + ", stop=" + musicStop + ", accept=" + callAccept +
                    ", reject=" + callReject + ", vol=" + volumeLevel + ", volChanged=" + volumeChanged + "]";
        }
    }

    private static int lastCallAcceptCtr = 0;
    private static int lastCallRejectCtr = 0;
    private static int lastMusicPlayCtr = 0;
    private static int lastMusicPauseCtr = 0;
    private static int lastMusicNextCtr = 0;
    private static int lastMusicPrevCtr = 0;
    private static int lastMusicStopCtr = 0;
    private static int lastVolumeNibble = -1;
    private static boolean handlebarInitialized = false;

    public static synchronized void resetHandlebarCounters() {
        handlebarInitialized = false;
        lastVolumeNibble = -1;
    }

    public static synchronized HandlebarEvent parseHandlebarPacket(byte[] data) {
        if (data == null || data.length < 11) return null;

        int callAccept = data[1] & 0xFF;
        int callReject = data[2] & 0xFF;
        int musicPlay = data[6] & 0xFF;
        int musicPause = data[7] & 0xFF;
        int musicNext = data[8] & 0xFF;
        int musicPrev = data[9] & 0xFF;
        int musicStop = data[10] & 0xFF;
        int volNibble = data[0] & 0x0F;

        // On first packet after connection, seed previous counters to avoid phantom clicks
        if (!handlebarInitialized) {
            lastCallAcceptCtr = callAccept;
            lastCallRejectCtr = callReject;
            lastMusicPlayCtr = musicPlay;
            lastMusicPauseCtr = musicPause;
            lastMusicNextCtr = musicNext;
            lastMusicPrevCtr = musicPrev;
            lastMusicStopCtr = musicStop;
            lastVolumeNibble = volNibble;
            handlebarInitialized = true;
            return null;
        }

        HandlebarEvent ev = new HandlebarEvent();
        ev.volumeLevel = volNibble;

        if (volNibble != lastVolumeNibble) {
            ev.volumeChanged = true;
            lastVolumeNibble = volNibble;
        }
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

    // =========================================================================
    // 5. Shared Display & Utility Helpers
    // =========================================================================
    public static String formatDistance(double meters) {
        if (meters <= 0.0) return "--";
        if (meters >= 1000.0) {
            return String.format("%.1f km", meters / 1000.0);
        }
        return String.format("%.0f m", meters);
    }

    public static String formatEta(int hour, int min, boolean isPm) {
        int h = (hour >= 1 && hour <= 12) ? hour : 12;
        return String.format("%02d:%02d %s", h, min, isPm ? "PM" : "AM");
    }

    public static String getGlyphIcon(String maneuverName) {
        if (maneuverName == null) return "↑";
        switch (maneuverName) {
            case "TURN_LEFT":
            case "SHARP_LEFT": return "↰";
            case "TURN_RIGHT":
            case "SHARP_RIGHT": return "↱";
            case "SLIGHT_LEFT":
            case "KEEP_LEFT": return "↖";
            case "SLIGHT_RIGHT":
            case "KEEP_RIGHT": return "↗";
            case "U_TURN_LEFT":
            case "U_TURN_RIGHT": return "↺";
            case "ROUNDABOUT_CW":
            case "ROUNDABOUT_CCW": return "⮡";
            case "RAMP_LEFT": return "↸";
            case "RAMP_RIGHT": return "↹";
            case "MERGE": return "⇶";
            case "DESTINATION": return "🏁";
            default: return "↑";
        }
    }

    public static String getGlyphSymbol(String maneuverName) {
        return getGlyphIcon(maneuverName);
    }

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) return "";
        StringBuilder sb = new StringBuilder(bytes.length * 3);
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
