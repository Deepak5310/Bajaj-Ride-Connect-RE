package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements ab {
    final /* synthetic */ LatLngBounds a;
    final /* synthetic */ int b;

    public ag(LatLngBounds latLngBounds, int i) {
        this.a = latLngBounds;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_NEW_LATLNG_BOUNDS);
        acVar.k(this.a, this.b, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_NEW_LATLNG_BOUNDS";
    }
}
