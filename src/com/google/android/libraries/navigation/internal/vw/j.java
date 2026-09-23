package com.google.android.libraries.navigation.internal.vw;

import android.content.Context;
import android.content.Intent;
import com.google.android.libraries.navigation.internal.acd.nv;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.bk;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.cm;
import com.google.android.libraries.navigation.internal.adr.gi;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.adr.gs;
import com.google.android.libraries.navigation.internal.adr.gv;
import com.google.android.libraries.navigation.internal.adr.gw;
import com.google.android.libraries.navigation.internal.adr.hv;
import com.google.android.libraries.navigation.internal.adr.hw;
import com.google.android.libraries.navigation.internal.adr.ib;
import com.google.android.libraries.navigation.internal.adr.ie;
import com.google.android.libraries.navigation.internal.adr.ig;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.adr.kb;
import com.google.android.libraries.navigation.internal.adr.kg;
import com.google.android.libraries.navigation.internal.adr.kh;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.afl.kz;
import com.google.android.libraries.navigation.internal.afl.la;
import com.google.android.libraries.navigation.internal.afl.lb;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.lk;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.mc;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.bp.ah;
import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.xe.fb;
import com.google.android.libraries.navigation.internal.xe.fc;
import com.google.android.libraries.navigation.internal.xe.fe;
import com.google.android.libraries.navigation.internal.xe.ff;
import com.google.android.libraries.navigation.internal.xe.fg;
import com.google.android.libraries.navigation.internal.xe.fh;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yx.bq;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zr.cb;
import com.google.android.libraries.navigation.internal.zr.cd;
import com.google.android.libraries.navigation.internal.zr.ce;
import com.google.android.libraries.navigation.internal.zr.cf;
import com.google.android.libraries.navigation.internal.zr.cg;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.vp.d {
    private final af A;
    private final com.google.android.libraries.navigation.internal.sl.q B;
    private final br C;
    private String D;
    private Intent E;
    private final com.google.android.libraries.navigation.internal.rw.q F;
    private final com.google.android.libraries.navigation.internal.rw.f G;
    private final Executor H;
    private final h I;
    private final g J;
    private final b L;
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final com.google.android.libraries.navigation.internal.qt.a b;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    public final Context d;
    public final com.google.android.libraries.navigation.internal.nt.p e;
    public com.google.android.libraries.navigation.internal.vp.i f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final o j;
    public com.google.android.libraries.navigation.internal.vp.b l;
    public boolean o;
    public long p;
    public final com.google.android.libraries.navigation.internal.cw.a q;
    public final com.google.android.libraries.navigation.internal.vt.a r;
    public fb s;
    public fe t;
    public ff u;
    public fh v;
    public fg w;
    private final com.google.android.libraries.navigation.internal.vp.g x;
    private final com.google.android.libraries.navigation.internal.sl.l y;
    private final com.google.android.libraries.navigation.internal.iv.f z;
    public com.google.android.libraries.navigation.internal.vv.a k = com.google.android.libraries.navigation.internal.vv.a.a;
    public com.google.android.libraries.navigation.internal.si.d m = com.google.android.libraries.navigation.internal.si.d.b().a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f645n = true;
    private final i K = new i(this);

    public j(com.google.android.libraries.navigation.internal.cw.a aVar, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.rw.f fVar, Executor executor, com.google.android.libraries.navigation.internal.vp.g gVar, o oVar, com.google.android.libraries.navigation.internal.vt.a aVar2, com.google.android.libraries.navigation.internal.sl.l lVar, com.google.android.libraries.navigation.internal.iv.f fVar2, com.google.android.libraries.navigation.internal.ia.e eVar, af afVar, com.google.android.libraries.navigation.internal.sl.q qVar2, com.google.android.libraries.navigation.internal.qt.a aVar3, com.google.android.libraries.navigation.internal.mj.a aVar4, Context context, br brVar) {
        this.q = aVar;
        this.F = qVar;
        this.G = fVar;
        this.H = executor;
        this.x = gVar;
        this.r = aVar2;
        this.y = lVar;
        this.z = fVar2;
        this.a = eVar;
        this.A = afVar;
        this.j = oVar;
        this.B = qVar2;
        this.b = aVar3;
        this.c = aVar4;
        this.d = context;
        this.C = brVar;
        b bVar = new b(this, aVar3);
        this.L = bVar;
        this.e = new com.google.android.libraries.navigation.internal.nt.p();
        this.I = new h(this);
        this.J = new g(this);
        executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vw.a
            @Override // java.lang.Runnable
            public final void run() {
                j jVar = this.a;
                jVar.m(13);
                jVar.o = jVar.b.a() > 0;
                jVar.r();
            }
        });
        aVar3.c(bVar);
    }

    private final synchronized void C(com.google.android.libraries.navigation.internal.vv.a aVar, bg bgVar, com.google.android.libraries.navigation.internal.si.d dVar, boolean z) {
        this.e.b(new com.google.android.libraries.navigation.internal.vs.a(aVar, dVar));
        boolean z2 = false;
        if ((bgVar != null || aVar.e != null) && !am.a(bgVar, aVar.e)) {
            z2 = true;
        }
        if (!((Boolean) this.C.a()).booleanValue() || ((this.g && !z) || !z2)) {
            return;
        }
        this.H.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vw.c
            @Override // java.lang.Runnable
            public final void run() {
                fe feVar = this.a.t;
                if (feVar != null) {
                    feVar.a();
                }
            }
        });
    }

    public final synchronized void A(fe feVar) {
        if (((Boolean) this.C.a()).booleanValue()) {
            this.t = feVar;
        }
        this.j.g = feVar;
    }

    public final synchronized void B(String str, int i, long j, com.google.android.libraries.navigation.internal.vy.b bVar) {
        if (str.equals(this.D)) {
            cb cbVar = (cb) ce.a.q();
            if (!cbVar.b.H()) {
                cbVar.v();
            }
            ce ceVar = (ce) cbVar.b;
            str.getClass();
            ceVar.b |= 1;
            ceVar.c = str;
            if (!cbVar.b.H()) {
                cbVar.v();
            }
            ce ceVar2 = (ce) cbVar.b;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            ceVar2.d = i2;
            ceVar2.b |= 2;
            if (!cbVar.b.H()) {
                cbVar.v();
            }
            ce ceVar3 = (ce) cbVar.b;
            ceVar3.b |= 4;
            ceVar3.e = j;
            if (bVar != null) {
                String strI = com.google.android.libraries.navigation.internal.zn.g.e.i(bVar.m());
                if (!cbVar.b.H()) {
                    cbVar.v();
                }
                ce ceVar4 = (ce) cbVar.b;
                ceVar4.b |= 8;
                ceVar4.f = strI;
            }
            cf cfVar = (cf) cg.a.q();
            ce ceVar5 = (ce) cbVar.t();
            if (!cfVar.b.H()) {
                cfVar.v();
            }
            cg cgVar = (cg) cfVar.b;
            ceVar5.getClass();
            cgVar.f = ceVar5;
            cgVar.b |= 1;
            cg cgVar2 = (cg) cfVar.t();
            com.google.android.libraries.navigation.internal.kd.d dVar = new com.google.android.libraries.navigation.internal.kd.d();
            dVar.b(com.google.android.libraries.navigation.internal.zp.n.aH);
            dVar.a = cgVar2;
            this.A.n(dVar.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.vp.d
    public final synchronized com.google.android.libraries.navigation.internal.vv.a a() {
        return this.k;
    }

    public final synchronized ck b() {
        bg bgVar;
        Context context;
        kb kbVar;
        al alVarB;
        com.google.android.libraries.navigation.internal.vv.a aVarB;
        la laVar;
        if (!this.k.d()) {
            return null;
        }
        this.j.c();
        com.google.android.libraries.navigation.internal.vv.a aVar = this.k;
        bg bgVar2 = aVar.e;
        Context context2 = this.d;
        ar.q(aVar.d);
        int i = 1;
        if (aVar.c.size() == 1) {
            aVarB = com.google.android.libraries.navigation.internal.vv.a.a;
            bgVar = bgVar2;
        } else {
            ai aiVar = aVar.d;
            ar.a(aiVar.e.size() > 2);
            ll llVar = aiVar.b.a.c;
            if (llVar == null) {
                llVar = ll.a;
            }
            lh lhVar = llVar.c;
            if (lhVar == null) {
                lhVar = lh.a;
            }
            bb bbVar = (bb) lhVar.aH(5, null);
            bbVar.x(lhVar);
            lb lbVar = (lb) bbVar;
            com.google.android.libraries.navigation.internal.bp.af afVar = aiVar.b;
            if (((lh) lbVar.b).c.size() == 0) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ca.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('i')).p("Directions has no waypoints.");
            } else {
                if (!lbVar.b.H()) {
                    lbVar.v();
                }
                lh lhVar2 = (lh) lbVar.b;
                bz bzVar = lhVar2.c;
                if (!bzVar.c()) {
                    lhVar2.c = bi.A(bzVar);
                }
                lhVar2.c.remove(0);
            }
            lh lhVar3 = (lh) lbVar.b;
            if (lhVar3.f < lhVar3.d.size()) {
                ki kiVarC = lbVar.c(((lh) lbVar.b).f);
                bb bbVar2 = (bb) kiVarC.aH(5, null);
                bbVar2.x(kiVarC);
                kbVar = (kb) bbVar2;
                if (((ki) kbVar.b).h.size() == 0) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ca.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('h')).p("Trip proto has no first path.");
                    bgVar = bgVar2;
                    context = context2;
                } else {
                    com.google.android.libraries.navigation.internal.ca.a.a(kbVar);
                    Cif cif = kbVar.c(0).c;
                    if (cif == null) {
                        cif = Cif.a;
                    }
                    bm bmVar = cif.e;
                    if (bmVar == null) {
                        bmVar = bm.a;
                    }
                    int i2 = bmVar.c;
                    com.google.android.libraries.navigation.internal.adz.f fVar = ((ki) kbVar.b).j;
                    if (fVar == null) {
                        fVar = com.google.android.libraries.navigation.internal.adz.f.a;
                    }
                    bb bbVar3 = (bb) fVar.aH(5, null);
                    bbVar3.x(fVar);
                    com.google.android.libraries.navigation.internal.adz.e eVar = (com.google.android.libraries.navigation.internal.adz.e) bbVar3;
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (i3 < ((com.google.android.libraries.navigation.internal.adz.f) eVar.b).d.size()) {
                        com.google.android.libraries.navigation.internal.adz.d dVar = (com.google.android.libraries.navigation.internal.adz.d) ((com.google.android.libraries.navigation.internal.adz.f) eVar.b).d.get(i3);
                        if (dVar.c == i) {
                            com.google.android.libraries.navigation.internal.adz.c cVar = (com.google.android.libraries.navigation.internal.adz.c) dVar.d;
                            int i4 = cVar.d;
                            int i5 = cVar.c;
                            int i6 = i4 + i5;
                            if (i6 > i2) {
                                bb bbVar4 = (bb) dVar.aH(5, null);
                                bbVar4.x(dVar);
                                com.google.android.libraries.navigation.internal.adz.a aVar2 = (com.google.android.libraries.navigation.internal.adz.a) bbVar4;
                                if (i5 < i2) {
                                    bb bbVar5 = (bb) cVar.aH(5, null);
                                    bbVar5.x(cVar);
                                    com.google.android.libraries.navigation.internal.adz.b bVar = (com.google.android.libraries.navigation.internal.adz.b) bbVar5;
                                    if (!bVar.b.H()) {
                                        bVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adz.c cVar2 = (com.google.android.libraries.navigation.internal.adz.c) bVar.b;
                                    cVar2.b |= 1;
                                    cVar2.c = 0;
                                    if (!bVar.b.H()) {
                                        bVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adz.c cVar3 = (com.google.android.libraries.navigation.internal.adz.c) bVar.b;
                                    cVar3.b |= 2;
                                    cVar3.d = i6 - i2;
                                    com.google.android.libraries.navigation.internal.adz.c cVar4 = (com.google.android.libraries.navigation.internal.adz.c) bVar.t();
                                    if (!aVar2.b.H()) {
                                        aVar2.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adz.d dVar2 = (com.google.android.libraries.navigation.internal.adz.d) aVar2.b;
                                    cVar4.getClass();
                                    dVar2.d = cVar4;
                                    dVar2.c = 1;
                                } else {
                                    bb bbVar6 = (bb) cVar.aH(5, null);
                                    bbVar6.x(cVar);
                                    com.google.android.libraries.navigation.internal.adz.b bVar2 = (com.google.android.libraries.navigation.internal.adz.b) bbVar6;
                                    if (!bVar2.b.H()) {
                                        bVar2.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adz.c cVar5 = (com.google.android.libraries.navigation.internal.adz.c) bVar2.b;
                                    cVar5.b |= 1;
                                    cVar5.c = i5 - i2;
                                    com.google.android.libraries.navigation.internal.adz.c cVar6 = (com.google.android.libraries.navigation.internal.adz.c) bVar2.t();
                                    if (!aVar2.b.H()) {
                                        aVar2.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adz.d dVar3 = (com.google.android.libraries.navigation.internal.adz.d) aVar2.b;
                                    cVar6.getClass();
                                    dVar3.d = cVar6;
                                    dVar3.c = 1;
                                }
                                arrayList.add((com.google.android.libraries.navigation.internal.adz.d) aVar2.t());
                            }
                        } else {
                            arrayList.add(dVar);
                        }
                        i3++;
                        bgVar2 = bgVar2;
                        context2 = context2;
                        i = 1;
                    }
                    bgVar = bgVar2;
                    context = context2;
                    if (!eVar.b.H()) {
                        eVar.v();
                    }
                    ((com.google.android.libraries.navigation.internal.adz.f) eVar.b).d = dj.b;
                    if (!eVar.b.H()) {
                        eVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adz.f fVar2 = (com.google.android.libraries.navigation.internal.adz.f) eVar.b;
                    bz bzVar2 = fVar2.d;
                    if (!bzVar2.c()) {
                        fVar2.d = bi.A(bzVar2);
                    }
                    com.google.android.libraries.navigation.internal.ael.b.m(arrayList, fVar2.d);
                    com.google.android.libraries.navigation.internal.adz.f fVar3 = (com.google.android.libraries.navigation.internal.adz.f) eVar.t();
                    if (!kbVar.b.H()) {
                        kbVar.v();
                    }
                    ki kiVar = (ki) kbVar.b;
                    fVar3.getClass();
                    kiVar.j = fVar3;
                    kiVar.b |= 64;
                    ii iiVar = ((ki) kbVar.b).i;
                    if (iiVar == null) {
                        iiVar = ii.a;
                    }
                    bb bbVar7 = (bb) iiVar.aH(5, null);
                    bbVar7.x(iiVar);
                    ig igVar = (ig) bbVar7;
                    if (((ii) igVar.b).c.size() > 0) {
                        while (((ii) igVar.b).c.size() > 0 && igVar.c(0).c < i2) {
                            igVar.e();
                        }
                        if (((ii) igVar.b).c.size() > 0) {
                            long j = igVar.c(0).d;
                            for (int i7 = 0; i7 < ((ii) igVar.b).c.size(); i7++) {
                                gv gvVarC = igVar.c(i7);
                                bb bbVar8 = (bb) gvVarC.aH(5, null);
                                bbVar8.x(gvVarC);
                                gs gsVar = (gs) bbVar8;
                                int i8 = ((gv) gsVar.b).c - i2;
                                if (!gsVar.b.H()) {
                                    gsVar.v();
                                }
                                gv gvVar = (gv) gsVar.b;
                                gvVar.b |= 1;
                                gvVar.c = i8;
                                long j2 = ((gv) gsVar.b).d - j;
                                if (!gsVar.b.H()) {
                                    gsVar.v();
                                }
                                gv gvVar2 = (gv) gsVar.b;
                                gvVar2.b |= 2;
                                gvVar2.d = j2;
                                igVar.f(i7, gsVar);
                            }
                        }
                    }
                    if (!igVar.b.H()) {
                        igVar.v();
                    }
                    ((ii) igVar.b).f = dj.b;
                    if (!igVar.b.H()) {
                        igVar.v();
                    }
                    ((ii) igVar.b).g = dj.b;
                    if (!igVar.b.H()) {
                        igVar.v();
                    }
                    ((ii) igVar.b).h = dj.b;
                    if (!igVar.b.H()) {
                        igVar.v();
                    }
                    ii iiVar2 = (ii) igVar.b;
                    iiVar2.j = null;
                    iiVar2.b &= -17;
                    if (!igVar.b.H()) {
                        igVar.v();
                    }
                    ii iiVar3 = (ii) igVar.b;
                    iiVar3.b &= -33;
                    iiVar3.k = 0;
                    ii iiVar4 = (ii) igVar.t();
                    if (!kbVar.b.H()) {
                        kbVar.v();
                    }
                    ki kiVar2 = (ki) kbVar.b;
                    kiVar2.i = null;
                    kiVar2.b &= -33;
                    if (!kbVar.b.H()) {
                        kbVar.v();
                    }
                    ki kiVar3 = (ki) kbVar.b;
                    iiVar4.getClass();
                    kiVar3.i = iiVar4;
                    kiVar3.b |= 32;
                    Cif cif2 = ((ki) kbVar.b).g;
                    if (cif2 == null) {
                        cif2 = Cif.a;
                    }
                    bm bmVar2 = cif2.e;
                    if (bmVar2 == null) {
                        bmVar2 = bm.a;
                    }
                    com.google.android.libraries.navigation.internal.aap.d dVar4 = cif2.f;
                    if (dVar4 == null) {
                        dVar4 = com.google.android.libraries.navigation.internal.aap.d.a;
                    }
                    bb bbVar9 = (bb) cif2.aH(5, null);
                    bbVar9.x(cif2);
                    ie ieVar = (ie) bbVar9;
                    bb bbVar10 = (bb) bmVar2.aH(5, null);
                    bbVar10.x(bmVar2);
                    bk bkVar = (bk) bbVar10;
                    int i9 = bmVar2.c;
                    bm bmVar3 = cif.e;
                    if (bmVar3 == null) {
                        bmVar3 = bm.a;
                    }
                    int i10 = i9 - bmVar3.c;
                    if (!bkVar.b.H()) {
                        bkVar.v();
                    }
                    bm bmVar4 = (bm) bkVar.b;
                    bmVar4.b |= 1;
                    bmVar4.c = i10;
                    if (!ieVar.b.H()) {
                        ieVar.v();
                    }
                    Cif cif3 = (Cif) ieVar.b;
                    bm bmVar5 = (bm) bkVar.t();
                    bmVar5.getClass();
                    cif3.e = bmVar5;
                    cif3.b |= 4;
                    bb bbVar11 = (bb) dVar4.aH(5, null);
                    bbVar11.x(dVar4);
                    com.google.android.libraries.navigation.internal.aap.c cVar7 = (com.google.android.libraries.navigation.internal.aap.c) bbVar11;
                    int i11 = dVar4.c;
                    com.google.android.libraries.navigation.internal.aap.d dVar5 = cif.f;
                    if (dVar5 == null) {
                        dVar5 = com.google.android.libraries.navigation.internal.aap.d.a;
                    }
                    int i12 = i11 - dVar5.c;
                    if (!cVar7.b.H()) {
                        cVar7.v();
                    }
                    com.google.android.libraries.navigation.internal.aap.d dVar6 = (com.google.android.libraries.navigation.internal.aap.d) cVar7.b;
                    dVar6.b |= 1;
                    dVar6.c = i12;
                    if (!ieVar.b.H()) {
                        ieVar.v();
                    }
                    Cif cif4 = (Cif) ieVar.b;
                    com.google.android.libraries.navigation.internal.aap.d dVar7 = (com.google.android.libraries.navigation.internal.aap.d) cVar7.t();
                    dVar7.getClass();
                    cif4.f = dVar7;
                    cif4.b |= 8;
                    if ((cif2.b & 256) == 0 || (cif.b & 256) == 0) {
                        if (!ieVar.b.H()) {
                            ieVar.v();
                        }
                        Cif cif5 = (Cif) ieVar.b;
                        cif5.i = null;
                        cif5.b &= -257;
                    } else {
                        cm cmVar = cif2.i;
                        if (cmVar == null) {
                            cmVar = cm.a;
                        }
                        cm cmVar2 = cif.i;
                        if (cmVar2 == null) {
                            cmVar2 = cm.a;
                        }
                        bb bbVar12 = (bb) cmVar.aH(5, null);
                        bbVar12.x(cmVar);
                        com.google.android.libraries.navigation.internal.adr.bz bzVar3 = (com.google.android.libraries.navigation.internal.adr.bz) bbVar12;
                        if ((cmVar.b & 1) == 0 || (cmVar2.b & 1) == 0) {
                            if (!bzVar3.b.H()) {
                                bzVar3.v();
                            }
                            cm cmVar3 = (cm) bzVar3.b;
                            cmVar3.c = null;
                            cmVar3.b &= -2;
                        } else {
                            com.google.android.libraries.navigation.internal.aap.d dVar8 = cmVar.c;
                            if (dVar8 == null) {
                                dVar8 = com.google.android.libraries.navigation.internal.aap.d.a;
                            }
                            int i13 = dVar8.c;
                            com.google.android.libraries.navigation.internal.aap.d dVar9 = cmVar2.c;
                            if (dVar9 == null) {
                                dVar9 = com.google.android.libraries.navigation.internal.aap.d.a;
                            }
                            int i14 = i13 - dVar9.c;
                            com.google.android.libraries.navigation.internal.aap.d dVar10 = cmVar.c;
                            if (dVar10 == null) {
                                dVar10 = com.google.android.libraries.navigation.internal.aap.d.a;
                            }
                            bb bbVar13 = (bb) dVar10.aH(5, null);
                            bbVar13.x(dVar10);
                            com.google.android.libraries.navigation.internal.aap.c cVar8 = (com.google.android.libraries.navigation.internal.aap.c) bbVar13;
                            if (!cVar8.b.H()) {
                                cVar8.v();
                            }
                            com.google.android.libraries.navigation.internal.aap.d dVar11 = (com.google.android.libraries.navigation.internal.aap.d) cVar8.b;
                            dVar11.b |= 1;
                            dVar11.c = i14;
                            if (!bzVar3.b.H()) {
                                bzVar3.v();
                            }
                            cm cmVar4 = (cm) bzVar3.b;
                            com.google.android.libraries.navigation.internal.aap.d dVar12 = (com.google.android.libraries.navigation.internal.aap.d) cVar8.t();
                            dVar12.getClass();
                            cmVar4.c = dVar12;
                            cmVar4.b |= 1;
                        }
                        if (!bzVar3.b.H()) {
                            bzVar3.v();
                        }
                        cm cmVar5 = (cm) bzVar3.b;
                        cmVar5.e = null;
                        cmVar5.b &= -9;
                        if (!bzVar3.b.H()) {
                            bzVar3.v();
                        }
                        cm cmVar6 = (cm) bzVar3.b;
                        cmVar6.g = null;
                        cmVar6.b &= -33;
                        if (!bzVar3.b.H()) {
                            bzVar3.v();
                        }
                        cm cmVar7 = (cm) bzVar3.b;
                        cmVar7.f = null;
                        cmVar7.b &= -17;
                        if (!bzVar3.b.H()) {
                            bzVar3.v();
                        }
                        cm cmVar8 = (cm) bzVar3.b;
                        cmVar8.i = null;
                        cmVar8.b &= -129;
                        cm cmVar9 = (cm) bzVar3.t();
                        if (!ieVar.b.H()) {
                            ieVar.v();
                        }
                        Cif cif6 = (Cif) ieVar.b;
                        cmVar9.getClass();
                        cif6.i = cmVar9;
                        cif6.b |= 256;
                    }
                    if (!ieVar.b.H()) {
                        ieVar.v();
                    }
                    Cif cif7 = (Cif) ieVar.b;
                    cif7.b &= -3;
                    cif7.d = Cif.a.d;
                    Cif cifT = ieVar.t();
                    if (!kbVar.b.H()) {
                        kbVar.v();
                    }
                    ki kiVar4 = (ki) kbVar.b;
                    cifT.getClass();
                    kiVar4.g = cifT;
                    kiVar4.b |= 16;
                    kbVar.d();
                    int i15 = -1;
                    for (int i16 = 0; i16 < ((ki) kbVar.b).h.size(); i16++) {
                        gj gjVarC = kbVar.c(i16);
                        bb bbVar14 = (bb) gjVarC.aH(5, null);
                        bbVar14.x(gjVarC);
                        gi giVar = (gi) bbVar14;
                        for (int i17 = 0; i17 < ((gj) giVar.b).e.size(); i17++) {
                            ib ibVarC = giVar.c(i17);
                            bb bbVar15 = (bb) ibVarC.aH(5, null);
                            bbVar15.x(ibVarC);
                            hw hwVar = (hw) bbVar15;
                            for (int i18 = 0; i18 < ((ib) hwVar.b).d.size(); i18++) {
                                hv hvVarC = hwVar.c(i18);
                                bb bbVar16 = (bb) hvVarC.aH(5, null);
                                bbVar16.x(hvVarC);
                                gw gwVar = (gw) bbVar16;
                                if (i15 < 0) {
                                    i15 = ((hv) gwVar.b).s;
                                }
                                int i19 = ((hv) gwVar.b).s - i15;
                                if (!gwVar.b.H()) {
                                    gwVar.v();
                                }
                                hv hvVar = (hv) gwVar.b;
                                hvVar.b |= 8192;
                                hvVar.s = i19;
                                hwVar.d(i18, gwVar);
                            }
                            giVar.d(i17, hwVar);
                        }
                        kbVar.e(i16, giVar);
                    }
                    if (((ki) kbVar.b).l < ((lh) lbVar.b).i.size()) {
                        la laVarD = lbVar.d(((ki) kbVar.b).l);
                        if (!lbVar.b.H()) {
                            lbVar.v();
                        }
                        ((lh) lbVar.b).i = dj.b;
                        kz kzVar = (kz) la.a.q();
                        int i20 = laVarD.e;
                        if (!kzVar.b.H()) {
                            kzVar.v();
                        }
                        la laVar2 = (la) kzVar.b;
                        laVar2.b |= 1;
                        laVar2.e = i20;
                        int size = laVarD.c.size() - 1;
                        if (i15 > size) {
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ca.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(102)).t("index (%d) must not be greater than size (%d) b/193847656", i15, size);
                            laVar = (la) kzVar.t();
                        } else {
                            int iD = 0;
                            int iD2 = 0;
                            for (int i21 = 0; i21 <= i15; i21++) {
                                iD += laVarD.c.d(i21);
                                iD2 += laVarD.d.d(i21);
                            }
                            kzVar.c(iD);
                            kzVar.d(iD2);
                            for (int i22 = i15 + 1; i22 < laVarD.c.size(); i22++) {
                                kzVar.c(laVarD.c.d(i22));
                                kzVar.d(laVarD.d.d(i22));
                            }
                            laVar = (la) kzVar.t();
                        }
                        lbVar.e(laVar);
                        if (!kbVar.b.H()) {
                            kbVar.v();
                        }
                        ki kiVar5 = (ki) kbVar.b;
                        kiVar5.b |= 512;
                        kiVar5.l = 0;
                    } else {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ca.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('g')).p("Trip compact polyline index is larger than the number of polylines.");
                    }
                    List<kh> listUnmodifiableList = Collections.unmodifiableList(((ki) kbVar.b).z);
                    ArrayList arrayList2 = new ArrayList();
                    for (kh khVar : listUnmodifiableList) {
                        int i23 = khVar.c;
                        if (i23 != 0) {
                            bb bbVar17 = (bb) khVar.aH(5, null);
                            bbVar17.x(khVar);
                            int i24 = i23 - 1;
                            kg kgVar = (kg) bbVar17;
                            if (!kgVar.b.H()) {
                                kgVar.v();
                            }
                            kh khVar2 = (kh) kgVar.b;
                            khVar2.b |= 1;
                            khVar2.c = i24;
                            arrayList2.add((kh) kgVar.t());
                        }
                    }
                    if (!kbVar.b.H()) {
                        kbVar.v();
                    }
                    ((ki) kbVar.b).z = dj.b;
                    if (!kbVar.b.H()) {
                        kbVar.v();
                    }
                    ki kiVar6 = (ki) kbVar.b;
                    bz bzVar4 = kiVar6.z;
                    if (!bzVar4.c()) {
                        kiVar6.z = bi.A(bzVar4);
                    }
                    com.google.android.libraries.navigation.internal.ael.b.m(arrayList2, kiVar6.z);
                }
                if (!lbVar.b.H()) {
                    lbVar.v();
                }
                ((lh) lbVar.b).d = dj.b;
                lbVar.f(kbVar);
                if (!lbVar.b.H()) {
                    lbVar.v();
                }
                lh lhVar4 = (lh) lbVar.b;
                lhVar4.b |= 2;
                lhVar4.f = 0;
            } else {
                bgVar = bgVar2;
                context = context2;
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.ca.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('e')).p("Selected trip index is larger than the number of directions.");
                kbVar = null;
            }
            if (kbVar != null) {
                Cif cif8 = ((ki) kbVar.b).g;
                if (cif8 == null) {
                    cif8 = Cif.a;
                }
                alVarB = al.b(cif8.c);
                if (alVarB == null) {
                    alVarB = al.DRIVE;
                }
            } else {
                alVarB = null;
            }
            ah ahVar = new ah();
            mc mcVar = (mc) mf.a.r(aiVar.b.a);
            lk lkVar = (lk) ll.a.q();
            if (!lkVar.b.H()) {
                lkVar.v();
            }
            ll llVar2 = (ll) lkVar.b;
            lh lhVar5 = (lh) lbVar.t();
            lhVar5.getClass();
            llVar2.c = lhVar5;
            llVar2.b |= 1;
            String strK = aiVar.b.k();
            if (!lkVar.b.H()) {
                lkVar.v();
            }
            ll llVar3 = (ll) lkVar.b;
            strK.getClass();
            llVar3.b |= 16;
            llVar3.e = strK;
            ll llVar4 = aiVar.b.a.c;
            if (llVar4 == null) {
                llVar4 = ll.a;
            }
            bz bzVar5 = llVar4.g;
            if (!lkVar.b.H()) {
                lkVar.v();
            }
            ll llVar5 = (ll) lkVar.b;
            bz bzVar6 = llVar5.g;
            if (!bzVar6.c()) {
                llVar5.g = bi.A(bzVar6);
            }
            com.google.android.libraries.navigation.internal.ael.b.m(bzVar5, llVar5.g);
            if (!mcVar.b.H()) {
                mcVar.v();
            }
            mf mfVar = (mf) mcVar.b;
            ll llVar6 = (ll) lkVar.t();
            llVar6.getClass();
            mfVar.c = llVar6;
            mfVar.b |= 1;
            ahVar.a = new com.google.android.libraries.navigation.internal.bp.af((mf) mcVar.t());
            ev evVar = aiVar.e;
            ahVar.d(evVar.subList(1, evVar.size()));
            ahVar.c(aiVar.c());
            ahVar.h = aiVar.i;
            if (alVarB != null) {
                ahVar.c = alVarB;
            }
            aVarB = com.google.android.libraries.navigation.internal.vv.a.b(new ai(ahVar), context);
        }
        this.k = aVarB;
        if (aVarB.d()) {
            q(this.k, bgVar, this.m);
        } else {
            q(com.google.android.libraries.navigation.internal.vv.a.a, bgVar, this.m);
        }
        if (!this.k.d()) {
            p();
            return null;
        }
        if (this.g) {
            if (!this.i) {
                com.google.android.libraries.navigation.internal.gz.f.a(5, "Warning: It looks like NavGuidanceController.continueToNextDestination() was called immediately after NavGuidanceController.startGuidance(). In order to start navigating to the next waypoint, continueToNextDestination() should be called first. Did you mean to call them in the opposite order?");
            }
            n();
        }
        this.h = false;
        return this.k.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized com.google.android.libraries.navigation.internal.vv.b c() {
        if (!this.k.d()) {
            return null;
        }
        if (this.j.e()) {
            return new com.google.android.libraries.navigation.internal.vv.b(this.k.a(), this.j.b());
        }
        com.google.android.libraries.navigation.internal.vv.a aVar = this.k;
        ar.q(aVar.e);
        return new com.google.android.libraries.navigation.internal.vv.b((ck) aVar.c.get(0), com.google.android.libraries.navigation.internal.vv.a.c((an) aVar.e.O().get(0)));
    }

    public final synchronized com.google.android.libraries.navigation.internal.vv.c d() {
        if (!this.k.d()) {
            return null;
        }
        if (!this.j.e()) {
            com.google.android.libraries.navigation.internal.vv.a aVar = this.k;
            ar.q(aVar.e);
            List listP = aVar.e.P(0.0d);
            ii.a aVarE = aVar.e.E();
            return new com.google.android.libraries.navigation.internal.vv.c((int) com.google.android.libraries.navigation.internal.ja.a.b((Duration) listP.get(0)), aVar.e.Z(0.0d)[0], aVarE.e);
        }
        o oVar = this.j;
        ar.r(oVar.e, "hasRemainingRoute is false.");
        double dA = oVar.e.a();
        bg bgVar = oVar.e.b;
        return new com.google.android.libraries.navigation.internal.vv.c(bgVar.P(dA).stream().mapToInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.vw.l
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return (int) com.google.android.libraries.navigation.internal.ja.a.b((Duration) obj);
            }
        }).toArray()[0], bgVar.Z(dA)[0], bgVar.E().e);
    }

    public final synchronized o e() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized List f() {
        if (!this.k.d()) {
            return new ArrayList();
        }
        com.google.android.libraries.navigation.internal.vv.a aVar = this.k;
        ar.q(aVar.e);
        List listO = aVar.e.O();
        int size = aVar.c.size();
        ar.l(listO.size() == size, "The number of subPolylines does not match the number of destinations.");
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.google.android.libraries.navigation.internal.vv.b((ck) aVar.c.get(i), com.google.android.libraries.navigation.internal.vv.a.c((an) listO.get(i))));
        }
        if (this.j.e()) {
            arrayList.set(0, new com.google.android.libraries.navigation.internal.vv.b(this.k.a(), this.j.b()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized List g() {
        if (!this.k.d()) {
            return new ArrayList();
        }
        int i = 0;
        if (!this.j.e()) {
            com.google.android.libraries.navigation.internal.vv.a aVar = this.k;
            ar.q(aVar.e);
            List listP = aVar.e.P(0.0d);
            int[] iArrZ = aVar.e.Z(0.0d);
            ev evVar = aVar.e.I;
            ArrayList arrayList = new ArrayList(listP.size());
            while (i < listP.size()) {
                arrayList.add(new com.google.android.libraries.navigation.internal.vv.c((int) com.google.android.libraries.navigation.internal.ja.a.b((Duration) listP.get(i)), iArrZ[i], ((ii.a) evVar.get(i)).e));
                i++;
            }
            return arrayList;
        }
        o oVar = this.j;
        ar.r(oVar.e, "hasRemainingRoute is false.");
        double dA = oVar.e.a();
        bg bgVar = oVar.e.b;
        int[] array = bgVar.P(dA).stream().mapToInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.vw.m
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return (int) com.google.android.libraries.navigation.internal.ja.a.b((Duration) obj);
            }
        }).toArray();
        int[] iArrZ2 = bgVar.Z(dA);
        ev evVar2 = bgVar.I;
        int length = array.length;
        int length2 = iArrZ2.length;
        boolean z = length == length2 && length2 == ((lv) evVar2).c;
        Integer numValueOf = Integer.valueOf(length);
        Integer numValueOf2 = Integer.valueOf(length2);
        if (!z) {
            throw new IllegalStateException(bq.a("ETA array size = %s Distance array size = %s Delay category list size = %s", numValueOf, numValueOf2, evVar2));
        }
        ArrayList arrayList2 = new ArrayList(length);
        while (i < array.length) {
            arrayList2.add(new com.google.android.libraries.navigation.internal.vv.c(array[i], iArrZ2[i], ((ii.a) evVar2.get(i)).e));
            i++;
        }
        return arrayList2;
    }

    public final synchronized List h() {
        ArrayList arrayList;
        o oVar = this.j;
        ad adVarN = ad.n(oVar.d);
        if (!oVar.d.isEmpty()) {
            float fE = (float) ((x) oVar.d.get(0)).e();
            if (adVarN.b.length > 4) {
                float f = fE * 4.0f;
                int iE = adVarN.e();
                boolean[] zArr = new boolean[iE];
                zArr[0] = true;
                int i = iE - 1;
                zArr[i] = true;
                int iJ = adVarN.j(f * f, 0, i, new x(), new x(), new x(), new x(), zArr) + 2;
                if (iJ != iE) {
                    int[] iArr = new int[iJ + iJ];
                    int i2 = 0;
                    for (int i3 = 0; i3 < iE; i3++) {
                        if (zArr[i3]) {
                            int i4 = i3 + i3;
                            int[] iArr2 = adVarN.b;
                            iArr[i2] = iArr2[i4];
                            i2 += 2;
                            iArr[i2 + 1] = iArr2[i4 + 1];
                        }
                    }
                    adVarN = new ad(iArr, adVarN.e, adVarN.c, adVarN.d, adVarN.f);
                }
            }
        }
        arrayList = new ArrayList(adVarN.e());
        Iterator it2 = adVarN.q().iterator();
        while (it2.hasNext()) {
            arrayList.add(o.a((x) it2.next()));
        }
        return arrayList;
    }

    public final synchronized void i() {
        k();
        this.b.d(this.L);
    }

    public final synchronized void j() {
        this.x.a();
        C(com.google.android.libraries.navigation.internal.vv.a.a, this.k.e, this.m, true);
        this.k = com.google.android.libraries.navigation.internal.vv.a.a;
        this.D = null;
        p();
    }

    public final synchronized void k() {
        this.x.a();
        this.D = null;
        this.s = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.t = null;
        this.j.g = null;
        com.google.android.libraries.navigation.internal.vp.i iVar = this.f;
        if (iVar != null) {
            iVar.g();
        }
    }

    public final synchronized void l(int i) {
        m(i);
    }

    public final synchronized void m(int i) {
        ap.UI_THREAD.f();
        this.B.a = 1 == (i & 1);
        if ((i & 4) != 0) {
            this.y.c(com.google.android.libraries.navigation.internal.sl.m.UNMUTED);
        } else if ((i & 2) != 0) {
            this.y.c(com.google.android.libraries.navigation.internal.sl.m.MINIMAL);
        } else {
            this.y.c(com.google.android.libraries.navigation.internal.sl.m.MUTED);
        }
        this.z.n(ab.aL, (i & 8) != 0);
    }

    public final synchronized void n() {
        com.google.android.libraries.navigation.internal.vv.a aVar;
        bh bhVar;
        if (this.k.d() && (bhVar = (aVar = this.k).b) != null) {
            ai aiVar = aVar.d;
            com.google.android.libraries.navigation.internal.so.d dVarB = com.google.android.libraries.navigation.internal.so.d.b(bhVar, aiVar.b());
            dVarB.c = ((com.google.android.libraries.navigation.internal.si.b) this.m).a;
            dVarB.f = aiVar.c().d == 64;
            this.r.e(new com.google.android.libraries.navigation.internal.so.e(dVarB), this.E);
        }
        if (!this.g) {
            this.j.d();
            com.google.android.libraries.navigation.internal.ia.e eVar = this.a;
            i iVar = this.K;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.sr.o.class, new k(0, com.google.android.libraries.navigation.internal.sr.o.class, iVar, ap.UI_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.sr.d.class, new k(1, com.google.android.libraries.navigation.internal.sr.d.class, iVar, ap.UI_THREAD));
            eVar.c(iVar, fzVar.a());
            this.F.a(this.I, this.H);
            this.G.c(this.J, this.H);
        }
        this.g = true;
        this.h = false;
    }

    public final synchronized void o(Intent intent) {
        this.E = intent;
        n();
    }

    public final synchronized void p() {
        if (this.g) {
            this.g = false;
            this.h = true;
            this.i = false;
            this.r.f();
            this.a.e(this.K);
            this.F.b(this.I);
            this.G.d(this.J);
        }
    }

    public final synchronized void q(com.google.android.libraries.navigation.internal.vv.a aVar, bg bgVar, com.google.android.libraries.navigation.internal.si.d dVar) {
        C(aVar, bgVar, dVar, false);
    }

    public final void r() {
        boolean z = true;
        if (!this.o && this.f645n) {
            z = false;
        }
        this.a.a(z ? com.google.android.libraries.navigation.internal.tl.b.a : com.google.android.libraries.navigation.internal.tl.b.b);
    }

    public final void s(bh bhVar) {
        synchronized (this) {
            ai aiVar = this.k.d;
            if (aiVar != null) {
                com.google.android.libraries.navigation.internal.zb.j jVar = bg.a;
                ar.a(bhVar.k());
                bg bgVarF = bhVar.f();
                ar.q(bgVarF);
                ll llVar = bgVarF.d.c;
                if (llVar == null) {
                    llVar = ll.a;
                }
                lh lhVar = llVar.c;
                if (lhVar == null) {
                    lhVar = lh.a;
                }
                lb lbVar = (lb) lh.a.r(lhVar);
                if (!lbVar.b.H()) {
                    lbVar.v();
                }
                ((lh) lbVar.b).d = dj.b;
                if (!lbVar.b.H()) {
                    lbVar.v();
                }
                ((lh) lbVar.b).i = dj.b;
                HashSet hashSet = new HashSet();
                Iterator it2 = bhVar.iterator();
                int i = 0;
                int i2 = 0;
                while (it2.hasNext()) {
                    bg bgVar = (bg) it2.next();
                    hashSet.addAll(bgVar.d.d);
                    ll llVar2 = bgVar.d.c;
                    if (llVar2 == null) {
                        llVar2 = ll.a;
                    }
                    lh lhVar2 = llVar2.c;
                    if (lhVar2 == null) {
                        lhVar2 = lh.a;
                    }
                    ki kiVar = (ki) lhVar2.d.get(bgVar.f);
                    bb bbVar = (bb) kiVar.aH(5, null);
                    bbVar.x(kiVar);
                    kb kbVar = (kb) bbVar;
                    ii iiVar = bgVar.u;
                    if (iiVar == null || iiVar.equals(ii.a)) {
                        if (!kbVar.b.H()) {
                            kbVar.v();
                        }
                        ki kiVar2 = (ki) kbVar.b;
                        ki kiVar3 = ki.a;
                        kiVar2.i = null;
                        kiVar2.b &= -33;
                    } else {
                        if (!kbVar.b.H()) {
                            kbVar.v();
                        }
                        ki kiVar4 = (ki) kbVar.b;
                        ki kiVar5 = ki.a;
                        kiVar4.i = iiVar;
                        kiVar4.b |= 32;
                    }
                    jg jgVar = bgVar.E;
                    if (jgVar != null) {
                        if (!kbVar.b.H()) {
                            kbVar.v();
                        }
                        ki kiVar6 = (ki) kbVar.b;
                        kiVar6.q = jgVar;
                        kiVar6.b |= 131072;
                    } else {
                        if (!kbVar.b.H()) {
                            kbVar.v();
                        }
                        ki kiVar7 = (ki) kbVar.b;
                        kiVar7.q = null;
                        kiVar7.b &= -131073;
                    }
                    if ((kiVar.b & 512) != 0) {
                        lbVar.e((la) lhVar2.i.get(kiVar.l));
                        if (!kbVar.b.H()) {
                            kbVar.v();
                        }
                        ki kiVar8 = (ki) kbVar.b;
                        kiVar8.b |= 512;
                        kiVar8.l = i;
                        i++;
                    }
                    if (bgVar == bgVarF) {
                        if (!lbVar.b.H()) {
                            lbVar.v();
                        }
                        lh lhVar3 = (lh) lbVar.b;
                        lhVar3.b |= 2;
                        lhVar3.f = i2;
                    }
                    i2++;
                    lbVar.g((ki) kbVar.t());
                }
                lk lkVar = (lk) ll.a.q();
                if (!lkVar.b.H()) {
                    lkVar.v();
                }
                ll llVar3 = (ll) lkVar.b;
                lh lhVar4 = (lh) lbVar.t();
                lhVar4.getClass();
                llVar3.c = lhVar4;
                llVar3.b |= 1;
                ll llVar4 = bgVarF.d.c;
                if (llVar4 == null) {
                    llVar4 = ll.a;
                }
                com.google.android.libraries.navigation.internal.acc.b bVar = llVar4.d;
                if (bVar == null) {
                    bVar = com.google.android.libraries.navigation.internal.acc.b.a;
                }
                if (!lkVar.b.H()) {
                    lkVar.v();
                }
                ll llVar5 = (ll) lkVar.b;
                bVar.getClass();
                llVar5.d = bVar;
                llVar5.b |= 4;
                ll llVar6 = bgVarF.d.c;
                if (llVar6 == null) {
                    llVar6 = ll.a;
                }
                String str = llVar6.e;
                if (!lkVar.b.H()) {
                    lkVar.v();
                }
                ll llVar7 = (ll) lkVar.b;
                str.getClass();
                llVar7.b |= 16;
                llVar7.e = str;
                nv nvVar = bgVarF.v;
                mc mcVar = (mc) mf.a.q();
                ll llVar8 = (ll) lkVar.t();
                if (!mcVar.b.H()) {
                    mcVar.v();
                }
                mf mfVar = (mf) mcVar.b;
                llVar8.getClass();
                mfVar.c = llVar8;
                mfVar.b |= 1;
                if (!mcVar.b.H()) {
                    mcVar.v();
                }
                mf mfVar2 = (mf) mcVar.b;
                bz bzVar = mfVar2.d;
                if (!bzVar.c()) {
                    mfVar2.d = bi.A(bzVar);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(hashSet, mfVar2.d);
                com.google.android.libraries.navigation.internal.bp.af afVar = new com.google.android.libraries.navigation.internal.bp.af((mf) mcVar.t());
                bg bgVarF2 = bhVar.f();
                ah ahVar = new ah(aiVar);
                ahVar.a = afVar;
                ahVar.d(bgVarF2.B());
                ahVar.e = bgVarF2.q;
                this.k = com.google.android.libraries.navigation.internal.vv.a.b(new ai(ahVar), this.d);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void t(bg bgVar) {
        if (!this.g) {
            ad adVar = !this.k.b.l() ? this.k.b.f().m : null;
            if (adVar != null && !adVar.equals(bgVar.m)) {
                bh bhVar = this.k.b;
                ad adVar2 = bgVar.m;
                ev evVarB = bhVar.b();
                int i = 0;
                while (true) {
                    if (i >= evVarB.size()) {
                        i = -1;
                        break;
                    }
                    ad adVar3 = ((bg) evVarB.get(i)).m;
                    if (((bg) evVarB.get(i)).m.equals(adVar2)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    com.google.android.libraries.navigation.internal.vv.a aVar = this.k;
                    bg bgVar2 = aVar.e;
                    s(aVar.b.j(i));
                    q(this.k, bgVar2, this.m);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r8 == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean u(com.google.android.libraries.navigation.internal.tj.j jVar) {
        boolean zEquals;
        if (jVar.h) {
            ck ckVarA = this.k.a();
            ck ckVarU = jVar.c().b.u();
            if (!ckVarA.X() || !ckVarU.X()) {
                if (ckVarA.Y() && ckVarU.Y()) {
                    r rVarN = ckVarA.n();
                    r rVarN2 = ckVarU.n();
                    if (Math.abs(rVarN.a - rVarN2.a) < 1.0E-7d && Math.abs(rVarN.b - rVarN2.b) < 1.0E-7d) {
                    }
                } else if (ckVarA.w() != null) {
                    zEquals = ckVarA.w().equals(ckVarU.w());
                }
                return true;
            }
            zEquals = ckVarA.m().equals(ckVarU.m());
        }
        return false;
    }

    public final synchronized boolean v() {
        return this.g && this.k.d();
    }

    public final synchronized com.google.android.libraries.navigation.internal.vq.b w(List list, lr lrVar, com.google.android.libraries.navigation.internal.si.d dVar, long j, as asVar) {
        int i = ev.d;
        return x(list, lv.a, lrVar, dVar, j, asVar);
    }

    public final synchronized com.google.android.libraries.navigation.internal.vq.b x(List list, List list2, lr lrVar, com.google.android.libraries.navigation.internal.si.d dVar, long j, as asVar) {
        com.google.android.libraries.navigation.internal.vq.b bVarA;
        String string = UUID.randomUUID().toString();
        this.D = string;
        this.p = this.c.a();
        ar.b(!list.isEmpty(), "Tried to set an empty destination list.");
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ar.r((ck) it2.next(), "Tried to set a null destination.");
        }
        bVarA = com.google.android.libraries.navigation.internal.vq.b.a();
        this.m = dVar;
        d dVar2 = new d(this, asVar, string, dVar, bVarA, list, lrVar, j);
        e eVar = new e(this, string);
        f fVar = new f(this, string);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        this.x.c(arrayList, list2, lrVar, j, dVar2, eVar, fVar);
        B(string, cd.d, this.c.a() - this.p, null);
        return bVarA;
    }

    public final synchronized void y(int i, int i2, fc fcVar) {
        this.j.f.add(new n(i, i2, fcVar));
    }

    public final synchronized void z(fc fcVar) {
        ArrayList arrayList = new ArrayList();
        o oVar = this.j;
        for (n nVar : oVar.f) {
            if (nVar.e.equals(fcVar)) {
                arrayList.add(nVar);
            }
        }
        oVar.f.removeAll(arrayList);
    }
}
