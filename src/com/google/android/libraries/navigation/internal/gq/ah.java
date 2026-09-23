package com.google.android.libraries.navigation.internal.gq;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah implements com.google.android.libraries.navigation.internal.gg.g {
    final com.google.android.libraries.navigation.internal.gh.d a;
    private final com.google.android.libraries.navigation.internal.afo.a b;

    public ah(ag agVar) {
        this.b = agVar.a;
        this.a = new com.google.android.libraries.navigation.internal.gh.d(agVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.g
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.gg.b a(Object obj, com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor) {
        return ((com.google.android.libraries.navigation.internal.gg.d) this.b.a()).a((com.google.android.libraries.navigation.internal.afm.af) obj, this.a, eVar, executor);
    }
}
