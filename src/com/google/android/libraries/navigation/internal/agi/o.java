package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o extends ho {
    final gu a;

    public o(gu guVar) {
        super(0);
        this.a = guVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ hj a(int i, int i2) {
        return new o(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final Object c(int i) {
        return this.a.get(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ho
    protected final int d() {
        return this.a.size();
    }

    public o(gu guVar, int i, int i2) {
        super(i, i2);
        this.a = guVar;
    }
}
