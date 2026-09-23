package com.google.android.libraries.navigation.internal.aga;

import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cb implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ cr a;

    public cb(cr crVar) {
        this.a = crVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        cr.a.logp(Level.SEVERE, "io.grpc.internal.ManagedChannelImpl$3", "uncaughtException", "[" + String.valueOf(this.a.f) + "] Uncaught exception in the SynchronizationContext. Panic!", th);
        cr crVar = this.a;
        if (crVar.q) {
            return;
        }
        crVar.q = true;
        try {
            crVar.c(true);
            crVar.g(false);
        } finally {
            crVar.h(new com.google.android.libraries.navigation.internal.afx.aq(com.google.android.libraries.navigation.internal.afx.as.a(com.google.android.libraries.navigation.internal.afx.cl.e.b("Panic! This is a bug!").a(th))));
            crVar.A.b(null);
            crVar.y.a(4, "PANIC! Entering TRANSIENT_FAILURE");
            crVar.l.a(com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE);
        }
    }
}
