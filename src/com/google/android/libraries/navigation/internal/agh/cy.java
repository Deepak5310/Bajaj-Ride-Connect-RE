package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cy extends com.google.android.libraries.navigation.internal.agi.hm implements com.google.android.libraries.navigation.internal.agi.hj {
    final /* synthetic */ cz a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy(cz czVar, int i, int i2) {
        super(i, i2);
        this.a = czVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hj a(int i, int i2) {
        return new cy(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ Object c(int i) {
        dg dgVar = this.a.a;
        return new i(dgVar.a[i], dgVar.b[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final int characteristics() {
        return 16465;
    }
}
