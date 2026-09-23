package com.google.android.apps.gmm.location.navigation;

import com.adobe.internal.xmp.options.PropertyOptions;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.google.android.libraries.navigation.internal.acu.cf;
import com.google.android.libraries.navigation.internal.adr.gv;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ael.cs;
import com.google.android.libraries.navigation.internal.agg.ef;
import com.google.android.libraries.navigation.internal.agi.cl;
import com.google.android.libraries.navigation.internal.agi.cn;
import com.google.android.libraries.navigation.internal.agi.cu;
import j$.time.Duration;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.w");

    /* JADX WARN: Code duplicated, block: B:193:0x03f2  */
    public static com.google.android.libraries.navigation.internal.db.q a(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.acu.ah ahVar, com.google.android.libraries.navigation.internal.bp.bh bhVar, long j) {
        com.google.android.libraries.navigation.internal.db.m mVar;
        int i;
        if ((ahVar.b & 1) == 0) {
            return null;
        }
        com.google.android.libraries.navigation.internal.acu.aj ajVar = ahVar.d;
        if (ajVar == null) {
            ajVar = com.google.android.libraries.navigation.internal.acu.aj.a;
        }
        com.google.android.libraries.navigation.internal.db.q qVar = new com.google.android.libraries.navigation.internal.db.q(aVar);
        qVar.a = "gmfc";
        qVar.k = Duration.ofMillis(j);
        qVar.l = Instant.ofEpochMilli(aVar.f().toEpochMilli());
        qVar.r(true);
        long j2 = ahVar.v;
        com.google.android.libraries.navigation.internal.db.ak akVarD = qVar.d();
        com.google.android.libraries.navigation.internal.db.ak akVar = com.google.android.libraries.navigation.internal.db.ak.a;
        akVarD.s = j2;
        if ((ahVar.b & 8388608) != 0) {
            qVar.d().t = ahVar.w;
            qVar.d().u = ahVar.x;
            qVar.d().v = ahVar.y;
            qVar.d().w = ahVar.z;
        }
        qVar.d().x = ahVar.A;
        qVar.d().I = ajVar;
        if ((ahVar.b & 32768) != 0) {
            qVar.d().g = ahVar.r;
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x(ajVar.c, ajVar.d);
        qVar.s(xVar.b(), xVar.d());
        int i2 = ajVar.b;
        if ((i2 & 32) != 0) {
            qVar.g = ajVar.h;
        }
        if ((i2 & 8) != 0) {
            qVar.i = ajVar.f;
        }
        int i3 = ahVar.b;
        if ((i3 & 4) != 0) {
            qVar.e = ahVar.f;
        }
        if ((i2 & 4) != 0) {
            qVar.d = ajVar.e;
        }
        if ((i2 & 16) != 0) {
            qVar.j = ajVar.g;
        }
        if ((i2 & 64) != 0) {
            qVar.h = ajVar.i;
        }
        if ((i3 & 8) != 0) {
            qVar.f = ahVar.g;
        }
        if (ahVar.h) {
            qVar.d().h = true;
        }
        if (ajVar.j) {
            qVar.d().c = true;
        }
        com.google.android.libraries.navigation.internal.acu.bz bzVar = ajVar.k;
        if (bzVar == null) {
            bzVar = com.google.android.libraries.navigation.internal.acu.bz.a;
        }
        if (bzVar.c) {
            qVar.d().b = true;
        }
        int i4 = ahVar.b;
        if ((i4 & 4096) != 0) {
            com.google.android.libraries.navigation.internal.db.af afVar = new com.google.android.libraries.navigation.internal.db.af((i4 & 8192) != 0 ? ahVar.p : null, ahVar.o);
            if (!bzVar.c) {
                int i5 = bzVar.b;
                if ((i5 & 2) != 0 && (i5 & 4) != 0 && (i4 & 16384) != 0) {
                    com.google.android.libraries.navigation.internal.db.ai.b(qVar, afVar, new com.google.android.libraries.navigation.internal.oe.x(bzVar.d, bzVar.e), ahVar.q);
                }
            } else if ((ajVar.b & 32) != 0) {
                com.google.android.libraries.navigation.internal.db.ai.b(qVar, afVar, xVar, ajVar.h);
            }
        }
        if ((ahVar.b & 2048) != 0) {
            qVar.d().N = ahVar.f172n;
        }
        if ((ahVar.b & 128) != 0) {
            qVar.d().O = ahVar.j;
        }
        if ((ahVar.b & 256) != 0) {
            qVar.d().P = ahVar.k;
        }
        int i6 = ahVar.b;
        if ((i6 & 512) != 0 && (i6 & 1024) != 0) {
            qVar.d().L = new com.google.android.libraries.navigation.internal.oe.x(ahVar.l, ahVar.m);
        }
        if ((ahVar.b & 65536) != 0) {
            com.google.android.libraries.navigation.internal.db.ae aeVar = ahVar.s;
            if (aeVar == null) {
                aeVar = com.google.android.libraries.navigation.internal.db.ae.a;
            }
            qVar.d().E = aeVar;
        }
        if ((ahVar.b & 131072) != 0) {
            com.google.android.libraries.navigation.internal.adj.d dVar = ahVar.t;
            if (dVar == null) {
                dVar = com.google.android.libraries.navigation.internal.adj.d.a;
            }
            qVar.d().F = dVar;
        }
        if ((ahVar.b & 262144) != 0) {
            qVar.d().G = ahVar.u;
        }
        if ((ahVar.c & 128) != 0) {
            cb cbVar = ahVar.Q;
            if (cbVar == null) {
                cbVar = cb.a;
            }
            qVar.d().H = cbVar;
        }
        if ((ahVar.b & 2) != 0) {
            com.google.android.libraries.navigation.internal.db.aa aaVar = ahVar.e;
            if (aaVar == null) {
                aaVar = com.google.android.libraries.navigation.internal.db.aa.a;
            }
            qVar.d().Q = aaVar;
        }
        int size = bzVar.f.size();
        if (size > 0) {
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = bzVar.f.d(i7);
            }
            qVar.d().C = new ef(iArr);
        }
        qVar.d().p = ahVar.C;
        qVar.d().m = ahVar.D;
        qVar.d().f385n = ahVar.E;
        qVar.d().o = ahVar.F;
        if ((ahVar.b & PropertyOptions.DELETE_EXISTING) != 0) {
            qVar.d().r = ahVar.G;
        }
        if ((ahVar.b & Integer.MIN_VALUE) != 0) {
            com.google.android.libraries.navigation.internal.zr.d dVar2 = ahVar.H;
            if (dVar2 == null) {
                dVar2 = com.google.android.libraries.navigation.internal.zr.d.a;
            }
            qVar.d().y = dVar2;
        }
        if ((ahVar.c & 1) != 0) {
            qVar.d().z = ahVar.I;
        }
        com.google.android.libraries.navigation.internal.bp.bg bgVarF = bhVar.f();
        if (bgVarF != null) {
            qVar.d().j = bgVarF.Y;
            qVar.d().k = bgVarF.Z;
        }
        if ((ajVar.b & 512) != 0) {
            com.google.android.libraries.navigation.internal.acu.bg bgVar = ajVar.l;
            if (bgVar == null) {
                bgVar = com.google.android.libraries.navigation.internal.acu.bg.a;
            }
            com.google.android.libraries.navigation.internal.db.x xVar2 = new com.google.android.libraries.navigation.internal.db.x();
            xVar2.a.addAll(bgVar.b);
            Iterator it2 = bhVar.iterator();
            while (it2.hasNext()) {
                com.google.android.libraries.navigation.internal.bp.bg bgVar2 = (com.google.android.libraries.navigation.internal.bp.bg) it2.next();
                com.google.android.libraries.navigation.internal.aci.d dVar3 = (com.google.android.libraries.navigation.internal.aci.d) Collections.unmodifiableMap(bgVar.d).get(Long.valueOf(bgVar2.Y));
                if (dVar3 != null) {
                    int i8 = dVar3.b;
                    if ((i8 & 1) != 0 && (i8 & 2) != 0) {
                        long j3 = bgVar2.Y;
                        xVar2.c.a(j3, dVar3);
                        xVar2.a.c(j3);
                        double dC = bgVar2.c(dVar3);
                        if (!Double.isNaN(dC)) {
                            long j4 = bgVar2.Y;
                            xVar2.b.b(j4, dC);
                            xVar2.a.c(j4);
                        }
                    }
                }
            }
            for (com.google.android.libraries.navigation.internal.acu.bd bdVar : bgVar.c) {
                com.google.android.libraries.navigation.internal.agh.ai aiVar = new com.google.android.libraries.navigation.internal.agh.ai();
                Iterator it3 = bhVar.iterator();
                while (it3.hasNext()) {
                    com.google.android.libraries.navigation.internal.bp.bg bgVar3 = (com.google.android.libraries.navigation.internal.bp.bg) it3.next();
                    com.google.android.libraries.navigation.internal.aci.d dVar4 = (com.google.android.libraries.navigation.internal.aci.d) Collections.unmodifiableMap(bdVar.i).get(Long.valueOf(bgVar3.Y));
                    if (dVar4 != null) {
                        int i9 = dVar4.b;
                        if ((i9 & 1) != 0 && (i9 & 2) != 0) {
                            double dC2 = bgVar3.c(dVar4);
                            if (!Double.isNaN(dC2)) {
                                aiVar.b(bgVar3.Y, dC2);
                            }
                        }
                    }
                }
                int iA = com.google.android.libraries.navigation.internal.aax.h.a;
                if ((bdVar.b & 128) != 0 && (iA = com.google.android.libraries.navigation.internal.aax.h.a(bdVar.k)) == 0) {
                    iA = com.google.android.libraries.navigation.internal.aax.h.a;
                }
                float f = bdVar.c;
                com.google.android.libraries.navigation.internal.db.p pVar = new com.google.android.libraries.navigation.internal.db.p(bdVar.d, Math.sqrt(bdVar.e));
                float f2 = bdVar.f;
                float f3 = bdVar.h;
                int i10 = com.google.android.libraries.navigation.internal.db.c.i;
                com.google.android.libraries.navigation.internal.db.b bVar = new com.google.android.libraries.navigation.internal.db.b(f, pVar, f2, aiVar, f3);
                bVar.g = bdVar.j;
                bVar.e = bdVar.g;
                bVar.h = iA;
                com.google.android.libraries.navigation.internal.db.c cVar = new com.google.android.libraries.navigation.internal.db.c(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g, bVar.h);
                xVar2.d.add(cVar);
                xVar2.a.d(cVar.c());
            }
            qVar.d().i = new com.google.android.libraries.navigation.internal.db.y(xVar2.a, xVar2.b, xVar2.c, xVar2.d);
        }
        com.google.android.libraries.navigation.internal.acu.ad adVar = ahVar.K;
        if (adVar == null) {
            adVar = com.google.android.libraries.navigation.internal.acu.ad.a;
        }
        int size2 = adVar.b.size();
        if (size2 < 3) {
            mVar = null;
        } else {
            mVar = new com.google.android.libraries.navigation.internal.db.m();
            int i11 = 0;
            com.google.android.libraries.navigation.internal.db.l lVar = null;
            while (i11 + 2 < size2) {
                int i12 = i11 / 3;
                com.google.android.libraries.navigation.internal.acu.af afVar2 = adVar.d.size() > i12 ? (com.google.android.libraries.navigation.internal.acu.af) adVar.d.get(i12) : com.google.android.libraries.navigation.internal.acu.af.a;
                if (afVar2.c) {
                    i = afVar2.b;
                    if ((i & 2) != 0 || (i & 4) == 0) {
                        lVar = null;
                    } else {
                        com.google.android.libraries.navigation.internal.aci.d dVar5 = afVar2.d;
                        if (dVar5 == null) {
                            dVar5 = com.google.android.libraries.navigation.internal.aci.d.a;
                        }
                        com.google.android.libraries.navigation.internal.aci.d dVar6 = afVar2.e;
                        if (dVar6 == null) {
                            dVar6 = com.google.android.libraries.navigation.internal.aci.d.a;
                        }
                        lVar = new com.google.android.libraries.navigation.internal.db.l(dVar5, dVar6);
                    }
                } else if (i11 == 0) {
                    i11 = 0;
                    i = afVar2.b;
                    if ((i & 2) != 0) {
                        lVar = null;
                    } else {
                        lVar = null;
                    }
                }
                int iD = adVar.b.d(i11);
                int iD2 = adVar.c.d(i11);
                int i13 = i11 + 1;
                int iD3 = adVar.b.d(i13);
                int iD4 = adVar.c.d(i13);
                int i14 = i11 + 2;
                int iD5 = adVar.b.d(i14);
                int iD6 = adVar.c.d(i14);
                mVar.b = new com.google.android.libraries.navigation.internal.oe.x(iD, iD2);
                if (iD3 == iD && iD4 == iD2) {
                    mVar.e(new com.google.android.libraries.navigation.internal.oe.x(iD5, iD6), lVar);
                } else {
                    mVar.d(new com.google.android.libraries.navigation.internal.oe.x(iD3, iD4), new com.google.android.libraries.navigation.internal.oe.x(iD5, iD6), lVar, 10);
                }
                i11 += 3;
            }
        }
        if (mVar != null) {
            com.google.android.libraries.navigation.internal.db.ai.a(qVar, mVar);
        }
        if ((ahVar.c & 4) != 0) {
            com.google.android.libraries.navigation.internal.db.aq aqVar = ahVar.L;
            if (aqVar == null) {
                aqVar = com.google.android.libraries.navigation.internal.db.aq.a;
            }
            qVar.d().D = aqVar;
        }
        for (com.google.android.libraries.navigation.internal.acu.am amVar : ahVar.J) {
            int iA2 = com.google.android.libraries.navigation.internal.acu.ao.a(amVar.b);
            if (iA2 == 0) {
                iA2 = com.google.android.libraries.navigation.internal.acu.ao.a;
            }
            if (iA2 == com.google.android.libraries.navigation.internal.acu.ao.e && amVar.c == 19 && amVar.d > 0) {
                qVar.d().q = true;
            }
        }
        if ((ahVar.c & 256) != 0) {
            com.google.android.libraries.navigation.internal.acu.bx bxVar = ahVar.R;
            if (bxVar == null) {
                bxVar = com.google.android.libraries.navigation.internal.acu.bx.a;
            }
            qVar.d().J = bxVar;
        }
        if ((ahVar.c & 2048) != 0) {
            cf cfVar = ahVar.U;
            if (cfVar == null) {
                cfVar = cf.a;
            }
            qVar.d().K = cfVar;
        }
        return qVar;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0406  */
    /* JADX WARN: Code duplicated, block: B:147:0x0414  */
    /* JADX WARN: Code duplicated, block: B:150:0x0426  */
    /* JADX WARN: Code duplicated, block: B:198:0x042c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.google.android.libraries.navigation.internal.acu.br b(com.google.android.libraries.navigation.internal.bp.bh bhVar, boolean z, boolean z2) {
        Iterator it2;
        boolean z3;
        int i;
        com.google.android.libraries.navigation.internal.acu.bt btVar;
        com.google.android.libraries.navigation.internal.ael.bz bzVar;
        com.google.android.libraries.navigation.internal.acu.bp bpVar = (com.google.android.libraries.navigation.internal.acu.bp) com.google.android.libraries.navigation.internal.acu.br.a.q();
        com.google.android.libraries.navigation.internal.bp.bg bgVarF = bhVar.f();
        boolean z4 = true;
        if (bgVarF != null) {
            if (!bpVar.b.H()) {
                bpVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.br brVar = (com.google.android.libraries.navigation.internal.acu.br) bpVar.b;
            brVar.b |= 1;
            brVar.c = bgVarF.Y;
        }
        Iterator it3 = bhVar.iterator();
        int i2 = 0;
        while (it3.hasNext()) {
            com.google.android.libraries.navigation.internal.bp.bg bgVar = (com.google.android.libraries.navigation.internal.bp.bg) it3.next();
            com.google.android.libraries.navigation.internal.oe.an anVarY = bgVar.y();
            com.google.android.libraries.navigation.internal.bp.bq[] bqVarArrAb = bgVar.ab();
            com.google.android.libraries.navigation.internal.acu.bs bsVar = (com.google.android.libraries.navigation.internal.acu.bs) com.google.android.libraries.navigation.internal.acu.bt.a.q();
            com.google.android.libraries.navigation.internal.aci.e eVar = (com.google.android.libraries.navigation.internal.aci.e) com.google.android.libraries.navigation.internal.aci.f.a.q();
            int iA = anVarY.a();
            com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
            for (int i3 = 0; i3 < iA; i3++) {
                anVarY.e(i3, xVar);
                int i4 = xVar.a;
                if (!eVar.b.H()) {
                    eVar.v();
                }
                com.google.android.libraries.navigation.internal.aci.f fVar = (com.google.android.libraries.navigation.internal.aci.f) eVar.b;
                com.google.android.libraries.navigation.internal.ael.bq bqVar = fVar.b;
                if (!bqVar.c()) {
                    fVar.b = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
                }
                fVar.b.i(i4);
                int i5 = xVar.b;
                if (!eVar.b.H()) {
                    eVar.v();
                }
                com.google.android.libraries.navigation.internal.aci.f fVar2 = (com.google.android.libraries.navigation.internal.aci.f) eVar.b;
                com.google.android.libraries.navigation.internal.ael.bq bqVar2 = fVar2.c;
                if (!bqVar2.c()) {
                    fVar2.c = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar2);
                }
                fVar2.c.i(i5);
            }
            if (!bsVar.b.H()) {
                bsVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.bt btVar2 = (com.google.android.libraries.navigation.internal.acu.bt) bsVar.b;
            com.google.android.libraries.navigation.internal.aci.f fVar3 = (com.google.android.libraries.navigation.internal.aci.f) eVar.t();
            fVar3.getClass();
            btVar2.c = fVar3;
            btVar2.b = (btVar2.b | (z4 ? 1 : 0)) == true ? 1 : 0;
            int iMax = Math.max(i2, bgVar.o);
            if (com.google.android.libraries.navigation.internal.pt.e.a(bgVar.j)) {
                com.google.android.libraries.navigation.internal.pt.d dVarA = null;
                for (com.google.android.libraries.navigation.internal.bp.bq bqVar3 : bqVarArrAb) {
                    int i6 = bqVar3.k;
                    while (((com.google.android.libraries.navigation.internal.acu.bt) bsVar.b).f.size() < i6) {
                        if (dVarA == null) {
                            com.google.android.libraries.navigation.internal.aci.a aVar = (com.google.android.libraries.navigation.internal.aci.a) com.google.android.libraries.navigation.internal.aci.b.a.q();
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aci.b bVar = (com.google.android.libraries.navigation.internal.aci.b) aVar.b;
                            bVar.b |= 2;
                            bVar.d = z4;
                            bsVar.d(aVar);
                        } else {
                            bsVar.e(dVarA.c());
                        }
                    }
                    dVarA = com.google.android.libraries.navigation.internal.pt.d.a(bqVar3.D);
                }
            }
            if (z) {
                if (bgVar.U()) {
                    ii iiVar = bgVar.u;
                    if (iiVar != null) {
                        for (gv gvVar : iiVar.c) {
                            bsVar.f(gvVar.c);
                            bsVar.c((int) gvVar.d);
                        }
                    }
                } else {
                    int seconds = 0;
                    int i7 = 0;
                    for (com.google.android.libraries.navigation.internal.bp.bq bqVar4 : bqVarArrAb) {
                        i7 += bqVar4.l;
                        seconds += (int) bqVar4.f355n.toSeconds();
                        bsVar.f(i7);
                        bsVar.c(seconds);
                    }
                }
            }
            if (z2) {
                ArrayList<com.google.android.libraries.navigation.internal.acm.aa> arrayList = new ArrayList();
                int length = bqVarArrAb.length;
                int i8 = 0;
                while (true) {
                    if (i8 < length) {
                        com.google.android.libraries.navigation.internal.bp.bq bqVar5 = bqVarArrAb[i8];
                        com.google.android.libraries.navigation.internal.acm.p pVar = (com.google.android.libraries.navigation.internal.acm.p) com.google.android.libraries.navigation.internal.acm.aa.a.q();
                        int i9 = bqVar5.k;
                        if (!pVar.b.H()) {
                            pVar.v();
                        }
                        com.google.android.libraries.navigation.internal.acm.aa aaVar = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                        aaVar.b = (aaVar.b | (z4 ? 1 : 0)) == true ? 1 : 0;
                        aaVar.c = i9;
                        int i10 = bqVar5.i;
                        if (!pVar.b.H()) {
                            pVar.v();
                        }
                        com.google.android.libraries.navigation.internal.acm.aa aaVar2 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                        aaVar2.b |= 2;
                        aaVar2.d = i10;
                        int i11 = bqVar5.l;
                        if (!pVar.b.H()) {
                            pVar.v();
                        }
                        com.google.android.libraries.navigation.internal.acm.aa aaVar3 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                        aaVar3.b |= 4;
                        aaVar3.e = i11;
                        int seconds2 = (int) bqVar5.f355n.toSeconds();
                        if (!pVar.b.H()) {
                            pVar.v();
                        }
                        com.google.android.libraries.navigation.internal.acm.aa aaVar4 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                        aaVar4.b |= 8;
                        aaVar4.f = seconds2;
                        int iA2 = com.google.android.libraries.navigation.internal.acm.v.a(bqVar5.d.F);
                        if (iA2 == 0) {
                            arrayList = new ArrayList();
                        } else {
                            if (!pVar.b.H()) {
                                pVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acm.aa aaVar5 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                            aaVar5.g = iA2 - 1;
                            aaVar5.b |= 16;
                            int iA3 = com.google.android.libraries.navigation.internal.acm.z.a(bqVar5.f.j);
                            if (iA3 == 0) {
                                arrayList = new ArrayList();
                            } else {
                                if (!pVar.b.H()) {
                                    pVar.v();
                                }
                                com.google.android.libraries.navigation.internal.acm.aa aaVar6 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                                aaVar6.h = iA3 - 1;
                                aaVar6.b |= 32;
                                int iA4 = com.google.android.libraries.navigation.internal.acm.x.a(bqVar5.e.d);
                                if (iA4 == 0) {
                                    arrayList = new ArrayList();
                                } else {
                                    if (!pVar.b.H()) {
                                        pVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.acm.aa aaVar7 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                                    aaVar7.i = iA4;
                                    aaVar7.b |= 64;
                                    com.google.android.libraries.navigation.internal.acm.q qVar = (com.google.android.libraries.navigation.internal.acm.q) com.google.android.libraries.navigation.internal.acm.t.a.q();
                                    Iterator it4 = bqVar5.B.iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            com.google.android.libraries.navigation.internal.bp.ar arVar = (com.google.android.libraries.navigation.internal.bp.ar) it4.next();
                                            int i12 = arVar.b;
                                            int i13 = i12 - 1;
                                            if (i12 == 0) {
                                                throw null;
                                            }
                                            int iA5 = com.google.android.libraries.navigation.internal.acm.s.a(i13);
                                            if (iA5 == 0) {
                                                arrayList = new ArrayList();
                                            } else {
                                                if (!qVar.b.H()) {
                                                    qVar.v();
                                                }
                                                com.google.android.libraries.navigation.internal.acm.t tVar = (com.google.android.libraries.navigation.internal.acm.t) qVar.b;
                                                com.google.android.libraries.navigation.internal.ael.bq bqVar6 = tVar.b;
                                                if (!bqVar6.c()) {
                                                    tVar.b = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar6);
                                                }
                                                tVar.b.i(iA5 - 1);
                                                com.google.android.libraries.navigation.internal.acm.h hVar = (com.google.android.libraries.navigation.internal.acm.h) com.google.android.libraries.navigation.internal.acm.o.a.q();
                                                int iA6 = com.google.android.libraries.navigation.internal.acm.j.a(i13);
                                                if (iA6 == 0) {
                                                    arrayList = new ArrayList();
                                                } else {
                                                    if (!hVar.b.H()) {
                                                        hVar.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.acm.o oVar = (com.google.android.libraries.navigation.internal.acm.o) hVar.b;
                                                    oVar.c = iA6 - 1;
                                                    oVar.b |= 1;
                                                    Iterator it5 = arVar.a.iterator();
                                                    while (true) {
                                                        if (it5.hasNext()) {
                                                            com.google.android.libraries.navigation.internal.bp.at atVar = (com.google.android.libraries.navigation.internal.bp.at) it5.next();
                                                            int iA7 = com.google.android.libraries.navigation.internal.acm.m.a(atVar.a.g);
                                                            if (iA7 == 0) {
                                                                arrayList = new ArrayList();
                                                            } else {
                                                                Iterator it6 = it3;
                                                                com.google.android.libraries.navigation.internal.acm.k kVar = (com.google.android.libraries.navigation.internal.acm.k) com.google.android.libraries.navigation.internal.acm.n.a.q();
                                                                boolean z5 = atVar.b;
                                                                int i14 = iMax;
                                                                if (!kVar.b.H()) {
                                                                    kVar.v();
                                                                }
                                                                com.google.android.libraries.navigation.internal.acm.n nVar = (com.google.android.libraries.navigation.internal.acm.n) kVar.b;
                                                                int i15 = length;
                                                                nVar.b |= 2;
                                                                nVar.d = z5;
                                                                if (!kVar.b.H()) {
                                                                    kVar.v();
                                                                }
                                                                com.google.android.libraries.navigation.internal.acm.n nVar2 = (com.google.android.libraries.navigation.internal.acm.n) kVar.b;
                                                                nVar2.c = iA7 - 1;
                                                                nVar2.b |= 1;
                                                                com.google.android.libraries.navigation.internal.acm.n nVar3 = (com.google.android.libraries.navigation.internal.acm.n) kVar.t();
                                                                if (!hVar.b.H()) {
                                                                    hVar.v();
                                                                }
                                                                com.google.android.libraries.navigation.internal.acm.o oVar2 = (com.google.android.libraries.navigation.internal.acm.o) hVar.b;
                                                                nVar3.getClass();
                                                                com.google.android.libraries.navigation.internal.ael.bz bzVar2 = oVar2.d;
                                                                if (!bzVar2.c()) {
                                                                    oVar2.d = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                                                }
                                                                oVar2.d.add(nVar3);
                                                                iMax = i14;
                                                                it3 = it6;
                                                                length = i15;
                                                            }
                                                        } else {
                                                            Iterator it7 = it3;
                                                            int i16 = iMax;
                                                            int i17 = length;
                                                            if (!pVar.b.H()) {
                                                                pVar.v();
                                                            }
                                                            com.google.android.libraries.navigation.internal.acm.aa aaVar8 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                                                            com.google.android.libraries.navigation.internal.acm.o oVar3 = (com.google.android.libraries.navigation.internal.acm.o) hVar.t();
                                                            oVar3.getClass();
                                                            com.google.android.libraries.navigation.internal.ael.bz bzVar3 = aaVar8.k;
                                                            if (!bzVar3.c()) {
                                                                aaVar8.k = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar3);
                                                            }
                                                            aaVar8.k.add(oVar3);
                                                            z4 = true;
                                                            iMax = i16;
                                                            it3 = it7;
                                                            length = i17;
                                                        }
                                                    }
                                                }
                                                it2 = it3;
                                                i = iMax;
                                                z3 = true;
                                            }
                                            for (com.google.android.libraries.navigation.internal.acm.aa aaVar9 : arrayList) {
                                                if (!bsVar.b.H()) {
                                                    bsVar.v();
                                                }
                                                btVar = (com.google.android.libraries.navigation.internal.acu.bt) bsVar.b;
                                                aaVar9.getClass();
                                                bzVar = btVar.g;
                                                if (!bzVar.c()) {
                                                    btVar.g = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                                }
                                                btVar.g.add(aaVar9);
                                            }
                                        } else {
                                            Iterator it8 = it3;
                                            Object[] objArr = z4 ? 1 : 0;
                                            int i18 = iMax;
                                            int i19 = length;
                                            if (!pVar.b.H()) {
                                                pVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.acm.aa aaVar10 = (com.google.android.libraries.navigation.internal.acm.aa) pVar.b;
                                            com.google.android.libraries.navigation.internal.acm.t tVar2 = (com.google.android.libraries.navigation.internal.acm.t) qVar.t();
                                            tVar2.getClass();
                                            aaVar10.j = tVar2;
                                            aaVar10.b |= 128;
                                            arrayList.add((com.google.android.libraries.navigation.internal.acm.aa) pVar.t());
                                            i8++;
                                            z4 = objArr == true ? 1 : 0;
                                            iMax = i18;
                                            it3 = it8;
                                            length = i19;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    it2 = it3;
                    z3 = z4;
                    i = iMax;
                    while (r1.hasNext()) {
                        if (!bsVar.b.H()) {
                            bsVar.v();
                        }
                        btVar = (com.google.android.libraries.navigation.internal.acu.bt) bsVar.b;
                        aaVar9.getClass();
                        bzVar = btVar.g;
                        if (!bzVar.c()) {
                            btVar.g = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                        }
                        btVar.g.add(aaVar9);
                    }
                }
            } else {
                it2 = it3;
                z3 = z4 ? 1 : 0;
                i = iMax;
            }
            long j = bgVar.Y;
            com.google.android.libraries.navigation.internal.acu.bt btVar3 = (com.google.android.libraries.navigation.internal.acu.bt) bsVar.t();
            btVar3.getClass();
            if (!bpVar.b.H()) {
                bpVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.br brVar2 = (com.google.android.libraries.navigation.internal.acu.br) bpVar.b;
            cs csVar = brVar2.e;
            if (!csVar.b) {
                brVar2.e = csVar.a();
            }
            brVar2.e.put(Long.valueOf(j), btVar3);
            z4 = z3;
            i2 = i;
            it3 = it2;
        }
        if (!bpVar.b.H()) {
            bpVar.v();
        }
        com.google.android.libraries.navigation.internal.acu.br brVar3 = (com.google.android.libraries.navigation.internal.acu.br) bpVar.b;
        brVar3.b |= 2;
        brVar3.d = i2;
        return (com.google.android.libraries.navigation.internal.acu.br) bpVar.t();
    }

    public static void c(com.google.android.libraries.navigation.internal.kl.a aVar, List list) {
        Iterator it2 = list.iterator();
        com.google.android.libraries.navigation.internal.km.x xVar = null;
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.acu.am amVar = (com.google.android.libraries.navigation.internal.acu.am) it2.next();
            int iA = com.google.android.libraries.navigation.internal.acu.ao.a(amVar.b);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.acu.ao.a;
            }
            if (iA == 0) {
                throw null;
            }
            switch (iA - 1) {
                case 1:
                    xVar = com.google.android.libraries.navigation.internal.km.af.k;
                    break;
                case 2:
                    xVar = com.google.android.libraries.navigation.internal.km.af.i;
                    break;
                case 3:
                    xVar = com.google.android.libraries.navigation.internal.km.af.j;
                    break;
                case 4:
                    xVar = com.google.android.libraries.navigation.internal.km.af.p;
                    break;
                case 5:
                    xVar = com.google.android.libraries.navigation.internal.km.af.x;
                    break;
                case 6:
                    xVar = com.google.android.libraries.navigation.internal.km.af.v;
                    break;
                case 7:
                    xVar = com.google.android.libraries.navigation.internal.km.af.w;
                    break;
            }
            if (xVar != null) {
                ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(xVar)).b(amVar.c, amVar.d);
            }
        }
    }

    public static void d(com.google.android.libraries.navigation.internal.ia.e eVar, List list, cu cuVar, long j) {
        com.google.android.libraries.navigation.internal.gz.c cVar;
        int i;
        cl clVar = new cl((cn) cuVar.t());
        while (clVar.hasNext()) {
            if (clVar.next().a() < j) {
                clVar.remove();
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.acu.l lVar = (com.google.android.libraries.navigation.internal.acu.l) it2.next();
            if (!cuVar.containsKey(lVar.c)) {
                int iA = com.google.android.libraries.navigation.internal.acu.j.a(lVar.d);
                if (iA == 0) {
                    iA = com.google.android.libraries.navigation.internal.acu.j.a;
                }
                if (iA == 0) {
                    throw null;
                }
                int i2 = iA - 1;
                if (i2 == 1) {
                    cVar = com.google.android.libraries.navigation.internal.gz.c.DEV;
                } else if (i2 == 2) {
                    cVar = com.google.android.libraries.navigation.internal.gz.c.GOOGLERS;
                } else if (i2 != 3) {
                    com.google.android.libraries.navigation.internal.zb.h hVar = (com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
                    int iA2 = com.google.android.libraries.navigation.internal.acu.j.a(lVar.d);
                    if (iA2 == 0) {
                        iA2 = com.google.android.libraries.navigation.internal.acu.j.a;
                    }
                    int i3 = iA2 - 1;
                    if (iA2 == 0) {
                        throw null;
                    }
                    hVar.q("Debug toast raised with invalid audience %d", i3);
                    cVar = com.google.android.libraries.navigation.internal.gz.c.DEV;
                } else {
                    cVar = com.google.android.libraries.navigation.internal.gz.c.PARTNERS;
                }
                eVar.a(new com.google.android.libraries.navigation.internal.gz.d(lVar.c, cVar));
                if ((lVar.b & 4) != 0 && (i = lVar.e) > 0) {
                    cuVar.b(lVar.c, (((long) i) * 1000) + j);
                }
            }
        }
    }
}
