package com.google.android.libraries.navigation.internal.bp;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements bj {
    public final com.google.android.libraries.navigation.internal.oe.ad a;
    private final bg b;
    private final double[] c;

    public ag(bg route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.b = route;
        com.google.android.libraries.navigation.internal.oe.ad adVar = route.m;
        if (adVar.e() > 1) {
            this.a = adVar;
            this.c = route.G;
            double[] dArr = route.F;
            return;
        }
        List listQ = adVar.q();
        Intrinsics.checkNotNullExpressionValue(listQ, "getVertices(...)");
        com.google.android.libraries.navigation.internal.oe.x xVar = (com.google.android.libraries.navigation.internal.oe.x) CollectionsKt.firstOrNull(listQ);
        xVar = xVar == null ? new com.google.android.libraries.navigation.internal.oe.x(0, 0) : xVar;
        com.google.android.libraries.navigation.internal.oe.ad adVarN = com.google.android.libraries.navigation.internal.oe.ad.n(CollectionsKt.listOf((Object[]) new com.google.android.libraries.navigation.internal.oe.x[]{xVar, new com.google.android.libraries.navigation.internal.oe.x(xVar.a + 1, xVar.b + 1)}));
        this.a = adVarN;
        this.c = new double[]{0.0d, adVarN.d(0)};
        adVarN.c(0);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bj
    public final int a(bq step) {
        Intrinsics.checkNotNullParameter(step, "step");
        com.google.android.libraries.navigation.internal.oe.ad adVar = this.a;
        int i = step.k;
        if (i < adVar.e() && Intrinsics.areEqual(this.a.q().get(i), step.c)) {
            return step.k;
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bj
    public final /* synthetic */ com.google.android.libraries.navigation.internal.oe.x b(bq bqVar) {
        return bi.a(this, bqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bj
    public final com.google.android.libraries.navigation.internal.oe.ad c(double d, double d2) {
        if (d2 < 0.0d) {
            return null;
        }
        com.google.android.libraries.navigation.internal.be.f fVarG = g(d);
        com.google.android.libraries.navigation.internal.be.f fVarG2 = g(d + d2);
        double dA = fVarG.a();
        double dA2 = fVarG2.a();
        if (dA > 0.0d || dA2 < 0.0d) {
            return null;
        }
        return fVarG.c().e(fVarG2.c());
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bj
    public final com.google.android.libraries.navigation.internal.oe.ad d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bj
    public final com.google.android.libraries.navigation.internal.oe.an e() {
        bq bqVarQ = this.b.q();
        if (bqVarQ == null || a(bqVarQ) == -1) {
            return null;
        }
        return this.b.y();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ag) {
            return this.b.Y == ((ag) obj).b.Y;
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bj
    public final void f() {
    }

    public final com.google.android.libraries.navigation.internal.be.f g(double d) {
        if (d < 0.0d) {
            com.google.android.libraries.navigation.internal.be.f fVarB = com.google.android.libraries.navigation.internal.be.f.a.b(this.a, 0, d);
            Intrinsics.checkNotNull(fVarB);
            return fVarB;
        }
        int iBinarySearch = Arrays.binarySearch(this.c, d);
        if (iBinarySearch >= 0) {
            com.google.android.libraries.navigation.internal.be.f fVarA = com.google.android.libraries.navigation.internal.be.f.a.a(this.a, iBinarySearch, 0.0d);
            Intrinsics.checkNotNull(fVarA);
            return fVarA;
        }
        int iMin = Math.min((~iBinarySearch) - 1, this.a.e() - 1);
        if (iMin < 0) {
            throw new IllegalStateException("Check failed.");
        }
        com.google.android.libraries.navigation.internal.be.f fVarB2 = com.google.android.libraries.navigation.internal.be.f.a.b(this.a, iMin, d - this.c[iMin]);
        Intrinsics.checkNotNull(fVarB2);
        return fVarB2;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.b.Y)});
    }
}
