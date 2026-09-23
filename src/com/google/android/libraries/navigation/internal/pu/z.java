package com.google.android.libraries.navigation.internal.pu;

import com.google.android.libraries.navigation.internal.abm.Cdo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public z(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.kg.d dVar = (com.google.android.libraries.navigation.internal.kg.d) this.a.a();
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.b.a();
        com.google.android.libraries.navigation.internal.kg.c cVarA = dVar.a(com.google.android.libraries.navigation.internal.kg.b.a);
        Cdo cdo = (Cdo) anVar.f();
        if (cdo != null) {
            cVarA.a(new e(cdo));
        }
        com.google.android.libraries.navigation.internal.afr.j.d(cVarA);
        return cVarA;
    }
}
