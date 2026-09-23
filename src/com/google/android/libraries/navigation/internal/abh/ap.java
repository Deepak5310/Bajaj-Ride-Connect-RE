package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ap implements ab {
    final /* synthetic */ LatLng a;

    public ap(LatLng latLng) {
        this.a = latLng;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_NEW_LATLNG);
        acVar.j(this.a, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_NEW_LATLNG";
    }
}
