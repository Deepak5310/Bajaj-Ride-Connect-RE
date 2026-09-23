package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bt {
    public static bn a(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof bn ? (bn) scheduledExecutorService : new bs(scheduledExecutorService);
    }

    static Executor b(Executor executor, d dVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        return executor == ac.INSTANCE ? executor : new bo(executor, dVar);
    }
}
