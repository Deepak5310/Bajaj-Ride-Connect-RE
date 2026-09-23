package com.google.android.libraries.navigation.internal.xm;

import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.gm.an;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements com.google.android.libraries.navigation.internal.gn.m {
    private final CronetEngine a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final Executor c;

    public h(CronetEngine cronetEngine, com.google.android.libraries.navigation.internal.mj.a aVar, Executor executor) {
        this.a = cronetEngine;
        this.b = aVar;
        this.c = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.gn.m
    public final com.google.android.libraries.navigation.internal.gn.l a(cy cyVar, an anVar, com.google.android.libraries.navigation.internal.gh.d dVar) {
        return com.google.android.libraries.navigation.internal.gd.a.MAPS_MOBILE_SDKS.equals(dVar.j) ? new g(this.b, this.a, this.c, anVar) : new a();
    }
}
