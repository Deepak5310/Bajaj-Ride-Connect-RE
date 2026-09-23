package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah extends gk {
    final /* synthetic */ ai a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ai aiVar, int i) {
        super(i);
        this.a = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final int a() {
        ai aiVar = this.a;
        return aiVar.c - aiVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final Object b(int i) {
        ai aiVar = this.a;
        return aiVar.a.get(aiVar.b + i);
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
