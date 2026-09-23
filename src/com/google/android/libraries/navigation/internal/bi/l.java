package com.google.android.libraries.navigation.internal.bi;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.bp.af;
import com.google.android.libraries.navigation.internal.yx.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ m a;
    private final h b;

    public l(m mVar, h hVar) {
        this.a = mVar;
        this.b = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        this.b.a(iVar, oVar);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        mf mfVar = (mf) obj;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("RpcCallbackImpl.onSuccess()");
        try {
            ll llVar = mfVar.c;
            if (llVar == null) {
                llVar = ll.a;
            }
            if ((llVar.b & 1) != 0) {
                if (com.google.android.libraries.navigation.internal.nw.e.b("DirectionsDataExchange.logTactileResponse()") != null) {
                    Trace.endSection();
                }
                h hVar = this.b;
                final af afVar = new af(mfVar);
                hVar.b(iVar, (af) this.a.a.b(new aa() { // from class: com.google.android.libraries.navigation.internal.bi.k
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj2) {
                        return ((com.google.android.libraries.navigation.internal.az.a) obj2).a();
                    }
                }).e(afVar));
            } else {
                this.b.a(iVar, com.google.android.libraries.navigation.internal.gg.o.g);
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
}
