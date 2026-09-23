package com.google.android.libraries.navigation.internal.lh;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends com.google.android.libraries.navigation.internal.d.a implements ao {
    public am(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ao
    public final int c() throws RemoteException {
        Parcel parcelB = b(2, a());
        int i = parcelB.readInt();
        parcelB.recycle();
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ao
    public final com.google.android.libraries.navigation.internal.lo.l d() throws RemoteException {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        Parcel parcelB = b(1, a());
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
