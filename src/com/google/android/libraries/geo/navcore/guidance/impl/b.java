package com.google.android.libraries.geo.navcore.guidance.impl;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.add.ba;
import com.google.android.libraries.navigation.internal.add.bb;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.ex;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.hh;
import com.google.android.libraries.navigation.internal.adr.hi;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.iz;
import com.google.android.libraries.navigation.internal.adr.jb;
import com.google.android.libraries.navigation.internal.adr.jf;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.adr.kq;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.we.be;
import com.google.android.libraries.navigation.internal.we.bf;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Instant;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements y {
    private com.google.android.libraries.navigation.internal.tj.u a = null;
    private final com.google.android.libraries.navigation.internal.hn.r b;
    private final bf c;
    private final com.google.android.libraries.navigation.internal.we.w d;
    private final com.google.android.libraries.navigation.internal.rw.g e;
    private final com.google.android.libraries.navigation.internal.we.i f;
    private final com.google.android.libraries.navigation.internal.we.at g;
    private final com.google.android.libraries.navigation.internal.we.ai h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.sn.h j;
    private final com.google.android.libraries.navigation.internal.wn.e k;

    public b(com.google.android.libraries.navigation.internal.hn.r rVar, bf bfVar, com.google.android.libraries.navigation.internal.we.w wVar, com.google.android.libraries.navigation.internal.rw.g gVar, com.google.android.libraries.navigation.internal.we.i iVar, com.google.android.libraries.navigation.internal.we.at atVar, com.google.android.libraries.navigation.internal.we.ai aiVar, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.wn.e eVar) {
        this.b = rVar;
        this.c = bfVar;
        this.d = wVar;
        this.e = gVar;
        this.f = iVar;
        this.g = atVar;
        this.h = aiVar;
        this.i = aVar;
        this.j = hVar;
        this.k = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0042  */
    /* JADX WARN: Code duplicated, block: B:119:0x024a  */
    /* JADX WARN: Code duplicated, block: B:195:0x046d  */
    /* JADX WARN: Code duplicated, block: B:24:0x00d6  */
    /* JADX WARN: Multi-variable type inference failed */
    private final com.google.android.libraries.navigation.internal.add.ag e(com.google.android.libraries.navigation.internal.tj.j jVar, com.google.android.libraries.navigation.internal.sd.b bVar) throws com.google.android.libraries.navigation.internal.wq.b {
        com.google.android.libraries.navigation.internal.add.c cVar;
        fd fdVar;
        com.google.android.libraries.navigation.internal.add.c cVar2;
        ev evVarG;
        fd fdVar2;
        com.google.android.libraries.navigation.internal.add.c cVar3;
        double d;
        ev evVar;
        int i;
        com.google.android.libraries.navigation.internal.add.t tVar;
        int i2;
        int i3;
        String str;
        com.google.android.libraries.navigation.internal.add.t tVar2;
        String str2;
        int i4;
        com.google.android.libraries.navigation.internal.add.k kVar;
        int i5;
        kq kqVar;
        com.google.android.libraries.navigation.internal.add.t tVar3;
        com.google.android.libraries.navigation.internal.we.at atVar = this.g;
        com.google.android.libraries.navigation.internal.we.i iVar = this.f;
        bh bhVarB = jVar.b();
        com.google.android.libraries.navigation.internal.ade.n nVarD = iVar.d();
        this.f.g(atVar.a(bhVarB, nVarD), nVarD);
        this.f.h();
        if (bVar != null) {
            bf bfVar = this.c;
            com.google.android.libraries.navigation.internal.db.y yVar = jVar.c().p;
            be beVar = bfVar.b;
            if (beVar != null) {
                com.google.android.libraries.navigation.internal.we.o oVar = (com.google.android.libraries.navigation.internal.we.o) beVar;
                if (oVar.a != bVar.e || oVar.b != bVar.a.f) {
                    bfVar.b = new com.google.android.libraries.navigation.internal.we.o(bVar.e, bVar.a.f, UUID.randomUUID().toString());
                }
            } else {
                bfVar.b = new com.google.android.libraries.navigation.internal.we.o(bVar.e, bVar.a.f, UUID.randomUUID().toString());
            }
            com.google.android.libraries.navigation.internal.vn.d dVarD = bfVar.a.d(bVar.a, bVar.e, bVar.b, yVar, bVar.c);
            if (dVarD == null) {
                cVar = null;
            } else {
                com.google.android.libraries.navigation.internal.add.b bVar2 = (com.google.android.libraries.navigation.internal.add.b) com.google.android.libraries.navigation.internal.add.c.a.q();
                ba baVar = (ba) bb.a.q();
                String strC = dVarD.c();
                if (!baVar.b.H()) {
                    baVar.v();
                }
                bb bbVar = (bb) baVar.b;
                strC.getClass();
                bbVar.b = strC;
                if (!bVar2.b.H()) {
                    bVar2.v();
                }
                com.google.android.libraries.navigation.internal.add.c cVar4 = (com.google.android.libraries.navigation.internal.add.c) bVar2.b;
                bb bbVar2 = (bb) baVar.t();
                bbVar2.getClass();
                cVar4.d = bbVar2;
                cVar4.b |= 2;
                String str3 = ((com.google.android.libraries.navigation.internal.we.o) bfVar.b).c;
                if (!bVar2.b.H()) {
                    bVar2.v();
                }
                com.google.android.libraries.navigation.internal.add.c cVar5 = (com.google.android.libraries.navigation.internal.add.c) bVar2.b;
                str3.getClass();
                cVar5.b |= 1;
                cVar5.c = str3;
                cVar = (com.google.android.libraries.navigation.internal.add.c) bVar2.t();
            }
        } else {
            cVar = null;
        }
        com.google.android.libraries.navigation.internal.we.w wVar = this.d;
        fd fdVarB = this.f.b();
        bg bgVar = jVar.c().b;
        double dA = jVar.c().a();
        long j = bgVar.Y;
        if (j != wVar.f) {
            wVar.f = j;
            wVar.e = dA;
        }
        if (dA > wVar.e) {
            wVar.e = dA;
        }
        com.google.android.libraries.navigation.internal.we.y yVar2 = new com.google.android.libraries.navigation.internal.we.y();
        double d2 = wVar.e;
        ii iiVar = bgVar.u;
        if (iiVar == null) {
            int i6 = ev.d;
            evVarG = lv.a;
            fdVar = fdVarB;
            cVar2 = cVar;
        } else {
            int i7 = ev.d;
            eq eqVar = new eq();
            ev evVarW = ev.w(new Comparator() { // from class: com.google.android.libraries.navigation.internal.we.ap
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    el elVar = (el) obj;
                    el elVar2 = (el) obj2;
                    ex exVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                    if (exVar == null) {
                        exVar = ex.a;
                    }
                    double d3 = exVar.c;
                    ex exVar2 = (elVar2.c == 22 ? (fh) elVar2.d : fh.a).i;
                    if (exVar2 == null) {
                        exVar2 = ex.a;
                    }
                    return Double.compare(d3, exVar2.c);
                }
            }, iiVar.g);
            int i8 = ((lv) evVarW).c;
            int i9 = 0;
            while (i9 < i8) {
                el elVar = (el) evVarW.get(i9);
                ex exVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                if (exVar == null) {
                    exVar = ex.a;
                }
                if ((exVar.b & 1) != 0) {
                    ex exVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                    if (exVar2 == null) {
                        exVar2 = ex.a;
                    }
                    evVar = evVarW;
                    i = i8;
                    double d3 = exVar2.c;
                    ex exVar3 = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                    if (exVar3 == null) {
                        exVar3 = ex.a;
                    }
                    if (((double) exVar3.d) + d3 <= d2) {
                        fdVar2 = fdVarB;
                        cVar3 = cVar;
                        d = d2;
                    } else {
                        int iB = (int) com.google.android.libraries.navigation.internal.ja.a.b(bgVar.K(d2, d3));
                        fd fdVar3 = com.google.android.libraries.navigation.internal.we.aq.a;
                        Cdo cdoB = Cdo.b(elVar.u);
                        if (cdoB == null) {
                            cdoB = Cdo.INCIDENT_OTHER;
                        }
                        if (iB > ((Integer) fdVar3.getOrDefault(cdoB, 15)).intValue()) {
                            break;
                        }
                        ex exVar4 = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                        if (exVar4 == null) {
                            exVar4 = ex.a;
                        }
                        if ((exVar4.b & 1) == 0) {
                            fdVar2 = fdVarB;
                            cVar3 = cVar;
                            d = d2;
                            tVar = null;
                        } else {
                            ex exVar5 = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                            if (exVar5 == null) {
                                exVar5 = ex.a;
                            }
                            int i10 = exVar5.c;
                            ex exVar6 = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                            if (exVar6 == null) {
                                exVar6 = ex.a;
                            }
                            int i11 = exVar6.d + i10;
                            if (i11 < 0 || i10 >= (i2 = bgVar.J)) {
                                fdVar2 = fdVarB;
                                cVar3 = cVar;
                                d = d2;
                            } else {
                                d = d2;
                                double dMax = Math.max(i10, 0);
                                int iMin = Math.min(i11, i2);
                                com.google.android.libraries.navigation.internal.oe.x xVarW = bgVar.w(dMax);
                                double d4 = iMin;
                                com.google.android.libraries.navigation.internal.oe.x xVarW2 = bgVar.w(d4);
                                if (xVarW == null || xVarW2 == null) {
                                    fdVar2 = fdVarB;
                                    cVar3 = cVar;
                                } else {
                                    Cdo cdoB2 = Cdo.b(elVar.u);
                                    if (cdoB2 == null) {
                                        cdoB2 = Cdo.INCIDENT_OTHER;
                                    }
                                    int iOrdinal = cdoB2.ordinal();
                                    cVar3 = cVar;
                                    if (iOrdinal == 0) {
                                        i3 = com.google.android.libraries.navigation.internal.ade.i.c;
                                    } else if (iOrdinal == 1) {
                                        i3 = com.google.android.libraries.navigation.internal.ade.i.d;
                                    } else if (iOrdinal == 2) {
                                        i3 = com.google.android.libraries.navigation.internal.ade.i.e;
                                    } else if (iOrdinal == 3 || iOrdinal == 6) {
                                        i3 = com.google.android.libraries.navigation.internal.ade.i.f;
                                    } else if (iOrdinal != 8) {
                                        i3 = com.google.android.libraries.navigation.internal.ade.i.a;
                                    } else {
                                        i3 = com.google.android.libraries.navigation.internal.ade.i.c;
                                    }
                                    if (i3 == com.google.android.libraries.navigation.internal.ade.i.a) {
                                        Cdo cdoB3 = Cdo.b(elVar.u);
                                        if (cdoB3 == null) {
                                            cdoB3 = Cdo.INCIDENT_OTHER;
                                        }
                                        cdoB3.name();
                                        fdVar2 = fdVarB;
                                    } else {
                                        com.google.android.libraries.navigation.internal.add.p pVar = (com.google.android.libraries.navigation.internal.add.p) com.google.android.libraries.navigation.internal.add.q.a.q();
                                        com.google.android.libraries.navigation.internal.ade.f fVar = (com.google.android.libraries.navigation.internal.ade.f) com.google.android.libraries.navigation.internal.ade.j.a.q();
                                        fdVar2 = fdVarB;
                                        if (!fVar.b.H()) {
                                            fVar.v();
                                        }
                                        ((com.google.android.libraries.navigation.internal.ade.j) fVar.b).c = com.google.android.libraries.navigation.internal.ade.i.a(i3);
                                        com.google.android.libraries.navigation.internal.ade.g gVar = (com.google.android.libraries.navigation.internal.ade.g) com.google.android.libraries.navigation.internal.ade.h.a.q();
                                        com.google.android.libraries.navigation.internal.ade.d dVar = (com.google.android.libraries.navigation.internal.ade.d) com.google.android.libraries.navigation.internal.ade.e.a.q();
                                        com.google.android.libraries.navigation.internal.ade.c cVarA = com.google.android.libraries.navigation.internal.wf.n.a(dMax, bgVar);
                                        if (!dVar.b.H()) {
                                            dVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ade.e eVar = (com.google.android.libraries.navigation.internal.ade.e) dVar.b;
                                        cVarA.getClass();
                                        eVar.c = cVarA;
                                        eVar.b |= 1;
                                        com.google.android.libraries.navigation.internal.ade.c cVarA2 = com.google.android.libraries.navigation.internal.wf.n.a(d4, bgVar);
                                        if (!dVar.b.H()) {
                                            dVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ade.e eVar2 = (com.google.android.libraries.navigation.internal.ade.e) dVar.b;
                                        cVarA2.getClass();
                                        eVar2.d = cVarA2;
                                        eVar2.b |= 2;
                                        com.google.android.libraries.navigation.internal.ade.e eVar3 = (com.google.android.libraries.navigation.internal.ade.e) dVar.t();
                                        if (!gVar.b.H()) {
                                            gVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ade.h hVar = (com.google.android.libraries.navigation.internal.ade.h) gVar.b;
                                        eVar3.getClass();
                                        hVar.c = eVar3;
                                        hVar.b = 1;
                                        com.google.android.libraries.navigation.internal.ade.h hVar2 = (com.google.android.libraries.navigation.internal.ade.h) gVar.t();
                                        if (!fVar.b.H()) {
                                            fVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ade.j jVar2 = (com.google.android.libraries.navigation.internal.ade.j) fVar.b;
                                        hVar2.getClass();
                                        bz bzVar = jVar2.b;
                                        if (!bzVar.c()) {
                                            jVar2.b = bi.A(bzVar);
                                        }
                                        jVar2.b.add(hVar2);
                                        if (!pVar.b.H()) {
                                            pVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.add.q qVar = (com.google.android.libraries.navigation.internal.add.q) pVar.b;
                                        com.google.android.libraries.navigation.internal.ade.j jVar3 = (com.google.android.libraries.navigation.internal.ade.j) fVar.t();
                                        jVar3.getClass();
                                        qVar.c = jVar3;
                                        qVar.b |= 1;
                                        com.google.android.libraries.navigation.internal.add.q qVar2 = (com.google.android.libraries.navigation.internal.add.q) pVar.t();
                                        if ((elVar.c == 22 ? (fh) elVar.d : fh.a).j.size() != 0) {
                                            com.google.android.libraries.navigation.internal.add.o oVar2 = (com.google.android.libraries.navigation.internal.add.o) com.google.android.libraries.navigation.internal.add.t.a.q();
                                            String str4 = (String) (elVar.c == 22 ? (fh) elVar.d : fh.a).j.get(0);
                                            if (!oVar2.b.H()) {
                                                oVar2.v();
                                            }
                                            com.google.android.libraries.navigation.internal.add.t tVar4 = (com.google.android.libraries.navigation.internal.add.t) oVar2.b;
                                            str4.getClass();
                                            tVar4.e = str4;
                                            if (!oVar2.b.H()) {
                                                oVar2.v();
                                            }
                                            com.google.android.libraries.navigation.internal.add.t tVar5 = (com.google.android.libraries.navigation.internal.add.t) oVar2.b;
                                            qVar2.getClass();
                                            tVar5.d = qVar2;
                                            tVar5.c = 9;
                                            com.google.android.libraries.navigation.internal.add.j jVar4 = (com.google.android.libraries.navigation.internal.add.j) com.google.android.libraries.navigation.internal.add.k.a.q();
                                            jVar4.d(com.google.android.libraries.navigation.internal.wf.k.a(xVarW));
                                            jVar4.d(com.google.android.libraries.navigation.internal.wf.k.a(xVarW2));
                                            com.google.android.libraries.navigation.internal.add.k kVar2 = (com.google.android.libraries.navigation.internal.add.k) jVar4.t();
                                            if (!oVar2.b.H()) {
                                                oVar2.v();
                                            }
                                            com.google.android.libraries.navigation.internal.add.t tVar6 = (com.google.android.libraries.navigation.internal.add.t) oVar2.b;
                                            kVar2.getClass();
                                            tVar6.f = kVar2;
                                            tVar6.b |= 1;
                                            oVar2.d(com.google.android.libraries.navigation.internal.wf.k.d(elVar.f221n));
                                            oVar2.c(com.google.android.libraries.navigation.internal.wf.k.d(elVar.p));
                                            com.google.android.libraries.navigation.internal.adr.n nVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).p;
                                            if (nVar == null) {
                                                nVar = com.google.android.libraries.navigation.internal.adr.n.a;
                                            }
                                            int iA = com.google.android.libraries.navigation.internal.adr.m.a(nVar.d);
                                            if (iA == 0) {
                                                iA = com.google.android.libraries.navigation.internal.adr.m.a;
                                            }
                                            if (iA == com.google.android.libraries.navigation.internal.adr.m.d) {
                                                ba baVar2 = (ba) bb.a.q();
                                                com.google.android.libraries.navigation.internal.adr.n nVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).p;
                                                if (nVar2 == null) {
                                                    nVar2 = com.google.android.libraries.navigation.internal.adr.n.a;
                                                }
                                                String str5 = nVar2.c;
                                                if (!baVar2.b.H()) {
                                                    baVar2.v();
                                                }
                                                bb bbVar3 = (bb) baVar2.b;
                                                str5.getClass();
                                                bbVar3.b = str5;
                                                if (!oVar2.b.H()) {
                                                    oVar2.v();
                                                }
                                                com.google.android.libraries.navigation.internal.add.t tVar7 = (com.google.android.libraries.navigation.internal.add.t) oVar2.b;
                                                bb bbVar4 = (bb) baVar2.t();
                                                bbVar4.getClass();
                                                tVar7.i = bbVar4;
                                                tVar7.b |= 2;
                                            }
                                            tVar = (com.google.android.libraries.navigation.internal.add.t) oVar2.t();
                                        }
                                    }
                                }
                            }
                            tVar = null;
                        }
                        if (tVar != null) {
                            eqVar.h(tVar);
                        }
                    }
                } else {
                    fdVar2 = fdVarB;
                    cVar3 = cVar;
                    d = d2;
                    evVar = evVarW;
                    i = i8;
                }
                i9++;
                evVarW = evVar;
                i8 = i;
                d2 = d;
                cVar = cVar3;
                fdVarB = fdVar2;
            }
            fdVar = fdVarB;
            cVar2 = cVar;
            evVarG = eqVar.g();
        }
        yVar2.b(evVarG);
        bq[] bqVarArr = bgVar.l;
        long j2 = wVar.f;
        int i12 = (int) wVar.e;
        eq eqVar2 = new eq();
        for (bq bqVar : bqVarArr) {
            for (hi hiVar : bqVar.C) {
                int i13 = bqVar.m + hiVar.f;
                int i14 = i12;
                if (i13 <= i14 && i14 < i13 + 500) {
                    int i15 = bqVar.i;
                    bb bbVarE = com.google.android.libraries.navigation.internal.wf.k.e(hiVar.e, com.google.android.libraries.navigation.internal.adr.m.a);
                    if (bbVarE == null) {
                        tVar3 = null;
                    } else {
                        com.google.android.libraries.navigation.internal.add.m mVar = (com.google.android.libraries.navigation.internal.add.m) com.google.android.libraries.navigation.internal.add.n.a.q();
                        String str6 = (hiVar.b == 6 ? (hh) hiVar.c : hh.a).b;
                        if (!mVar.b.H()) {
                            mVar.v();
                        }
                        com.google.android.libraries.navigation.internal.add.n nVar3 = (com.google.android.libraries.navigation.internal.add.n) mVar.b;
                        str6.getClass();
                        nVar3.b |= 1;
                        nVar3.c = str6;
                        String str7 = hiVar.d;
                        if (!mVar.b.H()) {
                            mVar.v();
                        }
                        com.google.android.libraries.navigation.internal.add.n nVar4 = (com.google.android.libraries.navigation.internal.add.n) mVar.b;
                        str7.getClass();
                        nVar4.d = str7;
                        com.google.android.libraries.navigation.internal.add.n nVar5 = (com.google.android.libraries.navigation.internal.add.n) mVar.t();
                        com.google.android.libraries.navigation.internal.add.o oVar3 = (com.google.android.libraries.navigation.internal.add.o) com.google.android.libraries.navigation.internal.add.t.a.q();
                        String string = com.google.android.libraries.navigation.internal.zl.aa.a.e().i(j2).c(i15).c(hiVar.f).o().toString();
                        if (!oVar3.b.H()) {
                            oVar3.v();
                        }
                        ((com.google.android.libraries.navigation.internal.add.t) oVar3.b).e = string;
                        if (!oVar3.b.H()) {
                            oVar3.v();
                        }
                        com.google.android.libraries.navigation.internal.add.t tVar8 = (com.google.android.libraries.navigation.internal.add.t) oVar3.b;
                        nVar5.getClass();
                        tVar8.d = nVar5;
                        tVar8.c = 3;
                        if (!oVar3.b.H()) {
                            oVar3.v();
                        }
                        com.google.android.libraries.navigation.internal.add.t tVar9 = (com.google.android.libraries.navigation.internal.add.t) oVar3.b;
                        tVar9.i = bbVarE;
                        tVar9.b |= 2;
                        oVar3.e(bbVarE.b);
                        tVar3 = (com.google.android.libraries.navigation.internal.add.t) oVar3.t();
                    }
                    if (tVar3 != null) {
                        eqVar2.h(tVar3);
                    }
                    bqVarArr = bqVarArr;
                }
            }
        }
        yVar2.b(eqVar2.g());
        com.google.android.libraries.navigation.internal.we.r rVar = wVar.c;
        String strA = com.google.android.libraries.navigation.internal.we.r.a(jVar);
        String str8 = rVar.b;
        if (str8 == null) {
            rVar.b = strA;
        } else if (strA.equals(str8)) {
            final com.google.android.libraries.navigation.internal.we.q qVar3 = rVar.a;
            if (qVar3 != null) {
                if (qVar3.b.a() < rVar.c.f().toEpochMilli() || Arrays.stream((bg[]) jVar.b().b().toArray(new bg[0])).noneMatch(new Predicate() { // from class: com.google.android.libraries.navigation.internal.we.p
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ((com.google.android.libraries.navigation.internal.bp.bg) obj).Z.equals(qVar3.a);
                    }
                })) {
                    rVar.a = null;
                }
            }
        } else {
            rVar.b = strA;
            rVar.a = null;
        }
        com.google.android.libraries.navigation.internal.tj.o oVar4 = jVar.j;
        com.google.android.libraries.navigation.internal.tj.o oVar5 = jVar.j;
        com.google.android.libraries.navigation.internal.se.b bVarB = oVar4.b();
        if (bVarB != null && (kqVar = oVar5.c) != null) {
            com.google.android.libraries.navigation.internal.tj.d dVar2 = rVar.d;
            bh bhVarB2 = jVar.b();
            Instant instant = jVar.c().b.i;
            jg jgVar = kqVar.e;
            if (jgVar == null) {
                jgVar = jg.a;
            }
            jb jbVar = jgVar.k;
            if (jbVar == null) {
                jbVar = jb.a;
            }
            rVar.a = new com.google.android.libraries.navigation.internal.we.q(bVarB.b.Z, dVar2.a(kqVar, bhVarB2, bVarB.b, instant.plusSeconds(jbVar.c)));
        }
        com.google.android.libraries.navigation.internal.we.q qVar4 = rVar.a;
        if (qVar4 != null) {
            com.google.android.libraries.navigation.internal.add.x xVar = (com.google.android.libraries.navigation.internal.add.x) fdVar.get(qVar4.a);
            if (xVar == null || com.google.android.libraries.navigation.internal.we.r.a(jVar).equals(qVar4.a)) {
                str2 = null;
            } else {
                com.google.android.libraries.navigation.internal.ade.l lVar = xVar.c;
                if (lVar == null) {
                    lVar = com.google.android.libraries.navigation.internal.ade.l.a;
                }
                com.google.android.libraries.navigation.internal.ade.p pVar2 = lVar.b;
                if (pVar2 == null) {
                    pVar2 = com.google.android.libraries.navigation.internal.ade.p.a;
                }
                str2 = pVar2.b;
            }
            com.google.android.libraries.navigation.internal.tj.b bVar3 = qVar4.b;
            jg jgVar2 = bVar3.b.e;
            if (jgVar2 == null) {
                jgVar2 = jg.a;
            }
            bb bbVarE2 = com.google.android.libraries.navigation.internal.wf.k.e(jgVar2.f, com.google.android.libraries.navigation.internal.adr.m.c);
            if (bbVarE2 == null) {
                tVar2 = null;
            } else {
                com.google.android.libraries.navigation.internal.add.o oVar6 = (com.google.android.libraries.navigation.internal.add.o) com.google.android.libraries.navigation.internal.add.t.a.q();
                com.google.android.libraries.navigation.internal.add.g gVar2 = (com.google.android.libraries.navigation.internal.add.g) com.google.android.libraries.navigation.internal.add.i.a.q();
                com.google.android.libraries.navigation.internal.ady.ad adVarB = com.google.android.libraries.navigation.internal.ady.ad.b(bVar3.b.c);
                if (adVarB == null) {
                    adVarB = com.google.android.libraries.navigation.internal.ady.ad.REROUTE_TYPE_BETTER_ETA;
                }
                int iOrdinal2 = adVarB.ordinal();
                if (iOrdinal2 == 0) {
                    i4 = com.google.android.libraries.navigation.internal.add.h.b;
                } else if (iOrdinal2 == 1) {
                    i4 = com.google.android.libraries.navigation.internal.add.h.c;
                } else if (iOrdinal2 != 2) {
                    i4 = iOrdinal2 != 3 ? com.google.android.libraries.navigation.internal.add.h.a : com.google.android.libraries.navigation.internal.add.h.e;
                } else {
                    i4 = com.google.android.libraries.navigation.internal.add.h.d;
                }
                if (!gVar2.b.H()) {
                    gVar2.v();
                }
                com.google.android.libraries.navigation.internal.add.i iVar2 = (com.google.android.libraries.navigation.internal.add.i) gVar2.b;
                if (i4 == 0) {
                    throw null;
                }
                com.google.android.libraries.navigation.internal.ael.bq bqVar2 = iVar2.b;
                if (!bqVar2.c()) {
                    iVar2.b = bi.w(bqVar2);
                }
                iVar2.b.i(com.google.android.libraries.navigation.internal.add.h.a(i4));
                if (str2 != null) {
                    if (!gVar2.b.H()) {
                        gVar2.v();
                    }
                    ((com.google.android.libraries.navigation.internal.add.i) gVar2.b).c = str2;
                }
                jg jgVar3 = bVar3.b.e;
                if (jgVar3 == null) {
                    jgVar3 = jg.a;
                }
                el elVar2 = jgVar3.i;
                if (elVar2 == null) {
                    elVar2 = el.a;
                }
                oVar6.d(com.google.android.libraries.navigation.internal.wf.k.d(elVar2.f221n));
                jg jgVar4 = bVar3.b.e;
                if (jgVar4 == null) {
                    jgVar4 = jg.a;
                }
                el elVar3 = jgVar4.i;
                if (elVar3 == null) {
                    elVar3 = el.a;
                }
                oVar6.c(com.google.android.libraries.navigation.internal.wf.k.d(elVar3.p));
                kq kqVar2 = bVar3.b;
                com.google.android.libraries.navigation.internal.zl.m mVar2 = com.google.android.libraries.navigation.internal.zl.aa.a;
                jg jgVar5 = kqVar2.e;
                if (jgVar5 == null) {
                    jgVar5 = jg.a;
                }
                ByteBuffer byteBufferN = jgVar5.g.n();
                String string2 = ((com.google.android.libraries.navigation.internal.zl.b) mVar2).c(byteBufferN.remaining()).a(byteBufferN).o().toString();
                if (!oVar6.b.H()) {
                    oVar6.v();
                }
                ((com.google.android.libraries.navigation.internal.add.t) oVar6.b).e = string2;
                com.google.android.libraries.navigation.internal.add.i iVar3 = (com.google.android.libraries.navigation.internal.add.i) gVar2.t();
                if (!oVar6.b.H()) {
                    oVar6.v();
                }
                com.google.android.libraries.navigation.internal.add.t tVar10 = (com.google.android.libraries.navigation.internal.add.t) oVar6.b;
                iVar3.getClass();
                tVar10.d = iVar3;
                tVar10.c = 4;
                com.google.android.libraries.navigation.internal.add.j jVar5 = (com.google.android.libraries.navigation.internal.add.j) com.google.android.libraries.navigation.internal.add.k.a.q();
                iz izVar = bVar3.d;
                bg bgVarH = bVar3.h();
                bg bgVar2 = bVar3.c;
                int i16 = izVar.b;
                if ((i16 & 8) != 0) {
                    com.google.android.libraries.navigation.internal.adq.ab abVar = izVar.f;
                    if (abVar == null) {
                        abVar = com.google.android.libraries.navigation.internal.adq.ab.a;
                    }
                    jVar5.c(com.google.android.libraries.navigation.internal.wf.k.c(abVar));
                    kVar = (com.google.android.libraries.navigation.internal.add.k) jVar5.t();
                } else {
                    if (izVar.e) {
                        if (bgVarH != null) {
                            i5 = 0;
                            jVar5.c(com.google.android.libraries.navigation.internal.wf.k.b(bgVarH, 0, bgVarH.J));
                        } else {
                            i5 = 0;
                        }
                        jVar5.c(com.google.android.libraries.navigation.internal.wf.k.b(bgVar2, i5, bgVar2.J));
                    } else {
                        if ((i16 & 1) != 0 && bgVarH != null) {
                            jf jfVar = izVar.c;
                            if (jfVar == null) {
                                jfVar = jf.a;
                            }
                            int i17 = jfVar.c;
                            jf jfVar2 = izVar.c;
                            if (jfVar2 == null) {
                                jfVar2 = jf.a;
                            }
                            jVar5.c(com.google.android.libraries.navigation.internal.wf.k.b(bgVarH, i17, jfVar2.d));
                        }
                        if ((izVar.b & 2) != 0) {
                            jf jfVar3 = izVar.d;
                            if (jfVar3 == null) {
                                jfVar3 = jf.a;
                            }
                            int i18 = jfVar3.c;
                            jf jfVar4 = izVar.d;
                            if (jfVar4 == null) {
                                jfVar4 = jf.a;
                            }
                            jVar5.c(com.google.android.libraries.navigation.internal.wf.k.b(bgVar2, i18, jfVar4.d));
                        }
                    }
                    kVar = (com.google.android.libraries.navigation.internal.add.k) jVar5.t();
                }
                if (!oVar6.b.H()) {
                    oVar6.v();
                }
                com.google.android.libraries.navigation.internal.add.t tVar11 = (com.google.android.libraries.navigation.internal.add.t) oVar6.b;
                kVar.getClass();
                tVar11.f = kVar;
                tVar11.b |= 1;
                if (!oVar6.b.H()) {
                    oVar6.v();
                }
                com.google.android.libraries.navigation.internal.add.t tVar12 = (com.google.android.libraries.navigation.internal.add.t) oVar6.b;
                tVar12.i = bbVarE2;
                tVar12.b |= 2;
                tVar2 = (com.google.android.libraries.navigation.internal.add.t) oVar6.t();
            }
            str = null;
        } else {
            str = null;
            tVar2 = null;
        }
        if (tVar2 != null) {
            yVar2.a(tVar2);
        }
        com.google.android.libraries.navigation.internal.we.az azVarA = wVar.d.a(jVar);
        if (azVarA != null) {
            com.google.android.libraries.navigation.internal.we.n nVar6 = (com.google.android.libraries.navigation.internal.we.n) azVarA;
            if (!com.google.android.libraries.navigation.internal.yx.am.a(wVar.g, nVar6.a.e)) {
                jg jgVar6 = jVar.c().b.E;
                com.google.android.libraries.navigation.internal.yx.ar.q(jgVar6);
                yVar2.b = new com.google.android.libraries.navigation.internal.tj.ag(jgVar6, jVar.b(), jVar.c().b.i.toEpochMilli());
            }
            if (!nVar6.b) {
                yVar2.a(nVar6.a);
            }
        }
        wVar.g = azVarA != null ? ((com.google.android.libraries.navigation.internal.we.n) azVarA).a.e : str;
        com.google.android.libraries.navigation.internal.we.m mVar3 = new com.google.android.libraries.navigation.internal.we.m(yVar2.a.g(), yVar2.b);
        this.a = mVar3.b;
        com.google.android.libraries.navigation.internal.we.ai aiVar = this.h;
        com.google.android.libraries.navigation.internal.we.i iVar4 = this.f;
        return aiVar.a(com.google.android.libraries.navigation.internal.add.ab.d, iVar4.e(), jVar, iVar4.b(), true, cVar2, mVar3.a);
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.y
    public final void a(final com.google.android.libraries.navigation.internal.tj.j jVar, final com.google.android.libraries.navigation.internal.sd.b bVar, final com.google.android.libraries.navigation.internal.sd.a aVar) {
        if (((hm) this.b.b()).f165n) {
            com.google.android.libraries.navigation.internal.wn.e eVar = this.k;
            Callable callable = new Callable() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(this.a.d(jVar, bVar));
                }
            };
            com.google.android.libraries.navigation.internal.km.x xVar = com.google.android.libraries.navigation.internal.km.ak.a;
            com.google.android.libraries.navigation.internal.km.ad adVar = com.google.android.libraries.navigation.internal.km.ak.g;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("AggregatedNavigationStateGenerator.publishAggregatedGuidedNavState");
            try {
                com.google.android.libraries.navigation.internal.kk.m mVarA = ((com.google.android.libraries.navigation.internal.kk.n) eVar.b.a(adVar)).a();
                try {
                    if (((Boolean) callable.call()).booleanValue()) {
                        mVarA.a();
                        ((com.google.android.libraries.navigation.internal.kk.k) eVar.b.a(xVar)).a(com.google.android.libraries.navigation.internal.km.ah.a(2));
                    } else {
                        ((com.google.android.libraries.navigation.internal.kk.k) eVar.b.a(xVar)).a(com.google.android.libraries.navigation.internal.km.ah.a(1));
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                } catch (com.google.android.libraries.navigation.internal.wq.b e) {
                    ((com.google.android.libraries.navigation.internal.kk.k) eVar.b.a(xVar)).a(com.google.android.libraries.navigation.internal.km.ah.a(1));
                    throw e;
                } catch (Exception e2) {
                    ((com.google.android.libraries.navigation.internal.kk.k) eVar.b.a(xVar)).a(com.google.android.libraries.navigation.internal.km.ah.a(1));
                    throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.UNKNOWN, e2.getMessage(), e2.getCause()));
                }
            } catch (Throwable th) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.y
    public final void b(com.google.android.libraries.navigation.internal.tj.h hVar) {
        com.google.android.libraries.navigation.internal.add.af afVar = (com.google.android.libraries.navigation.internal.add.af) com.google.android.libraries.navigation.internal.add.ag.a.q();
        com.google.android.libraries.navigation.internal.add.aa aaVar = (com.google.android.libraries.navigation.internal.add.aa) com.google.android.libraries.navigation.internal.add.ac.a.q();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.ac) aaVar.b).b = "";
        int i = com.google.android.libraries.navigation.internal.add.ab.b;
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.ac) aaVar.b).c = com.google.android.libraries.navigation.internal.add.ab.b(i);
        if (!afVar.b.H()) {
            afVar.v();
        }
        com.google.android.libraries.navigation.internal.add.ag agVar = (com.google.android.libraries.navigation.internal.add.ag) afVar.b;
        com.google.android.libraries.navigation.internal.add.ac acVar = (com.google.android.libraries.navigation.internal.add.ac) aaVar.t();
        acVar.getClass();
        agVar.c = acVar;
        agVar.b |= 1;
        com.google.android.libraries.navigation.internal.add.ag agVar2 = (com.google.android.libraries.navigation.internal.add.ag) afVar.t();
        com.google.android.libraries.navigation.internal.rw.a aVarA = com.google.android.libraries.navigation.internal.rw.b.a();
        aVarA.b(com.google.android.libraries.navigation.internal.rw.p.CRUISING);
        ((com.google.android.libraries.navigation.internal.rw.h) aVarA).b = hVar;
        aVarA.c(agVar2);
        aVarA.d(new com.google.android.libraries.navigation.internal.rw.j(null, hVar, null, null));
        this.e.f(aVarA.a());
        ((com.google.android.libraries.navigation.internal.we.l) this.i.a()).f();
    }

    @Override // com.google.android.libraries.geo.navcore.guidance.impl.y
    public final void c(com.google.android.libraries.navigation.internal.tj.j jVar, com.google.android.libraries.navigation.internal.sd.b bVar, com.google.android.libraries.navigation.internal.sd.a aVar) {
        d(jVar, bVar);
    }

    public final boolean d(com.google.android.libraries.navigation.internal.tj.j jVar, com.google.android.libraries.navigation.internal.sd.b bVar) {
        com.google.android.libraries.navigation.internal.vn.d dVarD;
        com.google.android.libraries.navigation.internal.rw.l lVar;
        try {
            com.google.android.libraries.navigation.internal.add.ag agVarE = e(jVar, bVar);
            int i = ev.d;
            ev evVar = lv.a;
            if (bVar != null) {
                dVarD = this.j.d(bVar.a, bVar.e, bVar.b, jVar.c().p, bVar.c);
            } else {
                dVarD = null;
            }
            com.google.android.libraries.navigation.internal.tj.u uVar = this.a;
            if (dVarD == null && evVar.isEmpty()) {
                lVar = null;
            } else {
                com.google.android.libraries.navigation.internal.rw.k kVar = new com.google.android.libraries.navigation.internal.rw.k();
                Objects.requireNonNull(evVar);
                kVar.f = evVar;
                if (dVarD != null) {
                    kVar.a = dVarD.a;
                    kVar.b = dVarD.b;
                    kVar.c = dVarD.c;
                    kVar.d = dVarD.d;
                    kVar.e = dVarD.f;
                    kVar.g = ((com.google.android.libraries.navigation.internal.tu.g) dVarD.a).b;
                }
                ev evVar2 = kVar.f;
                if (evVar2 == null) {
                    throw new IllegalStateException();
                }
                lVar = new com.google.android.libraries.navigation.internal.rw.l(kVar.a, kVar.b, kVar.c, kVar.d, kVar.e, evVar2, kVar.g);
            }
            com.google.android.libraries.navigation.internal.rw.j jVar2 = new com.google.android.libraries.navigation.internal.rw.j(jVar, null, lVar, uVar);
            com.google.android.libraries.navigation.internal.rw.a aVarA = com.google.android.libraries.navigation.internal.rw.b.a();
            aVarA.b(com.google.android.libraries.navigation.internal.rw.p.GUIDING);
            ((com.google.android.libraries.navigation.internal.rw.h) aVarA).a = jVar;
            aVarA.c(agVarE);
            aVarA.d(jVar2);
            this.e.f(aVarA.a());
            return true;
        } catch (com.google.android.libraries.navigation.internal.wq.b unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1398)).p("Failed to generate GuidanceUpdateEvent");
            return false;
        }
    }
}
