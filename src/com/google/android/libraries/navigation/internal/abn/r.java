package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r implements bf {
    final /* synthetic */ float a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ u e;

    public r(u uVar, float f, int i, int i2, int i3) {
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.e.e, "Camera moved during a cancellation");
        awVar.j();
        ac acVarN = awVar.a.n();
        CameraPosition cameraPositionD = awVar.d();
        ac acVar = new ac(((double) this.b) - acVarN.a, ((double) this.c) - acVarN.b);
        awVar.j();
        CameraPosition cameraPositionE = awVar.a.e(cameraPositionD, this.a, acVar, this.e.c);
        com.google.android.libraries.navigation.internal.abf.s.a(true, "Unable to zoom around an invalid location on the screen.");
        this.e.C(awVar, "CAMERA_UPDATE_ZOOM_BY_FIXING", cameraPositionE, u.y(this.d), 3);
    }
}
