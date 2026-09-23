package com.google.android.libraries.navigation.environment;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bo implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public bo(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.ec.d dVarA = ((com.google.android.libraries.navigation.internal.ec.e) this.a).a();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) dVarA.a.a();
        aVar.getClass();
        com.google.android.libraries.navigation.internal.iv.f fVar = (com.google.android.libraries.navigation.internal.iv.f) dVarA.b.a();
        fVar.getClass();
        com.google.android.libraries.navigation.internal.ia.e eVar = (com.google.android.libraries.navigation.internal.ia.e) dVarA.c.a();
        eVar.getClass();
        Executor executor = (Executor) dVarA.d.a();
        executor.getClass();
        return new com.google.android.libraries.navigation.internal.ec.c(fVar, eVar, executor, new com.google.android.libraries.navigation.internal.ec.h(aVar));
    }
}
