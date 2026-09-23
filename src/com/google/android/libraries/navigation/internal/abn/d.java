package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements bf {
    final /* synthetic */ LatLng a;
    final /* synthetic */ int b;
    final /* synthetic */ u c;

    public d(u uVar, LatLng latLng, int i) {
        this.a = latLng;
        this.b = i;
        this.c = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.c.e, "Camera moved during a cancellation");
        CameraPosition.Builder builder = CameraPosition.builder(awVar.d());
        builder.target(this.a);
        this.c.C(awVar, "CAMERA_UPDATE_NEW_LATLNG", builder.build(), this.b, 3);
    }
}
