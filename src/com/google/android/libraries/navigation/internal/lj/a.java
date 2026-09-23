package com.google.android.libraries.navigation.internal.lj;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.lh.bn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.d.a implements b {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // com.google.android.libraries.navigation.internal.lj.b
    public final void e(bn bnVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, bnVar);
        A(1, parcelA);
    }
}
