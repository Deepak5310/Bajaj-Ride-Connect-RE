package com.google.android.libraries.navigation.internal.agg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends ek {
    final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, int i) {
        super(i);
        this.a = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej
    protected final int g(int i) {
        n nVar = this.a;
        return nVar.a.n(nVar.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej
    protected final int h() {
        n nVar = this.a;
        return nVar.c - nVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ek
    protected final void i(int i, int i2) {
        this.a.r(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej
    protected final void j(int i) {
        this.a.o(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ek
    protected final void k(int i, int i2) {
        this.a.p(i, i2);
    }
}
