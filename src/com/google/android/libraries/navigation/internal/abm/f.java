package com.google.android.libraries.navigation.internal.abm;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    public static CameraPosition c(com.google.android.libraries.navigation.internal.pd.d dVar) {
        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.target(d(dVar.i));
        builder.zoom(dVar.k);
        builder.tilt(dVar.l);
        builder.bearing(dVar.m);
        return builder.build();
    }

    public static LatLng d(com.google.android.libraries.navigation.internal.oe.r rVar) {
        return new LatLng(rVar.a, rVar.b);
    }

    public static com.google.android.libraries.navigation.internal.oe.r e(LatLng latLng) {
        return new com.google.android.libraries.navigation.internal.oe.r(latLng.latitude, latLng.longitude);
    }

    public static com.google.android.libraries.navigation.internal.pd.d f(CameraPosition cameraPosition) {
        return g(cameraPosition, null);
    }

    public static com.google.android.libraries.navigation.internal.pd.d g(CameraPosition cameraPosition, com.google.android.libraries.navigation.internal.pd.e eVar) {
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        aVar.d(e(cameraPosition.target));
        aVar.c = cameraPosition.zoom;
        aVar.d = cameraPosition.tilt;
        aVar.e = cameraPosition.bearing;
        if (eVar == null) {
            eVar = com.google.android.libraries.navigation.internal.pd.e.a;
        }
        aVar.f = eVar;
        return aVar.a();
    }

    public final int a(float f, float f2) {
        return Math.round((f / f2) * 8.0f);
    }

    public final int b(float f) {
        int iFloatToIntBits = Float.floatToIntBits(f);
        if (iFloatToIntBits == Float.floatToIntBits(0.0f)) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        return iFloatToIntBits < 0 ? iFloatToIntBits ^ Integer.MAX_VALUE : iFloatToIntBits;
    }
}
