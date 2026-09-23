package com.google.android.libraries.navigation.internal.lh;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class an extends com.google.android.libraries.navigation.internal.d.b implements ao {
    public an() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i == 1) {
            com.google.android.libraries.navigation.internal.lo.l lVarD = d();
            parcel2.writeNoException();
            com.google.android.libraries.navigation.internal.d.c.d(parcel2, lVarD);
        } else {
            if (i != 2) {
                return false;
            }
            int iC = c();
            parcel2.writeNoException();
            parcel2.writeInt(iC);
        }
        return true;
    }
}
