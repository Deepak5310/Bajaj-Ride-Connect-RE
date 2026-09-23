package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cj implements com.google.android.libraries.navigation.internal.ol.ah {
    public final com.google.android.libraries.navigation.internal.yx.as a;
    final cl b;
    final ck c;
    public final com.google.android.libraries.navigation.internal.adg.hg d;
    final /* synthetic */ cm e;

    public cj(cm cmVar, com.google.android.libraries.navigation.internal.yx.as asVar, cl clVar) {
        this(cmVar, asVar, clVar, null);
    }

    public cj(cm cmVar, com.google.android.libraries.navigation.internal.yx.as asVar, cl clVar, com.google.android.libraries.navigation.internal.adg.hg hgVar) {
        this.e = cmVar;
        this.c = new ck(cmVar);
        this.a = asVar;
        this.b = clVar;
        this.d = hgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ah
    public final com.google.android.libraries.navigation.internal.ol.ag a(com.google.android.libraries.navigation.internal.px.ek ekVar, float f) {
        com.google.android.libraries.navigation.internal.adi.bo boVar;
        int iFloor = (int) Math.floor(f);
        ck ckVar = this.c;
        ckVar.a = ekVar;
        ckVar.b = iFloor;
        synchronized (this.e) {
            boVar = this.e.e;
        }
        return this.b.a(ekVar, this.c, boVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ah
    public final com.google.android.libraries.navigation.internal.ol.ag b() {
        cl clVar = this.b;
        if (clVar.b == null) {
            return cm.b;
        }
        com.google.android.libraries.navigation.internal.adg.dy dyVar = (com.google.android.libraries.navigation.internal.adg.dy) com.google.android.libraries.navigation.internal.adg.ef.a.q();
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(clVar.a);
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        dVar2.getClass();
        efVar.e = dVar2;
        efVar.b |= 8;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar2 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
        efVar2.b |= 64;
        efVar2.h = 1;
        com.google.android.libraries.navigation.internal.adg.dq dqVar = (com.google.android.libraries.navigation.internal.adg.dq) com.google.android.libraries.navigation.internal.adg.dt.a.q();
        dqVar.e(clVar.b);
        com.google.android.libraries.navigation.internal.adg.ds dsVar = com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY;
        if (!dqVar.b.H()) {
            dqVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.dt dtVar = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.b;
        dtVar.f = dsVar.d;
        dtVar.b |= 4;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar3 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
        com.google.android.libraries.navigation.internal.adg.dt dtVar2 = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.t();
        dtVar2.getClass();
        efVar3.c = dtVar2;
        efVar3.b |= 1;
        int i = com.google.android.libraries.navigation.internal.rb.a.a;
        com.google.android.libraries.navigation.internal.adl.x xVar = (com.google.android.libraries.navigation.internal.adl.x) dyVar.y(com.google.android.libraries.navigation.internal.adl.k.a);
        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) xVar.aH(5, null);
        bbVar.x(xVar);
        com.google.android.libraries.navigation.internal.adl.v vVar = (com.google.android.libraries.navigation.internal.adl.v) bbVar;
        if (!vVar.b.H()) {
            vVar.v();
        }
        com.google.android.libraries.navigation.internal.adl.x xVar2 = (com.google.android.libraries.navigation.internal.adl.x) vVar.b;
        com.google.android.libraries.navigation.internal.adl.x xVar3 = com.google.android.libraries.navigation.internal.adl.x.a;
        xVar2.b |= 1;
        xVar2.e = true;
        dyVar.C(com.google.android.libraries.navigation.internal.adl.k.a, (com.google.android.libraries.navigation.internal.adl.x) vVar.t());
        com.google.android.libraries.navigation.internal.ael.bh bhVar = com.google.android.libraries.navigation.internal.adl.k.a;
        com.google.android.libraries.navigation.internal.adl.v vVar2 = (com.google.android.libraries.navigation.internal.adl.v) com.google.android.libraries.navigation.internal.adl.x.a.q();
        if (!vVar2.b.H()) {
            vVar2.v();
        }
        com.google.android.libraries.navigation.internal.adl.x xVar4 = (com.google.android.libraries.navigation.internal.adl.x) vVar2.b;
        xVar4.b |= 128;
        xVar4.j = true;
        dyVar.C(bhVar, (com.google.android.libraries.navigation.internal.adl.x) vVar2.t());
        return new com.google.android.libraries.navigation.internal.ol.ag(com.google.android.libraries.navigation.internal.px.ep.as((com.google.android.libraries.navigation.internal.adg.ef) dyVar.t(), clVar.c.c.p(), clVar.c.c.f.d, null, com.google.android.libraries.navigation.internal.px.cg.d(clVar.a)), true);
    }
}
