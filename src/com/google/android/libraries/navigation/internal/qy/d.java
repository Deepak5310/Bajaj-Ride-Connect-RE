package com.google.android.libraries.navigation.internal.qy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static float a(float[] fArr, float f) {
        int i = 0;
        if (f <= fArr[0]) {
            return fArr[1];
        }
        int length = fArr.length;
        if (f >= fArr[length - 2]) {
            return fArr[length - 1];
        }
        while (true) {
            int length2 = fArr.length;
            if (i >= length2 - 2) {
                return fArr[length2 - 1];
            }
            float f2 = fArr[i];
            float f3 = fArr[i + 1];
            int i2 = i + 2;
            float f4 = fArr[i2];
            float f5 = fArr[i + 3];
            if (f >= f2 && f <= f4) {
                return f3 + ((f5 - f3) * ((f - f2) / (f4 - f2)));
            }
            i = i2;
        }
    }

    public static float[] b(int[] iArr, float f) {
        int length = iArr.length + 1;
        float[] fArr = new float[length + length];
        fArr[0] = 0.0f;
        fArr[1] = 1.0f;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = i + i;
            int i3 = i2 + 2;
            fArr[i3] = fArr[i2];
            int i4 = i2 + 1;
            int i5 = i2 + 3;
            fArr[i5] = fArr[i4];
            float f2 = iArr[i];
            fArr[i3] = fArr[i3] + ((i & 1) == 0 ? f2 : f2 * f);
            fArr[i5] = fArr[i5] + f2;
        }
        return fArr;
    }

    public static final int c(float f, int i, int i2) {
        return Math.round(i + (i2 * f));
    }

    public static final int d(float f, int i, int i2) {
        return Math.round(i + (i2 * f));
    }

    public static final float e(int i, int i2, int i3, int i4) {
        return g(i, i3, i2, i4);
    }

    public static final float f(int i, int i2, int i3, int i4) {
        return g(i, i3, i2, i4);
    }

    private static float g(int i, int i2, int i3, int i4) {
        if (i4 >= i) {
            return 1.0f;
        }
        float f = i2;
        float f2 = i3;
        return ((((float) Math.ceil((((((i - i4) + f) / f) * f) + f2) / 4.0f)) * 4.0f) - f2) / f;
    }
}
