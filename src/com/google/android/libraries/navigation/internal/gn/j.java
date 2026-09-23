package com.google.android.libraries.navigation.internal.gn;

import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.fw.v;
import com.google.android.libraries.navigation.internal.fw.z;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements m {
    private final com.google.android.libraries.navigation.internal.fy.f a;
    private final z b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private final com.google.android.libraries.navigation.internal.afo.a e;
    private final com.google.android.libraries.navigation.internal.mj.a f;
    private final com.google.android.libraries.navigation.internal.kl.a g;
    private final com.google.android.libraries.navigation.internal.kl.c h;
    private final Executor i;
    private final String j;
    private final an k;
    private final com.google.android.libraries.navigation.internal.no.a l;
    private final an m;

    public j(com.google.android.libraries.navigation.internal.fy.f fVar, z zVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.mj.a aVar4, com.google.android.libraries.navigation.internal.kl.a aVar5, com.google.android.libraries.navigation.internal.kl.c cVar, Executor executor, an anVar, an anVar2, com.google.android.libraries.navigation.internal.no.a aVar6, an anVar3) {
        this.a = fVar;
        this.b = zVar;
        this.c = aVar;
        this.d = aVar2;
        this.e = aVar3;
        this.f = aVar4;
        this.g = aVar5;
        this.h = cVar;
        this.i = executor;
        this.j = (String) anVar.f();
        this.k = anVar2;
        this.l = aVar6;
        this.m = anVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.gn.m
    public final l a(cy cyVar, com.google.android.libraries.navigation.internal.gm.an anVar, com.google.android.libraries.navigation.internal.gh.d dVar) {
        com.google.android.libraries.navigation.internal.fw.n nVar = new com.google.android.libraries.navigation.internal.fw.n((v) this.e.a(), this.f);
        com.google.android.libraries.navigation.internal.mj.a aVar = this.f;
        com.google.android.libraries.navigation.internal.kl.a aVar2 = this.g;
        com.google.android.libraries.navigation.internal.kl.c cVar = this.h;
        Executor executor = this.i;
        String str = this.j;
        com.google.android.libraries.navigation.internal.no.a aVar3 = this.l;
        an anVar2 = this.m;
        return new i(cyVar, this.c, this.a, this.b, anVar, dVar, this.d, nVar, aVar, aVar2, cVar, executor, str, aVar3, anVar2);
    }
}
