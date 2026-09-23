package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae extends ho {
    final la a;

    public ae(la laVar) {
        super(0);
        this.a = laVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ hj a(int i, int i2) {
        return new ae(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final Object c(int i) {
        return this.a.get(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ho
    protected final int d() {
        return this.a.size();
    }

    public ae(la laVar, int i, int i2) {
        super(i, i2);
        this.a = laVar;
    }
}
