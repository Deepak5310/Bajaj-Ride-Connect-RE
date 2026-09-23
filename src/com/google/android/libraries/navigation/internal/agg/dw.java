package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dw implements Serializable, dt {
    private static final long serialVersionUID = 1;
    final dt a;

    protected dw(dt dtVar) {
        this.a = dtVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final int a(int i, int i2) {
        return this.a.a(i2, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final /* synthetic */ int b(Integer num, Integer num2) {
        return ds.a(this, num, num2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final dt c() {
        return this.a;
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
    public final /* synthetic */ Comparator reversed() {
        return this.a;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return ds.d(this, comparator);
    }
}
