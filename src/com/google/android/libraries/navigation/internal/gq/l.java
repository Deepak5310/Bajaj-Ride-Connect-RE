package com.google.android.libraries.navigation.internal.gq;

import com.google.android.libraries.navigation.internal.afl.lz;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements com.google.android.libraries.navigation.internal.gg.g {
    final com.google.android.libraries.navigation.internal.gh.d a;
    private final com.google.android.libraries.navigation.internal.afo.a b;

    public l(k kVar) {
        this.b = kVar.a;
        this.a = new com.google.android.libraries.navigation.internal.gh.d(kVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.g
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.gg.b a(Object obj, com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor) {
        return ((com.google.android.libraries.navigation.internal.gg.d) this.b.a()).a((lz) obj, this.a, eVar, executor);
    }
}
