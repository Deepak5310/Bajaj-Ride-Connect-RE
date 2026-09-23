package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa extends com.google.android.libraries.navigation.internal.agi.hm implements com.google.android.libraries.navigation.internal.agi.hj {
    final /* synthetic */ ab a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(ab abVar, int i, int i2) {
        super(i, i2);
        this.a = abVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hj a(int i, int i2) {
        return new aa(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ Object c(int i) {
        ai aiVar = this.a.a;
        return new b(aiVar.b[i], aiVar.c[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final int characteristics() {
        return 16465;
    }
}
