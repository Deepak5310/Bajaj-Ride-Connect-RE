package com.google.android.libraries.navigation.internal.qu;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements Runnable {
    private final String a;
    private final k b;
    private final Runnable c;

    public j(k kVar, String str, Runnable runnable) {
        this.b = kVar;
        this.a = str;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b(this.a);
        try {
            this.b.c.lock();
            try {
                this.c.run();
                this.b.c.unlock();
                if (dVarB != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                this.b.c.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
