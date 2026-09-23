package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ao implements ab {
    final /* synthetic */ CameraPosition a;

    public ao(CameraPosition cameraPosition) {
        this.a = cameraPosition;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_NEW_CAMERA_POSITION);
        acVar.h(this.a, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_NEW_CAMERA_POSITION";
    }
}
