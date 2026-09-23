package com.google.android.libraries.navigation.internal.ta;

import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public j(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.sv.o oVar = (com.google.android.libraries.navigation.internal.sv.o) this.a.a();
        com.google.android.libraries.geo.navcore.service.base.k kVar = (com.google.android.libraries.geo.navcore.service.base.k) this.b.a();
        fw fwVar = new fw();
        fwVar.c(oVar);
        fwVar.c(kVar);
        fy fyVarI = fwVar.i();
        com.google.android.libraries.navigation.internal.afr.j.d(fyVarI);
        return fyVarI;
    }
}
