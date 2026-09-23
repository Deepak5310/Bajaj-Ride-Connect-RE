package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.gh.e {
    private final com.google.android.libraries.navigation.internal.afo.a a;

    public c(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final synchronized bj a() {
        return az.h(b());
    }

    public final synchronized com.google.android.libraries.navigation.internal.gh.b b() {
        com.google.android.libraries.navigation.internal.g.a aVar;
        aVar = (com.google.android.libraries.navigation.internal.g.a) ((com.google.android.libraries.navigation.internal.yx.an) this.a.a()).f();
        return new com.google.android.libraries.navigation.internal.gh.a("AdvertisingId", aVar == null ? "" : com.google.android.libraries.navigation.internal.yx.aq.b(aVar.a()));
    }
}
