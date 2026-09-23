package com.google.android.libraries.navigation.internal.bi;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    private final com.google.android.libraries.navigation.internal.gq.j a;
    private final f b;
    private final Executor c;

    public o(com.google.android.libraries.navigation.internal.gq.j jVar, f fVar, Executor executor) {
        this.a = jVar;
        this.b = fVar;
        this.c = executor;
    }

    public final com.google.android.libraries.navigation.internal.gg.b a(j jVar) {
        com.google.android.libraries.navigation.internal.gq.l lVarC;
        synchronized (this.a) {
            this.a.b().a = jVar.c().b;
            lVarC = this.a.c();
        }
        return new e(this.b.a, lVarC).a(jVar.d(), jVar.b(), this.c);
    }
}
