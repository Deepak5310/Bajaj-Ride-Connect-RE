package com.google.android.libraries.navigation.internal.pu;

import com.google.android.libraries.geo.mapcore.renderer.dw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public bc(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        Object dwVar = anVar.g() ? (com.google.android.libraries.geo.mapcore.renderer.ai) anVar.c() : new dw();
        com.google.android.libraries.navigation.internal.afr.j.d(dwVar);
        return dwVar;
    }
}
