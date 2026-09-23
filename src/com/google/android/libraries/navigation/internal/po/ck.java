package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ck {
    public com.google.android.libraries.navigation.internal.px.ek a;
    public int b = 0;
    final /* synthetic */ cm c;

    public ck(cm cmVar) {
        this.c = cmVar;
    }

    final com.google.android.libraries.navigation.internal.adg.eo a(com.google.android.libraries.navigation.internal.adg.dp dpVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(this.a);
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA = this.c.d.a(dpVar, this.a, this.b);
        if (!aiVarA.q()) {
            return com.google.android.libraries.navigation.internal.adg.eo.a;
        }
        com.google.android.libraries.geo.mapcore.internal.model.cb cbVar = aiVarA.r;
        com.google.android.libraries.navigation.internal.adg.ej ejVar = (com.google.android.libraries.navigation.internal.adg.ej) com.google.android.libraries.navigation.internal.adg.eo.a.q();
        int iE = cbVar.e();
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.eo eoVar = (com.google.android.libraries.navigation.internal.adg.eo) ejVar.b;
        eoVar.b |= 1;
        eoVar.c = iE;
        int iF = cbVar.f();
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.eo eoVar2 = (com.google.android.libraries.navigation.internal.adg.eo) ejVar.b;
        eoVar2.b |= 2;
        eoVar2.d = iF;
        com.google.android.libraries.navigation.internal.adg.cf cfVar = (com.google.android.libraries.navigation.internal.adg.cf) com.google.android.libraries.navigation.internal.adg.ch.a.q();
        int iG = cbVar.g();
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ch chVar = (com.google.android.libraries.navigation.internal.adg.ch) cfVar.b;
        chVar.b |= 1;
        chVar.c = iG;
        float fA = cbVar.a() * 100.0f;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ch chVar2 = (com.google.android.libraries.navigation.internal.adg.ch) cfVar.b;
        chVar2.b |= 4;
        chVar2.e = (int) (fA + 0.5f);
        float fC = cbVar.c() * 1000.0f;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ch chVar3 = (com.google.android.libraries.navigation.internal.adg.ch) cfVar.b;
        chVar3.b |= 8;
        chVar3.f = (int) (fC + 0.5f);
        float fB = cbVar.b() * 8.0f;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ch chVar4 = (com.google.android.libraries.navigation.internal.adg.ch) cfVar.b;
        chVar4.b |= 32;
        chVar4.g = (int) (fB + 0.5f);
        int iD = cbVar.d();
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ch chVar5 = (com.google.android.libraries.navigation.internal.adg.ch) cfVar.b;
        chVar5.b |= 2;
        chVar5.d = iD;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.eo eoVar3 = (com.google.android.libraries.navigation.internal.adg.eo) ejVar.b;
        com.google.android.libraries.navigation.internal.adg.ch chVar6 = (com.google.android.libraries.navigation.internal.adg.ch) cfVar.t();
        chVar6.getClass();
        eoVar3.g = chVar6;
        eoVar3.b |= 16;
        boolean zH = cbVar.h();
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.eo eoVar4 = (com.google.android.libraries.navigation.internal.adg.eo) ejVar.b;
        eoVar4.b |= 512;
        eoVar4.l = zH;
        return (com.google.android.libraries.navigation.internal.adg.eo) ejVar.t();
    }

    final boolean b(com.google.android.libraries.navigation.internal.adg.dp dpVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(this.a);
        return this.c.d.a(dpVar, this.a, this.b).i();
    }
}
