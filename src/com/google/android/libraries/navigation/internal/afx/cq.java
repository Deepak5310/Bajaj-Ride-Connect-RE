package com.google.android.libraries.navigation.internal.afx;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cq implements Executor {
    private final Thread.UncaughtExceptionHandler a;
    private final Queue b = new ConcurrentLinkedQueue();
    private final AtomicReference c = new AtomicReference();

    public cq(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    public final cp a(Runnable runnable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        co coVar = new co(runnable);
        return new cp(coVar, scheduledExecutorService.schedule(new cn(this, coVar, runnable), j, timeUnit));
    }

    public final void b() {
        do {
            AtomicReference atomicReference = this.c;
            Thread threadCurrentThread = Thread.currentThread();
            while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, threadCurrentThread)) {
                if (atomicReference.get() != null) {
                    return;
                }
            }
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.b.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.c.set(null);
                    throw th2;
                }
            }
            this.c.set(null);
        } while (!this.b.isEmpty());
    }

    public final void c(Runnable runnable) {
        com.google.android.libraries.navigation.internal.yx.ar.r(runnable, "runnable is null");
        this.b.add(runnable);
    }

    public final void d() {
        com.google.android.libraries.navigation.internal.yx.ar.l(Thread.currentThread() == this.c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(runnable);
        b();
    }
}
