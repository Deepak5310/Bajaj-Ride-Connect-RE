package com.google.android.libraries.navigation.internal.pu;

import com.google.android.libraries.navigation.internal.afl.pw;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.ho.ct;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh implements com.google.android.libraries.navigation.internal.afr.f {
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

    public bh(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10) {
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
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.a.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.c);
        com.google.android.libraries.navigation.internal.afo.a aVarC2 = com.google.android.libraries.navigation.internal.afr.e.c(this.d);
        com.google.android.libraries.navigation.internal.afo.a aVarC3 = com.google.android.libraries.navigation.internal.afr.e.c(this.e);
        com.google.android.libraries.navigation.internal.aac.bn bnVarA = ((com.google.android.libraries.navigation.internal.hy.ac) this.f).a();
        com.google.android.libraries.navigation.internal.aac.bn bnVarA2 = ((com.google.android.libraries.navigation.internal.nj.b) this.g).a();
        com.google.android.libraries.navigation.internal.afo.a aVarC4 = com.google.android.libraries.navigation.internal.afr.e.c(this.h);
        final qj qjVarA = ((ct) this.i).a();
        com.google.android.libraries.navigation.internal.pm.d dVar = (com.google.android.libraries.navigation.internal.pm.d) this.j.a();
        pw pwVar = qjVarA.l;
        if (pwVar == null) {
            pwVar = pw.a;
        }
        Objects.requireNonNull(qjVarA);
        return new com.google.android.libraries.navigation.internal.qu.bg(aVar, aVarC, aVarC2, aVarC3, bnVarA, bnVarA2, aVarC4, pwVar, new br() { // from class: com.google.android.libraries.navigation.internal.pu.ay
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Integer.valueOf(qjVarA.z);
            }
        }, dVar);
    }
}
