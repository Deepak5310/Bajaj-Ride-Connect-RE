package com.bajajconnect.utils;

import com.bajajconnect.variables.GlobalVar;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.material.timepicker.TimeModel;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import com.mappls.sdk.navigation.model.AdviseInfo;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationHelper {
    public static final Map<Integer, Maneuver> maneuverIDMap;
    public static final Map<Integer, RoundaboutExit> roundAboutExitMap;
    private final double distanceLeft;
    private final int distanceToNextAdvise;
    private final double eatSeconds;
    private final String eta;
    private final String fullText;
    private final int maneuverID;
    private final String nextInstructionText;
    private final String shortText;
    String TAG = "NavigationHelper";
    private final String type = "update";

    static {
        HashMap map = new HashMap();
        maneuverIDMap = map;
        HashMap map2 = new HashMap();
        roundAboutExitMap = map2;
        map.put(0, new Maneuver(73, 105));
        map.put(1, new Maneuver(69, 101));
        map.put(2, new Maneuver(81, 113));
        map.put(3, new Maneuver(74, RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN));
        map.put(4, new Maneuver(70, 102));
        map.put(5, new Maneuver(82, 114));
        map.put(6, new Maneuver(79, PanasonicMakernoteDirectory.TAG_LANDMARK));
        map.put(7, new Maneuver(71, 103));
        map.put(8, new Maneuver(71, 72));
        map.put(11, new Maneuver(73, 105));
        map.put(12, new Maneuver(74, RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN));
        map.put(13, new Maneuver(73, 105));
        map.put(14, new Maneuver(74, RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN));
        map.put(15, new Maneuver(67, 99));
        map.put(16, new Maneuver(68, 100));
        map.put(17, new Maneuver(69, 101));
        map.put(18, new Maneuver(70, 102));
        map.put(19, new Maneuver(90, 122));
        map.put(20, new Maneuver(88, 120));
        map.put(21, new Maneuver(71, 103));
        map.put(22, new Maneuver(73, 105));
        map.put(23, new Maneuver(73, 105));
        map.put(24, new Maneuver(74, RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN));
        map.put(25, new Maneuver(74, RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN));
        map.put(36, new Maneuver(89, PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE));
        map.put(41, new Maneuver(80, PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION));
        map.put(50, new Maneuver(71, 103));
        map.put(51, new Maneuver(71, 103));
        map.put(52, new Maneuver(71, 103));
        map.put(53, new Maneuver(71, 103));
        map.put(54, new Maneuver(71, 103));
        map.put(55, new Maneuver(71, 103));
        map.put(56, new Maneuver(71, 103));
        map.put(57, new Maneuver(71, 103));
        map.put(58, new Maneuver(78, 110));
        map.put(59, new Maneuver(78, 110));
        map.put(60, new Maneuver(78, 110));
        map.put(61, new Maneuver(78, 110));
        map.put(62, new Maneuver(78, 110));
        map.put(63, new Maneuver(78, 110));
        map.put(64, new Maneuver(78, 110));
        map.put(65, new Maneuver(85, 117));
        map.put(66, new Maneuver(85, 117));
        map.put(67, new Maneuver(85, 117));
        map.put(68, new Maneuver(85, 117));
        map.put(69, new Maneuver(85, 117));
        map.put(70, new Maneuver(85, 117));
        map.put(71, new Maneuver(85, 117));
        map.put(72, new Maneuver(66, 98));
        map.put(73, new Maneuver(75, 107));
        map.put(74, new Maneuver(75, 107));
        map.put(75, new Maneuver(76, 108));
        map2.put(65, new RoundaboutExit(1));
        map2.put(66, new RoundaboutExit(2));
        map2.put(67, new RoundaboutExit(3));
        map2.put(68, new RoundaboutExit(4));
        map2.put(69, new RoundaboutExit(5));
        map2.put(70, new RoundaboutExit(6));
        map2.put(71, new RoundaboutExit(7));
        map2.put(58, new RoundaboutExit(1));
        map2.put(59, new RoundaboutExit(2));
        map2.put(60, new RoundaboutExit(3));
        map2.put(61, new RoundaboutExit(4));
        map2.put(62, new RoundaboutExit(5));
        map2.put(63, new RoundaboutExit(6));
        map2.put(64, new RoundaboutExit(7));
    }

    public NavigationHelper(AdviseInfo adviseInfo) {
        this.fullText = adviseInfo.getText();
        this.shortText = adviseInfo.getShortText();
        this.nextInstructionText = adviseInfo.getNextInstructionText();
        this.distanceToNextAdvise = adviseInfo.getDistanceToNextAdvise();
        this.eta = adviseInfo.getEta();
        this.eatSeconds = adviseInfo.getLeftTime();
        this.distanceLeft = adviseInfo.getLeftDistance();
        this.maneuverID = (int) adviseInfo.getManeuverID();
    }

    private static String stripSpecialCharacters(String str) {
        return str.replaceAll("[^0-9a-zA-Z.]", StringUtils.SPACE);
    }

    private static DistanceInfo formatDistance(String str) {
        float f = Float.parseFloat(str);
        boolean z = f < 999.0f;
        int i = (int) f;
        String strDecimalToHex = decimalToHex(i);
        String strDecimalToHex2 = decimalToHex((int) ((f - i) * 10000.0f));
        String hex = formatHex(strDecimalToHex);
        String hex2 = formatHex(strDecimalToHex2);
        return new DistanceInfo(z, hex2.substring(0, 2), hex2.substring(2, 4), hex.substring(0, 2), hex.substring(2, 4));
    }

    private static String decimalToHex(int i) {
        return String.format("%04x", Integer.valueOf(i));
    }

    private static int hexToDecimal(String str) {
        return Integer.parseInt(str, 16);
    }

    private static String formatHex(String str) {
        return str.length() <= 4 ? String.format("%4s", str).replace(' ', '0') : str.substring(str.length() - 4);
    }

    private static TimeInfo formatTime(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, i);
        boolean z = calendar.get(9) == 0;
        int i2 = calendar.get(10);
        if (i2 == 0) {
            i2 = 12;
        }
        return new TimeInfo(z, String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(calendar.get(12))), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2)));
    }

    public static byte[] formatDistance(double d) {
        double d2;
        byte b;
        if (d < 1000.0d) {
            d2 = (int) d;
            b = 1;
        } else {
            d2 = d / 1000.0d;
            b = 0;
        }
        int i = (int) d2;
        byte[] bytes = Util.toBytes((short) i);
        byte[] bytes2 = Util.toBytes((short) ((d2 - ((double) i)) * 100.0d));
        return new byte[]{b, bytes[0], bytes[1], bytes2[0], bytes2[1]};
    }

    public byte[] sendNavigationData() {
        Map<Integer, Maneuver> map = maneuverIDMap;
        int hexValueInDecimal = map.get(7).getHexValueInDecimal();
        byte[] distance = formatDistance(this.distanceToNextAdvise);
        byte[] distance2 = formatDistance(this.distanceLeft);
        TimeInfo time = formatTime((int) this.eatSeconds);
        if (map.containsKey(Integer.valueOf(this.maneuverID))) {
            int i = this.maneuverID;
            if (i == 8) {
                if (this.distanceToNextAdvise < 40) {
                    hexValueInDecimal = map.get(Integer.valueOf(i)).getHexValueInDecimalBlinking();
                } else {
                    hexValueInDecimal = map.get(Integer.valueOf(i)).getHexValueInDecimal();
                }
            } else if (this.distanceToNextAdvise < 100) {
                hexValueInDecimal = map.get(Integer.valueOf(i)).getHexValueInDecimalBlinking();
            } else {
                hexValueInDecimal = map.get(Integer.valueOf(i)).getHexValueInDecimal();
            }
        }
        Map<Integer, RoundaboutExit> map2 = roundAboutExitMap;
        int i2 = map2.containsKey(Integer.valueOf(this.maneuverID)) ? map2.get(Integer.valueOf(this.maneuverID)).id : 0;
        byte[] bArr = new byte[48];
        bArr[0] = 1;
        byte b = (byte) (((byte) (distance[0] << 4)) | 1);
        bArr[0] = b;
        bArr[0] = (byte) (b | ((byte) ((!time.isAm ? 1 : 0) << 7)));
        bArr[1] = (byte) hexValueInDecimal;
        bArr[2] = distance[4];
        bArr[3] = distance[3];
        bArr[4] = distance[2];
        bArr[5] = distance[1];
        bArr[6] = Byte.parseByte(time.minutesValue);
        byte b2 = Byte.parseByte(time.hourValue);
        bArr[7] = b2;
        bArr[7] = (byte) (((byte) (i2 << 4)) | b2);
        bArr[8] = distance2[4];
        bArr[9] = distance2[3];
        bArr[10] = distance2[2];
        bArr[11] = distance2[1];
        byte b3 = distance2[0];
        bArr[12] = b3;
        bArr[12] = (byte) (b3 | ((byte) (GlobalVar.gpsStatus.getValue() << 2)));
        bArr[13] = (byte) GlobalVar.takeMeHomeAck;
        String strTrim = stripSpecialCharacters(streetForCluster()).trim();
        if (strTrim.length() > 31) {
            strTrim = strTrim.substring(0, 31) + ".";
        }
        bArr[14] = (byte) strTrim.length();
        System.arraycopy(strTrim.getBytes(), 0, bArr, 15, strTrim.length());
        return checkSumMaker(bArr, 47);
    }

    public byte[] sendNavigationEndData() {
        return new byte[48];
    }

    private String streetForCluster() {
        String str = this.shortText;
        if (str != null && !str.trim().isEmpty()) {
            return this.shortText;
        }
        String str2 = this.fullText;
        if (str2 != null && !str2.trim().isEmpty()) {
            return this.fullText;
        }
        String str3 = this.nextInstructionText;
        return str3 != null ? str3 : "";
    }

    private byte[] checkSumMaker(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 + bArr[i3]) & 255;
        }
        int i4 = i + 1;
        if (i4 == bArr.length) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            bArrCopyOf[i] = (byte) i2;
            return bArrCopyOf;
        }
        if (i4 < bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr2[i] = (byte) i2;
            System.arraycopy(bArr, i4, bArr2, i4, (bArr.length - i) - 1);
            return bArr2;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public static class Maneuver {
        private final int hexValueInDecimal;
        private final int hexValueInDecimalBlinking;

        public Maneuver(int i, int i2) {
            this.hexValueInDecimal = i;
            this.hexValueInDecimalBlinking = i2;
        }

        public int getHexValueInDecimal() {
            return this.hexValueInDecimal;
        }

        public int getHexValueInDecimalBlinking() {
            return this.hexValueInDecimalBlinking;
        }
    }

    public static class RoundaboutExit {
        public final int id;

        public RoundaboutExit(int i) {
            this.id = i;
        }
    }

    public static class DistanceInfo {
        public final String byte1Lsb;
        public final String byte1Msb;
        public final String byte2Lsb;
        public final String byte2Msb;
        public final boolean isMeter;

        public DistanceInfo(boolean z, String str, String str2, String str3, String str4) {
            this.isMeter = z;
            this.byte1Lsb = str;
            this.byte2Lsb = str2;
            this.byte1Msb = str3;
            this.byte2Msb = str4;
        }
    }

    public static class TimeInfo {
        public final String hourValue;
        public final boolean isAm;
        public final String minutesValue;

        public TimeInfo(boolean z, String str, String str2) {
            this.isAm = z;
            this.minutesValue = str;
            this.hourValue = str2;
        }
    }
}
