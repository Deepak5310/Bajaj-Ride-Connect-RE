package com.google.android.libraries.navigation.internal.au;

import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.afr.j;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public e(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c a() {
        an anVar = (an) ((g) this.a).a;
        c cVarB = anVar.g() ? ((a) anVar.c()).b() : new c();
        j.d(cVarB);
        return cVarB;
    }
}
