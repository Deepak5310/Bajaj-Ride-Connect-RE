package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al {
    private final fd a;

    public al(fd fdVar) {
        this.a = fdVar;
    }

    public final com.google.android.libraries.navigation.internal.op.l a(com.google.android.libraries.navigation.internal.rf.g gVar, com.google.android.libraries.navigation.internal.op.g gVar2, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        com.google.android.libraries.navigation.internal.op.l lVar;
        ay ayVarF;
        com.google.android.libraries.navigation.internal.op.j jVar = (com.google.android.libraries.navigation.internal.op.j) this.a.get(gVar2);
        if (jVar == null || (lVar = (com.google.android.libraries.navigation.internal.op.l) jVar.b().get(bVar)) == null || (ayVarF = gVar.f(xVar)) == null) {
            return null;
        }
        float f = ayVarF.b;
        float f2 = ayVarF.c;
        return new com.google.android.libraries.navigation.internal.op.d(lVar.b() + f, lVar.d() + f2, lVar.c() + f, lVar.a() + f2);
    }
}
