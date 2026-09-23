package com.google.android.libraries.navigation.internal.db;

import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public final List a = new ArrayList();
    public boolean c = false;
    public com.google.android.libraries.navigation.internal.oe.x b = null;

    static com.google.android.libraries.navigation.internal.oe.x c(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2, com.google.android.libraries.navigation.internal.oe.x xVar3, double d, com.google.android.libraries.navigation.internal.oe.x xVar4) {
        double d2 = 1.0d - d;
        double d3 = d * d;
        com.google.android.libraries.navigation.internal.oe.x xVar5 = xVar4 == null ? new com.google.android.libraries.navigation.internal.oe.x() : xVar4;
        double d4 = d2 * d2;
        double d5 = (d + d) * d2;
        xVar5.J((int) ((d4 * ((double) xVar.a)) + (d5 * ((double) xVar2.a)) + (d3 * ((double) xVar3.a))), (int) ((((double) xVar.b) * d4) + (((double) xVar2.b) * d5) + (((double) xVar3.b) * d3)));
        return xVar5;
    }

    public final double a(com.google.android.libraries.navigation.internal.oe.x xVar) {
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        double dM = 0.0d;
        double d = 3.4028234663852886E38d;
        double d2 = 0.0d;
        for (k kVar : this.a) {
            double dJ = com.google.android.libraries.navigation.internal.oe.x.j(kVar.b, kVar.d, xVar, xVar2);
            if (dJ < d) {
                dM = (((double) com.google.android.libraries.navigation.internal.oe.x.m(kVar.b, kVar.d, xVar)) * kVar.a) + d2;
                d = dJ;
            }
            d2 += kVar.a;
        }
        return dM;
    }

    public final double b(double d, com.google.android.libraries.navigation.internal.oe.x xVar, double d2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(!this.a.isEmpty());
        if (d < 0.0d) {
            k kVar = (k) this.a.get(0);
            if (!Double.isInfinite(100.0d)) {
                d = Math.max(d, kVar.b.e() * (-100.0d));
            }
            return kVar.a(d, xVar);
        }
        for (int i = 0; i < this.a.size(); i++) {
            k kVar2 = (k) this.a.get(i);
            double d3 = kVar2.a;
            if (d < d3) {
                return kVar2.a(d, xVar);
            }
            d -= d3;
        }
        k kVar3 = (k) gs.d(this.a);
        if (!Double.isInfinite(100.0d)) {
            d = Math.min(d, kVar3.d.e() * 100.0d);
        }
        return kVar3.a(kVar3.a + d, xVar);
    }

    public final void d(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2, l lVar, int i) {
        com.google.android.libraries.navigation.internal.oe.x xVar3;
        l lVar2;
        com.google.android.libraries.navigation.internal.yx.ar.q(this.b);
        int i2 = i - 1;
        if (i2 > 0) {
            com.google.android.libraries.navigation.internal.oe.x xVar4 = this.b;
            double d = xVar4.a;
            double d2 = xVar2.a;
            double d3 = xVar.a;
            double d4 = ((((double) xVar4.b) * 0.25d) + (((double) xVar2.b) * 0.25d)) - (((double) xVar.b) * 0.5d);
            double d5 = ((d * 0.25d) + (d2 * 0.25d)) - (d3 * 0.5d);
            if ((d5 * d5) + (d4 * d4) >= 400.0d) {
                com.google.android.libraries.navigation.internal.oe.x xVarC = c(xVar4, xVar, xVar2, 0.5d, null);
                com.google.android.libraries.navigation.internal.oe.x xVar5 = new com.google.android.libraries.navigation.internal.oe.x();
                com.google.android.libraries.navigation.internal.oe.x xVar6 = new com.google.android.libraries.navigation.internal.oe.x();
                com.google.android.libraries.navigation.internal.oe.x.H(this.b, xVar, 0.5f, xVar5);
                com.google.android.libraries.navigation.internal.oe.x.H(xVar, xVar2, 0.5f, xVar6);
                d(xVar5, xVarC, lVar, i2);
                d(xVar6, xVar2, lVar, i2);
                return;
            }
            xVar3 = xVar;
            lVar2 = lVar;
        } else {
            xVar3 = xVar;
            lVar2 = lVar;
        }
        this.a.add(new k(this.b, xVar3, xVar2, lVar2));
        this.b = xVar2;
    }

    public final void e(com.google.android.libraries.navigation.internal.oe.x xVar, l lVar) {
        com.google.android.libraries.navigation.internal.oe.x xVar2 = this.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(xVar2);
        this.a.add(new k(xVar2, null, xVar, lVar));
        this.b = xVar;
    }
}
