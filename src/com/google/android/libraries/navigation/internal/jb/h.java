package com.google.android.libraries.navigation.internal.jb;

import com.google.android.libraries.navigation.internal.afl.ab;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public h(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        int i = ab.f;
        Long lA = d.a();
        if (lA.equals(c.a)) {
            lA = c.b;
        }
        Long l = lA;
        g gVarG = g.g("24.50.00.719446310");
        a aVar = (a) g.g("6.1.0");
        return new c(i, an.j(aVar.a), aVar.b, ((a) gVarG).a, l);
    }
}
