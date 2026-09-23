package com.google.android.libraries.navigation.internal.qu;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k implements com.google.android.libraries.navigation.internal.qv.k {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.k");
    static final com.google.android.libraries.navigation.internal.adi.an b = com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY;
    public final com.google.android.libraries.navigation.internal.qv.g d;
    public final com.google.android.libraries.navigation.internal.qo.b e;
    public final ch f;
    public final bn h;
    public final Executor i;
    public final com.google.android.libraries.navigation.internal.aac.bn j;
    private final com.google.android.libraries.navigation.internal.oe.ap k;
    public final ReentrantLock c = new ReentrantLock();
    public final m g = new m();

    public k(com.google.android.libraries.navigation.internal.oe.ap apVar, com.google.android.libraries.navigation.internal.qv.g gVar, bn bnVar, com.google.android.libraries.navigation.internal.qo.b bVar, Executor executor, com.google.android.libraries.navigation.internal.aac.bn bnVar2, ch chVar) {
        com.google.android.libraries.navigation.internal.yx.ar.a(apVar.c.equals(b));
        this.k = apVar;
        this.d = gVar;
        this.h = bnVar;
        this.e = bVar;
        this.i = executor;
        this.j = bnVar2;
        this.f = chVar;
    }

    private final void l(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, boolean z, com.google.android.libraries.navigation.internal.qv.i iVar) {
        j("ApiTileStore.addTileRequest", this.i, new e(this, cdVar, z, iVar));
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final com.google.android.libraries.geo.mapcore.internal.model.cg D() {
        return com.google.android.libraries.geo.mapcore.internal.model.cg.s;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final com.google.android.libraries.navigation.internal.adi.an E() {
        return b;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final void F() {
        j("ApiTileStore.clearCache", this.j, new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.b
            @Override // java.lang.Runnable
            public final void run() {
                final k kVar = this.a;
                kVar.d.t();
                kVar.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        kVar.g.a();
                    }
                });
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final String a() {
        return null;
    }

    public final com.google.android.libraries.navigation.internal.dm.r b(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar) {
        com.google.android.libraries.navigation.internal.dm.r rVar = (com.google.android.libraries.navigation.internal.dm.r) com.google.android.libraries.navigation.internal.dm.s.a.q();
        com.google.android.libraries.navigation.internal.dm.o oVarA = com.google.android.libraries.geo.mapcore.internal.model.ch.a(this.k, com.google.android.libraries.geo.mapcore.internal.model.cg.s, cdVar, "", Locale.getDefault().toLanguageTag());
        if (!rVar.b.H()) {
            rVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.s sVar = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
        oVarA.getClass();
        sVar.c = oVarA;
        sVar.b |= 1;
        return rVar;
    }

    public final void f(final com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, final com.google.android.libraries.navigation.internal.qv.i iVar, final com.google.android.libraries.navigation.internal.qv.h hVar, final com.google.android.libraries.geo.mapcore.internal.model.cc ccVar) {
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.c
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.zb.j jVar = k.a;
                iVar.a(cdVar, hVar, ccVar);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final void g(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar, com.google.android.libraries.navigation.internal.adf.j jVar) {
        l(cdVar, true, iVar);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final void h(float f) {
        this.d.t();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final void i(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar, boolean z) {
        l(cdVar, false, iVar);
    }

    public final void j(String str, Executor executor, Runnable runnable) {
        executor.execute(new j(this, str, runnable));
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final void k(com.google.android.libraries.navigation.internal.qd.u uVar) {
        this.g.b(uVar);
    }
}
