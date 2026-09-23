package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.acu.ch;
import com.google.android.libraries.navigation.internal.agi.cu;
import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class bq implements x {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.bq");
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final com.google.android.libraries.navigation.internal.kl.a c;
    private final com.google.android.libraries.navigation.internal.ia.e d;
    private final aa e;
    private com.google.android.libraries.navigation.internal.cy.h f;
    private final cu g;
    private com.google.android.libraries.navigation.internal.bp.bh h;

    public bq(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kl.a aVar2, com.google.android.libraries.navigation.internal.ia.e eVar, aa aaVar) {
        ch chVar = ch.a;
        Duration duration = Duration.ZERO;
        this.f = new com.google.android.libraries.navigation.internal.cy.h();
        this.g = new cu();
        this.h = com.google.android.libraries.navigation.internal.bp.bh.b;
        this.b = aVar;
        this.c = aVar2;
        this.e = aaVar;
        this.d = eVar;
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.cy.h a() {
        return this.f;
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.db.q b(long j) {
        com.google.android.libraries.navigation.internal.yx.ar.q(this.e);
        aa aaVar = this.e;
        com.google.android.libraries.navigation.internal.yx.ar.k(aaVar.f());
        byte[] bArrNativeGetRouteLocationAsProto = aaVar.nativeGetRouteLocationAsProto(aaVar.b, j);
        try {
            com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.acu.ah.a, bArrNativeGetRouteLocationAsProto, 0, bArrNativeGetRouteLocationAsProto.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
            com.google.android.libraries.navigation.internal.acu.ah ahVar = (com.google.android.libraries.navigation.internal.acu.ah) biVarV;
            com.google.android.libraries.navigation.internal.db.q qVarA = w.a(this.b, ahVar, this.h, j);
            w.c(this.c, ahVar.J);
            w.d(this.d, ahVar.S, this.g, this.b.a());
            if ((ahVar.c & 32) != 0) {
                if (ahVar.M == null) {
                    ch chVar = ch.a;
                }
                Duration.ofMillis(j);
                this.f = new com.google.android.libraries.navigation.internal.cy.h();
            }
            return qVarA;
        } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 280)).p("Failed to parse LocationIntegratorResultProto");
            return null;
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.acu.ba c(com.google.android.libraries.navigation.internal.acu.ay ayVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        if (!this.e.f()) {
            return com.google.android.libraries.navigation.internal.acu.ba.a;
        }
        byte[] bArrG = this.e.g(ayVar.m());
        if (bArrG == null) {
            return com.google.android.libraries.navigation.internal.acu.ba.a;
        }
        try {
            com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.acu.ba.a, bArrG, 0, bArrG.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
            return (com.google.android.libraries.navigation.internal.acu.ba) biVarV;
        } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 281)).p("Failed to parse ObservationsResponseBytes");
            return com.google.android.libraries.navigation.internal.acu.ba.a;
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void d() {
        this.h = com.google.android.libraries.navigation.internal.bp.bh.b;
        if (this.e.f()) {
            this.e.b();
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void e(long j) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        if (this.e.f()) {
            this.e.h(j);
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void f() {
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void g() {
        if (this.e.f()) {
            this.e.d();
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void h(long j, com.google.android.libraries.navigation.internal.bp.bh bhVar) {
        if (this.e.f()) {
            this.h = bhVar;
            this.e.c(j, w.b(bhVar, false, false).m());
        }
    }
}
