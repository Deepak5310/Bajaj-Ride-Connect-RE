package com.google.android.libraries.navigation.internal.dp;

import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.ace.bk;
import com.google.android.libraries.navigation.internal.ace.bm;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.afl.ds;
import com.google.android.libraries.navigation.internal.afl.fk;
import com.google.android.libraries.navigation.internal.afl.fl;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.dr.ad;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Optional;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    private static final com.google.android.libraries.navigation.internal.zb.j C = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dp.k");
    public com.google.android.libraries.navigation.internal.cr.f B;
    private final bk D;
    private final com.google.android.libraries.navigation.internal.ace.y E;
    private final com.google.android.libraries.navigation.internal.hn.r F;
    private final com.google.android.libraries.navigation.internal.hn.r G;
    private final com.google.android.libraries.navigation.internal.fr.e H;
    private final com.google.android.libraries.navigation.internal.iv.f I;
    private final com.google.android.libraries.navigation.internal.ay.a J;
    private final com.google.android.libraries.navigation.internal.mj.a K;
    private final com.google.android.libraries.navigation.internal.cw.a L;
    private com.google.android.libraries.navigation.internal.dr.l M;
    public final ds a;
    public final boolean b;
    public final com.google.android.libraries.navigation.internal.ia.e c;
    public final Optional d;
    public final Executor e;
    public final com.google.android.libraries.navigation.internal.afo.a f;
    public final com.google.android.libraries.navigation.internal.ed.b g;
    public com.google.android.libraries.navigation.internal.oa.k h;
    public com.google.android.libraries.navigation.internal.oo.b i;
    public com.google.android.libraries.navigation.internal.afo.a j;
    public com.google.android.libraries.navigation.internal.afo.a k;
    public Resources l;
    com.google.android.libraries.navigation.internal.dr.z m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    com.google.android.libraries.navigation.internal.dr.ab f404n;
    volatile ad o;
    public volatile com.google.android.libraries.navigation.internal.dr.i p;
    boolean r;
    boolean s;
    public boolean t;
    public volatile com.google.android.libraries.navigation.internal.dt.c q = com.google.android.libraries.navigation.internal.dt.c.NONE;
    public boolean u = false;
    public boolean v = false;
    public volatile String w = null;
    public volatile boolean x = false;
    boolean y = false;
    private int N = -1;
    final com.google.android.libraries.navigation.internal.aw.c z = com.google.android.libraries.navigation.internal.aw.c.a;
    public final com.google.android.libraries.navigation.internal.nt.t A = new i(this);

    public k(ds dsVar, bk bkVar, com.google.android.libraries.navigation.internal.ace.y yVar, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.hn.r rVar2, com.google.android.libraries.navigation.internal.hn.r rVar3, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fr.e eVar2, com.google.android.libraries.navigation.internal.iv.f fVar, Optional optional, com.google.android.libraries.navigation.internal.ay.a aVar, Executor executor, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.cw.a aVar4, com.google.android.libraries.navigation.internal.ed.b bVar) {
        this.a = dsVar;
        this.D = bkVar;
        this.G = rVar3;
        this.E = yVar;
        this.b = ((qj) rVar.b()).J;
        this.c = eVar;
        this.H = eVar2;
        this.I = fVar;
        this.d = optional;
        this.J = aVar;
        this.e = executor;
        this.K = aVar2;
        this.f = aVar3;
        this.L = aVar4;
        this.F = rVar2;
        this.g = bVar;
    }

    public final com.google.android.libraries.navigation.internal.dr.p a() {
        com.google.android.libraries.navigation.internal.dr.p pVar;
        if (this.r) {
            pVar = this.b ? com.google.android.libraries.navigation.internal.dr.p.d : com.google.android.libraries.navigation.internal.dr.p.c;
        } else {
            pVar = this.b ? com.google.android.libraries.navigation.internal.dr.p.b : com.google.android.libraries.navigation.internal.dr.p.a;
        }
        if (!this.h.k.i()) {
            return pVar;
        }
        com.google.android.libraries.navigation.internal.dr.p pVar2 = new com.google.android.libraries.navigation.internal.dr.p(pVar);
        pVar2.i = com.google.android.libraries.navigation.internal.f.c.e;
        return pVar2;
    }

    final ad b() {
        if (this.m == null) {
            this.m = new com.google.android.libraries.navigation.internal.dr.z(this.l, this.h.b().a(), this.F, this.i, this.B);
        }
        com.google.android.libraries.navigation.internal.dr.o oVar = new com.google.android.libraries.navigation.internal.dr.o(a(), this.m);
        if (this.q == com.google.android.libraries.navigation.internal.dt.c.NAVIGATION_CUSTOM_3D_CHEVRON && !this.x && this.I.w(com.google.android.libraries.navigation.internal.iv.ab.bR) && this.I.w(com.google.android.libraries.navigation.internal.iv.ab.bQ)) {
            int iA = this.I.a(com.google.android.libraries.navigation.internal.iv.ab.bQ, 0);
            this.I.i(com.google.android.libraries.navigation.internal.iv.ab.bR, "");
            com.google.android.libraries.navigation.internal.ay.a aVar = this.J;
            if (aVar != null) {
                fl flVar = aVar.a.b().a.aA;
                if (flVar == null) {
                    flVar = fl.a;
                }
                for (fk fkVar : flVar.b) {
                    if (fkVar.b == iA) {
                        String str = fkVar.c;
                        break;
                    }
                }
            }
            com.google.android.libraries.navigation.internal.aw.a aVar2 = (com.google.android.libraries.navigation.internal.aw.a) this.d.orElse(null);
            if (aVar2 != null) {
                bm bmVarB = bm.b(((hm) this.G.b()).f);
                if (bmVarB == null) {
                    bmVarB = bm.UNKNOWN_ENABLED_STATE;
                }
                bmVarB.equals(bm.ENABLED);
                ((com.google.android.libraries.navigation.internal.po.fk) this.h.b()).J.p();
                com.google.android.libraries.navigation.internal.yu.c.d(aVar2.b().a, new j(), this.e);
            }
        }
        Resources resources = this.l;
        boolean z = this.t;
        String str2 = this.w;
        boolean z2 = this.u;
        com.google.android.libraries.navigation.internal.aw.c cVar = this.q == com.google.android.libraries.navigation.internal.dt.c.NAVIGATION_CUSTOM_3D_CHEVRON ? this.z : com.google.android.libraries.navigation.internal.aw.c.a;
        com.google.android.libraries.navigation.internal.pi.s sVar = this.h.h;
        com.google.android.libraries.navigation.internal.ia.e eVar = this.c;
        bk bkVar = this.D;
        bm bmVarB2 = bm.b(((hm) this.G.b()).f);
        if (bmVarB2 == null) {
            bmVarB2 = bm.UNKNOWN_ENABLED_STATE;
        }
        bmVarB2.equals(bm.ENABLED);
        return new ad(resources, oVar, z, str2, z2, cVar, sVar, eVar, bkVar, this.e);
    }

    public final void c(int i) {
        com.google.android.libraries.navigation.internal.dr.ab abVar = this.f404n;
        if (abVar != null) {
            abVar.b.c.d = i;
        }
        this.N = i;
    }

    final boolean d(com.google.android.libraries.navigation.internal.dt.b bVar) {
        boolean zJ;
        com.google.android.libraries.navigation.internal.dr.ab abVar = this.f404n;
        if (abVar == null) {
            if (this.m == null) {
                this.m = new com.google.android.libraries.navigation.internal.dr.z(this.l, this.h.b().a(), this.F, this.i, this.B);
            }
            if (this.M == null) {
                this.M = new com.google.android.libraries.navigation.internal.dr.l(this.m);
            }
            com.google.android.libraries.navigation.internal.oo.b bVar2 = this.i;
            if (bVar2 == null || !bVar2.s().c()) {
                zJ = this.h.J(com.google.android.libraries.navigation.internal.ob.h.SATELLITE);
            } else {
                com.google.android.libraries.navigation.internal.afo.a aVar = this.j;
                ar.q(aVar);
                zJ = ((com.google.android.libraries.navigation.internal.ok.b) aVar.a()).c(com.google.android.libraries.navigation.internal.ob.h.SATELLITE);
            }
            this.f404n = new com.google.android.libraries.navigation.internal.dr.ab(this.a, this.h.h, this.c, this.l, this.M, zJ, this.N, this.H, this.I, bVar, this.b, this.e);
        } else if (bVar.t != abVar.d()) {
            com.google.android.libraries.navigation.internal.dr.ab abVar2 = this.f404n;
            abVar2.a.a.e(abVar2.e, bVar.u);
            abVar2.a.a.e(abVar2.g, bVar.w);
            abVar2.a.a.e(abVar2.f, bVar.z);
            abVar2.e.e = bVar.v;
            abVar2.g.e = bVar.x;
            abVar2.b.c.b = bVar.y;
            abVar2.h = com.google.android.libraries.navigation.internal.dr.ab.e(bVar.t);
            synchronized (abVar2) {
                abVar2.d = bVar;
            }
        }
        this.f404n.b(true);
        if (this.p == this.f404n) {
            return false;
        }
        if (this.p != null) {
            this.p.b(false);
        }
        this.p = this.f404n;
        return true;
    }

    public final boolean e() {
        boolean z;
        boolean z2;
        com.google.android.libraries.navigation.internal.dt.c cVar = this.q;
        com.google.android.libraries.navigation.internal.dt.c cVar2 = com.google.android.libraries.navigation.internal.dt.c.NAVIGATION_CUSTOM_3D_CHEVRON;
        boolean z3 = cVar == cVar2;
        com.google.android.libraries.navigation.internal.afo.a aVar = this.k;
        boolean zF = aVar != null ? ((com.google.android.libraries.navigation.internal.oi.c) aVar.a()).f() : this.h.K();
        if (this.r != zF) {
            this.r = zF;
            z = true;
        } else {
            z = false;
        }
        boolean z4 = this.s;
        if (z4 == z3 && z4 == this.x) {
            z2 = false;
        } else {
            if (this.x && cVar == cVar2) {
                this.s = true;
            } else if (cVar != cVar2) {
                this.s = false;
            }
            z2 = true;
        }
        if (this.o == null) {
            this.o = b();
        } else if (z2) {
            this.o.d();
            this.o = b();
            if (this.y && this.s) {
                ad adVar = this.o;
                ar.q(adVar);
                adVar.e();
                this.y = false;
            }
        } else if (z) {
            this.o.f(a());
        }
        boolean z5 = this.p != this.o;
        ad adVar2 = this.o;
        ar.q(adVar2);
        this.p = adVar2;
        this.p.b(true);
        return z5;
    }
}
