package com.google.android.libraries.navigation.internal.bp;

import android.util.LongSparseArray;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@com.google.android.libraries.navigation.internal.ib.a
public class bk implements com.google.android.libraries.navigation.internal.ic.a {
    public final LongSparseArray a;
    private final LongSparseArray b;
    private final LongSparseArray c;

    public bk(LongSparseArray longSparseArray, LongSparseArray longSparseArray2, LongSparseArray longSparseArray3) {
        this.a = longSparseArray;
        this.b = longSparseArray2;
        this.c = longSparseArray3;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean a() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ic.a
    public final /* synthetic */ boolean aj() {
        return false;
    }

    public final Double c(long j) {
        return (Double) this.c.get(j);
    }

    public final Double d(long j) {
        return (Double) this.b.get(j);
    }
}
