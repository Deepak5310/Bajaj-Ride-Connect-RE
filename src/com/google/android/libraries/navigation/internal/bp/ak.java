package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ak implements an {
    static final ak a = new ak();

    private ak() {
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* bridge */ /* synthetic */ double a(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        Double d = (Double) comparable;
        Double d2 = (Double) comparable2;
        Double d3 = (Double) comparable3;
        if (com.google.android.libraries.navigation.internal.yx.am.a(d, d2)) {
            return 0.0d;
        }
        return (d3.doubleValue() - d.doubleValue()) / (d2.doubleValue() - d.doubleValue());
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* bridge */ /* synthetic */ am b(Comparable comparable) {
        return new am(((Double) comparable).intValue(), Duration.ZERO, false);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* bridge */ /* synthetic */ Comparable c(am amVar) {
        return Double.valueOf(amVar.a);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* bridge */ /* synthetic */ Comparable d(Comparable comparable, Comparable comparable2, double d) {
        Double d2 = (Double) comparable;
        return Double.valueOf(d2.doubleValue() + (d * (((Double) comparable2).doubleValue() - d2.doubleValue())));
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final boolean e() {
        return true;
    }
}
