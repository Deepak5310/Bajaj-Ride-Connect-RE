package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.aac.cc;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p {
    static final ScheduledExecutorService a;
    private static final ThreadFactory b;

    static {
        cc ccVar = new cc();
        ccVar.a = "RetryingFuture-Timer-%d";
        ccVar.b();
        ThreadFactory threadFactoryA = cc.a(ccVar);
        b = threadFactoryA;
        a = Executors.newSingleThreadScheduledExecutor(threadFactoryA);
    }
}
