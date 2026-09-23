package com.google.android.libraries.navigation.internal.afx;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cp {
    private final co a;
    private final ScheduledFuture b;

    public cp(co coVar, ScheduledFuture scheduledFuture) {
        this.a = coVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(scheduledFuture, "future");
        this.b = scheduledFuture;
    }

    public final void a() {
        this.a.b = true;
        this.b.cancel(false);
    }

    public final boolean b() {
        co coVar = this.a;
        return (coVar.c || coVar.b) ? false : true;
    }
}
