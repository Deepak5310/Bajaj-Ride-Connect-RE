package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ael.am;
import com.google.android.libraries.navigation.internal.bp.bf;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.zs.bm;
import com.google.android.libraries.navigation.internal.zs.bn;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.db;
import com.google.android.libraries.navigation.internal.zs.ei;
import com.google.android.libraries.navigation.internal.zs.ek;
import com.google.android.libraries.navigation.internal.zs.el;
import com.google.android.libraries.navigation.internal.zs.fc;
import com.google.android.libraries.navigation.internal.zs.fd;
import com.google.android.libraries.navigation.internal.zs.fo;
import com.google.android.libraries.navigation.internal.zs.fp;
import com.google.android.libraries.navigation.internal.zs.fw;
import com.google.android.libraries.navigation.internal.zs.fx;
import j$.time.Duration;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.rw.w, com.google.android.libraries.navigation.internal.rw.r, com.google.android.libraries.navigation.internal.rw.x, com.google.android.libraries.navigation.internal.rw.aa, com.google.android.libraries.navigation.internal.rw.y, com.google.android.libraries.navigation.internal.rw.m {
    final /* synthetic */ p a;

    public m(p pVar) {
        this.a = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.m
    public final void a(com.google.android.libraries.navigation.internal.tj.o oVar) {
        p pVar = this.a;
        boolean zF = pVar.i.f(oVar);
        if (pVar.g("onRouteCompletedSuccessfully")) {
            com.google.android.libraries.navigation.internal.zs.ac acVar = (com.google.android.libraries.navigation.internal.zs.ac) com.google.android.libraries.navigation.internal.zs.ad.a.q();
            cz czVar = (cz) db.a.q();
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar = (db) czVar.b;
            com.google.android.libraries.navigation.internal.zs.ad adVar = (com.google.android.libraries.navigation.internal.zs.ad) acVar.t();
            adVar.getClass();
            dbVar.d = adVar;
            dbVar.c = 17;
            this.a.h.c(czVar);
        }
        this.a.h.f(zF);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:52:0x0105  */
    /* JADX WARN: Code duplicated, block: B:60:0x013f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0170  */
    /* JADX WARN: Code duplicated, block: B:71:0x018d  */
    /* JADX WARN: Code duplicated, block: B:74:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:89:0x0208  */
    /* JADX WARN: Code duplicated, block: B:91:0x0224  */
    /* JADX WARN: Code duplicated, block: B:95:0x022a  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
    
        if (r2 != 4) goto L40;
     */
    @Override // com.google.android.libraries.navigation.internal.rw.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void av(com.google.android.libraries.navigation.internal.tj.o oVar, int i, boolean z) {
        com.google.android.libraries.navigation.internal.zs.c cVar;
        com.google.android.libraries.navigation.internal.zs.f fVar;
        int i2;
        com.google.android.libraries.navigation.internal.se.b bVar;
        cz czVar;
        fw fwVar;
        int i3;
        int i4;
        Duration duration;
        Duration duration2;
        Duration duration3;
        Duration duration4;
        Duration duration5;
        n nVarA;
        ap.NAVIGATION_INTERNAL.f();
        if (z) {
            p pVar = this.a;
            boolean zF = pVar.i.f(oVar);
            int i5 = oVar.a().D;
            bf bfVar = oVar.a().Q;
            bf bfVar2 = bf.ONLINE;
            if (!pVar.g("onRouteChanged") || (i5 < 0 && bfVar == bfVar2)) {
                if (i != com.google.android.libraries.navigation.internal.rw.z.b && i != com.google.android.libraries.navigation.internal.rw.z.c) {
                    pVar.v = false;
                }
                pVar.h.f(zF);
            } else {
                if (i != com.google.android.libraries.navigation.internal.rw.z.b) {
                    if (i == com.google.android.libraries.navigation.internal.rw.z.c) {
                        bg bgVarA = oVar.a();
                        pVar.v = !bgVarA.C;
                        if (pVar.g("onDrivenOntoAlternateRoute")) {
                            bm bmVar = (bm) bn.a.q();
                            cz czVar2 = (cz) db.a.q();
                            if (!czVar2.b.H()) {
                                czVar2.v();
                            }
                            db dbVar = (db) czVar2.b;
                            bn bnVar = (bn) bmVar.t();
                            bnVar.getClass();
                            dbVar.d = bnVar;
                            dbVar.c = 15;
                            pVar.h.d(czVar2, null, false, bgVarA, null);
                        }
                    } else if (i5 >= 0 && (nVarA = pVar.a(i5)) != null) {
                        pVar.k.c(i == com.google.android.libraries.navigation.internal.rw.z.d ? nVarA.d : nVarA.b);
                        pVar.j.c(nVarA.c);
                        af afVar = pVar.k;
                        int i6 = afVar.a;
                        int i7 = afVar.b;
                        pVar.i.a();
                    }
                }
                int i8 = i - 1;
                int i9 = com.google.android.libraries.navigation.internal.zs.e.b;
                if (i == 0) {
                    throw null;
                }
                if (i8 == 0) {
                    i9 = com.google.android.libraries.navigation.internal.zs.e.b;
                    cVar = (com.google.android.libraries.navigation.internal.zs.c) com.google.android.libraries.navigation.internal.zs.f.a.q();
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    fVar = (com.google.android.libraries.navigation.internal.zs.f) cVar.b;
                    i2 = i9 - 1;
                    if (i9 != 0) {
                        throw null;
                    }
                    fVar.d = i2;
                    fVar.b |= 2;
                    bVar = pVar.E;
                    if (bVar != null) {
                        com.google.android.libraries.navigation.internal.se.b bVarC = oVar.c();
                        fwVar = (fw) fx.a.q();
                        i3 = bVarC.k;
                        i4 = bVar.k;
                        if (i4 != -1 && i3 != -1) {
                            int i10 = i3 - i4;
                            if (!fwVar.b.H()) {
                                fwVar.v();
                            }
                            fx fxVar = (fx) fwVar.b;
                            fxVar.b |= 4;
                            fxVar.e = i10;
                        }
                        com.google.android.libraries.navigation.internal.bp.ae aeVar = bVar.l;
                        duration = ((com.google.android.libraries.navigation.internal.bp.k) bVarC.l).a;
                        duration2 = com.google.android.libraries.navigation.internal.se.b.a;
                        duration3 = ((com.google.android.libraries.navigation.internal.bp.k) aeVar).a;
                        if (!duration3.equals(duration2) && !duration.equals(com.google.android.libraries.navigation.internal.se.b.a)) {
                            am amVarB = p.b(duration.minus(duration3));
                            if (!fwVar.b.H()) {
                                fwVar.v();
                            }
                            fx fxVar2 = (fx) fwVar.b;
                            amVarB.getClass();
                            fxVar2.c = amVarB;
                            fxVar2.b |= 1;
                        }
                        com.google.android.libraries.navigation.internal.bp.ae aeVar2 = bVar.l;
                        duration4 = ((com.google.android.libraries.navigation.internal.bp.k) bVarC.l).b;
                        duration5 = ((com.google.android.libraries.navigation.internal.bp.k) aeVar2).b;
                        if (duration5 != null && duration4 != null) {
                            am amVarB2 = p.b(duration4.minus(duration5));
                            if (!fwVar.b.H()) {
                                fwVar.v();
                            }
                            fx fxVar3 = (fx) fwVar.b;
                            amVarB2.getClass();
                            fxVar3.d = amVarB2;
                            fxVar3.b = 2 | fxVar3.b;
                        }
                        ii.a aVarE = bVar.e();
                        if (!fwVar.b.H()) {
                            fwVar.v();
                        }
                        fx fxVar4 = (fx) fwVar.b;
                        fxVar4.f = aVarE.e;
                        fxVar4.b |= 8;
                        ii.a aVarE2 = bVarC.e();
                        if (!fwVar.b.H()) {
                            fwVar.v();
                        }
                        fx fxVar5 = (fx) fwVar.b;
                        fxVar5.g = aVarE2.e;
                        fxVar5.b |= 16;
                        fx fxVar6 = (fx) fwVar.t();
                        if (!cVar.b.H()) {
                            cVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.f fVar2 = (com.google.android.libraries.navigation.internal.zs.f) cVar.b;
                        fxVar6.getClass();
                        fVar2.c = fxVar6;
                        fVar2.b = 1 | fVar2.b;
                    }
                    if (i != com.google.android.libraries.navigation.internal.rw.z.b && i != com.google.android.libraries.navigation.internal.rw.z.c) {
                        if (!cVar.b.H()) {
                            cVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.f fVar3 = (com.google.android.libraries.navigation.internal.zs.f) cVar.b;
                        fVar3.b |= 4;
                        fVar3.e = i5;
                    }
                    czVar = (cz) db.a.q();
                    if (!czVar.b.H()) {
                        czVar.v();
                    }
                    db dbVar2 = (db) czVar.b;
                    com.google.android.libraries.navigation.internal.zs.f fVar4 = (com.google.android.libraries.navigation.internal.zs.f) cVar.t();
                    fVar4.getClass();
                    dbVar2.d = fVar4;
                    dbVar2.c = 9;
                    pVar.h.c(czVar);
                    if (i != com.google.android.libraries.navigation.internal.rw.z.b) {
                        pVar.v = false;
                    }
                    pVar.h.f(zF);
                } else {
                    if (i8 == 1 || i8 == 2) {
                        i9 = com.google.android.libraries.navigation.internal.zs.e.c;
                    } else if (i8 == 3) {
                        i9 = com.google.android.libraries.navigation.internal.zs.e.b;
                    }
                    cVar = (com.google.android.libraries.navigation.internal.zs.c) com.google.android.libraries.navigation.internal.zs.f.a.q();
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    fVar = (com.google.android.libraries.navigation.internal.zs.f) cVar.b;
                    i2 = i9 - 1;
                    if (i9 != 0) {
                        throw null;
                    }
                    fVar.d = i2;
                    fVar.b |= 2;
                    bVar = pVar.E;
                    if (bVar != null) {
                        com.google.android.libraries.navigation.internal.se.b bVarC2 = oVar.c();
                        fwVar = (fw) fx.a.q();
                        i3 = bVarC2.k;
                        i4 = bVar.k;
                        if (i4 != -1) {
                            int i11 = i3 - i4;
                            if (!fwVar.b.H()) {
                                fwVar.v();
                            }
                            fx fxVar7 = (fx) fwVar.b;
                            fxVar7.b |= 4;
                            fxVar7.e = i11;
                        }
                        com.google.android.libraries.navigation.internal.bp.ae aeVar3 = bVar.l;
                        duration = ((com.google.android.libraries.navigation.internal.bp.k) bVarC2.l).a;
                        duration2 = com.google.android.libraries.navigation.internal.se.b.a;
                        duration3 = ((com.google.android.libraries.navigation.internal.bp.k) aeVar3).a;
                        if (!duration3.equals(duration2)) {
                            am amVarB3 = p.b(duration.minus(duration3));
                            if (!fwVar.b.H()) {
                                fwVar.v();
                            }
                            fx fxVar8 = (fx) fwVar.b;
                            amVarB3.getClass();
                            fxVar8.c = amVarB3;
                            fxVar8.b |= 1;
                        }
                        com.google.android.libraries.navigation.internal.bp.ae aeVar4 = bVar.l;
                        duration4 = ((com.google.android.libraries.navigation.internal.bp.k) bVarC2.l).b;
                        duration5 = ((com.google.android.libraries.navigation.internal.bp.k) aeVar4).b;
                        if (duration5 != null) {
                            am amVarB4 = p.b(duration4.minus(duration5));
                            if (!fwVar.b.H()) {
                                fwVar.v();
                            }
                            fx fxVar9 = (fx) fwVar.b;
                            amVarB4.getClass();
                            fxVar9.d = amVarB4;
                            fxVar9.b = 2 | fxVar9.b;
                        }
                        ii.a aVarE3 = bVar.e();
                        if (!fwVar.b.H()) {
                            fwVar.v();
                        }
                        fx fxVar10 = (fx) fwVar.b;
                        fxVar10.f = aVarE3.e;
                        fxVar10.b |= 8;
                        ii.a aVarE4 = bVarC2.e();
                        if (!fwVar.b.H()) {
                            fwVar.v();
                        }
                        fx fxVar11 = (fx) fwVar.b;
                        fxVar11.g = aVarE4.e;
                        fxVar11.b |= 16;
                        fx fxVar12 = (fx) fwVar.t();
                        if (!cVar.b.H()) {
                            cVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.f fVar5 = (com.google.android.libraries.navigation.internal.zs.f) cVar.b;
                        fxVar12.getClass();
                        fVar5.c = fxVar12;
                        fVar5.b = 1 | fVar5.b;
                    }
                    if (i != com.google.android.libraries.navigation.internal.rw.z.b) {
                        if (!cVar.b.H()) {
                            cVar.v();
                        }
                        com.google.android.libraries.navigation.internal.zs.f fVar6 = (com.google.android.libraries.navigation.internal.zs.f) cVar.b;
                        fVar6.b |= 4;
                        fVar6.e = i5;
                    }
                    czVar = (cz) db.a.q();
                    if (!czVar.b.H()) {
                        czVar.v();
                    }
                    db dbVar3 = (db) czVar.b;
                    com.google.android.libraries.navigation.internal.zs.f fVar7 = (com.google.android.libraries.navigation.internal.zs.f) cVar.t();
                    fVar7.getClass();
                    dbVar3.d = fVar7;
                    dbVar3.c = 9;
                    pVar.h.c(czVar);
                    if (i != com.google.android.libraries.navigation.internal.rw.z.b) {
                        pVar.v = false;
                    }
                    pVar.h.f(zF);
                }
            }
        }
        this.a.E = oVar.c();
    }

    @Override // com.google.android.libraries.navigation.internal.rw.w
    public final void b(int i) {
        ap.NAVIGATION_INTERNAL.f();
        if (this.a.g("onRerouteRequested")) {
            ei eiVar = (ei) el.a.q();
            if (i == 4) {
                int i2 = ek.a;
                if (!eiVar.b.H()) {
                    eiVar.v();
                }
                el elVar = (el) eiVar.b;
                int i3 = i2 - 1;
                if (i2 == 0) {
                    throw null;
                }
                elVar.c = i3;
                elVar.b |= 1;
            } else if (i == 2) {
                int i4 = ek.b;
                if (!eiVar.b.H()) {
                    eiVar.v();
                }
                el elVar2 = (el) eiVar.b;
                int i5 = i4 - 1;
                if (i4 == 0) {
                    throw null;
                }
                elVar2.c = i5;
                elVar2.b |= 1;
            } else {
                int i6 = ek.c;
                if (!eiVar.b.H()) {
                    eiVar.v();
                }
                el elVar3 = (el) eiVar.b;
                int i7 = i6 - 1;
                if (i6 == 0) {
                    throw null;
                }
                elVar3.c = i7;
                elVar3.b |= 1;
            }
            cz czVar = (cz) db.a.q();
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar = (db) czVar.b;
            el elVar4 = (el) eiVar.t();
            elVar4.getClass();
            dbVar.d = elVar4;
            dbVar.c = 14;
            this.a.h.c(czVar);
        }
        this.a.h.f(false);
    }

    @Override // com.google.android.libraries.navigation.internal.rw.x
    public final void c(com.google.android.libraries.navigation.internal.tj.o oVar, boolean z) {
        ap.NAVIGATION_INTERNAL.f();
        bq bqVar = oVar.c().c;
        p pVar = this.a;
        boolean zF = pVar.i.f(oVar);
        if (pVar.g("onStepChanged") && bqVar != null) {
            int i = oVar.c().k - oVar.c().f;
            fc fcVar = (fc) fd.a.q();
            if (!fcVar.b.H()) {
                fcVar.v();
            }
            fd fdVar = (fd) fcVar.b;
            fdVar.b |= 1;
            fdVar.c = z;
            fd fdVar2 = (fd) fcVar.t();
            cz czVar = (cz) db.a.q();
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar = (db) czVar.b;
            fdVar2.getClass();
            dbVar.d = fdVar2;
            dbVar.c = 8;
            p pVar2 = this.a;
            pVar2.h.d(czVar, null, pVar2.e(i), null, null);
        }
        this.a.h.f(zF);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0085  */
    /* JADX WARN: Code duplicated, block: B:22:0x009c  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b3  */
    @Override // com.google.android.libraries.navigation.internal.rw.y
    public final void d(com.google.android.libraries.navigation.internal.tj.o oVar) {
        n nVarA;
        boolean zF = this.a.i.f(oVar);
        int i = oVar.a().D;
        if (this.a.g("onTrafficUpdated") && i >= 0 && (nVarA = this.a.a(i)) != null) {
            p pVar = this.a;
            af afVar = nVarA.b;
            af afVar2 = pVar.k;
            int i2 = afVar2.a;
            int i3 = afVar2.b;
            afVar2.c(afVar);
            this.a.j.c(nVarA.c);
            p pVar2 = this.a;
            af afVar3 = pVar2.k;
            int i4 = afVar3.a;
            int i5 = afVar3.b;
            pVar2.i.a();
            fo foVar = (fo) fp.a.q();
            if (!foVar.b.H()) {
                foVar.v();
            }
            int i6 = nVarA.e;
            fp fpVar = (fp) foVar.b;
            fpVar.b |= 8;
            fpVar.f = i;
            p pVar3 = this.a;
            af afVar4 = pVar3.k;
            if (afVar4.a != i2) {
                if (!foVar.b.H()) {
                    foVar.v();
                }
                fp fpVar2 = (fp) foVar.b;
                fpVar2.b |= 1;
                fpVar2.c = i2;
                if (!foVar.b.H()) {
                    foVar.v();
                }
                fp fpVar3 = (fp) foVar.b;
                fpVar3.b |= 2;
                fpVar3.d = i3;
                if (!foVar.b.H()) {
                    foVar.v();
                }
                fp fpVar4 = (fp) foVar.b;
                fpVar4.b |= 4;
                fpVar4.e = i6;
            } else if (afVar4.b != i3 + 1 || pVar3.i.a() != i6) {
                if (!foVar.b.H()) {
                    foVar.v();
                }
                fp fpVar5 = (fp) foVar.b;
                fpVar5.b |= 1;
                fpVar5.c = i2;
                if (!foVar.b.H()) {
                    foVar.v();
                }
                fp fpVar6 = (fp) foVar.b;
                fpVar6.b |= 2;
                fpVar6.d = i3;
                if (!foVar.b.H()) {
                    foVar.v();
                }
                fp fpVar7 = (fp) foVar.b;
                fpVar7.b |= 4;
                fpVar7.e = i6;
            }
            cz czVar = (cz) db.a.q();
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar = (db) czVar.b;
            fp fpVar8 = (fp) foVar.t();
            fpVar8.getClass();
            dbVar.d = fpVar8;
            dbVar.c = 10;
            this.a.h.c(czVar);
        }
        this.a.h.f(zF);
        this.a.v = false;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.r
    public final void j(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        ap.NAVIGATION_INTERNAL.f();
        this.a.i.b(rVar);
        p pVar = this.a;
        pVar.c("onGuidanceProgressed", rVar, pVar.i.f(oVar));
        this.a.E = oVar.c();
    }
}
