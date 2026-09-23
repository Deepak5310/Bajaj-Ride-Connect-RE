package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class dr implements Serializable, dt {
    public final /* synthetic */ dt a;
    public final /* synthetic */ dt b;

    public /* synthetic */ dr(dt dtVar, dt dtVar2) {
        this.a = dtVar;
        this.b = dtVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final int a(int i, int i2) {
        int iA = this.a.a(i, i2);
        return iA == 0 ? this.b.a(i, i2) : iA;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final /* synthetic */ int b(Integer num, Integer num2) {
        return ds.a(this, num, num2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final /* synthetic */ dt c() {
        return dy.a(this);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return b((Integer) obj, (Integer) obj2);
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
