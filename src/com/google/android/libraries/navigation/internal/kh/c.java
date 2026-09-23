package com.google.android.libraries.navigation.internal.kh;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends p {
    private final com.google.android.libraries.navigation.internal.afo.a a;

    public c(com.google.android.libraries.navigation.internal.di.b bVar, com.google.android.libraries.navigation.internal.afo.a aVar) {
        super(bVar);
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kh.p
    protected final void a(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.ke.c cVar, y yVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClearcutLoggingClient.process");
        try {
            if (aq.c(com.google.android.libraries.navigation.internal.hj.c.a.a())) {
                i(iVar, cVar, yVar);
            } else {
                b(new b(iVar, ev.q(cVar), yVar));
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.kh.p
    protected final void b(o oVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClearcutLoggingClient.send");
        try {
            no it2 = ((b) oVar).b.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.kl.b) this.a.a()).k();
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

    @Override // com.google.android.libraries.navigation.internal.kh.p
    protected final boolean c() {
        return false;
    }
}
