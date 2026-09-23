package com.google.android.libraries.navigation.internal.mg;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends com.google.android.libraries.navigation.internal.d.b implements d {
    public c() {
        super("com.google.android.gms.usagereporting.internal.IUsageReportingOptInOptionsChangedListener");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        b();
        return true;
    }
}
