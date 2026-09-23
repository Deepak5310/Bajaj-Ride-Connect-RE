package com.google.android.libraries.navigation.internal.nq;

import androidx.core.math.MathUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final float a = (float) (1.0d / Math.log(2.0d));

    public static float a(float f, float f2, float f3, float f4, float f5) {
        return f + ((f2 - f) * ((MathUtils.clamp(f5, f3, f4) - f3) / (f4 - f3)));
    }

    public static float b(float f) {
        return ((float) Math.log(f)) * a;
    }

    public static float c(float f) {
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return 0.0f;
        }
        if (f >= 360.0f) {
            return f - 360.0f;
        }
        return f < 0.0f ? f + 360.0f : f;
    }

    public static float d(float f) {
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return 0.0f;
        }
        while (f < 0.0f) {
            f += 360.0f;
        }
        while (f >= 360.0f) {
            f -= 360.0f;
        }
        return f;
    }

    public static float e(float f) {
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return 0.0f;
        }
        if (f >= 180.0f) {
            return f - 360.0f;
        }
        return f < -180.0f ? f + 360.0f : f;
    }

    public static int f(int i, int i2) {
        while (i2 < i) {
            i2 += i2;
        }
        return i2;
    }

    public static int g(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Greatest common divisor should be computed on numbers greater than zero.");
        }
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    public static int h(int i, int i2, int i3, int i4) {
        return (i & 255) | ((i2 & 255) << 8) | ((i3 & 255) << 16) | ((i4 & 255) << 24);
    }

    public static long i(long j) {
        return (long) Math.ceil(j / 1048576.0d);
    }

    public static boolean j(int i) {
        return (i & (i + (-1))) == 0;
    }
}
