package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cd implements Runnable {
    cf a;

    public cd(cf cfVar) {
        this.a = cfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bj bjVar;
        cf cfVar = this.a;
        if (cfVar == null || (bjVar = cfVar.a) == null) {
            return;
        }
        this.a = null;
        if (bjVar.isDone()) {
            cfVar.aA(bjVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = cfVar.b;
            cfVar.b = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    cfVar.ap(new ce(str));
                    throw th;
                }
            }
            cfVar.ap(new ce(str + ": " + bjVar.toString()));
            bjVar.cancel(true);
        } catch (Throwable th2) {
            bjVar.cancel(true);
            throw th2;
        }
    }
}
