package com.google.android.libraries.navigation.internal.abh;

import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fe extends com.google.android.libraries.navigation.internal.ly.aq implements View.OnClickListener {
    private final ac a;
    private final com.google.android.libraries.navigation.internal.abf.z b;
    public final be c;
    protected final fg d;
    public Location e;
    public boolean f;
    public boolean g;
    public com.google.android.libraries.navigation.internal.ly.bj h;
    public com.google.android.libraries.navigation.internal.ly.bh i;
    private final com.google.android.libraries.navigation.internal.ly.o j;
    private final fc k;
    private final com.google.android.libraries.navigation.internal.ly.o l;
    private final ht m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.ly.bl f120n;
    private final com.google.android.libraries.navigation.internal.yx.br o;
    private final bq p;

    public fe(be beVar, ac acVar, fc fcVar, fg fgVar, com.google.android.libraries.navigation.internal.ly.o oVar, ht htVar, com.google.android.libraries.navigation.internal.yx.br brVar, bq bqVar) {
        com.google.android.libraries.navigation.internal.abf.z zVar = com.google.android.libraries.navigation.internal.abf.z.a;
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "ContextManager");
        this.c = beVar;
        com.google.android.libraries.navigation.internal.abf.s.k(acVar, "CameraManager");
        this.a = acVar;
        com.google.android.libraries.navigation.internal.abf.s.k(fcVar, "MyLocationButton");
        this.k = fcVar;
        com.google.android.libraries.navigation.internal.abf.s.k(fgVar, "MyLocationRenderer");
        this.d = fgVar;
        this.j = oVar;
        this.l = oVar;
        this.m = htVar;
        this.g = true;
        com.google.android.libraries.navigation.internal.abf.s.k(brVar, "DRD");
        this.o = brVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "UiThreadChecker");
        this.b = zVar;
        this.f120n = null;
        this.p = bqVar;
    }

    private final float k(LatLng latLng, float f) {
        float f2 = this.a.c().zoom;
        if (f2 <= 10.0f) {
            f2 = 15.0f;
        }
        double d = f;
        double d2 = d + d;
        float f3 = this.a.d(bw.f(latLng, 0.5d, 0.5d, bw.i(d2), bw.a(latLng, d2))).zoom;
        return f3 == -1.0f ? f2 : Math.min(f2, f3);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.ar
    public final void a(com.google.android.libraries.navigation.internal.lo.l lVar) {
        f((Location) com.google.android.libraries.navigation.internal.lo.n.b(lVar));
    }

    public void b() {
        this.b.a();
        if (this.f) {
            this.f = false;
            h();
            try {
                this.l.b();
                this.d.a();
                this.d.g(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public void c() {
        this.b.a();
        if (this.f) {
            return;
        }
        this.f = true;
        this.d.b();
        this.d.g(this);
        try {
            this.l.a(this);
            h();
            Location location = this.e;
            if (location != null) {
                f(location);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public abstract void d(boolean z);

    public abstract void e(boolean z);

    public final void f(Location location) {
        this.d.h(location);
        if (this.h != null) {
            Location location2 = new Location(location);
            try {
                ((com.google.android.gms.maps.f) this.h).a.onMyLocationChange((Location) com.google.android.libraries.navigation.internal.lo.n.b(new com.google.android.libraries.navigation.internal.lo.n(location2)));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.e = location;
        this.p.d(k(new LatLng(location.getLatitude(), location.getLongitude()), location.getAccuracy()));
        this.p.c(location);
    }

    public final void g(com.google.android.libraries.navigation.internal.ly.bl blVar) {
        this.b.a();
        this.f120n = blVar;
        this.d.e(blVar != null);
    }

    public final void h() {
        boolean z = this.g && this.f;
        this.k.a.setVisibility(true != z ? 8 : 0);
        this.k.a(true != z ? null : this);
    }

    public final boolean i() {
        this.b.a();
        if (this.e == null || this.f120n == null) {
            return false;
        }
        this.m.c(com.google.android.libraries.navigation.internal.abx.b.MY_LOCATION_CLICK_WITH_LISTENER);
        try {
            com.google.android.libraries.navigation.internal.ly.bl blVar = this.f120n;
            ((com.google.android.gms.maps.h) blVar).a.onMyLocationClick(this.e);
            return true;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean j() {
        return this.l == this.j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(final View view) {
        Location location;
        this.m.c(com.google.android.libraries.navigation.internal.abx.b.MY_LOCATION_BUTTON_CLICK);
        com.google.android.libraries.navigation.internal.ly.bh bhVar = this.i;
        if (bhVar != null) {
            try {
                if (((com.google.android.gms.maps.g) bhVar).a.onMyLocationButtonClick()) {
                    return;
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        com.google.android.libraries.navigation.internal.abf.s.d(this.f, "MyLocation layer not enabled");
        Location location2 = this.e;
        if (location2 != null) {
            LatLng latLng = new LatLng(location2.getLatitude(), this.e.getLongitude());
            float fK = k(latLng, this.e.getAccuracy());
            CameraPosition.Builder builder = CameraPosition.builder(this.a.c());
            builder.target(latLng);
            builder.zoom(fK);
            this.a.i(builder.build(), -1);
        }
        if (!b.a(this.c.a) || (location = this.e) == null) {
            return;
        }
        LatLng latLng2 = new LatLng(location.getLatitude(), this.e.getLongitude());
        gk gkVar = new gk(latLng2, k(latLng2, this.e.getAccuracy()));
        gkVar.b = new gi() { // from class: com.google.android.libraries.navigation.internal.abh.fd
            @Override // com.google.android.libraries.navigation.internal.abh.gi
            public final void a(gk gkVar2) {
                if (gkVar2.k() > 0) {
                    View view2 = view;
                    fe feVar = this.a;
                    gj gjVarL = gkVar2.l();
                    view2.announceForAccessibility(feVar.c.n(com.google.android.gms.maps.am.i) + ": " + gjVarL.a());
                }
            }
        };
        ((com.google.android.libraries.navigation.internal.abg.q) this.o.a()).j(gkVar);
    }
}
