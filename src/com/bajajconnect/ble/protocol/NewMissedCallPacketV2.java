package com.bajajconnect.ble.protocol;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public final class NewMissedCallPacketV2 {
    private static final byte RESERVED_ID = 1;

    private NewMissedCallPacketV2() {
    }

    public static byte[] build(String str, String str2, long j) {
        byte[] bArr = new byte[63];
        bArr[0] = 1;
        String strSanitize = sanitize(str);
        String strSanitize2 = sanitize(str2);
        if (!isUnknownCallerName(strSanitize, strSanitize2)) {
            byte[] bytes = strSanitize.getBytes(StandardCharsets.UTF_8);
            int iMin = Math.min(bytes.length, 32);
            bArr[1] = (byte) iMin;
            System.arraycopy(bytes, 0, bArr, 2, iMin);
        }
        byte[] bytes2 = strSanitize2.getBytes(StandardCharsets.UTF_8);
        int iMin2 = Math.min(bytes2.length, 18);
        bArr[34] = (byte) iMin2;
        System.arraycopy(bytes2, 0, bArr, 35, iMin2);
        int i = (int) (4294967295L & j);
        bArr[53] = (byte) ((i >> 24) & 255);
        bArr[54] = (byte) ((i >> 16) & 255);
        bArr[55] = (byte) ((i >> 8) & 255);
        bArr[56] = (byte) (i & 255);
        return bArr;
    }

    private static boolean isUnknownCallerName(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return str2 != null && str.equals(str2);
    }

    private static String sanitize(String str) {
        return str == null ? "" : str.replaceAll("[\\p{Cn}]", "");
    }
}
