package com.google.android.libraries.navigation.internal.px;

import org.joda.time.DateTime;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class et implements aa {
    private final com.google.android.libraries.navigation.internal.qa.b b = new com.google.android.libraries.navigation.internal.qa.b();
    private final com.google.android.libraries.navigation.internal.oe.ay c = new com.google.android.libraries.navigation.internal.oe.ay();
    private final float[] d = new float[8];
    private final com.google.android.libraries.navigation.internal.fq.k e = new com.google.android.libraries.navigation.internal.fq.k(20);
    public com.google.android.libraries.navigation.internal.agg.bj a = new com.google.android.libraries.navigation.internal.agg.bz();

    public static int b(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
        efVar.h(bhVarS);
        Object objK = efVar.w.k(bhVarS.d);
        if ((((com.google.android.libraries.navigation.internal.adl.x) (objK == null ? bhVarS.b : bhVarS.c(objK))).b & 16) == 0) {
            return 0;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
        efVar.h(bhVarS2);
        Object objK2 = efVar.w.k(bhVarS2.d);
        com.google.android.libraries.navigation.internal.adl.s sVar = ((com.google.android.libraries.navigation.internal.adl.x) (objK2 == null ? bhVarS2.b : bhVarS2.c(objK2))).h;
        if (sVar == null) {
            sVar = com.google.android.libraries.navigation.internal.adl.s.a;
        }
        if ((sVar.b & 2) == 0) {
            return 0;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
        efVar.h(bhVarS3);
        Object objK3 = efVar.w.k(bhVarS3.d);
        com.google.android.libraries.navigation.internal.adl.s sVar2 = ((com.google.android.libraries.navigation.internal.adl.x) (objK3 == null ? bhVarS3.b : bhVarS3.c(objK3))).h;
        if (sVar2 == null) {
            sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
        }
        return sVar2.c;
    }

    @Override // com.google.android.libraries.navigation.internal.px.aa
    public final void a(ek ekVar) {
        es esVarC;
        int iB = b(ekVar.o());
        if (iB == 0 || !this.a.c(iB) || (esVarC = c(ekVar)) == null) {
            return;
        }
        esVarC.a = DateTime.now();
        eu euVar = (eu) this.a.p(iB);
        if (!euVar.c.contains(esVarC)) {
            euVar.b++;
        }
        euVar.d.add(esVarC);
    }

    public final es c(ek ekVar) {
        es esVar = (es) this.e.f(ekVar.o());
        if (esVar != null) {
            return esVar;
        }
        if (!ekVar.h().h()) {
            return null;
        }
        com.google.android.libraries.navigation.internal.oe.j jVarF = ekVar.f();
        com.google.android.libraries.geo.mapcore.internal.model.c cVar = ((m) ekVar.h()).a;
        com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
        com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ab);
        efVarO.h(bhVarS);
        Object objK = efVarO.w.k(bhVarS.d);
        Object objC = objK == null ? bhVarS.b : bhVarS.c(objK);
        com.google.android.libraries.navigation.internal.oe.x xVar = cVar.a;
        com.google.android.libraries.navigation.internal.ael.bz bzVar = ((com.google.android.libraries.navigation.internal.adg.dn) objC).b;
        es esVar2 = new es(jVarF, xVar);
        this.e.m(ekVar.o(), esVar2);
        return esVar2;
    }

    public final boolean d(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.qa.a aVar, com.google.android.libraries.navigation.internal.pb.t tVar, int i) {
        if (!com.google.android.libraries.navigation.internal.pb.j.n(tVar, xVar, this.c, this.d)) {
            return false;
        }
        com.google.android.libraries.navigation.internal.qa.b bVar = this.b;
        com.google.android.libraries.navigation.internal.oe.ay ayVar = this.c;
        float f = i / 2.0f;
        bVar.g(ayVar.b, ayVar.c, 0.0d, f, f);
        return this.b.e(aVar);
    }
}
