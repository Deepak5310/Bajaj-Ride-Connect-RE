package com.google.android.libraries.navigation.internal.zl;

import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t {
    private static final q a;

    static {
        q qVar = p.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                qVar = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? s.UNSAFE_LITTLE_ENDIAN : s.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        a = qVar;
    }

    static int a(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static long b(byte[] bArr, int i) {
        return a.a(bArr, i);
    }
}
