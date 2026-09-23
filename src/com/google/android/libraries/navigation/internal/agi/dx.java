package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dx extends hm implements hj {
    final /* synthetic */ dy a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dx(dy dyVar, int i, int i2) {
        super(i, i2);
        this.a = dyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ hj a(int i, int i2) {
        return new dx(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ Object c(int i) {
        ef efVar = this.a.a;
        return new j(efVar.a[i], efVar.b[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final int characteristics() {
        return 16465;
    }
}
