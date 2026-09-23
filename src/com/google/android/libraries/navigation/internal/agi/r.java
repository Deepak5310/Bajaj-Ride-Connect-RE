package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends gk {
    final /* synthetic */ s a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, int i) {
        super(i);
        this.a = sVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final int a() {
        s sVar = this.a;
        return sVar.c - sVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final Object b(int i) {
        s sVar = this.a;
        return sVar.a.get(sVar.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gk
    protected final void c(int i, Object obj) {
        this.a.add(i, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final void d(int i) {
        this.a.remove(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gk
    protected final void e(int i, Object obj) {
        this.a.set(i, obj);
    }
}
