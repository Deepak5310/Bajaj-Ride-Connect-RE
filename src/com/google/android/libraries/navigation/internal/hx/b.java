package com.google.android.libraries.navigation.internal.hx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bl;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bx;
import com.google.android.libraries.navigation.internal.yz.ck;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import j$.util.concurrent.DesugarTimeUnit;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends AbstractExecutorService implements bn {
    public final int a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    private final String f;
    private final ScheduledExecutorService g;
    protected final AtomicInteger c = new AtomicInteger();
    public final ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();
    private final CountDownLatch h = new CountDownLatch(1);
    public final Map e = new ConcurrentHashMap();
    private ev i = null;

    /* JADX INFO: compiled from: PG */
    public final class a extends com.google.android.libraries.navigation.internal.aac.d implements RunnableScheduledFuture, bl {
        static final AtomicLong a = new AtomicLong();
        Callable b;
        private final boolean c;
        private final b d;
        private final com.google.android.libraries.navigation.internal.mj.a e;
        private final long f;
        private final String g;
        private final long h;
        private final long i;
        private final AtomicLong j;

        public a(Callable callable, boolean z, b bVar) {
            this(callable, z, bVar, 0L, 0L, 0L, TimeUnit.NANOSECONDS);
        }

        final long a() {
            AtomicLong atomicLong = this.j;
            return atomicLong != null ? atomicLong.get() : this.i;
        }

        @Override // com.google.android.libraries.navigation.internal.aac.d
        protected final void b() {
            this.b = null;
            this.d.m(this);
        }

        final void c() {
            ar.q(this.j);
            long j = this.h;
            if (j > 0) {
                this.j.addAndGet(j);
            } else {
                this.j.set(this.e.b() - j);
            }
            try {
                this.d.k(this);
            } catch (RejectedExecutionException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(TypedValues.TransitionType.TYPE_INTERPOLATOR)).s("Repeating task rejected on  %s", this.d);
            }
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
            Delayed delayed2 = delayed;
            if (!(delayed2 instanceof a)) {
                return Long.compare(getDelay(TimeUnit.NANOSECONDS), delayed2.getDelay(TimeUnit.NANOSECONDS));
            }
            a aVar = (a) delayed2;
            return ck.b.d(a(), aVar.a()).d(this.f, aVar.f).a();
        }

        @Override // java.util.concurrent.Delayed
        public final long getDelay(TimeUnit timeUnit) {
            return DesugarTimeUnit.convert(timeUnit, Duration.ofNanos(a() - this.e.b()));
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public final boolean isPeriodic() {
            return this.h != 0;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            Callable callable = this.b;
            if (callable == null || isDone()) {
                return;
            }
            Duration.ofNanos(a());
            int i = m.a;
            try {
                Object objCall = callable.call();
                if (!isPeriodic() || isDone()) {
                    d(objCall);
                } else {
                    c();
                }
            } catch (Throwable th) {
                ap(th);
                if (this.c) {
                    return;
                }
                bx.c(th);
                throw new RuntimeException("Task<> Exception on " + this.d.toString(), th);
            }
        }

        public a(Callable callable, boolean z, b bVar, long j, long j2, long j3, TimeUnit timeUnit) {
            Callable callableC;
            long j4;
            long j5;
            long j6;
            if (j != 0) {
                callableC = callable;
                j4 = j;
                j5 = j2;
                j6 = j3;
            } else if (j2 != 0) {
                callableC = callable;
                j5 = j2;
                j6 = j3;
                j4 = 0;
            } else if (j3 == 0) {
                callableC = com.google.android.libraries.navigation.internal.yu.f.c(callable);
                j4 = 0;
                j5 = 0;
                j6 = 0;
            } else {
                callableC = callable;
                j6 = j3;
                j4 = 0;
                j5 = 0;
            }
            this.b = callableC;
            this.c = z;
            this.d = bVar;
            com.google.android.libraries.navigation.internal.mj.a aVar = bVar.b;
            this.e = aVar;
            this.f = a.getAndIncrement();
            int i = m.a;
            this.g = null;
            ar.b(j5 >= 0, "'period' must not be negative");
            ar.b(j6 >= 0, "'delay' must not be negative");
            ar.b(j6 == 0 || j5 == 0, "One of 'delay' or 'period' must be zero.");
            long nanos = timeUnit.toNanos(j5 <= 0 ? -j6 : j5);
            this.h = nanos;
            long jB = aVar.b() + timeUnit.toNanos(Math.max(0L, j4));
            this.i = jB;
            this.j = nanos != 0 ? new AtomicLong(jB) : null;
        }
    }

    public b(String str, int i, com.google.android.libraries.navigation.internal.mj.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.f = str;
        this.a = i;
        this.b = aVar;
        this.g = scheduledExecutorService;
    }

    protected c a() {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.h.await(j, timeUnit);
    }

    final b b(String str, int i, ap apVar) {
        ScheduledExecutorService scheduledExecutorService = this.g;
        i iVar = new i(str, i, this, this.b, scheduledExecutorService == null ? this : scheduledExecutorService, apVar);
        synchronized (this.c) {
            if (isShutdown()) {
                throw new IllegalStateException("Can't delegate to shut down Executor '" + this.f + "'.");
            }
            this.d.add(iVar);
        }
        return iVar;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: c */
    public final bj submit(Runnable runnable) {
        return (bj) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: d */
    public final bj submit(Callable callable) {
        return (bj) super.submit(callable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: e */
    public final bl schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(Executors.callable(runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (isShutdown()) {
            throw new RejectedExecutionException("execute() on shut down Executor: ".concat(String.valueOf(this.f)));
        }
        h(runnable instanceof a ? (a) runnable : new a(Executors.callable(runnable), false, this));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: f */
    public final bl schedule(Callable callable, long j, TimeUnit timeUnit) {
        return p(callable, j, 0L, 0L, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: g */
    public final bl scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return p(Executors.callable(runnable), j, j2, 0L, timeUnit);
    }

    protected abstract void h(a aVar);

    protected final void i() {
        if (n(33554432, 16777216)) {
            this.h.countDown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return (this.c.get() & ViewCompat.MEASURED_STATE_MASK) >= 33554432;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return (this.c.get() & ViewCompat.MEASURED_STATE_MASK) == 50331648;
    }

    protected void j() {
    }

    public final void k(final a aVar) {
        if (this.g != null) {
            long delay = aVar.getDelay(TimeUnit.NANOSECONDS);
            if (delay > 0) {
                synchronized (this.c) {
                    if (isShutdown()) {
                        throw new RejectedExecutionException("Delayed task on shut down Executor: " + this.f);
                    }
                    this.e.put(aVar, this.g.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.hx.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b bVar = this.a;
                            b.a aVar2 = aVar;
                            synchronized (bVar.c) {
                                if (((ScheduledFuture) bVar.e.remove(aVar2)) != null && !aVar2.isDone()) {
                                    bVar.h(aVar2);
                                }
                            }
                        }
                    }, delay, TimeUnit.NANOSECONDS));
                }
                return;
            }
        }
        if (isShutdown()) {
            throw new RejectedExecutionException("Immeditate task on shut down Executor: ".concat(String.valueOf(this.f)));
        }
        h(aVar);
    }

    public final void l() {
        synchronized (this.c) {
            if (n(0, 16777216)) {
                eq eqVar = new eq();
                while (true) {
                    ExecutorService executorService = (ExecutorService) this.d.poll();
                    if (executorService == null) {
                        break;
                    } else {
                        eqVar.j(executorService.shutdownNow());
                    }
                }
                ar.k(n(16777216, 16777216));
                for (a aVar : this.e.keySet()) {
                    if (m(aVar) && !aVar.isDone()) {
                        eqVar.h(aVar);
                    }
                }
                this.i = eqVar.g();
                j();
            }
        }
    }

    public final boolean m(a aVar) {
        ScheduledFuture scheduledFuture;
        if (this.g == null || (scheduledFuture = (ScheduledFuture) this.e.remove(aVar)) == null) {
            return false;
        }
        scheduledFuture.cancel(false);
        return true;
    }

    protected final boolean n(int i, int i2) {
        int i3;
        ar.a((i & ViewCompat.MEASURED_STATE_MASK) <= 50331648);
        do {
            i3 = this.c.get();
            if ((i3 & ViewCompat.MEASURED_STATE_MASK) != i) {
                return false;
            }
        } while (!this.c.compareAndSet(i3, i3 + i2));
        return true;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new a(Executors.callable(runnable, obj), true, this);
    }

    public final b o(String str) {
        return b(str, 1, null);
    }

    protected final bl p(Callable callable, long j, long j2, long j3, TimeUnit timeUnit) {
        a aVar = new a(callable, true, this, j, j2, j3, timeUnit);
        k(aVar);
        return aVar;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return p(Executors.callable(runnable), j, 0L, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        l();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        ev evVar;
        synchronized (this.c) {
            l();
            evVar = this.i;
            ar.q(evVar);
            this.i = lv.a;
        }
        return evVar;
    }

    public final String toString() {
        c cVarA = a();
        if (cVarA == null) {
            return String.format(Locale.ENGLISH, "%s@%x[%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.f);
        }
        return String.format(Locale.ENGLISH, "%s@%x[%s %d/%d/%dq%d]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.f, Integer.valueOf(cVarA.a), Integer.valueOf(cVarA.b), Integer.valueOf(cVarA.c), Integer.valueOf(cVarA.d));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (bj) super.submit(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final /* synthetic */ RunnableFuture newTaskFor(Callable callable) {
        return new a(callable, true, this);
    }
}
