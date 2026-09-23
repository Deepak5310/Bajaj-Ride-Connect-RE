package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y extends aa {
    final /* synthetic */ ab a;
    private final s c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(ab abVar, s sVar, Executor executor) {
        super(abVar, executor);
        this.a = abVar;
        this.c = sVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final /* bridge */ /* synthetic */ Object a() throws Exception {
        s sVar = this.c;
        bj bjVarA = sVar.a();
        com.google.android.libraries.navigation.internal.yx.ar.s(bjVarA, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", sVar);
        return bjVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final String b() {
        return this.c.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.aa
    public final /* bridge */ /* synthetic */ void c(Object obj) {
        this.a.aA((bj) obj);
    }
}
