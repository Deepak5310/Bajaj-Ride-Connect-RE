package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.acu.ch;
import com.google.android.libraries.navigation.internal.agi.cu;
import com.google.android.libraries.navigation.internal.agi.hc;
import com.google.android.libraries.navigation.internal.yz.lg;
import j$.time.Duration;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class bz implements x {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.bz");
    public final ab a;
    com.google.android.libraries.navigation.internal.rw.o b;
    private final com.google.android.libraries.navigation.internal.mj.a d;
    private final com.google.android.libraries.navigation.internal.rw.q e;
    private final com.google.android.libraries.navigation.internal.ia.e f;
    private final com.google.android.libraries.navigation.internal.ia.b g;
    private final com.google.android.libraries.navigation.internal.aac.bn h;
    private final com.google.android.libraries.navigation.internal.bf.d i;
    private final com.google.android.libraries.navigation.internal.sf.d j;
    private final com.google.android.libraries.navigation.internal.kl.a k;
    private final Random l;
    private final float m;
    private int o;
    private int q;
    private com.google.android.libraries.navigation.internal.cy.h r;
    private long s;
    private final com.google.android.libraries.navigation.internal.fl.r snaptileProvider;
    private long t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final cu f43n = new cu();
    private com.google.android.libraries.navigation.internal.bp.bh p = com.google.android.libraries.navigation.internal.bp.bh.b;

    public bz(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fl.r rVar, com.google.android.libraries.navigation.internal.rw.q qVar, ab abVar, float f, com.google.android.libraries.navigation.internal.bf.d dVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.ia.b bVar, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.sf.d dVar2, com.google.android.libraries.navigation.internal.kl.a aVar2) {
        ch chVar = ch.a;
        Duration duration = Duration.ZERO;
        this.r = new com.google.android.libraries.navigation.internal.cy.h();
        this.s = 0L;
        this.t = 0L;
        this.b = new by(this);
        this.d = aVar;
        this.l = new Random(aVar.f().toEpochMilli());
        this.snaptileProvider = rVar;
        this.e = qVar;
        this.m = f;
        this.f = eVar;
        this.g = bVar;
        this.h = bnVar;
        this.i = dVar;
        this.j = dVar2;
        this.a = abVar;
        this.k = aVar2;
        this.s = aVar.a() - aVar.e().toMillis();
    }

    private final void i() {
        String str;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        ab abVar = this.a;
        if (abVar == null || !abVar.f()) {
            return;
        }
        com.google.android.libraries.navigation.internal.mj.a aVar = this.d;
        long jA = aVar.a();
        long millis = jA - aVar.e().toMillis();
        long j = millis - this.s;
        if (j > 1000) {
            ab abVar2 = this.a;
            if (abVar2.f()) {
                abVar2.nativeWokeFromSleep(abVar2.b, j, jA);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) LocationIntegratorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 230)).p("wokeFromSleep on closed location integrator.");
            }
            com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) this.k.a(com.google.android.libraries.navigation.internal.km.af.p);
            int i = com.google.android.libraries.navigation.internal.acu.ak.r;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            kVar.a(i2);
        }
        this.s = millis;
        int iA = this.snaptileProvider.a();
        if (this.o != iA) {
            this.o = iA;
            ab abVar3 = this.a;
            if (abVar3.f()) {
                abVar3.nativeUpdateSnaptilePrefetchingVersion(abVar3.b, iA);
            }
            com.google.android.libraries.navigation.internal.ia.b bVar = this.g;
            ab abVar4 = this.a;
            if (abVar4.f()) {
                str = new String(abVar4.nativeGetTileStateDebugString(abVar4.b), StandardCharsets.UTF_8);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) LocationIntegratorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 225)).p("getTileStateDebugString on closed location integrator.");
                str = "";
            }
            bVar.c(new com.google.android.libraries.navigation.internal.dh.ay(str));
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.cy.h a() {
        return this.r;
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.db.q b(long j) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        com.google.android.libraries.navigation.internal.yx.ar.k(true);
        com.google.android.libraries.navigation.internal.yx.ar.q(this.a);
        i();
        ab abVar = this.a;
        int i = this.q;
        com.google.android.libraries.navigation.internal.yx.ar.k(abVar.f());
        byte[] bArrNativeGetSnaptileLocationAsProto = abVar.nativeGetSnaptileLocationAsProto(abVar.b, j, i);
        final com.google.android.libraries.navigation.internal.oe.x xVarF = null;
        try {
            com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.acu.ah.a, bArrNativeGetSnaptileLocationAsProto, 0, bArrNativeGetSnaptileLocationAsProto.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
            com.google.android.libraries.navigation.internal.acu.ah ahVar = (com.google.android.libraries.navigation.internal.acu.ah) biVarV;
            com.google.android.libraries.navigation.internal.db.q qVarA = w.a(this.d, ahVar, this.p, j);
            if (ahVar.B.size() > 0) {
                List<com.google.android.libraries.navigation.internal.acu.aq> arrayList = ahVar.B;
                if (qVarA != null && qVarA.l()) {
                    xVarF = qVarA.f();
                }
                if (xVarF != null) {
                    arrayList = new ArrayList(ahVar.B);
                    Collections.sort(arrayList, new com.google.android.libraries.navigation.internal.yz.ba(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.apps.gmm.location.navigation.bx
                        @Override // com.google.android.libraries.navigation.internal.yx.aa
                        public final Object ak(Object obj) {
                            com.google.android.libraries.navigation.internal.acu.aq aqVar = (com.google.android.libraries.navigation.internal.acu.aq) obj;
                            return Float.valueOf(new com.google.android.libraries.geo.mapcore.internal.model.cd(aqVar.d, aqVar.b, aqVar.c).b().h(xVarF));
                        }
                    }, lg.a));
                }
                for (com.google.android.libraries.navigation.internal.acu.aq aqVar : arrayList) {
                    this.snaptileProvider.f(aqVar.e).f(new com.google.android.libraries.geo.mapcore.internal.model.cd(aqVar.d, aqVar.b, aqVar.c));
                }
            }
            if ((ahVar.c & 64) != 0) {
                this.q = ahVar.N;
                int size = ahVar.O.size();
                hc hcVar = new hc(size);
                for (int i2 = 0; i2 < size; i2++) {
                    hcVar.add(new UUID(ahVar.O.a(i2), ahVar.P.a(i2)));
                }
                this.f.a(new com.google.android.libraries.navigation.internal.dh.az(hcVar));
            }
            for (com.google.android.libraries.navigation.internal.zr.bq bqVar : ahVar.i) {
                Random random = this.l;
                if (random.nextFloat() < this.m) {
                    this.f.a(new com.google.android.libraries.navigation.internal.cw.j(bqVar));
                }
            }
            com.google.android.libraries.navigation.internal.ael.bz bzVar = ahVar.J;
            w.c(this.k, bzVar);
            if (this.g.e() && !bzVar.isEmpty()) {
                at atVar = new at(ahVar.J);
                if (this.g.e()) {
                    this.g.c(atVar);
                }
            }
            if ((ahVar.b & 2) != 0) {
                com.google.android.libraries.navigation.internal.db.aa aaVar = ahVar.e;
                if (aaVar == null) {
                    aaVar = com.google.android.libraries.navigation.internal.db.aa.a;
                }
                if (aaVar.c != this.t) {
                    com.google.android.libraries.navigation.internal.db.aa aaVar2 = ahVar.e;
                    if (aaVar2 == null) {
                        aaVar2 = com.google.android.libraries.navigation.internal.db.aa.a;
                    }
                    this.t = aaVar2.c;
                    com.google.android.libraries.navigation.internal.ia.e eVar = this.f;
                    com.google.android.libraries.navigation.internal.db.aa aaVar3 = ahVar.e;
                    eVar.a(new com.google.android.libraries.navigation.internal.cy.e());
                }
            }
            w.d(this.f, ahVar.S, this.f43n, j);
            if ((ahVar.c & 512) != 0) {
                String str = ahVar.T;
                if (!str.isEmpty()) {
                    this.g.c(new com.google.android.libraries.navigation.internal.dh.ay(str));
                }
            }
            if ((ahVar.c & 32) != 0) {
                if (ahVar.M == null) {
                    ch chVar = ch.a;
                }
                Duration.ofMillis(j);
                this.r = new com.google.android.libraries.navigation.internal.cy.h();
            }
            return qVarA;
        } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 309)).p("Failed to parse LocationIntegratorResultProto");
            return null;
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.acu.ba c(com.google.android.libraries.navigation.internal.acu.ay ayVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        ab abVar = this.a;
        if (abVar == null || !abVar.f()) {
            return com.google.android.libraries.navigation.internal.acu.ba.a;
        }
        i();
        byte[] bArrG = this.a.g(ayVar.m());
        if (bArrG == null) {
            return com.google.android.libraries.navigation.internal.acu.ba.a;
        }
        try {
            com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.acu.ba.a, bArrG, 0, bArrG.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
            return (com.google.android.libraries.navigation.internal.acu.ba) biVarV;
        } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 310)).p("Failed to parse ObservationsResponseBytes");
            return com.google.android.libraries.navigation.internal.acu.ba.a;
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void d() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        this.g.c(new com.google.android.libraries.navigation.internal.dh.ay(""));
        this.e.b(this.b);
        ab abVar = this.a;
        if (abVar != null) {
            if (abVar.f()) {
                abVar.nativeCancelAllBackgroundWork(abVar.b);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) LocationIntegratorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 226)).p("cancelAllBackgroundWork on closed location integrator.");
            }
        }
        this.o = 0;
        this.p = com.google.android.libraries.navigation.internal.bp.bh.b;
        this.f.a(new com.google.android.libraries.navigation.internal.dh.az(null));
        ab abVar2 = this.a;
        if (abVar2 != null) {
            abVar2.a(false);
            this.a.b();
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void e(long j) {
        com.google.android.libraries.navigation.internal.acu.t tVar;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        ab abVar = this.a;
        if (abVar == null || !abVar.f()) {
            return;
        }
        i();
        byte[] bArrH = this.a.h(j);
        if (bArrH != null) {
            try {
                com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.acu.t.a, bArrH, 0, bArrH.length, com.google.android.libraries.navigation.internal.ael.ar.b());
                com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
                tVar = (com.google.android.libraries.navigation.internal.acu.t) biVarV;
            } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 311)).p("Failed to parse followUpWorkResult");
                tVar = com.google.android.libraries.navigation.internal.acu.t.a;
            }
            com.google.android.libraries.navigation.internal.acm.e eVar = this.i.a().b;
            if (eVar == null) {
                eVar = com.google.android.libraries.navigation.internal.acm.e.b;
            }
            if (com.google.android.libraries.navigation.internal.bf.g.b(eVar) && (tVar.b & 1) != 0) {
                com.google.android.libraries.navigation.internal.sf.d dVar = this.j;
                if (tVar.c == null) {
                    com.google.android.libraries.navigation.internal.acm.g gVar = com.google.android.libraries.navigation.internal.acm.g.a;
                }
                dVar.a();
            }
            if ((tVar.b & 2) != 0) {
                com.google.android.libraries.navigation.internal.acu.au auVar = tVar.d;
                if (auVar == null) {
                    auVar = com.google.android.libraries.navigation.internal.acu.au.a;
                }
                if (auVar.b.size() > 0) {
                    com.google.android.libraries.navigation.internal.ia.e eVar2 = this.f;
                    com.google.android.libraries.navigation.internal.acu.au auVar2 = tVar.d;
                    eVar2.a(new com.google.android.libraries.navigation.internal.dh.z());
                }
            }
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void f() {
        this.e.a(this.b, this.h);
        ab abVar = this.a;
        if (abVar != null) {
            abVar.a(true);
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void g() {
        ab abVar = this.a;
        if (abVar != null) {
            abVar.d();
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void h(long j, com.google.android.libraries.navigation.internal.bp.bh bhVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        ab abVar = this.a;
        if (abVar == null || !abVar.f()) {
            return;
        }
        i();
        this.p = bhVar;
        ab abVar2 = this.a;
        com.google.android.libraries.navigation.internal.acm.e eVar = this.i.a().b;
        if (eVar == null) {
            eVar = com.google.android.libraries.navigation.internal.acm.e.b;
        }
        abVar2.c(j, w.b(bhVar, true, com.google.android.libraries.navigation.internal.bf.g.b(eVar)).m());
    }
}
