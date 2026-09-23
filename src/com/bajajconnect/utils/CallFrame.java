package com.bajajconnect.utils;

import com.bajajconnect.enums.Alert;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.enums.music.PlayStatus;
import com.bajajconnect.variables.GlobalVar;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class CallFrame {
    private static final int CALLER_NAME_MAX = 30;
    private static final int CALLER_NAME_OFFSET = 21;
    private static final String HEXES = "0123456789ABCDEF";
    private static int heartbeat;
    private static int stickyCallerOverwriteLen;

    public static byte[] phoneStatusNew() {
        heartbeat++;
        byte[] bArr = new byte[55];
        bArr[0] = (byte) getStatusByteZero();
        bArr[1] = (byte) getStatusByteOne();
        bArr[2] = (byte) ((GlobalVar.signalStrength < 0 || GlobalVar.signalStrength > 7) ? 0 : GlobalVar.signalStrength & 7);
        bArr[3] = (byte) (GlobalVar.callState == CallState.ACTIVE_CALL ? 1 : 0);
        bArr[4] = (byte) (GlobalVar.callState == CallState.ACTIVE_CALL ? 0 : 1);
        bArr[5] = (byte) GlobalVar.callRejectAck;
        bArr[6] = (byte) GlobalVar.callRejectWithSmsAck;
        bArr[7] = (byte) GlobalVar.resumeSongAck;
        bArr[8] = (byte) GlobalVar.pauseSongAck;
        bArr[9] = (byte) GlobalVar.skipToNextAck;
        bArr[10] = (byte) GlobalVar.skipToPrevAck;
        bArr[11] = (byte) GlobalVar.stopSongAck;
        bArr[12] = (byte) GlobalVar.launchMediaPlayerAck;
        bArr[13] = (byte) GlobalVar.missedCallCount;
        bArr[14] = (byte) GlobalVar.missedCallGetAck;
        bArr[15] = (byte) GlobalVar.smsCount;
        bArr[16] = (byte) GlobalVar.alertsGetAck;
        bArr[17] = 0;
        if (GlobalVar.callState == CallState.ACTIVE_CALL || GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.OUTGOING_CALL) {
            String str = GlobalVar.callerName;
            if (str == null || str.trim().isEmpty()) {
                str = GlobalVar.callerNumber != null ? GlobalVar.callerNumber : "";
            }
            String strReplaceAll = str.replaceAll("[\\p{So}\\p{Cn}^]", "");
            if (strReplaceAll.trim().isEmpty()) {
                bArr[18] = 0;
                Arrays.fill(bArr, 21, 51, (byte) 0);
                bArr[20] = 0;
            } else {
                bArr[18] = 1;
                byte[] bytes = strReplaceAll.getBytes(StandardCharsets.UTF_8);
                int iMin = Math.min(bytes.length, 30);
                Arrays.fill(bArr, 21, 51, (byte) 0);
                System.arraycopy(bytes, 0, bArr, 21, iMin);
                int iMax = Math.max(iMin, stickyCallerOverwriteLen);
                bArr[20] = (byte) (iMax <= 30 ? iMax : 30);
                stickyCallerOverwriteLen = iMin;
            }
        } else {
            GlobalVar.callProgressCount = 0;
            bArr[18] = 0;
        }
        bArr[53] = (byte) heartbeat;
        return bArr;
    }

    public static byte[] musicInfoFrame(String str, String str2, String str3, int i, int i2, PlayStatus playStatus) {
        int value;
        byte[] bArr = new byte[PanasonicMakernoteDirectory.TAG_LANDMARK];
        bArr[0] = 1;
        if (str != null) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            bArr[1] = (byte) Math.min(bytes.length, 32);
            System.arraycopy(bytes, 0, bArr, 2, Math.min(bytes.length, 32));
        }
        if (str2 != null) {
            byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
            bArr[34] = (byte) Math.min(bytes2.length, 32);
            System.arraycopy(bytes2, 0, bArr, 35, Math.min(bytes2.length, 32));
        }
        if (str3 != null) {
            byte[] bytes3 = str3.getBytes(StandardCharsets.UTF_8);
            bArr[67] = (byte) Math.min(bytes3.length, 32);
            System.arraycopy(bytes3, 0, bArr, 68, Math.min(bytes3.length, 32));
        }
        byte[] bytes4 = Util.toBytes((short) i);
        bArr[100] = bytes4[0];
        bArr[101] = bytes4[1];
        byte[] bytes5 = Util.toBytes((short) i2);
        bArr[102] = bytes5[0];
        bArr[103] = bytes5[1];
        if (playStatus != null) {
            value = playStatus.getValue();
        } else {
            value = GlobalVar.playStatus.getValue();
        }
        bArr[104] = (byte) value;
        return bArr;
    }

    public static byte[] tbtInfo(int i, int i2, int i3, int i4, short s, byte b, byte b2, short s2, int i5, int i6, String str) {
        byte[] bArr = new byte[49];
        bArr[0] = (byte) (i | (i4 << 4) | (i3 << 7));
        bArr[1] = (byte) i2;
        byte[] bytes = Util.toBytes(s);
        bArr[2] = bytes[0];
        bArr[3] = bytes[1];
        bArr[4] = b;
        bArr[5] = b2;
        bArr[5] = (byte) ((i6 << 4) | b2);
        byte[] bArrShortToBytes = Util.shortToBytes(s2);
        bArr[6] = bArrShortToBytes[0];
        bArr[7] = bArrShortToBytes[1];
        byte b3 = (byte) i5;
        bArr[8] = b3;
        bArr[8] = (byte) (b3 | (GlobalVar.gpsStatus.getValue() << 2));
        bArr[9] = (byte) GlobalVar.takeMeHomeAck;
        byte[] bytes2 = str.getBytes(StandardCharsets.US_ASCII);
        if (str.length() > 32) {
            bytes2 = (str.substring(0, 29) + "..").getBytes(StandardCharsets.US_ASCII);
        }
        bArr[10] = (byte) Math.min(bytes2.length, 31);
        System.arraycopy(bytes2, 0, bArr, 11, Math.min(bytes2.length, 31));
        return bArr;
    }

    private static int getStatusByteZero() {
        boolean z = GlobalVar.isHeadsetConnected;
        return ((z ? 1 : 0) << 4) | GlobalVar.currentVolume | JfifUtil.MARKER_SOFn;
    }

    private static int getStatusByteOne() {
        return GlobalVar.callState.getValue() | (GlobalVar.batteryPercentage << 3);
    }

    public static byte[] missedCallFrame(String str, String str2, long j) {
        byte[] bArr = new byte[74];
        bArr[0] = 1;
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
        bArr[1] = (byte) Math.min(bytes.length, 32);
        System.arraycopy(bytes, 0, bArr, 2, Math.min(bytes.length, 32));
        bArr[34] = (byte) Math.min(bytes2.length, 18);
        System.arraycopy(bytes2, 0, bArr, 35, Math.min(bytes2.length, 18));
        return bArr;
    }

    public static byte[] alertsFrame(Alert alert, String str, long j) {
        byte[] bArr = new byte[40];
        bArr[0] = (byte) alert.getValue();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        bArr[1] = (byte) Math.min(bytes.length, 32);
        System.arraycopy(bytes, 0, bArr, 2, Math.min(bytes.length, 32));
        return bArr;
    }

    static String getHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(HEXES.charAt((b & 240) >> 4));
            sb.append(HEXES.charAt(b & Ascii.SI));
        }
        return sb.toString();
    }
}
