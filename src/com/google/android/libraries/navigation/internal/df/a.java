package com.google.android.libraries.navigation.internal.df;

import com.google.android.libraries.navigation.internal.de.x;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a {
    protected static final float[] a = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public float f;
    public float k;
    public final float[] b = new float[3];
    protected final x c = new x();
    public final x d = new x();
    public float[] e = new float[9];
    public final x g = new x();
    public final float[] h = new float[9];
    public final x i = new x();
    public float[] j = null;
    public long l = Long.MIN_VALUE;
    public long m = Long.MIN_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected long f392n = Long.MIN_VALUE;
    public boolean o = false;
    protected boolean p = false;
    protected float q = 0.02f;
    protected c r = null;
    public f s = null;
    public float t = Float.NaN;
    public long u = 0;
    public float v = Float.NaN;

    public abstract float a(int i, float[] fArr);

    public final void b(long j) {
        if (!this.o || this.j == null) {
            return;
        }
        long j2 = this.f392n;
        if (j2 == Long.MIN_VALUE || j - j2 >= 30) {
            this.q = 0.02f;
            f fVar = this.s;
            if (fVar != null && fVar.e()) {
                float fA = this.s.a();
                float f = this.v;
                if (Float.isNaN(f)) {
                    this.v = fA;
                } else {
                    this.v = d.a(0.988f, f, fA);
                }
                if (fA >= 40.0f) {
                    this.q = 0.0f;
                }
            }
            x xVar = this.g;
            x xVar2 = this.i;
            if (xVar.a(xVar2) < 0.0f) {
                xVar2.a = -xVar2.a;
                xVar2.b = -xVar2.b;
                xVar2.c = -xVar2.c;
                xVar2.d = -xVar2.d;
            }
            float f2 = this.q;
            float f3 = xVar.d;
            float f4 = -xVar2.a;
            float f5 = xVar.a;
            float f6 = xVar2.d;
            float f7 = xVar.b;
            float f8 = -xVar2.c;
            float f9 = f7 * f8;
            float f10 = xVar.c;
            float f11 = -xVar2.b;
            float f12 = f7 * f6;
            float f13 = f5 * f11;
            float f14 = f7 * f4;
            float f15 = f7 * f11;
            float f16 = (((f3 * f4) + (f5 * f6)) + f9) - (f10 * f11);
            xVar.a = f16;
            float f17 = ((f3 * f11) - (f5 * f8)) + f12 + (f10 * f4);
            xVar.b = f17;
            float f18 = (((f3 * f8) + f13) - f14) + (f10 * f6);
            xVar.c = f18;
            float f19 = (((f3 * f6) - (f5 * f4)) - f15) - (f10 * f8);
            xVar.d = f19;
            float f20 = 1.0f - f2;
            double dAcos = (f19 > 1.0f || f19 < -1.0f) ? 0.0d : Math.acos(f19);
            double d = f20;
            double dSin = Math.sin(dAcos);
            double dSin2 = dSin != 0.0d ? Math.sin(d * dAcos) / dSin : 1.0d;
            xVar.a = (float) (((double) f16) * dSin2);
            xVar.b = (float) (((double) f17) * dSin2);
            xVar.c = (float) (((double) f18) * dSin2);
            xVar.d = (float) Math.cos(d * dAcos);
            xVar.e(xVar, xVar2);
            xVar.f(xVar);
            this.p = true;
            this.f392n = j;
        }
    }

    public final void c(long j, int i) {
        long millis = TimeUnit.NANOSECONDS.toMillis(j);
        float[] fArr = this.j;
        if (fArr == null) {
            return;
        }
        if (!this.o) {
            float[] fArr2 = a;
            this.e = fArr2;
            this.c.d(fArr2);
            this.f = 0.0f;
            this.r = new c(j);
            System.arraycopy(fArr, 0, this.h, 0, 9);
            this.g.d(this.h);
            this.o = true;
            return;
        }
        this.d.g();
        x xVar = this.d;
        float[] fArr3 = this.b;
        c cVar = this.r;
        ar.q(cVar);
        float f = (j - cVar.d) * 1.0E-9f;
        if (f > 0.04f) {
            f = cVar.c ? cVar.a : 0.01f;
        } else {
            int i2 = cVar.b;
            if (i2 == 0) {
                cVar.a = f;
                cVar.b = 1;
            } else {
                cVar.a = d.a(0.95f, cVar.a, f);
                int i3 = i2 + 1;
                cVar.b = i3;
                if (i3 >= 10.0f) {
                    cVar.c = true;
                }
            }
        }
        cVar.d = j;
        xVar.c(fArr3, f);
        x xVar2 = this.c;
        xVar2.e(xVar2, this.d);
        xVar2.f(xVar2);
        x xVar3 = this.g;
        xVar3.e(xVar3, this.d);
        xVar3.f(xVar3);
        this.c.b(this.e);
        float fA = a(i, this.e);
        this.f = fA;
        f fVar = this.s;
        if (fVar != null) {
            fVar.c(fA, millis);
        }
        if (millis - this.u > 1000) {
            this.g.b(this.h);
            a(i, this.h);
            f fVar2 = this.s;
            if (fVar2 != null) {
                fVar2.a();
                fVar2.b();
                fVar2.o.a();
                fVar2.f393n.a();
            }
            this.u = millis;
        }
        b(millis);
    }

    public final void d() {
        this.c.g();
        this.g.g();
        this.o = false;
        this.p = false;
        this.f392n = Long.MIN_VALUE;
        this.q = 0.02f;
        this.r = null;
    }

    public abstract void e(float f, float f2, float f3, long j);

    public final void f(float[] fArr, int i, long j) {
        f fVar = this.s;
        if (fVar != null) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            float f4 = i;
            if (!Float.isNaN(fSqrt) && !Float.isNaN(f4)) {
                float f5 = fVar.d;
                if (Float.isNaN(f5)) {
                    fVar.d = f4;
                } else {
                    fVar.d = d.a(0.8f, f5, f4);
                }
                float f6 = fVar.e;
                if (Float.isNaN(f6)) {
                    fVar.e = fSqrt;
                } else {
                    fVar.e = d.a(0.8f, f6, fSqrt);
                }
                fVar.f = j;
                fVar.d(Long.valueOf(j));
            }
        }
        b(j);
    }

    public final boolean g(long j) {
        return this.p && TimeUnit.MILLISECONDS.toSeconds(j - this.l) <= 1;
    }
}
