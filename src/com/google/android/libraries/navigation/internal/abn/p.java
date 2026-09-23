package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements bf {
    final /* synthetic */ float a;
    final /* synthetic */ int b;
    final /* synthetic */ u c;

    public p(u uVar, float f, int i) {
        this.a = f;
        this.b = i;
        this.c = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.c.e, "Camera moved during a cancellation");
        CameraPosition cameraPositionD = awVar.d();
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionD);
        builder.zoom(cameraPositionD.zoom + this.a);
        this.c.C(awVar, "CAMERA_UPDATE_ZOOM_BY", builder.build(), u.y(this.b), 3);
    }
}
