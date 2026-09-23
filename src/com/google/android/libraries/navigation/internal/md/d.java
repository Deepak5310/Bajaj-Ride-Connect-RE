package com.google.android.libraries.navigation.internal.md;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d extends com.google.android.libraries.navigation.internal.d.b implements e {
    public d() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i) {
            case 3:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                break;
            case 4:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                break;
            case 7:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                break;
            case 8:
                m mVar = (m) com.google.android.libraries.navigation.internal.d.c.a(parcel, m.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                c(mVar);
                break;
            case 9:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
