package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p extends hq {
    final gy a;

    public p(gy gyVar) {
        super(0);
        this.a = gyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hq
    protected final int a() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final long b(int i) {
        return this.a.m(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final /* bridge */ /* synthetic */ hl c(int i, int i2) {
        return new p(this.a, i, i2);
    }

    public p(gy gyVar, int i, int i2) {
        super(i, i2);
        this.a = gyVar;
    }
}
