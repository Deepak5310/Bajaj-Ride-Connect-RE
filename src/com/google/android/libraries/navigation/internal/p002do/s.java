package com.google.android.libraries.navigation.internal.p002do;

import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bj;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.ni.a;
import com.google.android.libraries.navigation.internal.oe.ag;
import com.google.android.libraries.navigation.internal.oe.b;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oe.y;
import com.google.android.libraries.navigation.internal.ol.q;
import com.google.android.libraries.navigation.internal.pt.d;
import com.google.android.libraries.navigation.internal.pt.e;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements q {
    public final Object a = new Object();
    public final bg b;
    public final b c;
    public final a d;
    public long e;
    private final bj f;
    private final float g;

    public s(bg bgVar, bj bjVar, float f, a aVar, double d, double d2) {
        this.b = bgVar;
        this.f = bjVar;
        this.g = f;
        this.d = aVar;
        b bVar = new b(d);
        this.c = bVar;
        bVar.h(0.0d, d + d2, d2);
        this.e = aVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00bf  */
    public static double a(com.google.android.libraries.navigation.internal.of.a aVar, bg bgVar, double d) {
        ag agVar;
        ag agVar2;
        if (aVar == null || bgVar == null) {
            return Double.NaN;
        }
        r rVar = (r) aVar;
        x xVarA = x.A(rVar.b, rVar.c);
        double dE = xVarA.e();
        float f = rVar.d;
        double dMax = Math.max(50.0d, f + f) * dE;
        Objects.requireNonNull(bgVar);
        r rVar2 = new r(bgVar);
        double d2 = rVar.l().i.d(bgVar.Y);
        if (Double.isNaN(d2)) {
            agVar = null;
        } else {
            bg bgVar2 = rVar2.a;
            if (d2 < 0.0d || d2 > bgVar2.J) {
                agVar = null;
            } else {
                List listN = bgVar2.N();
                int iH = bgVar2.h(d2);
                if (iH == listN.size() - 1) {
                    x xVar = (x) listN.get(iH);
                    agVar = new ag(xVar, iH > 0 ? x.a((x) listN.get(iH - 1), xVar) : 0.0d, 0.0d, iH);
                } else {
                    double dA = bgVar2.a(iH);
                    int i = iH + 1;
                    double dA2 = bgVar2.a(i) - dA;
                    double d3 = dA2 != 0.0d ? (d2 - dA) / dA2 : 0.0d;
                    x xVar2 = (x) listN.get(iH);
                    x xVar3 = (x) listN.get(i);
                    x xVar4 = new x();
                    x.H(xVar2, xVar3, (float) d3, xVar4);
                    agVar = new ag(xVar4, x.a(xVar2, xVar3), 0.0d, iH);
                }
            }
        }
        if (agVar != null && agVar.a.h(xVarA) < dMax) {
            return bgVar.e(agVar);
        }
        List listAc = bgVar.ac(xVarA, dMax, bgVar.n(), Integer.MAX_VALUE);
        if (!Double.isNaN(d)) {
            double dMin = dE * Math.min(100.0d, ((double) rVar.d) + 20.0d);
            Iterator it2 = listAc.iterator();
            while (it2.hasNext()) {
                double dE2 = bgVar.e((ag) it2.next());
                double d4 = dE2 - d;
                if ((-dMin) < d4 && d4 < dMin) {
                    return dE2;
                }
            }
        }
        Iterator it3 = listAc.iterator();
        while (true) {
            int i2 = 0;
            if (!it3.hasNext()) {
                if (listAc.isEmpty()) {
                    return Double.NaN;
                }
                return bgVar.e((ag) listAc.get(0));
            }
            agVar2 = (ag) it3.next();
            if (!aVar.t() || y.a((float) agVar2.b, aVar.f()) < 120.0f) {
                if (!e.a(bgVar.j)) {
                    break;
                }
                int i3 = agVar2.c;
                bq[] bqVarArr = bgVar.l;
                bq bqVar = null;
                while (i2 < bqVarArr.length) {
                    bq bqVar2 = bqVarArr[i2];
                    if (bqVar2.k > i3) {
                        break;
                    }
                    i2++;
                    bqVar = bqVar2;
                }
                d dVarA = bqVar == null ? null : d.a(bqVar.D);
                d dVar = rVar.f387n;
                if (dVar == null || (dVarA != null && dVar.equals(dVarA))) {
                    break;
                }
            }
        }
        return bgVar.e(agVar2);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.q
    public final float b() {
        double dE;
        synchronized (this.a) {
            dE = this.c.e(Math.min((this.d.a() - this.e) / 1000.0d, 1.0d)) - ((double) this.g);
        }
        return (float) dE;
    }
}
