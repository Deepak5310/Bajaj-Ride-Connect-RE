package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bl implements Comparable {
    com.google.android.libraries.navigation.internal.oe.x a = new com.google.android.libraries.navigation.internal.oe.x();
    double b = Double.MAX_VALUE;
    int c = -1;

    public final com.google.android.libraries.navigation.internal.oe.ag a(com.google.android.libraries.navigation.internal.oe.ad adVar, int i, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2) {
        double d;
        float fC;
        int iMin = Math.min(i, adVar.e() - 1);
        int i2 = this.c;
        if (i2 >= iMin) {
            if (iMin > 0) {
                adVar.u(i2 - 1, xVar);
                adVar.u(this.c, xVar2);
                fC = com.google.android.libraries.navigation.internal.oe.y.c(xVar, xVar2);
            } else {
                d = 0.0d;
            }
            double d2 = d;
            com.google.android.libraries.navigation.internal.oe.x xVar3 = this.a;
            return new com.google.android.libraries.navigation.internal.oe.ag(xVar3, d2, this.b / xVar3.e(), this.c);
        }
        adVar.u(i2, xVar);
        adVar.u(this.c + 1, xVar2);
        fC = com.google.android.libraries.navigation.internal.oe.y.c(xVar, xVar2);
        d = fC;
        double d3 = d;
        com.google.android.libraries.navigation.internal.oe.x xVar4 = this.a;
        return new com.google.android.libraries.navigation.internal.oe.ag(xVar4, d3, this.b / xVar4.e(), this.c);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Double.compare(this.b, ((bl) obj).b);
    }
}
