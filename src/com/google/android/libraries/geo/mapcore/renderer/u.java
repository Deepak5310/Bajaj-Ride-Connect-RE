package com.google.android.libraries.geo.mapcore.renderer;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class u {
    public final AtomicReference e;
    protected final Runnable f;
    public boolean g;
    protected final t h;

    public u(com.google.android.libraries.navigation.internal.pd.d dVar, int i, int i2, float f, Runnable runnable) {
        this.g = false;
        this.h = new t();
        com.google.android.libraries.navigation.internal.yx.ar.g(i > 0 && i2 > 0, "target=%sx%s", i, i2);
        com.google.android.libraries.navigation.internal.yx.ar.f(f > 0.0f, "screenDensity=%s", Float.valueOf(f));
        com.google.android.libraries.navigation.internal.yx.ar.f(true, "nearClip=%s", Float.valueOf(0.1f));
        com.google.android.libraries.navigation.internal.yx.ar.f(true, "farClip=%s", Float.valueOf(20.0f));
        com.google.android.libraries.navigation.internal.yx.ar.f(true, "filedOfViewDegrees=%s", Float.valueOf(30.0f));
        this.e = new AtomicReference(y(dVar, i, i2, f, 0.1f, 20.0f, 30.0f));
        this.f = runnable;
    }

    public static boolean D(float f, float f2, int i, int i2, int i3, int i4, int i5, float[] fArr, com.google.android.libraries.navigation.internal.oe.x xVar, float[] fArr2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(true);
        fArr2[0] = f;
        fArr2[1] = f2;
        fArr2[2] = 1.0f;
        fArr2[3] = 1.0f;
        com.google.android.libraries.navigation.internal.rq.f.e(fArr2, 4, fArr, fArr2);
        float f3 = 1.0f / fArr2[7];
        float f4 = fArr2[4] * f3;
        float f5 = fArr2[5] * f3;
        double d = (fArr2[6] * f3) / i5;
        if (d >= 1.0d) {
            return false;
        }
        double d2 = 1.0d / (1.0d - d);
        double d3 = i3;
        double d4 = i4;
        xVar.J((int) ((((((double) f4) + ((double) i)) - d3) * d2) + d3), (int) ((((((double) f5) + ((double) i2)) - d4) * d2) + d4));
        return true;
    }

    public static void H(com.google.android.libraries.navigation.internal.pd.d dVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3, float[] fArr, com.google.android.libraries.navigation.internal.oe.bc bcVar, float[] fArr2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(true);
        float f4 = dVar.l;
        float f5 = i7;
        float fCeil = (float) Math.ceil((((double) i7) * 0.5d) - ((double) ((f5 * f2) * ((float) Math.tan((Math.min(Math.min((0.5f * f) + f4, 82.5f), f3) - f4) * 0.017453292f)))));
        boolean zD = D(0.0f, f5, i, i2, i3, i4, i5, fArr, bcVar.b(0), fArr2);
        float f6 = i6;
        boolean zD2 = D(f6, f5, i, i2, i3, i4, i5, fArr, bcVar.b(1), fArr2);
        boolean zD3 = D(f6, fCeil, i, i2, i3, i4, i5, fArr, bcVar.b(2), fArr2);
        boolean zD4 = D(0.0f, fCeil, i, i2, i3, i4, i5, fArr, bcVar.b(3), fArr2);
        if (zD && zD2 && zD3 && zD4) {
            bcVar.f();
            return;
        }
        bcVar.b(0).J(0, 0);
        bcVar.b(1).J(0, 0);
        bcVar.b(2).J(0, 0);
        bcVar.b(3).J(0, 0);
        bcVar.f();
    }

    public static float g(v vVar, float f) {
        float f2 = vVar.q;
        double d = ((double) (f + f2)) - ((double) f2);
        double d2 = vVar.f86n * d;
        double d3 = vVar.t;
        float[] fArr = {(float) (d2 * d3), (float) (vVar.o * d * d3), (float) (vVar.p * d * d3), 1.0f};
        com.google.android.libraries.navigation.internal.rq.f.e(fArr, 0, vVar.w, fArr);
        return fArr[2] / fArr[3];
    }

    protected static v y(com.google.android.libraries.navigation.internal.pd.d dVar, int i, int i2, float f, float f2, float f3, float f4) {
        com.google.android.libraries.navigation.internal.pd.e eVar = dVar.f515n;
        float f5 = eVar.b;
        double d = f4;
        double dTan = 0.5d / Math.tan((d * 0.017453292519943295d) * 0.5d);
        float fHypot = (float) Math.hypot(i, i2);
        float fTan = (float) Math.tan(0.5235987755982988d);
        float fTan2 = (float) Math.tan((d / 2.0d) * 0.017453292519943295d);
        float f6 = fHypot / ((fTan2 + fTan2) - (2.0f / fTan));
        double dHypot = Math.hypot(f6, (-f6) / fTan);
        float f7 = 256.0f * f;
        float fMax = Math.max(2.0f, com.google.android.libraries.navigation.internal.nq.a.b(((float) Math.ceil(((float) (dHypot + dHypot)) / f7)) + 1.0f));
        float f8 = dVar.m;
        double d2 = ((double) dVar.l) * 0.017453292519943295d;
        double dSin = Math.sin(d2);
        double d3 = (90.0d - ((double) f8)) * 0.017453292519943295d;
        double dCos = dSin * Math.cos(d3);
        double dSin2 = dSin * Math.sin(d3);
        double d4 = -Math.cos(d2);
        double dTan2 = 1.0d / Math.tan((d * 0.5d) * 0.017453292519943295d);
        double dAtan2 = Math.atan2(eVar.c, dTan2);
        float f9 = (float) dTan;
        double dSin3 = Math.sin(dAtan2) / Math.sin((3.141592653589793d - (1.5707963267948966d - d2)) - dAtan2);
        float f10 = i2;
        double dPow = Math.pow(2.0d, 30.0f - dVar.k) * ((double) (f10 / f7));
        double d5 = 0.5d * dPow * dTan2;
        com.google.android.libraries.navigation.internal.oe.x xVar = dVar.j;
        double d6 = xVar.a;
        double d7 = f8 * 0.017453292f;
        float fSin = (float) Math.sin(d7);
        double d8 = xVar.b;
        float fCos = (float) Math.cos(d7);
        int i3 = xVar.c;
        float f11 = (float) (dPow * ((double) f9));
        float f12 = f11 > 2.1474835E9f ? 2.1474835E9f : f11;
        double d9 = -f12;
        float f13 = f12;
        int iRound = (int) Math.round(d9 * dCos);
        int iRound2 = (int) Math.round(d9 * dSin2);
        int iRound3 = ((int) Math.round(d9 * d4)) + i3;
        float f14 = iRound3;
        float f15 = 1.0f / f14;
        com.google.android.libraries.navigation.internal.yx.ar.k(f15 >= 0.0f);
        float[] fArr = new float[16];
        com.google.android.libraries.navigation.internal.rq.f.f(fArr);
        float f16 = i;
        float f17 = f10 * 0.5f;
        float f18 = 0.5f * f16;
        fArr[0] = f18;
        fArr[5] = -f17;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
        fArr[12] = f18;
        fArr[13] = f17;
        float f19 = i2 == 0 ? 1.0f : f16 / f10;
        double d10 = dSin3 * d5;
        int i4 = (int) (d8 + (((double) fCos) * d10));
        int i5 = iRound2 + i4;
        int i6 = (int) (d6 + (d10 * ((double) fSin)));
        int i7 = iRound + i6;
        float fTan3 = ((float) Math.tan(Math.toRadians(d) / 2.0d)) * f2;
        float f20 = f2 + f2;
        float f21 = fTan3 * f19 * (1.0f - f5);
        float f22 = -fTan3;
        float f23 = f19 * f22 * (f5 + 1.0f);
        float f24 = f21 - f23;
        float f25 = fTan3 - f22;
        float f26 = f3 - f2;
        float[] fArr2 = {f20 / f24, 0.0f, 0.0f, 0.0f, 0.0f, f20 / f25, 0.0f, 0.0f, (f21 + f23) / f24, (fTan3 + f22) / f25, (-(f3 + f2)) / f26, -1.0f, 0.0f, 0.0f, (-((f3 + f3) * f2)) / f26, 0.0f};
        com.google.android.libraries.navigation.internal.oe.q qVarA = dVar.a();
        float f27 = qVarA.a;
        float f28 = qVarA.b;
        float f29 = qVarA.c;
        float f30 = -((i7 - i6) * f15);
        float f31 = -((i5 - i4) * f15);
        float f32 = -((iRound3 - i3) * f15);
        float fA = 1.0f / com.google.android.libraries.navigation.internal.rq.f.a(f30, f31, f32);
        float f33 = f30 * fA;
        float f34 = f31 * fA;
        float f35 = f34 * f27;
        float f36 = f32 * fA;
        float f37 = f33 * f29;
        float f38 = (f29 * f34) - (f28 * f36);
        float f39 = (f27 * f36) - f37;
        float f40 = (f33 * f28) - f35;
        float fA2 = 1.0f / com.google.android.libraries.navigation.internal.rq.f.a(f38, f39, f40);
        float f41 = f38 * fA2;
        float f42 = f39 * fA2;
        float f43 = f40 * fA2;
        float[] fArr3 = {f41, (f42 * f36) - (f43 * f34), -f33, 0.0f, f42, (f43 * f33) - (f41 * f36), -f34, 0.0f, f43, (f41 * f34) - (f42 * f33), -f36, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        com.google.android.libraries.navigation.internal.rq.f.g(fArr3, f30, f31, f32);
        float[] fArr4 = new float[16];
        com.google.android.libraries.navigation.internal.rq.f.c(fArr4, fArr2, fArr3);
        float[] fArr5 = new float[16];
        float[] fArr6 = new float[16];
        com.google.android.libraries.navigation.internal.rq.f.c(fArr5, fArr, fArr2);
        com.google.android.libraries.navigation.internal.rq.f.c(fArr6, fArr5, fArr3);
        for (int i8 = 12; i8 < 16; i8++) {
            fArr6[i8] = fArr6[i8] * f14;
        }
        float[] fArr7 = new float[16];
        com.google.android.libraries.navigation.internal.rq.f.b(fArr7, fArr6);
        com.google.android.libraries.navigation.internal.oe.bc bcVar = new com.google.android.libraries.navigation.internal.oe.bc(new com.google.android.libraries.navigation.internal.oe.x[]{new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x()});
        H(dVar, i6, i4, i7, i5, iRound3, i, i2, f4, f9, 90.0f, fArr7, bcVar, new float[8]);
        return new v(dVar, i, i2, f, f2, f3, f4, i6, i4, i3, i7, i5, iRound3, dCos, dSin2, d4, f13, f9, fMax, f15, bcVar, fArr3, fArr4, fArr6, fArr7);
    }

    public final void A(com.google.android.libraries.navigation.internal.oe.x xVar) {
        v vVar = (v) this.e.get();
        xVar.K(vVar.h, vVar.i, vVar.j);
    }

    public final void B(com.google.android.libraries.navigation.internal.pd.d dVar) {
        if (dVar == null) {
            return;
        }
        z();
        v vVar = (v) this.e.get();
        if (vVar.a.equals(dVar)) {
            return;
        }
        this.e.set(y(dVar, vVar.b, vVar.c, vVar.d, vVar.e, vVar.f, vVar.g));
        Runnable runnable = this.f;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void C(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        z();
        v vVar = (v) this.e.get();
        if (vVar.b == i && vVar.c == i2) {
            return;
        }
        this.e.set(y(vVar.a, i, i2, vVar.d, vVar.e, vVar.f, vVar.g));
        Runnable runnable = this.f;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final float[] E() {
        z();
        return ((v) this.e.get()).y;
    }

    public final float[] F() {
        z();
        return ((v) this.e.get()).x;
    }

    public final float[] G() {
        return ((v) this.e.get()).w;
    }

    public void b(int i, int i2) {
        throw null;
    }

    public final boolean equals(Object obj) {
        z();
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return ((v) this.e.get()).equals(((u) obj).e.get());
        }
        return false;
    }

    public final float h() {
        return ((v) this.e.get()).q;
    }

    public final int hashCode() {
        return ((v) this.e.get()).hashCode();
    }

    public final float i() {
        return ((v) this.e.get()).g;
    }

    public final float j() {
        return ((v) this.e.get()).r;
    }

    public final float k() {
        return ((v) this.e.get()).s;
    }

    public final float l() {
        return ((v) this.e.get()).t;
    }

    public final float m(com.google.android.libraries.navigation.internal.oe.x xVar, boolean z) {
        double d;
        z();
        synchronized (this.h) {
            v vVar = (v) this.e.get();
            com.google.android.libraries.navigation.internal.oe.x xVar2 = this.h.a;
            xVar2.a = xVar.a - vVar.h;
            xVar2.b = xVar.b - vVar.i;
            xVar2.c = xVar.c - vVar.j;
            if (z) {
                xVar2.Q(xVar2);
            }
            int i = vVar.h - vVar.k;
            int i2 = vVar.i - vVar.l;
            int i3 = vVar.j - vVar.m;
            int i4 = xVar2.a + i;
            xVar2.a = i4;
            int i5 = xVar2.b + i2;
            xVar2.b = i5;
            int i6 = xVar2.c + i3;
            xVar2.c = i6;
            d = (((double) i4) * vVar.f86n) + (((double) i5) * vVar.o) + (((double) i6) * vVar.p);
        }
        return (float) d;
    }

    public final float n() {
        return ((v) this.e.get()).d;
    }

    public final float o() {
        return ((v) this.e.get()).a.k;
    }

    public final int p() {
        return ((v) this.e.get()).h;
    }

    public final int q() {
        return ((v) this.e.get()).i;
    }

    public final int r() {
        return ((v) this.e.get()).c;
    }

    public final int s() {
        return ((v) this.e.get()).b;
    }

    public final com.google.android.libraries.navigation.internal.oe.x t() {
        v vVar = (v) this.e.get();
        return new com.google.android.libraries.navigation.internal.oe.x(vVar.h, vVar.i, vVar.j);
    }

    public final String toString() {
        v vVar = (v) this.e.get();
        String string = new com.google.android.libraries.navigation.internal.oe.x(vVar.h, vVar.i, vVar.j).toString();
        float f = vVar.q;
        com.google.android.libraries.navigation.internal.pd.d dVar = vVar.a;
        return "[" + string + ", " + f + ", " + dVar.m + ", " + dVar.l + ", " + vVar.g + "]";
    }

    public final com.google.android.libraries.navigation.internal.oe.x u() {
        z();
        v vVar = (v) this.e.get();
        return new com.google.android.libraries.navigation.internal.oe.x(vVar.k, vVar.l, vVar.m);
    }

    public final com.google.android.libraries.navigation.internal.oe.bc v() {
        z();
        return ((v) this.e.get()).u;
    }

    public final com.google.android.libraries.navigation.internal.pd.d w() {
        return ((v) this.e.get()).a;
    }

    public final v x() {
        return (v) this.e.get();
    }

    protected final void z() {
        if (this.g && !cc.b()) {
            new IllegalStateException("Camera method called from wrong thread.");
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1321)).p("Camera method called from wrong thread.");
        }
    }

    public u(u uVar) {
        this.g = false;
        this.h = new t();
        this.e = new AtomicReference((v) uVar.e.get());
        this.f = null;
    }
}
