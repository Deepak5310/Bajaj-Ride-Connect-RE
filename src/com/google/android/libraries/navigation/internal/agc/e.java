package com.google.android.libraries.navigation.internal.agc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static int a(int i, float f) {
        long jMax = Math.max(2L, h((long) Math.ceil(i / f)));
        if (jMax <= 1073741824) {
            return (int) jMax;
        }
        throw new IllegalArgumentException("Too large (" + i + " expected elements with load factor " + f + ")");
    }

    public static int b(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public static int c(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int d(int i, float f) {
        return Math.min((int) Math.ceil(i * f), i - 1);
    }

    public static int e(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public static int f(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static long g(long j) {
        long j2 = j * (-7046029254386353131L);
        long j3 = j2 ^ (j2 >>> 32);
        return j3 ^ (j3 >>> 16);
    }

    public static long h(long j) {
        return 1 << (64 - Long.numberOfLeadingZeros(j - 1));
    }
}
