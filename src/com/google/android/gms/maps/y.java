package com.google.android.gms.maps;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class y extends com.google.android.libraries.navigation.internal.ly.ay {
    final /* synthetic */ GoogleMap.OnMapLongClickListener a;

    public y(GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.a = onMapLongClickListener;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.az
    public final void a(LatLng latLng) {
        this.a.onMapLongClick(latLng);
    }
}
