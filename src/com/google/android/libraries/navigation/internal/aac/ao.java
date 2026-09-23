package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ao extends an {
    private final bj a;

    public ao(bj bjVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bjVar);
        this.a = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return this.a.get();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final boolean isDone() {
        return this.a.isDone();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, com.google.android.libraries.navigation.internal.aac.bj
    public final void l(Runnable runnable, Executor executor) {
        this.a.l(runnable, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    public final String toString() {
        return this.a.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.a.get(j, timeUnit);
    }
}
