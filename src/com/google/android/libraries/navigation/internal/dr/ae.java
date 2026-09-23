package com.google.android.libraries.navigation.internal.dr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae {
    public static float a(float f) {
        if (f >= 16.0f) {
            return 1.0f;
        }
        if (f < 12.0f) {
            return 0.75f;
        }
        return ((f - 12.0f) * 0.0625f) + 0.75f;
    }

    public static float b(float f, float f2) {
        return (f / 2.0f) * f2;
    }
}
