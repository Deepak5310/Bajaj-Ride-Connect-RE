package com.google.android.libraries.navigation.internal.zy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static long b(long j, long j2, long j3) {
        return Math.min(Math.max(j, j2), j3);
    }

    public static long c(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b6) & 255) << 16) | ((((long) b) & 255) << 56) | ((((long) b2) & 255) << 48) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
    }
}
