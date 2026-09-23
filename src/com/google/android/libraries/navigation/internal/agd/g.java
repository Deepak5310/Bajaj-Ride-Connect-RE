package com.google.android.libraries.navigation.internal.agd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends bh {
    final ao a;

    public g(ao aoVar) {
        super(0);
        this.a = aoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf
    protected final byte a(int i) {
        return this.a.l(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bh
    protected final int b() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf
    protected final /* bridge */ /* synthetic */ be c(int i, int i2) {
        return new g(this.a, i, i2);
    }

    public g(ao aoVar, int i, int i2) {
        super(i, i2);
        this.a = aoVar;
    }
}
