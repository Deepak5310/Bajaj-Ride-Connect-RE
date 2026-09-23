package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.FollowMyLocationOptions;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class br implements bq {
    private com.google.android.libraries.navigation.internal.pd.i a;
    private final bu b;
    private final ac c;
    private float d;
    private com.google.android.libraries.navigation.internal.afl.fd e = com.google.android.libraries.navigation.internal.afl.fd.UNKNOWN_CAMERA_TYPE;
    private FollowMyLocationOptions f;
    private final com.google.android.libraries.navigation.internal.po.gr g;

    public br(Context context, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, ac acVar, com.google.android.libraries.navigation.internal.oa.k kVar, float f) {
        this.b = new bu(context, acVar, f, aVar, kVar.c(), eVar);
        this.g = kVar.p;
        this.c = acVar;
    }

    private final void j() {
        CameraPosition cameraPositionC = this.c.c();
        this.c.i(new CameraPosition(cameraPositionC.target, cameraPositionC.zoom, 0.0f, 0.0f), 400);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void a() {
        this.a = null;
        j();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void b() {
        j();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void c(Location location) {
        if (this.a == null) {
            return;
        }
        bu buVar = this.b;
        buVar.a = location;
        buVar.d.m(com.google.android.libraries.navigation.internal.db.t.c(location));
        buVar.d.b(buVar.e);
        this.g.b();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void d(float f) {
        this.d = f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void e() {
        f(this.e, this.f);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void f(com.google.android.libraries.navigation.internal.afl.fd fdVar, FollowMyLocationOptions followMyLocationOptions) {
        this.e = fdVar;
        this.f = followMyLocationOptions;
        com.google.android.libraries.navigation.internal.pd.f fVar = new com.google.android.libraries.navigation.internal.pd.f();
        if (fdVar == com.google.android.libraries.navigation.internal.afl.fd.CAMERA_3D) {
            fVar.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_AND_BEARING;
            fVar.b = 18.0f;
            fVar.c = 45.0f;
        } else if (fdVar == com.google.android.libraries.navigation.internal.afl.fd.CAMERA_2D_NORTH_UP || fdVar == com.google.android.libraries.navigation.internal.afl.fd.CAMERA_2D_HEADING_UP) {
            fVar.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_ONLY;
            fVar.b = 16.0f;
            fVar.c = 0.0f;
            fVar.d = 0.0f;
        }
        FollowMyLocationOptions followMyLocationOptions2 = this.f;
        if (followMyLocationOptions2 == null || followMyLocationOptions2.getZoomLevel() == null) {
            float f = this.d;
            if (f > 0.0f) {
                fVar.b = f;
            }
        } else {
            fVar.b = this.f.getZoomLevel().floatValue();
        }
        com.google.android.libraries.navigation.internal.pd.i iVarA = fVar.a();
        this.a = iVarA;
        bu buVar = this.b;
        buVar.c.f(iVarA, false);
        buVar.b.b(buVar.c);
        buVar.f.g(buVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final boolean g() {
        return this.a != null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final boolean h() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void i() {
        this.a = null;
    }
}
