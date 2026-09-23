package com.google.android.libraries.navigation.internal.r;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.cw;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.adl.ak;
import com.google.android.libraries.navigation.internal.adl.al;
import com.google.android.libraries.navigation.internal.adl.v;
import com.google.android.libraries.navigation.internal.adq.ad;
import com.google.android.libraries.navigation.internal.adq.ae;
import com.google.android.libraries.navigation.internal.adq.ah;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.ob.u;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.on.q;
import com.google.android.libraries.navigation.internal.ot.o;
import com.google.android.libraries.navigation.internal.pi.s;
import com.google.android.libraries.navigation.internal.vu.p;
import com.google.android.libraries.navigation.internal.yz.ee;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.mh;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.s.b {
    public final Resources a;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final com.google.android.libraries.navigation.internal.afo.a e;
    public final s f;
    public final com.google.android.libraries.navigation.internal.afo.a g;
    public final com.google.android.libraries.navigation.internal.afo.a h;
    public final com.google.android.libraries.navigation.internal.afo.a i;
    public final l j;
    public final com.google.android.libraries.navigation.internal.oa.l k;
    private final r l;
    private final com.google.android.libraries.navigation.internal.afo.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.afo.a f567n;
    private final f o;
    private final mh p;
    private final x q = x.A(0.0d, 0.0d);
    private ev r;

    public m(Executor executor, Resources resources, com.google.android.libraries.navigation.internal.oa.l lVar, s sVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.afo.a aVar5) {
        int i = ev.d;
        this.r = lv.a;
        this.l = null;
        this.a = resources;
        this.k = lVar;
        this.b = aVar;
        this.c = aVar2;
        this.m = null;
        this.d = null;
        this.e = aVar3;
        this.f = sVar;
        this.h = null;
        this.f567n = aVar4;
        this.i = aVar5;
        this.p = new ee();
        this.g = new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.r.a
            @Override // com.google.android.libraries.navigation.internal.afo.a
            public final Object a() {
                return new q(((p) this.a.e).a);
            }
        };
        l lVar2 = new l(this);
        this.j = lVar2;
        this.o = new f(executor, lVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object b(com.google.android.libraries.navigation.internal.ob.r rVar, Object obj, com.google.android.libraries.navigation.internal.oj.h hVar, x xVar, boolean z) {
        dy dyVarB = hVar.b();
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(xVar);
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar = (ef) dyVarB.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        ef efVar2 = ef.a;
        dVar2.getClass();
        efVar.e = dVar2;
        efVar.b |= 8;
        dq dqVar = (dq) dt.a.q();
        dqVar.d(hVar.a(obj));
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar3 = (ef) dyVarB.b;
        dt dtVar = (dt) dqVar.t();
        dtVar.getClass();
        efVar3.c = dtVar;
        efVar3.b |= 1;
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar4 = (ef) dyVarB.b;
        efVar4.b |= 128;
        efVar4.i = Integer.MAX_VALUE;
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar5 = (ef) dyVarB.b;
        efVar5.b |= 64;
        efVar5.h = 1;
        bh bhVar = com.google.android.libraries.navigation.internal.adl.k.a;
        v vVar = (v) com.google.android.libraries.navigation.internal.adl.x.a.q();
        ak akVar = (ak) al.a.q();
        if (!akVar.b.H()) {
            akVar.v();
        }
        al alVar = (al) akVar.b;
        alVar.b |= 1;
        alVar.c = z;
        if (!vVar.b.H()) {
            vVar.v();
        }
        com.google.android.libraries.navigation.internal.adl.x xVar2 = (com.google.android.libraries.navigation.internal.adl.x) vVar.b;
        al alVar2 = (al) akVar.t();
        alVar2.getClass();
        xVar2.d = alVar2;
        xVar2.c = 2;
        if (!vVar.b.H()) {
            vVar.v();
        }
        com.google.android.libraries.navigation.internal.adl.x.c((com.google.android.libraries.navigation.internal.adl.x) vVar.b);
        dyVarB.C(bhVar, (com.google.android.libraries.navigation.internal.adl.x) vVar.t());
        int iOrdinal = rVar.g().ordinal();
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar6 = (ef) dyVarB.b;
        efVar6.b |= 16384;
        efVar6.f186n = iOrdinal;
        if (!rVar.l().isEmpty()) {
            com.google.android.libraries.navigation.internal.acw.i iVar = (com.google.android.libraries.navigation.internal.acw.i) com.google.android.libraries.navigation.internal.acw.j.a.q();
            ev evVarL = rVar.l();
            int i = ((lv) evVarL).c;
            for (int i2 = 0; i2 < i; i2++) {
                com.google.android.libraries.navigation.internal.pt.d dVar3 = (com.google.android.libraries.navigation.internal.pt.d) evVarL.get(i2);
                com.google.android.libraries.navigation.internal.acw.g gVar = (com.google.android.libraries.navigation.internal.acw.g) com.google.android.libraries.navigation.internal.acw.h.a.q();
                String strF = dVar3.b.f();
                if (!gVar.b.H()) {
                    gVar.v();
                }
                com.google.android.libraries.navigation.internal.acw.h hVar2 = (com.google.android.libraries.navigation.internal.acw.h) gVar.b;
                hVar2.b |= 1;
                hVar2.c = strF;
                int i3 = dVar3.c;
                if (!gVar.b.H()) {
                    gVar.v();
                }
                com.google.android.libraries.navigation.internal.acw.h hVar3 = (com.google.android.libraries.navigation.internal.acw.h) gVar.b;
                hVar3.b |= 2;
                hVar3.d = i3;
                com.google.android.libraries.navigation.internal.acw.h hVar4 = (com.google.android.libraries.navigation.internal.acw.h) gVar.t();
                if (!iVar.b.H()) {
                    iVar.v();
                }
                com.google.android.libraries.navigation.internal.acw.j jVar = (com.google.android.libraries.navigation.internal.acw.j) iVar.b;
                hVar4.getClass();
                bz bzVar = jVar.b;
                if (!bzVar.c()) {
                    jVar.b = bi.A(bzVar);
                }
                jVar.b.add(hVar4);
            }
            dyVarB.C(bj.W, (com.google.android.libraries.navigation.internal.acw.j) iVar.t());
        }
        if (rVar.f() != 0) {
            bh bhVar2 = bj.V;
            cw cwVar = (cw) cx.a.q();
            long jF = rVar.f();
            if (!cwVar.b.H()) {
                cwVar.v();
            }
            cx cxVar = (cx) cwVar.b;
            cxVar.b |= 32;
            cxVar.g = jF;
            dyVarB.C(bhVar2, (cx) cwVar.t());
            bh bhVar3 = bj.M;
            com.google.android.libraries.navigation.internal.ado.i iVar2 = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
            ae aeVar = (ae) ah.a.q();
            aeVar.e(ad.y);
            ah ahVar = (ah) aeVar.t();
            if (!iVar2.b.H()) {
                iVar2.v();
            }
            com.google.android.libraries.navigation.internal.ado.j jVar2 = (com.google.android.libraries.navigation.internal.ado.j) iVar2.b;
            ahVar.getClass();
            jVar2.c = ahVar;
            jVar2.b |= 1;
            dyVarB.C(bhVar3, (com.google.android.libraries.navigation.internal.ado.j) iVar2.t());
        } else {
            rVar.k();
        }
        rVar.q();
        rVar.o();
        return hVar.d();
    }

    private final void h(Iterable iterable) {
        Map.Entry entry;
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.s.a aVar = (com.google.android.libraries.navigation.internal.s.a) it2.next();
            Iterator it3 = this.p.u().iterator();
            do {
                if (!it3.hasNext()) {
                    entry = null;
                    break;
                }
                entry = (Map.Entry) it3.next();
            } while (entry.getValue() != aVar);
            if (entry != null) {
                ((j) entry.getValue()).a();
                this.p.C(entry.getKey(), entry.getValue());
            }
        }
    }

    private final boolean i() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized ev j(Iterable iterable, Iterable iterable2, final boolean z) {
        eq eqVar;
        com.google.android.libraries.navigation.internal.on.l lVarA;
        com.google.android.libraries.navigation.internal.on.l lVarC;
        com.google.android.libraries.navigation.internal.s.a kVar;
        eqVar = new eq();
        final fy fyVarO = fy.o(this.p.x());
        int i = ev.d;
        eq eqVar2 = new eq();
        h(iterable2);
        no it2 = ((ev) iterable).iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.ob.r rVar = (com.google.android.libraries.navigation.internal.ob.r) it2.next();
            boolean zContains = fyVarO.contains(rVar);
            x xVarZ = x.z(rVar.i());
            if (i()) {
                kVar = new i();
            } else {
                com.google.android.libraries.navigation.internal.on.l lVarB = this.j.b(rVar);
                com.google.android.libraries.navigation.internal.ol.g gVarA = this.j.a(rVar, lVarB);
                com.google.android.libraries.navigation.internal.ot.p pVarC = com.google.android.libraries.navigation.internal.ot.p.c(o.PLACEMARK_SELECTION);
                l lVar = this.j;
                if (rVar.h() == u.NAMED_STYLE) {
                    lVarA = ((q) lVar.a.g.a()).b(rVar.d());
                } else {
                    lVarA = ((q) lVar.a.g.a()).a(rVar.m() ? com.google.android.libraries.navigation.internal.adg.b.TOP : com.google.android.libraries.navigation.internal.adg.b.CENTER);
                }
                com.google.android.libraries.navigation.internal.on.l lVar2 = lVarA;
                l lVar3 = this.j;
                if (rVar.h() == u.NORMAL && rVar.e() == Integer.MIN_VALUE) {
                    lVarC = new com.google.android.libraries.navigation.internal.on.m(((q) lVar3.a.g.a()).a.f(ex.LEGEND_STYLE_SPOTLIGHT_PIN));
                } else if (rVar.h() == u.NAMED_STYLE) {
                    lVarC = ((q) lVar3.a.g.a()).b(rVar.a());
                } else {
                    u uVarH = rVar.h();
                    rVar.n();
                    lVarC = ((q) lVar3.a.g.a()).c(lVar3.c(uVarH, rVar.e()));
                }
                ef efVar = (ef) b(rVar, lVarC.a(), com.google.android.libraries.navigation.internal.oj.h.f(lVar2.a()), xVarZ, z);
                com.google.android.libraries.navigation.internal.afo.a aVar = this.c;
                jr jrVar = jr.WORLD_ENCODING_LAT_LNG_E7;
                ai aiVar = ((com.google.android.libraries.navigation.internal.vu.o) aVar).a;
                com.google.android.libraries.navigation.internal.ol.u uVarB = aiVar.b(efVar, jrVar);
                uVarB.k(new b(this, xVarZ, rVar));
                aiVar.m(uVarB);
                if (!zContains) {
                    uVarB.b(((com.google.android.libraries.navigation.internal.ot.d) pVarC).a);
                }
                kVar = new k(this, uVarB, gVarA, lVarC, lVar2, lVarB);
            }
            this.p.t(rVar, kVar);
            eqVar2.h(new e(rVar, kVar));
            eqVar.h(kVar);
        }
        if (i()) {
            final f fVar = this.o;
            final ev evVarG = eqVar2.g();
            final ev evVarN = ev.n(iterable2);
            fVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.r.c
                public final /* synthetic */ boolean e = true;

                @Override // java.lang.Runnable
                public final void run() {
                    f.b(fVar, fyVarO, evVarG, evVarN, true, z);
                }
            });
        }
        return eqVar.g();
    }

    @Override // com.google.android.libraries.navigation.internal.s.b
    public final synchronized com.google.android.libraries.navigation.internal.oe.r a() {
        mh mhVar = this.p;
        if (mhVar.A()) {
            return null;
        }
        return ((com.google.android.libraries.navigation.internal.ob.r) Collections.min(mhVar.x(), new h())).i();
    }

    @Override // com.google.android.libraries.navigation.internal.s.b
    public final void c() {
        com.google.android.libraries.navigation.internal.ra.c.b.f();
        d(this.r);
        int i = ev.d;
        this.r = lv.a;
        this.q.J(0, 0);
        ((com.google.android.libraries.navigation.internal.vu.o) this.c).a.l(null);
    }

    @Override // com.google.android.libraries.navigation.internal.s.b
    public final synchronized void d(Iterable iterable) {
        h(iterable);
        if (i()) {
            final f fVar = this.o;
            final ev evVarN = ev.n(iterable);
            fVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.r.d
                @Override // java.lang.Runnable
                public final void run() {
                    fVar.a(evVarN);
                }
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.s.b
    public final void e(com.google.android.libraries.navigation.internal.ob.r rVar) {
        com.google.android.libraries.navigation.internal.ol.ah ahVarD;
        com.google.android.libraries.navigation.internal.ra.c.b.f();
        x xVarZ = x.z(rVar.i());
        boolean zG = com.google.android.libraries.navigation.internal.oe.j.g(rVar.f());
        ai aiVar = ((com.google.android.libraries.navigation.internal.vu.o) this.c).a;
        if (zG) {
            ahVarD = aiVar.c(rVar.f(), xVarZ.b(), xVarZ.d());
        } else {
            rVar.j();
            ahVarD = aiVar.d(xVarZ);
        }
        aiVar.l(ahVarD);
        if (xVarZ.equals(this.q)) {
            return;
        }
        this.q.W(xVarZ);
        this.r = j(ev.q(rVar), this.r, true);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024 A[Catch: all -> 0x004a, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:7:0x001a, B:8:0x001c, B:10:0x0024, B:11:0x0026), top: B:17:0x0003 }] */
    @Override // com.google.android.libraries.navigation.internal.s.b
    public final synchronized void f(com.google.android.libraries.navigation.internal.ob.r rVar, Rect rect) {
        if (rVar == null) {
            mh mhVar = this.p;
            rVar = !mhVar.A() ? (com.google.android.libraries.navigation.internal.ob.r) mhVar.x().iterator().next() : com.google.android.libraries.navigation.internal.ob.r.f;
            if (rVar.h() == u.NAMED_STYLE) {
                rVar = com.google.android.libraries.navigation.internal.ob.r.f;
            }
            l lVar = this.j;
            u uVarH = rVar.h();
            rVar.n();
            Bitmap bitmapC = lVar.c(uVarH, rVar.e());
            int width = bitmapC.getWidth();
            int i = (-width) / 2;
            rect.set(i, -bitmapC.getHeight(), width + i, 0);
        } else {
            if (rVar.h() == u.NAMED_STYLE) {
                rVar = com.google.android.libraries.navigation.internal.ob.r.f;
            }
            l lVar2 = this.j;
            u uVarH2 = rVar.h();
            rVar.n();
            Bitmap bitmapC2 = lVar2.c(uVarH2, rVar.e());
            int width2 = bitmapC2.getWidth();
            int i2 = (-width2) / 2;
            rect.set(i2, -bitmapC2.getHeight(), width2 + i2, 0);
        }
        throw th;
    }

    @Override // com.google.android.libraries.navigation.internal.s.b
    public final synchronized ev g(Iterable iterable, Iterable iterable2) {
        return j(iterable, iterable2, false);
    }
}
