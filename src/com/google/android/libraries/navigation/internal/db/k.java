package com.google.android.libraries.navigation.internal.db;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k {
    final double a;
    final com.google.android.libraries.navigation.internal.oe.x b;
    final com.google.android.libraries.navigation.internal.oe.x c;
    final com.google.android.libraries.navigation.internal.oe.x d;
    final l e;

    public k(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2, com.google.android.libraries.navigation.internal.oe.x xVar3, l lVar) {
        this.a = xVar.h(xVar3);
        this.b = xVar;
        this.c = xVar2;
        this.d = xVar3;
        this.e = lVar;
    }

    final double a(double d, com.google.android.libraries.navigation.internal.oe.x xVar) {
        com.google.android.libraries.navigation.internal.oe.x xVar2 = this.c;
        if (xVar2 == null) {
            if (xVar != null) {
                com.google.android.libraries.navigation.internal.oe.x.H(this.b, this.d, (float) (d / this.a), xVar);
            }
            return com.google.android.libraries.navigation.internal.oe.x.a(this.b, this.d);
        }
        double d2 = this.a;
        double d3 = d / d2;
        if (d3 <= 0.0d) {
            if (xVar != null) {
                com.google.android.libraries.navigation.internal.oe.x xVar3 = this.b;
                com.google.android.libraries.navigation.internal.oe.x.H(xVar3, xVar2, (float) (d / ((double) xVar3.h(xVar2))), xVar);
            }
            return com.google.android.libraries.navigation.internal.oe.x.a(this.b, this.c);
        }
        if (d3 >= 1.0d) {
            if (xVar != null) {
                double dH = xVar2.h(this.d);
                com.google.android.libraries.navigation.internal.oe.x.H(this.c, this.d, (float) (((d - d2) + dH) / dH), xVar);
            }
            return com.google.android.libraries.navigation.internal.oe.x.a(this.c, this.d);
        }
        if (xVar != null) {
            m.c(this.b, xVar2, this.d, d3, xVar);
        }
        double dMax = Math.max(0.0d, Math.min(d3, 1.0d));
        float fA = (float) com.google.android.libraries.navigation.internal.oe.x.a(this.b, this.c);
        double d4 = ((double) fA) + (dMax * ((double) com.google.android.libraries.navigation.internal.oe.y.d(fA, (float) com.google.android.libraries.navigation.internal.oe.x.a(this.c, this.d))));
        return d4 < 0.0d ? d4 + 360.0d : d4;
    }
}
