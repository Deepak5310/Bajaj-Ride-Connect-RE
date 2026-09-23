package com.google.android.libraries.navigation.internal.mb;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends com.google.android.libraries.navigation.internal.d.b implements b {
    public a() {
        super("com.google.android.gms.phenotype.internal.IFlagUpdateListener");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        com.google.android.libraries.navigation.internal.d.c.b(parcel);
        b(bArrCreateByteArray);
        return true;
    }
}
