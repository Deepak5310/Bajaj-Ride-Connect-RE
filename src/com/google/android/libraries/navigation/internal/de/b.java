package com.google.android.libraries.navigation.internal.de;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public float a = -1.0f;
    public float b = Float.MAX_VALUE;
    public long c = Long.MIN_VALUE;
    public long d = Long.MIN_VALUE;

    public static float a(float f, float f2, float f3) {
        float f4;
        if (f < 0.0f) {
            return f2;
        }
        float f5 = 1.0f - f3;
        if (Math.abs(f2 - f) < 180.0f) {
            return (f3 * f) + (f5 * f2);
        }
        if (f2 > f) {
            f4 = f3 * f;
            f2 -= 360.0f;
        } else {
            f4 = f3 * (f - 360.0f);
        }
        return com.google.android.libraries.navigation.internal.df.d.b(f4 + (f5 * f2), 0.0f, 360.0f);
    }
}
