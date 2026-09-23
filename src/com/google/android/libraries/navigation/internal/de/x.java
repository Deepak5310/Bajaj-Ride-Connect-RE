package com.google.android.libraries.navigation.internal.de;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    public float a;
    public float b;
    public float c;
    public float d;

    public x() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 1.0f;
    }

    public x(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final float a(x xVar) {
        float f = this.a * xVar.a;
        float f2 = this.b * xVar.b;
        return f + f2 + (this.c * xVar.c) + (this.d * xVar.d);
    }

    public final void b(float[] fArr) {
        float f = this.a;
        float f2 = f + f;
        float f3 = this.b;
        float f4 = f3 + f3;
        float f5 = this.c;
        float f6 = f5 + f5;
        float f7 = this.d;
        float f8 = f7 * f2;
        float f9 = f7 * f4;
        float f10 = f7 * f6;
        float f11 = f2 * f;
        float f12 = f * f4;
        float f13 = f * f6;
        float f14 = f4 * f3;
        float f15 = f3 * f6;
        float f16 = f5 * f6;
        fArr[0] = 1.0f - (f14 + f16);
        fArr[1] = f12 - f10;
        fArr[2] = f13 + f9;
        fArr[3] = f12 + f10;
        fArr[4] = 1.0f - (f16 + f11);
        fArr[5] = f15 - f8;
        fArr[6] = f13 - f9;
        fArr[7] = f15 + f8;
        fArr[8] = 1.0f - (f11 + f14);
    }

    public final void c(float[] fArr, float f) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
        float f5 = f * fSqrt;
        float fSin = ((double) fSqrt) > 1.0E-10d ? ((float) Math.sin(f5 / 2.0f)) / fSqrt : 0.0f;
        this.a = f2 * fSin;
        this.b = f3 * fSin;
        this.c = f4 * fSin;
        this.d = (float) Math.cos(f5 / 2.0f);
    }

    public final void d(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[4];
        float f3 = fArr[8];
        float f4 = f + f2 + f3;
        if (f4 > 1.0E-6f) {
            double dSqrt = Math.sqrt(f4 + 1.0f);
            float f5 = (float) (dSqrt + dSqrt);
            this.d = 0.25f * f5;
            this.a = (fArr[7] - fArr[5]) / f5;
            this.b = (fArr[2] - fArr[6]) / f5;
            this.c = (fArr[3] - fArr[1]) / f5;
            return;
        }
        if (f > f2 && f > f3) {
            double dSqrt2 = Math.sqrt(((f + 1.0f) - f2) - f3);
            float f6 = (float) (dSqrt2 + dSqrt2);
            this.d = (fArr[7] - fArr[5]) / f6;
            this.a = 0.25f * f6;
            this.b = (fArr[3] + fArr[1]) / f6;
            this.c = (fArr[2] + fArr[6]) / f6;
            return;
        }
        if (f2 > f3) {
            double dSqrt3 = Math.sqrt(((f2 + 1.0f) - f) - f3);
            float f7 = (float) (dSqrt3 + dSqrt3);
            this.d = (fArr[2] - fArr[6]) / f7;
            this.a = (fArr[3] + fArr[1]) / f7;
            this.b = 0.25f * f7;
            this.c = (fArr[7] + fArr[5]) / f7;
            return;
        }
        double dSqrt4 = Math.sqrt(((f3 + 1.0f) - f) - f2);
        float f8 = (float) (dSqrt4 + dSqrt4);
        this.d = (fArr[3] - fArr[1]) / f8;
        this.a = (fArr[2] + fArr[6]) / f8;
        this.b = (fArr[7] + fArr[5]) / f8;
        this.c = f8 * 0.25f;
    }

    public final void e(x xVar, x xVar2) {
        float f = xVar.d;
        float f2 = xVar2.a;
        float f3 = xVar.a;
        float f4 = xVar2.d;
        float f5 = xVar.b;
        float f6 = xVar2.c;
        float f7 = f5 * f6;
        float f8 = xVar.c;
        float f9 = xVar2.b;
        float f10 = f8 * f9;
        float f11 = f5 * f4;
        float f12 = f8 * f2;
        float f13 = f5 * f2;
        float f14 = f8 * f4;
        this.a = (((f * f2) + (f3 * f4)) + f7) - f10;
        this.b = ((f * f9) - (f3 * f6)) + f11 + f12;
        this.c = (((f * f6) + (f3 * f9)) - f13) + f14;
        this.d = (((f * f4) - (f3 * f2)) - (f5 * f9)) - (f8 * f6);
    }

    public final void f(x xVar) {
        float fA = xVar.a(xVar);
        float fSqrt = Math.abs(1.0f - fA) < 2.0E-4f ? (fA + 1.0f) / 2.0f : (float) Math.sqrt(fA);
        if (fSqrt == 0.0f) {
            h(0.0f, 0.0f, 0.0f, 1.0f);
            return;
        }
        float f = 1.0f / fSqrt;
        this.a = xVar.a * f;
        this.b = xVar.b * f;
        this.c = xVar.c * f;
        this.d = xVar.d * f;
    }

    public final void g() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 1.0f;
    }

    public final void h(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final void i(x xVar) {
        this.a = xVar.a;
        this.b = xVar.b;
        this.c = xVar.c;
        this.d = xVar.d;
    }

    public final String toString() {
        return String.format(Locale.US, "[%f, %f, %f, %f]", Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d));
    }
}
