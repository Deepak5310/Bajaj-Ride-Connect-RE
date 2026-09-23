package com.google.android.libraries.navigation.internal.abn;

import android.os.RemoteException;
import android.view.View;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.bt;
import com.google.android.libraries.navigation.internal.abh.ga;
import com.google.android.libraries.navigation.internal.abh.ht;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements com.google.android.libraries.navigation.internal.abh.ac {
    public static final String b = "u";
    public final c c;
    public final aa d;
    public boolean e;
    public com.google.android.libraries.navigation.internal.ly.g f;
    public com.google.android.libraries.navigation.internal.ly.u g;
    public final CopyOnWriteArrayList h;
    private final bl i;
    private final be j;
    private final View k;

    public u(bl blVar, View view, c cVar) {
        aa aaVar = aa.a;
        this.i = blVar;
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.j = null;
        } else {
            be beVarC = blVar.c();
            com.google.android.libraries.navigation.internal.abf.s.k(beVarC, "WorldModelState must not be null.");
            this.j = beVarC;
        }
        com.google.android.libraries.navigation.internal.abf.s.k(view, "androidView");
        this.k = view;
        this.c = cVar;
        com.google.android.libraries.navigation.internal.abf.s.k(aaVar, "CameraUtils must not be null");
        this.d = aaVar;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = new CopyOnWriteArrayList();
    }

    public static void A(com.google.android.libraries.navigation.internal.ly.u uVar, CameraPosition cameraPosition) {
        if (uVar == null) {
            return;
        }
        try {
            uVar.a(cameraPosition);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private final void F(CameraPosition cameraPosition, int i, int i2) {
        com.google.android.libraries.navigation.internal.abf.s.k(cameraPosition, "CameraPosition must not be null.");
        com.google.android.libraries.navigation.internal.abf.t.a(i == -1 || i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid duration: "));
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new j(this, cameraPosition, i, i2));
        } else {
            com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
            B("CAMERA_UPDATE_NEW_CAMERA_POSITION", cameraPosition, i, i2);
        }
    }

    static int y(int i) {
        return i == -1 ? ExifDirectoryBase.TAG_SUB_IFD_OFFSET : i;
    }

    final void B(String str, CameraPosition cameraPosition, int i, int i2) {
        E(cameraPosition, i, false, i2);
    }

    final void C(aw awVar, String str, CameraPosition cameraPosition, int i, int i2) {
        D(awVar, cameraPosition, i, false, i2);
    }

    final void D(aw awVar, CameraPosition cameraPosition, int i, boolean z, int i2) {
        String str = b;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(cameraPosition.zoom));
        com.google.android.libraries.navigation.internal.ly.g gVar = this.f;
        t tVar = gVar != null ? new t(this, gVar) : null;
        this.f = null;
        awVar.j();
        CameraPosition cameraPositionG = awVar.a.g(cameraPosition);
        com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(cameraPositionG.zoom));
        CameraPosition cameraPositionB = this.c.b(cameraPositionG, awVar);
        if (!cameraPositionB.equals(cameraPositionG)) {
            com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        }
        int i3 = i == -1 ? ExifDirectoryBase.TAG_SUB_IFD_OFFSET : i;
        awVar.k(z ? Float.valueOf(cameraPositionB.zoom) : null);
        v axVar = i3 == 0 ? new ax(cameraPositionB, false, i2) : new aj(cameraPositionB, false, false, i3, i2);
        if (tVar != null) {
            axVar = new b(axVar, tVar);
        }
        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        this.i.e(axVar);
    }

    final void E(CameraPosition cameraPosition, int i, boolean z, int i2) {
        String str = b;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(cameraPosition.zoom));
        com.google.android.libraries.navigation.internal.ly.g gVar = this.f;
        t tVar = gVar != null ? new t(this, gVar) : null;
        this.f = null;
        CameraPosition cameraPositionG = this.j.g(cameraPosition);
        com.google.android.libraries.navigation.internal.abf.s.c(!Float.isNaN(cameraPositionG.zoom));
        CameraPosition cameraPositionC = this.c.c(cameraPositionG, this.j);
        if (!cameraPositionC.equals(cameraPositionG)) {
            com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        }
        int i3 = i == -1 ? ExifDirectoryBase.TAG_SUB_IFD_OFFSET : i;
        this.j.v(z ? Float.valueOf(cameraPositionC.zoom) : null);
        v axVar = i3 == 0 ? new ax(cameraPositionC, false, i2) : new aj(cameraPositionC, false, false, i3, i2);
        if (tVar != null) {
            axVar = new b(axVar, tVar);
        }
        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        this.i.e(axVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final float a(LatLng latLng) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLng, "LatLng must not be null.");
        this.c.h(latLng);
        return 21.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final float b() {
        return 2.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final CameraPosition c() {
        com.google.android.libraries.navigation.internal.afu.d.u();
        if (!com.google.android.libraries.navigation.internal.afu.d.j()) {
            return this.j.c();
        }
        k kVar = new k();
        this.i.d(kVar);
        return kVar.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final CameraPosition d(LatLngBounds latLngBounds) {
        com.google.android.libraries.navigation.internal.abf.ak akVarJ;
        com.google.android.libraries.navigation.internal.abf.v vVar = new com.google.android.libraries.navigation.internal.abf.v(this.k.getWidth(), this.k.getHeight());
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            g gVar = new g(vVar);
            this.i.d(gVar);
            akVarJ = gVar.a;
        } else {
            akVarJ = this.j.j(vVar);
        }
        com.google.android.libraries.navigation.internal.abf.v vVar2 = (com.google.android.libraries.navigation.internal.abf.v) akVarJ;
        return z(latLngBounds, vVar2.a, vVar2.b, 0);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final /* bridge */ /* synthetic */ ga e() {
        View view = this.k;
        com.google.android.libraries.navigation.internal.abf.v vVar = new com.google.android.libraries.navigation.internal.abf.v(view.getWidth(), view.getHeight());
        if (!com.google.android.libraries.navigation.internal.afu.d.j()) {
            return this.j.m(vVar);
        }
        l lVar = new l(vVar);
        this.i.d(lVar);
        return lVar.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void f(com.google.android.libraries.navigation.internal.ly.u uVar) {
        if (uVar != null) {
            this.h.add(uVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void g(bt btVar) {
        this.i.e(new al(this, btVar));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void h(CameraPosition cameraPosition, int i) {
        F(cameraPosition, i, 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void i(CameraPosition cameraPosition, int i) {
        F(cameraPosition, i, 2);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void j(LatLng latLng, int i) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLng, "LatLng must not be null.");
        com.google.android.libraries.navigation.internal.abf.t.a(i == -1 || i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid duration: "));
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new d(this, latLng, i));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        CameraPosition.Builder builder = CameraPosition.builder(c());
        builder.target(latLng);
        B("CAMERA_UPDATE_NEW_LATLNG", builder.build(), i, 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void k(LatLngBounds latLngBounds, int i, int i2) {
        com.google.android.libraries.navigation.internal.abf.t.c(latLngBounds, "LatLngBounds must not be null.");
        com.google.android.libraries.navigation.internal.abf.t.a(i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Padding must be non-negative: "));
        com.google.android.libraries.navigation.internal.abf.t.a(i2 == -1 || i2 >= 0, com.google.android.libraries.navigation.internal.b.b.b(i2, "Invalid duration: "));
        View view = this.k;
        com.google.android.libraries.navigation.internal.abf.v vVar = new com.google.android.libraries.navigation.internal.abf.v(view.getWidth(), view.getHeight());
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new h(this, vVar, i, latLngBounds, i2));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        com.google.android.libraries.navigation.internal.abf.v vVar2 = (com.google.android.libraries.navigation.internal.abf.v) this.j.j(vVar);
        int i3 = vVar2.b;
        boolean z = i < i3 / 2 || i < vVar2.a / 2;
        com.google.android.libraries.navigation.internal.abf.t.a(z, "Additional padding must be less than half the existing padded map view width or height: " + i + " vs " + vVar2.a + "x" + i3);
        B("CAMERA_UPDATE_NEW_LATLNG_BOUNDS", z(latLngBounds, vVar2.a, vVar2.b, i), i2, 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void l(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        com.google.android.libraries.navigation.internal.abf.t.c(latLngBounds, "LatLngBounds must not be null.");
        com.google.android.libraries.navigation.internal.abf.t.a(i > 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Width must be non-negative: "));
        com.google.android.libraries.navigation.internal.abf.t.a(i2 > 0, com.google.android.libraries.navigation.internal.b.b.b(i2, "Height must be non-negative: "));
        com.google.android.libraries.navigation.internal.abf.t.a(i3 >= 0, com.google.android.libraries.navigation.internal.b.b.b(i3, "Padding must be non-negative: "));
        com.google.android.libraries.navigation.internal.abf.t.a(i4 == -1 || i4 >= 0, com.google.android.libraries.navigation.internal.b.b.b(i4, "Invalid duration: "));
        com.google.android.libraries.navigation.internal.abf.v vVar = new com.google.android.libraries.navigation.internal.abf.v(i, i2);
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new i(this, vVar, i, i3, i2, latLngBounds, i4));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        com.google.android.libraries.navigation.internal.abf.v vVar2 = (com.google.android.libraries.navigation.internal.abf.v) this.j.j(vVar);
        int i5 = vVar2.b;
        boolean z = i3 < i5 / 2 || i3 < vVar2.a / 2;
        com.google.android.libraries.navigation.internal.abf.t.a(z, "Additional camera padding must be less than half of the existing padded map view width or height: " + i3 + " vs " + vVar2.a + "x" + i5);
        B("CAMERA_UPDATE_NEW_LATLNG_BOUNDS_WITH_DIMENSIONS", z(latLngBounds, vVar2.a, vVar2.b, i3), i4, 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void m(LatLng latLng, float f, int i) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLng, "LatLng must not be null.");
        com.google.android.libraries.navigation.internal.abf.t.a(i == -1 || i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid duration: "));
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new e(this, latLng, f, i));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        CameraPosition.Builder builder = CameraPosition.builder(c());
        builder.target(latLng);
        builder.zoom(f);
        B("CAMERA_UPDATE_NEW_LATLNG_ZOOM", builder.build(), i, 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void n() {
        this.h.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void o(com.google.android.libraries.navigation.internal.ly.u uVar) {
        if (uVar != null) {
            this.h.remove(uVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void p(float f, float f2, int i) {
        com.google.android.libraries.navigation.internal.abf.t.a(i == -1 || i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid duration: "));
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new s(this, f, f2, i));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        CameraPosition cameraPositionC = c();
        LatLng latLngH = this.j.h(f, f2, true);
        com.google.android.libraries.navigation.internal.abf.s.a(latLngH != null, "Unable to scroll to an invalid location.");
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionC);
        builder.target(latLngH);
        B("CAMERA_UPDATE_SCROLL_BY", builder.build(), y(i), 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void q(com.google.android.libraries.navigation.internal.ly.u uVar) {
        this.g = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void r(int i, int i2, int i3, int i4) {
        az azVar = new az(i, i2, i3, i4);
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new m(azVar));
        } else {
            this.j.r(azVar);
            String str = b;
            com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
            if (com.google.android.libraries.navigation.internal.abf.p.f(str, 3)) {
                this.j.o();
                this.j.k();
            }
        }
        this.i.f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abn.bj
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void s() {
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new n(this));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera stopped during a cancellation");
        com.google.android.libraries.navigation.internal.abf.s.d(this.f == null, "stopAnimation() is not a CameraUpdate.");
        B("MAP_STOP_ANIMATION", c(), 0, -4);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void t(com.google.android.libraries.navigation.internal.abh.ab abVar, int i, com.google.android.libraries.navigation.internal.ly.g gVar, ht htVar) {
        boolean z = true;
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        com.google.android.libraries.navigation.internal.abf.s.d(this.f == null, "Another CameraUpdate is already in progress.");
        com.google.android.libraries.navigation.internal.abf.t.c(abVar, "CameraUpdate must not be null.");
        com.google.android.libraries.navigation.internal.abf.t.a(i == -1 || i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid duration: "));
        if (i == 0 && gVar != null) {
            z = false;
        }
        com.google.android.libraries.navigation.internal.abf.t.a(z, "Callback supplied with instantaneous camera movement");
        com.google.android.libraries.navigation.internal.abf.s.k(htVar, "UsageLog must not be null.");
        this.f = gVar;
        try {
            abVar.a(this, i, htVar);
        } finally {
            this.f = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void u(float f, int i) {
        com.google.android.libraries.navigation.internal.abf.t.a(i == -1 || i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid duration: "));
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new p(this, f, i));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        CameraPosition cameraPositionC = c();
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionC);
        builder.zoom(cameraPositionC.zoom + f);
        B("CAMERA_UPDATE_ZOOM_BY", builder.build(), y(i), 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void v(float f, int i, int i2, int i3) {
        com.google.android.libraries.navigation.internal.abf.t.a(i3 == -1 || i3 >= 0, com.google.android.libraries.navigation.internal.b.b.b(i3, "Invalid duration: "));
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new r(this, f, i, i2, i3));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        be beVar = this.j;
        ac acVarN = beVar.n();
        CameraPosition cameraPositionE = beVar.e(c(), f, new ac(((double) i) - acVarN.a, ((double) i2) - acVarN.b), this.c);
        com.google.android.libraries.navigation.internal.abf.s.a(true, "Unable to zoom around an invalid location on the screen.");
        B("CAMERA_UPDATE_ZOOM_BY_FIXING", cameraPositionE, y(i3), 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void w(float f, int i) {
        com.google.android.libraries.navigation.internal.abf.t.a(i == -1 || i >= 0, com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid duration: "));
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new q(this, f, i));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        CameraPosition.Builder builder = CameraPosition.builder(c());
        builder.zoom(f);
        B("CAMERA_UPDATE_ZOOM_TO", builder.build(), y(i), 3);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ac
    public final void x(float f) {
        if (f == 0.0f) {
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.a(true, com.google.android.libraries.navigation.internal.b.b.b(-1, "Invalid duration: "));
        int i = true != com.google.android.libraries.navigation.internal.afu.d.a.a().B() ? 3 : 2;
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.i.d(new o(this, f, i));
            return;
        }
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e, "Camera moved during a cancellation");
        com.google.android.libraries.navigation.internal.abf.s.d(this.f == null, "zoomByCumulative() is not a CameraUpdate.");
        CameraPosition cameraPositionC = c();
        float fB = this.j.b();
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionC);
        builder.zoom(fB + f);
        E(builder.build(), y(-1), true, i);
    }

    public final CameraPosition z(LatLngBounds latLngBounds, int i, int i2, int i3) {
        int i4 = i3 + i3;
        int i5 = i - i4;
        int i6 = i2 - i4;
        boolean z = true;
        if (i5 <= 0 && i6 <= 0) {
            z = false;
        }
        com.google.android.libraries.navigation.internal.abf.s.d(z, "View size is too small after padding is applied.");
        if (!com.google.android.libraries.navigation.internal.afu.d.j()) {
            return new CameraPosition(this.d.c(latLngBounds).a(), (float) this.d.b(latLngBounds, i5, i6, this.j.a), 0.0f, 0.0f);
        }
        f fVar = new f(this, latLngBounds, i5, i6);
        this.i.d(fVar);
        return fVar.a;
    }
}
