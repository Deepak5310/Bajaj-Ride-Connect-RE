package com.google.android.libraries.navigation.internal.gl;

import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.gm.an;
import com.google.android.libraries.navigation.internal.gn.l;
import com.google.android.libraries.navigation.internal.gn.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements m {
    private final com.google.android.libraries.navigation.internal.afo.a a;
    private final Executor b;

    public c(com.google.android.libraries.navigation.internal.afo.a aVar, Executor executor) {
        this.a = aVar;
        this.b = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.gn.m
    public final l a(cy cyVar, an anVar, com.google.android.libraries.navigation.internal.gh.d dVar) {
        return new b(cyVar, dVar, this.a, anVar, this.b);
    }
}
