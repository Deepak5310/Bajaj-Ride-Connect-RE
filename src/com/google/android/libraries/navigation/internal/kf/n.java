package com.google.android.libraries.navigation.internal.kf;

import com.google.android.libraries.navigation.internal.aac.bn;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.kf.n");
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final ScheduledExecutorService c;
    public volatile ScheduledFuture d;
    public final ConcurrentLinkedQueue e = new ConcurrentLinkedQueue();

    public n(bn bnVar, com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.c = bnVar;
        this.b = aVar;
    }
}
