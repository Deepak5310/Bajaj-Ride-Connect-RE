package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s extends gu {
    final /* synthetic */ t a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, int i) {
        super(i);
        this.a = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt
    protected final int g() {
        t tVar = this.a;
        return tVar.c - tVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt
    protected final long h(int i) {
        t tVar = this.a;
        return tVar.a.m(tVar.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gu
    protected final void i(int i, long j) {
        this.a.q(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt
    protected final void j(int i) {
        this.a.n(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gu
    protected final void k(int i, long j) {
        this.a.o(i, j);
    }
}
