package com.google.android.libraries.navigation.internal.rf;

import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.bc;
import com.google.android.libraries.navigation.internal.oe.q;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oq.i;
import com.google.android.libraries.navigation.internal.pb.j;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public final t a;

    public g(com.google.android.libraries.navigation.internal.oq.f fVar, int i, int i2, float f) {
        this.a = new t(com.google.android.libraries.navigation.internal.pd.d.c(fVar), i, i2, f);
    }

    public final float a() {
        return this.a.i();
    }

    public final float b() {
        return this.a.n();
    }

    public final int c() {
        return this.a.r();
    }

    public final int d() {
        return this.a.s();
    }

    public final q e(float f, float f2) {
        x xVarJ = j.j(this.a, f, f2, new float[8]);
        if (xVarJ != null) {
            return new q(xVarJ);
        }
        return null;
    }

    public final ay f(x xVar) {
        float[] fArr = new float[8];
        if (j.m(this.a, xVar, fArr)) {
            return new ay(fArr[0], fArr[1]);
        }
        return null;
    }

    public final com.google.android.libraries.navigation.internal.oq.f g() {
        return com.google.android.libraries.navigation.internal.pd.d.b(this.a.w());
    }

    public final i h() {
        q qVar;
        com.google.android.libraries.navigation.internal.oq.b bVar = (com.google.android.libraries.navigation.internal.oq.b) g();
        com.google.android.libraries.navigation.internal.oq.j jVar = bVar.d;
        int iD = d();
        int iC = c();
        float fB = b();
        float fA = a();
        double d = fA;
        double dTan = 0.5d / Math.tan((d * 0.017453292519943295d) * 0.5d);
        float f = bVar.b;
        double d2 = ((double) bVar.c) * 0.017453292519943295d;
        double dSin = Math.sin(d2);
        double d3 = (90.0d - ((double) f)) * 0.017453292519943295d;
        double dCos = Math.cos(d3) * dSin;
        double dSin2 = dSin * Math.sin(d3);
        double d4 = -Math.cos(d2);
        double dTan2 = 1.0d / Math.tan((d * 0.5d) * 0.017453292519943295d);
        double dAtan2 = Math.atan2(((com.google.android.libraries.navigation.internal.oq.c) bVar.d).b, dTan2);
        double dSin3 = Math.sin(dAtan2) / Math.sin((3.141592653589793d - (1.5707963267948966d - d2)) - dAtan2);
        float f2 = iC;
        double dPow = Math.pow(2.0d, 30.0f - bVar.e) * ((double) (f2 / (fB * 256.0f)));
        x xVarZ = x.z(bVar.a);
        double d5 = xVarZ.a;
        double d6 = f * 0.017453292f;
        float fSin = (float) Math.sin(d6);
        double d7 = xVarZ.b;
        float fCos = (float) Math.cos(d6);
        int i = xVarZ.c;
        float f3 = (float) dTan;
        float f4 = (float) (((double) f3) * dPow);
        if (f4 > 2.1474835E9f) {
            f4 = 2.1474835E9f;
        }
        double d8 = -f4;
        double d9 = dSin3 * dPow * 0.5d * dTan2;
        double d10 = d7 + (d9 * ((double) fCos));
        int i2 = (int) (d5 + (((double) fSin) * d9));
        long jRound = Math.round(dCos * d8) + ((long) i2);
        int i3 = (int) d10;
        long jRound2 = Math.round(dSin2 * d8) + ((long) i3);
        int iRound = (int) (Math.round(d8 * d4) + ((long) i));
        float f5 = iRound;
        float f6 = 1.0f / f5;
        ar.k(f6 >= 0.0f);
        float f7 = bVar.b;
        float f8 = bVar.c;
        float[] fArr = new float[16];
        com.google.android.libraries.navigation.internal.rq.f.f(fArr);
        float f9 = iD;
        float f10 = f9 * 0.5f;
        fArr[0] = f10;
        float f11 = f2 * 0.5f;
        fArr[5] = -f11;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
        fArr[12] = f10;
        fArr[13] = f11;
        float f12 = iC == 0 ? 1.0f : f9 / f2;
        float f13 = ((com.google.android.libraries.navigation.internal.oq.c) jVar).a;
        float f14 = f13 + 1.0f;
        float fTan = ((float) Math.tan(Math.toRadians(d) / 2.0d)) * 0.1f;
        float f15 = fTan * f12 * (1.0f - f13);
        float f16 = -fTan;
        float f17 = f12 * f16 * f14;
        float f18 = f15 - f17;
        float f19 = fTan - f16;
        float[] fArr2 = {0.2f / f18, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f / f19, 0.0f, 0.0f, (f15 + f17) / f18, (fTan + f16) / f19, -1.0100503f, -1.0f, 0.0f, 0.0f, -0.20100503f, 0.0f};
        double d11 = (90.0d - ((double) f7)) * 0.017453292519943295d;
        float fCos2 = (float) Math.cos(d11);
        float fSin2 = (float) Math.sin(d11);
        if (f8 == 0.0f) {
            qVar = new q(Math.round(fCos2 * 65536.0f), Math.round(fSin2 * 65536.0f));
        } else {
            double d12 = ((double) f8) * 0.017453292519943295d;
            float fCos3 = (float) Math.cos(d12);
            qVar = new q(Math.round(fCos2 * fCos3 * 65536.0f), Math.round(fSin2 * fCos3 * 65536.0f), Math.round((float) (Math.sin(d12) * 65536.0d)));
        }
        int i4 = (int) jRound2;
        int i5 = (int) jRound;
        float f20 = -((i5 - i2) * f6);
        float f21 = -((i4 - i3) * f6);
        float f22 = -((iRound - i) * f6);
        float fA2 = 1.0f / com.google.android.libraries.navigation.internal.rq.f.a(f20, f21, f22);
        float f23 = f20 * fA2;
        float f24 = f21 * fA2;
        float f25 = fA2 * f22;
        float f26 = qVar.b;
        float f27 = qVar.a;
        float f28 = f24 * f27;
        float f29 = qVar.c;
        float f30 = f23 * f29;
        float f31 = (f29 * f24) - (f26 * f25);
        float f32 = (f27 * f25) - f30;
        float f33 = (f23 * f26) - f28;
        float fA3 = 1.0f / com.google.android.libraries.navigation.internal.rq.f.a(f31, f32, f33);
        float f34 = f31 * fA3;
        float f35 = f33 * fA3;
        float f36 = f32 * fA3;
        float[] fArr3 = {f34, (f36 * f25) - (f35 * f24), -f23, 0.0f, f36, (f35 * f23) - (f34 * f25), -f24, 0.0f, f35, (f24 * f34) - (f23 * f36), -f25, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        com.google.android.libraries.navigation.internal.rq.f.g(fArr3, f20, f21, f22);
        com.google.android.libraries.navigation.internal.rq.f.c(new float[16], fArr2, fArr3);
        float[] fArr4 = new float[16];
        float[] fArr5 = new float[16];
        com.google.android.libraries.navigation.internal.rq.f.c(fArr4, fArr, fArr2);
        com.google.android.libraries.navigation.internal.rq.f.c(fArr5, fArr4, fArr3);
        for (int i6 = 12; i6 < 16; i6++) {
            fArr5[i6] = fArr5[i6] * f5;
        }
        float[] fArr6 = new float[16];
        com.google.android.libraries.navigation.internal.rq.f.b(fArr6, fArr5);
        bc bcVar = new bc(new x[]{new x(), new x(), new x(), new x()});
        float f37 = bVar.c;
        float[] fArr7 = new float[8];
        float fCeil = (float) Math.ceil((((double) iC) * 0.5d) - ((double) ((f2 * f3) * ((float) Math.tan((Math.min(Math.min((fA * 0.5f) + f37, 82.5f), 90.0f) - f37) * 0.017453292f)))));
        boolean zA = a.a(0.0f, f2, i2, i3, i5, i4, iRound, fArr6, bcVar.b(0), fArr7);
        boolean zA2 = a.a(f9, f2, i2, i3, i5, i4, iRound, fArr6, bcVar.b(1), fArr7);
        boolean zA3 = a.a(f9, fCeil, i2, i3, i5, i4, iRound, fArr6, bcVar.b(2), fArr7);
        boolean zA4 = a.a(0.0f, fCeil, i2, i3, i5, i4, iRound, fArr6, bcVar.b(3), fArr7);
        if (!zA || !zA2 || !zA3 || !zA4) {
            bcVar.b(0).J(0, 0);
            bcVar.b(1).J(0, 0);
            bcVar.b(2).J(0, 0);
            bcVar.b(3).J(0, 0);
            bcVar.f();
        }
        bcVar.f();
        return new i(bcVar);
    }

    public final g i(com.google.android.libraries.navigation.internal.oq.f fVar) {
        return new g(this.a, fVar);
    }

    public g(t tVar) {
        this.a = new t(tVar);
    }

    private g(t tVar, com.google.android.libraries.navigation.internal.oq.f fVar) {
        t tVar2 = new t(tVar);
        this.a = tVar2;
        tVar2.B(com.google.android.libraries.navigation.internal.pd.d.c(fVar));
    }
}
