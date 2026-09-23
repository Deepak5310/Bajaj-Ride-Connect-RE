package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ay {
    public static float a(int i) {
        return i / 8.0f;
    }

    public static float b(int i, int i2) {
        if (i2 == 0) {
            return 30.0f;
        }
        return i + a(i2);
    }

    public static float c(int i, int i2) {
        if (i2 == 0) {
            return 30.0f;
        }
        return i + a(i2);
    }

    public static float d(int i, int i2) {
        if (i > 0) {
            return i2 == 0 ? i - 1 : i + a(i2);
        }
        return a(i2);
    }

    public static float e(int i, int i2) {
        return i2 == 0 ? Math.max(0, i - 4) : i + a(i2);
    }

    public static boolean f(int i, int i2) {
        return (i & i2) != 0;
    }
}
