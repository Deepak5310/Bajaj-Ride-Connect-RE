package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dx implements Serializable, dt {
    private static final long serialVersionUID = 1;

    protected dx() {
    }

    private Object readResolve() {
        return dy.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final int a(int i, int i2) {
        return -Integer.compare(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int compare(Integer num, Integer num2) {
        return ds.a(this, num, num2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final dt c() {
        return dy.a;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return compare((Integer) obj, (Integer) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dt
    public final /* synthetic */ dt d(dt dtVar) {
        return new dr(this, dtVar);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator reversed() {
        return dy.a;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return ds.d(this, comparator);
    }
}
