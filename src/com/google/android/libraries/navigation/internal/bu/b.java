package com.google.android.libraries.navigation.internal.bu;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.libraries.navigation.internal.aap.f;
import com.google.android.libraries.navigation.internal.aap.i;
import com.google.android.libraries.navigation.internal.aap.j;
import com.google.android.libraries.navigation.internal.aap.u;
import com.google.android.libraries.navigation.internal.aap.v;
import com.google.android.libraries.navigation.internal.adr.bt;
import com.google.android.libraries.navigation.internal.adr.bw;
import com.google.android.libraries.navigation.internal.adr.by;
import com.google.android.libraries.navigation.internal.adr.gb;
import com.google.android.libraries.navigation.internal.adr.gc;
import com.google.android.libraries.navigation.internal.adr.gf;
import com.google.android.libraries.navigation.internal.adr.gg;
import com.google.android.libraries.navigation.internal.adr.ip;
import com.google.android.libraries.navigation.internal.adr.it;
import com.google.android.libraries.navigation.internal.adr.iu;
import com.google.android.libraries.navigation.internal.adr.ju;
import com.google.android.libraries.navigation.internal.adr.jw;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.adr.kv;
import com.google.android.libraries.navigation.internal.adr.kw;
import com.google.android.libraries.navigation.internal.adr.lb;
import com.google.android.libraries.navigation.internal.adr.lc;
import com.google.android.libraries.navigation.internal.ady.ai;
import com.google.android.libraries.navigation.internal.ady.aj;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ady.n;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afl.lo;
import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public x a;
    public n b;
    public EnumMap c;
    private final lr d;
    private final al e;
    private boolean f;
    private x g;
    private x h;
    private double i = -1.0d;
    private final com.google.android.libraries.navigation.internal.bb.a j;

    public b(com.google.android.libraries.navigation.internal.bb.a aVar, lr lrVar, al alVar) {
        this.j = aVar;
        this.d = lrVar;
        this.e = alVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final lr a() {
        al alVarB;
        boolean z;
        ka kaVar = this.d.f;
        if (kaVar == null) {
            kaVar = ka.a;
        }
        int iA = jw.a(kaVar.d);
        if (iA == 0) {
            iA = jw.a;
        }
        if (iA == jw.c) {
            alVarB = al.b(kaVar.c);
            if (alVarB == null) {
                alVarB = al.MIXED;
            }
        } else {
            alVarB = this.e;
        }
        lo loVar = (lo) lr.a.r(this.d);
        ju juVar = (ju) ka.a.r(kaVar);
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka kaVar2 = (ka) juVar.b;
        kaVar2.c = alVarB.k;
        kaVar2.b |= 1;
        int i = jw.c;
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka kaVar3 = (ka) juVar.b;
        if (i == 0) {
            throw null;
        }
        kaVar3.d = i;
        kaVar3.b |= 2;
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka kaVar4 = (ka) juVar.b;
        kaVar4.b |= 2048;
        int i2 = 0;
        kaVar4.g = false;
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka.c((ka) juVar.b);
        ka kaVar5 = (ka) juVar.t();
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar = (lr) loVar.b;
        kaVar5.getClass();
        lrVar.f = kaVar5;
        lrVar.b |= 1;
        n nVar = this.b;
        if (nVar != null) {
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar2 = (lr) loVar.b;
            lrVar2.t = nVar;
            lrVar2.c |= 2048;
        }
        if (this.f) {
            if (this.g != null) {
                gb gbVar = (gb) gc.a.q();
                x xVar = this.g;
                ar.q(xVar);
                if (!gbVar.b.H()) {
                    gbVar.v();
                }
                gc gcVar = (gc) gbVar.b;
                gcVar.b |= 1;
                gcVar.c = xVar;
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr lrVar3 = (lr) loVar.b;
                gc gcVar2 = (gc) gbVar.t();
                gcVar2.getClass();
                lrVar3.q = gcVar2;
                lrVar3.b |= 33554432;
            }
        } else if (this.h != null) {
            gf gfVar = (gf) gg.a.q();
            x xVar2 = this.h;
            ar.q(xVar2);
            if (!gfVar.b.H()) {
                gfVar.v();
            }
            gg ggVar = (gg) gfVar.b;
            ggVar.b |= 1;
            ggVar.c = xVar2;
            double d = this.i;
            if (d >= 0.0d) {
                int i3 = (int) d;
                if (!gfVar.b.H()) {
                    gfVar.v();
                }
                gg ggVar2 = (gg) gfVar.b;
                ggVar2.b |= 2;
                ggVar2.d = i3;
            }
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar4 = (lr) loVar.b;
            gg ggVar3 = (gg) gfVar.t();
            ggVar3.getClass();
            lrVar4.p = ggVar3;
            lrVar4.b |= 8388608;
        }
        by byVar = ((lr) loVar.b).h;
        if (byVar == null) {
            byVar = by.a;
        }
        bt btVar = (bt) by.a.r(byVar);
        lc lcVar = ((lr) loVar.b).j;
        if (lcVar == null) {
            lcVar = lc.a;
        }
        lb lbVar = (lb) lc.a.r(lcVar);
        com.google.android.libraries.navigation.internal.aar.b bVar = ((lr) loVar.b).w;
        if (bVar == null) {
            bVar = com.google.android.libraries.navigation.internal.aar.b.a;
        }
        com.google.android.libraries.navigation.internal.aar.a aVar = (com.google.android.libraries.navigation.internal.aar.a) com.google.android.libraries.navigation.internal.aar.b.a.r(bVar);
        kw kwVar = ((lr) loVar.b).i;
        if (kwVar == null) {
            kwVar = kw.a;
        }
        kv kvVar = (kv) kw.a.r(kwVar);
        int i4 = 4;
        if (this.c != null) {
            if (!btVar.b.H()) {
                btVar.v();
            }
            ((by) btVar.b).f = dj.b;
            EnumMap enumMap = this.c;
            ar.q(enumMap);
            for (Map.Entry entry : enumMap.entrySet()) {
                a aVar2 = (a) entry.getKey();
                ar.q(aVar2);
                Integer num = (Integer) entry.getValue();
                ar.q(num);
                int iIntValue = num.intValue();
                switch (aVar2.ordinal()) {
                    case 3:
                        boolean z2 = iIntValue != 0;
                        if (!btVar.b.H()) {
                            btVar.v();
                        }
                        by byVar2 = (by) btVar.b;
                        byVar2.b |= 1;
                        byVar2.c = z2;
                        i2 = 0;
                        i4 = 4;
                        break;
                    case 4:
                        boolean z3 = iIntValue != 0;
                        if (!btVar.b.H()) {
                            btVar.v();
                        }
                        by byVar3 = (by) btVar.b;
                        byVar3.b |= 2;
                        byVar3.d = z3;
                        i2 = 0;
                        i4 = 4;
                        break;
                    case 5:
                        j jVar = ((by) btVar.b).h;
                        if (jVar == null) {
                            jVar = j.a;
                        }
                        bb bbVar = (bb) jVar.aH(5, null);
                        bbVar.x(jVar);
                        i iVar = (i) bbVar;
                        j jVar2 = ((by) btVar.b).h;
                        if (jVar2 == null) {
                            jVar2 = j.a;
                        }
                        if (!jVar2.c) {
                            z = i2;
                        } else if (iIntValue != 0) {
                            z = 1;
                        } else {
                            int i5 = i2;
                            iIntValue = i5 == true ? 1 : 0;
                            z = i5;
                        }
                        if (!iVar.b.H()) {
                            iVar.v();
                        }
                        j jVar3 = (j) iVar.b;
                        jVar3.b |= 2;
                        jVar3.d = z;
                        j jVar4 = (j) iVar.t();
                        if (!btVar.b.H()) {
                            btVar.v();
                        }
                        by byVar4 = (by) btVar.b;
                        jVar4.getClass();
                        byVar4.h = jVar4;
                        byVar4.b |= 524288;
                        j jVar5 = ((kw) kvVar.b).c;
                        if (jVar5 == null) {
                            jVar5 = j.a;
                        }
                        bb bbVar2 = (bb) jVar5.aH(5, null);
                        bbVar2.x(jVar5);
                        i iVar2 = (i) bbVar2;
                        j jVar6 = ((kw) kvVar.b).c;
                        if (jVar6 == null) {
                            jVar6 = j.a;
                        }
                        boolean z4 = jVar6.c && iIntValue != 0;
                        if (!iVar2.b.H()) {
                            iVar2.v();
                        }
                        j jVar7 = (j) iVar2.b;
                        jVar7.b |= 2;
                        jVar7.d = z4;
                        j jVar8 = (j) iVar2.t();
                        if (!kvVar.b.H()) {
                            kvVar.v();
                        }
                        kw kwVar2 = (kw) kvVar.b;
                        jVar8.getClass();
                        kwVar2.c = jVar8;
                        kwVar2.b |= 2;
                        i2 = 0;
                        i4 = 4;
                        break;
                    case 6:
                        boolean z5 = iIntValue != 0 ? 1 : i2;
                        if (!loVar.b.H()) {
                            loVar.v();
                        }
                        lr lrVar5 = (lr) loVar.b;
                        lrVar5.b |= 4096;
                        lrVar5.f320n = z5;
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        switch (((a) entry.getKey()).ordinal()) {
                            case 7:
                                com.google.android.libraries.navigation.internal.bj.c.e(1, btVar, bw.b(((Integer) entry.getValue()).intValue()));
                                break;
                            case 8:
                                com.google.android.libraries.navigation.internal.bj.c.e(2, btVar, bw.b(((Integer) entry.getValue()).intValue()));
                                break;
                            case 9:
                                com.google.android.libraries.navigation.internal.bj.c.e(3, btVar, bw.b(((Integer) entry.getValue()).intValue()));
                                break;
                            case 10:
                                com.google.android.libraries.navigation.internal.bj.c.e(i4, btVar, bw.b(((Integer) entry.getValue()).intValue()));
                                break;
                        }
                        break;
                    case 11:
                        int iA2 = lq.a(iIntValue);
                        if (!loVar.b.H()) {
                            loVar.v();
                        }
                        lr lrVar6 = (lr) loVar.b;
                        int i6 = iA2 - 1;
                        if (iA2 == 0) {
                            throw null;
                        }
                        lrVar6.m = i6;
                        lrVar6.b |= 2048;
                        break;
                        break;
                    case 12:
                        if (iIntValue > 0) {
                            if (!loVar.b.H()) {
                                loVar.v();
                            }
                            lr lrVar7 = (lr) loVar.b;
                            lrVar7.b |= 1024;
                            lrVar7.l = iIntValue;
                        } else {
                            if (!loVar.b.H()) {
                                loVar.v();
                            }
                            lr lrVar8 = (lr) loVar.b;
                            lrVar8.b &= -1025;
                            lrVar8.l = i2;
                        }
                        break;
                    case 13:
                        boolean z6 = iIntValue != 0 ? 1 : i2;
                        if (!lbVar.b.H()) {
                            lbVar.v();
                        }
                        lc lcVar2 = (lc) lbVar.b;
                        lcVar2.b |= 1;
                        lcVar2.c = z6;
                        break;
                    case 14:
                        ai aiVar = (ai) aj.a.q();
                        boolean z7 = iIntValue != 0 ? 1 : i2;
                        if (!aiVar.b.H()) {
                            aiVar.v();
                        }
                        aj ajVar = (aj) aiVar.b;
                        ajVar.b |= 1;
                        ajVar.c = z7;
                        aj ajVar2 = (aj) aiVar.t();
                        if (!btVar.b.H()) {
                            btVar.v();
                        }
                        by byVar5 = (by) btVar.b;
                        ajVar2.getClass();
                        byVar5.g = ajVar2;
                        byVar5.b |= 131072;
                        break;
                    case 15:
                        if (this.j.a()) {
                            v vVar = ((by) btVar.b).i;
                            if (vVar == null) {
                                vVar = v.a;
                            }
                            bb bbVar3 = (bb) vVar.aH(5, null);
                            bbVar3.x(vVar);
                            u uVar = (u) bbVar3;
                            int i7 = com.google.android.libraries.navigation.internal.bb.c.a;
                            f fVarB = f.b(iIntValue);
                            if (fVarB == null) {
                                fVarB = f.UNKNOWN_ENGINE_TYPE;
                            }
                            if (!uVar.b.H()) {
                                uVar.v();
                            }
                            v vVar2 = (v) uVar.b;
                            vVar2.c = fVarB.f;
                            vVar2.b |= 1;
                            v vVar3 = (v) uVar.t();
                            if (!btVar.b.H()) {
                                btVar.v();
                            }
                            by byVar6 = (by) btVar.b;
                            vVar3.getClass();
                            byVar6.i = vVar3;
                            byVar6.b |= 1048576;
                        }
                        break;
                    case 16:
                    default:
                        break;
                    case 17:
                        boolean z8 = iIntValue != 0 ? 1 : i2;
                        if (!btVar.b.H()) {
                            btVar.v();
                        }
                        by byVar7 = (by) btVar.b;
                        byVar7.b |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                        byVar7.j = z8;
                        break;
                }
            }
        }
        iu iuVar = ((by) btVar.b).e;
        if (iuVar == null) {
            iuVar = iu.a;
        }
        ip ipVar = (ip) iu.a.r(iuVar);
        int i8 = it.c;
        if (!ipVar.b.H()) {
            ipVar.v();
        }
        iu iuVar2 = (iu) ipVar.b;
        int i9 = i8 - 1;
        if (i8 == 0) {
            throw null;
        }
        iuVar2.d = i9;
        iuVar2.b |= 64;
        if (!ipVar.b.H()) {
            ipVar.v();
        }
        iu iuVar3 = (iu) ipVar.b;
        iuVar3.b &= -257;
        iuVar3.e = 0;
        x xVar3 = this.a;
        if (xVar3 != null) {
            if (!ipVar.b.H()) {
                ipVar.v();
            }
            iu iuVar4 = (iu) ipVar.b;
            iuVar4.b = 1 | iuVar4.b;
            iuVar4.c = xVar3;
        }
        if (!btVar.b.H()) {
            btVar.v();
        }
        by byVar8 = (by) btVar.b;
        iu iuVar5 = (iu) ipVar.t();
        iuVar5.getClass();
        byVar8.e = iuVar5;
        byVar8.b |= 512;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar9 = (lr) loVar.b;
        by byVar9 = (by) btVar.t();
        byVar9.getClass();
        lrVar9.h = byVar9;
        lrVar9.b |= 4;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar10 = (lr) loVar.b;
        lc lcVar3 = (lc) lbVar.t();
        lcVar3.getClass();
        lrVar10.j = lcVar3;
        lrVar10.b |= 16;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar11 = (lr) loVar.b;
        kw kwVar3 = (kw) kvVar.t();
        kwVar3.getClass();
        lrVar11.i = kwVar3;
        lrVar11.b |= 8;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar12 = (lr) loVar.b;
        com.google.android.libraries.navigation.internal.aar.b bVar2 = (com.google.android.libraries.navigation.internal.aar.b) aVar.t();
        bVar2.getClass();
        lrVar12.w = bVar2;
        lrVar12.c |= 8388608;
        return (lr) loVar.t();
    }

    public final void b(x xVar) {
        this.f = true;
        this.g = xVar;
    }

    public final void c(x xVar, double d) {
        this.h = xVar;
        this.i = d;
    }
}
