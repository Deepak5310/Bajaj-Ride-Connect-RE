package com.google.android.libraries.navigation.internal.rq;

import android.opengl.Matrix;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final float[] a = new float[16];

    public static float a(float f, float f2, float f3) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public static void b(float[] fArr, float[] fArr2) {
        Matrix.invertM(fArr, 0, fArr2, 0);
    }

    public static void d(float[] fArr, float[] fArr2, float[] fArr3) {
        for (int i = 0; i < 4; i++) {
            float f = fArr2[i];
            float f2 = fArr2[i + 4];
            float f3 = fArr2[i + 8];
            float f4 = fArr2[i + 12];
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = i2 * 4;
                fArr[i3 + i] = (fArr3[i3] * f) + (fArr3[i3 + 1] * f2) + (fArr3[i3 + 2] * f3) + (fArr3[i3 + 3] * f4);
            }
        }
    }

    public static void e(float[] fArr, int i, float[] fArr2, float[] fArr3) {
        float f = fArr2[0];
        float f2 = fArr3[0];
        float f3 = f * f2;
        float f4 = fArr2[4];
        float f5 = fArr3[1];
        float f6 = f4 * f5;
        float f7 = fArr2[8];
        float f8 = fArr3[2];
        float f9 = f7 * f8;
        float f10 = fArr2[12];
        float f11 = fArr3[3];
        float f12 = fArr2[1] * f2;
        float f13 = fArr2[5] * f5;
        float f14 = fArr2[9] * f8;
        float f15 = fArr2[13] * f11;
        float f16 = fArr2[2] * f2;
        float f17 = fArr2[6] * f5;
        float f18 = fArr2[10] * f8;
        float f19 = fArr2[14] * f11;
        float f20 = fArr2[3] * f2;
        float f21 = fArr2[7] * f5;
        float f22 = fArr2[11] * f8;
        float f23 = fArr2[15] * f11;
        fArr[i] = f3 + f6 + f9 + (f10 * f11);
        fArr[i + 1] = f12 + f13 + f14 + f15;
        fArr[i + 2] = f16 + f17 + f18 + f19;
        fArr[i + 3] = f20 + f21 + f22 + f23;
    }

    public static void f(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }

    public static void g(float[] fArr, float f, float f2, float f3) {
        Matrix.translateM(fArr, 0, f, f2, f3);
    }

    public static void c(float[] fArr, float[] fArr2, float[] fArr3) {
        if (fArr != fArr3) {
            d(fArr, fArr2, fArr3);
            return;
        }
        if (fArr == fArr2) {
            float[] fArr4 = a;
            synchronized (fArr4) {
                d(fArr4, fArr2, fArr3);
                System.arraycopy(fArr4, 0, fArr, 0, 16);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int i2 = i * 4;
            float f = fArr[i2];
            float f2 = fArr[i2 + 1];
            float f3 = fArr[i2 + 2];
            float f4 = fArr[i2 + 3];
            for (int i3 = 0; i3 < 4; i3++) {
                fArr[i2 + i3] = (fArr2[i3] * f) + (fArr2[i3 + 4] * f2) + (fArr2[i3 + 8] * f3) + (fArr2[i3 + 12] * f4);
            }
        }
    }
}
