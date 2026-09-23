package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.bp.cj;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.sp.b {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final com.google.android.libraries.navigation.internal.iv.f b;
    public final aw c;
    public final bg d;
    public final ao e;
    public final aq f;
    public final com.google.android.libraries.navigation.internal.fz.d g;
    private final com.google.android.libraries.navigation.internal.jy.af h;
    private final m i;
    private final Executor j;
    private final com.google.android.libraries.navigation.internal.av.a k;

    public g(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.av.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, aw awVar, bg bgVar, ao aoVar, aq aqVar, m mVar, com.google.android.libraries.navigation.internal.fz.d dVar, Executor executor) {
        this.a = eVar;
        this.b = fVar;
        this.k = aVar;
        this.h = afVar;
        this.c = awVar;
        this.d = bgVar;
        this.e = aoVar;
        this.f = aqVar;
        this.i = mVar;
        this.g = dVar;
        this.j = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        fd fdVarK = fd.k(com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, this.j);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.cw.d.class, new i(0, com.google.android.libraries.navigation.internal.cw.d.class, this, com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, i.b(com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.e.class, new i(1, com.google.android.libraries.navigation.internal.sr.e.class, this, apVar, i.b(apVar, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar2 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.j.class, new i(2, com.google.android.libraries.navigation.internal.sr.j.class, this, apVar2, i.b(apVar2, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar3 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sw.g.class, new i(3, com.google.android.libraries.navigation.internal.sw.g.class, this, apVar3, i.b(apVar3, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar4 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.si.g.class, new i(4, com.google.android.libraries.navigation.internal.si.g.class, this, apVar4, i.b(apVar4, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar5 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sw.h.class, new i(5, com.google.android.libraries.navigation.internal.sw.h.class, this, apVar5, i.b(apVar5, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar6 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.p.class, new i(6, com.google.android.libraries.navigation.internal.sr.p.class, this, apVar6, i.b(apVar6, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar7 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.ss.e.class, new i(7, com.google.android.libraries.navigation.internal.ss.e.class, this, apVar7, i.b(apVar7, fdVarK)));
        com.google.android.libraries.navigation.internal.hx.ap apVar8 = com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.i.class, new i(8, com.google.android.libraries.navigation.internal.sr.i.class, this, apVar8, i.b(apVar8, fdVarK)));
        this.a.c(this, fzVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        this.a.e(this);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007b  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void c(com.google.android.libraries.navigation.internal.tj.r rVar) {
        boolean zE;
        com.google.android.libraries.navigation.internal.oe.r rVarT = rVar.a.d().t();
        cj cjVarM = ck.M();
        com.google.android.libraries.navigation.internal.bp.t tVar = (com.google.android.libraries.navigation.internal.bp.t) cjVarM;
        tVar.c = rVarT;
        tVar.a = rVar.a.e();
        tVar.b = rVar.a.c();
        tVar.f = rVar.a.e();
        cjVarM.v(true);
        ck ckVarB = cjVarM.B();
        int i = ev.d;
        eq eqVar = new eq();
        eqVar.h(ckVarB);
        if ((rVar instanceof com.google.android.libraries.navigation.internal.tj.q) || (rVar instanceof com.google.android.libraries.navigation.internal.tj.p)) {
            ev evVarA = rVar.b.b.A();
            int size = evVarA.size();
            int i2 = 0;
            while (i2 < size) {
                ck ckVar = (ck) evVarA.get(i2);
                if (ckVar.X() && ckVarB.X()) {
                    com.google.android.libraries.navigation.internal.oe.j jVarM = ckVar.m();
                    com.google.android.libraries.navigation.internal.oe.j jVar = ((com.google.android.libraries.navigation.internal.bp.u) ckVarB).c;
                    if (jVar == null || jVarM.c != jVar.c) {
                        zE = com.google.android.libraries.navigation.internal.oe.r.e(ckVar.n(), ((com.google.android.libraries.navigation.internal.bp.u) ckVarB).d);
                    } else {
                        zE = true;
                    }
                } else {
                    zE = com.google.android.libraries.navigation.internal.oe.r.e(ckVar.n(), ((com.google.android.libraries.navigation.internal.bp.u) ckVarB).d);
                }
                i2++;
                if (zE) {
                    this.a.a(new com.google.android.libraries.navigation.internal.sr.m(rVar));
                    return;
                }
            }
            com.google.android.libraries.navigation.internal.bp.bg bgVar = rVar.b.b;
            for (int iMax = Math.max(1, bgVar.m() - 8); iMax < bgVar.m(); iMax++) {
                eqVar.h(bgVar.v(iMax));
            }
        }
        com.google.android.libraries.navigation.internal.se.b bVar = rVar.b;
        final m mVar = this.i;
        final ev evVarG = eqVar.g();
        com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
        mVar.b.c();
        final com.google.android.libraries.navigation.internal.ael.x xVarD = mVar.h.d();
        final com.google.android.libraries.navigation.internal.db.r rVarB = ((com.google.android.libraries.navigation.internal.cw.a) mVar.a.a()).b();
        com.google.android.libraries.navigation.internal.aac.bj bjVarA = rVarB == null ? mVar.g.a() : com.google.android.libraries.navigation.internal.aac.az.h(rVarB);
        final com.google.android.libraries.navigation.internal.bp.bg bgVar2 = bVar.b;
        com.google.android.libraries.navigation.internal.aac.az.o(com.google.android.libraries.navigation.internal.aac.j.i(bjVarA, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.sv.l
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj) {
                m mVar2 = mVar;
                boolean zA = mVar2.c.a().a();
                return mVar2.d.a(rVarB, evVarG, bgVar2, xVarD, zA, mVar2.e.b(true));
            }
        }, mVar.f), new f(this, rVar), this.j);
    }

    final void d(boolean z) {
        com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
        if (this.f.m()) {
            this.e.a(new com.google.android.libraries.navigation.internal.tj.s());
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.si.g gVar) {
        if (gVar.f() != null) {
            String str = gVar.f().f;
            if (gVar.h() && str != null) {
                this.h.m(hv.SEARCH, str);
            }
        }
        com.google.android.libraries.navigation.internal.tj.o oVarD = this.f.d();
        com.google.android.libraries.navigation.internal.yx.ar.q(oVarD);
        com.google.android.libraries.navigation.internal.tj.q qVar = new com.google.android.libraries.navigation.internal.tj.q(gVar, oVarD.c());
        c(qVar);
        this.e.a(qVar);
    }

    public final boolean f() {
        return com.google.android.libraries.navigation.internal.av.a.b().a();
    }
}
