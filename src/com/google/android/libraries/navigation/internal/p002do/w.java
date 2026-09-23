package com.google.android.libraries.navigation.internal.p002do;

import com.google.android.libraries.navigation.internal.db.m;
import com.google.android.libraries.navigation.internal.nq.a;
import com.google.android.libraries.navigation.internal.oe.b;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oe.y;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements t {
    public boolean c;
    public long d;
    public long e;
    public m j;
    public x k;
    public m l;
    public b p;
    public b q;
    public b r;
    public b s;
    public boolean t;
    public final v a = new v();
    public final v b = new v();
    public long f = -1000;
    public long g = -1000;
    public long h = -4611686018427387904L;
    public boolean i = false;
    public boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f402n = new b(0.0d);
    public long u = -1000;
    public double v = 0.0d;
    public double w = 0.0d;
    public double x = 0.0d;
    public boolean y = false;
    public final b o = null;

    public w(boolean z) {
    }

    public static double a(m mVar, double d, x xVar) {
        x xVar2 = new x();
        double radians = Math.toRadians(90.0d - (mVar.b(d, xVar2, 100.0d) + 90.0d));
        x xVarU = xVar2.u(new x((int) Math.round(Math.cos(radians) * 100.0d), (int) Math.round(Math.sin(radians) * 100.0d)));
        return x.m(xVar2, xVarU, xVar) * xVar2.h(xVarU);
    }

    public static double b(m mVar, x xVar, b bVar, b bVar2, double d) {
        double dB = mVar.b(bVar.e(d), xVar, 100.0d);
        if (bVar2 != null) {
            double dE = bVar2.e(d);
            double radians = Math.toRadians(90.0d - (dB + 90.0d));
            xVar.S(new x((int) Math.round(Math.cos(radians) * dE), (int) Math.round(dE * Math.sin(radians))));
        }
        return dB;
    }

    public static void d(b bVar) {
        if (bVar != null) {
            bVar.i(bVar.e(0.0d), 0.0d, bVar.e(0.0d), 0.0d);
        }
    }

    public final double c(long j) {
        long j2 = this.f;
        long j3 = this.g;
        return j2 >= j3 ? Math.max(0.0d, Math.min(1.0d, (j - j3) / 1000.0d)) : 1.0d - Math.max(0.0d, Math.min(1.0d, (j - j2) / 1000.0d));
    }

    public final void e(long j, double d, double d2, double d3, v vVar) {
        float fD;
        float fD2;
        float fD3;
        x xVar;
        boolean z = d2 >= -0.05d;
        Double dValueOf = Double.valueOf(d2);
        ar.b(z, dValueOf);
        ar.b(d2 <= 1.05d, dValueOf);
        m mVar = this.j;
        m mVar2 = this.l;
        b bVar = this.q;
        ar.q(bVar);
        b bVar2 = this.r;
        ar.q(bVar2);
        double dMin = Math.min(d, 3.0d);
        if (mVar == null) {
            vVar.d = (float) bVar.c(dMin);
            vVar.e = (float) bVar2.c(dMin);
            b bVar3 = this.s;
            xVar = null;
            if (bVar3 != null) {
                fD3 = (float) bVar3.c(dMin);
                fD2 = a.d((float) this.s.e(dMin));
            } else {
                fD3 = 0.0f;
                fD2 = 0.0f;
            }
        } else {
            double d4 = dMin + 1.0d;
            x xVar2 = new x();
            float fB = (float) b(mVar, xVar2, this.f402n, this.o, dMin);
            b bVar4 = this.f402n;
            float fD4 = a.d(fB);
            double dAbs = Math.abs(bVar4.c(dMin));
            double radians = Math.toRadians(fD4);
            bVar2 = bVar2;
            vVar.d = (float) (dAbs * Math.sin(radians));
            vVar.e = (float) (dAbs * Math.cos(radians));
            if (mVar2 != null) {
                float fB2 = (float) b(mVar2, new x(), bVar4, this.o, dMin);
                b bVar5 = this.f402n;
                float fD5 = a.d(fB2);
                fD = a.d((float) mVar2.b(bVar5.e(d4), null, 100.0d));
                dMin = dMin;
                fD2 = fD5;
            } else {
                dMin = dMin;
                fD = a.d((float) mVar.b(bVar4.e(d4), null, 100.0d));
                fD2 = fD4;
            }
            fD3 = y.d(fD2, fD);
            xVar = xVar2;
        }
        x xVar3 = new x((int) Math.round(bVar.e(dMin)), (int) Math.round(bVar2.e(dMin)));
        if ((mVar == null || (mVar.c && !this.i)) && this.o == null && (xVar = this.k) != null) {
            xVar3 = xVar;
        } else if (xVar != null) {
            x xVar4 = new x();
            x.H(xVar3, xVar, (float) d2, xVar4);
            xVar3 = xVar4;
        }
        vVar.a = xVar3;
        b bVar6 = this.p;
        if (bVar6 != null) {
            double dMin2 = Math.min(d3, 0.5d);
            fD2 = a.d((float) bVar6.e(dMin2));
            fD3 = (float) bVar6.c(dMin2);
        }
        vVar.b = j;
        vVar.c = fD2;
        vVar.f = fD3;
    }

    public final boolean f() {
        return (this.s == null && this.p == null) ? false : true;
    }
}
