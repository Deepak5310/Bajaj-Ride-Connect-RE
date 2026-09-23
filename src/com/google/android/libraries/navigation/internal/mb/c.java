package com.google.android.libraries.navigation.internal.mb;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ld.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends com.google.android.libraries.navigation.internal.d.b implements d {
    public c() {
        super("com.google.android.gms.phenotype.internal.IGetStorageInfoCallbacks");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        ab abVar = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
        byte[] bArrCreateByteArray = parcel.createByteArray();
        com.google.android.libraries.navigation.internal.d.c.b(parcel);
        b(abVar, bArrCreateByteArray);
        return true;
    }
}
