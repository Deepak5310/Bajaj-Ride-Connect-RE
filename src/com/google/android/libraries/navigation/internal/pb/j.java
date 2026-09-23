package com.google.android.libraries.navigation.internal.pb;

import android.graphics.Rect;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.yx.ar;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    private static final float a = (float) (1.0d / Math.log(2.0d));

    public static float a(float f, float f2, int i, float f3) {
        return f(f, i, f3) * b(f2);
    }

    public static float b(float f) {
        return (float) (0.5d / Math.tan((((double) f) * 0.017453292519943295d) * 0.5d));
    }

    public static float c(t tVar) {
        return u(tVar, tVar.h());
    }

    public static float d(float f, int i, float f2, float f3, float f4) {
        return (f(f, i, f2) * b(f4)) / (f3 * i);
    }

    public static float e(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        if (tVar.w().l == 0.0f) {
            return 1.0f;
        }
        return tVar.h() / tVar.m(xVar, true);
    }

    public static float f(float f, int i, float f2) {
        return ((float) Math.pow(2.0d, 30.0f - f)) * (i / (f2 * 256.0f));
    }

    public static float g(float f, float f2, float f3) {
        return 30.0f - com.google.android.libraries.navigation.internal.nq.a.b((f2 / f3) * (f * 256.0f));
    }

    public static com.google.android.libraries.navigation.internal.oe.l h(t tVar, float f, float f2, float f3, float f4, float[] fArr) {
        ar.k(fArr.length >= 8);
        com.google.android.libraries.navigation.internal.oe.x xVarU = tVar.u();
        int i = xVarU.a;
        int i2 = xVarU.b;
        int i3 = xVarU.c;
        int iP = tVar.p() - i;
        int iQ = tVar.q() - i2;
        fArr[0] = f;
        fArr[1] = f3;
        fArr[2] = 1.0f;
        fArr[3] = 1.0f;
        com.google.android.libraries.navigation.internal.rq.f.e(fArr, 4, tVar.E(), fArr);
        float f5 = 1.0f / fArr[7];
        float f6 = fArr[4] * f5;
        float f7 = fArr[5] * f5;
        float f8 = i3;
        double d = (fArr[6] * f5) / f8;
        if (d >= 1.0d) {
            return null;
        }
        double d2 = 1.0d / (1.0d - d);
        double d3 = iP;
        double d4 = i;
        double d5 = iQ;
        double d6 = i2;
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x((int) (((((double) f6) + d3) * d2) + d4), (int) (((((double) f7) + d5) * d2) + d6));
        fArr[0] = f2;
        com.google.android.libraries.navigation.internal.rq.f.e(fArr, 4, tVar.E(), fArr);
        float f9 = 1.0f / fArr[7];
        float f10 = fArr[4] * f9;
        float f11 = fArr[5] * f9;
        double d7 = (fArr[6] * f9) / f8;
        if (d7 >= 1.0d) {
            return null;
        }
        double d8 = 1.0d / (1.0d - d7);
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x((int) (((((double) f10) + d3) * d8) + d4), (int) (((((double) f11) + d5) * d8) + d6));
        fArr[1] = f4;
        com.google.android.libraries.navigation.internal.rq.f.e(fArr, 4, tVar.E(), fArr);
        float f12 = 1.0f / fArr[7];
        float f13 = fArr[4] * f12;
        float f14 = fArr[5] * f12;
        double d9 = (fArr[6] * f12) / f8;
        if (d9 >= 1.0d) {
            return null;
        }
        double d10 = 1.0d / (1.0d - d9);
        com.google.android.libraries.navigation.internal.oe.x xVar3 = new com.google.android.libraries.navigation.internal.oe.x((int) (((((double) f13) + d3) * d10) + d4), (int) (((((double) f14) + d5) * d10) + d6));
        fArr[0] = f;
        com.google.android.libraries.navigation.internal.rq.f.e(fArr, 4, tVar.E(), fArr);
        float f15 = 1.0f / fArr[7];
        float f16 = fArr[4] * f15;
        float f17 = fArr[5] * f15;
        double d11 = (fArr[6] * f15) / f8;
        if (d11 >= 1.0d) {
            return null;
        }
        double d12 = 1.0d / (1.0d - d11);
        return com.google.android.libraries.navigation.internal.oe.l.d(new com.google.android.libraries.navigation.internal.oe.x((int) (((((double) f16) + d3) * d12) + d4), (int) (((((double) f17) + d5) * d12) + d6)), xVar3, xVar, xVar2);
    }

    public static com.google.android.libraries.navigation.internal.oe.x i(float f) {
        double d = ((double) f) * 0.017453292519943295d;
        return new com.google.android.libraries.navigation.internal.oe.x(Math.round((float) (Math.sin(d) * 65536.0d)), Math.round((float) (Math.cos(d) * 65536.0d)));
    }

    public static com.google.android.libraries.navigation.internal.oe.x j(t tVar, float f, float f2, float[] fArr) {
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        if (q(tVar, f, f2, xVar, fArr)) {
            return xVar;
        }
        return null;
    }

    public static com.google.android.libraries.navigation.internal.pd.d k(t tVar, com.google.android.libraries.navigation.internal.pd.d dVar, float f, float f2, float f3) {
        float fS = f2 - (tVar.s() * dVar.f515n.a());
        float fR = f3 - (tVar.r() * dVar.f515n.b());
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a(l(tVar, dVar, fS, fR));
        aVar.c = f;
        tVar.b.e(aVar);
        com.google.android.libraries.navigation.internal.pd.d dVarA = aVar.a();
        tVar.B(dVarA);
        return l(tVar, dVarA, -fS, -fR);
    }

    public static com.google.android.libraries.navigation.internal.pd.d l(t tVar, com.google.android.libraries.navigation.internal.pd.d dVar, float f, float f2) {
        float fU = u(tVar, a(dVar.k, tVar.i(), tVar.r(), tVar.n()));
        float f3 = f * fU;
        float f4 = (-f2) * fU;
        com.google.android.libraries.navigation.internal.pd.d dVarW = tVar.w();
        float fCos = (float) Math.cos(((double) dVarW.l) * 0.017453292519943295d);
        if (dVarW.o == null) {
            double d = ((double) (dVarW.m + 90.0f)) * 0.017453292519943295d;
            dVarW.o = new com.google.android.libraries.navigation.internal.oe.q(new com.google.android.libraries.navigation.internal.oe.x(Math.round(((float) Math.sin(d)) * 65536.0f), Math.round(((float) Math.cos(d)) * 65536.0f)));
        }
        float f5 = f4 / fCos;
        com.google.android.libraries.navigation.internal.oe.x xVarB = dVarW.o.b();
        com.google.android.libraries.navigation.internal.oe.x xVarB2 = dVarW.a().b();
        com.google.android.libraries.navigation.internal.oe.x.I(xVarB, f3, xVarB);
        com.google.android.libraries.navigation.internal.oe.x.I(xVarB2, f5, xVarB2);
        com.google.android.libraries.navigation.internal.oe.x xVar = dVar.j;
        int i = xVar.c;
        com.google.android.libraries.navigation.internal.oe.x xVarU = xVar.u(xVarB);
        com.google.android.libraries.navigation.internal.oe.x.F(xVarU, xVarB2, xVarU);
        xVarU.c = i;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a(dVar);
        aVar.e(xVarU);
        return aVar.a();
    }

    public static boolean m(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float[] fArr) {
        return x(tVar, xVar, fArr, true);
    }

    public static boolean n(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, ay ayVar, float[] fArr) {
        boolean zM = m(tVar, xVar, fArr);
        ayVar.q(fArr[0], fArr[1]);
        return zM;
    }

    public static boolean o(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float[] fArr) {
        fArr[0] = (((xVar.a - tVar.p()) + PropertyOptions.DELETE_EXISTING) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK) - 536870912;
        fArr[1] = xVar.b - tVar.q();
        float[] fArrF = tVar.F();
        float f = fArrF[0];
        float f2 = fArr[0];
        float f3 = fArrF[4];
        float f4 = fArr[1];
        float f5 = (f * f2) + (f3 * f4) + fArrF[12];
        fArr[4] = f5;
        float f6 = (fArrF[1] * f2) + (fArrF[5] * f4) + fArrF[13];
        fArr[5] = f6;
        float f7 = (fArrF[3] * f2) + (fArrF[7] * f4) + fArrF[15];
        fArr[7] = f7;
        if (f7 <= 0.0f) {
            fArr[0] = Float.NaN;
            fArr[1] = Float.NaN;
            return false;
        }
        float f8 = 1.0f / f7;
        fArr[0] = f5 * f8;
        fArr[1] = f6 * f8;
        return true;
    }

    public static boolean p(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float[] fArr) {
        return x(tVar, xVar, fArr, false);
    }

    public static boolean q(t tVar, float f, float f2, com.google.android.libraries.navigation.internal.oe.x xVar, float[] fArr) {
        ar.k(true);
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = 1.0f;
        fArr[3] = 1.0f;
        com.google.android.libraries.navigation.internal.rq.f.e(fArr, 4, tVar.E(), fArr);
        com.google.android.libraries.navigation.internal.oe.x xVarU = tVar.u();
        int i = xVarU.a;
        int i2 = xVarU.b;
        int i3 = xVarU.c;
        float f3 = 1.0f / fArr[7];
        float f4 = fArr[4] * f3;
        float f5 = fArr[5] * f3;
        double d = (fArr[6] * f3) / i3;
        if (d >= 1.0d || Double.isNaN(d)) {
            return false;
        }
        double d2 = 1.0d / (1.0d - d);
        tVar.A(xVar);
        double d3 = i;
        double d4 = i2;
        xVar.J((int) ((((((double) f4) + ((double) xVar.a)) - d3) * d2) + d3), (int) ((((((double) f5) + ((double) xVar.b)) - d4) * d2) + d4));
        return true;
    }

    public static int[] r(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        float[] fArr = new float[8];
        if (m(tVar, xVar, fArr)) {
            return new int[]{Math.round(fArr[0]), Math.round(fArr[1])};
        }
        return null;
    }

    public static float s(com.google.android.libraries.navigation.internal.rf.g gVar) {
        return d(((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).e, gVar.c(), gVar.b(), b(gVar.a()), gVar.a());
    }

    public static float t(float f, float f2) {
        ar.a(true);
        return f2 / (f * 256.0f);
    }

    public static float u(t tVar, float f) {
        return f / (tVar.j() * tVar.r());
    }

    public static com.google.android.libraries.navigation.internal.rf.g v(com.google.android.libraries.navigation.internal.rf.g gVar, com.google.android.libraries.navigation.internal.oq.h hVar, com.google.android.libraries.navigation.internal.oe.x xVar, Rect rect, int i, float f, float f2, float f3) {
        com.google.android.libraries.navigation.internal.oe.l lVarY = y(gVar, rect.left, rect.right - 1, rect.top + i, rect.bottom - 1);
        for (int i2 = 0; i2 < 5 && lVarY != null && !lVarY.k(xVar); i2++) {
            com.google.android.libraries.navigation.internal.oe.x xVarZ = com.google.android.libraries.navigation.internal.oe.x.z(((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).a);
            ay ayVarF = gVar.f(xVar);
            if (ayVarF == null) {
                float fAbs = Math.abs(w(lVarY.i(), lVarY.h(), xVarZ, xVar));
                float f4 = ((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).e;
                float fLog = ((float) Math.log(fAbs)) * a;
                com.google.android.libraries.navigation.internal.oq.a aVar = new com.google.android.libraries.navigation.internal.oq.a(gVar.g());
                aVar.k(f4 - fLog);
                return gVar.i(aVar.l());
            }
            float fW = ayVarF.b < rect.left ? w(lVarY.h(), lVarY.e(), xVarZ, xVar) : ayVarF.b >= ((float) rect.right) ? w(lVarY.i(), lVarY.f(), xVarZ, xVar) : 1.0f;
            if (ayVarF.c < rect.top + i) {
                fW = Math.max(fW, w(lVarY.f(), lVarY.e(), xVarZ, xVar));
            } else if (ayVarF.c >= rect.bottom) {
                fW = Math.max(fW, w(lVarY.i(), lVarY.h(), xVarZ, xVar));
            }
            float fLog2 = ((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).e - (((float) Math.log(fW)) * a);
            if (Math.abs(fLog2 - ((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).e) < 1.0E-6d && ((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).c <= hVar.a(fLog2)) {
                break;
            }
            com.google.android.libraries.navigation.internal.oq.a aVar2 = new com.google.android.libraries.navigation.internal.oq.a(gVar.g());
            aVar2.k(fLog2);
            aVar2.j(Math.min(hVar.a(fLog2), ((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).c));
            gVar = gVar.i(aVar2.l());
            lVarY = y(gVar, rect.left, (rect.left + rect.right) - 1, rect.top + i, rect.bottom - 1);
        }
        float f5 = ((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).e;
        if (Math.floor(f5) == Math.floor(f2) || Math.abs(f5 - f2) >= f3 || f5 == f) {
            return gVar;
        }
        com.google.android.libraries.navigation.internal.oq.a aVar3 = new com.google.android.libraries.navigation.internal.oq.a(gVar.g());
        aVar3.k(f2);
        return gVar.i(aVar3.l());
    }

    private static float w(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2, com.google.android.libraries.navigation.internal.oe.x xVar3, com.google.android.libraries.navigation.internal.oe.x xVar4) {
        int i = xVar.b;
        int i2 = i - xVar2.b;
        int i3 = xVar2.a;
        int i4 = xVar.a;
        int i5 = xVar3.a;
        int i6 = xVar3.b;
        long j = i4 - i5;
        long j2 = i2;
        long j3 = i3 - i4;
        return 1.0f / ((float) (((j * j2) + (((long) (i - i6)) * j3)) / ((((long) (xVar4.a - i5)) * j2) + (((long) (xVar4.b - i6)) * j3))));
    }

    private static boolean x(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float[] fArr, boolean z) {
        ar.k(true);
        fArr[0] = z ? (((xVar.a - tVar.p()) + PropertyOptions.DELETE_EXISTING) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK) - 536870912 : xVar.a - tVar.p();
        fArr[1] = xVar.b - tVar.q();
        fArr[2] = xVar.c;
        float[] fArrF = tVar.F();
        float f = fArrF[0];
        float f2 = fArr[0];
        float f3 = fArrF[4];
        float f4 = fArr[1];
        float f5 = fArrF[8];
        float f6 = fArr[2];
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6) + fArrF[12];
        fArr[4] = f7;
        float f8 = (fArrF[1] * f2) + (fArrF[5] * f4) + (fArrF[9] * f6) + fArrF[13];
        fArr[5] = f8;
        float f9 = (fArrF[3] * f2) + (fArrF[7] * f4) + (fArrF[11] * f6) + fArrF[15];
        fArr[7] = f9;
        if (f9 <= 0.0f) {
            fArr[0] = Float.NaN;
            fArr[1] = Float.NaN;
            return false;
        }
        float f10 = 1.0f / f9;
        fArr[0] = f7 * f10;
        fArr[1] = f8 * f10;
        return true;
    }

    private static com.google.android.libraries.navigation.internal.oe.l y(com.google.android.libraries.navigation.internal.rf.g gVar, float f, float f2, float f3, float f4) {
        com.google.android.libraries.navigation.internal.oe.q qVarE = gVar.e(f, f3);
        com.google.android.libraries.navigation.internal.oe.q qVarE2 = gVar.e(f2, f3);
        com.google.android.libraries.navigation.internal.oe.q qVarE3 = gVar.e(f2, f4);
        com.google.android.libraries.navigation.internal.oe.q qVarE4 = gVar.e(f, f4);
        if (qVarE == null || qVarE2 == null || qVarE3 == null || qVarE4 == null) {
            return null;
        }
        return com.google.android.libraries.navigation.internal.oe.l.d(qVarE4.a(), qVarE3.a(), qVarE.a(), qVarE2.a());
    }
}
