package com.google.android.libraries.navigation.internal.pu;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;

    public ab(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a;
        Context context = (Context) ((com.google.android.libraries.navigation.internal.afr.g) this.b).a;
        Object hVar = anVar.g() ? (com.google.android.libraries.navigation.internal.pn.j) anVar.c() : new com.google.android.libraries.navigation.internal.ri.h((com.google.android.libraries.navigation.internal.qj.a) this.c.a(), (com.google.android.libraries.navigation.internal.ri.i) ((com.google.android.libraries.navigation.internal.yx.an) ((com.google.android.libraries.navigation.internal.afr.g) this.d).a).e(new com.google.android.libraries.navigation.internal.ri.i()), (com.google.android.libraries.navigation.internal.oq.d) this.e.a(), context.getResources().getDisplayMetrics().density);
        com.google.android.libraries.navigation.internal.afr.j.d(hVar);
        return hVar;
    }
}
