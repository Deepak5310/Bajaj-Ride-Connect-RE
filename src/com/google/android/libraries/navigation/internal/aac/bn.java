package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface bn extends ScheduledExecutorService, bm {
    bl e(Runnable runnable, long j, TimeUnit timeUnit);

    bl f(Callable callable, long j, TimeUnit timeUnit);

    bl g(Runnable runnable, long j, long j2, TimeUnit timeUnit);
}
