package com.google.android.libraries.navigation.internal.pu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public ac(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        com.google.android.libraries.navigation.internal.pi.s sVar = (com.google.android.libraries.navigation.internal.pi.s) this.b.a();
        return anVar.g() ? ((com.google.android.libraries.navigation.internal.oo.c) anVar.c()).a(sVar) : new com.google.android.libraries.navigation.internal.u.f(sVar);
    }
}
