package com.google.android.libraries.navigation.internal.zo;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements Executor {
    final /* synthetic */ Executor a;
    final /* synthetic */ q b;

    public m(q qVar, Executor executor) {
        this.a = executor;
        this.b = qVar;
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
