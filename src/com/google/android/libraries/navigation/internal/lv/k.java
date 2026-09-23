package com.google.android.libraries.navigation.internal.lv;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.d.a implements l {
    public k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.libraries.navigation.internal.lv.l
    public final void e(ai aiVar, com.google.android.libraries.navigation.internal.lu.z zVar, com.google.android.libraries.navigation.internal.le.al alVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, aiVar);
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, zVar);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, alVar);
        z(88, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.lv.l
    public final void f(PendingIntent pendingIntent) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, pendingIntent);
        z(6, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.lv.l
    public final void g(ai aiVar, com.google.android.libraries.navigation.internal.le.al alVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, aiVar);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, alVar);
        z(89, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.lv.l
    public final void h(d dVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, dVar);
        z(75, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.lv.l
    public final void i(am amVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, amVar);
        z(59, parcelA);
    }
}
