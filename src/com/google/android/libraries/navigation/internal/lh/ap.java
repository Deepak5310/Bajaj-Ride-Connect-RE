package com.google.android.libraries.navigation.internal.lh;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ap extends com.google.android.libraries.navigation.internal.d.b implements aq {
    public ap() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i == 1) {
            int i2 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) com.google.android.libraries.navigation.internal.d.c.a(parcel, Bundle.CREATOR);
            com.google.android.libraries.navigation.internal.d.c.b(parcel);
            b(i2, strongBinder, bundle);
        } else if (i == 2) {
            parcel.readInt();
            com.google.android.libraries.navigation.internal.d.c.b(parcel);
            d();
        } else {
            if (i != 3) {
                return false;
            }
            int i3 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            r rVar = (r) com.google.android.libraries.navigation.internal.d.c.a(parcel, r.CREATOR);
            com.google.android.libraries.navigation.internal.d.c.b(parcel);
            c(i3, strongBinder2, rVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
