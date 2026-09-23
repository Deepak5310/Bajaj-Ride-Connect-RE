package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cf extends am {
    public bj a;
    public ScheduledFuture b;

    public cf(bj bjVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bjVar);
        this.a = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        bj bjVar = this.a;
        ScheduledFuture scheduledFuture = this.b;
        if (bjVar == null) {
            return null;
        }
        String strN = com.google.android.libraries.navigation.internal.b.b.n(bjVar, "inputFuture=[", "]");
        if (scheduledFuture == null) {
            return strN;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return strN;
        }
        return strN + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        o(this.a);
        ScheduledFuture scheduledFuture = this.b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.a = null;
        this.b = null;
    }
}
