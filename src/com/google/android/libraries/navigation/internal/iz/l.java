package com.google.android.libraries.navigation.internal.iz;

import androidx.tracing.Trace;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements Runnable {
    public final Runnable a;
    public final m b;
    private final Executor c;

    public l(Runnable runnable, Executor executor, m mVar) {
        this.a = runnable;
        this.b = mVar;
        this.c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.iz.k
            @Override // java.lang.Runnable
            public final void run() {
                int i = n.k;
                l lVar = this.a;
                final Runnable runnable = lVar.a;
                final m mVar = lVar.b;
                com.google.android.libraries.navigation.internal.nw.d dVarA = com.google.android.libraries.navigation.internal.nw.e.a(new com.google.android.libraries.navigation.internal.nw.c() { // from class: com.google.android.libraries.navigation.internal.iz.g
                    @Override // com.google.android.libraries.navigation.internal.nw.c
                    public final com.google.android.libraries.navigation.internal.xn.a a() {
                        int i2 = n.k;
                        return com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.c("Running post-startup task ", runnable.getClass()), com.google.android.libraries.navigation.internal.xn.a.f(" on ", mVar));
                    }
                });
                try {
                    runnable.run();
                    if (dVarA != null) {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (dVarA != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        });
    }
}
