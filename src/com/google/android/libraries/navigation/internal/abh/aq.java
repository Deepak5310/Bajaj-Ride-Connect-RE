package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aq implements ab {
    final /* synthetic */ LatLng a;
    final /* synthetic */ float b;

    public aq(LatLng latLng, float f) {
        this.a = latLng;
        this.b = f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_NEW_LATLNG_ZOOM);
        acVar.m(this.a, this.b, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_NEW_LATLNG_ZOOM";
    }
}
