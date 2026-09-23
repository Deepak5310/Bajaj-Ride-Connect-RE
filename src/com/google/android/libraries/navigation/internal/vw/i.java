package com.google.android.libraries.navigation.internal.vw;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i {
    final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    public final synchronized void a() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavGuidanceControllerImpl.onRequestDismissPromptEvent");
        try {
            com.google.android.libraries.navigation.internal.vp.i iVar = this.a.f;
            ar.q(iVar);
            iVar.a();
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
