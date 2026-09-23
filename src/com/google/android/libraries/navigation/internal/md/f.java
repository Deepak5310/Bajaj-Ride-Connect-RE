package com.google.android.libraries.navigation.internal.md;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends com.google.android.libraries.navigation.internal.d.a implements g {
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.libraries.navigation.internal.md.g
    public final void e(k kVar, e eVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, kVar);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, eVar);
        z(12, parcelA);
    }
}
