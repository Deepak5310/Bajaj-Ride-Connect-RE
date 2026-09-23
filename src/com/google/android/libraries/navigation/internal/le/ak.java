package com.google.android.libraries.navigation.internal.le;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ak extends com.google.android.libraries.navigation.internal.d.b implements al {
    public ak() {
        super("com.google.android.gms.common.api.internal.IStatusCallback");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        com.google.android.libraries.navigation.internal.ld.ab abVar = (com.google.android.libraries.navigation.internal.ld.ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, com.google.android.libraries.navigation.internal.ld.ab.CREATOR);
        com.google.android.libraries.navigation.internal.d.c.b(parcel);
        b(abVar);
        return true;
    }
}
