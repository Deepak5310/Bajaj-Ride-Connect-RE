package com.google.android.libraries.navigation.internal.abm;

import android.location.Location;
import com.google.android.libraries.navigation.internal.abh.fe;
import com.google.android.libraries.navigation.internal.abh.fg;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dh extends com.google.android.libraries.navigation.internal.ol.ar implements fg {
    public final ap a;
    public fe b;
    boolean c;
    private final com.google.android.libraries.navigation.internal.ol.z d;
    private final com.google.android.libraries.navigation.internal.abh.be e;
    private final com.google.android.libraries.navigation.internal.on.h f;
    private final com.google.android.libraries.navigation.internal.abo.a g;
    private final com.google.android.libraries.navigation.internal.abo.b h;
    private final Executor i;
    private boolean j;
    private boolean k;

    public dh(com.google.android.libraries.navigation.internal.ol.z zVar, com.google.android.libraries.navigation.internal.abh.be beVar, ap apVar, com.google.android.libraries.navigation.internal.on.h hVar) {
        com.google.android.libraries.navigation.internal.abo.a aVar = new com.google.android.libraries.navigation.internal.abo.a();
        com.google.android.libraries.navigation.internal.abo.b bVar = new com.google.android.libraries.navigation.internal.abo.b();
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.d = zVar;
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
        this.e = beVar;
        this.a = apVar;
        this.f = hVar;
        this.g = aVar;
        this.h = bVar;
        this.i = executorA;
        this.c = false;
        this.j = false;
        this.b = null;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.dg
            @Override // java.lang.Runnable
            public final void run() {
                dh dhVar = this.a;
                fe feVar = dhVar.b;
                if (feVar != null) {
                    feVar.i();
                }
                ap apVar = dhVar.a;
                apVar.a.a();
                apVar.c.c();
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void a() {
        this.g.c.a(0.0f);
        com.google.android.libraries.navigation.internal.abo.b bVar = this.h;
        bVar.d.a(0.0f);
        bVar.e.a().d(bVar.d);
        bVar.j = false;
        this.k = false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void c(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void d() {
        if (this.c) {
            com.google.android.libraries.navigation.internal.abo.a aVar = this.g;
            aVar.f.d(aVar.d, aVar.g);
            com.google.android.libraries.navigation.internal.abo.b bVar = this.h;
            int i = bVar.k.get(com.google.android.libraries.navigation.internal.abo.b.a, -1);
            if (i != -1) {
                bVar.g.d(bVar.e, i);
            }
            int i2 = bVar.k.get(com.google.android.libraries.navigation.internal.abo.b.b, -1);
            if (i2 != -1) {
                bVar.g.d(bVar.e, i2);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void e(boolean z) {
        this.j = z;
        if (this.c) {
            if (z) {
                this.h.c(this);
                return;
            }
            com.google.android.libraries.navigation.internal.abo.b bVar = this.h;
            com.google.android.libraries.navigation.internal.abf.s.k(bVar.d, "dot");
            bVar.d.aq();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void f(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void g(fe feVar) {
        this.b = feVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void h(Location location) {
        com.google.android.libraries.navigation.internal.oe.x xVarA = com.google.android.libraries.navigation.internal.oe.x.A(location.getLatitude(), location.getLongitude());
        float accuracy = location.getAccuracy();
        com.google.android.libraries.navigation.internal.abo.a aVar = this.g;
        com.google.android.libraries.navigation.internal.ol.i iVarC = aVar.c.c();
        iVarC.b(xVarA);
        iVarC.e(accuracy + accuracy, xVarA.b());
        aVar.c.d(iVarC);
        com.google.android.libraries.navigation.internal.abo.b bVar = this.h;
        com.google.android.libraries.navigation.internal.oe.x xVar = bVar.h;
        bVar.h = xVarA;
        com.google.android.libraries.navigation.internal.ol.i iVarC2 = bVar.d.c();
        iVarC2.b(xVarA);
        if (bVar.i) {
            iVarC2.c(iVarC2.d, xVarA);
        }
        bVar.d.d(iVarC2);
        if (xVar == null) {
            bVar.b();
        }
        boolean zHasBearing = location.hasBearing();
        com.google.android.libraries.navigation.internal.abo.b bVar2 = this.h;
        com.google.android.libraries.navigation.internal.abf.s.k(bVar2.f, "contextManager");
        com.google.android.libraries.navigation.internal.abf.s.k(bVar2.e, "phoenixGoogleMap");
        if (bVar2.i != zHasBearing) {
            bVar2.i = zHasBearing;
            if (!zHasBearing) {
                com.google.android.libraries.navigation.internal.ol.i iVarC3 = bVar2.d.c();
                iVarC3.c(0.0f, new com.google.android.libraries.navigation.internal.oe.x());
                bVar2.d.d(iVarC3);
            }
            com.google.android.libraries.navigation.internal.ol.j jVar = bVar2.d;
            int i = zHasBearing ? com.google.android.libraries.navigation.internal.abo.b.b : com.google.android.libraries.navigation.internal.abo.b.a;
            int i2 = bVar2.k.get(i, -1);
            jVar.b(i2 == -1 ? bVar2.a(i) : bVar2.e.e().i().c(i2));
        }
        if (zHasBearing) {
            com.google.android.libraries.navigation.internal.abo.b bVar3 = this.h;
            float bearing = location.getBearing();
            if (bVar3.i) {
                com.google.android.libraries.navigation.internal.ol.i iVarC4 = bVar3.d.c();
                iVarC4.c(bearing, iVarC4.a);
                bVar3.d.d(iVarC4);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final boolean i() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void b() {
        boolean z;
        if (this.c) {
            z = true;
        } else {
            com.google.android.libraries.navigation.internal.abo.a aVar = this.g;
            com.google.android.libraries.navigation.internal.ol.z zVar = this.d;
            com.google.android.libraries.navigation.internal.abh.be beVar = this.e;
            com.google.android.libraries.navigation.internal.on.h hVar = this.f;
            f fVar = f.a;
            df dfVar = df.b;
            com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
            com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
            com.google.android.libraries.navigation.internal.abf.s.k(hVar, "clientRenderOpFactory");
            com.google.android.libraries.navigation.internal.abf.s.k(dfVar, "multiZoomStyleFactoryPhoenix");
            com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
            aVar.d = zVar;
            com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
            aVar.e = beVar;
            com.google.android.libraries.navigation.internal.abf.s.k(dfVar, "multiZoomStyleFactoryPhoenix");
            aVar.f = dfVar;
            ic icVar = (ic) id.a.q();
            int iD = aVar.e.d(com.google.android.libraries.navigation.internal.abo.a.b);
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar = (id) icVar.b;
            idVar.b |= 1;
            idVar.c = iD;
            int iA = fVar.a(2.0f, aVar.e.b());
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar2 = (id) icVar.b;
            idVar2.b |= 8;
            idVar2.e = iA;
            aVar.g = aVar.f.b(aVar.d, icVar, aVar.e.d(com.google.android.libraries.navigation.internal.abo.a.a), Float.MAX_VALUE);
            aVar.c = hVar.c(0.0d, 0.0d, 100, 1.0f, true, aVar.d.e().i().c(aVar.g), true, 3, 2147483646, 0);
            aVar.c.a(0.0f);
            zVar.a().e(aVar.c);
            com.google.android.libraries.navigation.internal.abo.b bVar = this.h;
            com.google.android.libraries.navigation.internal.ol.z zVar2 = this.d;
            com.google.android.libraries.navigation.internal.abh.be beVar2 = this.e;
            com.google.android.libraries.navigation.internal.on.h hVar2 = this.f;
            df dfVar2 = df.b;
            com.google.android.libraries.navigation.internal.abf.s.k(zVar2, "phoenixGoogleMap");
            bVar.e = zVar2;
            com.google.android.libraries.navigation.internal.abf.s.k(beVar2, "contextManager");
            bVar.f = beVar2;
            com.google.android.libraries.navigation.internal.abf.s.k(dfVar2, "multiZoomStyleFactoryPhoenix");
            bVar.g = dfVar2;
            com.google.android.libraries.navigation.internal.abf.s.k(hVar2, "clientRenderOpFactory");
            bVar.d = hVar2.c(0.0d, 0.0d, 4, 1.0f, true, bVar.a(com.google.android.libraries.navigation.internal.abo.b.a), false, 3, Integer.MAX_VALUE, 0);
            com.google.android.libraries.navigation.internal.ol.i iVarC = bVar.d.c();
            iVarC.d(beVar2.a(com.google.android.libraries.navigation.internal.abo.b.c), com.google.android.libraries.navigation.internal.ol.h.PIXEL);
            bVar.d.d(iVarC);
            bVar.d.a(0.0f);
            bVar.h = null;
            bVar.j = false;
            if (this.j) {
                this.h.c(this);
            }
            z = true;
            this.c = true;
        }
        this.g.c.a(1.0f);
        com.google.android.libraries.navigation.internal.abo.b bVar2 = this.h;
        bVar2.j = z;
        bVar2.d.a(1.0f);
        bVar2.b();
        this.k = z;
    }
}
