package com.google.android.libraries.navigation.internal.mg;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.google.android.libraries.navigation.internal.d.a implements f {
    public e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.usagereporting.internal.IUsageReportingService");
    }

    @Override // com.google.android.libraries.navigation.internal.mg.f
    public final void e(b bVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, bVar);
        z(2, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mg.f
    public final void f(d dVar, b bVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, dVar);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, bVar);
        z(4, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mg.f
    public final void g(d dVar, b bVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, dVar);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, bVar);
        z(5, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mg.f
    public final void h(d dVar, b bVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, dVar);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, bVar);
        z(10, parcelA);
    }
}
