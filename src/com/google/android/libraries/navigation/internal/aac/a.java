package com.google.android.libraries.navigation.internal.aac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends c {
    public a(bj bjVar, Class cls, t tVar) {
        super(bjVar, cls, tVar);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.c
    public final /* bridge */ /* synthetic */ Object f(Object obj, Throwable th) throws Exception {
        t tVar = (t) obj;
        bj bjVarA = tVar.a(th);
        com.google.android.libraries.navigation.internal.yx.ar.s(bjVarA, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", tVar);
        return bjVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.c
    public final /* synthetic */ void g(Object obj) {
        aA((bj) obj);
    }
}
