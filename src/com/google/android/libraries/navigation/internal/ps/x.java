package com.google.android.libraries.navigation.internal.ps;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.po.gr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class x implements Runnable {
    public final com.google.android.libraries.navigation.internal.pb.t a;
    final /* synthetic */ y b;
    public final gr c;

    public x(y yVar, com.google.android.libraries.navigation.internal.pb.t tVar, gr grVar) {
        this.b = yVar;
        this.a = tVar;
        this.c = grVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixIndoorMapControllerImpl.CameraTrackingRunnable.run");
        try {
            this.c.d(this);
            this.b.o(this.a);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
