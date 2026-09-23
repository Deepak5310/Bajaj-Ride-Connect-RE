package com.google.android.libraries.navigation.internal.nj;

import android.os.Handler;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bl;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.ca;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends com.google.android.libraries.navigation.internal.aac.g implements bn {
    public static final /* synthetic */ int c = 0;
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public final Handler b = new Handler(Looper.getMainLooper());

    public n(com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = aVar;
    }

    public static int a(Delayed delayed, Delayed delayed2) {
        long delay = delayed2.getDelay(TimeUnit.MILLISECONDS);
        long delay2 = delayed.getDelay(TimeUnit.MILLISECONDS);
        if (delay > delay2) {
            return -1;
        }
        return delay == delay2 ? 0 : 1;
    }

    private final bl b(Runnable runnable, long j, long j2, TimeUnit timeUnit, boolean z) {
        long millis = timeUnit.toMillis(j);
        l lVar = new l(this, runnable, millis + this.a.a(), timeUnit.toMillis(j2), z);
        this.b.postDelayed(lVar, millis);
        h(lVar, lVar);
        return lVar;
    }

    private final void h(bj bjVar, final Runnable runnable) {
        bjVar.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.nj.j
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.removeCallbacks(runnable);
            }
        }, ac.INSTANCE);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.g, com.google.android.libraries.navigation.internal.aac.bm
    /* JADX INFO: renamed from: d */
    public final bj submit(final Callable callable) {
        final ca caVar = new ca();
        this.b.post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.nj.k
            @Override // java.lang.Runnable
            public final void run() {
                int i = n.c;
                ca caVar2 = caVar;
                try {
                    caVar2.d(callable.call());
                } catch (Exception e) {
                    caVar2.ap(e);
                    throw new RuntimeException(e);
                }
            }
        });
        return caVar;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final bl schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(Executors.callable(runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.b.post(runnable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final bl schedule(Callable callable, long j, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j);
        m mVar = new m(this, callable, this.a.a() + millis);
        this.b.postDelayed(mVar, millis);
        h(mVar, mVar);
        return mVar;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final bl scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return b(runnable, j, j2, timeUnit, true);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return b(runnable, j, j2, timeUnit, false);
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.g, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* bridge */ /* synthetic */ Future submit(Callable callable) {
        return submit(callable);
    }
}
