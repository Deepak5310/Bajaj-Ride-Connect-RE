package com.google.android.libraries.navigation.internal.kf;

import android.content.Context;
import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public aj(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("UserEventReporterModule.getAccessibilityState");
        try {
            com.google.android.libraries.navigation.internal.zp.d dVarA = com.google.android.libraries.navigation.internal.mi.a.a(context);
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.afr.j.d(dVarA);
            return dVarA;
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
