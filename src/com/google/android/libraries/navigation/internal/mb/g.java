package com.google.android.libraries.navigation.internal.mb;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends com.google.android.libraries.navigation.internal.d.a implements h {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.phenotype.internal.IPhenotypeService");
    }

    @Override // com.google.android.libraries.navigation.internal.mb.h
    public final void e(f fVar, String str) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, fVar);
        parcelA.writeString(str);
        z(5, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mb.h
    public final void f(f fVar, byte[] bArr) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, fVar);
        parcelA.writeByteArray(bArr);
        z(31, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mb.h
    public final void g(d dVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, dVar);
        z(27, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mb.h
    public final void h(String str, b bVar) throws RemoteException {
        Parcel parcelA = a();
        parcelA.writeString(str);
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, bVar);
        z(28, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mb.h
    public final void i(f fVar, String str, String str2) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, fVar);
        parcelA.writeString(str);
        parcelA.writeString("");
        parcelA.writeString(null);
        z(11, parcelA);
    }

    @Override // com.google.android.libraries.navigation.internal.mb.h
    public final void j(f fVar, String str, int i, String[] strArr) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.libraries.navigation.internal.d.c.d(parcelA, fVar);
        parcelA.writeString(str);
        parcelA.writeInt(i);
        parcelA.writeStringArray(strArr);
        parcelA.writeByteArray(null);
        z(1, parcelA);
    }
}
