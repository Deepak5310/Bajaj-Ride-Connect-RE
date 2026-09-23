package com.google.android.libraries.navigation.internal.agj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends bb {
    final am a;

    public c(am amVar) {
        super(0);
        this.a = amVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.bb
    protected final int a() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az
    protected final /* bridge */ /* synthetic */ ay b(int i, int i2) {
        return new c(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az
    protected final short c(int i) {
        return this.a.l(i);
    }

    public c(am amVar, int i, int i2) {
        super(i, i2);
        this.a = amVar;
    }
}
