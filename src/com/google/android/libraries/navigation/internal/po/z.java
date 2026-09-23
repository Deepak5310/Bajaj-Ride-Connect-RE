package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.no;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends x implements com.google.android.libraries.navigation.internal.ol.k {
    public z(com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.oe.k kVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.geo.mapcore.internal.model.ce ceVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2, hi hiVar, w wVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.pb.t tVar, gr grVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ol.a aVar, boolean z) {
        super(aqVar, kVar, hVar, ceVar, aqVar2, hiVar, wVar, axVar, tVar, grVar, sVar, aVar);
        this.g.k(this.i);
        this.g.l(1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.po.x
    protected final ay e(x xVar, w wVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.navigation.internal.oe.k kVar, com.google.android.libraries.geo.mapcore.internal.model.g gVar, com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2) {
        com.google.android.libraries.navigation.internal.adg.gm gmVar = aqVar.c;
        if (gmVar == null) {
            gmVar = com.google.android.libraries.navigation.internal.adg.gm.a;
        }
        List listC = C(gmVar, kVar);
        int i = aqVar.k;
        int i2 = aqVar.l;
        int iA = com.google.android.libraries.navigation.internal.adg.cz.a(aqVar.f);
        if (iA == 0) {
            iA = com.google.android.libraries.navigation.internal.adg.cz.a;
        }
        com.google.android.libraries.navigation.internal.adg.fh fhVar = (com.google.android.libraries.navigation.internal.adg.fh) com.google.android.libraries.navigation.internal.adg.fi.a.q();
        no it2 = ((com.google.android.libraries.navigation.internal.yz.ev) listC).iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.ael.x xVar2 = (com.google.android.libraries.navigation.internal.ael.x) it2.next();
            D(fhVar, kVar.b(xVar2), xVar2, aqVar2, i, i2, iA);
        }
        com.google.android.libraries.navigation.internal.ol.r rVarA = wVar.a(xVar, hVar, kVar, (com.google.android.libraries.navigation.internal.adg.fi) fhVar.t());
        if (rVarA == Cdo.a) {
            return null;
        }
        return (ay) rVarA;
    }
}
