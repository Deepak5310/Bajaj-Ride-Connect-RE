package com.google.android.libraries.navigation.internal.we;

import com.google.android.libraries.navigation.internal.add.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.bp.bq;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj implements ai {
    private final al a;
    private final com.google.android.libraries.navigation.internal.kl.b b;

    public aj(com.google.android.libraries.navigation.internal.kl.b bVar, al alVar) {
        this.b = bVar;
        this.a = alVar;
    }

    /* JADX WARN: Code duplicated, block: B:154:0x03e2  */
    @Override // com.google.android.libraries.navigation.internal.we.ai
    public final com.google.android.libraries.navigation.internal.add.ag a(int i, String str, com.google.android.libraries.navigation.internal.tj.j jVar, Map map, boolean z, com.google.android.libraries.navigation.internal.add.c cVar, List list) {
        com.google.android.libraries.navigation.internal.ael.am amVarA;
        int i2;
        com.google.android.libraries.navigation.internal.ael.am amVarA2;
        long j;
        long j2;
        com.google.android.libraries.navigation.internal.add.af afVar = (com.google.android.libraries.navigation.internal.add.af) com.google.android.libraries.navigation.internal.add.ag.a.q();
        com.google.android.libraries.navigation.internal.add.aa aaVar = (com.google.android.libraries.navigation.internal.add.aa) com.google.android.libraries.navigation.internal.add.ac.a.q();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.ac) aaVar.b).c = com.google.android.libraries.navigation.internal.add.ab.b(i);
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.ac) aaVar.b).b = "";
        if (!afVar.b.H()) {
            afVar.v();
        }
        com.google.android.libraries.navigation.internal.add.ag agVar = (com.google.android.libraries.navigation.internal.add.ag) afVar.b;
        com.google.android.libraries.navigation.internal.add.ac acVar = (com.google.android.libraries.navigation.internal.add.ac) aaVar.t();
        acVar.getClass();
        agVar.c = acVar;
        agVar.b |= 1;
        if (i != com.google.android.libraries.navigation.internal.add.ab.d) {
            return (com.google.android.libraries.navigation.internal.add.ag) afVar.t();
        }
        if (map == null) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(com.google.android.libraries.navigation.internal.km.ak.h)).a();
            throw new IllegalArgumentException("uuidToGuidanceRouteMap should not be null.");
        }
        if (str == null) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(com.google.android.libraries.navigation.internal.km.ak.h)).a();
            throw new IllegalArgumentException("routeSetId should not be null.");
        }
        com.google.android.libraries.navigation.internal.kl.b bVar = this.b;
        com.google.android.libraries.navigation.internal.se.b bVarC = jVar.c();
        com.google.android.libraries.navigation.internal.add.ax axVar = (com.google.android.libraries.navigation.internal.add.ax) com.google.android.libraries.navigation.internal.add.ay.a.q();
        int iB = com.google.android.libraries.navigation.internal.add.l.b(bVarC.b.T.e);
        if (iB == 0) {
            iB = com.google.android.libraries.navigation.internal.add.l.a;
        }
        Duration durationC = bVarC.l.c();
        try {
            amVarA = com.google.android.libraries.navigation.internal.aen.b.a(durationC);
        } catch (IllegalArgumentException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.MEDIUM)).F(1972)).s("Could not translate duration %s to proto duration.", durationC);
            amVarA = com.google.android.libraries.navigation.internal.aen.a.a;
        }
        boolean z2 = !bVarC.m;
        if (!axVar.b.H()) {
            axVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.ay) axVar.b).c = z2;
        if (!axVar.b.H()) {
            axVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.ay) axVar.b).i = com.google.android.libraries.navigation.internal.add.l.a(iB);
        int i3 = bVarC.k;
        if (i3 != -1) {
            int iMax = Math.max(0, i3);
            if (!axVar.b.H()) {
                axVar.v();
            }
            com.google.android.libraries.navigation.internal.add.ay ayVar = (com.google.android.libraries.navigation.internal.add.ay) axVar.b;
            ayVar.b |= 8;
            ayVar.g = iMax;
        }
        long j3 = amVarA.b;
        long j4 = -1;
        long j5 = 0;
        if (j3 != -1) {
            if (j3 < 0) {
                amVarA = com.google.android.libraries.navigation.internal.aen.a.a;
            }
            if (!axVar.b.H()) {
                axVar.v();
            }
            com.google.android.libraries.navigation.internal.add.ay ayVar2 = (com.google.android.libraries.navigation.internal.add.ay) axVar.b;
            amVarA.getClass();
            ayVar2.h = amVarA;
            ayVar2.b |= 16;
        }
        bq bqVar = bVarC.c;
        if (bqVar != null) {
            if (!axVar.b.H()) {
                axVar.v();
            }
            com.google.android.libraries.navigation.internal.add.ay ayVar3 = (com.google.android.libraries.navigation.internal.add.ay) axVar.b;
            ayVar3.b |= 1;
            ayVar3.d = bqVar.i;
            int i4 = bVarC.g;
            if (i4 != -1) {
                com.google.android.libraries.navigation.internal.ael.am amVarB = com.google.android.libraries.navigation.internal.aen.a.b(Math.max(0L, i4), 0);
                if (!axVar.b.H()) {
                    axVar.v();
                }
                com.google.android.libraries.navigation.internal.add.ay ayVar4 = (com.google.android.libraries.navigation.internal.add.ay) axVar.b;
                amVarB.getClass();
                ayVar4.f = amVarB;
                ayVar4.b |= 4;
            }
            int i5 = bVarC.f;
            if (i5 != -1) {
                int iMax2 = Math.max(0, i5);
                if (!axVar.b.H()) {
                    axVar.v();
                }
                com.google.android.libraries.navigation.internal.add.ay ayVar5 = (com.google.android.libraries.navigation.internal.add.ay) axVar.b;
                ayVar5.b |= 2;
                ayVar5.e = iMax2;
            }
        }
        com.google.android.libraries.navigation.internal.add.ay ayVar6 = (com.google.android.libraries.navigation.internal.add.ay) axVar.t();
        ArrayList arrayList = new ArrayList();
        com.google.android.libraries.navigation.internal.se.b[] bVarArrG = jVar.g();
        int i6 = 0;
        while (i6 < bVarArrG.length) {
            if (i6 == jVar.b().a()) {
                j2 = j5;
                j = j4;
                bVarArrG = bVarArrG;
            } else {
                com.google.android.libraries.navigation.internal.se.b bVar2 = bVarArrG[i6];
                String str2 = bVar2.b.Z;
                if (((com.google.android.libraries.navigation.internal.add.x) map.get(str2)) == null) {
                    ((com.google.android.libraries.navigation.internal.kk.j) bVar.a(com.google.android.libraries.navigation.internal.km.ak.f466n)).a();
                    throw new IllegalArgumentException("No alternate route found for route id: ".concat(String.valueOf(str2)));
                }
                Duration durationC2 = bVar2.l.c();
                try {
                    amVarA2 = com.google.android.libraries.navigation.internal.aen.b.a(durationC2);
                } catch (IllegalArgumentException unused2) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.MEDIUM)).F(1964)).s("Could not translate duration %s to proto duration.", durationC2);
                    amVarA2 = com.google.android.libraries.navigation.internal.aen.a.a;
                }
                com.google.android.libraries.navigation.internal.add.e eVar = (com.google.android.libraries.navigation.internal.add.e) com.google.android.libraries.navigation.internal.add.f.a.q();
                if (!eVar.b.H()) {
                    eVar.v();
                }
                com.google.android.libraries.navigation.internal.add.f fVar = (com.google.android.libraries.navigation.internal.add.f) eVar.b;
                str2.getClass();
                fVar.c = str2;
                boolean z3 = !bVar2.m;
                if (!eVar.b.H()) {
                    eVar.v();
                }
                ((com.google.android.libraries.navigation.internal.add.f) eVar.b).d = z3;
                int i7 = bVar2.k;
                if (i7 != -1) {
                    int iMax3 = Math.max(0, i7);
                    if (!eVar.b.H()) {
                        eVar.v();
                    }
                    com.google.android.libraries.navigation.internal.add.f fVar2 = (com.google.android.libraries.navigation.internal.add.f) eVar.b;
                    fVar2.b |= 1;
                    fVar2.e = iMax3;
                }
                long j6 = amVarA2.b;
                j = -1;
                j2 = 0;
                if (j6 != -1) {
                    if (j6 < 0) {
                        amVarA2 = com.google.android.libraries.navigation.internal.aen.a.a;
                    }
                    if (!eVar.b.H()) {
                        eVar.v();
                    }
                    com.google.android.libraries.navigation.internal.add.f fVar3 = (com.google.android.libraries.navigation.internal.add.f) eVar.b;
                    amVarA2.getClass();
                    fVar3.f = amVarA2;
                    fVar3.b |= 2;
                }
                arrayList.add((com.google.android.libraries.navigation.internal.add.f) eVar.t());
            }
            i6++;
            bVarArrG = bVarArrG;
            j5 = j2;
            j4 = j;
        }
        com.google.android.libraries.navigation.internal.add.a aVar = (com.google.android.libraries.navigation.internal.add.a) com.google.android.libraries.navigation.internal.add.d.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.add.d dVar = (com.google.android.libraries.navigation.internal.add.d) aVar.b;
        ayVar6.getClass();
        dVar.c = ayVar6;
        dVar.b |= 1;
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.add.d dVar2 = (com.google.android.libraries.navigation.internal.add.d) aVar.b;
        bz bzVar = dVar2.d;
        if (!bzVar.c()) {
            dVar2.d = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(arrayList, dVar2.d);
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.add.d dVar3 = (com.google.android.libraries.navigation.internal.add.d) aVar.b;
        bz bzVar2 = dVar3.g;
        if (!bzVar2.c()) {
            dVar3.g = bi.A(bzVar2);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(list, dVar3.g);
        boolean z4 = bVarC.o;
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.d) aVar.b).h = z4;
        Object obj = bVarC.b.Z;
        if (map.containsKey(obj)) {
            com.google.android.libraries.navigation.internal.add.x xVar = (com.google.android.libraries.navigation.internal.add.x) map.get(obj);
            bq bqVar2 = bVarC.c;
            if (xVar == null || xVar.d.size() <= 0 || bqVar2 == null) {
                i2 = 0;
            } else {
                bh bhVar = (bh) xVar.d.get(bqVar2.i);
                int i8 = bVarC.f;
                boolean z5 = bVarC.d;
                com.google.android.libraries.navigation.internal.add.u uVar = (com.google.android.libraries.navigation.internal.add.u) com.google.android.libraries.navigation.internal.add.v.a.q();
                i2 = 0;
                int iMax4 = Math.max(0, i8);
                if (!uVar.b.H()) {
                    uVar.v();
                }
                ((com.google.android.libraries.navigation.internal.add.v) uVar.b).c = iMax4;
                bz bzVar3 = bhVar.f;
                if (!uVar.b.H()) {
                    uVar.v();
                }
                com.google.android.libraries.navigation.internal.add.v vVar = (com.google.android.libraries.navigation.internal.add.v) uVar.b;
                bz bzVar4 = vVar.e;
                if (!bzVar4.c()) {
                    vVar.e = bi.A(bzVar4);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(bzVar3, vVar.e);
                com.google.android.libraries.navigation.internal.add.aq aqVar = bhVar.g;
                if (aqVar == null) {
                    aqVar = com.google.android.libraries.navigation.internal.add.aq.a;
                }
                if (!uVar.b.H()) {
                    uVar.v();
                }
                com.google.android.libraries.navigation.internal.add.v vVar2 = (com.google.android.libraries.navigation.internal.add.v) uVar.b;
                aqVar.getClass();
                vVar2.f = aqVar;
                vVar2.b |= 2;
                if (z5 && (bhVar.b & 1) != 0) {
                    com.google.android.libraries.navigation.internal.add.an anVar = bhVar.e;
                    if (anVar == null) {
                        anVar = com.google.android.libraries.navigation.internal.add.an.a;
                    }
                    if (!uVar.b.H()) {
                        uVar.v();
                    }
                    com.google.android.libraries.navigation.internal.add.v vVar3 = (com.google.android.libraries.navigation.internal.add.v) uVar.b;
                    anVar.getClass();
                    vVar3.d = anVar;
                    vVar3.b |= 1;
                }
                com.google.android.libraries.navigation.internal.add.v vVar4 = (com.google.android.libraries.navigation.internal.add.v) uVar.t();
                if (!aVar.b.H()) {
                    aVar.v();
                }
                com.google.android.libraries.navigation.internal.add.d dVar4 = (com.google.android.libraries.navigation.internal.add.d) aVar.b;
                vVar4.getClass();
                dVar4.e = vVar4;
                dVar4.b |= 2;
            }
        } else {
            i2 = 0;
        }
        if (cVar != null) {
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.add.d dVar5 = (com.google.android.libraries.navigation.internal.add.d) aVar.b;
            dVar5.f = cVar;
            dVar5.b |= 4;
        }
        com.google.android.libraries.navigation.internal.add.d dVar6 = (com.google.android.libraries.navigation.internal.add.d) aVar.t();
        com.google.android.libraries.navigation.internal.add.ad adVar = (com.google.android.libraries.navigation.internal.add.ad) com.google.android.libraries.navigation.internal.add.ae.a.q();
        if (!adVar.b.H()) {
            adVar.v();
        }
        com.google.android.libraries.navigation.internal.add.ae aeVar = (com.google.android.libraries.navigation.internal.add.ae) adVar.b;
        dVar6.getClass();
        aeVar.d = dVar6;
        aeVar.b |= 2;
        com.google.android.libraries.navigation.internal.bp.bh bhVarB = jVar.b();
        com.google.android.libraries.navigation.internal.add.y yVar = (com.google.android.libraries.navigation.internal.add.y) com.google.android.libraries.navigation.internal.add.z.a.q();
        if (!yVar.b.H()) {
            yVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.z) yVar.b).c = str;
        int iA = bhVarB.a();
        int iD = bhVarB.d();
        for (int i9 = i2; i9 < iD; i9++) {
            Object obj2 = bhVarB.e(i9).Z;
            com.google.android.libraries.navigation.internal.add.x xVar2 = (com.google.android.libraries.navigation.internal.add.x) map.get(obj2);
            if (xVar2 == null) {
                ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(com.google.android.libraries.navigation.internal.km.ak.i)).a();
                throw new IllegalArgumentException("GuidanceRoute does not exist for routeUuid: ".concat(String.valueOf(obj2)));
            }
            if (i9 == iA) {
                if (!yVar.b.H()) {
                    yVar.v();
                }
                com.google.android.libraries.navigation.internal.add.z zVar = (com.google.android.libraries.navigation.internal.add.z) yVar.b;
                zVar.d = xVar2;
                zVar.b |= 1;
            } else {
                if (!yVar.b.H()) {
                    yVar.v();
                }
                com.google.android.libraries.navigation.internal.add.z zVar2 = (com.google.android.libraries.navigation.internal.add.z) yVar.b;
                bz bzVar5 = zVar2.e;
                if (!bzVar5.c()) {
                    zVar2.e = bi.A(bzVar5);
                }
                zVar2.e.add(xVar2);
            }
        }
        com.google.android.libraries.navigation.internal.add.z zVar3 = (com.google.android.libraries.navigation.internal.add.z) yVar.t();
        if (!adVar.b.H()) {
            adVar.v();
        }
        com.google.android.libraries.navigation.internal.add.ae aeVar2 = (com.google.android.libraries.navigation.internal.add.ae) adVar.b;
        zVar3.getClass();
        aeVar2.c = zVar3;
        aeVar2.b |= 1;
        com.google.android.libraries.navigation.internal.bp.bh bhVarB2 = jVar.b();
        com.google.android.libraries.navigation.internal.db.r rVar = jVar.a;
        if (rVar != null) {
            al alVar = this.a;
            com.google.android.libraries.navigation.internal.bp.bg bgVarF = bhVarB2.f();
            com.google.android.libraries.navigation.internal.yx.ar.q(bgVarF);
            com.google.android.libraries.navigation.internal.add.as asVarA = alVar.a(bgVarF, rVar);
            if (asVarA != null) {
                if (!adVar.b.H()) {
                    adVar.v();
                }
                com.google.android.libraries.navigation.internal.add.ae aeVar3 = (com.google.android.libraries.navigation.internal.add.ae) adVar.b;
                aeVar3.e = asVarA;
                aeVar3.b |= 4;
            }
        }
        if (!afVar.b.H()) {
            afVar.v();
        }
        com.google.android.libraries.navigation.internal.add.ag agVar2 = (com.google.android.libraries.navigation.internal.add.ag) afVar.b;
        com.google.android.libraries.navigation.internal.add.ae aeVar4 = (com.google.android.libraries.navigation.internal.add.ae) adVar.t();
        aeVar4.getClass();
        agVar2.d = aeVar4;
        agVar2.b |= 2;
        return (com.google.android.libraries.navigation.internal.add.ag) afVar.t();
    }
}
