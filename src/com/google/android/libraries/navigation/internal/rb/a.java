package com.google.android.libraries.navigation.internal.rb;

import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.ds;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.ee;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.ei;
import com.google.android.libraries.navigation.internal.adl.ac;
import com.google.android.libraries.navigation.internal.adl.ad;
import com.google.android.libraries.navigation.internal.adl.k;
import com.google.android.libraries.navigation.internal.adl.x;
import com.google.android.libraries.navigation.internal.adl.y;
import com.google.android.libraries.navigation.internal.adl.z;
import com.google.android.libraries.navigation.internal.ado.f;
import com.google.android.libraries.navigation.internal.ado.q;
import com.google.android.libraries.navigation.internal.adq.r;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.oe.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

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
        y yVar5 = (y) z.a.q();
        ee eeVar5 = ee.TOP_RIGHT_TO_BOTTOM_RIGHT;
        if (!yVar5.b.H()) {
            yVar5.v();
        }
        z zVar9 = (z) yVar5.b;
        zVar9.c = eeVar5.q;
        zVar9.b |= 1;
        ds dsVar5 = ds.RIGHT_JUSTIFY;
        if (!yVar5.b.H()) {
            yVar5.v();
        }
        z zVar10 = (z) yVar5.b;
        zVar10.d = dsVar5.d;
        zVar10.b |= 2;
        acVar.c(yVar5);
        y yVar6 = (y) z.a.q();
        ee eeVar6 = ee.TOP_LEFT_TO_BOTTOM_LEFT;
        if (!yVar6.b.H()) {
            yVar6.v();
        }
        z zVar11 = (z) yVar6.b;
        zVar11.c = eeVar6.q;
        zVar11.b |= 1;
        ds dsVar6 = ds.LEFT_JUSTIFY;
        if (!yVar6.b.H()) {
            yVar6.v();
        }
        z zVar12 = (z) yVar6.b;
        zVar12.d = dsVar6.d;
        zVar12.b |= 2;
        acVar.c(yVar6);
    }

    public static long a(ef efVar) {
        if (efVar == null) {
            return 0L;
        }
        bh bhVarS = bi.s(bj.V);
        efVar.h(bhVarS);
        if (efVar.w.n(bhVarS.d)) {
            bh bhVarS2 = bi.s(bj.V);
            efVar.h(bhVarS2);
            Object objK = efVar.w.k(bhVarS2.d);
            return ((cx) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).g;
        }
        bh bhVarS3 = bi.s(bj.F);
        efVar.h(bhVarS3);
        Object objK2 = efVar.w.k(bhVarS3.d);
        r rVar = ((f) (objK2 == null ? bhVarS3.b : bhVarS3.c(objK2))).b;
        if (rVar == null) {
            rVar = r.a;
        }
        if ((rVar.b & 2) != 0) {
            return j.d(rVar.d).c;
        }
        return 0L;
    }

    public static com.google.android.libraries.navigation.internal.acw.j b(ef efVar) {
        bh bhVarS = bi.s(bj.W);
        efVar.h(bhVarS);
        if (!efVar.w.n(bhVarS.d)) {
            return null;
        }
        bh bhVarS2 = bi.s(bj.W);
        efVar.h(bhVarS2);
        Object objK = efVar.w.k(bhVarS2.d);
        return (com.google.android.libraries.navigation.internal.acw.j) (objK == null ? bhVarS2.b : bhVarS2.c(objK));
    }

    public static cx c(ei eiVar) {
        return (cx) eiVar.y(bj.V);
    }

    public static x d(ef efVar) {
        bh bhVarS = bi.s(k.a);
        efVar.h(bhVarS);
        Object objK = efVar.w.k(bhVarS.d);
        return (x) (objK == null ? bhVarS.b : bhVarS.c(objK));
    }

    public static com.google.android.libraries.navigation.internal.ado.j e(ef efVar) {
        bh bhVarS = bi.s(bj.M);
        efVar.h(bhVarS);
        if (!efVar.w.n(bhVarS.d)) {
            return null;
        }
        bh bhVarS2 = bi.s(bj.M);
        efVar.h(bhVarS2);
        Object objK = efVar.w.k(bhVarS2.d);
        return (com.google.android.libraries.navigation.internal.ado.j) (objK == null ? bhVarS2.b : bhVarS2.c(objK));
    }

    public static String f(dt dtVar) {
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

    public static String g(ef efVar) {
        if (efVar == null) {
            return "";
        }
        bh bhVarS = bi.s(bj.V);
        efVar.h(bhVarS);
        if (efVar.w.n(bhVarS.d)) {
            bh bhVarS2 = bi.s(bj.V);
            efVar.h(bhVarS2);
            Object objK = efVar.w.k(bhVarS2.d);
            com.google.android.libraries.navigation.internal.aeb.b bVar = ((cx) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).h;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.aeb.b.a;
            }
            com.google.android.libraries.navigation.internal.aav.b bVar2 = bVar.b;
            if (bVar2 == null) {
                bVar2 = com.google.android.libraries.navigation.internal.aav.b.a;
            }
            String str = bVar2.b;
            if (!str.isEmpty()) {
                return str;
            }
        }
        bh bhVarS3 = bi.s(bj.F);
        efVar.h(bhVarS3);
        Object objK2 = efVar.w.k(bhVarS3.d);
        r rVar = ((f) (objK2 == null ? bhVarS3.b : bhVarS3.c(objK2))).b;
        if (rVar == null) {
            rVar = r.a;
        }
        com.google.android.libraries.navigation.internal.aeb.b bVar3 = rVar.c;
        if (bVar3 == null) {
            bVar3 = com.google.android.libraries.navigation.internal.aeb.b.a;
        }
        com.google.android.libraries.navigation.internal.aav.b bVar4 = bVar3.b;
        if (bVar4 == null) {
            bVar4 = com.google.android.libraries.navigation.internal.aav.b.a;
        }
        String str2 = bVar4.b;
        return !str2.isEmpty() ? str2 : "";
    }

    public static boolean h(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean i(ef efVar) {
        cx cxVarC = c(efVar);
        if (!cxVarC.equals(bj.V.b) && cxVarC.k) {
            return true;
        }
        bh bhVarS = bi.s(bj.R);
        efVar.h(bhVarS);
        if (efVar.w.n(bhVarS.d)) {
            return true;
        }
        return d(efVar).e;
    }

    public static boolean j(ef efVar) {
        bh bhVarS = bi.s(bj.H);
        efVar.h(bhVarS);
        if (efVar.w.n(bhVarS.d)) {
            bh bhVarS2 = bi.s(bj.H);
            efVar.h(bhVarS2);
            Object objK = efVar.w.k(bhVarS2.d);
            com.google.android.libraries.navigation.internal.ado.r rVar = (com.google.android.libraries.navigation.internal.ado.r) (objK == null ? bhVarS2.b : bhVarS2.c(objK));
            if ((rVar.b & 1) != 0) {
                int iA = q.a(rVar.c);
                if (iA == 0) {
                    iA = q.a;
                }
                if (iA == q.a) {
                    return true;
                }
            }
        }
        return false;
    }
}
