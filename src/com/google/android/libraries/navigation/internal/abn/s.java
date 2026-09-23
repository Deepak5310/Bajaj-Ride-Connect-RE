package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s implements bf {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ int c;
    final /* synthetic */ u d;

    public s(u uVar, float f, float f2, int i) {
        this.a = f;
        this.b = f2;
        this.c = i;
        this.d = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.d.e, "Camera moved during a cancellation");
        float f = this.a;
        CameraPosition cameraPositionD = awVar.d();
        LatLng latLngE = awVar.e(f, this.b, true);
        com.google.android.libraries.navigation.internal.abf.s.a(latLngE != null, "Unable to scroll to an invalid location.");
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionD);
        builder.target(latLngE);
        this.d.C(awVar, "CAMERA_UPDATE_SCROLL_BY", builder.build(), u.y(this.c), 3);
    }
}
