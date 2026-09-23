package com.bajajconnect.ble.protocol;

import com.bajajconnect.enums.Alert;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public final class NewAlertsPacketV2 {
    private NewAlertsPacketV2() {
    }

    public static byte[] build(Alert alert, String str, long j) {
        byte[] bArr = new byte[44];
        bArr[0] = (byte) alert.getValue();
        byte[] bytes = sanitize(str).getBytes(StandardCharsets.UTF_8);
        int iMin = Math.min(bytes.length, 32);
        bArr[1] = (byte) iMin;
        System.arraycopy(bytes, 0, bArr, 2, iMin);
        int i = (int) (4294967295L & j);
        bArr[34] = (byte) ((i >> 24) & 255);
        bArr[35] = (byte) ((i >> 16) & 255);
        bArr[36] = (byte) ((i >> 8) & 255);
        bArr[37] = (byte) (i & 255);
        return bArr;
    }

    private static String sanitize(String str) {
        return str == null ? "" : str.replaceAll("[\\p{Cn}]", "");
    }
}
