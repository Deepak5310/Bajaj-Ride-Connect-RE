package com.google.android.libraries.navigation.internal.agj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends al {
    final /* synthetic */ g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, int i) {
        super(i);
        this.a = gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak
    protected final int j() {
        g gVar = this.a;
        return gVar.c - gVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak
    protected final short k(int i) {
        g gVar = this.a;
        return gVar.a.l(gVar.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.al
    protected final void l(int i, short s) {
        this.a.o(i, s);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak
    protected final void m(int i) {
        this.a.m(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.al
    protected final void n(int i, short s) {
        this.a.n(i, s);
    }
}
