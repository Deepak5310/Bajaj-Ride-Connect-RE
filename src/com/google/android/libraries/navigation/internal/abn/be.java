package com.google.android.libraries.navigation.internal.abn;

import android.graphics.Point;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.libraries.navigation.internal.abm.dy;
import com.google.android.libraries.navigation.internal.po.gu;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be {
    private static final ThreadLocal b = new ba();
    private static final ThreadLocal c = new bb();
    private static final ThreadLocal d = new bc();
    public final double a;
    private final com.google.android.libraries.navigation.internal.abf.ak e;
    private final bd f;
    private az g;
    private com.google.android.libraries.navigation.internal.abf.ak h;
    private ac i;
    private ac j;
    private boolean k;
    private final com.google.android.libraries.navigation.internal.pb.t l;
    private Float m;

    public be(com.google.android.libraries.navigation.internal.pb.t tVar, int i, int i2, double d2) {
        com.google.android.libraries.navigation.internal.abf.v vVar = new com.google.android.libraries.navigation.internal.abf.v(i, i2);
        bd bdVar = bd.a;
        com.google.android.libraries.navigation.internal.abf.s.k(tVar, "gmmCamera");
        this.l = tVar;
        this.e = vVar;
        this.f = bdVar;
        this.a = d2;
        this.g = az.a;
        this.k = false;
        synchronized (this) {
            this.i = null;
        }
    }

    private static CameraPosition y(com.google.android.libraries.navigation.internal.pb.t tVar, CameraPosition cameraPosition, double d2, double d3) {
        return com.google.android.libraries.navigation.internal.abm.f.c(com.google.android.libraries.navigation.internal.pb.j.l(tVar, com.google.android.libraries.navigation.internal.abm.f.f(cameraPosition), (float) d2, (float) d3));
    }

    private final synchronized CameraPosition z(CameraPosition cameraPosition, double d2, double d3) {
        float fSqrt;
        com.google.android.libraries.navigation.internal.pd.a aVar;
        com.google.android.libraries.navigation.internal.oe.x xVar = (com.google.android.libraries.navigation.internal.oe.x) b.get();
        xVar.K(0, 0, 0);
        com.google.android.libraries.navigation.internal.oq.f fVarB = com.google.android.libraries.navigation.internal.pd.d.b(com.google.android.libraries.navigation.internal.abm.f.f(cameraPosition));
        float f = ((com.google.android.libraries.navigation.internal.oq.b) fVarB).e;
        com.google.android.libraries.navigation.internal.pb.t tVar = this.l;
        float fI = tVar.i();
        float fJ = tVar.j();
        int iR = tVar.r();
        float fA = com.google.android.libraries.navigation.internal.pb.j.a(f, fI, iR, tVar.n());
        float f2 = ((com.google.android.libraries.navigation.internal.oq.b) fVarB).b;
        float f3 = ((com.google.android.libraries.navigation.internal.oq.b) fVarB).c;
        com.google.android.libraries.navigation.internal.oe.r rVar = ((com.google.android.libraries.navigation.internal.oq.b) fVarB).a;
        float f4 = fA / (fJ * iR);
        float fSin = (-((float) d3)) * f4;
        com.google.android.libraries.navigation.internal.oe.x xVarI = com.google.android.libraries.navigation.internal.pb.j.i(f2 + 90.0f);
        com.google.android.libraries.navigation.internal.oe.x xVarI2 = com.google.android.libraries.navigation.internal.pb.j.i(f2);
        com.google.android.libraries.navigation.internal.oe.x xVarZ = com.google.android.libraries.navigation.internal.oe.x.z(rVar);
        if (f3 > 0.0f) {
            double dAtan2 = Math.atan2(fSin, fA);
            fSin = fA * ((float) (Math.sin(dAtan2) / Math.cos((((double) f3) * 0.017453292519943295d) + dAtan2)));
            fSqrt = ((float) Math.sqrt(((double) ((fA * fA) + (fSin * fSin))) - (((double) ((fA + fA) * fSin)) * Math.cos(((double) (f3 + 90.0f)) * 0.017453292519943295d)))) / fA;
        } else {
            fSqrt = 1.0f;
        }
        com.google.android.libraries.navigation.internal.oe.x.I(xVarI, (-(((float) d2) * f4)) * fSqrt, xVarI);
        com.google.android.libraries.navigation.internal.oe.x.I(xVarI2, -fSin, xVarI2);
        com.google.android.libraries.navigation.internal.oe.x.F(xVarZ.u(xVarI), xVarI2, xVar);
        aVar = new com.google.android.libraries.navigation.internal.pd.a(com.google.android.libraries.navigation.internal.abm.f.f(cameraPosition));
        aVar.e(xVar);
        return com.google.android.libraries.navigation.internal.abm.f.c(aVar.a());
    }

    public final synchronized double a() {
        return this.l.i();
    }

    public final synchronized float b() {
        Float f;
        f = this.m;
        return f != null ? f.floatValue() : this.l.w().k;
    }

    public final synchronized CameraPosition c() {
        ac acVarN;
        acVarN = n();
        return z(f(), -acVarN.a, -acVarN.b);
    }

    public final synchronized CameraPosition d(CameraPosition cameraPosition, float f, ac acVar) {
        com.google.android.libraries.navigation.internal.pb.t tVar;
        double d2;
        double d3;
        CameraPosition cameraPositionBuild;
        tVar = new com.google.android.libraries.navigation.internal.pb.t(this.l);
        double dS = tVar.s();
        double dR = tVar.r();
        d2 = acVar.a - (dS / 2.0d);
        d3 = acVar.b - (dR / 2.0d);
        CameraPosition cameraPositionY = y(tVar, cameraPosition, d2, d3);
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionY);
        builder.bearing(cameraPositionY.bearing + f);
        cameraPositionBuild = builder.build();
        tVar.B(com.google.android.libraries.navigation.internal.abm.f.f(cameraPositionBuild));
        return y(tVar, cameraPositionBuild, -d2, -d3);
    }

    public final synchronized CameraPosition e(CameraPosition cameraPosition, float f, ac acVar, c cVar) {
        com.google.android.libraries.navigation.internal.pb.t tVar;
        double dS;
        double dR;
        CameraPosition cameraPositionBuild;
        com.google.android.libraries.navigation.internal.abf.s.k(cameraPosition, "startPosition");
        com.google.android.libraries.navigation.internal.abf.s.k(acVar, "focusPixel");
        com.google.android.libraries.navigation.internal.abf.s.k(cVar, "sanitizer");
        tVar = new com.google.android.libraries.navigation.internal.pb.t(this.l);
        dS = acVar.a - (((double) tVar.s()) / 2.0d);
        dR = acVar.b - (((double) tVar.r()) / 2.0d);
        float fA = cVar.a(cameraPosition.zoom + f, cameraPosition.target, this);
        CameraPosition.Builder builder = CameraPosition.builder(y(tVar, cameraPosition, dS, dR));
        builder.zoom(fA);
        cameraPositionBuild = builder.build();
        tVar.B(com.google.android.libraries.navigation.internal.abm.f.f(cameraPositionBuild));
        return y(tVar, cameraPositionBuild, -dS, -dR);
    }

    public final synchronized CameraPosition f() {
        return com.google.android.libraries.navigation.internal.abm.f.c(this.l.w());
    }

    public final synchronized CameraPosition g(CameraPosition cameraPosition) {
        ac acVarN;
        acVarN = n();
        return z(cameraPosition, acVarN.a, acVarN.b);
    }

    public final synchronized LatLng h(float f, float f2, boolean z) {
        float height;
        float f3;
        try {
            if (z) {
                ac acVarO = o();
                f3 = (float) acVarO.a;
                height = (float) acVarO.b;
            } else {
                com.google.android.libraries.navigation.internal.abf.ak akVarK = k();
                float width = akVarK.getWidth();
                height = akVarK.getHeight() / 2.0f;
                f3 = width / 2.0f;
            }
            com.google.android.libraries.navigation.internal.oe.r rVarB = new gu(new com.google.android.libraries.navigation.internal.pb.t(this.l)).b(new Point(Math.round(f3 + f), Math.round(height + f2)));
            if (rVarB == null) {
                return null;
            }
            return com.google.android.libraries.navigation.internal.abm.f.d(rVarB);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized com.google.android.libraries.navigation.internal.pd.e i() {
        return this.l.w().f515n;
    }

    public final synchronized com.google.android.libraries.navigation.internal.abf.ak j(com.google.android.libraries.navigation.internal.abf.ak akVar) {
        int i;
        int height;
        az azVar;
        if (((com.google.android.libraries.navigation.internal.abf.v) akVar).a <= 0 || ((com.google.android.libraries.navigation.internal.abf.v) akVar).b <= 0) {
            akVar = k();
        }
        int width = akVar.getWidth();
        az azVar2 = this.g;
        i = (width - azVar2.b) - azVar2.d;
        height = akVar.getHeight();
        azVar = this.g;
        return new com.google.android.libraries.navigation.internal.abf.v(i, (height - azVar.c) - azVar.e);
    }

    public final synchronized com.google.android.libraries.navigation.internal.abf.ak k() {
        com.google.android.libraries.navigation.internal.pb.t tVar = this.l;
        int iS = tVar.s();
        int iR = tVar.r();
        if (iS > 0 && iR > 0) {
            com.google.android.libraries.navigation.internal.abf.ak akVar = this.h;
            if (akVar == null || ((com.google.android.libraries.navigation.internal.abf.v) akVar).a != iS || ((com.google.android.libraries.navigation.internal.abf.v) akVar).b != iR) {
                this.h = new com.google.android.libraries.navigation.internal.abf.v(iS, iR);
            }
            return this.h;
        }
        return this.e;
    }

    public final synchronized dy l() {
        return m(k());
    }

    public final synchronized dy m(com.google.android.libraries.navigation.internal.abf.ak akVar) {
        com.google.android.libraries.navigation.internal.pb.t tVar;
        com.google.android.libraries.navigation.internal.oe.r rVar;
        com.google.android.libraries.navigation.internal.oe.r rVar2;
        com.google.android.libraries.navigation.internal.oe.r rVar3;
        com.google.android.libraries.navigation.internal.oe.r rVar4;
        com.google.android.libraries.navigation.internal.oe.t tVar2;
        tVar = new com.google.android.libraries.navigation.internal.pb.t(this.l);
        tVar.C(akVar.getWidth(), akVar.getHeight());
        float[] fArr = (float[]) c.get();
        Arrays.fill(fArr, 0.0f);
        float f = this.g.b;
        int width = akVar.getWidth();
        az azVar = this.g;
        com.google.android.libraries.navigation.internal.oe.l lVarH = com.google.android.libraries.navigation.internal.pb.j.h(tVar, f, width - azVar.d, azVar.c, akVar.getHeight() - this.g.e, fArr);
        Object[] objArr = {this.l.w()};
        if (lVarH == null) {
            throw new NullPointerException(String.format("Frustum is null at %s", objArr));
        }
        com.google.android.libraries.navigation.internal.abf.s.e(true, "Ground plane projection should have four vertices %s", 4);
        com.google.android.libraries.navigation.internal.oe.x[] xVarArr = (com.google.android.libraries.navigation.internal.oe.x[]) d.get();
        Arrays.fill(xVarArr, (Object) null);
        xVarArr[0] = lVarH.j(0);
        xVarArr[1] = lVarH.j(1);
        xVarArr[2] = lVarH.j(2);
        xVarArr[3] = lVarH.j(3);
        com.google.android.libraries.navigation.internal.oe.bc bcVar = new com.google.android.libraries.navigation.internal.oe.bc(xVarArr);
        com.google.android.libraries.navigation.internal.oe.bb bbVar = new com.google.android.libraries.navigation.internal.oe.bb(com.google.android.libraries.navigation.internal.oe.h.a(bcVar.b[0]), com.google.android.libraries.navigation.internal.oe.h.a(bcVar.b[1]), com.google.android.libraries.navigation.internal.oe.h.a(bcVar.b[3]), com.google.android.libraries.navigation.internal.oe.h.a(bcVar.b[2]), com.google.android.libraries.navigation.internal.oe.h.b(bcVar.d));
        rVar = bbVar.a;
        rVar2 = bbVar.b;
        rVar3 = bbVar.c;
        rVar4 = bbVar.d;
        tVar2 = bbVar.e;
        return new dy(new gu(tVar), new VisibleRegion(com.google.android.libraries.navigation.internal.abm.f.d(rVar), com.google.android.libraries.navigation.internal.abm.f.d(rVar2), com.google.android.libraries.navigation.internal.abm.f.d(rVar3), com.google.android.libraries.navigation.internal.abm.f.d(rVar4), new LatLngBounds(com.google.android.libraries.navigation.internal.abm.f.d(tVar2.a), com.google.android.libraries.navigation.internal.abm.f.d(tVar2.b))));
    }

    public final synchronized ac n() {
        az azVar = this.g;
        int i = azVar.b - azVar.d;
        double d2 = azVar.c - azVar.e;
        double d3 = ((double) i) / 2.0d;
        double d4 = d2 / 2.0d;
        ac acVar = this.j;
        if (acVar == null || acVar.a != d3 || acVar.b != d4) {
            this.j = new ac(d3, d4);
        }
        return this.j;
    }

    public final synchronized ac o() {
        com.google.android.libraries.navigation.internal.abf.ak akVarK = k();
        double d2 = this.g.b;
        int width = akVarK.getWidth();
        az azVar = this.g;
        int i = (width - azVar.b) - azVar.d;
        double d3 = azVar.c;
        int height = akVarK.getHeight();
        az azVar2 = this.g;
        double d4 = d2 + (((double) i) / 2.0d);
        double d5 = d3 + (((double) ((height - azVar2.c) - azVar2.e)) / 2.0d);
        ac acVar = this.i;
        if (acVar == null || acVar.a != d4 || acVar.b != d5) {
            this.i = new ac(d4, d5);
        }
        return this.i;
    }

    public final synchronized az p() {
        return this.g;
    }

    public final synchronized void q(be beVar) {
        synchronized (beVar) {
            com.google.android.libraries.navigation.internal.abf.s.k(beVar, "other");
            com.google.android.libraries.navigation.internal.abf.ak akVarK = beVar.k();
            w(akVarK.getWidth(), akVarK.getHeight());
            u(beVar.f(), beVar.i());
        }
    }

    public final synchronized void r(az azVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(azVar, "Cannot set null WindowPadding.");
        if (com.google.android.libraries.navigation.internal.abf.r.a(this.g, azVar)) {
            return;
        }
        this.g = azVar;
    }

    public final synchronized void s() {
        this.k = true;
    }

    public final synchronized void t(CameraPosition cameraPosition) {
        this.l.B(com.google.android.libraries.navigation.internal.abm.f.f(cameraPosition));
    }

    public final synchronized void u(CameraPosition cameraPosition, com.google.android.libraries.navigation.internal.pd.e eVar) {
        this.l.B(com.google.android.libraries.navigation.internal.abm.f.g(cameraPosition, eVar));
    }

    public final synchronized void v(Float f) {
        this.m = f;
    }

    public final synchronized void w(int i, int i2) {
        this.l.C(i, i2);
    }

    public final synchronized boolean x() {
        return this.k;
    }
}
