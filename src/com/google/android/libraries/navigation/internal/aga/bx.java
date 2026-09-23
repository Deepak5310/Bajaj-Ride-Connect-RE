package com.google.android.libraries.navigation.internal.aga;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bx implements Runnable {
    private static final Logger a = Logger.getLogger(bx.class.getName());
    private final Runnable b;

    public bx(Runnable runnable) {
        this.b = runnable;
    }

    public final String toString() {
        return "LogExceptionRunnable(" + String.valueOf(this.b) + ")";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.run();
        } catch (Throwable th) {
            a.logp(Level.SEVERE, "io.grpc.internal.LogExceptionRunnable", "run", "Exception while executing runnable ".concat(String.valueOf(String.valueOf(this.b))), th);
            com.google.android.libraries.navigation.internal.yx.bx.c(th);
            throw new AssertionError(th);
        }
    }
}
