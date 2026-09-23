package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o implements bf {
    final /* synthetic */ float a;
    final /* synthetic */ int b;
    final /* synthetic */ u c;

    public o(u uVar, float f, int i) {
        this.a = f;
        this.b = i;
        this.c = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.c.e, "Camera moved during a cancellation");
        com.google.android.libraries.navigation.internal.abf.s.d(this.c.f == null, "zoomByCumulative() is not a CameraUpdate.");
        CameraPosition cameraPositionD = awVar.d();
        float fC = awVar.c();
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionD);
        builder.zoom(fC + this.a);
        this.c.D(awVar, builder.build(), u.y(-1), true, this.b);
    }
}
