package com.bajajconnect.wifi.navv2;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class NavigationProtocolV2Codec {
    private static final String TAG = "NavV2";

    public static void logFrame(String str, int i, byte[] bArr) {
    }

    private NavigationProtocolV2Codec() {
    }

    public static byte[] buildResponse(int i, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 5];
        bArr2[0] = 1;
        bArr2[1] = 2;
        bArr2[2] = (byte) (i & 255);
        bArr2[3] = (byte) ((length >> 8) & 255);
        bArr2[4] = (byte) (length & 255);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 5, length);
        }
        return bArr2;
    }

    public static byte[] encodeIndexedNameList(List<NavV2Models.IndexedPlace> list) {
        ArrayList arrayList = new ArrayList();
        int iMin = list == null ? 0 : Math.min(5, list.size());
        arrayList.add(Byte.valueOf((byte) iMin));
        for (int i = 0; i < iMin; i++) {
            NavV2Models.IndexedPlace indexedPlace = list.get(i);
            byte[] bArrSafeUtf8 = safeUtf8(indexedPlace.name);
            int iMin2 = Math.min(255, bArrSafeUtf8.length);
            arrayList.add(Byte.valueOf((byte) (indexedPlace.index & 255)));
            arrayList.add(Byte.valueOf((byte) iMin2));
            for (int i2 = 0; i2 < iMin2; i2++) {
                arrayList.add(Byte.valueOf(bArrSafeUtf8[i2]));
            }
        }
        return toPrimitive(arrayList);
    }

    public static byte[] encodeDetail(int i, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Byte.valueOf((byte) (i & 255)));
        appendLengthPrefixedUtf8(str, arrayList);
        appendLengthPrefixedUtf8(str2, arrayList);
        appendLengthPrefixedUtf8(str3, arrayList);
        return toPrimitive(arrayList);
    }

    public static byte[] encodeRoutePreview(NavV2Models.Source source, int i, NavV2Models.RouteMode routeMode, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Byte.valueOf((byte) (source != null ? source.value : 0)));
        arrayList.add(Byte.valueOf((byte) (i & 255)));
        arrayList.add(Byte.valueOf((byte) (routeMode != null ? routeMode.value : 0)));
        appendLengthPrefixedUtf8(str, arrayList);
        appendLengthPrefixedUtf8(str2, arrayList);
        return toPrimitive(arrayList);
    }

    public static byte[] encodeNavStatus(NavV2Models.NavStatus navStatus, String str) {
        ArrayList arrayList = new ArrayList();
        if (navStatus == null) {
            navStatus = NavV2Models.NavStatus.FAILED;
        }
        arrayList.add(Byte.valueOf((byte) navStatus.value));
        appendLengthPrefixedUtf8(str, arrayList);
        return toPrimitive(arrayList);
    }

    public static byte[] encodePreferenceAck(NavV2Models.AckStatus ackStatus) {
        if (ackStatus == null) {
            ackStatus = NavV2Models.AckStatus.FAILURE;
        }
        return new byte[]{(byte) ackStatus.value};
    }

    public static byte[] encodePreference(NavV2Models.RoutePreference routePreference) {
        if (routePreference == null) {
            routePreference = new NavV2Models.RoutePreference();
        }
        return routePreference.payloadBytes();
    }

    private static void appendLengthPrefixedUtf8(String str, ArrayList<Byte> arrayList) {
        byte[] bArrSafeUtf8 = safeUtf8(str);
        int iMin = Math.min(255, bArrSafeUtf8.length);
        arrayList.add(Byte.valueOf((byte) iMin));
        for (int i = 0; i < iMin; i++) {
            arrayList.add(Byte.valueOf(bArrSafeUtf8[i]));
        }
    }

    private static byte[] safeUtf8(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        return str.getBytes(StandardCharsets.UTF_8);
    }

    private static byte[] toPrimitive(ArrayList<Byte> arrayList) {
        byte[] bArr = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            bArr[i] = arrayList.get(i).byteValue();
        }
        return bArr;
    }

    private static String toHex(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 3);
        for (byte b : bArr) {
            sb.append(String.format("%02X ", Byte.valueOf(b)));
        }
        return sb.toString().trim();
    }
}
