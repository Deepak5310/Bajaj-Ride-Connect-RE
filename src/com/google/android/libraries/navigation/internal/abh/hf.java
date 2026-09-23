package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface hf {
    public static final StreetViewPanoramaCamera a = new StreetViewPanoramaCamera(0.0f, 0.0f, 0.0f);

    StreetViewPanoramaCamera a();

    StreetViewPanoramaLocation b();

    StreetViewPanoramaOrientation c(int i, int i2);

    void d(com.google.android.libraries.navigation.internal.ly.bv bvVar);

    void e(com.google.android.libraries.navigation.internal.ly.bx bxVar);

    void f(com.google.android.libraries.navigation.internal.ly.bz bzVar);

    void g(com.google.android.libraries.navigation.internal.ly.cb cbVar);

    void h(he heVar);

    boolean i();

    void onPause();

    void onResume();
}
