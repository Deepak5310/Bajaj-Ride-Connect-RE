package com.google.android.libraries.navigation.internal.pu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public bj(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.om.p pVarA;
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        com.google.android.libraries.navigation.internal.yx.an anVar2 = (com.google.android.libraries.navigation.internal.yx.an) this.b.a();
        com.google.android.libraries.navigation.internal.yx.an anVar3 = (com.google.android.libraries.navigation.internal.yx.an) this.c.a();
        if (anVar.g()) {
            pVarA = (com.google.android.libraries.navigation.internal.om.p) anVar.c();
        } else if (anVar2.g()) {
            pVarA = ((com.google.android.libraries.navigation.internal.om.o) anVar2.c()).a();
        } else {
            if (!anVar3.g()) {
                throw new IllegalStateException("No MapSettings bound");
            }
            pVarA = ((com.google.android.libraries.navigation.internal.om.q) anVar3.c()).a();
        }
        com.google.android.libraries.navigation.internal.afr.j.d(pVarA);
        return pVarA;
    }
}
