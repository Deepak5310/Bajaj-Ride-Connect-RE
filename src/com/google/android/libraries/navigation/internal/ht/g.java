package com.google.android.libraries.navigation.internal.ht;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public g(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        an anVar = (an) this.a.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.b);
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.c.a();
        Set setA = ((com.google.android.libraries.navigation.internal.afr.p) this.d).a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("create ClientParametersBlockingReference");
        try {
            com.google.android.libraries.navigation.internal.hm.d dVar = new com.google.android.libraries.navigation.internal.hm.d((com.google.android.libraries.navigation.internal.afo.a) anVar.e(com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.ht.e
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return new com.google.android.libraries.navigation.internal.hp.h();
                }
            })), aVarC, aVar, setA);
            if (dVarB != null) {
                Trace.endSection();
            }
            return dVar;
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
