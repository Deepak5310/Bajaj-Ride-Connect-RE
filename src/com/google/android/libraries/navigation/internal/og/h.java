package com.google.android.libraries.navigation.internal.og;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.pb.aa;
import com.google.android.libraries.navigation.internal.pb.ab;
import com.google.android.libraries.navigation.internal.pb.z;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends n {
    static final Interpolator a = com.google.android.libraries.navigation.internal.k.b.a;
    private final j m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final i f495n;

    public h(com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.oq.d dVar) {
        super(aVar);
        j jVar = new j(new ab(), dVar);
        this.m = jVar;
        this.f495n = new i(a, jVar.d);
    }

    @Override // com.google.android.libraries.navigation.internal.og.n, com.google.android.libraries.navigation.internal.pc.c
    public final boolean d() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.og.n
    public final void f(TimeInterpolator timeInterpolator) {
        super.f(timeInterpolator);
        this.f495n.a = timeInterpolator;
        synchronized (this.l) {
            this.g.setInterpolator(this.f495n);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.og.n
    public final boolean m(com.google.android.libraries.navigation.internal.oq.f fVar, com.google.android.libraries.navigation.internal.oq.f fVar2) {
        boolean zM;
        synchronized (this.l) {
            zM = super.m(fVar, fVar2);
            f(a);
            j jVar = this.m;
            ar.q(fVar);
            ar.q(fVar2);
            com.google.android.libraries.navigation.internal.oq.f fVarC = jVar.b.c(fVar);
            com.google.android.libraries.navigation.internal.oq.f fVarC2 = jVar.b.c(fVar2);
            jVar.g = fVarC;
            jVar.h = fVarC2;
            com.google.android.libraries.navigation.internal.rf.g gVarC = jVar.a.c();
            jVar.e = gVarC.a();
            jVar.f = gVarC.c();
            float fD = gVarC.d();
            float f = ((com.google.android.libraries.navigation.internal.oq.b) fVarC).e;
            float f2 = ((com.google.android.libraries.navigation.internal.oq.b) fVarC2).e;
            float fMin = Math.min(f, f2);
            float fMax = Math.max(f, f2);
            float fA = jVar.a(f);
            float fA2 = jVar.a(((com.google.android.libraries.navigation.internal.oq.b) fVarC2).e);
            jVar.k = Math.min(fA, fA2);
            gVarC.a();
            float fT = com.google.android.libraries.navigation.internal.pb.j.t(gVarC.b(), Math.max(jVar.f, fD));
            aa aaVar = jVar.c;
            z zVarA = aa.a(fT, fMin, x.z(((com.google.android.libraries.navigation.internal.oq.b) fVarC).a), x.z(((com.google.android.libraries.navigation.internal.oq.b) fVarC2).a));
            float fMin2 = Math.min(fMin, jVar.b.b(fMin - zVarA.c, x.z(((com.google.android.libraries.navigation.internal.oq.b) fVarC).a)));
            float fA3 = jVar.a(fMin2);
            jVar.j = fA3 - jVar.k;
            jVar.d.d((fA3 - fA) * 1.0E-6f, (fA3 - fA2) * 1.0E-6f);
            jVar.i = ((long) (Math.min(1.0f, ((zVarA.a * 0.5f) / zVarA.b) + (((fMax - fMin2) * 0.5f) / 4.0f)) * 1200.0f)) + 800;
            o(this.m.i);
            this.h.setEvaluator(this.m);
            q(1, true);
            q(2, true);
            q(3, true);
            q(4, true);
            q(5, false);
        }
        return zM;
    }
}
