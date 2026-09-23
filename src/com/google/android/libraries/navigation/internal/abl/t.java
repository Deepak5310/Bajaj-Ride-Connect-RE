package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Point;
import android.util.Base64;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.internal.abh.id;
import com.google.android.libraries.navigation.internal.adi.ag;
import com.google.android.libraries.navigation.internal.adi.aj;
import com.google.android.libraries.navigation.internal.adi.ao;
import com.google.android.libraries.navigation.internal.adi.ap;
import com.google.android.libraries.navigation.internal.adi.ba;
import com.google.android.libraries.navigation.internal.adi.bb;
import com.google.android.libraries.navigation.internal.adi.bc;
import com.google.android.libraries.navigation.internal.adi.bd;
import com.google.android.libraries.navigation.internal.adi.br;
import com.google.android.libraries.navigation.internal.adi.bs;
import com.google.android.libraries.navigation.internal.adi.bu;
import com.google.android.libraries.navigation.internal.adi.bv;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t {
    static int a(int i, double d) {
        return Math.min((int) Math.ceil(((double) i) / d), (int) Math.floor(2048.0d / d));
    }

    static int b(double d) {
        return (int) Math.round(d * 1.0E7d);
    }

    public static ao c(aj ajVar) {
        if ((ajVar.b & 2) == 0) {
            return (ao) ap.a.q();
        }
        ap apVar = ajVar.e;
        if (apVar == null) {
            apVar = ap.a;
        }
        return (ao) ap.a.r(apVar);
    }

    public static String d(aj ajVar, aa aaVar, int i, com.google.android.libraries.navigation.internal.abh.d dVar, String str, int i2, String str2, List list, id idVar) {
        ag agVar = (ag) aj.a.r(ajVar);
        if (!agVar.b.H()) {
            agVar.v();
        }
        ((aj) agVar.b).j = bj.a;
        if (!agVar.b.H()) {
            agVar.v();
        }
        aj ajVar2 = (aj) agVar.b;
        bq bqVar = ajVar2.j;
        if (!bqVar.c()) {
            ajVar2.j = bi.w(bqVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(list, ajVar2.j);
        ao aoVarC = c(ajVar);
        com.google.android.libraries.navigation.internal.adi.h hVar = ((aj) agVar.b).g;
        if (hVar == null) {
            hVar = com.google.android.libraries.navigation.internal.adi.h.a;
        }
        com.google.android.libraries.navigation.internal.adi.g gVar = (com.google.android.libraries.navigation.internal.adi.g) com.google.android.libraries.navigation.internal.adi.h.a.r(hVar);
        float f = (float) aaVar.h;
        float f2 = i2;
        if (!gVar.b.H()) {
            gVar.v();
        }
        float f3 = f / f2;
        com.google.android.libraries.navigation.internal.adi.h hVar2 = (com.google.android.libraries.navigation.internal.adi.h) gVar.b;
        hVar2.b |= 64;
        hVar2.c = f3;
        com.google.android.libraries.navigation.internal.adi.h hVar3 = (com.google.android.libraries.navigation.internal.adi.h) gVar.t();
        if (!agVar.b.H()) {
            agVar.v();
        }
        aj ajVar3 = (aj) agVar.b;
        hVar3.getClass();
        ajVar3.g = hVar3;
        ajVar3.b |= 16;
        f(agVar, aaVar, i2);
        if (dVar != null) {
            h(agVar, com.google.android.libraries.navigation.internal.adi.w.a);
            com.google.android.libraries.navigation.internal.adi.bq bqVar2 = (com.google.android.libraries.navigation.internal.adi.bq) bv.a.q();
            int i3 = bu.m;
            if (!bqVar2.b.H()) {
                bqVar2.v();
            }
            bv bvVar = (bv) bqVar2.b;
            if (i3 == 0) {
                throw null;
            }
            bvVar.c = i3;
            bvVar.b |= 1;
            br brVar = (br) bs.a.q();
            if (!brVar.b.H()) {
                brVar.v();
            }
            bs bsVar = (bs) brVar.b;
            bsVar.b |= 1;
            bsVar.c = "set";
            if (!brVar.b.H()) {
                brVar.v();
            }
            boolean z = dVar.a;
            bs bsVar2 = (bs) brVar.b;
            bsVar2.b |= 2;
            bsVar2.d = true != z ? "RoadmapAmbiactive" : "RoadmapAmbiactiveLowBit";
            bqVar2.d((bs) brVar.t());
            aoVarC.d((bv) bqVar2.t());
        } else {
            g(agVar, aoVarC, i);
            if (!com.google.android.libraries.navigation.internal.abf.x.a(str2) && i == 1) {
                com.google.android.libraries.navigation.internal.adi.bq bqVar3 = (com.google.android.libraries.navigation.internal.adi.bq) bv.a.q();
                int i4 = bu.d;
                if (!bqVar3.b.H()) {
                    bqVar3.v();
                }
                bv bvVar2 = (bv) bqVar3.b;
                if (i4 == 0) {
                    throw null;
                }
                bvVar2.c = i4;
                bvVar2.b |= 1;
                br brVar2 = (br) bs.a.q();
                if (!brVar2.b.H()) {
                    brVar2.v();
                }
                bs bsVar3 = (bs) brVar2.b;
                bsVar3.b = 1 | bsVar3.b;
                bsVar3.c = "styles";
                if (!brVar2.b.H()) {
                    brVar2.v();
                }
                bs bsVar4 = (bs) brVar2.b;
                str2.getClass();
                bsVar4.b |= 2;
                bsVar4.d = str2;
                bqVar3.d((bs) brVar2.t());
                aoVarC.d((bv) bqVar3.t());
            }
        }
        ap apVar = (ap) aoVarC.t();
        if (!agVar.b.H()) {
            agVar.v();
        }
        aj ajVar4 = (aj) agVar.b;
        apVar.getClass();
        ajVar4.e = apVar;
        ajVar4.b |= 2;
        return e((aj) agVar.t(), str);
    }

    public static String e(aj ajVar, String str) {
        return str + "bpb=" + Base64.encodeToString(ajVar.m(), 10);
    }

    public static void f(ag agVar, aa aaVar, int i) {
        int i2 = (int) aaVar.e.zoom;
        bc bcVar = (bc) bd.a.q();
        com.google.android.libraries.navigation.internal.adi.m mVar = (com.google.android.libraries.navigation.internal.adi.m) com.google.android.libraries.navigation.internal.adi.n.a.q();
        if (!mVar.b.H()) {
            mVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.n nVar = (com.google.android.libraries.navigation.internal.adi.n) mVar.b;
        nVar.b |= 1;
        nVar.c = i2;
        ba baVar = (ba) bb.a.q();
        double d = i;
        int iA = a(aaVar.f / i, aaVar.h / d);
        if (!baVar.b.H()) {
            baVar.v();
        }
        bb bbVar = (bb) baVar.b;
        bbVar.b |= 1;
        bbVar.c = iA;
        int iA2 = a(aaVar.g / i, aaVar.h / d);
        if (!baVar.b.H()) {
            baVar.v();
        }
        bb bbVar2 = (bb) baVar.b;
        bbVar2.b |= 2;
        bbVar2.d = iA2;
        bb bbVar3 = (bb) baVar.t();
        if (!mVar.b.H()) {
            mVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.n nVar2 = (com.google.android.libraries.navigation.internal.adi.n) mVar.b;
        bbVar3.getClass();
        nVar2.d = bbVar3;
        nVar2.b |= 8;
        com.google.android.libraries.navigation.internal.aax.c cVar = (com.google.android.libraries.navigation.internal.aax.c) com.google.android.libraries.navigation.internal.aax.d.a.q();
        LatLng latLngB = (aaVar.a == aaVar.c && aaVar.b == aaVar.d) ? aaVar.e.target : aaVar.b(new Point(aaVar.f / 2, aaVar.g / 2));
        int iB = b(latLngB.latitude);
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.aax.d dVar = (com.google.android.libraries.navigation.internal.aax.d) cVar.b;
        dVar.b |= 1;
        dVar.c = iB;
        int iB2 = b(latLngB.longitude);
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.aax.d dVar2 = (com.google.android.libraries.navigation.internal.aax.d) cVar.b;
        dVar2.b |= 2;
        dVar2.d = iB2;
        com.google.android.libraries.navigation.internal.aax.d dVar3 = (com.google.android.libraries.navigation.internal.aax.d) cVar.t();
        if (!mVar.b.H()) {
            mVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.n nVar3 = (com.google.android.libraries.navigation.internal.adi.n) mVar.b;
        dVar3.getClass();
        nVar3.e = dVar3;
        nVar3.b |= 16;
        com.google.android.libraries.navigation.internal.adi.n nVar4 = (com.google.android.libraries.navigation.internal.adi.n) mVar.t();
        if (!bcVar.b.H()) {
            bcVar.v();
        }
        bd bdVar = (bd) bcVar.b;
        nVar4.getClass();
        bdVar.d = nVar4;
        bdVar.b |= 16;
        agVar.e((bd) bcVar.t());
    }

    public static void g(ag agVar, ao aoVar, int i) {
        com.google.android.libraries.navigation.internal.abf.s.a(i != 0, "Shouldn't fetch for MAP_TYPE_NONE");
        if (i == 1) {
            com.google.android.libraries.navigation.internal.adi.bq bqVar = (com.google.android.libraries.navigation.internal.adi.bq) bv.a.q();
            int i2 = bu.a;
            if (!bqVar.b.H()) {
                bqVar.v();
            }
            bv bvVar = (bv) bqVar.b;
            if (i2 == 0) {
                throw null;
            }
            bvVar.c = i2;
            bvVar.b |= 1;
            br brVar = (br) bs.a.q();
            if (!brVar.b.H()) {
                brVar.v();
            }
            bs bsVar = (bs) brVar.b;
            bsVar.b = 1 | bsVar.b;
            bsVar.c = "smartmaps";
            bqVar.d((bs) brVar.t());
            aoVar.d((bv) bqVar.t());
        } else {
            if (i == 2) {
                h(agVar, com.google.android.libraries.navigation.internal.adi.w.b);
                return;
            }
            if (i == 3) {
                h(agVar, com.google.android.libraries.navigation.internal.adi.w.d);
                h(agVar, com.google.android.libraries.navigation.internal.adi.w.a);
                com.google.android.libraries.navigation.internal.adi.bq bqVar2 = (com.google.android.libraries.navigation.internal.adi.bq) bv.a.q();
                int i3 = bu.A;
                if (!bqVar2.b.H()) {
                    bqVar2.v();
                }
                bv bvVar2 = (bv) bqVar2.b;
                if (i3 == 0) {
                    throw null;
                }
                bvVar2.c = i3;
                bvVar2.b |= 1;
                aoVar.d((bv) bqVar2.t());
                return;
            }
            if (i == 4) {
                h(agVar, com.google.android.libraries.navigation.internal.adi.w.b);
                h(agVar, com.google.android.libraries.navigation.internal.adi.w.a);
                com.google.android.libraries.navigation.internal.adi.bq bqVar3 = (com.google.android.libraries.navigation.internal.adi.bq) bv.a.q();
                int i4 = bu.t;
                if (!bqVar3.b.H()) {
                    bqVar3.v();
                }
                bv bvVar3 = (bv) bqVar3.b;
                if (i4 == 0) {
                    throw null;
                }
                bvVar3.c = i4;
                bvVar3.b |= 1;
                aoVar.d((bv) bqVar3.t());
                return;
            }
        }
        h(agVar, com.google.android.libraries.navigation.internal.adi.w.a);
    }

    private static void h(ag agVar, int i) {
        com.google.android.libraries.navigation.internal.adi.u uVar = (com.google.android.libraries.navigation.internal.adi.u) com.google.android.libraries.navigation.internal.adi.x.a.q();
        if (!uVar.b.H()) {
            uVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.x xVar = (com.google.android.libraries.navigation.internal.adi.x) uVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        xVar.c = i2;
        xVar.b |= 1;
        if (!uVar.b.H()) {
            uVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.x xVar2 = (com.google.android.libraries.navigation.internal.adi.x) uVar.b;
        xVar2.b |= 4;
        xVar2.e = 999999;
        agVar.d((com.google.android.libraries.navigation.internal.adi.x) uVar.t());
    }
}
