package com.google.android.libraries.navigation.internal.pu;

import android.content.Context;
import com.google.android.libraries.navigation.internal.afl.pw;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;

    public be(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.fq.f fVar = (com.google.android.libraries.navigation.internal.fq.f) this.a.a();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.b.a();
        final Context context = (Context) this.c.a();
        com.google.android.libraries.navigation.internal.agl.a aVar2 = this.e;
        final com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.d);
        final com.google.android.libraries.navigation.internal.afo.a aVarC2 = com.google.android.libraries.navigation.internal.afr.e.c(aVar2);
        return new com.google.android.libraries.navigation.internal.qf.d(fVar, aVar, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pu.ax
            /* JADX WARN: Code duplicated, block: B:12:0x002c  */
            /* JADX WARN: Code duplicated, block: B:9:0x001d  */
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.fr.k kVar = com.google.android.libraries.navigation.internal.fr.l.a;
                boolean z = true;
                if (com.google.android.libraries.navigation.internal.fr.k.a(context)) {
                    pw pwVar = ((qj) aVarC.a()).l;
                    if (pwVar == null) {
                        pwVar = pw.a;
                    }
                    if (!pwVar.b) {
                        if (!((com.google.android.libraries.navigation.internal.hn.p) aVarC2.a()).n()) {
                            z = false;
                        }
                    }
                } else if (!((com.google.android.libraries.navigation.internal.hn.p) aVarC2.a()).n()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }));
    }
}
