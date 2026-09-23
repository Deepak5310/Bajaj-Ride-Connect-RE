package com.google.android.libraries.navigation.internal.nj;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements Thread.UncaughtExceptionHandler {
    private final com.google.android.libraries.navigation.internal.afo.a a;
    private final AtomicBoolean b = new AtomicBoolean();
    private Thread.UncaughtExceptionHandler c;

    public p(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = aVar;
    }

    final void a() {
        if (!this.b.compareAndSet(false, true) || ((Set) this.a.a()).isEmpty()) {
            return;
        }
        this.c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            for (Thread.UncaughtExceptionHandler uncaughtExceptionHandler : (Set) this.a.a()) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } catch (RuntimeException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(796)).s("Uncaught exception handler failed: %s", uncaughtExceptionHandler);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.c;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.c;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
