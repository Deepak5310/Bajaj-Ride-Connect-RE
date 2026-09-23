package com.google.android.libraries.navigation.internal.agd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends an {
    final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, int i) {
        super(i);
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am
    protected final byte j(int i) {
        f fVar = this.a;
        return fVar.a.l(fVar.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am
    protected final int k() {
        f fVar = this.a;
        return fVar.c - fVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.an
    protected final void l(int i, byte b) {
        this.a.p(i, b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am
    protected final void m(int i) {
        this.a.m(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.an
    protected final void n(int i, byte b) {
        this.a.n(i, b);
    }
}
