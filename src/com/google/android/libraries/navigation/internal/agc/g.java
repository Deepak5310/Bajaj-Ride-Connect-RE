package com.google.android.libraries.navigation.internal.agc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static byte a(int i) {
        if (i >= -128 && i <= 127) {
            return (byte) i;
        }
        throw new IllegalArgumentException(i + " can't be represented as byte (out of range)");
    }

    public static float b(double d) {
        if (Double.isNaN(d)) {
            return Float.NaN;
        }
        if (Double.isInfinite(d)) {
            return d < 0.0d ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (d < -3.4028234663852886E38d || d > 3.4028234663852886E38d) {
            throw new IllegalArgumentException(d + " can't be represented as float (out of range)");
        }
        float f = (float) d;
        if (f == d) {
            return f;
        }
        throw new IllegalArgumentException(d + " can't be represented as float (imprecise)");
    }

    public static short c(int i) {
        if (i >= -32768 && i <= 32767) {
            return (short) i;
        }
        throw new IllegalArgumentException(i + " can't be represented as short (out of range)");
    }
}
