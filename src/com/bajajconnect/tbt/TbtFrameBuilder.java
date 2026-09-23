package com.bajajconnect.tbt;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * High-performance, lightweight TBT Frame Builder for Bajaj Pulsar NS400Z BLE GATT (0110).
 * Constructs the exact 48-byte bytearray expected by the motorcycle's LCD dot-matrix cluster.
 */
public class TbtFrameBuilder {

    public static final String GATT_SERVICE_UUID = "0010676e-6972-6565-6e69-676e4543544f";
    public static final String TBT_CHAR_UUID    = "0110676e-6972-6565-6e69-676e4543544f";

    public enum Maneuver {
        STRAIGHT(71),
        TURN_LEFT(73),
        TURN_RIGHT(74),
        SLIGHT_LEFT(67),
        SLIGHT_RIGHT(68),
        SHARP_LEFT(69),
        SHARP_RIGHT(70),
        U_TURN_LEFT(79),
        U_TURN_RIGHT(80),
        KEEP_LEFT(90),
        KEEP_RIGHT(88),
        ROUNDABOUT_CW(78),
        ROUNDABOUT_CCW(85),
        MERGE(86),
        DESTINATION(72),
        WRONG_WAY(66);

        public final int code;
        Maneuver(int code) {
            this.code = code;
        }
    }

    public static byte[] buildFrame(
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
        // Blinking indicator if within 100m of turn
        if (stepDistanceMeters > 0 && stepDistanceMeters < 100 && glyph != 72 && glyph != 66) {
            glyph += 32;
        }

        byte[] stepDist = encodeDistance(stepDistanceMeters);
        byte[] totDist = encodeDistance(totalDistanceMeters);

        // Byte 0: Active | (StepUnit << 4) | (isPM << 7)
        frame[0] = (byte) (1 | (stepDist[0] << 4) | ((isPm ? 1 : 0) << 7));

        // Byte 1: Glyph code
        frame[1] = (byte) glyph;

        // Bytes 2-5: Step Distance (4 bytes)
        System.arraycopy(stepDist, 1, frame, 2, 4);

        // Byte 6: ETA Minute
        frame[6] = (byte) (etaMinute & 0xFF);

        // Byte 7: ETA Hour | (RoundaboutExit << 4)
        int h = (etaHour12 >= 1 && etaHour12 <= 12) ? etaHour12 : 12;
        frame[7] = (byte) ((h & 0x0F) | ((roundaboutExit & 0x0F) << 4));

        // Bytes 8-11: Total Remaining Distance (4 bytes)
        System.arraycopy(totDist, 1, frame, 8, 4);

        // Byte 12: Total Distance Unit | (GpsStatus << 2)
        int gpsVal = gpsActive ? 1 : 0;
        frame[12] = (byte) ((totDist[0] & 0x03) | ((gpsVal & 0x03) << 2));

        // Byte 13: TakeMeHome ACK
        frame[13] = 0;

        // Bytes 14-46: Street Name
        if (streetName != null && !streetName.isEmpty()) {
            String clean = streetName.replaceAll("[^a-zA-Z0-9 .\\-]", "").trim();
            if (clean.length() > 31) {
                clean = clean.substring(0, 31);
            }
            frame[14] = (byte) clean.length();
            byte[] asciiBytes = clean.getBytes();
            System.arraycopy(asciiBytes, 0, frame, 15, asciiBytes.length);
        }

        // Byte 47: 8-bit Checksum
        int sum = 0;
        for (int i = 0; i < 47; i++) {
            sum = (sum + frame[i]) & 0xFF;
        }
        frame[47] = (byte) sum;

        return frame;
    }

    private static byte[] encodeDistance(double distanceMeters) {
        byte unit;
        int intPart;
        int decPart;

        if (distanceMeters < 1000.0) {
            unit = 1; // Meters
            intPart = (int) distanceMeters;
            decPart = 0;
        } else {
            unit = 0; // Kilometers
            double km = distanceMeters / 1000.0;
            intPart = (int) km;
            decPart = (int) ((km - intPart) * 100.0);
        }

        ByteBuffer bufInt = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort((short) intPart);
        ByteBuffer bufDec = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort((short) decPart);

        byte[] bInt = bufInt.array();
        byte[] bDec = bufDec.array();

        // Returns: [unit_flag, dec_msb, dec_lsb, int_msb, int_lsb]
        return new byte[]{unit, bDec[1], bDec[0], bInt[1], bInt[0]};
    }
}
