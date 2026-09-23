package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements bf {
    final /* synthetic */ LatLng a;
    final /* synthetic */ float b;
    final /* synthetic */ int c;
    final /* synthetic */ u d;

    public e(u uVar, LatLng latLng, float f, int i) {
        this.a = latLng;
        this.b = f;
        this.c = i;
        this.d = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.d.e, "Camera moved during a cancellation");
        CameraPosition.Builder builder = CameraPosition.builder(awVar.d());
        builder.target(this.a);
        builder.zoom(this.b);
        this.d.C(awVar, "CAMERA_UPDATE_NEW_LATLNG_ZOOM", builder.build(), this.c, 3);
    }
}
