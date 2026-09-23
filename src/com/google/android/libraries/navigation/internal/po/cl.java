package com.google.android.libraries.navigation.internal.po;

import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cl {
    public final com.google.android.libraries.navigation.internal.oe.x a;
    public final com.google.android.libraries.navigation.internal.adg.dp b;
    final /* synthetic */ cm c;

    public cl(cm cmVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.dp dpVar) {
        this.c = cmVar;
        this.a = xVar;
        this.b = dpVar;
    }

    public final com.google.android.libraries.navigation.internal.ol.ag a(com.google.android.libraries.navigation.internal.px.ek ekVar, ck ckVar, com.google.android.libraries.navigation.internal.adi.bo boVar) {
        com.google.android.libraries.navigation.internal.adg.ds dsVarB;
        com.google.android.libraries.navigation.internal.adg.es esVar;
        com.google.android.libraries.navigation.internal.adi.bo boVar2 = com.google.android.libraries.navigation.internal.adi.bo.ROADMAP_SATELLITE;
        boolean z = com.google.android.libraries.geo.mapcore.internal.model.aq.a(boVar).G;
        boolean zG = cm.g(ekVar);
        if (!ekVar.h().h() || ekVar.ac() == com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIGHT_HIGHLIGHTING) {
            return new com.google.android.libraries.navigation.internal.ol.ag(ekVar, true);
        }
        boolean z2 = !zG;
        if ((this.c.h && ekVar.L()) || (com.google.android.libraries.navigation.internal.rb.a.c(ekVar.o()).b & 4) != 0) {
            cm cmVar = this.c;
            com.google.android.libraries.navigation.internal.oe.x xVar = this.a;
            com.google.android.libraries.navigation.internal.adg.ef efVar = (com.google.android.libraries.navigation.internal.adg.ef) cm.e(ekVar, xVar, z2).t();
            cmVar.g.b(ekVar.o(), efVar);
            return new com.google.android.libraries.navigation.internal.ol.ag(ekVar.Z(efVar, ekVar.c(), com.google.android.libraries.navigation.internal.px.cg.d(xVar)), cm.h(ekVar, z2));
        }
        cm cmVar2 = this.c;
        com.google.android.libraries.navigation.internal.oe.x xVar2 = this.a;
        com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
        com.google.android.libraries.navigation.internal.adg.dt dtVarD = zG ? com.google.android.libraries.navigation.internal.adg.dt.a : cm.d((com.google.android.libraries.navigation.internal.adg.dp) cmVar2.c.f(com.google.android.libraries.navigation.internal.adg.ex.LEGEND_STYLE_SPOTLIGHT_PIN).b().t(), com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY);
        ArrayList arrayList = new ArrayList();
        com.google.android.libraries.navigation.internal.adg.dt dtVar = efVarO.c;
        if (dtVar == null) {
            dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        com.google.android.libraries.navigation.internal.adg.dt dtVar2 = dtVar;
        boolean z3 = boVar != boVar2;
        cmVar2.f(dtVar2, z3, z, true, ckVar, arrayList);
        com.google.android.libraries.navigation.internal.adg.dt dtVar3 = efVarO.d;
        if (dtVar3 == null) {
            dtVar3 = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        cmVar2.f(dtVar3, z3, z, false, ckVar, arrayList);
        com.google.android.libraries.navigation.internal.adg.dt dtVar4 = efVarO.d;
        if (dtVar4 == null) {
            dtVar4 = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        if (dtVar4.c.size() == 0) {
            com.google.android.libraries.navigation.internal.adg.dt dtVar5 = efVarO.c;
            if (dtVar5 == null) {
                dtVar5 = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            dsVarB = com.google.android.libraries.navigation.internal.adg.ds.b(dtVar5.f);
            if (dsVarB == null) {
                dsVarB = com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY;
            }
        } else {
            com.google.android.libraries.navigation.internal.adg.dt dtVar6 = efVarO.d;
            if (dtVar6 == null) {
                dtVar6 = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            dsVarB = com.google.android.libraries.navigation.internal.adg.ds.b(dtVar6.f);
            if (dsVarB == null) {
                dsVarB = com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY;
            }
        }
        com.google.android.libraries.navigation.internal.adg.dq dqVar = (com.google.android.libraries.navigation.internal.adg.dq) com.google.android.libraries.navigation.internal.adg.dt.a.q();
        dqVar.c(arrayList);
        if (!dqVar.b.H()) {
            dqVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.dt dtVar7 = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.b;
        dtVar7.f = dsVarB.d;
        dtVar7.b |= 4;
        com.google.android.libraries.navigation.internal.adg.dt dtVar8 = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.t();
        com.google.android.libraries.navigation.internal.adg.dy dyVarE = cm.e(ekVar, xVar2, z2);
        com.google.android.libraries.navigation.internal.adg.dt dtVar9 = true == zG ? dtVar8 : dtVarD;
        if (!dyVarE.b.H()) {
            dyVarE.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar2 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarE.b;
        dtVar9.getClass();
        efVar2.c = dtVar9;
        efVar2.b |= 1;
        if (zG) {
            dtVar8 = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        if (!dyVarE.b.H()) {
            dyVarE.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar3 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarE.b;
        dtVar8.getClass();
        efVar3.d = dtVar8;
        efVar3.b |= 2;
        com.google.android.libraries.navigation.internal.ael.bh bhVar = com.google.android.libraries.navigation.internal.adl.k.a;
        com.google.android.libraries.navigation.internal.adl.x xVar3 = (com.google.android.libraries.navigation.internal.adl.x) dyVarE.y(com.google.android.libraries.navigation.internal.adl.k.a);
        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) xVar3.aH(5, null);
        bbVar.x(xVar3);
        com.google.android.libraries.navigation.internal.adl.v vVar = (com.google.android.libraries.navigation.internal.adl.v) bbVar;
        if (!vVar.b.H()) {
            vVar.v();
        }
        com.google.android.libraries.navigation.internal.adl.x xVar4 = (com.google.android.libraries.navigation.internal.adl.x) vVar.b;
        com.google.android.libraries.navigation.internal.adl.x xVar5 = com.google.android.libraries.navigation.internal.adl.x.a;
        xVar4.b |= 128;
        xVar4.j = z2;
        dyVarE.C(bhVar, (com.google.android.libraries.navigation.internal.adl.x) vVar.t());
        if (!zG && (esVar = ((ba) cmVar2.c.f(com.google.android.libraries.navigation.internal.adg.ex.LEGEND_STYLE_SPOTLIGHT_PIN_LABEL_LAYOUT)).b) != null) {
            dyVarE.C(com.google.android.libraries.navigation.internal.adg.et.c, esVar);
            if (!dyVarE.b.H()) {
                dyVarE.v();
            }
            com.google.android.libraries.navigation.internal.adg.ef efVar4 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarE.b;
            efVar4.b &= -8193;
            efVar4.m = -1L;
            if (!dyVarE.b.H()) {
                dyVarE.v();
            }
            com.google.android.libraries.navigation.internal.adg.ef efVar5 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarE.b;
            efVar5.b &= -4097;
            efVar5.l = -1;
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarE.t();
        cmVar2.g.b(efVarO, efVar6);
        return new com.google.android.libraries.navigation.internal.ol.ag(ekVar.Z(efVar6, cmVar2.c.f.d, com.google.android.libraries.navigation.internal.px.cg.d(xVar2)), cm.h(ekVar, z2));
    }
}
