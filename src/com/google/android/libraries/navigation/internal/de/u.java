package com.google.android.libraries.navigation.internal.de;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u extends TimerTask {
    final /* synthetic */ v a;

    public u(v vVar) {
        this.a = vVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        long j = this.a.O.get();
        if (j > 0) {
            v vVar = this.a;
            vVar.R = vVar.g();
            long j2 = 500 + j;
            if (this.a.O.compareAndSet(j, j2)) {
                this.a.M.schedule(this, Math.max(0L, j2 - this.a.P.f().toEpochMilli()), TimeUnit.MILLISECONDS);
            }
        }
    }
}
