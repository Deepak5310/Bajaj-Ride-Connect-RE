package com.google.android.libraries.navigation.internal.hx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.internal.view.SupportMenu;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends b implements an {
    final ThreadLocal f;
    private final Executor g;
    private final ap h;
    private final ConcurrentLinkedQueue i;
    private final AtomicReference j;
    private final AtomicReference k;

    public i(String str, int i, Executor executor, com.google.android.libraries.navigation.internal.mj.a aVar, ScheduledExecutorService scheduledExecutorService, ap apVar) {
        super(str, i, aVar, scheduledExecutorService);
        this.i = new ConcurrentLinkedQueue();
        this.f = new h();
        this.j = new AtomicReference(null);
        this.k = new AtomicReference(null);
        this.g = executor;
        this.h = apVar;
        ar.a(i > 0);
        ar.a(i <= 255);
    }

    private final void s(final b.a aVar) {
        try {
            this.g.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.hx.g
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = this.a;
                    b.a aVar2 = aVar;
                    try {
                        ((List) ap.L.get()).add(iVar);
                        aVar2.run();
                    } finally {
                        iVar.c.getAndAdd(SupportMenu.CATEGORY_MASK);
                        iVar.r();
                        ap.h(iVar);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            this.c.getAndAdd(SupportMenu.CATEGORY_MASK);
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(TypedValues.TransitionType.TYPE_STAGGERED)).x("Delegation rejected:  %s  -->  %s", this, this.g);
            r();
        }
    }

    private final void t() {
        if (this.c.get() == 33554432) {
            i();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b
    protected final c a() {
        int i = this.c.get();
        return new c((i >>> 16) & 255, 0, this.a, (char) i);
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b
    protected final void h(b.a aVar) {
        int i;
        do {
            int i2 = this.c.get();
            i = (-16777216) & i2;
            if (i >= 33554432) {
                throw new RejectedExecutionException("Delegator shut down:  ".concat(toString()));
            }
            if (((char) i2) == 65535) {
                throw new RejectedExecutionException("Too many tasks:  ".concat(toString()));
            }
        } while (!n(i, 1));
        this.i.offer(aVar);
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b
    protected final void j() {
        Executor executor = this.g;
        if (executor instanceof b) {
            ((b) executor).d.remove(this);
        }
        t();
    }

    @Override // com.google.android.libraries.navigation.internal.hx.an
    public final ap q() {
        return this.h;
    }

    final void r() {
        ThreadLocal threadLocal = this.f;
        Thread threadCurrentThread = Thread.currentThread();
        boolean zBooleanValue = ((Boolean) threadLocal.get()).booleanValue();
        this.f.set(true);
        if (zBooleanValue) {
            return;
        }
        try {
            com.google.android.libraries.navigation.internal.yr.ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
            try {
                this.j.set(threadCurrentThread);
                while (threadCurrentThread == this.j.get()) {
                    if (f.a(this.k, null, threadCurrentThread)) {
                        try {
                            int i = this.c.get();
                            char c = (char) i;
                            int i2 = i >>> 16;
                            if (c != 0 && (i2 & 255) < this.a) {
                                b.a aVar = (b.a) this.i.poll();
                                if (aVar != null) {
                                    if (aVar.isDone()) {
                                        this.c.addAndGet(-1);
                                    } else {
                                        this.c.addAndGet(65535);
                                        s(aVar);
                                    }
                                }
                                this.k.set(null);
                            }
                            this.k.set(null);
                            break;
                        } catch (Throwable th) {
                            this.k.set(null);
                            throw th;
                        }
                    }
                }
                aiVarA.close();
                this.f.set(false);
                f.a(this.j, threadCurrentThread, null);
                t();
            } catch (Throwable th2) {
                try {
                    aiVarA.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            this.f.set(false);
            f.a(this.j, threadCurrentThread, null);
            throw th4;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b, java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        List listShutdownNow = super.shutdownNow();
        eq eqVar = new eq();
        eqVar.j(listShutdownNow);
        while (((char) this.c.get()) > 0) {
            b.a aVar = (b.a) this.i.poll();
            if (aVar != null) {
                this.c.getAndAdd(-1);
                if (!aVar.isDone()) {
                    eqVar.h(aVar);
                }
            }
        }
        t();
        return eqVar.g();
    }
}
