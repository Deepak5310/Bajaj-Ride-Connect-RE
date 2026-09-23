package com.google.android.libraries.navigation.internal.gp;

import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements com.google.android.libraries.navigation.internal.gn.m {
    private final g a;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final com.google.android.libraries.navigation.internal.mj.a d;
    private final com.google.android.libraries.navigation.internal.kl.a e;
    private final com.google.android.libraries.navigation.internal.kl.c f;
    private final Executor g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final String i;
    private final com.google.android.libraries.navigation.internal.in.b j;
    private final an k;

    public r(g gVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.mj.a aVar3, com.google.android.libraries.navigation.internal.kl.a aVar4, com.google.android.libraries.navigation.internal.kl.c cVar, Executor executor, com.google.android.libraries.navigation.internal.agl.a aVar5, an anVar, com.google.android.libraries.navigation.internal.in.b bVar, an anVar2) {
        this.a = gVar;
        this.b = aVar;
        this.c = aVar2;
        this.d = aVar3;
        this.e = aVar4;
        this.f = cVar;
        this.g = executor;
        this.h = aVar5;
        this.i = (String) anVar.f();
        this.j = bVar;
        this.k = anVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.gn.m
    public final com.google.android.libraries.navigation.internal.gn.l a(cy cyVar, com.google.android.libraries.navigation.internal.gm.an anVar, com.google.android.libraries.navigation.internal.gh.d dVar) {
        return new q(cyVar, this.b, this.a, anVar, new com.google.android.libraries.navigation.internal.fw.n((com.google.android.libraries.navigation.internal.fw.v) this.c.a(), this.d), this.d, this.e, this.f, this.g, this.h, this.i, this.j, dVar);
    }
}
