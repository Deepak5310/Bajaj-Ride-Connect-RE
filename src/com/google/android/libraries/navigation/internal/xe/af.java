package com.google.android.libraries.navigation.internal.xe;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public static CameraPosition a(com.google.android.libraries.navigation.internal.pd.d dVar) {
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.bearing(dVar.m);
        builder.tilt(dVar.l);
        builder.zoom(dVar.k);
        com.google.android.libraries.navigation.internal.oe.r rVar = dVar.i;
        builder.target(new LatLng(rVar.a, rVar.b));
        return builder.build();
    }
}
