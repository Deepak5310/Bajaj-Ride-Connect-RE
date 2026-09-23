package com.google.android.libraries.navigation.internal.la;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ky.as;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends com.google.android.libraries.navigation.internal.d.a implements r {
    public q(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    @Override // com.google.android.libraries.navigation.internal.la.r
    public final void e(p pVar, a aVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, pVar);
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, aVar);
        A(8, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.la.r
    public final void f(p pVar, as asVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, pVar);
        com.google.android.libraries.navigation.internal.d.c.c(parcelA, asVar);
        A(1, parcelA);
    }
}
