package com.google.android.libraries.navigation.internal.hm;

import com.google.android.libraries.navigation.internal.aac.bj;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    private final com.google.android.libraries.navigation.internal.nt.m a;
    private final com.google.android.libraries.navigation.internal.yx.aa b;
    private final Executor c;
    private final ConcurrentMap d = new ConcurrentHashMap();

    public h(j jVar, Executor executor, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        this.a = jVar.a();
        this.b = aaVar;
        this.c = executor;
    }

    public final com.google.android.libraries.navigation.internal.yx.an a() {
        com.google.android.libraries.navigation.internal.fz.d dVar = (com.google.android.libraries.navigation.internal.fz.d) this.a.c();
        return dVar == null ? com.google.android.libraries.navigation.internal.yx.a.a : com.google.android.libraries.navigation.internal.yx.an.i(dVar);
    }

    public final bj b() {
        com.google.android.libraries.navigation.internal.yx.an anVarA = a();
        return anVarA.g() ? com.google.android.libraries.navigation.internal.aac.az.h(anVarA.c()) : com.google.android.libraries.navigation.internal.yu.a.b(this.a.d()).c(this.b, this.c);
    }

    public final void c(com.google.android.libraries.navigation.internal.hn.i iVar, Executor executor) {
        g gVar = new g(this, iVar);
        this.a.e(gVar, executor);
        this.d.put(iVar, gVar);
    }

    public final void d(com.google.android.libraries.navigation.internal.hn.i iVar) {
        com.google.android.libraries.navigation.internal.nt.t tVar = (com.google.android.libraries.navigation.internal.nt.t) this.d.remove(iVar);
        if (tVar != null) {
            this.a.h(tVar);
        }
    }
}
