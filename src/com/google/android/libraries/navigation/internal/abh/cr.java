package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cr extends com.google.android.libraries.navigation.internal.lz.g implements fl {
    private static final GroundOverlayOptions d = new GroundOverlayOptions();
    private static final com.google.android.libraries.navigation.internal.lo.l e = new com.google.android.libraries.navigation.internal.lo.n(null);
    private static final AtomicInteger f = new AtomicInteger(0);
    public final fm a;
    public cq b;
    public final com.google.android.libraries.navigation.internal.abf.z c;
    private final String g;
    private final ht h;
    private LatLngBounds i;
    private float j;
    private float k;
    private LatLng l;
    private float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f116n;
    private int o;
    private x p;
    private float q;
    private float r;
    private float s;
    private final z t;
    private float u;
    private boolean v;
    private boolean w;
    private boolean x;
    private com.google.android.libraries.navigation.internal.lo.l y;

    public cr(GroundOverlayOptions groundOverlayOptions, fm fmVar, z zVar, ht htVar, com.google.android.libraries.navigation.internal.abf.z zVar2) {
        com.google.android.libraries.navigation.internal.abf.s.j(fmVar);
        this.a = fmVar;
        com.google.android.libraries.navigation.internal.abf.s.j(htVar);
        this.h = htVar;
        this.g = String.format(Locale.getDefault(), "go%d", Integer.valueOf(f.getAndIncrement()));
        this.t = zVar;
        this.c = zVar2;
        this.y = e;
        com.google.android.libraries.navigation.internal.abf.s.a(groundOverlayOptions.getWidth() >= 0.0f, "line width is negative");
        com.google.android.libraries.navigation.internal.abf.s.a(groundOverlayOptions.getImage() != null, "Options doesn't specify an image");
        this.r = groundOverlayOptions.getAnchorU();
        this.s = groundOverlayOptions.getAnchorV();
        this.v = groundOverlayOptions.isVisible();
        this.u = groundOverlayOptions.getZIndex();
        this.q = groundOverlayOptions.getTransparency();
        this.w = groundOverlayOptions.isClickable();
        x xVar = (x) com.google.android.libraries.navigation.internal.lo.n.b(groundOverlayOptions.getImage().a);
        this.p = xVar;
        zVar.b(xVar);
        Bitmap bitmapA = zVar.a(this.p);
        this.f116n = bitmapA.getHeight();
        this.o = bitmapA.getWidth();
        com.google.android.libraries.navigation.internal.abf.s.a((groundOverlayOptions.getLocation() == null && groundOverlayOptions.getBounds() == null) ? false : true, "Options doesn't specify a position");
        if (groundOverlayOptions.getBounds() != null) {
            this.i = groundOverlayOptions.getBounds();
            J();
        } else {
            this.l = groundOverlayOptions.getLocation();
            this.j = groundOverlayOptions.getWidth();
            this.k = groundOverlayOptions.getHeight() != -1.0f ? groundOverlayOptions.getHeight() : (this.f116n / this.o) * this.j;
            K();
        }
        this.m = groundOverlayOptions.getBearing();
        float bearing = groundOverlayOptions.getBearing();
        GroundOverlayOptions groundOverlayOptions2 = d;
        if (bearing != groundOverlayOptions2.getBearing()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_BEARING);
        }
        if (groundOverlayOptions.getTransparency() != groundOverlayOptions2.getTransparency()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_TRANSPARENCY);
        }
        if (groundOverlayOptions.isVisible() != groundOverlayOptions2.isVisible()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_VISIBILITY);
        }
        if (groundOverlayOptions.getZIndex() != groundOverlayOptions2.getZIndex()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_Z_INDEX);
        }
        if (groundOverlayOptions.isClickable() != groundOverlayOptions2.isClickable()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_CLICKABILITY);
        }
    }

    private final synchronized float H(LatLngBounds latLngBounds) {
        return (float) (Math.toRadians(latLngBounds.northeast.latitude - latLngBounds.southwest.latitude) * 6371009.0d);
    }

    private final synchronized float I(LatLngBounds latLngBounds) {
        LatLng latLng;
        double dB;
        latLng = this.l;
        dB = bw.b(latLngBounds.northeast.longitude, latLngBounds.southwest.longitude);
        return (float) (Math.toRadians(dB) * 6371009.0d * Math.cos(Math.toRadians(latLng.latitude)));
    }

    private final synchronized void J() {
        LatLngBounds latLngBounds = this.i;
        LatLng latLng = latLngBounds.northeast;
        double d2 = latLng.latitude;
        LatLng latLng2 = latLngBounds.southwest;
        double d3 = latLng2.latitude;
        double d4 = latLng.longitude;
        double d5 = latLng2.longitude;
        if (d4 < d5) {
            d4 += 360.0d;
        }
        float f2 = this.r;
        float f3 = this.s;
        this.l = new LatLng((((double) (1.0f - f3)) * d2) + (((double) f3) * d3), (((double) (1.0f - f2)) * d5) + (((double) f2) * d4));
        this.j = I(latLngBounds);
        this.k = H(this.i);
    }

    private final synchronized void K() {
        LatLng latLng = this.l;
        this.i = bw.f(latLng, this.r, this.s, bw.i(this.k), bw.a(latLng, this.j));
    }

    private final void L(int i) {
        synchronized (this) {
            if (this.x) {
                return;
            }
            cq cqVar = this.b;
            if (cqVar != null) {
                com.google.android.libraries.navigation.internal.abm.ae aeVar = (com.google.android.libraries.navigation.internal.abm.ae) cqVar;
                aeVar.f.a();
                boolean z = aeVar.j;
                com.google.android.libraries.navigation.internal.abf.s.e(z, "isInitialized=%s", Boolean.valueOf(z));
                if (aeVar.k) {
                    return;
                }
                switch (i) {
                    case 0:
                    case 1:
                    case 4:
                        aeVar.e();
                        aeVar.i.c((com.google.android.libraries.navigation.internal.adg.aq) aeVar.h.t(), com.google.android.libraries.navigation.internal.abm.ae.a, aeVar.d(), aeVar.c());
                        return;
                    case 2:
                    case 3:
                        com.google.android.libraries.navigation.internal.adg.ap apVar = aeVar.h;
                        int i2 = ((com.google.android.libraries.navigation.internal.adg.aq) apVar.b).i;
                        int iA = aeVar.e.a(aeVar.c, aeVar.d.C(), aeVar.d.B());
                        if (!apVar.b.H()) {
                            apVar.v();
                        }
                        com.google.android.libraries.navigation.internal.adg.aq aqVar = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
                        aqVar.b |= 128;
                        aqVar.i = iA;
                        com.google.android.libraries.navigation.internal.abm.z zVar = aeVar.i;
                        int i3 = ((com.google.android.libraries.navigation.internal.adg.aq) aeVar.h.b).i;
                        zVar.b.a();
                        if (zVar.c != null) {
                            zVar.c.b(zVar.a.e().i().c(i3));
                        }
                        aeVar.e.d(aeVar.c, i2);
                        return;
                    case 5:
                    case 6:
                        com.google.android.libraries.navigation.internal.abm.z zVar2 = aeVar.i;
                        float fC = aeVar.c();
                        zVar2.b.a();
                        com.google.android.libraries.navigation.internal.ol.g gVar = zVar2.c;
                        if (gVar != null) {
                            gVar.a(fC);
                            return;
                        }
                        return;
                    default:
                        aeVar.i.e(aeVar.d());
                        return;
                }
            }
        }
    }

    public final synchronized float A() {
        return 1.0f - this.q;
    }

    public final synchronized float B() {
        return this.u;
    }

    public final synchronized Bitmap C() {
        return this.t.a(this.p);
    }

    public final synchronized LatLngBounds D() {
        return this.i;
    }

    public final synchronized boolean E() {
        return this.w;
    }

    public final synchronized boolean F() {
        return this.v;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fl
    public final void G() {
        cq cqVar = this.b;
        if (cqVar != null) {
            com.google.android.libraries.navigation.internal.abm.ae aeVar = (com.google.android.libraries.navigation.internal.abm.ae) cqVar;
            aeVar.f.a();
            boolean z = aeVar.j;
            com.google.android.libraries.navigation.internal.abf.s.e(z, "isInitialized=%s", Boolean.valueOf(z));
            if (!aeVar.k) {
                aeVar.i.a();
                aeVar.e.d(aeVar.c, ((com.google.android.libraries.navigation.internal.adg.aq) aeVar.h.b).i);
                aeVar.k = true;
            }
        }
        synchronized (this) {
            if (this.x) {
                return;
            }
            this.y = e;
            this.x = true;
            this.t.c(this.p);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized float a() {
        this.c.a();
        return z();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized float b() {
        this.c.a();
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized float c() {
        this.c.a();
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized float d() {
        this.c.a();
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized float e() {
        this.c.a();
        return B();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final int f() {
        return hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final com.google.android.libraries.navigation.internal.lo.l g() {
        this.c.a();
        return this.y;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized LatLng h() {
        this.c.a();
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized LatLngBounds i() {
        this.c.a();
        return D();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final String j() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void k() {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_REMOVE);
        G();
        this.a.b(this);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void l(float f2) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_BEARING);
        synchronized (this) {
            this.m = f2;
        }
        L(0);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void m(boolean z) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_CLICKABILITY);
        synchronized (this) {
            this.w = z;
        }
        L(7);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void n(float f2) {
        o(f2, -1.0f);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void o(float f2, float f3) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_SET_DIMENSIONS);
        synchronized (this) {
            this.j = f2;
            if (f3 == -1.0f) {
                f3 = (this.f116n / this.o) * f2;
            }
            this.k = f3;
            K();
        }
        L(1);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void p(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.c.a();
        com.google.android.libraries.navigation.internal.abf.s.k(lVar, "wrappedImageDescriptor");
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_SET_IMAGE);
        synchronized (this) {
            this.t.c(this.p);
            x xVar = (x) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
            this.p = xVar;
            this.t.b(xVar);
            Bitmap bitmapA = this.t.a(this.p);
            this.f116n = bitmapA.getHeight();
            this.o = bitmapA.getWidth();
        }
        L(2);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void q(LatLng latLng) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_SET_LOCATION);
        synchronized (this) {
            this.l = latLng;
            K();
        }
        L(4);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void r(LatLngBounds latLngBounds) {
        this.c.a();
        synchronized (this) {
            this.i = latLngBounds;
            J();
        }
        L(4);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void s(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_SET_TAG);
        this.y = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void t(float f2) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_TRANSPARENCY);
        boolean z = false;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.abf.s.a(z, "Transparency must be in the range [0..1]");
        synchronized (this) {
            this.q = f2;
        }
        L(6);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void u(boolean z) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_VISIBILITY);
        synchronized (this) {
            this.v = z;
        }
        L(5);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final void v(float f2) {
        this.c.a();
        this.h.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_Z_INDEX);
        synchronized (this) {
            this.u = f2;
        }
        L(3);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final boolean w(com.google.android.libraries.navigation.internal.lz.h hVar) {
        return equals(hVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized boolean x() {
        this.c.a();
        return E();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.h
    public final synchronized boolean y() {
        this.c.a();
        return F();
    }

    public final synchronized float z() {
        return this.m;
    }
}
