package com.google.android.libraries.navigation.internal.po;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements w {
    final /* synthetic */ com.google.android.libraries.navigation.internal.pm.d a;
    final /* synthetic */ Cdo b;
    final /* synthetic */ com.google.android.libraries.geo.mapcore.renderer.ax c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.pi.s d;
    final /* synthetic */ com.google.android.libraries.navigation.internal.pb.t e;
    final /* synthetic */ Context f;
    final /* synthetic */ gr g;

    public c(com.google.android.libraries.navigation.internal.pm.d dVar, Cdo cdo, com.google.android.libraries.geo.mapcore.renderer.ax axVar, gr grVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.pb.t tVar, Context context) {
        this.a = dVar;
        this.b = cdo;
        this.c = axVar;
        this.g = grVar;
        this.d = sVar;
        this.e = tVar;
        this.f = context;
    }

    @Override // com.google.android.libraries.navigation.internal.po.w
    public final com.google.android.libraries.navigation.internal.ol.r a(com.google.android.libraries.navigation.internal.ol.g gVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.navigation.internal.oe.k kVar, com.google.android.libraries.navigation.internal.adg.fi fiVar) {
        float f = this.f.getResources().getDisplayMetrics().density;
        Cdo cdo = this.b;
        return new ay(cdo, cdo.b, this.c, this.g, this.d, this.e, f, fiVar, gVar, hVar, kVar);
    }

    @Override // com.google.android.libraries.navigation.internal.po.w
    public final v b(x xVar, com.google.android.libraries.geo.mapcore.internal.model.g gVar) {
        com.google.android.libraries.geo.mapcore.renderer.af afVar;
        int iOrdinal = (gVar != null ? gVar.e : com.google.android.libraries.geo.mapcore.internal.model.at.DEFAULT).ordinal();
        if (iOrdinal == 1) {
            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.CLIENT_INJECTED_AREAS_ABOVE_LABELS;
        } else if (iOrdinal != 2) {
            afVar = iOrdinal != 3 ? com.google.android.libraries.geo.mapcore.renderer.cg.CLIENT_INJECTED_DRAW_ORDER : com.google.android.libraries.geo.mapcore.renderer.cl.NAV_POLYLINE;
        } else {
            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.CLIENT_INJECTED_AREAS_ABOVE_LABELS_AND_CALLOUTS;
        }
        return new v(xVar, afVar);
    }
}
