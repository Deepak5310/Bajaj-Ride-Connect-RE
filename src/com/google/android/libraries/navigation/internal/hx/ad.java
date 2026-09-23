package com.google.android.libraries.navigation.internal.hx;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import j$.time.Duration;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad extends b {
    public static final /* synthetic */ int h = 0;
    private static final Duration i = Duration.ofSeconds(5);
    final ThreadPoolExecutor f;
    public final com.google.android.libraries.navigation.internal.xn.a g;

    /* JADX WARN: Illegal instructions before constructor call */
    public ad(ap apVar, com.google.android.libraries.navigation.internal.mj.a aVar, ScheduledExecutorService scheduledExecutorService) {
        String str = apVar.N;
        apVar.b();
        super(str, apVar.a(), aVar, scheduledExecutorService);
        int iA = apVar.a();
        ar.a(iA > 0);
        this.g = com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.d("Queue-"), apVar.O);
        ac acVar = new ac(this, iA, iA, i.toMillis(), TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new w(apVar));
        this.f = acVar;
        acVar.allowCoreThreadTimeOut(iA > 1);
    }

    public static void q(com.google.android.libraries.navigation.internal.xn.a aVar, ThreadPoolExecutor threadPoolExecutor) {
        com.google.android.libraries.navigation.internal.nw.e.g(aVar, threadPoolExecutor.getQueue().size());
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b
    protected final c a() {
        ThreadPoolExecutor threadPoolExecutor = this.f;
        return new c(threadPoolExecutor.getActiveCount(), threadPoolExecutor.getPoolSize(), threadPoolExecutor.getMaximumPoolSize(), threadPoolExecutor.getQueue().size());
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b
    protected final void h(b.a aVar) {
        this.f.execute(aVar);
        q(this.g, this.f);
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b, java.util.concurrent.ExecutorService
    public final void shutdown() {
        super.l();
        this.f.shutdown();
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b, java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        ThreadPoolExecutor threadPoolExecutor = this.f;
        List listShutdownNow = super.shutdownNow();
        List<Runnable> listShutdownNow2 = threadPoolExecutor.shutdownNow();
        eq eqVar = new eq();
        eqVar.j(listShutdownNow2);
        eqVar.j(listShutdownNow);
        return eqVar.g();
    }
}
