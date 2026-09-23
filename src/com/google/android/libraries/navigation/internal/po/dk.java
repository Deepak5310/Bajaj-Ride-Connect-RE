package com.google.android.libraries.navigation.internal.po;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dk implements com.google.android.libraries.navigation.internal.ol.aj {
    private static final com.google.android.libraries.navigation.internal.ol.w b = new com.google.android.libraries.navigation.internal.ol.w(0, 0);
    public final ds a;
    private final com.google.android.libraries.navigation.internal.qd.x c;
    private final com.google.android.libraries.navigation.internal.qu.cf d;

    public dk(com.google.android.libraries.navigation.internal.qd.x xVar, com.google.android.libraries.navigation.internal.qu.cf cfVar, ds dsVar) {
        this.c = xVar;
        this.d = cfVar;
        this.a = dsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aj
    public final di a(com.google.android.libraries.navigation.internal.abm.d dVar, boolean z, Executor executor) {
        com.google.android.libraries.navigation.internal.qu.k kVar;
        dj djVar = new dj();
        com.google.android.libraries.navigation.internal.oe.ap apVar = new com.google.android.libraries.navigation.internal.oe.ap(dVar.a, com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY);
        com.google.android.libraries.navigation.internal.qu.cf cfVar = this.d;
        synchronized (cfVar.e(apVar)) {
            com.google.android.libraries.navigation.internal.adi.an anVar = com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY;
            com.google.android.libraries.navigation.internal.oe.ap apVarA = cfVar.b.a(anVar);
            kVar = new com.google.android.libraries.navigation.internal.qu.k(apVarA, new com.google.android.libraries.navigation.internal.qw.b(cfVar.d, apVarA, com.google.android.libraries.navigation.internal.qu.cf.a(cfVar.i, anVar, ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) cfVar.e.a()).e()).b, cfVar.j)), new com.google.android.libraries.navigation.internal.qu.bn(new com.google.android.libraries.navigation.internal.qu.bp()), new com.google.android.libraries.navigation.internal.qo.b(executor, dVar), executor, cfVar.h, new com.google.android.libraries.navigation.internal.qu.ch(cfVar.f, anVar));
            cfVar.f(apVar, kVar);
        }
        com.google.android.libraries.navigation.internal.qd.w wVarD = this.c.d(apVar, com.google.android.libraries.geo.mapcore.internal.model.cg.s, kVar, djVar, false);
        wVarD.F(b);
        wVarD.I = z;
        this.a.g(wVarD);
        di diVar = new di(wVarD, kVar, djVar);
        diVar.a(1.0f);
        return diVar;
    }
}
