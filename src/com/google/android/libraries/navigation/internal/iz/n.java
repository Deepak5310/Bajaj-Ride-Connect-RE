package com.google.android.libraries.navigation.internal.iz;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.ce;
import com.google.android.libraries.navigation.internal.hx.ab;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    public static final /* synthetic */ int k = 0;
    public final com.google.android.libraries.navigation.internal.ia.e b;
    public final ab c;
    public final ab d;
    public final ab e;
    public final ab f;
    public final j g = new j();
    public volatile CountDownLatch h;
    final com.google.android.libraries.navigation.internal.hx.e i;
    public final com.google.android.libraries.navigation.internal.hm.h j;
    private final bn m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile CountDownLatch f455n;
    private volatile CountDownLatch o;
    private final Executor p;
    private static final com.google.android.libraries.navigation.internal.zb.j l = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.iz.n");
    static final long a = TimeUnit.SECONDS.toMillis(10);

    static {
        TimeUnit.SECONDS.toMillis(35L);
        fy.q(ce.EIT_TIMELINE_PUBLIC_URL, ce.EIT_TIMELINE_NOTIFICATION);
    }

    public n(bn bnVar, com.google.android.libraries.navigation.internal.ia.e eVar, an anVar) {
        ac acVar = ac.INSTANCE;
        this.p = acVar;
        this.i = new com.google.android.libraries.navigation.internal.hx.e(new i(this));
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MapEnvironmentImpl - startupScheduler.get()");
        try {
            this.m = bnVar;
            this.b = eVar;
            this.j = (com.google.android.libraries.navigation.internal.hm.h) anVar.f();
            this.c = new ab(acVar);
            this.d = new ab(acVar);
            this.e = new ab(acVar);
            this.f = new ab(acVar);
            this.h = new CountDownLatch(0);
            this.f455n = new CountDownLatch(0);
            this.o = new CountDownLatch(0);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private final void h(Runnable runnable, Executor executor, m mVar) {
        final l lVar = new l(runnable, executor, mVar);
        int iOrdinal = mVar.ordinal();
        if (iOrdinal == 0) {
            this.c.execute(lVar);
            return;
        }
        if (iOrdinal == 1) {
            this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.iz.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d.execute(lVar);
                }
            });
        } else if (iOrdinal == 2) {
            this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.iz.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e.execute(lVar);
                }
            });
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.f.execute(lVar);
        }
    }

    public final void a() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.unleashMapStableTasks");
        try {
            this.f.b();
        } catch (IllegalStateException unused) {
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
        if (dVarB != null) {
            Trace.endSection();
        }
        this.m.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.iz.d
            @Override // java.lang.Runnable
            public final void run() {
                int i = n.k;
                if (com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler received OnInitialLabelingComplete") != null) {
                    Trace.endSection();
                }
                ap.UI_THREAD.f();
            }
        });
    }

    final void b() {
        ap.UI_THREAD.f();
        if (com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler signaling network readiness") != null) {
            Trace.endSection();
        }
        this.g.a();
    }

    public final void c(Runnable runnable, Executor executor) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.scheduleClientParametersLoadedTask");
        try {
            h(runnable, executor, m.ON_CLIENT_PARAMETERS_LOADED);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void d(Runnable runnable, Executor executor, m mVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.schedulePostStartupTask");
        try {
            h(runnable, executor, mVar);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void e() {
        com.google.android.libraries.navigation.internal.hx.e eVar;
        f();
        g();
        b();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.unleashStartupCompleteTasks");
        try {
            ap.UI_THREAD.f();
            try {
                this.e.b();
                this.o.countDown();
                eVar = this.i;
            } catch (IllegalStateException unused) {
                this.o.countDown();
                eVar = this.i;
            } catch (Throwable th) {
                this.o.countDown();
                this.i.a();
                throw th;
            }
            eVar.a();
            if (dVarB != null) {
                Trace.endSection();
            }
            this.b.a(new c());
        } catch (Throwable th2) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public final void f() {
        CountDownLatch countDownLatch;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.unleashClientParametersLoadedTasks");
        try {
            try {
                try {
                    this.c.b();
                    countDownLatch = this.h;
                } catch (Throwable th) {
                    this.h.countDown();
                    throw th;
                }
            } catch (IllegalStateException unused) {
                countDownLatch = this.h;
            }
            countDownLatch.countDown();
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th2) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public final void g() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.unleashFirstTransitionCompleteTasks");
        try {
            ap.UI_THREAD.f();
            try {
                this.d.b();
                this.f455n.countDown();
            } catch (IllegalStateException unused) {
                this.f455n.countDown();
            } finally {
                this.f455n.countDown();
                b();
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
