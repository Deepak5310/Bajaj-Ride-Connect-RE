package com.google.android.libraries.navigation.internal.er;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.afl.gv;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.es.a {
    public final br a;
    private final com.google.android.libraries.navigation.internal.wt.m b;

    public c(com.google.android.libraries.navigation.internal.wt.m mVar, br brVar) {
        this.b = mVar;
        this.a = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.es.a
    public final bj a(final com.google.android.libraries.navigation.internal.aco.b bVar, final gv gvVar, final lz lzVar, final mf mfVar, final int i) {
        return com.google.android.libraries.navigation.internal.yu.a.b(this.b.a("getReroute", new com.google.android.libraries.navigation.internal.wt.l() { // from class: com.google.android.libraries.navigation.internal.er.a
            @Override // java.util.concurrent.Callable
            public final Object call() throws com.google.android.libraries.navigation.internal.eq.a {
                Object obj = ((bv) this.a.a).a;
                mf mfVar2 = mfVar;
                lz lzVar2 = lzVar;
                byte[] bArrF = ((com.google.android.apps.gmm.offline.routing.l) obj).f(bVar.m(), gvVar.m(), lzVar2.m(), mfVar2.m(), i);
                if (bArrF == null) {
                    throw new com.google.android.libraries.navigation.internal.eq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, "null response from backend");
                }
                try {
                    bi biVarV = bi.v(mf.a, bArrF, 0, bArrF.length, ar.b());
                    bi.I(biVarV);
                    return (mf) biVarV;
                } catch (cc e) {
                    throw new com.google.android.libraries.navigation.internal.eq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, e);
                }
            }
        })).a(com.google.android.libraries.navigation.internal.wt.i.class, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.er.b
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) throws com.google.android.libraries.navigation.internal.eq.a {
                throw new com.google.android.libraries.navigation.internal.eq.a(com.google.android.libraries.navigation.internal.aei.a.UNAVAILABLE, "too busy");
            }
        }, this.b.a);
    }
}
