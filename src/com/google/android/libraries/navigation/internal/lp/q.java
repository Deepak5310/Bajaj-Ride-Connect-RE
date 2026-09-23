package com.google.android.libraries.navigation.internal.lp;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends com.google.android.libraries.navigation.internal.d.a implements r {
    public q(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.libraries.navigation.internal.lp.r
    public final com.google.android.libraries.navigation.internal.lo.l e(com.google.android.libraries.navigation.internal.lo.l lVar, int i, com.google.android.libraries.navigation.internal.lo.l lVar2) throws RemoteException {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(i);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar2);
        Parcel parcelB = b(2, parcelA);
        IBinder strongBinder = parcelB.readStrongBinder();
        if (strongBinder == null) {
            jVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            jVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(strongBinder);
        }
        parcelB.recycle();
        return jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lp.r
    public final com.google.android.libraries.navigation.internal.lo.l f(com.google.android.libraries.navigation.internal.lo.l lVar, int i, com.google.android.libraries.navigation.internal.lo.l lVar2) throws RemoteException {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(i);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar2);
        Parcel parcelB = b(3, parcelA);
        IBinder strongBinder = parcelB.readStrongBinder();
        if (strongBinder == null) {
            jVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            jVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(strongBinder);
        }
        parcelB.recycle();
        return jVar;
    }
}
