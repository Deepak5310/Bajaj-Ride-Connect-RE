package com.google.android.libraries.navigation.internal.rq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static int a(int i) {
        int i2 = ((i >> 8) & 255) << 8;
        return ((i >> 16) & 255) | i2 | ((i & 255) << 16) | (((i >> 24) & 255) << 24);
    }

    public static int b(int i) {
        return i >>> 24;
    }

    public static int c(int i) {
        return i & 255;
    }

    public static int d(int i) {
        return (i >>> 8) & 255;
    }

    public static int e(int i) {
        return (i >>> 16) & 255;
    }
}
