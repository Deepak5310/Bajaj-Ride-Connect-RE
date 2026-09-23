package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs extends bp implements bn {
    final ScheduledExecutorService a;

    public bs(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        com.google.android.libraries.navigation.internal.yx.ar.q(scheduledExecutorService);
        this.a = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: e */
    public final bl schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.a;
        ci ciVarF = ci.f(runnable, null);
        return new bq(ciVarF, scheduledExecutorService.schedule(ciVarF, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: f */
    public final bl schedule(Callable callable, long j, TimeUnit timeUnit) {
        ci ciVar = new ci(callable);
        return new bq(ciVar, this.a.schedule(ciVar, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: g */
    public final bl scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        br brVar = new br(runnable);
        return new bq(brVar, this.a.scheduleAtFixedRate(brVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        br brVar = new br(runnable);
        return new bq(brVar, this.a.scheduleWithFixedDelay(brVar, j, j2, timeUnit));
    }
}
