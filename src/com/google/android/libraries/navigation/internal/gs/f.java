package com.google.android.libraries.navigation.internal.gs;

import com.google.android.libraries.navigation.internal.acd.ub;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.gg.g {
    final com.google.android.libraries.navigation.internal.gh.d a;
    private final com.google.android.libraries.navigation.internal.afo.a b;

    public f(e eVar) {
        this.b = eVar.a;
        this.a = new com.google.android.libraries.navigation.internal.gh.d(eVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.g
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.gg.b a(Object obj, com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor) {
        return ((com.google.android.libraries.navigation.internal.gg.d) this.b.a()).a((ub) obj, this.a, eVar, executor);
    }
}
