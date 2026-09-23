package com.google.android.libraries.navigation.internal.bq;

import com.google.android.libraries.navigation.internal.adq.z;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.ah;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.eq;
import com.google.android.libraries.navigation.internal.adr.ft;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.nx;
import com.google.android.libraries.navigation.internal.afl.nz;
import com.google.android.libraries.navigation.internal.afl.oa;
import com.google.android.libraries.navigation.internal.agg.de;
import com.google.android.libraries.navigation.internal.agg.es;
import com.google.android.libraries.navigation.internal.bp.av;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bj;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zy.p;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final bg a;
    public final bj b;
    public final boolean c;
    public final Integer d;
    public final Integer e;
    public final List f;
    public final es g;
    public final ev h;
    public List i;

    /* JADX WARN: Code duplicated, block: B:112:0x02de  */
    /* JADX WARN: Code duplicated, block: B:120:0x02e1 A[SYNTHETIC] */
    public b(bg bgVar, bj bjVar, com.google.android.libraries.navigation.internal.bn.e eVar, ii iiVar, com.google.android.libraries.navigation.internal.bn.d dVar, com.google.android.libraries.navigation.internal.ci.a aVar, Integer num, Integer num2) {
        ev evVarO;
        b bVar = this;
        bVar.i = new ArrayList();
        ar.r(bgVar, PlaceTypes.ROUTE);
        bVar.a = bgVar;
        bVar.c = eVar.e;
        bVar.b = bjVar;
        bVar.d = num;
        bVar.e = num2;
        al alVar = bgVar.j;
        bVar.f = bgVar.N();
        de deVar = new de(bgVar.m());
        boolean z = false;
        deVar.c(0);
        for (bq bqVar : bgVar.aa()) {
            deVar.c(bqVar.k);
        }
        bVar.g = deVar;
        if ((bgVar.j == al.TRANSIT || bgVar.j == al.BIKESHARING) && bgVar.j() != 0) {
            ArrayList arrayList = new ArrayList(bgVar.g.b());
            de deVar2 = new de();
            arrayList.add(deVar2);
            av[] avVarArr = bgVar.g.b;
            int length = avVarArr.length;
            int i = 0;
            boolean z2 = true;
            while (i < length) {
                av avVar = avVarArr[i];
                int iA = avVar.a();
                if (!z2) {
                    deVar2.c(avVar.b(0).b(0, 0, -12345).k);
                    deVar2 = new de(iA);
                    arrayList.add(deVar2);
                }
                for (int i2 = 1; i2 < iA; i2++) {
                    deVar2.c(avVar.b(i2).b(0, 0, -12345).k);
                }
                i++;
                z2 = false;
            }
            deVar2.c(bgVar.m.e() - 1);
            evVarO = ev.o(arrayList);
        } else {
            int i3 = ev.d;
            evVarO = lv.a;
        }
        bVar.h = evVarO;
        switch (alVar) {
            case DRIVE:
            case TWO_WHEELER:
            case TAXI:
            case TAXICAB:
                ArrayList arrayList2 = new ArrayList();
                if (iiVar != null) {
                    for (Iterator it2 = iiVar.f.iterator(); it2.hasNext(); it2 = it2) {
                        el elVar = (el) it2.next();
                        oa oaVar = null;
                        if (dVar == 0) {
                            ((h) c.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('R')).p("iconManager is empty.");
                        } else {
                            int i4 = elVar.b;
                            if ((i4 & 16384) == 0 || (65536 & i4) == 0 || (i4 & 131072) == 0) {
                                ((h) c.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('Q')).p("Traffic incident notice missing ID or icon, ignoring.");
                            } else {
                                long jB = p.b(elVar.t);
                                com.google.android.libraries.navigation.internal.bn.a aVar2 = com.google.android.libraries.navigation.internal.bn.a.INCIDENT_LIGHT;
                                ah ahVar = elVar.v;
                                String strE = dVar.e((ahVar == null ? ah.a : ahVar).d, aVar2, z);
                                ah ahVar2 = elVar.w;
                                String strE2 = dVar.e((ahVar2 == null ? ah.a : ahVar2).d, aVar2, z);
                                if (strE != null && strE2 != null) {
                                    Cdo cdoB = Cdo.b(elVar.u);
                                    cdoB = cdoB == null ? Cdo.INCIDENT_OTHER : cdoB;
                                    z zVar = elVar.r;
                                    r rVarA = r.a(zVar == null ? z.a : zVar);
                                    z zVar2 = elVar.s;
                                    r rVarA2 = r.a(zVar2 == null ? z.a : zVar2);
                                    int i5 = (elVar.c == 18 ? (eq) elVar.d : eq.a).c;
                                    int i6 = (elVar.c == 18 ? (eq) elVar.d : eq.a).d;
                                    String str = elVar.h;
                                    String str2 = elVar.j;
                                    ft ftVar = elVar.y;
                                    ftVar = ftVar == null ? ft.a : ftVar;
                                    EnumMap enumMap = com.google.android.libraries.navigation.internal.tt.e.a;
                                    ar.q(cdoB);
                                    com.google.android.libraries.navigation.internal.afm.z zVarD = rVarA.d();
                                    com.google.android.libraries.navigation.internal.afm.z zVarD2 = rVarA2.d();
                                    nz nzVar = (nz) com.google.android.libraries.navigation.internal.tt.e.c.get(cdoB);
                                    nzVar = nzVar == null ? nz.INCIDENT_OTHER : nzVar;
                                    nx nxVar = (nx) oa.a.q();
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar2 = (oa) nxVar.b;
                                    oaVar2.b |= 1;
                                    oaVar2.c = jB;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar3 = (oa) nxVar.b;
                                    oaVar3.d = nzVar.C;
                                    oaVar3.b |= 2;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar4 = (oa) nxVar.b;
                                    zVarD.getClass();
                                    oaVar4.e = zVarD;
                                    oaVar4.b |= 4;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar5 = (oa) nxVar.b;
                                    zVarD2.getClass();
                                    oaVar5.f = zVarD2;
                                    oaVar5.b |= 8;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar6 = (oa) nxVar.b;
                                    oaVar6.b |= 16;
                                    oaVar6.g = i5;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar7 = (oa) nxVar.b;
                                    oaVar7.b |= 32;
                                    oaVar7.h = i6;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar8 = (oa) nxVar.b;
                                    oaVar8.b |= 512;
                                    oaVar8.l = strE;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar9 = (oa) nxVar.b;
                                    oaVar9.b |= 1024;
                                    oaVar9.m = strE2;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar10 = (oa) nxVar.b;
                                    str2.getClass();
                                    oaVar10.b |= 64;
                                    oaVar10.i = str2;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar11 = (oa) nxVar.b;
                                    str.getClass();
                                    oaVar11.b |= 2048;
                                    oaVar11.f323n = str;
                                    if (!nxVar.b.H()) {
                                        nxVar.v();
                                    }
                                    oa oaVar12 = (oa) nxVar.b;
                                    ftVar.getClass();
                                    oaVar12.p = ftVar;
                                    oaVar12.b |= 8192;
                                    oaVar = (oa) nxVar.t();
                                }
                            }
                            if (oaVar != null) {
                                arrayList2.add(oaVar);
                            }
                            z = false;
                        }
                        if (oaVar != null) {
                            arrayList2.add(oaVar);
                        }
                        z = false;
                    }
                    bVar = this;
                }
                bVar.i = arrayList2;
                return;
            case BICYCLE:
            case WALK:
            case TRANSIT:
            case FLY:
            case BIKESHARING:
                return;
            case MIXED:
            default:
                throw new UnsupportedOperationException("Unsupported travel mode: ".concat(String.valueOf(String.valueOf(alVar))));
        }
    }
}
