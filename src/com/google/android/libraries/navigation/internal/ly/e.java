package com.google.android.libraries.navigation.internal.ly;

import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface e {
    com.google.android.libraries.navigation.internal.lo.l a(CameraPosition cameraPosition) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l b(LatLng latLng) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l c(LatLngBounds latLngBounds, int i) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l d(LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l e(LatLng latLng, float f) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l f(float f, float f2) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l g(float f) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l h(float f, int i, int i2) throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l i() throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l j() throws RemoteException;

    com.google.android.libraries.navigation.internal.lo.l k(float f) throws RemoteException;
}
