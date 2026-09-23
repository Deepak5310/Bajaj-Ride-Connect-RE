package com.google.android.libraries.navigation.internal.aac;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az extends bb {
    @SafeVarargs
    public static ax a(bj... bjVarArr) {
        return new ax(false, ev.p(bjVarArr));
    }

    public static ax b(Iterable iterable) {
        return new ax(true, ev.n(iterable));
    }

    @SafeVarargs
    public static ax c(bj... bjVarArr) {
        return new ax(true, ev.p(bjVarArr));
    }

    public static bj d(Iterable iterable) {
        return new v(ev.n(iterable), true);
    }

    @SafeVarargs
    public static bj e(bj... bjVarArr) {
        return new v(ev.p(bjVarArr), true);
    }

    public static bj f() {
        bc bcVar = bc.a;
        return bcVar != null ? bcVar : new bc();
    }

    public static bj g(Throwable th) {
        com.google.android.libraries.navigation.internal.yx.ar.q(th);
        return new bd(th);
    }

    public static bj h(Object obj) {
        return obj == null ? be.a : new be(obj);
    }

    public static bj i(bj bjVar) {
        if (bjVar.isDone()) {
            return bjVar;
        }
        ay ayVar = new ay(bjVar);
        bjVar.l(ayVar, ac.INSTANCE);
        return ayVar;
    }

    public static bj j(s sVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        ci ciVar = new ci(sVar);
        final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(ciVar, j, timeUnit);
        ciVar.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.aac.at
            @Override // java.lang.Runnable
            public final void run() {
                scheduledFutureSchedule.cancel(false);
            }
        }, ac.INSTANCE);
        return ciVar;
    }

    public static bj k(Callable callable, Executor executor) {
        ci ciVar = new ci(callable);
        executor.execute(ciVar);
        return ciVar;
    }

    public static bj l(s sVar, Executor executor) {
        ci ciVar = new ci(sVar);
        executor.execute(ciVar);
        return ciVar;
    }

    public static bj m(bj bjVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (bjVar.isDone()) {
            return bjVar;
        }
        cf cfVar = new cf(bjVar);
        cd cdVar = new cd(cfVar);
        cfVar.b = scheduledExecutorService.schedule(cdVar, j, timeUnit);
        bjVar.l(cdVar, ac.INSTANCE);
        return cfVar;
    }

    public static Object n(Future future) throws ExecutionException {
        com.google.android.libraries.navigation.internal.yx.ar.o(future.isDone(), "Future was expected to be done: %s", future);
        return ck.a(future);
    }

    public static void o(bj bjVar, as asVar, Executor executor) {
        bjVar.l(new au(bjVar, asVar), executor);
    }

    public static void p(bj bjVar, Future future) {
        if (bjVar instanceof d) {
            ((d) bjVar).o(future);
        } else {
            if (bjVar == null || !bjVar.isCancelled() || future == null) {
                return;
            }
            future.cancel(false);
        }
    }
}
