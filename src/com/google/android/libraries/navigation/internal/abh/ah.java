package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah implements ab {
    final /* synthetic */ LatLngBounds a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;

    public ah(LatLngBounds latLngBounds, int i, int i2, int i3) {
        this.a = latLngBounds;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_NEW_LATLNG_BOUNDS_WITH_DIMENSIONS);
        acVar.l(this.a, this.b, this.c, this.d, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_NEW_LATLNG_BOUNDS_WITH_DIMENSIONS";
    }
}
