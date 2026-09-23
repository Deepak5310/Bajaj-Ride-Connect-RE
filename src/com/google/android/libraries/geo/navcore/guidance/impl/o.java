package com.google.android.libraries.geo.navcore.guidance.impl;

import android.util.LongSparseArray;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.bp.be;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bk;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.sv.bd;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.kc;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements com.google.android.libraries.navigation.internal.rw.n {
    private final ExecutorService a;
    private final com.google.android.libraries.navigation.internal.sv.ak b;

    public o(ExecutorService executorService, com.google.android.libraries.navigation.internal.sv.ak akVar) {
        this.a = executorService;
        this.b = akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.n
    public final void a(final com.google.android.libraries.navigation.internal.db.r rVar) {
        this.a.submit(new Callable() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.d(rVar);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.rw.n
    public final void b(ck ckVar) {
        bg bgVar;
        boolean zA;
        bg bgVar2;
        int iM;
        final com.google.android.libraries.navigation.internal.sv.ak akVar = this.b;
        com.google.android.libraries.navigation.internal.sc.f fVar = akVar.J.f;
        if (fVar == null || (bgVar = fVar.e) == null) {
            return;
        }
        ev evVarB = bgVar.B();
        for (int i = 1; i < evVarB.size(); i++) {
            ck ckVar2 = (ck) evVarB.get(i);
            if (ckVar2.s() == ckVar.s() && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.x(), ckVar.x()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.m(), ckVar.m()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.n(), ckVar.n()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.f(), ckVar.f()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.k(), ckVar.k()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.o(), ckVar.o()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.q(), ckVar.q()) && Arrays.equals(ckVar2.G(), ckVar.G()) && Arrays.equals(ckVar2.F(), ckVar.F()) && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.u(), ckVar.u()) && ckVar2.B() == ckVar.B() && com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.t(), ckVar.t())) {
                bj bjVar = null;
                if (ckVar2.W() && ckVar.W()) {
                    com.google.android.libraries.navigation.internal.adq.t tVarQ = ckVar2.Q();
                    com.google.android.libraries.navigation.internal.yx.ar.q(tVarQ);
                    bb bbVar = (bb) tVarQ.aH(5, null);
                    bbVar.x(tVarQ);
                    com.google.android.libraries.navigation.internal.adq.s sVar = (com.google.android.libraries.navigation.internal.adq.s) bbVar;
                    if (!sVar.b.H()) {
                        sVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adq.t tVar = (com.google.android.libraries.navigation.internal.adq.t) sVar.b;
                    tVar.b &= -3;
                    tVar.c = com.google.android.libraries.navigation.internal.adq.t.a.c;
                    com.google.android.libraries.navigation.internal.adq.t tVar2 = (com.google.android.libraries.navigation.internal.adq.t) sVar.t();
                    com.google.android.libraries.navigation.internal.adq.t tVarQ2 = ckVar.Q();
                    com.google.android.libraries.navigation.internal.yx.ar.q(tVarQ2);
                    bb bbVar2 = (bb) tVarQ2.aH(5, null);
                    bbVar2.x(tVarQ2);
                    com.google.android.libraries.navigation.internal.adq.s sVar2 = (com.google.android.libraries.navigation.internal.adq.s) bbVar2;
                    if (!sVar2.b.H()) {
                        sVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.adq.t tVar3 = (com.google.android.libraries.navigation.internal.adq.t) sVar2.b;
                    tVar3.b &= -3;
                    tVar3.c = com.google.android.libraries.navigation.internal.adq.t.a.c;
                    zA = com.google.android.libraries.navigation.internal.yx.am.a(tVar2, (com.google.android.libraries.navigation.internal.adq.t) sVar2.t());
                } else {
                    zA = com.google.android.libraries.navigation.internal.yx.am.a(ckVar2.g(), ckVar.g());
                }
                if (zA && ckVar2.L() == ckVar.L() && ckVar2.a() == ckVar.a()) {
                    com.google.android.libraries.navigation.internal.sc.f fVar2 = akVar.J.f;
                    if (fVar2 == null || (iM = (bgVar2 = fVar2.e).m()) <= 2 || i > iM) {
                        return;
                    }
                    eq eqVar = new eq();
                    ev evVarB2 = bgVar2.B();
                    boolean z = false;
                    for (int i2 = 1; i2 < evVarB2.size(); i2++) {
                        ck ckVar3 = (ck) evVarB2.get(i2);
                        if (z) {
                            z = true;
                        } else {
                            if (i2 == i) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        eqVar.h(ckVar3);
                    }
                    if (z) {
                        final ev evVarG = eqVar.g();
                        com.google.android.libraries.navigation.internal.sc.f fVar3 = akVar.J.f;
                        if (fVar3 != null) {
                            akVar.l();
                            final com.google.android.libraries.navigation.internal.ael.x xVarJ = akVar.j();
                            final boolean zA2 = akVar.m.a().a();
                            Logger logger = com.google.android.libraries.navigation.internal.zo.q.a;
                            com.google.android.libraries.navigation.internal.zo.o oVar = new com.google.android.libraries.navigation.internal.zo.o();
                            oVar.b(akVar.G);
                            final bg bgVar3 = fVar3.e;
                            akVar.v = oVar.a(new br() { // from class: com.google.android.libraries.navigation.internal.sv.z
                                @Override // com.google.android.libraries.navigation.internal.yx.br
                                public final Object a() {
                                    ak akVar2 = akVar;
                                    lt ltVarB = akVar2.f579n.b(true);
                                    return akVar2.o.a(akVar2.D, evVarG, bgVar3, xVarJ, zA2, ltVarB);
                                }
                            }, new com.google.android.libraries.navigation.internal.zo.b(), new com.google.android.libraries.navigation.internal.sv.v(akVar));
                            akVar.s(akVar.v, akVar.D);
                            akVar.p.f(akVar.C);
                            bjVar = akVar.v;
                        }
                        if (bjVar != null) {
                            com.google.android.libraries.navigation.internal.aac.j.i(bjVar, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.sv.y
                                @Override // com.google.android.libraries.navigation.internal.aac.t
                                public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj) {
                                    com.google.android.libraries.navigation.internal.sx.as asVar = (com.google.android.libraries.navigation.internal.sx.as) obj;
                                    int i3 = ak.K;
                                    boolean z2 = false;
                                    if (asVar != null && asVar.b()) {
                                        z2 = true;
                                    }
                                    return com.google.android.libraries.navigation.internal.aac.az.h(Boolean.valueOf(z2));
                                }
                            }, akVar.G);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.n
    public final void c(final String str) {
        this.a.submit(new Callable() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.e(str);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0157  */
    public final /* synthetic */ Boolean d(com.google.android.libraries.navigation.internal.db.r rVar) throws Exception {
        com.google.android.libraries.navigation.internal.sc.f fVarB;
        com.google.android.libraries.navigation.internal.sv.j jVar;
        jg jgVar;
        com.google.android.libraries.navigation.internal.db.r rVar2;
        com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
        com.google.android.libraries.navigation.internal.sv.ak akVar = this.b;
        akVar.D = rVar;
        boolean z = false;
        if (akVar.u) {
            com.google.android.libraries.navigation.internal.sc.f fVar = akVar.J.f;
            if (fVar == null) {
                z = true;
            } else {
                int iE = fVar.e();
                if (fVar.i()) {
                    com.google.android.libraries.navigation.internal.tj.o oVarG = akVar.g();
                    akVar.q.d(oVarG.d);
                    akVar.p.h(oVarG, rVar, akVar.C, null);
                    akVar.e.d(oVarG, rVar);
                    z = true;
                } else {
                    com.google.android.libraries.navigation.internal.sc.d dVarA = akVar.J.a(rVar);
                    akVar.t.b();
                    akVar.s.a(dVarA);
                    if (dVarA.b() != null) {
                        akVar.C = dVarA.b();
                    }
                    com.google.android.libraries.navigation.internal.sd.a aVarA = dVarA.a() != null ? dVarA.a() : null;
                    com.google.android.libraries.navigation.internal.sv.k kVar = akVar.J;
                    com.google.android.libraries.navigation.internal.sc.f fVar2 = kVar.f;
                    com.google.android.libraries.navigation.internal.yx.ar.q(fVar2);
                    Iterator it2 = kVar.e.iterator();
                    boolean z2 = false;
                    while (it2.hasNext()) {
                        com.google.android.libraries.navigation.internal.sc.f fVar3 = (com.google.android.libraries.navigation.internal.sc.f) it2.next();
                        if (!fVar3.c) {
                            it2.remove();
                            if (fVar3 == kVar.f) {
                                z2 = true;
                            }
                        }
                    }
                    if (z2) {
                        bg bgVar = fVar2.e;
                        int iA = lq.a(bgVar.P.m);
                        if (iA == 0) {
                            iA = lq.b;
                        }
                        if (iA == lq.d) {
                            com.google.android.libraries.navigation.internal.sc.f fVar4 = kVar.f;
                            com.google.android.libraries.navigation.internal.yx.ar.q(fVar4);
                            kVar.e.add(fVar4);
                            int iMax = Math.max(fVar4.e.P.l - ((int) fVar4.a()), 0);
                            EnumMap enumMapG = kc.g(com.google.android.libraries.navigation.internal.bu.a.class);
                            enumMapG.put(com.google.android.libraries.navigation.internal.bu.a.TARGET_DISTANCE, Integer.valueOf(iMax));
                            if (iMax == 0) {
                                com.google.android.libraries.navigation.internal.bu.a aVar = com.google.android.libraries.navigation.internal.bu.a.TRIP_ORDER;
                                int i = lq.b;
                                int i2 = i - 1;
                                if (i == 0) {
                                    throw null;
                                }
                                enumMapG.put(aVar, Integer.valueOf(i2));
                            }
                            jVar = new com.google.android.libraries.navigation.internal.sv.j(new com.google.android.libraries.navigation.internal.bc.a(enumMapG));
                        } else if (kVar.e.isEmpty()) {
                            kVar.e.add(fVar2);
                            jVar = new com.google.android.libraries.navigation.internal.sv.j(true);
                        } else {
                            boolean z3 = fVar2.b.f572n;
                            if (iA == lq.c) {
                                if (z3) {
                                    fVarB = kVar.c();
                                    if (fVarB == null || com.google.android.libraries.navigation.internal.hf.c.f((int) (fVarB.b() - fVar2.b())) == 3) {
                                        fVarB = null;
                                    }
                                } else {
                                    fVarB = kVar.c();
                                }
                            } else if (z3) {
                                fVarB = kVar.b();
                                if (fVarB == null || !fVarB.e.U() || com.google.android.libraries.navigation.internal.hf.u.g((int) Math.round(fVarB.d() - fVar2.d()), false) == 3) {
                                    fVarB = null;
                                }
                            } else {
                                fVarB = kVar.b();
                            }
                            if (fVarB != null) {
                                String str = bgVar.r;
                                jVar = new com.google.android.libraries.navigation.internal.sv.j(fVarB);
                            } else {
                                kVar.e.add(fVar2);
                                jVar = new com.google.android.libraries.navigation.internal.sv.j(true);
                            }
                        }
                    } else {
                        jVar = new com.google.android.libraries.navigation.internal.sv.j(false);
                    }
                    if (jVar.a) {
                        akVar.H(jVar.b, true, false, !akVar.h.f165n);
                    }
                    com.google.android.libraries.navigation.internal.sc.f fVar5 = jVar.c;
                    if (fVar5 != null) {
                        akVar.L(fVar5, false, false, com.google.android.libraries.navigation.internal.rw.z.c);
                        if (akVar.h.h) {
                            akVar.n(fVar5, null, false);
                        }
                    }
                    com.google.android.libraries.navigation.internal.sc.f fVar6 = akVar.J.f;
                    com.google.android.libraries.navigation.internal.yx.ar.q(fVar6);
                    int iE2 = fVar6.e();
                    com.google.android.libraries.navigation.internal.tj.o oVarG2 = akVar.g();
                    if (iE2 != -1 && iE2 != iE) {
                        akVar.e.e(oVarG2, iE != -1 && iE2 == iE + 1);
                    }
                    akVar.q.d(oVarG2.d);
                    akVar.e.d(oVarG2, rVar);
                    com.google.android.libraries.navigation.internal.ia.e eVar = akVar.d;
                    com.google.android.libraries.navigation.internal.sv.k kVar2 = akVar.J;
                    LongSparseArray longSparseArray = new LongSparseArray();
                    LongSparseArray longSparseArray2 = new LongSparseArray();
                    LongSparseArray longSparseArray3 = new LongSparseArray();
                    for (com.google.android.libraries.navigation.internal.sc.f fVar7 : kVar2.e) {
                        long j = fVar7.e.Y;
                        Duration durationB = com.google.android.libraries.navigation.internal.aaa.a.b(fVar7.d());
                        double dB = fVar7.b();
                        double dA = fVar7.a();
                        longSparseArray.put(j, durationB);
                        longSparseArray2.put(j, Double.valueOf(dB));
                        longSparseArray3.put(j, Double.valueOf(dA));
                    }
                    eVar.a(new bk(longSparseArray, longSparseArray2, longSparseArray3));
                    if (fVar6.i()) {
                        akVar.e.c(oVarG2);
                        akVar.q.b();
                        akVar.p.k();
                        if (!akVar.h.b && akVar.m.a().a()) {
                            if (akVar.h.c) {
                                akVar.k.run();
                            } else {
                                akVar.j.postDelayed(akVar.k, 5000L);
                            }
                        }
                        akVar.k();
                    }
                    akVar.p.h(oVarG2, rVar, akVar.C, aVarA);
                    com.google.android.libraries.navigation.internal.sc.f fVar8 = akVar.J.f;
                    if (fVar8 != null && (jgVar = fVar8.e.E) != null && (rVar2 = fVar8.a) != null && rVar2.k().b && fVar8.j()) {
                        akVar.q(jgVar, fVar8.e.i.toEpochMilli());
                    }
                    com.google.android.libraries.navigation.internal.sv.an anVar = akVar.l;
                    bg bgVar2 = fVar6.e;
                    if (bgVar2.X() && bgVar2.u != null && akVar.c.a() - akVar.B > ((long) akVar.g.f()) * 1000) {
                        eq eqVar = new eq();
                        for (int i3 = 0; i3 < ((lv) bgVar2.I).c; i3++) {
                            eqVar.h(ii.a.DELAY_NODATA);
                        }
                        bgVar2.I = eqVar.g();
                        bgVar2.T = ii.a.DELAY_NODATA;
                        synchronized (bgVar2.S) {
                            be beVar = bgVar2.S;
                            beVar.c = null;
                            beVar.d = null;
                            bgVar2.u = null;
                            bgVar2.z = null;
                            bgVar2.A = -1;
                            bgVar2.B = "";
                            bgVar2.C = false;
                            bgVar2.D = -1;
                        }
                        ((com.google.android.libraries.navigation.internal.kk.j) akVar.b.a(com.google.android.libraries.navigation.internal.km.af.m)).a();
                    }
                    akVar.p();
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Boolean e(String str) throws Exception {
        com.google.android.libraries.navigation.internal.db.r rVar;
        com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL.f();
        bd bdVar = (bd) com.google.android.libraries.navigation.internal.sv.be.a.q();
        if (!bdVar.b.H()) {
            bdVar.v();
        }
        com.google.android.libraries.navigation.internal.sv.ak akVar = this.b;
        com.google.android.libraries.navigation.internal.sv.be beVar = (com.google.android.libraries.navigation.internal.sv.be) bdVar.b;
        str.getClass();
        beVar.b = str;
        akVar.m("com.google.android.libraries.geo.navcore.service.guider.SwitchRouteProto", bdVar.t());
        akVar.q.b();
        boolean zC = akVar.C(str, null);
        if (zC && akVar.h.f165n && (rVar = akVar.D) != null) {
            akVar.w(rVar);
            zC = true;
        }
        return Boolean.valueOf(zC);
    }
}
