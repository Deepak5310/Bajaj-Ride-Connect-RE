package com.google.android.libraries.navigation.internal.pb;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends x {
    static final Interpolator a = com.google.android.libraries.navigation.internal.k.b.a;
    private final s m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final r f513n;

    public q(com.google.android.libraries.navigation.internal.ni.a aVar, t tVar) {
        super(aVar);
        s sVar = new s(new ab(), tVar);
        this.m = sVar;
        this.f513n = new r(a, sVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final boolean d() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x
    public final void f(TimeInterpolator timeInterpolator) {
        super.f(timeInterpolator);
        this.f513n.a = timeInterpolator;
        synchronized (this.l) {
            this.g.setInterpolator(this.f513n);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x
    public final boolean m(com.google.android.libraries.navigation.internal.pd.d dVar, com.google.android.libraries.navigation.internal.pd.d dVar2) {
        boolean zM;
        synchronized (this.l) {
            zM = super.m(dVar, dVar2);
            f(a);
            s sVar = this.m;
            ar.q(dVar);
            ar.q(dVar2);
            m mVar = sVar.a.b;
            com.google.android.libraries.navigation.internal.pd.d dVarD = mVar.d(dVar);
            com.google.android.libraries.navigation.internal.pd.d dVarD2 = mVar.d(dVar2);
            sVar.f = dVarD;
            sVar.g = dVarD2;
            sVar.d = sVar.a.i();
            sVar.e = sVar.a.r();
            float fS = sVar.a.s();
            float f = dVarD.k;
            float f2 = dVarD2.k;
            float fMin = Math.min(f, f2);
            float fMax = Math.max(f, f2);
            float fA = sVar.a(f);
            float fA2 = sVar.a(dVarD2.k);
            sVar.j = Math.min(fA, fA2);
            sVar.a.i();
            float fT = j.t(sVar.a.n(), Math.max(sVar.e, fS));
            aa aaVar = sVar.b;
            z zVarA = aa.a(fT, fMin, dVarD.j, dVarD2.j);
            float fMin2 = Math.min(fMin, mVar.c(fMin - zVarA.c, dVarD.j));
            float fA3 = sVar.a(fMin2);
            sVar.i = fA3 - sVar.j;
            sVar.c.d((fA3 - fA) * 1.0E-6f, (fA3 - fA2) * 1.0E-6f);
            sVar.h = ((long) (Math.min(1.0f, ((zVarA.a * 0.5f) / zVarA.b) + (((fMax - fMin2) * 0.5f) / 4.0f)) * 1200.0f)) + 800;
            p(this.m.h);
            this.h.setEvaluator(this.m);
            r(1, true);
            r(2, true);
            r(3, true);
            r(4, true);
            r(5, false);
        }
        return zM;
    }

    public final boolean n() {
        return super.s(1);
    }
}
