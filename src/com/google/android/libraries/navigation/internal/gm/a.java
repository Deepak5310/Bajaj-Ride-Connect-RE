package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.gh.e {
    private final com.google.android.libraries.navigation.internal.afo.a a;

    public a(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final synchronized bj a() {
        com.google.android.libraries.navigation.internal.gh.b bVarB;
        bVarB = b();
        com.google.android.libraries.navigation.internal.yx.ar.q(bVarB);
        return az.h(bVarB);
    }

    public final synchronized com.google.android.libraries.navigation.internal.gh.b b() {
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.a.a();
        if (!anVar.g()) {
            return null;
        }
        return new com.google.android.libraries.navigation.internal.gh.a("AdSpamEssentialCookie", ((com.google.android.libraries.navigation.internal.h.a) anVar.c()).a());
    }
}
