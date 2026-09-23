package com.google.android.libraries.navigation.internal.eo;

import androidx.tracing.Trace;
import com.google.android.apps.gmm.offline.routing.OfflineReroutingController;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public b(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.apps.gmm.offline.routing.c cVar = (com.google.android.apps.gmm.offline.routing.c) this.a.a();
        final OfflineReroutingController offlineReroutingController = new OfflineReroutingController(cVar.a);
        cVar.b.execute(new Runnable() { // from class: com.google.android.apps.gmm.offline.routing.b
            @Override // java.lang.Runnable
            public final void run() {
                OfflineReroutingController offlineReroutingController2 = offlineReroutingController;
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("OfflineReroutingControllerFactory.performExpensiveInitialization");
                try {
                    if (!offlineReroutingController2.a) {
                        offlineReroutingController2.a = true;
                        long j = offlineReroutingController2.b;
                        byte[] bArr = i.a;
                        try {
                            offlineReroutingController2.nativePerformExpensiveInitialization(j);
                        } catch (com.google.android.apps.gmm.jni.util.c e) {
                            i.a(e);
                        }
                    }
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
        });
        return offlineReroutingController;
    }
}
