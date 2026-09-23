package com.google.android.libraries.navigation.internal.iz;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public o(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        final n nVar = new n(((com.google.android.libraries.navigation.internal.nj.h) this.a).a(), (com.google.android.libraries.navigation.internal.ia.e) this.b.a(), (an) this.c.a());
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MapEnvironmentImpl - startupScheduler.init");
        try {
            if (nVar.h.getCount() == 0) {
                nVar.c.a();
                nVar.h = new CountDownLatch(1);
            }
            nVar.f.a();
            com.google.android.libraries.navigation.internal.ia.e eVar = nVar.b;
            fz fzVar = new fz();
            fzVar.b(b.class, new p(b.class, nVar, ap.UI_THREAD));
            eVar.c(nVar, fzVar.a());
            com.google.android.libraries.navigation.internal.hm.h hVar = nVar.j;
            if (hVar != null) {
                hVar.b().l(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.iz.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        n nVar2 = nVar;
                        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler.onClientParametersUpdated");
                        try {
                            if (com.google.android.libraries.navigation.internal.nw.e.b("StartupScheduler received ClientParameters update") != null) {
                                Trace.endSection();
                            }
                            nVar2.f();
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            if (dVarB2 != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                }), ac.INSTANCE);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return nVar;
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
