package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class r extends com.google.android.libraries.navigation.internal.d.b implements s {
    public r() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i == 1) {
            ab abVar = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
            com.google.android.libraries.navigation.internal.d.c.b(parcel);
            f(abVar);
        } else if (i == 2) {
            v vVar = (v) com.google.android.libraries.navigation.internal.d.c.a(parcel, v.CREATOR);
            com.google.android.libraries.navigation.internal.d.c.b(parcel);
            e(vVar);
        } else {
            if (i != 3) {
                return false;
            }
            g();
        }
        return true;
    }
}
