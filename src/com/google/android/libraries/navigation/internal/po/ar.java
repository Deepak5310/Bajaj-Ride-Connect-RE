package com.google.android.libraries.navigation.internal.po;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ar implements Runnable {
    final /* synthetic */ ay a;

    public ar(ay ayVar) {
        this.a = ayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("scheduleCameraAndRequestRenderRunnable.run");
        try {
            ay ayVar = this.a;
            ayVar.y.d(ayVar.x);
            this.a.y.b();
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
