package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.er;
import com.google.android.libraries.navigation.internal.abh.es;
import com.google.android.libraries.navigation.internal.abh.ez;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fv;
import com.google.android.libraries.navigation.internal.adg.fw;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class de implements er, com.google.android.libraries.navigation.internal.ol.as {
    private static final com.google.android.libraries.navigation.internal.adl.x g;
    private static final com.google.android.libraries.navigation.internal.adl.x h;
    private static final com.google.android.libraries.navigation.internal.ado.j i;
    private static final AtomicInteger j;
    public final es a;
    public final com.google.android.libraries.navigation.internal.abh.ac b;
    public final cz c;
    com.google.android.libraries.navigation.internal.ol.u d;
    final com.google.android.libraries.navigation.internal.adg.dy e;
    boolean f;
    private final com.google.android.libraries.navigation.internal.ol.z k;
    private final dl l;
    private final an m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Executor f134n;
    private final f o;
    private final Queue p;
    private final Queue q;
    private final AtomicInteger r;
    private com.google.android.libraries.navigation.internal.ol.aq s;
    private com.google.android.libraries.navigation.internal.ol.aq t;

    static {
        com.google.android.libraries.navigation.internal.adl.v vVar = (com.google.android.libraries.navigation.internal.adl.v) com.google.android.libraries.navigation.internal.adl.x.a.q();
        if (!vVar.b.H()) {
            vVar.v();
        }
        com.google.android.libraries.navigation.internal.adl.x.c((com.google.android.libraries.navigation.internal.adl.x) vVar.b);
        if (!vVar.b.H()) {
            vVar.v();
        }
        com.google.android.libraries.navigation.internal.adl.x xVar = (com.google.android.libraries.navigation.internal.adl.x) vVar.b;
        xVar.b |= 8;
        xVar.g = false;
        g = (com.google.android.libraries.navigation.internal.adl.x) vVar.t();
        com.google.android.libraries.navigation.internal.adl.v vVar2 = (com.google.android.libraries.navigation.internal.adl.v) com.google.android.libraries.navigation.internal.adl.x.a.q();
        if (!vVar2.b.H()) {
            vVar2.v();
        }
        com.google.android.libraries.navigation.internal.adl.x.c((com.google.android.libraries.navigation.internal.adl.x) vVar2.b);
        if (!vVar2.b.H()) {
            vVar2.v();
        }
        com.google.android.libraries.navigation.internal.adl.x xVar2 = (com.google.android.libraries.navigation.internal.adl.x) vVar2.b;
        xVar2.b |= 8;
        xVar2.g = true;
        h = (com.google.android.libraries.navigation.internal.adl.x) vVar2.t();
        com.google.android.libraries.navigation.internal.ado.i iVar = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
        com.google.android.libraries.navigation.internal.adq.ah ahVar = com.google.android.libraries.navigation.internal.adq.ah.a;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.ado.j jVar = (com.google.android.libraries.navigation.internal.ado.j) iVar.b;
        ahVar.getClass();
        jVar.c = ahVar;
        jVar.b |= 1;
        i = (com.google.android.libraries.navigation.internal.ado.j) iVar.t();
        j = new AtomicInteger();
    }

    public de(com.google.android.libraries.navigation.internal.ol.z zVar, dl dlVar, es esVar, com.google.android.libraries.navigation.internal.abh.ac acVar) {
        an anVar = new an(zVar, esVar);
        cz czVar = dlVar.b;
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        f fVar = f.a;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.k = zVar;
        this.l = dlVar;
        this.a = esVar;
        com.google.android.libraries.navigation.internal.abf.s.k(acVar, "cameraManager");
        this.b = acVar;
        this.m = anVar;
        com.google.android.libraries.navigation.internal.abf.s.k(czVar, "dragHandler");
        this.c = czVar;
        this.f134n = executorA;
        this.o = fVar;
        this.d = null;
        this.e = (com.google.android.libraries.navigation.internal.adg.dy) ef.a.q();
        this.q = new ArrayDeque();
        this.p = new ArrayDeque();
        this.r = new AtomicInteger(0);
        this.f = false;
    }

    private final void A() {
        com.google.android.libraries.navigation.internal.ol.u uVar = this.d;
        com.google.android.libraries.navigation.internal.ol.ay ayVar = (com.google.android.libraries.navigation.internal.ol.ay) com.google.android.libraries.navigation.internal.ol.bd.a.q();
        com.google.android.libraries.navigation.internal.ol.az azVar = (com.google.android.libraries.navigation.internal.ol.az) com.google.android.libraries.navigation.internal.ol.bc.a.q();
        float fL = this.a.L();
        if (!azVar.b.H()) {
            azVar.v();
        }
        com.google.android.libraries.navigation.internal.ol.bc bcVar = (com.google.android.libraries.navigation.internal.ol.bc) azVar.b;
        bcVar.b |= 1;
        bcVar.c = fL;
        int i2 = this.a.X() ? com.google.android.libraries.navigation.internal.ol.bb.b : com.google.android.libraries.navigation.internal.ol.bb.c;
        if (!azVar.b.H()) {
            azVar.v();
        }
        com.google.android.libraries.navigation.internal.ol.bc bcVar2 = (com.google.android.libraries.navigation.internal.ol.bc) azVar.b;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        bcVar2.d = i3;
        bcVar2.b |= 2;
        if (!ayVar.b.H()) {
            ayVar.v();
        }
        com.google.android.libraries.navigation.internal.ol.bd bdVar = (com.google.android.libraries.navigation.internal.ol.bd) ayVar.b;
        com.google.android.libraries.navigation.internal.ol.bc bcVar3 = (com.google.android.libraries.navigation.internal.ol.bc) azVar.t();
        bcVar3.getClass();
        bdVar.f = bcVar3;
        bdVar.b |= 8;
        uVar.c((com.google.android.libraries.navigation.internal.ol.bd) ayVar.t());
    }

    private final void B() {
        if (this.s != null) {
            synchronized (this) {
                q(this.s, this.q);
            }
        }
        int iO = o();
        int iP = p();
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
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        eoVar.b |= 1024;
        eoVar.m = iO;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar2 = (eo) ejVar.b;
        eoVar2.b |= 2048;
        eoVar2.f187n = iP;
        if (!daVar.b.H()) {
            daVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.db dbVar2 = (com.google.android.libraries.navigation.internal.adg.db) daVar.b;
        eo eoVar3 = (eo) ejVar.t();
        eoVar3.getClass();
        dbVar2.e = eoVar3;
        dbVar2.b |= 4;
        fxVar.c(daVar);
        com.google.android.libraries.navigation.internal.ol.s sVarA = this.k.e().a((ga) fxVar.t());
        this.s = sVarA;
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        int iA = sVarA.a();
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        ef efVar2 = ef.a;
        efVar.b |= 4096;
        efVar.l = iA;
    }

    private final int o() {
        es esVar = this.a;
        return Math.round(esVar.H() * esVar.O().getWidth()) * (-8);
    }

    private final int p() {
        es esVar = this.a;
        return Math.round(esVar.I() * esVar.O().getHeight()) * (-8);
    }

    private final int q(Object obj, Queue queue) {
        int iIncrementAndGet = this.r.incrementAndGet();
        queue.add(new dd(iIncrementAndGet, obj));
        return iIncrementAndGet;
    }

    private final LatLng r() {
        return this.a.Q();
    }

    private final void s() {
        if (this.a.Z()) {
            this.k.b().m(this.d);
        } else {
            g();
            this.k.b().i(this.d);
        }
    }

    private final void t() {
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        ef efVar2 = ef.a;
        efVar.b |= 64;
        efVar.h = 11;
        int i2 = this.a.k;
        if (i2 == 1) {
            com.google.android.libraries.navigation.internal.adg.dy dyVar2 = this.e;
            if (!dyVar2.b.H()) {
                dyVar2.v();
            }
            ef efVar3 = (ef) dyVar2.b;
            efVar3.b |= 64;
            efVar3.h = 9;
            return;
        }
        if (i2 != 2) {
            com.google.android.libraries.navigation.internal.adg.dy dyVar3 = this.e;
            if (!dyVar3.b.H()) {
                dyVar3.v();
            }
            ef efVar4 = (ef) dyVar3.b;
            efVar4.b |= 64;
            efVar4.h = 11;
            return;
        }
        com.google.android.libraries.navigation.internal.adg.dy dyVar4 = this.e;
        if (!dyVar4.b.H()) {
            dyVar4.v();
        }
        ef efVar5 = (ef) dyVar4.b;
        efVar5.b |= 64;
        efVar5.h = 8;
    }

    private final void u() {
        this.e.C(com.google.android.libraries.navigation.internal.adl.k.a, this.a.X() ? h : g);
    }

    private final void v() {
        Bitmap bitmapO = this.a.O();
        com.google.android.libraries.navigation.internal.abf.s.k(bitmapO, "bitmap");
        com.google.android.libraries.navigation.internal.ol.aq aqVarC = this.k.e().c(bitmapO);
        if (this.t != null) {
            synchronized (this) {
                q(this.t, this.q);
            }
        }
        this.t = aqVarC;
        com.google.android.libraries.navigation.internal.adg.dq dqVar = (com.google.android.libraries.navigation.internal.adg.dq) com.google.android.libraries.navigation.internal.adg.dt.a.q();
        Cdo cdo = (Cdo) com.google.android.libraries.navigation.internal.adg.dp.a.q();
        int i2 = ((com.google.android.libraries.navigation.internal.po.dq) aqVarC).e;
        if (!cdo.b.H()) {
            cdo.v();
        }
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        com.google.android.libraries.navigation.internal.adg.dp dpVar = (com.google.android.libraries.navigation.internal.adg.dp) cdo.b;
        dpVar.b |= 2;
        dpVar.d = i2;
        dqVar.d(cdo);
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        com.google.android.libraries.navigation.internal.adg.dt dtVar = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.t();
        ef efVar2 = ef.a;
        dtVar.getClass();
        efVar.c = dtVar;
        efVar.b |= 1;
    }

    private final void w() {
        LatLng latLngR = r();
        if (latLngR == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(com.google.android.libraries.navigation.internal.oe.x.A(latLngR.latitude, latLngR.longitude));
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        com.google.android.libraries.navigation.internal.adg.b bVar = com.google.android.libraries.navigation.internal.adg.b.BOTTOM_RIGHT;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        dVar2.d = bVar.j;
        dVar2.b |= 2;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        com.google.android.libraries.navigation.internal.adg.d dVar3 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        ef efVar2 = ef.a;
        dVar3.getClass();
        efVar.e = dVar3;
        efVar.b |= 8;
    }

    private final void x() {
        int iB = this.o.b(this.a.M()) ^ Integer.MIN_VALUE;
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        ef efVar2 = ef.a;
        efVar.b |= 32768;
        efVar.o = iB;
        this.e.C(com.google.android.libraries.navigation.internal.adl.k.d, Integer.valueOf(j.getAndIncrement()));
    }

    private final void y() {
        com.google.android.libraries.navigation.internal.ol.u uVar = this.d;
        com.google.android.libraries.navigation.internal.ol.ay ayVar = (com.google.android.libraries.navigation.internal.ol.ay) com.google.android.libraries.navigation.internal.ol.bd.a.q();
        float fG = this.a.G();
        if (!ayVar.b.H()) {
            ayVar.v();
        }
        com.google.android.libraries.navigation.internal.ol.bd bdVar = (com.google.android.libraries.navigation.internal.ol.bd) ayVar.b;
        bdVar.b |= 4;
        bdVar.e = fG;
        uVar.c((com.google.android.libraries.navigation.internal.ol.bd) ayVar.t());
    }

    private final void z() {
        if (this.m.c == null || this.d == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.ol.z zVar = this.k;
        an anVar = this.m;
        com.google.android.libraries.navigation.internal.ol.ai aiVarB = zVar.b();
        com.google.android.libraries.navigation.internal.ol.u uVar = anVar.c;
        com.google.android.libraries.navigation.internal.ol.u uVar2 = this.d;
        es esVar = this.a;
        com.google.android.libraries.navigation.internal.po.dh dhVar = (com.google.android.libraries.navigation.internal.po.dh) aiVarB;
        com.google.android.libraries.navigation.internal.po.df dfVar = dhVar.d;
        float fJ = esVar.J();
        float fK = esVar.K();
        if (!uVar.equals(uVar2)) {
            com.google.android.libraries.navigation.internal.po.de deVar = new com.google.android.libraries.navigation.internal.po.de(uVar, uVar2, fJ, fK);
            synchronized (dfVar.a) {
                dfVar.a.t(uVar2, deVar);
            }
        }
        dhVar.m.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        this.f134n.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.dc
            @Override // java.lang.Runnable
            public final void run() {
                de deVar = this.a;
                if (deVar.f || !deVar.a.F()) {
                    return;
                }
                es esVar = deVar.a;
                if (esVar.b.q(esVar)) {
                    return;
                }
                CameraPosition.Builder builder = CameraPosition.builder(deVar.b.c());
                builder.target(deVar.a.Q());
                deVar.b.i(builder.build(), ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void D(Object obj) {
        final com.google.android.libraries.navigation.internal.ol.o oVar = (com.google.android.libraries.navigation.internal.ol.o) obj;
        this.f134n.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.da
            @Override // java.lang.Runnable
            public final void run() {
                de deVar = this.a;
                if (!deVar.a.W()) {
                    com.google.android.libraries.navigation.internal.afu.d.a.a().L();
                    return;
                }
                cz czVar = deVar.c;
                es esVar = deVar.a;
                com.google.android.libraries.navigation.internal.abf.s.k(esVar, "markerImpl");
                czVar.b.a();
                es esVar2 = czVar.d;
                if (esVar2 != null) {
                    esVar2.b.e(esVar2);
                }
                czVar.e = false;
                czVar.d = esVar;
                if (com.google.android.libraries.navigation.internal.afu.d.j()) {
                    cy cyVar = new cy(czVar);
                    czVar.c.d(cyVar);
                    LatLng latLng = cyVar.a;
                    if (latLng != null) {
                        esVar.U(latLng);
                    }
                } else {
                    Point pointA = czVar.a.l().a(czVar.d.Q());
                    czVar.a(czVar.d, pointA.x, pointA.y);
                }
                es esVar3 = czVar.d;
                ez ezVar = esVar3.b;
                ((er) ezVar.b.get(esVar3)).f();
                View view = (View) ezVar.c.get(esVar3);
                if (view != null) {
                    view.setVisibility(4);
                }
                com.google.android.libraries.navigation.internal.ly.bf bfVar = ezVar.f;
                if (bfVar != null) {
                    try {
                        ((com.google.android.gms.maps.a) bfVar).a.onMarkerDragStart(new Marker(esVar3));
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
                if (ezVar.d.get(esVar3) != null) {
                    ((View) ezVar.d.get(esVar3)).bringToFront();
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final Rect c() {
        es esVar = this.a;
        Bitmap bitmapO = esVar.O();
        float fH = esVar.H() * bitmapO.getWidth();
        float fI = this.a.I() * bitmapO.getHeight();
        Point pointA = this.b.e().a(this.a.g());
        int i2 = (int) fH;
        int i3 = (int) fI;
        Point point = new Point(pointA.x - i2, pointA.y - i3);
        Point point2 = new Point(pointA.x + (bitmapO.getWidth() - i2), pointA.y + (bitmapO.getHeight() - i3));
        return new Rect(point.x, point.y, point2.x, point2.y);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void d() {
        if (this.f) {
            return;
        }
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        ef efVar2 = ef.a;
        efVar.b |= 16384;
        efVar.f186n = 2147483645;
        com.google.android.libraries.navigation.internal.ael.bh bhVar = com.google.android.libraries.navigation.internal.adg.bj.U;
        fv fvVar = (fv) fw.a.q();
        es esVar = this.a;
        if (!fvVar.b.H()) {
            fvVar.v();
        }
        String str = esVar.a;
        fw fwVar = (fw) fvVar.b;
        str.getClass();
        fwVar.b |= 1;
        fwVar.c = str;
        dyVar.C(bhVar, (fw) fvVar.t());
        dyVar.C(com.google.android.libraries.navigation.internal.adl.k.f, true);
        com.google.android.libraries.navigation.internal.rp.c.h(this.e, i);
        w();
        x();
        u();
        t();
        com.google.android.libraries.navigation.internal.adg.dy dyVar2 = this.e;
        if (!dyVar2.b.H()) {
            dyVar2.v();
        }
        ef efVar3 = (ef) dyVar2.b;
        efVar3.b |= 128;
        efVar3.i = 32767;
        com.google.android.libraries.navigation.internal.afu.d.r();
        v();
        B();
        if (this.d == null) {
            com.google.android.libraries.navigation.internal.po.bb bbVarB = ((com.google.android.libraries.navigation.internal.po.dh) this.k.b()).b((ef) this.e.t(), jr.WORLD_ENCODING_LAT_LNG_E7);
            this.d = bbVarB;
            bbVarB.k(this);
            A();
            y();
            s();
            this.l.c.put(this.a.a, this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void e() {
        t();
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        ef efVar2 = ef.a;
        efVar.b |= 16384;
        efVar.f186n = 2147483645;
        n();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void f() {
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        int i2 = ((ef) dyVar.b).h | 3;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        efVar.b |= 64;
        efVar.h = i2;
        com.google.android.libraries.navigation.internal.adg.dy dyVar2 = this.e;
        if (!dyVar2.b.H()) {
            dyVar2.v();
        }
        ef efVar2 = (ef) dyVar2.b;
        efVar2.b |= 16384;
        efVar2.f186n = 2147483646;
        n();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void g() {
        if (k()) {
            this.l.l(this.m, this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void h(int i2) {
        com.google.android.libraries.navigation.internal.afu.d.r();
        if (this.f) {
            return;
        }
        switch (i2) {
            case 0:
                w();
                LatLng latLngR = r();
                if (latLngR != null) {
                    com.google.android.libraries.navigation.internal.ol.u uVar = this.d;
                    com.google.android.libraries.navigation.internal.ol.ay ayVar = (com.google.android.libraries.navigation.internal.ol.ay) com.google.android.libraries.navigation.internal.ol.bd.a.q();
                    com.google.android.libraries.navigation.internal.acc.c cVar = (com.google.android.libraries.navigation.internal.acc.c) com.google.android.libraries.navigation.internal.acc.d.a.q();
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acc.d dVar = (com.google.android.libraries.navigation.internal.acc.d) cVar.b;
                    dVar.b |= 2;
                    dVar.d = latLngR.latitude;
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    double d = latLngR.longitude;
                    com.google.android.libraries.navigation.internal.acc.d dVar2 = (com.google.android.libraries.navigation.internal.acc.d) cVar.b;
                    dVar2.b |= 1;
                    dVar2.c = d;
                    com.google.android.libraries.navigation.internal.acc.d dVar3 = (com.google.android.libraries.navigation.internal.acc.d) cVar.t();
                    if (!ayVar.b.H()) {
                        ayVar.v();
                    }
                    com.google.android.libraries.navigation.internal.ol.bd bdVar = (com.google.android.libraries.navigation.internal.ol.bd) ayVar.b;
                    dVar3.getClass();
                    bdVar.c = dVar3;
                    bdVar.b |= 1;
                    uVar.c((com.google.android.libraries.navigation.internal.ol.bd) ayVar.t());
                }
                break;
            case 1:
                v();
                n();
                break;
            case 2:
                com.google.android.libraries.navigation.internal.ol.u uVar2 = this.d;
                com.google.android.libraries.navigation.internal.ol.ay ayVar2 = (com.google.android.libraries.navigation.internal.ol.ay) com.google.android.libraries.navigation.internal.ol.bd.a.q();
                int iO = o();
                if (!ayVar2.b.H()) {
                    ayVar2.v();
                }
                com.google.android.libraries.navigation.internal.ol.bd bdVar2 = (com.google.android.libraries.navigation.internal.ol.bd) ayVar2.b;
                bdVar2.b |= 16;
                bdVar2.g = iO;
                int iP = p();
                if (!ayVar2.b.H()) {
                    ayVar2.v();
                }
                com.google.android.libraries.navigation.internal.ol.bd bdVar3 = (com.google.android.libraries.navigation.internal.ol.bd) ayVar2.b;
                bdVar3.b |= 32;
                bdVar3.h = iP;
                uVar2.c((com.google.android.libraries.navigation.internal.ol.bd) ayVar2.t());
                break;
            case 3:
                u();
                n();
                break;
            case 4:
                A();
                break;
            case 5:
                break;
            case 6:
                s();
                break;
            case 7:
            case 8:
                if (k()) {
                    this.l.m(this.m);
                    z();
                }
                break;
            case 9:
                z();
                break;
            case 10:
                y();
                break;
            default:
                x();
                n();
                break;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void i() {
        if (this.f) {
            return;
        }
        g();
        cz czVar = this.c;
        es esVar = this.a;
        com.google.android.libraries.navigation.internal.abf.s.k(esVar, "markerImpl");
        czVar.b.a();
        if (com.google.android.libraries.navigation.internal.abf.r.a(esVar, czVar.d)) {
            czVar.d = null;
        }
        com.google.android.libraries.navigation.internal.ol.u uVar = this.d;
        if (uVar != null) {
            uVar.h();
            this.d = null;
        }
        if (this.s != null) {
            this.k.e().j(this.s);
            this.s = null;
        }
        if (this.t != null) {
            this.k.e().j(this.t);
            this.t = null;
        }
        m(this.r.get());
        this.f = true;
        this.l.c.remove(this.a.a);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void j(boolean z) {
        an anVar;
        de deVar;
        if (this.a.F()) {
            if (z && k()) {
                this.l.m(this.m);
            } else {
                dl dlVar = this.l;
                an anVar2 = this.m;
                com.google.android.libraries.navigation.internal.abf.s.k(anVar2, "infoWindowRenderer");
                synchronized (dlVar) {
                    anVar = dlVar.f;
                    deVar = dlVar.g;
                }
                if (anVar != null && anVar.c != null) {
                    dlVar.l(anVar, deVar);
                }
                synchronized (dlVar) {
                    dlVar.f = anVar2;
                    dlVar.g = this;
                }
                anVar2.c(dlVar.a.getWidth(), dlVar.a.getHeight());
                com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
                if (((ef) dyVar.b).f186n != 2147483646) {
                    if (!dyVar.b.H()) {
                        dyVar.v();
                    }
                    ef efVar = (ef) dyVar.b;
                    efVar.b |= 16384;
                    efVar.f186n = 2147483646;
                    n();
                }
                anVar2.e();
            }
            z();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final boolean k() {
        return this.l.n(this.m);
    }

    public final int l() {
        return this.b.e().a(this.a.g()).y;
    }

    public final void m(int i2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this) {
            while (!this.p.isEmpty() && ((dd) this.p.peek()).a <= i2) {
                arrayList.add((com.google.android.libraries.navigation.internal.ol.u) ((dd) this.p.remove()).b);
            }
            while (!this.q.isEmpty() && ((dd) this.q.peek()).a <= i2) {
                arrayList2.add((com.google.android.libraries.navigation.internal.ol.aq) ((dd) this.q.remove()).b);
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((com.google.android.libraries.navigation.internal.ol.u) arrayList.get(i3)).h();
        }
        int size2 = arrayList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            this.k.e().j((com.google.android.libraries.navigation.internal.ol.aq) arrayList2.get(i4));
        }
    }

    public final void n() {
        final int iQ;
        if (this.d == null) {
            return;
        }
        B();
        synchronized (this) {
            iQ = q(this.d, this.p);
        }
        com.google.android.libraries.navigation.internal.ol.z zVar = this.k;
        com.google.android.libraries.navigation.internal.adg.dy dyVar = this.e;
        com.google.android.libraries.navigation.internal.po.bb bbVarB = ((com.google.android.libraries.navigation.internal.po.dh) zVar.b()).b((ef) dyVar.t(), jr.WORLD_ENCODING_LAT_LNG_E7);
        this.d = bbVarB;
        bbVarB.k(this);
        A();
        y();
        z();
        s();
        t();
        this.d.ar(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.db
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m(iQ);
            }
        });
    }
}
