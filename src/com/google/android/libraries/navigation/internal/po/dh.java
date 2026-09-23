package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.adg.ho;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class dh implements com.google.android.libraries.navigation.internal.ol.ai, com.google.android.libraries.navigation.internal.px.ad {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final com.google.android.libraries.navigation.internal.zb.j f522n = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.dh");
    public final hi a;
    public final dd b;
    public final dg c;
    public final df d;
    public final cw e;
    public com.google.android.libraries.navigation.internal.px.ca f;
    public final float g;
    public final af h;
    public final cm i;
    public final cv j;
    public volatile com.google.android.libraries.navigation.internal.pz.d k;
    public com.google.android.libraries.geo.mapcore.internal.model.aq l;
    public final gr m;
    private final Set o;
    private final Map p;
    private final AtomicLong q;
    private final AtomicBoolean r;
    private final gd s;

    public dh(hi hiVar, com.google.android.libraries.navigation.internal.qc.g gVar, gd gdVar, Map map, float f, af afVar, gr grVar, boolean z, boolean z2) {
        cw cwVar = new cw();
        this.e = cwVar;
        cv cvVar = new cv(this);
        this.j = cvVar;
        this.q = new AtomicLong(0L);
        this.k = com.google.android.libraries.navigation.internal.pz.d.a;
        this.l = com.google.android.libraries.geo.mapcore.internal.model.aq.a;
        this.r = new AtomicBoolean(false);
        this.a = hiVar;
        this.m = grVar;
        dd ddVar = new dd();
        this.b = ddVar;
        this.c = new dg();
        this.d = new df();
        this.o = new HashSet();
        this.s = gdVar;
        this.p = map;
        this.g = f;
        this.h = afVar;
        cm cmVar = new cm(hiVar, gVar, cwVar, z, z2);
        this.i = cmVar;
        hiVar.u(cmVar);
        ddVar.f(cvVar.g);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0039  */
    private final aa t(com.google.android.libraries.navigation.internal.adg.ef efVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.av avVar, com.google.android.libraries.navigation.internal.ox.b bVar) {
        com.google.android.libraries.navigation.internal.oe.x xVarG;
        w(bVar);
        if (avVar == null) {
            avVar = this.a.f;
        }
        com.google.android.libraries.navigation.internal.oe.o oVar = (com.google.android.libraries.navigation.internal.oe.o) this.p.get(jrVar);
        com.google.android.libraries.navigation.internal.adg.b bVarB = null;
        if (oVar == null) {
            xVarG = null;
        } else {
            com.google.android.libraries.navigation.internal.adg.d dVar = efVar.e;
            if (dVar == null) {
                dVar = com.google.android.libraries.navigation.internal.adg.d.a;
            }
            com.google.android.libraries.navigation.internal.adg.h hVar = dVar.c;
            if (hVar == null) {
                hVar = com.google.android.libraries.navigation.internal.adg.h.a;
            }
            if ((hVar.b & 1) != 0) {
                try {
                    com.google.android.libraries.navigation.internal.adg.d dVar2 = efVar.e;
                    if (dVar2 == null) {
                        dVar2 = com.google.android.libraries.navigation.internal.adg.d.a;
                    }
                    com.google.android.libraries.navigation.internal.adg.h hVar2 = dVar2.c;
                    if (hVar2 == null) {
                        hVar2 = com.google.android.libraries.navigation.internal.adg.h.a;
                    }
                    xVarG = oVar.g(hVar2.c);
                } catch (IOException unused) {
                    xVarG = null;
                }
            } else {
                xVarG = null;
            }
        }
        dd ddVar = this.b;
        af afVar = this.h;
        gx gxVar = (gx) avVar;
        com.google.android.libraries.navigation.internal.px.ep epVarAs = com.google.android.libraries.navigation.internal.px.ep.as(efVar, null, gxVar.d, null, xVarG == null ? com.google.android.libraries.navigation.internal.px.cg.f() : com.google.android.libraries.navigation.internal.px.cg.d(xVarG));
        com.google.android.libraries.navigation.internal.op.a aVar = new com.google.android.libraries.navigation.internal.op.a(this.q.incrementAndGet());
        if ((efVar.b & 8) != 0) {
            com.google.android.libraries.navigation.internal.adg.d dVar3 = efVar.e;
            if (dVar3 == null) {
                dVar3 = com.google.android.libraries.navigation.internal.adg.d.a;
            }
            bVarB = com.google.android.libraries.navigation.internal.adg.b.b(dVar3.d);
            if (bVarB == null) {
                bVarB = com.google.android.libraries.navigation.internal.adg.b.CENTER;
            }
        }
        final aa aaVar = new aa(ddVar, afVar, epVarAs, aVar, bVarB, this);
        final Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.cs
            @Override // java.lang.Runnable
            public final void run() {
                dh dhVar = this.a;
                com.google.android.libraries.navigation.internal.px.ca caVar = dhVar.f;
                com.google.android.libraries.navigation.internal.yx.ar.q(caVar);
                aaVar.A(caVar, dhVar.g, dhVar.k, dhVar.l);
            }
        };
        if (y(efVar, this.s, gxVar.d)) {
            this.j.a(runnable);
        } else {
            this.s.a(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ct
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.s(runnable);
                }
            });
        }
        cv cvVar = this.j;
        synchronized (cvVar.a) {
            cvVar.d.add(aaVar);
        }
        dd ddVar2 = this.b;
        synchronized (ddVar2) {
            ddVar2.d.add(aaVar.c);
        }
        return aaVar;
    }

    private final bb u(final com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.navigation.internal.or.c cVar, jr jrVar, gx gxVar, com.google.android.libraries.navigation.internal.ox.b bVar) {
        com.google.android.libraries.geo.mapcore.internal.model.c cVarA;
        com.google.android.libraries.geo.mapcore.internal.model.c cVarA2;
        w(bVar);
        if ((efVar.b & 16) != 0) {
            throw new UnsupportedOperationException("Cannot create point label from line label proto");
        }
        if (!y(efVar, this.s, gxVar.d)) {
            com.google.android.libraries.navigation.internal.oe.o oVar = (com.google.android.libraries.navigation.internal.oe.o) this.p.get(jrVar);
            com.google.android.libraries.navigation.internal.yx.ar.q(oVar);
            try {
                com.google.android.libraries.navigation.internal.adg.d dVar = efVar.e;
                if (dVar == null) {
                    dVar = com.google.android.libraries.navigation.internal.adg.d.a;
                }
                cVarA = com.google.android.libraries.geo.mapcore.internal.model.c.b(dVar, oVar);
                com.google.android.libraries.geo.mapcore.internal.model.ad.b(efVar, cVarA);
            } catch (IOException unused) {
                cVarA = com.google.android.libraries.geo.mapcore.internal.model.c.a(new com.google.android.libraries.navigation.internal.oe.x());
            }
            final bb bbVar = new bb(cVar, cVarA, this.b, this.h, this.c, efVar, gxVar.d, this, null);
            this.s.a(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.cq
                @Override // java.lang.Runnable
                public final void run() {
                    bb bbVar2 = bbVar;
                    bbVar2.q();
                    this.a.e.c(efVar, bbVar2);
                }
            });
            return bbVar;
        }
        com.google.android.libraries.navigation.internal.oe.o oVar2 = (com.google.android.libraries.navigation.internal.oe.o) this.p.get(jrVar);
        com.google.android.libraries.navigation.internal.yx.ar.q(oVar2);
        try {
            com.google.android.libraries.navigation.internal.adg.d dVar2 = efVar.e;
            if (dVar2 == null) {
                dVar2 = com.google.android.libraries.navigation.internal.adg.d.a;
            }
            cVarA2 = com.google.android.libraries.geo.mapcore.internal.model.c.b(dVar2, oVar2);
            com.google.android.libraries.geo.mapcore.internal.model.ad.b(efVar, cVarA2);
        } catch (IOException unused2) {
            cVarA2 = com.google.android.libraries.geo.mapcore.internal.model.c.a(new com.google.android.libraries.navigation.internal.oe.x());
        }
        bb bbVar2 = new bb(cVar, cVarA2, this.b, this.h, this.c, efVar, gxVar.d, this);
        this.e.c(efVar, bbVar2);
        return bbVar2;
    }

    private static com.google.android.libraries.navigation.internal.pp.a v(com.google.android.libraries.navigation.internal.ol.o oVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(oVar instanceof com.google.android.libraries.navigation.internal.pp.a);
        return (com.google.android.libraries.navigation.internal.pp.a) oVar;
    }

    private final void w(com.google.android.libraries.navigation.internal.ox.b bVar) {
        if (this.r.get() && bVar.ordinal() == 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ox.b.c.d(com.google.android.libraries.navigation.internal.nl.a.a).h(com.google.android.libraries.navigation.internal.zb.an.SMALL)).F(839)).p("Unported legacy label creation; crashing app.");
        }
    }

    private static boolean x(com.google.android.libraries.navigation.internal.adg.dt dtVar) {
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.d);
        dtVar.h(bhVarS);
        if (dtVar.w.n(bhVarS.d)) {
            return true;
        }
        for (com.google.android.libraries.navigation.internal.adg.dp dpVar : dtVar.c) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.e);
            dpVar.h(bhVarS2);
            if (dpVar.w.n(bhVarS2.d)) {
                return true;
            }
        }
        return false;
    }

    private static boolean y(com.google.android.libraries.navigation.internal.adg.ef efVar, gd gdVar, int i) {
        if (efVar == null) {
            return false;
        }
        if (gdVar.b()) {
            return true;
        }
        com.google.android.libraries.navigation.internal.ol.aq aqVar = hi.b;
        if (i == 2) {
            return false;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.c);
        efVar.h(bhVarS);
        if (efVar.w.n(bhVarS.d)) {
            return false;
        }
        if ((efVar.b & 1) != 0) {
            com.google.android.libraries.navigation.internal.adg.dt dtVar = efVar.c;
            if (dtVar == null) {
                dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            if (x(dtVar)) {
                return false;
            }
        }
        if ((2 & efVar.b) != 0) {
            com.google.android.libraries.navigation.internal.adg.dt dtVar2 = efVar.d;
            if (dtVar2 == null) {
                dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            if (x(dtVar2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.ol.n a(com.google.android.libraries.navigation.internal.adg.ef efVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.av avVar) {
        return t(efVar, jrVar, avVar, com.google.android.libraries.navigation.internal.ox.b.FROM_MODERN);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final com.google.android.libraries.navigation.internal.ol.ah c(long j, double d, double d2) {
        ch chVar = new ch(j);
        com.google.android.libraries.navigation.internal.adg.hn hnVar = (com.google.android.libraries.navigation.internal.adg.hn) ho.a.q();
        if (!hnVar.b.H()) {
            hnVar.v();
        }
        cm cmVar = this.i;
        ho hoVar = (ho) hnVar.b;
        hoVar.b |= 1;
        hoVar.c = j;
        return cmVar.b(chVar, (ho) hnVar.t(), com.google.android.libraries.navigation.internal.oe.x.A(d, d2));
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final com.google.android.libraries.navigation.internal.ol.ah d(com.google.android.libraries.navigation.internal.oe.x xVar) {
        ci ciVar = new ci(xVar);
        cm cmVar = this.i;
        return new cj(cmVar, ciVar, new cl(cmVar, xVar, null));
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void e(com.google.android.libraries.navigation.internal.ol.ad adVar) {
        this.b.f(adVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void f(com.google.android.libraries.navigation.internal.yx.as asVar) {
        boolean zB;
        dd ddVar = this.b;
        synchronized (ddVar) {
            zB = ddVar.b.b(asVar);
        }
        if (zB) {
            ddVar.g();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void g(com.google.android.libraries.navigation.internal.ol.o oVar) {
        com.google.android.libraries.navigation.internal.pp.a aVarV = v(oVar);
        i(aVarV);
        aVarV.x();
        this.e.d((com.google.android.libraries.navigation.internal.adg.ef) oVar.n());
        if (aVarV instanceof bb) {
            this.d.a((bb) aVarV);
        }
        if (aVarV instanceof aa) {
            dd ddVar = this.b;
            aa aaVar = (aa) aVarV;
            synchronized (ddVar) {
                ddVar.d.remove(aaVar.c);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void h() {
        this.b.g();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void i(com.google.android.libraries.navigation.internal.ol.o oVar) {
        boolean zRemove;
        com.google.android.libraries.navigation.internal.pp.a aVarV = v(oVar);
        synchronized (this) {
            zRemove = this.o.remove(aVarV);
        }
        if (zRemove) {
            aVarV.y();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void j(com.google.android.libraries.navigation.internal.ol.ad adVar) {
        dd ddVar = this.b;
        synchronized (ddVar) {
            if (ddVar.h.contains(adVar)) {
                ddVar.h.remove(adVar);
            } else if (ddVar.e != null && ddVar.g.contains(adVar)) {
                ddVar.e.o(adVar);
                ddVar.g.remove(adVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void k(com.google.android.libraries.navigation.internal.yx.as asVar) {
        boolean zC;
        dd ddVar = this.b;
        synchronized (ddVar) {
            zC = ddVar.b.c(asVar);
        }
        if (zC) {
            ddVar.g();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void l(com.google.android.libraries.navigation.internal.ol.ah ahVar) {
        dd ddVar = this.b;
        synchronized (ddVar) {
            if (ahVar != ddVar.f) {
                ddVar.f = ahVar;
                com.google.android.libraries.navigation.internal.px.bk bkVar = ddVar.e;
                if (bkVar != null) {
                    bkVar.i(ahVar);
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    public final void m(com.google.android.libraries.navigation.internal.ol.o oVar) {
        boolean zAdd;
        com.google.android.libraries.navigation.internal.pp.a aVarV = v(oVar);
        synchronized (this) {
            zAdd = this.o.add(aVarV);
        }
        if (zAdd) {
            aVarV.z();
        }
    }

    public final aa n(com.google.android.libraries.navigation.internal.adg.ef efVar, jr jrVar) {
        return t(efVar, jrVar, this.a.f, com.google.android.libraries.navigation.internal.ox.b.FROM_LEGACY);
    }

    public final ag o(com.google.android.libraries.navigation.internal.adg.ef efVar, jr jrVar) {
        return p(efVar, null, jrVar, null, com.google.android.libraries.navigation.internal.ox.b.FROM_LEGACY);
    }

    public final ag p(com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.navigation.internal.or.c cVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.av avVar, com.google.android.libraries.navigation.internal.ox.b bVar) {
        com.google.android.libraries.navigation.internal.oe.ad adVarH;
        com.google.android.libraries.navigation.internal.oe.ad adVarH2;
        if (avVar == null) {
            avVar = this.a.f;
        }
        if (jrVar == jr.WORLD_ENCODING_UNKNOWN) {
            throw new IllegalArgumentException("Attempting to create a client-inject label with an unknown vertex encoding");
        }
        if ((efVar.b & 8) != 0) {
            return u(efVar, cVar, jrVar, (gx) avVar, bVar);
        }
        w(bVar);
        if ((efVar.b & 8) != 0) {
            throw new UnsupportedOperationException("Cannot create line label from point label proto");
        }
        gx gxVar = (gx) avVar;
        if (y(efVar, this.s, gxVar.d)) {
            com.google.android.libraries.navigation.internal.oe.o oVar = (com.google.android.libraries.navigation.internal.oe.o) this.p.get(jrVar);
            com.google.android.libraries.navigation.internal.yx.ar.q(oVar);
            try {
                com.google.android.libraries.navigation.internal.adg.gq gqVar = efVar.f;
                if (gqVar == null) {
                    gqVar = com.google.android.libraries.navigation.internal.adg.gq.a;
                }
                com.google.android.libraries.navigation.internal.ael.x xVar = gqVar.b;
                com.google.android.libraries.navigation.internal.adg.gq gqVar2 = efVar.f;
                if (gqVar2 == null) {
                    gqVar2 = com.google.android.libraries.navigation.internal.adg.gq.a;
                }
                adVarH2 = oVar.h(xVar, gqVar2.c);
            } catch (IOException unused) {
                adVarH2 = com.google.android.libraries.navigation.internal.oe.ad.a;
            }
            return new ao(cVar, adVarH2, this.b, this.h, efVar, gxVar.d, this);
        }
        com.google.android.libraries.navigation.internal.oe.o oVar2 = (com.google.android.libraries.navigation.internal.oe.o) this.p.get(jrVar);
        com.google.android.libraries.navigation.internal.yx.ar.q(oVar2);
        try {
            com.google.android.libraries.navigation.internal.adg.gq gqVar3 = efVar.f;
            if (gqVar3 == null) {
                gqVar3 = com.google.android.libraries.navigation.internal.adg.gq.a;
            }
            com.google.android.libraries.navigation.internal.ael.x xVar2 = gqVar3.b;
            com.google.android.libraries.navigation.internal.adg.gq gqVar4 = efVar.f;
            if (gqVar4 == null) {
                gqVar4 = com.google.android.libraries.navigation.internal.adg.gq.a;
            }
            adVarH = oVar2.h(xVar2, gqVar4.c);
        } catch (IOException unused2) {
            adVarH = com.google.android.libraries.navigation.internal.oe.ad.a;
        }
        final ao aoVar = new ao(cVar, adVarH, this.b, this.h, efVar, gxVar.d, this, null);
        this.s.a(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.cr
            @Override // java.lang.Runnable
            public final void run() {
                aoVar.q();
            }
        });
        return aoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ai
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final bb b(com.google.android.libraries.navigation.internal.adg.ef efVar, jr jrVar) {
        return u(efVar, null, jrVar, this.a.f, com.google.android.libraries.navigation.internal.ox.b.FROM_LEGACY);
    }

    public final bb r(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        return this.e.a(efVar);
    }

    public final /* synthetic */ void s(Runnable runnable) {
        this.j.a(runnable);
    }
}
