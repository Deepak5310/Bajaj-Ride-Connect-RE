package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class du implements dt {
    final /* synthetic */ Comparator a;

    public du(Comparator comparator) {
        this.a = comparator;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final int a(int i, int i2) {
        return this.a.compare(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compare(Integer num, Integer num2) {
        return this.a.compare(num, num2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final /* synthetic */ dt c() {
        return dy.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final /* synthetic */ dt d(dt dtVar) {
        return new dr(this, dtVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ Comparator reversed() {
        return c();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return ds.d(this, comparator);
    }
}
