package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class aa extends bh {
    private final Executor a;
    final /* synthetic */ ab b;

    public aa(ab abVar, Executor executor) {
        this.b = abVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        this.a = executor;
    }

    public abstract void c(Object obj);

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final void d(Throwable th) {
        this.b.b = null;
        if (th instanceof ExecutionException) {
            this.b.ap(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.b.cancel(false);
        } else {
            this.b.ap(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final void e(Object obj) {
        this.b.b = null;
        c(obj);
    }

    final void f() {
        try {
            this.a.execute(this);
        } catch (RejectedExecutionException e) {
            this.b.ap(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final boolean g() {
        return this.b.isDone();
    }
}
