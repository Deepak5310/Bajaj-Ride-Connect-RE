package com.google.android.libraries.navigation.internal.aac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cg extends bh {
    final /* synthetic */ ci a;
    private final s b;

    public cg(ci ciVar, s sVar) {
        this.a = ciVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(sVar);
        this.b = sVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final /* bridge */ /* synthetic */ Object a() throws Exception {
        s sVar = this.b;
        bj bjVarA = sVar.a();
        com.google.android.libraries.navigation.internal.yx.ar.s(bjVarA, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", sVar);
        return bjVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final String b() {
        return this.b.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final void d(Throwable th) {
        this.a.ap(th);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final /* bridge */ /* synthetic */ void e(Object obj) {
        this.a.aA((bj) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final boolean g() {
        return this.a.isDone();
    }
}
