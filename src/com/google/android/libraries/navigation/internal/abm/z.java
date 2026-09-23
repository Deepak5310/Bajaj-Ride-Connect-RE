package com.google.android.libraries.navigation.internal.abm;

import com.google.android.libraries.navigation.internal.adg.jr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    public final com.google.android.libraries.navigation.internal.ol.z a;
    public final com.google.android.libraries.navigation.internal.abf.z b;
    public com.google.android.libraries.navigation.internal.ol.g c;
    final com.google.android.libraries.navigation.internal.po.bf d;
    private final com.google.android.libraries.navigation.internal.po.be e;

    public z(com.google.android.libraries.navigation.internal.ol.z zVar) {
        com.google.android.libraries.navigation.internal.abf.z zVar2 = com.google.android.libraries.navigation.internal.abf.z.a;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.a = zVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar2, "uiThreadChecker");
        this.b = zVar2;
        com.google.android.libraries.navigation.internal.po.bf bfVarN = zVar.n();
        this.d = bfVarN;
        this.e = bfVarN.e();
    }

    public final void a() {
        this.b.a();
        this.c = null;
        this.e.c(null);
        this.d.d(null);
    }

    public final void b(com.google.android.libraries.navigation.internal.adg.aq aqVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.as asVar) {
        d(aqVar, jrVar, asVar, 1.0f, null);
    }

    public final void c(com.google.android.libraries.navigation.internal.adg.aq aqVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.as asVar, float f) {
        d(aqVar, jrVar, asVar, f, null);
    }

    public final void d(com.google.android.libraries.navigation.internal.adg.aq aqVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.as asVar, float f, Runnable runnable) {
        com.google.android.libraries.navigation.internal.abf.s.k(aqVar, "areaRenderOp");
        com.google.android.libraries.navigation.internal.abf.s.k(jrVar, "worldBasedVertexEncoding");
        com.google.android.libraries.navigation.internal.ol.k kVarA = this.a.a().a(aqVar, jrVar);
        kVarA.a(f);
        if (asVar != null) {
            kVarA.k(asVar);
        }
        this.c = kVarA;
        this.e.c(kVarA);
        this.d.d(runnable);
    }

    public final void e(com.google.android.libraries.navigation.internal.ol.as asVar) {
        this.b.a();
        com.google.android.libraries.navigation.internal.ol.g gVar = this.c;
        if (gVar == null) {
            return;
        }
        if (asVar != null) {
            gVar.k(asVar);
        } else {
            gVar.aq();
        }
    }
}
