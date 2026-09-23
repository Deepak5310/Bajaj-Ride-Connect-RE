package com.google.android.libraries.navigation.internal.xt;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class au implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.aac.bn b;
    final /* synthetic */ long c;
    final /* synthetic */ TimeUnit d;

    public au(Runnable runnable, com.google.android.libraries.navigation.internal.aac.bn bnVar, long j, TimeUnit timeUnit) {
        this.a = runnable;
        this.b = bnVar;
        this.c = j;
        this.d = timeUnit;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.run();
        ap.a(this.b.e(this, this.c, this.d));
    }
}
