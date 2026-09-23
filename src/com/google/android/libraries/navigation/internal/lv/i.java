package com.google.android.libraries.navigation.internal.lv;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i extends com.google.android.libraries.navigation.internal.d.b implements j {
    public i() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i == 1) {
            f fVar = (f) com.google.android.libraries.navigation.internal.d.c.a(parcel, f.CREATOR);
            com.google.android.libraries.navigation.internal.d.c.b(parcel);
            e(fVar);
        } else {
            if (i != 2) {
                return false;
            }
            f();
        }
        return true;
    }
}
