package com.google.android.libraries.navigation.internal.lh;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at extends com.google.android.libraries.navigation.internal.d.a implements au {
    public at(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.libraries.navigation.internal.lh.au
    public final com.google.android.libraries.navigation.internal.lc.x e(com.google.android.libraries.navigation.internal.lc.v vVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, vVar);
        Parcel parcelB = b(6, parcelA);
        com.google.android.libraries.navigation.internal.lc.x xVar = (com.google.android.libraries.navigation.internal.lc.x) com.google.android.libraries.navigation.internal.d.c.a(parcelB, com.google.android.libraries.navigation.internal.lc.x.CREATOR);
        parcelB.recycle();
        return xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.au
    public final boolean f(com.google.android.libraries.navigation.internal.lc.z zVar, com.google.android.libraries.navigation.internal.lo.l lVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, zVar);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        Parcel parcelB = b(5, parcelA);
        boolean zE = com.google.android.libraries.navigation.internal.d.c.e(parcelB);
        parcelB.recycle();
        return zE;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.au
    public final boolean g() throws RemoteException {
        Parcel parcelB = b(7, a());
        boolean zE = com.google.android.libraries.navigation.internal.d.c.e(parcelB);
        parcelB.recycle();
        return zE;
    }
}
