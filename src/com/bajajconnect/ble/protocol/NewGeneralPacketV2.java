package com.bajajconnect.ble.protocol;

import android.os.Build;
import android.util.Log;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.variables.GlobalVar;
import com.facebook.imageutils.JfifUtil;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class NewGeneralPacketV2 {
    private static final int CALLER_NAME_MAX = 32;
    private static final int CALLER_NAME_OFFSET = 20;
    private static int heartbeat = 0;
    private static int lastByteTwo = -1;
    private static int stickyCallerOverwriteLen;

    private static int clampSignal(int i) {
        if (i < 0 || i > 7) {
            return 0;
        }
        return i;
    }

    private NewGeneralPacketV2() {
    }

    public static byte[] build() {
        heartbeat++;
        byte[] bArr = new byte[89];
        bArr[0] = (byte) getStatusByteZero();
        bArr[1] = (byte) getStatusByteOne();
        int iClampSignal = clampSignal(GlobalVar.signalStrength);
        int i = GlobalVar.birthdayDay & 31;
        int i2 = (iClampSignal & 7) | (i << 3);
        bArr[2] = (byte) i2;
        if (i2 != lastByteTwo) {
            Log.i("BLE_SIGNAL", "General v2 byte2=0x" + Integer.toHexString(i2 & 255) + " signal=" + iClampSignal + " birthdayDay=" + i + " (raw signalStrength=" + GlobalVar.signalStrength + ")");
            lastByteTwo = i2;
        }
        bArr[3] = (byte) (GlobalVar.birthdayMonth & 15);
        bArr[4] = (byte) GlobalVar.callAcceptAck;
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
        bArr[17] = (byte) GlobalVar.selectePlaylistSongAck;
        if (GlobalVar.callState == CallState.ACTIVE_CALL || GlobalVar.callState == CallState.INCOMING_CALL || GlobalVar.callState == CallState.OUTGOING_CALL) {
            String strSanitize = sanitize(GlobalVar.callerName);
            if (strSanitize.isEmpty()) {
                strSanitize = sanitize(GlobalVar.callerNumber);
            }
            if (strSanitize.isEmpty()) {
                bArr[18] = 0;
                Arrays.fill(bArr, 20, 52, (byte) 0);
                bArr[19] = 0;
            } else {
                bArr[18] = 1;
                byte[] bytes = strSanitize.getBytes(StandardCharsets.UTF_8);
                int iMin = Math.min(bytes.length, 32);
                Arrays.fill(bArr, 20, 52, (byte) 0);
                System.arraycopy(bytes, 0, bArr, 20, iMin);
                int iMax = Math.max(iMin, stickyCallerOverwriteLen);
                if (iMax > 32) {
                    iMax = 32;
                }
                bArr[19] = (byte) iMax;
                stickyCallerOverwriteLen = iMin;
            }
        } else {
            GlobalVar.callProgressCount = 0;
            bArr[18] = 0;
        }
        bArr[52] = (byte) (GlobalVar.callProgressCount & 255);
        bArr[53] = (byte) ((GlobalVar.callProgressCount >> 8) & 255);
        bArr[54] = (byte) heartbeat;
        byte[] bytes2 = sanitize(Build.MODEL).getBytes(StandardCharsets.UTF_8);
        int iMin2 = Math.min(bytes2.length, 32);
        bArr[55] = (byte) iMin2;
        System.arraycopy(bytes2, 0, bArr, 56, iMin2);
        bArr[88] = checksum(bArr, 88);
        return bArr;
    }

    private static int getStatusByteZero() {
        return (GlobalVar.currentVolume & 15) | ((GlobalVar.isHeadsetConnected ? 1 : 0) << 4) | JfifUtil.MARKER_SOFn;
    }

    private static int getStatusByteOne() {
        int i = GlobalVar.isDndEnabled ? 128 : 0;
        int i2 = GlobalVar.batteryPercentage & 255;
        if (i2 > 3) {
            i2 = 3;
        }
        return i | ((i2 & 3) << 4) | (GlobalVar.callState.getValue() & 15);
    }

    private static byte checksum(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 + (bArr[i3] & 255)) & 255;
        }
        return (byte) i2;
    }

    private static String sanitize(String str) {
        return str == null ? "" : str.replaceAll("[\\p{Cn}]", "");
    }
}
