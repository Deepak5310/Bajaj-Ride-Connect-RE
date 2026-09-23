package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ea implements Runnable {
    final /* synthetic */ ec a;

    public ea(ec ecVar) {
        this.a = ecVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ec ecVar = this.a;
        if (!ecVar.e) {
            ecVar.f = null;
            return;
        }
        long jA = ecVar.a();
        ec ecVar2 = this.a;
        if (ecVar2.d - jA > 0) {
            ecVar2.f = ecVar2.a.schedule(new eb(ecVar2), this.a.d - jA, TimeUnit.NANOSECONDS);
            return;
        }
        ecVar2.e = false;
        ecVar2.f = null;
        ecVar2.c.run();
    }
}
