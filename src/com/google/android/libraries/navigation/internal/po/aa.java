package com.google.android.libraries.navigation.internal.po;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends ag implements com.google.android.libraries.navigation.internal.ol.n {
    public final com.google.android.libraries.navigation.internal.px.ag c;
    public final com.google.android.libraries.navigation.internal.op.g d;
    public final com.google.android.libraries.navigation.internal.adg.b e;
    private final com.google.android.libraries.navigation.internal.adg.ee h;

    public aa(dd ddVar, af afVar, com.google.android.libraries.navigation.internal.px.ek ekVar, com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.ol.ai aiVar) {
        super(ddVar, afVar, ekVar, aiVar, false);
        this.c = new com.google.android.libraries.navigation.internal.px.ag();
        this.d = gVar;
        this.e = bVar;
        com.google.android.libraries.navigation.internal.adg.ee eeVarB = com.google.android.libraries.navigation.internal.adg.ee.b(((com.google.android.libraries.navigation.internal.px.b) ekVar).a.g);
        this.h = eeVarB == null ? com.google.android.libraries.navigation.internal.adg.ee.CENTER_LEFT_TO_CENTER_RIGHT : eeVarB;
    }

    final synchronized void A(com.google.android.libraries.navigation.internal.px.ca caVar, float f, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        if (this.b) {
            return;
        }
        this.c.b(caVar.a(this.g, this.h, Arrays.hashCode(new Object[]{this.g, dVar, aqVar}), f, this.e, dVar, this));
        q();
    }

    public final synchronized boolean B() {
        return this.b;
    }

    final synchronized void C(com.google.android.libraries.navigation.internal.px.ca caVar, float f, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        com.google.android.libraries.navigation.internal.px.ah ahVar;
        if (this.b) {
            return;
        }
        int iHashCode = Arrays.hashCode(new Object[]{this.g, dVar, aqVar});
        synchronized (this.c.b) {
            ahVar = this.c.a;
        }
        if (ahVar == null || ahVar.z() == iHashCode) {
            return;
        }
        com.google.android.libraries.navigation.internal.px.ah ahVarA = caVar.a(this.g, this.h, iHashCode, f, this.e, dVar, this);
        this.c.a();
        this.c.b(ahVarA);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.n
    public final com.google.android.libraries.navigation.internal.op.g a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.n
    public final com.google.android.libraries.navigation.internal.op.j b() {
        com.google.android.libraries.navigation.internal.yz.ez ezVarH = com.google.android.libraries.navigation.internal.yz.fd.h(com.google.android.libraries.navigation.internal.adg.b.values().length - 1);
        com.google.android.libraries.navigation.internal.qa.a aVar = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
        com.google.android.libraries.navigation.internal.adg.ef efVarF = n();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.b);
        efVarF.h(bhVarS);
        Object objK = efVarF.w.k(bhVarS.d);
        float f = ((com.google.android.libraries.navigation.internal.adl.f) (objK == null ? bhVarS.b : bhVarS.c(objK))).c;
        float[] fArr = {0.0f, 0.0f};
        synchronized (this.c.b) {
            com.google.android.libraries.navigation.internal.px.ah ahVar = this.c.a;
            if (ahVar != null) {
                ahVar.t();
                com.google.android.libraries.navigation.internal.py.a aVar2 = ahVar.a;
                if (aVar2 != null) {
                    com.google.android.libraries.navigation.internal.adg.b[] bVarArrValues = com.google.android.libraries.navigation.internal.adg.b.values();
                    int i = 0;
                    for (int length = bVarArrValues.length; i < length; length = length) {
                        com.google.android.libraries.navigation.internal.adg.b bVar = bVarArrValues[i];
                        if (!bVar.equals(com.google.android.libraries.navigation.internal.adg.b.CENTER)) {
                            aVar2.d(0.0f, 0.0f, 1.0f, bVar, com.google.android.libraries.navigation.internal.py.a.b(aVar2.a, bVar, aVar2.b), aVar);
                            com.google.android.libraries.navigation.internal.on.f.a(0.0f, 0.0f, f, bVar, fArr);
                            float f2 = aVar.a;
                            float f3 = fArr[0];
                            float f4 = aVar.b;
                            float f5 = fArr[1];
                            ezVarH.f(bVar, new com.google.android.libraries.navigation.internal.op.d(f2 + f3, f4 + f5, aVar.c + f3, aVar.d + f5));
                        }
                        i++;
                    }
                }
            }
        }
        return com.google.android.libraries.navigation.internal.op.j.c(this.d, ezVarH.d());
    }

    @Override // com.google.android.libraries.navigation.internal.ol.n
    public final void c() {
        synchronized (this.c.b) {
            com.google.android.libraries.navigation.internal.px.ah ahVar = this.c.a;
            if (ahVar != null) {
                ahVar.t();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.n
    public final void d(com.google.android.libraries.navigation.internal.ol.l lVar) {
        com.google.android.libraries.navigation.internal.px.ag agVar = this.c;
        synchronized (agVar.b) {
            com.google.android.libraries.navigation.internal.px.ah ahVar = agVar.a;
            if (ahVar != null) {
                ahVar.l(lVar);
            } else {
                agVar.e = lVar;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.n
    public final void e(com.google.android.libraries.navigation.internal.ol.m mVar, boolean z) {
        com.google.android.libraries.navigation.internal.px.ag agVar = this.c;
        synchronized (agVar.b) {
            agVar.d.a(mVar);
            agVar.c = true;
        }
        if (z) {
            this.f.g();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.pp.d
    public final /* bridge */ /* synthetic */ void w() {
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.pp.d
    public final synchronized void x() {
        this.f.i(this);
        this.c.a();
        super.x();
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.pp.d
    public final void z() {
        if (I()) {
            return;
        }
        this.f.g();
    }
}
