package com.google.android.libraries.navigation.internal.abf;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements ThreadFactory {
    private final String a;
    private final AtomicInteger b = new AtomicInteger(0);
    private final int c;

    public ag(String str, int i) {
        this.a = str;
        this.c = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a + "-" + this.b.incrementAndGet());
        thread.setPriority(this.c);
        return thread;
    }
}
