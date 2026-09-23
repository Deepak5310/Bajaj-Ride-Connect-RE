package com.google.android.libraries.navigation.internal.px;

import android.content.res.Resources;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends ak {
    public af(com.google.android.libraries.navigation.internal.fq.f fVar) {
        super(fVar, com.google.android.libraries.navigation.internal.fq.n.CALLOUT_LABELS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ah a(ek ekVar, com.google.android.libraries.navigation.internal.adg.ee eeVar, int i, float f, com.google.android.libraries.navigation.internal.pz.a aVar, com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.qz.g gVar2, Resources resources, com.google.android.libraries.navigation.internal.adg.b bVar2, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.navigation.internal.ol.n nVar) {
        ae aeVar = ae.a;
        com.google.android.libraries.geo.mapcore.renderer.ck ckVar = com.google.android.libraries.geo.mapcore.renderer.ck.CALLOUT_LABEL;
        com.google.android.libraries.navigation.internal.adg.ef efVarN = ((com.google.android.libraries.navigation.internal.po.ag) nVar).n();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.b);
        efVarN.h(bhVarS);
        Object objK = efVarN.w.k(bhVarS.d);
        if (((com.google.android.libraries.navigation.internal.adl.f) (objK == null ? bhVarS.b : bhVarS.c(objK))).e) {
            ckVar = com.google.android.libraries.geo.mapcore.renderer.ck.CALLOUT_LABEL_OVER_PLACEMARKS;
        }
        ah ahVar = (ah) c();
        ahVar.x(ekVar, i, f, gVar, bVar, aVar, gVar2, ckVar, resources, bVar2, eeVar, dVar, nVar, aeVar);
        return ahVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ak
    protected final /* synthetic */ al b() {
        return new ah();
    }
}
