package com.google.android.libraries.navigation.internal.aac;

import com.google.maps.android.BuildConfig;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class by implements Runnable {
    Runnable a;
    final /* synthetic */ bz b;

    public by(bz bzVar) {
        this.b = bzVar;
    }

    public final String toString() {
        String str;
        Runnable runnable = this.a;
        if (runnable != null) {
            return com.google.android.libraries.navigation.internal.b.b.n(runnable, "SequentialExecutorWorker{running=", "}");
        }
        int i = this.b.d;
        if (i == 1) {
            str = "IDLE";
        } else if (i == 2) {
            str = "QUEUING";
        } else if (i != 3) {
            str = i != 4 ? BuildConfig.TRAVIS : DebugCoroutineInfoImplKt.RUNNING;
        } else {
            str = "QUEUED";
        }
        return com.google.android.libraries.navigation.internal.b.b.g(str, "SequentialExecutorWorker{state=", "}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r1 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r11.a.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        r11.a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        com.google.android.libraries.navigation.internal.aac.bz.a.a().logp(java.util.logging.Level.SEVERE, "com.google.common.util.concurrent.SequentialExecutor$QueueWorker", "workOnQueue", "Exception while executing runnable " + java.lang.String.valueOf(r11.a), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        r11.a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
    
        r11.a = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z = false;
        boolean zInterrupted = false;
        while (true) {
            try {
                try {
                    synchronized (this.b.b) {
                        if (!z) {
                            if (this.b.d != 4) {
                                bz bzVar = this.b;
                                bzVar.c++;
                                bzVar.d = 4;
                            }
                        }
                        Runnable runnable = (Runnable) this.b.b.poll();
                        this.a = runnable;
                        if (runnable == null) {
                            this.b.d = 1;
                        }
                    }
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                    z = true;
                } catch (Throwable th) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (Error e) {
                synchronized (this.b.b) {
                    this.b.d = 1;
                    throw e;
                }
            }
        }
    }
}
