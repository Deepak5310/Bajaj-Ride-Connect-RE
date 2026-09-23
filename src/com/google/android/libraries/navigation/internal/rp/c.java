package com.google.android.libraries.navigation.internal.rp;

import com.google.android.libraries.navigation.internal.adf.m;
import com.google.android.libraries.navigation.internal.adf.n;
import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.ds;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ee;
import com.google.android.libraries.navigation.internal.adg.ei;
import com.google.android.libraries.navigation.internal.adl.ac;
import com.google.android.libraries.navigation.internal.adl.ad;
import com.google.android.libraries.navigation.internal.adl.al;
import com.google.android.libraries.navigation.internal.adl.k;
import com.google.android.libraries.navigation.internal.adl.v;
import com.google.android.libraries.navigation.internal.adl.x;
import com.google.android.libraries.navigation.internal.adl.y;
import com.google.android.libraries.navigation.internal.adl.z;
import com.google.android.libraries.navigation.internal.ado.j;
import com.google.android.libraries.navigation.internal.ael.bb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final ad a;

    static {
        ac acVar = (ac) ad.a.q();
        y yVar = (y) z.a.q();
        ee eeVar = ee.CENTER_RIGHT_TO_CENTER_LEFT;
        if (!yVar.b.H()) {
            yVar.v();
        }
        z zVar = (z) yVar.b;
        zVar.c = eeVar.q;
        zVar.b |= 1;
        ds dsVar = ds.RIGHT_JUSTIFY;
        if (!yVar.b.H()) {
            yVar.v();
        }
        z zVar2 = (z) yVar.b;
        zVar2.d = dsVar.d;
        zVar2.b |= 2;
        acVar.c(yVar);
        y yVar2 = (y) z.a.q();
        ee eeVar2 = ee.CENTER_LEFT_TO_CENTER_RIGHT;
        if (!yVar2.b.H()) {
            yVar2.v();
        }
        z zVar3 = (z) yVar2.b;
        zVar3.c = eeVar2.q;
        zVar3.b |= 1;
        ds dsVar2 = ds.LEFT_JUSTIFY;
        if (!yVar2.b.H()) {
            yVar2.v();
        }
        z zVar4 = (z) yVar2.b;
        zVar4.d = dsVar2.d;
        zVar4.b |= 2;
        acVar.c(yVar2);
        y yVar3 = (y) z.a.q();
        ee eeVar3 = ee.BOTTOM_RIGHT_TO_TOP_RIGHT;
        if (!yVar3.b.H()) {
            yVar3.v();
        }
        z zVar5 = (z) yVar3.b;
        zVar5.c = eeVar3.q;
        zVar5.b |= 1;
        ds dsVar3 = ds.RIGHT_JUSTIFY;
        if (!yVar3.b.H()) {
            yVar3.v();
        }
        z zVar6 = (z) yVar3.b;
        zVar6.d = dsVar3.d;
        zVar6.b |= 2;
        acVar.c(yVar3);
        y yVar4 = (y) z.a.q();
        ee eeVar4 = ee.BOTTOM_LEFT_TO_TOP_LEFT;
        if (!yVar4.b.H()) {
            yVar4.v();
        }
        z zVar7 = (z) yVar4.b;
        zVar7.c = eeVar4.q;
        zVar7.b |= 1;
        ds dsVar4 = ds.LEFT_JUSTIFY;
        if (!yVar4.b.H()) {
            yVar4.v();
        }
        z zVar8 = (z) yVar4.b;
        zVar8.d = dsVar4.d;
        zVar8.b |= 2;
        acVar.c(yVar4);
        a = (ad) acVar.t();
        ac acVar2 = (ac) ad.a.q();
        y yVar5 = (y) z.a.q();
        ee eeVar5 = ee.CENTER_LEFT_TO_CENTER_RIGHT;
        if (!yVar5.b.H()) {
            yVar5.v();
        }
        z zVar9 = (z) yVar5.b;
        zVar9.c = eeVar5.q;
        zVar9.b |= 1;
        ds dsVar5 = ds.LEFT_JUSTIFY;
        if (!yVar5.b.H()) {
            yVar5.v();
        }
        z zVar10 = (z) yVar5.b;
        zVar10.d = dsVar5.d;
        zVar10.b |= 2;
        acVar2.c(yVar5);
        y yVar6 = (y) z.a.q();
        ee eeVar6 = ee.CENTER_RIGHT_TO_CENTER_LEFT;
        if (!yVar6.b.H()) {
            yVar6.v();
        }
        z zVar11 = (z) yVar6.b;
        zVar11.c = eeVar6.q;
        zVar11.b |= 1;
        ds dsVar6 = ds.RIGHT_JUSTIFY;
        if (!yVar6.b.H()) {
            yVar6.v();
        }
        z zVar12 = (z) yVar6.b;
        zVar12.d = dsVar6.d;
        zVar12.b |= 2;
        acVar2.c(yVar6);
        y yVar7 = (y) z.a.q();
        ee eeVar7 = ee.BOTTOM_CENTER_TO_TOP_CENTER;
        if (!yVar7.b.H()) {
            yVar7.v();
        }
        z zVar13 = (z) yVar7.b;
        zVar13.c = eeVar7.q;
        zVar13.b |= 1;
        ds dsVar7 = ds.CENTER_JUSTIFY;
        if (!yVar7.b.H()) {
            yVar7.v();
        }
        z zVar14 = (z) yVar7.b;
        zVar14.d = dsVar7.d;
        zVar14.b |= 2;
        acVar2.c(yVar7);
        y yVar8 = (y) z.a.q();
        ee eeVar8 = ee.TOP_CENTER_TO_BOTTOM_CENTER;
        if (!yVar8.b.H()) {
            yVar8.v();
        }
        z zVar15 = (z) yVar8.b;
        zVar15.c = eeVar8.q;
        zVar15.b |= 1;
        ds dsVar8 = ds.CENTER_JUSTIFY;
        if (!yVar8.b.H()) {
            yVar8.v();
        }
        z zVar16 = (z) yVar8.b;
        zVar16.d = dsVar8.d;
        zVar16.b |= 2;
        acVar2.c(yVar8);
    }

    public static cx a(ei eiVar) {
        return (cx) eiVar.y(bj.V);
    }

    public static v b(dy dyVar) {
        x xVar = (x) dyVar.y(k.a);
        bb bbVar = (bb) xVar.aH(5, null);
        bbVar.x(xVar);
        return (v) bbVar;
    }

    public static String c(ei eiVar) {
        cx cxVarA = a(eiVar);
        if (!cxVarA.equals(bj.V.b) && (cxVarA.b & 512) != 0) {
            return cxVarA.i;
        }
        dt dtVarC = eiVar.c();
        String strI = dtVarC.c.size() > 0 ? i(dtVarC) : "";
        if (!eiVar.e()) {
            return strI;
        }
        dt dtVarD = eiVar.d();
        if (dtVarD.c.size() <= 0) {
            return strI;
        }
        String strI2 = i(dtVarD);
        if (strI.length() > 0 && strI2.length() > 0) {
            strI = String.valueOf(strI).concat("\n");
        }
        return String.valueOf(strI).concat(String.valueOf(strI2));
    }

    public static void d(dy dyVar, String str) {
        e(dyVar, str, new com.google.android.libraries.navigation.internal.hb.a() { // from class: com.google.android.libraries.navigation.internal.rp.a
            @Override // com.google.android.libraries.navigation.internal.hb.a
            public final void a(Object obj, Object obj2) {
                String str2 = (String) obj2;
                bb bbVar = (bb) obj;
                if (!bbVar.b.H()) {
                    bbVar.v();
                }
                n nVar = (n) ((m) obj).b;
                n nVar2 = n.a;
                str2.getClass();
                nVar.b |= 2;
                nVar.c = str2;
            }
        });
    }

    public static void e(dy dyVar, Object obj, com.google.android.libraries.navigation.internal.hb.a aVar) {
        n nVar = (n) dyVar.y(bj.N);
        bb bbVar = (bb) nVar.aH(5, null);
        bbVar.x(nVar);
        m mVar = (m) bbVar;
        aVar.a(mVar, obj);
        dyVar.C(bj.N, (n) mVar.t());
    }

    public static void f(dy dyVar, n nVar) {
        dyVar.C(bj.N, nVar);
    }

    public static void g(dy dyVar) {
        v vVarB = b(dyVar);
        al alVar = al.a;
        if (!vVarB.b.H()) {
            vVarB.v();
        }
        x xVar = (x) vVarB.b;
        x xVar2 = x.a;
        alVar.getClass();
        xVar.d = alVar;
        xVar.c = 2;
        dyVar.C(k.a, (x) vVarB.t());
    }

    public static void h(dy dyVar, j jVar) {
        dyVar.C(bj.M, jVar);
    }

    private static String i(dt dtVar) {
        StringBuilder sb = new StringBuilder();
        for (dp dpVar : dtVar.c) {
            if (dpVar.h) {
                sb.append('\n');
            }
            if ((dpVar.b & 1) != 0) {
                sb.append(dpVar.c);
            }
        }
        return sb.toString();
    }
}
