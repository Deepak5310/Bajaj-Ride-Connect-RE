package com.google.android.libraries.navigation.internal.gr;

import com.google.android.libraries.navigation.internal.gg.g;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements g {
    final com.google.android.libraries.navigation.internal.gh.d a;
    private final com.google.android.libraries.navigation.internal.afo.a b;

    public c(b bVar) {
        this.b = bVar.a;
        this.a = new com.google.android.libraries.navigation.internal.gh.d(bVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.g
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.gg.b a(Object obj, com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor) {
        return ((com.google.android.libraries.navigation.internal.gg.d) this.b.a()).a((com.google.android.libraries.navigation.internal.gj.d) obj, this.a, eVar, executor);
    }
}
