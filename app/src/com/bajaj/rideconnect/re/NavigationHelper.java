package com.bajaj.rideconnect.re;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Ported directly from authoritative Bajaj Ride Connect NavigationHelper.
 * Translates Mappls navigation directions & maneuvers into the exact 48-byte BLE TBT frames
 * accepted by Bajaj LCD/TFT motorcycle clusters (GATT characteristic 0110).
 */
public final class NavigationHelper {

    public static final Map<Integer, Maneuver> maneuverIDMap = new HashMap<>();
    public static final Map<Integer, Integer> roundAboutExitMap = new HashMap<>();

    static {
        // Normal vs Blinking (within 100m) ASCII cluster glyphs
        maneuverIDMap.put(0, new Maneuver(73, 105)); // Straight 'I' / 'i'
        maneuverIDMap.put(1, new Maneuver(69, 101)); // Slight Right 'E' / 'e'
        maneuverIDMap.put(2, new Maneuver(81, 113)); // Right 'Q' / 'q'
        maneuverIDMap.put(3, new Maneuver(74, 106)); // Sharp Right 'J' / 'j'
        maneuverIDMap.put(4, new Maneuver(70, 102)); // U-Turn Right 'F' / 'f'
        maneuverIDMap.put(5, new Maneuver(82, 114)); // U-Turn Left 'R' / 'r'
        maneuverIDMap.put(6, new Maneuver(79, 111)); // Keep Left 'O' / 'o'
        maneuverIDMap.put(7, new Maneuver(71, 103)); // Keep Right 'G' / 'g'
        maneuverIDMap.put(8, new Maneuver(71, 72));  // Destination 'G' / 'H'
        maneuverIDMap.put(11, new Maneuver(73, 105));
        maneuverIDMap.put(12, new Maneuver(74, 106));
        maneuverIDMap.put(13, new Maneuver(73, 105));
        maneuverIDMap.put(14, new Maneuver(74, 106));
        maneuverIDMap.put(15, new Maneuver(67, 99)); // 'C' / 'c'
        maneuverIDMap.put(16, new Maneuver(68, 100)); // 'D' / 'd'
        maneuverIDMap.put(17, new Maneuver(69, 101));
        maneuverIDMap.put(18, new Maneuver(70, 102));
        maneuverIDMap.put(19, new Maneuver(90, 122)); // 'Z' / 'z'
        maneuverIDMap.put(20, new Maneuver(88, 120)); // 'X' / 'x'
        maneuverIDMap.put(21, new Maneuver(71, 103));
        maneuverIDMap.put(22, new Maneuver(73, 105));
        maneuverIDMap.put(23, new Maneuver(73, 105));
        maneuverIDMap.put(24, new Maneuver(74, 106));
        maneuverIDMap.put(25, new Maneuver(74, 106));
        maneuverIDMap.put(36, new Maneuver(89, 121)); // 'Y' / 'y'
        maneuverIDMap.put(41, new Maneuver(80, 112)); // 'P' / 'p'
        for (int i = 50; i <= 57; i++) {
            maneuverIDMap.put(i, new Maneuver(71, 103));
        }
        for (int i = 58; i <= 64; i++) {
            maneuverIDMap.put(i, new Maneuver(78, 110)); // 'N' / 'n'
            roundAboutExitMap.put(i, i - 57);            // Exits 1 to 7
        }
        for (int i = 65; i <= 71; i++) {
            maneuverIDMap.put(i, new Maneuver(85, 117)); // 'U' / 'u'
            roundAboutExitMap.put(i, i - 64);            // Exits 1 to 7
        }
        maneuverIDMap.put(72, new Maneuver(66, 98));  // 'B' / 'b'
        maneuverIDMap.put(73, new Maneuver(75, 107)); // 'K' / 'k'
        maneuverIDMap.put(74, new Maneuver(75, 107));
        maneuverIDMap.put(75, new Maneuver(76, 108)); // 'L' / 'l'
    }

    private final int maneuverID;
    private final double distanceToNextAdvise; // meters
    private final double distanceLeft;         // meters
    private final double etaSeconds;
    private final String shortText;
    private final String fullText;

    public NavigationHelper(int maneuverID, double distanceToNextAdvise, double distanceLeft,
                            double etaSeconds, String shortText, String fullText) {
        this.maneuverID = maneuverID;
        this.distanceToNextAdvise = distanceToNextAdvise;
        this.distanceLeft = distanceLeft;
        this.etaSeconds = etaSeconds;
        this.shortText = shortText;
        this.fullText = fullText;
    }

