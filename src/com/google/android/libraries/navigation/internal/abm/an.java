package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;
import com.google.android.libraries.navigation.internal.abh.es;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an implements com.google.android.libraries.navigation.internal.ol.as {
    public final es a;
    public final Executor b;
    com.google.android.libraries.navigation.internal.ol.u c;
    private final com.google.android.libraries.navigation.internal.ol.z d;
    private final com.google.android.libraries.navigation.internal.adg.dy e;

    public an(com.google.android.libraries.navigation.internal.ol.z zVar, es esVar) {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.d = zVar;
        this.a = esVar;
        this.b = executorA;
        this.c = null;
        this.e = (com.google.android.libraries.navigation.internal.adg.dy) ef.a.q();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.ak
            @Override // java.lang.Runnable
            public final void run() {
                an anVar = this.a;
                if (anVar.c == null) {
                    return;
                }
                es esVar = anVar.a;
                esVar.b.f(esVar);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void D(Object obj) {
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.am
            @Override // java.lang.Runnable
            public final void run() {
                an anVar = this.a;
                if (anVar.c == null) {
                    return;
                }
                es esVar = anVar.a;
                esVar.b.h(esVar);
            }
        });
    }

    public final void c(int i, int i2) {
        if (this.c != null) {
            return;
        }
        es esVar = this.a;
        Bitmap bitmapA = esVar.b.g.a(esVar, i, i2);
        if (bitmapA != null) {
            if ((((ef) this.e.b).b & 64) == 0) {
                com.google.android.libraries.navigation.internal.adl.v vVar = (com.google.android.libraries.navigation.internal.adl.v) com.google.android.libraries.navigation.internal.adl.x.a.q();
                if (!vVar.b.H()) {
                    vVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.x.c((com.google.android.libraries.navigation.internal.adl.x) vVar.b);
                if (!vVar.b.H()) {
                    vVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.x xVar = (com.google.android.libraries.navigation.internal.adl.x) vVar.b;
                xVar.b |= 65536;
                xVar.o = true;
                com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
                fx fxVar = (fx) ga.a.q();
                com.google.android.libraries.navigation.internal.adg.da daVar = (com.google.android.libraries.navigation.internal.adg.da) com.google.android.libraries.navigation.internal.adg.db.a.q();
                if (!daVar.b.H()) {
                    daVar.v();
                }
                com.google.android.libraries.navigation.internal.adg.db dbVar = (com.google.android.libraries.navigation.internal.adg.db) daVar.b;
                dbVar.b |= 1;
                dbVar.c = 0;
                ej ejVar = (ej) eo.a.q();
                if (!ejVar.b.H()) {
                    ejVar.v();
                }
                eo.d((eo) ejVar.b);
                if (!daVar.b.H()) {
                    daVar.v();
                }
                com.google.android.libraries.navigation.internal.adg.db dbVar2 = (com.google.android.libraries.navigation.internal.adg.db) daVar.b;
                eo eoVar = (eo) ejVar.t();
                eoVar.getClass();
                dbVar2.e = eoVar;
                dbVar2.b |= 4;
                fxVar.c(daVar);
                int iA = this.d.e().a((ga) fxVar.t()).a();
                if (!dyVar.b.H()) {
                    dyVar.v();
                }
                ef efVar = (ef) dyVar.b;
                efVar.b |= 4096;
                efVar.l = iA;
                if (!dyVar.b.H()) {
                    dyVar.v();
                }
                ef efVar2 = (ef) dyVar.b;
                efVar2.b |= 16384;
                efVar2.f186n = Integer.MAX_VALUE;
                if (!dyVar.b.H()) {
                    dyVar.v();
                }
                ef efVar3 = (ef) dyVar.b;
                efVar3.b |= 64;
                efVar3.h = 3;
                dyVar.C(com.google.android.libraries.navigation.internal.adl.k.a, (com.google.android.libraries.navigation.internal.adl.x) vVar.t());
                dyVar.C(com.google.android.libraries.navigation.internal.adl.k.f, true);
            }
            com.google.android.libraries.navigation.internal.adg.dy dyVar2 = this.e;
            com.google.android.libraries.navigation.internal.adg.dq dqVar = (com.google.android.libraries.navigation.internal.adg.dq) com.google.android.libraries.navigation.internal.adg.dt.a.q();
            Cdo cdo = (Cdo) com.google.android.libraries.navigation.internal.adg.dp.a.q();
            int i3 = ((com.google.android.libraries.navigation.internal.po.dq) this.d.e().c(bitmapA)).e;
            if (!cdo.b.H()) {
                cdo.v();
            }
            com.google.android.libraries.navigation.internal.adg.dp dpVar = (com.google.android.libraries.navigation.internal.adg.dp) cdo.b;
            dpVar.b |= 2;
            dpVar.d = i3;
            dqVar.d(cdo);
            if (!dyVar2.b.H()) {
                dyVar2.v();
            }
            ef efVar4 = (ef) dyVar2.b;
            com.google.android.libraries.navigation.internal.adg.dt dtVar = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.t();
            dtVar.getClass();
            efVar4.c = dtVar;
            efVar4.b |= 1;
            com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
            com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(com.google.android.libraries.navigation.internal.oe.x.A(this.a.g().latitude, this.a.g().longitude));
            if (!cVar.b.H()) {
                cVar.v();
            }
            com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
            hVarA.getClass();
            dVar.c = hVarA;
            dVar.b = 1 | dVar.b;
            com.google.android.libraries.navigation.internal.adg.b bVar = com.google.android.libraries.navigation.internal.adg.b.TOP;
            if (!cVar.b.H()) {
                cVar.v();
            }
            com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
            dVar2.d = bVar.j;
            dVar2.b |= 2;
            if (!dyVar2.b.H()) {
                dyVar2.v();
            }
            ef efVar5 = (ef) dyVar2.b;
            com.google.android.libraries.navigation.internal.adg.d dVar3 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
            dVar3.getClass();
            efVar5.e = dVar3;
            efVar5.b |= 8;
            com.google.android.libraries.navigation.internal.po.bb bbVarB = ((com.google.android.libraries.navigation.internal.po.dh) this.d.b()).b((ef) this.e.t(), jr.WORLD_ENCODING_LAT_LNG_E7);
            this.c = bbVarB;
            bbVarB.k(this);
        }
    }

    public final void d() {
        if (this.c == null) {
            return;
        }
        this.d.b().i(this.c);
        this.d.b().g(this.c);
        this.c = null;
    }

    public final void e() {
        if (this.c != null) {
            es esVar = this.a;
            if (esVar.b.p(esVar)) {
                return;
            }
            this.d.b().m(this.c);
        }
    }
}
