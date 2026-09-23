package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface ac {
    public static final CameraPosition a = CameraPosition.fromLatLngZoom(new LatLng(0.0d, 0.0d), 1.0f);

    float a(LatLng latLng);

    float b();

    CameraPosition c();

    CameraPosition d(LatLngBounds latLngBounds);

    ga e();

    void f(com.google.android.libraries.navigation.internal.ly.u uVar);

    void g(bt btVar);

    void h(CameraPosition cameraPosition, int i);

    void i(CameraPosition cameraPosition, int i);

    void j(LatLng latLng, int i);

    void k(LatLngBounds latLngBounds, int i, int i2);

    void l(LatLngBounds latLngBounds, int i, int i2, int i3, int i4);

    void m(LatLng latLng, float f, int i);

    void n();

    void o(com.google.android.libraries.navigation.internal.ly.u uVar);

    void p(float f, float f2, int i);

    void q(com.google.android.libraries.navigation.internal.ly.u uVar);

    void r(int i, int i2, int i3, int i4);

    void s();

    void t(ab abVar, int i, com.google.android.libraries.navigation.internal.ly.g gVar, ht htVar);

    void u(float f, int i);

    void v(float f, int i, int i2, int i3);

    void w(float f, int i);

    void x(float f);
}
