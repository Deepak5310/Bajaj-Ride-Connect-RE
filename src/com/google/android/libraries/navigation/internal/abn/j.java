package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements bf {
    final /* synthetic */ CameraPosition a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ u d;

    public j(u uVar, CameraPosition cameraPosition, int i, int i2) {
        this.a = cameraPosition;
        this.b = i;
        this.c = i2;
        this.d = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.d.e, "Camera moved during a cancellation");
        this.d.C(awVar, "CAMERA_UPDATE_NEW_CAMERA_POSITION", this.a, this.b, this.c);
    }
}
