package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ec {
    public final ScheduledExecutorService a;
    public final Executor b;
    public final Runnable c;
    public long d;
    public boolean e;
    public ScheduledFuture f;
    private final com.google.android.libraries.navigation.internal.yx.bm g;

    public ec(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, com.google.android.libraries.navigation.internal.yx.bm bmVar) {
        this.c = runnable;
        this.b = executor;
        this.a = scheduledExecutorService;
        this.g = bmVar;
        bmVar.d();
    }

    public final long a() {
        return this.g.a(TimeUnit.NANOSECONDS);
    }
}
