package com.google.android.libraries.navigation.internal.afs;

import com.google.android.libraries.navigation.internal.aer.i;
import com.google.android.libraries.navigation.internal.gg.e;
import com.google.android.libraries.navigation.internal.gg.g;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements g {
    final com.google.android.libraries.navigation.internal.gh.d a;
    private final com.google.android.libraries.navigation.internal.afo.a b;

    public b(a aVar) {
        this.b = aVar.a;
        this.a = new com.google.android.libraries.navigation.internal.gh.d(aVar.b);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.g
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.gg.b a(Object obj, e eVar, Executor executor) {
        return ((com.google.android.libraries.navigation.internal.gg.d) this.b.a()).a((i) obj, this.a, eVar, executor);
    }
}
