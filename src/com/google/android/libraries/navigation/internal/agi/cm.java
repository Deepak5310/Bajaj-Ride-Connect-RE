package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cm extends hm implements hj {
    final /* synthetic */ cn a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cm(cn cnVar, int i, int i2) {
        super(i, i2);
        this.a = cnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ hj a(int i, int i2) {
        return new cm(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ Object c(int i) {
        cu cuVar = this.a.a;
        return new g(cuVar.b[i], cuVar.c[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final int characteristics() {
        return 16465;
    }
}
