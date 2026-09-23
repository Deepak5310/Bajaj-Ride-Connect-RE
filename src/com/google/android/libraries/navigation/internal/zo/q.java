package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.bt;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.aac.u;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yx.bm;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bz;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends com.google.android.libraries.navigation.internal.aac.d {
    public static final Logger a = Logger.getLogger(q.class.getCanonicalName());
    public static final Object b = new Object();
    static final k i = new k();
    public final br c;
    public final g d;
    public final as e;
    public final bm f;
    public final bn g;
    public final k j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Executor f663n;
    public volatile int h = 0;
    private final AtomicReference o = new AtomicReference(az.h(new Object()));

    public q(br brVar, g gVar, as asVar, Executor executor, ScheduledExecutorService scheduledExecutorService, bz bzVar, k kVar) {
        this.c = brVar;
        this.d = gVar;
        this.e = asVar;
        ar.q(executor);
        this.f663n = new m(this, executor);
        this.g = bt.a(scheduledExecutorService);
        this.j = kVar;
        this.f = bm.b(bzVar);
        f(0L, TimeUnit.MILLISECONDS);
        l(new l(this, kVar), executor);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        bj bjVar = (bj) this.o.get();
        String string = bjVar.toString();
        g gVar = this.d;
        as asVar = this.e;
        return "futureSupplier=[" + String.valueOf(this.c) + "], shouldContinue=[" + String.valueOf(asVar) + "], strategy=[" + String.valueOf(gVar) + "], tries=[" + this.h + "]" + (bjVar.isDone() ? "" : com.google.android.libraries.navigation.internal.b.b.g(string, ", activeTry=[", "]"));
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        bj bjVar = (bj) this.o.getAndSet(az.f());
        if (bjVar != null) {
            boolean z = true;
            if (isCancelled() && !p()) {
                z = false;
            }
            bjVar.cancel(z);
        }
    }

    public final void f(final long j, final TimeUnit timeUnit) {
        ca caVar = new ca();
        bj bjVarI = (bj) this.o.getAndSet(caVar);
        if (j != 0) {
            bjVarI = com.google.android.libraries.navigation.internal.aac.j.i(bjVarI, new t() { // from class: com.google.android.libraries.navigation.internal.zo.h
                @Override // com.google.android.libraries.navigation.internal.aac.t
                public final bj a(Object obj) {
                    return this.a.g.schedule(new u(), j, timeUnit);
                }
            }, ac.INSTANCE);
        }
        final bj bjVarI2 = com.google.android.libraries.navigation.internal.aac.j.i(bjVarI, new t() { // from class: com.google.android.libraries.navigation.internal.zo.i
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                q qVar = this.a;
                qVar.h++;
                try {
                    return (bj) qVar.c.a();
                } catch (Exception e) {
                    qVar.ap(e);
                    return az.h(null);
                }
            }
        }, this.f663n);
        caVar.aA(com.google.android.libraries.navigation.internal.aac.c.i(bjVarI2, Exception.class, new t() { // from class: com.google.android.libraries.navigation.internal.zo.j
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) throws a {
                bj bjVar = bjVarI2;
                Exception exc = (Exception) obj;
                if (bjVar.isCancelled()) {
                    return bjVar;
                }
                q qVar = this.a;
                bm bmVar = qVar.f;
                long jC = qVar.d.c(qVar.h, bmVar.a(TimeUnit.MILLISECONDS));
                if (jC < 0 || !qVar.e.a(exc)) {
                    q.a.logp(Level.FINE, "com.google.common.labs.concurrent.RetryingFuture$1", "terminalExceptionCaught", "RetryingFuture caught terminal exception", (Throwable) exc);
                    int i2 = qVar.h;
                    throw new a(exc);
                }
                q.a.logp(Level.FINE, "com.google.common.labs.concurrent.RetryingFuture$1", "retryableExceptionCaught", "RetryingFuture caught exception; retrying", (Throwable) exc);
                qVar.f(jC, TimeUnit.MILLISECONDS);
                return az.h(q.b);
            }
        }, this.f663n));
        caVar.l(new n(this, caVar), ac.INSTANCE);
    }
}