    public static byte[] formatDistance(double d) {
        double d2;
        byte b;
        if (d < 1000.0d) {
            d2 = (int) d;
            b = 1; // Meters
        } else {
            d2 = d / 1000.0d;
            b = 0; // Kilometers
        }
        int i = (int) d2;
        short intPart = (short) i;
        short fracPart = (short) Math.round((d2 - (double) i) * 100.0d);

        byte[] bInt = toBytes(intPart);
        byte[] bFrac = toBytes(fracPart);
        return new byte[]{b, bInt[0], bInt[1], bFrac[0], bFrac[1]};
    }

    private static byte[] toBytes(short s) {
        return new byte[]{(byte) ((s >> 8) & 0xFF), (byte) (s & 0xFF)};
    }

    public static TimeInfo formatTime(int etaSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, etaSeconds);
        boolean isAm = calendar.get(Calendar.AM_PM) == Calendar.AM;
        int hour = calendar.get(Calendar.HOUR);
        if (hour == 0) hour = 12;
        int min = calendar.get(Calendar.MINUTE);
        return new TimeInfo(isAm, hour, min);
    }

    public byte[] buildNavigationPacket() {
        int glyphCode = 71; // Default 'G'
        if (maneuverIDMap.containsKey(maneuverID)) {
            Maneuver m = maneuverIDMap.get(maneuverID);
            if (maneuverID == 8) {
                glyphCode = (distanceToNextAdvise < 40) ? m.blinkingCode : m.normalCode;
            } else if (distanceToNextAdvise < 100) {
                glyphCode = m.blinkingCode;
            } else {
                glyphCode = m.normalCode;
            }
        }

        int roundaboutExit = roundAboutExitMap.getOrDefault(maneuverID, 0);
        byte[] stepDistBytes = formatDistance(distanceToNextAdvise);
        byte[] totalDistBytes = formatDistance(distanceLeft);
        TimeInfo time = formatTime((int) etaSeconds);

        byte[] packet = new byte[48];
        // Byte 0: Bit 0=1 (Active), Bit 4=Unit (1=m, 0=km), Bit 7=PM flag
        byte b0 = 1;
        b0 = (byte) (b0 | (stepDistBytes[0] << 4));
        b0 = (byte) (b0 | ((!time.isAm ? 1 : 0) << 7));
        packet[0] = b0;

        packet[1] = (byte) glyphCode;
        packet[2] = stepDistBytes[4]; // fracLsb
        packet[3] = stepDistBytes[3]; // fracMsb
        packet[4] = stepDistBytes[2]; // intLsb
        packet[5] = stepDistBytes[1]; // intMsb
        packet[6] = (byte) time.minute;
        packet[7] = (byte) (((roundaboutExit << 4) & 0xF0) | (time.hour & 0x0F));
        packet[8] = totalDistBytes[4];
        packet[9] = totalDistBytes[3];
        packet[10] = totalDistBytes[2];
        packet[11] = totalDistBytes[1];
        packet[12] = (byte) (totalDistBytes[0] | (1 << 2)); // GPS Lock = 1
        packet[13] = 0; // Take me home ack

        String street = getSanitizedStreet();
        byte[] streetBytes = street.getBytes(StandardCharsets.US_ASCII);
        int copyLen = Math.min(streetBytes.length, 31);
        packet[14] = (byte) copyLen;
        System.arraycopy(streetBytes, 0, packet, 15, copyLen);

        return computeChecksum(packet, 47);
    }

    public static byte[] buildNavigationEndPacket() {
        return new byte[48];
    }

    private String getSanitizedStreet() {
        String s = (shortText != null && !shortText.trim().isEmpty()) ? shortText : fullText;
        if (s == null) s = "";
        s = s.replaceAll("[^0-9a-zA-Z. ]", " ").trim();
        if (s.length() > 31) {
            s = s.substring(0, 30) + ".";
        }
        return s;
    }

    private static byte[] computeChecksum(byte[] data, int checksumIndex) {
        int sum = 0;
        for (int i = 0; i < checksumIndex; i++) {
            sum = (sum + (data[i] & 0xFF)) & 0xFF;
        }
        byte[] copy = Arrays.copyOf(data, data.length);
        copy[checksumIndex] = (byte) sum;
        return copy;
    }

    public static class Maneuver {
        public final int normalCode;
        public final int blinkingCode;

        public Maneuver(int normalCode, int blinkingCode) {
            this.normalCode = normalCode;
            this.blinkingCode = blinkingCode;
        }
    }

    public static class TimeInfo {
        public final boolean isAm;
        public final int hour;
        public final int minute;

        public TimeInfo(boolean isAm, int hour, int minute) {
            this.isAm = isAm;
            this.hour = hour;
            this.minute = minute;
        }
    }
}

