package com.google.android.libraries.navigation.internal.le;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bf implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.md.m a;
    final /* synthetic */ bg b;

    public bf(bg bgVar, com.google.android.libraries.navigation.internal.md.m mVar) {
        this.a = mVar;
        this.b = bgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.md.m mVar = this.a;
        com.google.android.libraries.navigation.internal.lc.a aVar = mVar.b;
        boolean zC = aVar.c();
        bg bgVar = this.b;
        if (zC) {
            com.google.android.libraries.navigation.internal.lh.bi biVar = mVar.c;
            com.google.android.libraries.navigation.internal.lh.be.j(biVar);
            com.google.android.libraries.navigation.internal.lc.a aVar2 = biVar.c;
            if (!aVar2.c()) {
                new Exception();
                bgVar.g.b(aVar2);
                bgVar.f.i();
                return;
            }
            ah ahVar = bgVar.g;
            com.google.android.libraries.navigation.internal.lh.al alVarA = biVar.a();
            Set set = bgVar.d;
            if (alVarA == null || set == null) {
                new Exception();
                ahVar.b(new com.google.android.libraries.navigation.internal.lc.a(4));
            } else {
                ahVar.c = alVarA;
                ahVar.d = set;
                ahVar.c();
            }
        } else {
            bgVar.g.b(aVar);
        }
        bgVar.f.i();
    }
}
