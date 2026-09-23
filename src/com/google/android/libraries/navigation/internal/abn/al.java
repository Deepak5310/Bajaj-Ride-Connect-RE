package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.internal.abh.bt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al implements v {
    private final bt a;
    private final com.google.android.libraries.navigation.internal.abh.ac b;
    private com.google.android.libraries.navigation.internal.pd.d c;

    public al(com.google.android.libraries.navigation.internal.abh.ac acVar, bt btVar) {
        this.a = btVar;
        this.b = acVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return 4;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition c(be beVar, long j) {
        CameraPosition cameraPositionC = this.b.c();
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        aVar.e = cameraPositionC.bearing;
        aVar.d = cameraPositionC.bearing;
        aVar.c = cameraPositionC.zoom;
        LatLng latLng = cameraPositionC.target;
        aVar.d(new com.google.android.libraries.navigation.internal.oe.r(latLng.latitude, latLng.longitude));
        this.c = this.a.b(j, aVar);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.bearing(this.c.m);
        builder.tilt(this.c.l);
        builder.zoom(this.c.k);
        com.google.android.libraries.navigation.internal.oe.r rVar = this.c.i;
        builder.target(new LatLng(rVar.a, rVar.b));
        return builder.build();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition d() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final com.google.android.libraries.navigation.internal.pd.e e() {
        return this.c.f515n;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final com.google.android.libraries.navigation.internal.abf.q f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final void h(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean i() {
        return this.a.i() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean k(CameraPosition cameraPosition, be beVar) {
        return true;
    }
}
