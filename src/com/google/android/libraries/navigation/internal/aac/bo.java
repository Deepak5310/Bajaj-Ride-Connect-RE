package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bo implements Executor {
    final /* synthetic */ Executor a;
    final /* synthetic */ d b;

    public bo(Executor executor, d dVar) {
        this.a = executor;
        this.b = dVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.b.ap(e);
        }
    }
}
