package com.google.android.libraries.navigation.internal.df;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static float a(float f, float f2, float f3) {
        return (f * f2) + ((1.0f - f) * f3);
    }

    public static float b(float f, float f2, float f3) {
        while (f >= f3) {
            f -= 360.0f;
        }
        while (f < f2) {
            f += 360.0f;
        }
        return f;
    }
}
