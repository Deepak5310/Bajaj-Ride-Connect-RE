package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.ace.fh;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.hy;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.io;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg {
    public int a = -1;
    public List b;
    public final Map c;
    public final com.google.android.libraries.navigation.internal.fz.d d;
    public final com.google.android.libraries.navigation.internal.bp.bg e;
    public com.google.android.libraries.navigation.internal.bp.bj f;
    public boolean g;
    public boolean h;
    public final List i;

    public bg(com.google.android.libraries.navigation.internal.bp.bg bgVar, com.google.android.libraries.navigation.internal.fz.d dVar) {
        int i = ev.d;
        this.b = lv.a;
        this.c = new HashMap();
        this.g = false;
        this.h = false;
        this.i = new ArrayList();
        this.e = bgVar;
        this.f = new com.google.android.libraries.navigation.internal.bp.ag(bgVar);
        this.d = dVar;
    }

    public static float a(List list) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        be beVar = (be) gs.d(list);
        return beVar.k + beVar.f367n;
    }

    public static int b(com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        return Integer.MAX_VALUE - ((int) (bgVar.j != com.google.android.libraries.navigation.internal.ady.al.TRANSIT ? bgVar.H.c() : bgVar.I()).toSeconds());
    }

    public static bf c(com.google.android.libraries.navigation.internal.bp.bq bqVar, int i, boolean z) {
        boolean z2;
        int iA;
        int i2 = ev.d;
        eq eqVar = new eq();
        com.google.android.libraries.navigation.internal.bp.bt btVar = bqVar.b;
        if (btVar != null) {
            int i3 = cx.a;
            z2 = i == -1 || btVar.b == 0;
            iA = btVar.j() ? com.google.android.libraries.navigation.internal.gz.b.a(btVar.h().e, 0) : 0;
            hy hyVar = btVar.a.g;
            if (hyVar == null) {
                hyVar = hy.a;
            }
            ii iiVar = hyVar.b;
            if (iiVar == null) {
                iiVar = ii.a;
            }
            io ioVar = iiVar.j;
            if (ioVar == null) {
                ioVar = io.a;
            }
            if (ioVar.b.size() > 0) {
                eqVar.j(ioVar.b);
            }
        } else {
            z2 = true;
            iA = 0;
        }
        return (z && bqVar.J) ? new d(new bi(bqVar.k, iA, z2), f(bqVar), eqVar.g(), true) : new d(new bi(bqVar.k, iA, z2), f(bqVar), eqVar.g(), false);
    }

    public static ev d(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2) {
        com.google.android.libraries.navigation.internal.oe.x xVar3 = xVar;
        int i = xVar3.a;
        int i2 = xVar2.a;
        com.google.android.libraries.navigation.internal.oe.x xVar4 = i > i2 ? xVar2 : xVar3;
        double d = xVar4.a;
        if (i <= i2) {
            xVar3 = xVar2;
        }
        double d2 = xVar3.a;
        double d3 = xVar4.b;
        double d4 = xVar3.b;
        if (d == d2 && d3 == d4) {
            int i3 = ev.d;
            return lv.a;
        }
        double dHypot = Math.hypot(d - d2, d3 - d4);
        double d5 = (d2 - d) / dHypot;
        double dSqrt = (Math.sqrt(3.0d) * dHypot) / 4.0d;
        com.google.android.libraries.navigation.internal.oe.x xVar5 = new com.google.android.libraries.navigation.internal.oe.x((int) Math.round(((d + d2) / 2.0d) + ((-((d4 - d3) / dHypot)) * dSqrt)), (int) Math.round(((d3 + d4) / 2.0d) + (d5 * dSqrt)));
        ArrayList arrayList = new ArrayList(11);
        arrayList.add(xVar4);
        for (int i4 = 1; i4 < 10; i4++) {
            com.google.android.libraries.navigation.internal.oe.x xVar6 = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
            if (com.google.android.libraries.navigation.internal.oe.ah.a(xVar4.a, xVar4.b, xVar5.a, xVar5.b, xVar3.a, xVar3.b, (((double) i4) / 10.0d) * dHypot, xVar6) > 0.0d) {
                xVar6.W(xVar3);
            }
            arrayList.add(xVar6);
        }
        arrayList.add(xVar3);
        if (i > i2) {
            Collections.reverse(arrayList);
        }
        return ev.o(arrayList);
    }

    public static boolean e(boolean z, fh fhVar) {
        return (z || fhVar == null || !fhVar.l) ? false : true;
    }

    private static com.google.android.libraries.navigation.internal.ady.al f(com.google.android.libraries.navigation.internal.bp.bq bqVar) {
        Cif cifG;
        Cif cif = bqVar.a;
        if (cif != null) {
            com.google.android.libraries.navigation.internal.ady.al alVarB = com.google.android.libraries.navigation.internal.ady.al.b(cif.c);
            return alVarB == null ? com.google.android.libraries.navigation.internal.ady.al.DRIVE : alVarB;
        }
        com.google.android.libraries.navigation.internal.bp.bt btVar = bqVar.b;
        if (btVar == null || (cifG = btVar.g()) == null) {
            return com.google.android.libraries.navigation.internal.ady.al.WALK;
        }
        if ((cifG.b & 1) == 0) {
            return com.google.android.libraries.navigation.internal.ady.al.WALK;
        }
        com.google.android.libraries.navigation.internal.ady.al alVarB2 = com.google.android.libraries.navigation.internal.ady.al.b(cifG.c);
        return alVarB2 == null ? com.google.android.libraries.navigation.internal.ady.al.DRIVE : alVarB2;
    }
}
