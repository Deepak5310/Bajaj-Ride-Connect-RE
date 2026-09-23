package com.google.android.gms.maps;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class x extends com.google.android.libraries.navigation.internal.ly.au {
    final /* synthetic */ GoogleMap.OnMapClickListener a;

    public x(GoogleMap.OnMapClickListener onMapClickListener) {
        this.a = onMapClickListener;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.av
    public final void a(LatLng latLng) {
        this.a.onMapClick(latLng);
    }
}
