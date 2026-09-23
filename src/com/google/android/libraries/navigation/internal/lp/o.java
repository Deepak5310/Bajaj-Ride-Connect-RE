package com.google.android.libraries.navigation.internal.lp;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends com.google.android.libraries.navigation.internal.d.a implements p {
    public o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.libraries.navigation.internal.lp.p
    public final int e() throws RemoteException {
        Parcel parcelB = b(6, a());
        int i = parcelB.readInt();
        parcelB.recycle();
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.lp.p
    public final com.google.android.libraries.navigation.internal.lo.l f(com.google.android.libraries.navigation.internal.lo.l lVar, int i) throws RemoteException {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(i);
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

    @Override // com.google.android.libraries.navigation.internal.lp.p
    public final com.google.android.libraries.navigation.internal.lo.l g(com.google.android.libraries.navigation.internal.lo.l lVar, int i, com.google.android.libraries.navigation.internal.lo.l lVar2) throws RemoteException {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(i);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar2);
        Parcel parcelB = b(8, parcelA);
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

    @Override // com.google.android.libraries.navigation.internal.lp.p
    public final com.google.android.libraries.navigation.internal.lo.l h(com.google.android.libraries.navigation.internal.lo.l lVar, int i) throws RemoteException {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(i);
        Parcel parcelB = b(4, parcelA);
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

    @Override // com.google.android.libraries.navigation.internal.lp.p
    public final int i(com.google.android.libraries.navigation.internal.lo.l lVar, boolean z) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(z ? 1 : 0);
        Parcel parcelB = b(3, parcelA);
        int i = parcelB.readInt();
        parcelB.recycle();
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.lp.p
    public final int j(com.google.android.libraries.navigation.internal.lo.l lVar, boolean z) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(z ? 1 : 0);
        Parcel parcelB = b(5, parcelA);
        int i = parcelB.readInt();
        parcelB.recycle();
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.lp.p
    public final com.google.android.libraries.navigation.internal.lo.l k(com.google.android.libraries.navigation.internal.lo.l lVar, boolean z, long j) throws RemoteException {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, lVar);
        parcelA.writeString("com.google.android.gms.googlecertificates");
        parcelA.writeInt(z ? 1 : 0);
        parcelA.writeLong(j);
        Parcel parcelB = b(7, parcelA);
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
