package com.google.android.libraries.navigation.internal.gq;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y implements com.google.android.libraries.navigation.internal.gg.g {
    final com.google.android.libraries.navigation.internal.gh.d a;
    private final com.google.android.libraries.navigation.internal.afo.a b;

    public y(x xVar) {
        this.b = xVar.a;
        this.a = new com.google.android.libraries.navigation.internal.gh.d(xVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.g
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.gg.b a(Object obj, com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor) {
        return ((com.google.android.libraries.navigation.internal.gg.d) this.b.a()).a((com.google.android.libraries.navigation.internal.adi.aj) obj, this.a, eVar, executor);
    }
}
