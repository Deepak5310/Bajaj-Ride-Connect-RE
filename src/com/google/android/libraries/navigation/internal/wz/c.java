package com.google.android.libraries.navigation.internal.wz;

import com.google.android.libraries.navigation.internal.fq.d;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private final com.google.android.libraries.navigation.internal.xb.b a;

    public c() {
        this((ThreadFactory) null);
    }

    public final synchronized void a(d dVar) {
        this.a.b(dVar);
    }

    public final synchronized void b(d dVar) {
        this.a.c(dVar);
    }

    public c(ScheduledExecutorService scheduledExecutorService) {
        new com.google.android.libraries.navigation.internal.xb.a(scheduledExecutorService);
        this.a = new com.google.android.libraries.navigation.internal.xb.b(scheduledExecutorService);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        if (threadFactory == null) {
            scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        } else {
            scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(threadFactory);
        }
        this(scheduledExecutorServiceNewSingleThreadScheduledExecutor);
    }
}
