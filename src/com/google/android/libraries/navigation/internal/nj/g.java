package com.google.android.libraries.navigation.internal.nj;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public g(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    public static bn c(an anVar, an anVar2, com.google.android.libraries.navigation.internal.agl.a aVar, Object obj) {
        ((p) obj).a();
        bn bnVar = (bn) ((com.google.android.libraries.navigation.internal.agl.a) anVar.a(anVar2).e(aVar)).a();
        com.google.android.libraries.navigation.internal.afr.j.d(bnVar);
        return bnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bn a() {
        return c((an) this.a.a(), (an) ((com.google.android.libraries.navigation.internal.afr.g) this.b).a, this.c, this.d.a());
    }
}
