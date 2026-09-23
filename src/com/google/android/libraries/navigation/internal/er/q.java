package com.google.android.libraries.navigation.internal.er;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.db.at;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class q implements com.google.android.libraries.navigation.internal.es.b {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.er.q");
    public final br a;
    public final com.google.android.libraries.navigation.internal.eu.a b;
    private final com.google.android.libraries.navigation.internal.wt.m d;
    private final s e;

    public q(s sVar, com.google.android.libraries.navigation.internal.wt.m mVar, br brVar, com.google.android.libraries.navigation.internal.eu.a aVar) {
        this.e = sVar;
        this.d = mVar;
        this.a = brVar;
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.es.b
    public final com.google.android.libraries.navigation.internal.gg.b a(final lz lzVar, com.google.android.libraries.navigation.internal.gh.d dVar, com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor) {
        final br brVar = new br() { // from class: com.google.android.libraries.navigation.internal.er.l
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.apps.gmm.offline.routing.e eVar2 = (com.google.android.apps.gmm.offline.routing.e) this.a.a.a();
                Objects.requireNonNull(eVar2);
                return new j(eVar2);
            }
        };
        final dg dgVar = (dg) mf.a.aH(7, null);
        s sVar = this.e;
        final com.google.android.libraries.navigation.internal.aco.b bVarA = s.a(sVar.a, ((com.google.android.libraries.navigation.internal.cw.a) sVar.c.a()).b(), sVar.b.g());
        com.google.android.libraries.navigation.internal.gg.h hVar = new com.google.android.libraries.navigation.internal.gg.h();
        hVar.a = lzVar;
        hVar.c = dVar.f;
        hVar.e = new com.google.android.libraries.navigation.internal.gg.n(null);
        hVar.a(1);
        com.google.android.libraries.navigation.internal.aes.h hVar2 = bVarA.e;
        if (hVar2 == null) {
            hVar2 = com.google.android.libraries.navigation.internal.aes.h.a;
        }
        com.google.android.libraries.navigation.internal.wt.m mVar = this.d;
        hVar.d = new at(hVar2);
        com.google.android.libraries.navigation.internal.gg.i iVar = new com.google.android.libraries.navigation.internal.gg.i(hVar);
        bj bjVarA = mVar.a("getDirections", new com.google.android.libraries.navigation.internal.wt.l() { // from class: com.google.android.libraries.navigation.internal.er.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                cy cyVar = lzVar;
                com.google.android.libraries.navigation.internal.aco.b bVar = bVarA;
                byte[] bArrA = ((j) brVar.a()).a(bVar.m(), cyVar.m());
                dg dgVar2 = dgVar;
                if (bArrA == null) {
                    throw new p(com.google.android.libraries.navigation.internal.gg.o.l);
                }
                try {
                    return dgVar2.i(bArrA, ar.b());
                } catch (cc e) {
                    throw new p(com.google.android.libraries.navigation.internal.gg.o.g.c(e));
                }
            }
        });
        com.google.android.libraries.navigation.internal.yu.c.d(bjVarA, new n(this, lzVar, eVar, iVar, mVar), executor);
        return new o(bjVarA);
    }
}
