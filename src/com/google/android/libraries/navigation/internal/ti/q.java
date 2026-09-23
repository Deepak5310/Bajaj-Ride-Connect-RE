package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ael.am;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zs.bs;
import com.google.android.libraries.navigation.internal.zs.bt;
import com.google.android.libraries.navigation.internal.zs.bw;
import com.google.android.libraries.navigation.internal.zs.bx;
import com.google.android.libraries.navigation.internal.zs.by;
import com.google.android.libraries.navigation.internal.zs.bz;
import com.google.android.libraries.navigation.internal.zs.ca;
import com.google.android.libraries.navigation.internal.zs.cc;
import com.google.android.libraries.navigation.internal.zs.cd;
import com.google.android.libraries.navigation.internal.zs.cs;
import com.google.android.libraries.navigation.internal.zs.ct;
import com.google.android.libraries.navigation.internal.zs.cv;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.db;
import com.google.android.libraries.navigation.internal.zs.fa;
import com.google.android.libraries.navigation.internal.zs.fs;
import com.google.android.libraries.navigation.internal.zs.ft;
import com.google.android.libraries.navigation.internal.zs.fw;
import com.google.android.libraries.navigation.internal.zs.fx;
import j$.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public q(int i, Class cls, p pVar, ap apVar, Executor executor) {
        super(cls, pVar, apVar, executor);
        this.f = i;
    }

    /* JADX WARN: Code duplicated, block: B:287:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:289:0x0800  */
    /* JADX WARN: Code duplicated, block: B:322:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        cz czVar;
        int i;
        cz czVarA;
        boolean z = false;
        switch (this.f) {
            case 0:
                p pVar = (p) this.c;
                com.google.android.libraries.navigation.internal.tf.d dVar = (com.google.android.libraries.navigation.internal.tf.d) aVar;
                if (pVar.g("onLoggerEvent")) {
                    db dbVar = dVar.a;
                    ac acVar = pVar.h;
                    bb bbVar = (bb) dbVar.aH(5, null);
                    bbVar.x(dbVar);
                    acVar.c((cz) bbVar);
                    return;
                }
                return;
            case 1:
                p pVar2 = (p) this.c;
                com.google.android.libraries.navigation.internal.sr.a aVar2 = (com.google.android.libraries.navigation.internal.sr.a) aVar;
                if (!pVar2.g("onActivityRecognitionEvent") || (i = pVar2.g.a.F) <= 0) {
                    return;
                }
                long millis = TimeUnit.SECONDS.toMillis(pVar2.g.a.E);
                if (millis > 0) {
                    long j = aVar2.a.c;
                    if (j >= pVar2.B + ((millis * 9) / 10)) {
                        pVar2.B = j;
                        com.google.android.libraries.navigation.internal.zs.o oVar = (com.google.android.libraries.navigation.internal.zs.o) com.google.android.libraries.navigation.internal.zs.r.a.q();
                        int i2 = aVar2.a.d;
                        if (!oVar.b.H()) {
                            oVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.r rVar = (com.google.android.libraries.navigation.internal.zs.r) oVar.b;
                        rVar.b |= 1;
                        rVar.e = i2;
                        for (com.google.android.libraries.navigation.internal.lu.d dVar2 : aVar2.a.a) {
                            com.google.android.libraries.navigation.internal.zs.q qVar = (com.google.android.libraries.navigation.internal.zs.q) p.b.getOrDefault(Integer.valueOf(dVar2.a()), com.google.android.libraries.navigation.internal.zs.q.UNKNOWN);
                            if (!oVar.b.H()) {
                                oVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zs.r rVar2 = (com.google.android.libraries.navigation.internal.zs.r) oVar.b;
                            qVar.getClass();
                            bq bqVar = rVar2.c;
                            if (!bqVar.c()) {
                                rVar2.c = bi.w(bqVar);
                            }
                            rVar2.c.i(qVar.w);
                            int i3 = dVar2.b;
                            if (!oVar.b.H()) {
                                oVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zs.r rVar3 = (com.google.android.libraries.navigation.internal.zs.r) oVar.b;
                            bq bqVar2 = rVar3.d;
                            if (!bqVar2.c()) {
                                rVar3.d = bi.w(bqVar2);
                            }
                            rVar3.d.i(i3);
                            int i4 = i4 - 1;
                            if (i4 <= 0) {
                                if (((com.google.android.libraries.navigation.internal.zs.r) oVar.b).c.size() != 0) {
                                    czVar = (cz) db.a.q();
                                    com.google.android.libraries.navigation.internal.zs.r rVar4 = (com.google.android.libraries.navigation.internal.zs.r) oVar.t();
                                    if (!czVar.b.H()) {
                                        czVar.v();
                                    }
                                    db dbVar2 = (db) czVar.b;
                                    rVar4.getClass();
                                    dbVar2.d = rVar4;
                                    dbVar2.c = 27;
                                    ((com.google.android.libraries.navigation.internal.zs.r) oVar.b).c.size();
                                    pVar2.h.c(czVar);
                                    return;
                                }
                                return;
                            }
                        }
                        if (((com.google.android.libraries.navigation.internal.zs.r) oVar.b).c.size() != 0) {
                            czVar = (cz) db.a.q();
                            com.google.android.libraries.navigation.internal.zs.r rVar5 = (com.google.android.libraries.navigation.internal.zs.r) oVar.t();
                            if (!czVar.b.H()) {
                                czVar.v();
                            }
                            db dbVar3 = (db) czVar.b;
                            rVar5.getClass();
                            dbVar3.d = rVar5;
                            dbVar3.c = 27;
                            ((com.google.android.libraries.navigation.internal.zs.r) oVar.b).c.size();
                            pVar2.h.c(czVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 2:
                ap.NAVIGATION_INTERNAL.f();
                return;
            case 3:
                p pVar3 = (p) this.c;
                ap.NAVIGATION_INTERNAL.f();
                com.google.android.libraries.navigation.internal.db.r rVarD = ((com.google.android.libraries.navigation.internal.db.s) aVar).d();
                if (rVarD != null) {
                    int iA = fa.a(pVar3.g.a.z);
                    if (iA == 0) {
                        iA = fa.a;
                    }
                    if (iA != fa.b) {
                        pVar3.i.b(rVarD);
                        pVar3.c("onLocationChanged", rVarD, false);
                        return;
                    }
                    return;
                }
                return;
            case 4:
                p pVar4 = (p) this.c;
                ap.NAVIGATION_INTERNAL.f();
                cz czVar2 = (cz) db.a.q();
                cv cvVarC = ((com.google.android.libraries.navigation.internal.sr.h) aVar).c();
                if (!czVar2.b.H()) {
                    czVar2.v();
                }
                db dbVar4 = (db) czVar2.b;
                cvVarC.getClass();
                dbVar4.d = cvVarC;
                dbVar4.c = 41;
                pVar4.h.c(czVar2);
                return;
            case 5:
                p pVar5 = (p) this.c;
                com.google.android.libraries.navigation.internal.sw.c cVar = (com.google.android.libraries.navigation.internal.sw.c) aVar;
                ap.NAVIGATION_INTERNAL.f();
                boolean zF = pVar5.i.f(cVar.b);
                if (pVar5.g("onBetterRoutePromptNavigation")) {
                    com.google.android.libraries.navigation.internal.zs.k kVar = (com.google.android.libraries.navigation.internal.zs.k) com.google.android.libraries.navigation.internal.zs.l.a.q();
                    com.google.android.libraries.navigation.internal.se.b bVarC = cVar.b.c();
                    bg bgVar = cVar.a;
                    fw fwVar = (fw) fx.a.q();
                    int i5 = bVarC.k;
                    int i6 = bgVar.i();
                    if (i5 != -1) {
                        int i7 = i6 - i5;
                        if (!fwVar.b.H()) {
                            fwVar.v();
                        }
                        fx fxVar = (fx) fwVar.b;
                        fxVar.b |= 4;
                        fxVar.e = i7;
                    }
                    Duration duration = ((com.google.android.libraries.navigation.internal.bp.k) bVarC.l).a;
                    Duration duration2 = bgVar.N;
                    if (!duration.equals(com.google.android.libraries.navigation.internal.se.b.a) && duration2.toSeconds() > 0) {
                        am amVarB = p.b(duration2.minus(duration));
                        if (!fwVar.b.H()) {
                            fwVar.v();
                        }
                        fx fxVar2 = (fx) fwVar.b;
                        amVarB.getClass();
                        fxVar2.c = amVarB;
                        fxVar2.b |= 1;
                    }
                    Duration duration3 = ((com.google.android.libraries.navigation.internal.bp.k) bVarC.l).b;
                    if (duration3 != null) {
                        Duration durationOfSeconds = Duration.ofSeconds(bgVar.H().toSeconds());
                        if (durationOfSeconds.toSeconds() > 0) {
                            am amVarB2 = p.b(durationOfSeconds.minus(duration3));
                            if (!fwVar.b.H()) {
                                fwVar.v();
                            }
                            fx fxVar3 = (fx) fwVar.b;
                            amVarB2.getClass();
                            fxVar3.d = amVarB2;
                            fxVar3.b |= 2;
                        }
                    }
                    ii.a aVarE = bVarC.e();
                    if (!fwVar.b.H()) {
                        fwVar.v();
                    }
                    fx fxVar4 = (fx) fwVar.b;
                    fxVar4.f = aVarE.e;
                    fxVar4.b |= 8;
                    ii.a aVarE2 = bgVar.E();
                    if (!fwVar.b.H()) {
                        fwVar.v();
                    }
                    fx fxVar5 = (fx) fwVar.b;
                    fxVar5.g = aVarE2.e;
                    fxVar5.b |= 16;
                    fx fxVar6 = (fx) fwVar.t();
                    if (!kVar.b.H()) {
                        kVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zs.l lVar = (com.google.android.libraries.navigation.internal.zs.l) kVar.b;
                    fxVar6.getClass();
                    lVar.c = fxVar6;
                    lVar.b |= 1;
                    if (cVar.a.z().g()) {
                        Object objC = cVar.a.z().c();
                        if (!kVar.b.H()) {
                            kVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.l lVar2 = (com.google.android.libraries.navigation.internal.zs.l) kVar.b;
                        lVar2.d = ((com.google.android.libraries.navigation.internal.ady.ad) objC).e;
                        lVar2.b |= 2;
                    }
                    cz czVar3 = (cz) db.a.q();
                    if (!czVar3.b.H()) {
                        czVar3.v();
                    }
                    db dbVar5 = (db) czVar3.b;
                    com.google.android.libraries.navigation.internal.zs.l lVar3 = (com.google.android.libraries.navigation.internal.zs.l) kVar.t();
                    lVar3.getClass();
                    dbVar5.d = lVar3;
                    dbVar5.c = 11;
                    pVar5.h.d(czVar3, null, false, cVar.a, null);
                }
                pVar5.h.f(zF);
                return;
            case 6:
                p pVar6 = (p) this.c;
                com.google.android.libraries.navigation.internal.sw.b bVar = (com.google.android.libraries.navigation.internal.sw.b) aVar;
                ap.NAVIGATION_INTERNAL.f();
                if (pVar6.g("onBetterRoutePromptActionHandled")) {
                    com.google.android.libraries.navigation.internal.zs.i iVar = (com.google.android.libraries.navigation.internal.zs.i) com.google.android.libraries.navigation.internal.zs.j.a.q();
                    bg bgVar2 = bVar.b;
                    if (bgVar2 != null && bgVar2.z().g()) {
                        Object objC2 = bgVar2.z().c();
                        if (!iVar.b.H()) {
                            iVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.j jVar = (com.google.android.libraries.navigation.internal.zs.j) iVar.b;
                        jVar.d = ((com.google.android.libraries.navigation.internal.ady.ad) objC2).e;
                        jVar.b |= 2;
                    }
                    int i8 = bVar.c - 1;
                    if (i8 == 0) {
                        pVar6.v = bgVar2 == null || !bgVar2.C;
                        if (bVar.a) {
                            int i9 = com.google.android.libraries.navigation.internal.zs.h.c;
                            if (!iVar.b.H()) {
                                iVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zs.j jVar2 = (com.google.android.libraries.navigation.internal.zs.j) iVar.b;
                            int i10 = i9 - 1;
                            if (i9 == 0) {
                                throw null;
                            }
                            jVar2.c = i10;
                            jVar2.b |= 1;
                        } else {
                            int i11 = com.google.android.libraries.navigation.internal.zs.h.e;
                            if (!iVar.b.H()) {
                                iVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zs.j jVar3 = (com.google.android.libraries.navigation.internal.zs.j) iVar.b;
                            int i12 = i11 - 1;
                            if (i11 == 0) {
                                throw null;
                            }
                            jVar3.c = i12;
                            jVar3.b |= 1;
                        }
                    } else if (i8 == 2) {
                        int i13 = com.google.android.libraries.navigation.internal.zs.h.b;
                        if (!iVar.b.H()) {
                            iVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.j jVar4 = (com.google.android.libraries.navigation.internal.zs.j) iVar.b;
                        int i14 = i13 - 1;
                        if (i13 == 0) {
                            throw null;
                        }
                        jVar4.c = i14;
                        jVar4.b |= 1;
                    } else if (bVar.a) {
                        int i15 = com.google.android.libraries.navigation.internal.zs.h.d;
                        if (!iVar.b.H()) {
                            iVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.j jVar5 = (com.google.android.libraries.navigation.internal.zs.j) iVar.b;
                        int i16 = i15 - 1;
                        if (i15 == 0) {
                            throw null;
                        }
                        jVar5.c = i16;
                        jVar5.b |= 1;
                    } else {
                        int i17 = com.google.android.libraries.navigation.internal.zs.h.f;
                        if (!iVar.b.H()) {
                            iVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.j jVar6 = (com.google.android.libraries.navigation.internal.zs.j) iVar.b;
                        int i18 = i17 - 1;
                        if (i17 == 0) {
                            throw null;
                        }
                        jVar6.c = i18;
                        jVar6.b |= 1;
                    }
                    cz czVar4 = (cz) db.a.q();
                    if (!czVar4.b.H()) {
                        czVar4.v();
                    }
                    db dbVar6 = (db) czVar4.b;
                    com.google.android.libraries.navigation.internal.zs.j jVar7 = (com.google.android.libraries.navigation.internal.zs.j) iVar.t();
                    jVar7.getClass();
                    dbVar6.d = jVar7;
                    dbVar6.c = 12;
                    pVar6.h.d(czVar4, null, false, bVar.b, null);
                    return;
                }
                return;
            case 7:
                p pVar7 = (p) this.c;
                com.google.android.libraries.navigation.internal.tf.b bVar2 = (com.google.android.libraries.navigation.internal.tf.b) aVar;
                ap.NAVIGATION_INTERNAL.f();
                if (bVar2.b == null) {
                    pVar7.v = !bVar2.a.C;
                    if (pVar7.g("onAlternateRouteAccepted")) {
                        com.google.android.libraries.navigation.internal.zs.m mVar = (com.google.android.libraries.navigation.internal.zs.m) com.google.android.libraries.navigation.internal.zs.n.a.q();
                        cz czVar5 = (cz) db.a.q();
                        if (!czVar5.b.H()) {
                            czVar5.v();
                        }
                        db dbVar7 = (db) czVar5.b;
                        com.google.android.libraries.navigation.internal.zs.n nVar = (com.google.android.libraries.navigation.internal.zs.n) mVar.t();
                        nVar.getClass();
                        dbVar7.d = nVar;
                        dbVar7.c = 13;
                        pVar7.h.d(czVar5, null, false, bVar2.a, null);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                p pVar8 = (p) this.c;
                com.google.android.libraries.navigation.internal.sm.e eVar = (com.google.android.libraries.navigation.internal.sm.e) aVar;
                ap.NAVIGATION_INTERNAL.f();
                if (pVar8.g("onGuidanceAlertStartedEvent")) {
                    String str = eVar.e;
                    int i19 = eVar.c;
                    int i20 = eVar.d;
                    eVar.b.c.E();
                    by byVar = (by) bz.a.q();
                    am amVarA = com.google.android.libraries.navigation.internal.aen.a.a(eVar.a);
                    if (!byVar.b.H()) {
                        byVar.v();
                    }
                    bz bzVar = (bz) byVar.b;
                    amVarA.getClass();
                    bzVar.d = amVarA;
                    bzVar.b |= 4;
                    if (str != null) {
                        int iB = com.google.android.libraries.navigation.internal.vm.a.b(str);
                        if (!byVar.b.H()) {
                            byVar.v();
                        }
                        bz bzVar2 = (bz) byVar.b;
                        bzVar2.b |= 1;
                        bzVar2.c = iB;
                    }
                    int i21 = eVar.d;
                    cz czVar6 = (cz) db.a.q();
                    if (!czVar6.b.H()) {
                        czVar6.v();
                    }
                    db dbVar8 = (db) czVar6.b;
                    bz bzVar3 = (bz) byVar.t();
                    bzVar3.getClass();
                    dbVar8.d = bzVar3;
                    dbVar8.c = 6;
                    pVar8.h.d(czVar6, null, pVar8.e(i21), null, eVar.b);
                    return;
                }
                return;
            case 9:
                p pVar9 = (p) this.c;
                com.google.android.libraries.navigation.internal.sm.c cVar2 = (com.google.android.libraries.navigation.internal.sm.c) aVar;
                ap.NAVIGATION_INTERNAL.f();
                if (pVar9.g("onGuidanceAlertEndedEvent")) {
                    ca caVar = (ca) cd.a.q();
                    int iB2 = com.google.android.libraries.navigation.internal.vm.a.b(cVar2.c);
                    if (!caVar.b.H()) {
                        caVar.v();
                    }
                    cd cdVar = (cd) caVar.b;
                    cdVar.b |= 1;
                    cdVar.c = iB2;
                    int i22 = cVar2.d;
                    int i23 = i22 - 1;
                    if (i22 == 0) {
                        throw null;
                    }
                    if (i23 == 0) {
                        i = cc.b;
                    } else if (i23 == 1) {
                        i = cc.c;
                    } else if (i23 != 2) {
                        i = i23 != 3 ? cc.a : cc.e;
                    } else {
                        i = cc.d;
                    }
                    if (!caVar.b.H()) {
                        caVar.v();
                    }
                    cd cdVar2 = (cd) caVar.b;
                    int i24 = i - 1;
                    if (i == 0) {
                        throw null;
                    }
                    cdVar2.d = i24;
                    cdVar2.b |= 2;
                    cz czVar7 = (cz) db.a.q();
                    if (!czVar7.b.H()) {
                        czVar7.v();
                    }
                    db dbVar9 = (db) czVar7.b;
                    cd cdVar3 = (cd) caVar.t();
                    cdVar3.getClass();
                    dbVar9.d = cdVar3;
                    dbVar9.c = 7;
                    pVar9.h.d(czVar7, null, pVar9.e(cVar2.b), null, cVar2.a);
                    return;
                }
                return;
            case 10:
                p pVar10 = (p) this.c;
                ap.NAVIGATION_INTERNAL.f();
                ev evVar = ((com.google.android.libraries.navigation.internal.sw.i) aVar).a;
                ev evVar2 = pVar10.w;
                pVar10.h.f(true);
                pVar10.g.c(evVar);
                fs fsVar = (fs) ft.a.q();
                ev evVar3 = pVar10.w;
                if (!fsVar.b.H()) {
                    fsVar.v();
                }
                ft ftVar = (ft) fsVar.b;
                com.google.android.libraries.navigation.internal.ael.bz bzVar4 = ftVar.b;
                if (!bzVar4.c()) {
                    ftVar.b = bi.A(bzVar4);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(evVar3, ftVar.b);
                if (!fsVar.b.H()) {
                    fsVar.v();
                }
                ft ftVar2 = (ft) fsVar.b;
                com.google.android.libraries.navigation.internal.ael.bz bzVar5 = ftVar2.c;
                if (!bzVar5.c()) {
                    ftVar2.c = bi.A(bzVar5);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(evVar, ftVar2.c);
                cz czVar8 = (cz) db.a.q();
                if (!czVar8.b.H()) {
                    czVar8.v();
                }
                db dbVar10 = (db) czVar8.b;
                ft ftVar3 = (ft) fsVar.t();
                ftVar3.getClass();
                dbVar10.d = ftVar3;
                dbVar10.c = 36;
                pVar10.h.c(czVar8);
                pVar10.w = evVar;
                return;
            case 11:
                p pVar11 = (p) this.c;
                com.google.android.libraries.navigation.internal.cw.d dVar3 = (com.google.android.libraries.navigation.internal.cw.d) aVar;
                ap.NAVIGATION_INTERNAL.f();
                bw bwVar = (bw) bx.a.q();
                boolean z2 = dVar3.c;
                if (!bwVar.b.H()) {
                    bwVar.v();
                }
                bx bxVar = (bx) bwVar.b;
                bxVar.b |= 1;
                bxVar.c = z2;
                boolean z3 = dVar3.d;
                if (!bwVar.b.H()) {
                    bwVar.v();
                }
                bx bxVar2 = (bx) bwVar.b;
                bxVar2.b |= 2;
                bxVar2.d = z3;
                bx bxVar3 = (bx) bwVar.t();
                bx bxVar4 = pVar11.o;
                if (bxVar4 == null || !bxVar4.equals(bxVar3)) {
                    pVar11.o = bxVar3;
                    pVar11.p = pVar11.f.a();
                    return;
                }
                return;
            case 12:
                p pVar12 = (p) this.c;
                ap.NAVIGATION_INTERNAL.f();
                bs bsVar = (bs) bt.a.q();
                boolean z4 = ((com.google.android.libraries.navigation.internal.tl.b) aVar).c;
                if (!bsVar.b.H()) {
                    bsVar.v();
                }
                bt btVar = (bt) bsVar.b;
                btVar.b |= 1;
                btVar.c = z4;
                bt btVar2 = (bt) bsVar.t();
                bt btVar3 = pVar12.m;
                if (btVar3 == null || !btVar3.equals(btVar2)) {
                    pVar12.m = btVar2;
                    pVar12.f596n = pVar12.f.a();
                    return;
                }
                return;
            case 13:
                p pVar13 = (p) this.c;
                com.google.android.libraries.navigation.internal.cw.f fVar = (com.google.android.libraries.navigation.internal.cw.f) aVar;
                ap.NAVIGATION_INTERNAL.f();
                if (!pVar13.g("onLocationProviderStatus") || (czVarA = pVar13.l.a(fVar.a)) == null) {
                    return;
                }
                pVar13.h.c(czVarA);
                return;
            case 14:
                p pVar14 = (p) this.c;
                com.google.android.libraries.navigation.internal.sr.b bVar3 = (com.google.android.libraries.navigation.internal.sr.b) aVar;
                ap.NAVIGATION_INTERNAL.f();
                if (pVar14.g("onAssistantEvent")) {
                    pVar14.h();
                    return;
                } else {
                    pVar14.q.push(bVar3);
                    pVar14.r.push(Long.valueOf(pVar14.f.a()));
                    return;
                }
            case 15:
                p pVar15 = (p) this.c;
                com.google.android.libraries.navigation.internal.cw.j jVar8 = (com.google.android.libraries.navigation.internal.cw.j) aVar;
                ap.NAVIGATION_INTERNAL.f();
                if (pVar15.f.a() - pVar15.D > 1000) {
                    pVar15.D = pVar15.f.a();
                    try {
                        String strB = com.google.android.libraries.navigation.internal.mh.b.b(pVar15.J.a.getContentResolver(), "network_location_opt_in");
                        if (strB != null) {
                            try {
                                if (Integer.parseInt(strB) == 1) {
                                    z = true;
                                }
                            } catch (NumberFormatException unused) {
                            }
                        }
                    } catch (RuntimeException unused2) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1800)).p("Swallowed exception on location service opt in check. See b/26710136 and b/31244960.");
                    }
                    pVar15.C = z;
                }
                if (pVar15.C && pVar15.g("onMapVersusSensorInconsistencyEvent")) {
                    cz czVar9 = (cz) db.a.q();
                    cs csVar = (cs) ct.a.q();
                    com.google.android.libraries.navigation.internal.zr.bq bqVar3 = jVar8.a;
                    if (!csVar.b.H()) {
                        csVar.v();
                    }
                    ct ctVar = (ct) csVar.b;
                    bqVar3.getClass();
                    ctVar.c = bqVar3;
                    ctVar.b |= 1;
                    if (!czVar9.b.H()) {
                        czVar9.v();
                    }
                    db dbVar11 = (db) czVar9.b;
                    ct ctVar2 = (ct) csVar.t();
                    ctVar2.getClass();
                    dbVar11.d = ctVar2;
                    dbVar11.c = 33;
                    pVar15.h.d(czVar9, null, true, null, null);
                    return;
                }
                return;
            case 16:
                throw null;
            default:
                p pVar16 = (p) this.c;
                ap.NAVIGATION_INTERNAL.f();
                if (pVar16.g("onLapSummaryEvent")) {
                    throw null;
                }
                return;
        }
    }
}
