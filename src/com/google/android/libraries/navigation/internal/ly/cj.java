package com.google.android.libraries.navigation.internal.ly;

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface cj {
    com.google.android.libraries.navigation.internal.lo.l a(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    StreetViewPanoramaCamera b() throws RemoteException;

    StreetViewPanoramaLocation c() throws RemoteException;

    StreetViewPanoramaOrientation d(com.google.android.libraries.navigation.internal.lo.l lVar) throws RemoteException;

    void e(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException;

    void f(boolean z) throws RemoteException;

    void g(boolean z) throws RemoteException;

    void h(boolean z) throws RemoteException;

    void i(boolean z) throws RemoteException;

    void j(bv bvVar) throws RemoteException;

    void k(bx bxVar) throws RemoteException;

    void l(bz bzVar) throws RemoteException;

    void m(cb cbVar) throws RemoteException;

    void n(LatLng latLng) throws RemoteException;

    void o(String str) throws RemoteException;

    void p(LatLng latLng, int i) throws RemoteException;

    void q(LatLng latLng, int i, StreetViewSource streetViewSource) throws RemoteException;

    void r(LatLng latLng, StreetViewSource streetViewSource) throws RemoteException;

    boolean s() throws RemoteException;

    boolean t() throws RemoteException;

    boolean u() throws RemoteException;

    boolean v() throws RemoteException;
}
