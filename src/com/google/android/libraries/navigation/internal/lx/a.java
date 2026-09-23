package com.google.android.libraries.navigation.internal.lx;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.d.c;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.d.a implements b {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.auth.IApiTokenService");
    }

    @Override // com.google.android.libraries.navigation.internal.lx.b
    public final Bundle e(Bundle bundle) throws RemoteException {
        Parcel parcelA = a();
        c.c(parcelA, bundle);
        Parcel parcelB = b(1, parcelA);
        Bundle bundle2 = (Bundle) c.a(parcelB, Bundle.CREATOR);
        parcelB.recycle();
        return bundle2;
    }
}
