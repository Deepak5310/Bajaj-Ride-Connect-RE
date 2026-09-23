package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ce implements Executor {
    private Executor a;
    private final es b;

    public ce(es esVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(esVar, "executorPool");
        this.b = esVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.concurrent.Executor] */
    final synchronized Executor a() {
        if (this.a == null) {
            ?? A = this.b.a();
            com.google.android.libraries.navigation.internal.yx.ar.s(A, "%s.getObject()", this.a);
            this.a = A;
        }
        return this.a;
    }

    final synchronized void b() {
        Executor executor = this.a;
        if (executor != null) {
            this.b.b(executor);
            this.a = null;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        a().execute(runnable);
    }
}
