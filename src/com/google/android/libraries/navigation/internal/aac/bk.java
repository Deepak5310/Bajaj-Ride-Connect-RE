package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk extends FutureTask implements bj {
    private final af a;

    public bk(Runnable runnable) {
        super(runnable, null);
        this.a = new af();
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        af afVar = this.a;
        synchronized (afVar) {
            if (afVar.b) {
                return;
            }
            afVar.b = true;
            ae aeVar = afVar.a;
            ae aeVar2 = null;
            afVar.a = null;
            while (aeVar != null) {
                ae aeVar3 = aeVar.c;
                aeVar.c = aeVar2;
                aeVar2 = aeVar;
                aeVar = aeVar3;
            }
            while (aeVar2 != null) {
                af.a(aeVar2.a, aeVar2.b);
                aeVar2 = aeVar2.c;
            }
        }
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        return nanos <= 2147483647999999999L ? super.get(j, timeUnit) : super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bj
    public final void l(Runnable runnable, Executor executor) {
        com.google.android.libraries.navigation.internal.yx.ar.r(runnable, "Runnable was null.");
        com.google.android.libraries.navigation.internal.yx.ar.r(executor, "Executor was null.");
        af afVar = this.a;
        synchronized (afVar) {
            if (afVar.b) {
                af.a(runnable, executor);
            } else {
                afVar.a = new ae(runnable, executor, afVar.a);
            }
        }
    }

    public bk(Callable callable) {
        super(callable);
        this.a = new af();
    }
}
