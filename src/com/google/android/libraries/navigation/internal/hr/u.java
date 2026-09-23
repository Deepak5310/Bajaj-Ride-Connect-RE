package com.google.android.libraries.navigation.internal.hr;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.agl.a j;
    private final com.google.android.libraries.navigation.internal.agl.a k;
    private final com.google.android.libraries.navigation.internal.agl.a l;
    private final com.google.android.libraries.navigation.internal.agl.a m;

    public u(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.agl.a aVar11, com.google.android.libraries.navigation.internal.agl.a aVar12, com.google.android.libraries.navigation.internal.agl.a aVar13) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
        this.k = aVar11;
        this.l = aVar12;
        this.m = aVar13;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        b bVar = (b) this.a.a();
        an anVar = (an) ((com.google.android.libraries.navigation.internal.afr.g) this.b).a;
        an anVar2 = (an) ((com.google.android.libraries.navigation.internal.afr.g) this.c).a;
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.b) this.e).a();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.f.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.g);
        com.google.android.libraries.navigation.internal.afo.a aVarC2 = com.google.android.libraries.navigation.internal.afr.e.c(this.h);
        com.google.android.libraries.navigation.internal.hm.d dVar = (com.google.android.libraries.navigation.internal.hm.d) this.i.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC3 = com.google.android.libraries.navigation.internal.afr.e.c(this.j);
        com.google.android.libraries.navigation.internal.afo.a aVarC4 = com.google.android.libraries.navigation.internal.afr.e.c(this.k);
        com.google.android.libraries.navigation.internal.afo.a aVarC5 = com.google.android.libraries.navigation.internal.afr.e.c(this.l);
        com.google.android.libraries.navigation.internal.ip.a aVarA = ((com.google.android.libraries.navigation.internal.ip.b) this.m).a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("create ClientParametersUpdater");
        try {
            o oVar = new o(bVar, anVar, anVar2, bnVarA, aVar, aVarC, aVarC2, dVar, aVarC3, aVarC4, aVarC5, aVarA);
            if (dVarB != null) {
                Trace.endSection();
            }
            return oVar;
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
