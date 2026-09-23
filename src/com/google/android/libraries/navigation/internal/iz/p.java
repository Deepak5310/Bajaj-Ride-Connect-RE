package com.google.android.libraries.navigation.internal.iz;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends com.google.android.libraries.navigation.internal.ia.k {
    public p(Class cls, n nVar, ap apVar) {
        super(cls, nVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        n nVar = (n) this.c;
        if (com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler received OnFragmentTransitionComplete") != null) {
            Trace.endSection();
        }
        nVar.g();
        nVar.e();
        if (com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.onFragmentTransitionComplete - unleashStartupCompleteTasks") != null) {
            Trace.endSection();
        }
        nVar.b.a(new a());
    }
}
