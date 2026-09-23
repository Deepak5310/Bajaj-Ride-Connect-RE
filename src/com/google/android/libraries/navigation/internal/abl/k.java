package com.google.android.libraries.navigation.internal.abl;

import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.bt;
import com.google.android.libraries.navigation.internal.abh.ht;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.google.android.libraries.navigation.internal.abh.ac {
    private final l b;
    private final double c;
    private int g;
    private int h;
    private int i;
    private int j;
    private CameraPosition d = z(new CameraPosition(new LatLng(0.0d, 0.0d), 3.0f, 0.0f, 0.0f));
    private final CopyOnWriteArrayList f = new CopyOnWriteArrayList();
    private com.google.android.libraries.navigation.internal.ly.u e = null;

    public k(l lVar, float f) {
        this.b = lVar;
        this.c = Math.max(1.0d, Math.floor(f));
    }

    private final void A(CameraPosition cameraPosition) {
        this.d = z(cameraPosition);
        this.b.c.b();
        Iterator it2 = this.f.iterator();
        while (it2.hasNext()) {
            try {
                ((com.google.android.libraries.navigation.internal.ly.u) it2.next()).a(this.d);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        com.google.android.libraries.navigation.internal.ly.u uVar = this.e;
        if (uVar != null) {
            try {
                uVar.a(this.d);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    private static CameraPosition z(CameraPosition cameraPosition) {
        if (cameraPosition.tilt != 0.0f || cameraPosition.bearing != 0.0f) {
            com.google.android.libraries.navigation.internal.abf.p.b("Non zero bearing and tilt");
        }
        float f = cameraPosition.zoom;
        if (f != Math.round(f)) {
            com.google.android.libraries.navigation.internal.abf.p.b("Non integer zooms");
        }
        return new CameraPosition(cameraPosition.target, Math.round(Math.max(0.0f, Math.min(22.0f, cameraPosition.zoom))), 0.0f, 0.0f);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final float a(LatLng latLng) {
        return 22.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final float b() {
        return 0.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final CameraPosition c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final CameraPosition d(LatLngBounds latLngBounds) {
        l lVar = this.b;
        int width = lVar.getWidth();
        int height = lVar.getHeight();
        latLngBounds.getCenter();
        LatLng latLng = latLngBounds.southwest;
        double d = this.c;
        double d2 = 22.0d;
        z zVarF = aa.f(latLng, 22.0d, d);
        z zVarF2 = aa.f(latLngBounds.northeast, 22.0d, d);
        if (latLngBounds.southwest.longitude > latLngBounds.northeast.longitude) {
            zVarF2 = new z(zVarF2.a + ((long) ((int) aa.d(22.0d, d))), zVarF2.b);
        }
        long j = zVarF.a;
        long j2 = zVarF.b;
        long j3 = zVarF2.a - j;
        long j4 = j2 - zVarF2.b;
        while (true) {
            if (j3 <= width && j4 <= height) {
                return new CameraPosition(latLngBounds.getCenter(), (float) d2, 0.0f, 0.0f);
            }
            d2 -= 1.0d;
            j3 >>= 1;
            j4 >>= 1;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void f(com.google.android.libraries.navigation.internal.ly.u uVar) {
        this.f.add(uVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void g(bt btVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void h(CameraPosition cameraPosition, int i) {
        A(cameraPosition);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void i(CameraPosition cameraPosition, int i) {
        A(cameraPosition);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void j(LatLng latLng, int i) {
        CameraPosition cameraPosition = this.d;
        A(new CameraPosition(latLng, cameraPosition.zoom, cameraPosition.tilt, cameraPosition.bearing));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void k(LatLngBounds latLngBounds, int i, int i2) {
        A(d(latLngBounds));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void l(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        com.google.android.libraries.navigation.internal.abf.p.e("newLatLngBounds with size");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void m(LatLng latLng, float f, int i) {
        CameraPosition cameraPosition = this.d;
        A(new CameraPosition(latLng, f, cameraPosition.tilt, cameraPosition.bearing));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void n() {
        this.f.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void o(com.google.android.libraries.navigation.internal.ly.u uVar) {
        this.f.remove(uVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void p(float f, float f2, int i) {
        com.google.android.libraries.navigation.internal.abf.p.e("scrollBy");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void q(com.google.android.libraries.navigation.internal.ly.u uVar) {
        this.e = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void r(int i, int i2, int i3, int i4) {
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = i4;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void s() {
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0009 A[PHI: r4
      0x0009: PHI (r4v1 int) = (r4v0 int), (r4v5 int) binds: [B:3:0x0001, B:5:0x0004] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void t(com.google.android.libraries.navigation.internal.abh.ab abVar, int i, com.google.android.libraries.navigation.internal.ly.g gVar, ht htVar) {
        int i2;
        boolean z;
        if (i == 0) {
            i = 0;
            z = false;
            if (gVar == null) {
                i2 = i;
                z = true;
            } else {
                i2 = 0;
            }
        } else {
            i2 = i;
            z = true;
        }
        com.google.android.libraries.navigation.internal.abf.s.a(z, "Callback supplied with instantaneous camera movement");
        com.google.android.libraries.navigation.internal.abf.s.d(true, "Camera moved during a cancellation");
        abVar.a(this, i2, htVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void u(float f, int i) {
        CameraPosition cameraPosition = this.d;
        A(new CameraPosition(cameraPosition.target, cameraPosition.zoom + f, cameraPosition.tilt, cameraPosition.bearing));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void v(float f, int i, int i2, int i3) {
        com.google.android.libraries.navigation.internal.abf.p.e("zoomBy with focus");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void w(float f, int i) {
        CameraPosition cameraPosition = this.d;
        A(new CameraPosition(cameraPosition.target, f, cameraPosition.tilt, cameraPosition.bearing));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void x(float f) {
        com.google.android.libraries.navigation.internal.abf.p.e("zoomByCumulative");
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final aa e() {
        l lVar = this.b;
        return new aa(this.d, lVar.getWidth(), lVar.getHeight(), this.c, this.g, this.h, this.i, this.j);
    }
}
