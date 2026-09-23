package com.google.android.libraries.navigation.internal.qq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    public final com.google.android.libraries.navigation.internal.oe.l a;
    public final com.google.android.libraries.navigation.internal.qa.a b;
    public final com.google.android.libraries.navigation.internal.pb.t c;
    protected final com.google.android.libraries.navigation.internal.oe.x d;
    public final float[] e;
    public final float f;
    public final float[] g;
    public final com.google.android.libraries.navigation.internal.qa.b i;
    private final w j = new w();
    public final float[] h = new float[6];

    public x(com.google.android.libraries.navigation.internal.oe.x xVar, float f, com.google.android.libraries.navigation.internal.pb.t tVar) {
        float[] fArr = new float[2];
        this.e = fArr;
        float[] fArr2 = new float[8];
        this.g = fArr2;
        com.google.android.libraries.navigation.internal.oe.l.d(new com.google.android.libraries.navigation.internal.oe.x(0, 0), new com.google.android.libraries.navigation.internal.oe.x(0, 0), new com.google.android.libraries.navigation.internal.oe.x(0, 0), new com.google.android.libraries.navigation.internal.oe.x(0, 0));
        this.i = new com.google.android.libraries.navigation.internal.qa.b();
        if (!com.google.android.libraries.navigation.internal.pb.j.m(tVar, xVar, fArr2)) {
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
        }
        float f2 = fArr2[0];
        fArr[0] = f2;
        float f3 = fArr2[1];
        fArr[1] = f3;
        float f4 = f2 - f;
        float f5 = f2 + f;
        float f6 = f3 - f;
        float f7 = f3 + f;
        this.a = com.google.android.libraries.navigation.internal.pb.j.h(tVar, f4, f5, f6, f7, fArr2);
        this.b = new com.google.android.libraries.navigation.internal.qa.a(f4, f6, f5, f7);
        this.d = xVar;
        this.c = tVar;
        this.f = f;
    }

    private static boolean e(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f5 - f3;
        float f10 = f4 - f2;
        float f11 = (((f6 - f2) * f10) + ((f7 - f3) * f9)) / ((f10 * f10) + (f9 * f9));
        if (f11 > 0.0f && !Float.isNaN(f11)) {
            if (f11 >= 1.0f) {
                f2 = f4;
                f3 = f5;
            } else {
                f2 += f10 * f11;
                f3 += f11 * f9;
            }
        }
        float f12 = f8 + (f / 2.0f);
        float f13 = f6 - f2;
        float f14 = f7 - f3;
        return (f13 * f13) + (f14 * f14) <= f12 * f12;
    }

    public final boolean a(com.google.android.libraries.navigation.internal.qa.b bVar) {
        return bVar.e(this.b);
    }

    public final boolean b(float f, float f2, double d, float f3, float f4) {
        this.i.g(f, f2, d, f3 / 2.0f, f4 / 2.0f);
        return this.i.e(this.b);
    }

    public final boolean c(float[] fArr, boolean z, float f, com.google.android.libraries.navigation.internal.rm.c cVar, float f2) {
        com.google.android.libraries.navigation.internal.oe.x xVarA = this.j.a(this.d, cVar);
        if (z) {
            com.google.android.libraries.navigation.internal.pb.t tVar = this.c;
            float[] fArr2 = this.g;
            fArr2[0] = xVarA.a;
            fArr2[1] = xVarA.b;
            float[] fArrF = tVar.F();
            float f3 = fArrF[0];
            float f4 = fArr2[0];
            float f5 = fArrF[4];
            float f6 = fArr2[1];
            float f7 = (f3 * f4) + (f5 * f6);
            fArr2[4] = f7;
            float f8 = (fArrF[1] * f4) + (fArrF[5] * f6);
            fArr2[5] = f8;
            float f9 = fArrF[11] + fArrF[15];
            fArr2[7] = f9;
            if (f9 <= 0.0f) {
                fArr2[0] = Float.NaN;
                fArr2[1] = Float.NaN;
                return false;
            }
            float f10 = 1.0f / f9;
            fArr2[0] = f7 * f10;
            fArr2[1] = f8 * f10;
        } else if (!com.google.android.libraries.navigation.internal.pb.j.p(this.c, xVarA, this.g)) {
            return false;
        }
        float[] fArr3 = this.g;
        float f11 = fArr3[0];
        float f12 = fArr3[1];
        float f13 = 0.5f * f;
        if (f11 < (com.google.android.libraries.navigation.internal.zy.b.b(fArr[0], fArr[2], fArr[4]) - f2) - f13 || f11 > com.google.android.libraries.navigation.internal.zy.b.a(fArr[0], fArr[2], fArr[4]) + f2 + f13 || f12 < (com.google.android.libraries.navigation.internal.zy.b.b(fArr[1], fArr[3], fArr[5]) - f2) - f13 || f12 > com.google.android.libraries.navigation.internal.zy.b.a(fArr[1], fArr[3], fArr[5]) + f2 + f13) {
            return false;
        }
        float f14 = fArr[0];
        float f15 = fArr[1];
        float f16 = fArr[2];
        float f17 = fArr[3];
        if (!e(f, f14, f15, f16, f17, f11, f12, f2)) {
            float f18 = fArr[4];
            float f19 = fArr[5];
            if (!e(f, f16, f17, f18, f19, f11, f12, f2) && !e(f, f18, f19, f14, f15, f11, f12, f2)) {
                double d = f11;
                double d2 = f15;
                double d3 = f18;
                double d4 = f19;
                double d5 = ((double) f17) - d4;
                double d6 = d3 - ((double) f16);
                double d7 = ((double) f14) - d3;
                double d8 = (d5 * d7) + ((d2 - d4) * d6);
                double d9 = d - d3;
                double d10 = ((double) f12) - d4;
                double d11 = (d5 * d9) + (d6 * d10);
                double d12 = ((d4 - d2) * d9) + (d7 * d10);
                double d13 = (d8 - d11) - d12;
                if (d8 < 0.0d) {
                    d8 = -d8;
                    d11 = -d11;
                    d12 = -d12;
                    d13 = -d13;
                }
                return d11 >= 0.0d && d11 <= d8 && d12 >= 0.0d && d12 <= d8 && d13 >= 0.0d && d13 <= d8;
            }
        }
        return true;
    }

    public final boolean d(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2, com.google.android.libraries.navigation.internal.oe.x xVar3, com.google.android.libraries.navigation.internal.rm.c cVar) {
        com.google.android.libraries.navigation.internal.oe.x xVarA = this.j.a(this.d, cVar);
        int i = xVarA.a;
        int i2 = xVarA.b;
        long j = xVar.a;
        long j2 = xVar.b;
        long j3 = xVar2.a;
        long j4 = xVar2.b;
        long j5 = xVar3.a;
        long j6 = xVar3.b;
        long j7 = i;
        long j8 = j4 - j6;
        long j9 = j5 - j3;
        long j10 = j - j5;
        long j11 = (j8 * j10) + ((j2 - j6) * j9);
        long j12 = j6 - j2;
        long j13 = j7 - j5;
        long j14 = ((long) i2) - j6;
        long j15 = (j8 * j13) + (j9 * j14);
        long j16 = (j12 * j13) + (j14 * j10);
        long j17 = (j11 - j15) - j16;
        if (j11 < 0) {
            j11 = -j11;
            j15 = -j15;
            j16 = -j16;
            j17 = -j17;
        }
        return j15 >= 0 && j15 <= j11 && j16 >= 0 && j16 <= j11 && j17 >= 0 && j17 <= j11;
    }
}
