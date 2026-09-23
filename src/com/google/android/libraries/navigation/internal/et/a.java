package com.google.android.libraries.navigation.internal.et;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.wt.g;
import com.google.android.libraries.navigation.internal.wt.h;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public a(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.b) this.a).a();
        g gVar = new g();
        gVar.c = bnVarA;
        gVar.b(1);
        gVar.a = h.LIFO;
        gVar.c();
        return gVar.a();
    }
}
