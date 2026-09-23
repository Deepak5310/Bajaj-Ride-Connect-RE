package com.google.android.libraries.navigation.internal.la;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ld.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class o extends com.google.android.libraries.navigation.internal.d.b implements p {
    public o() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i) {
            case 1:
                ab abVar = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                c(abVar);
                return true;
            case 2:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                d();
                return true;
            case 3:
                parcel.readLong();
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                h();
                return true;
            case 4:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                i();
                return true;
            case 5:
                parcel.readLong();
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                e();
                return true;
            case 6:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                f();
                return true;
            case 7:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                g();
                return true;
            case 8:
                ab abVar2 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                b(abVar2);
                return true;
            default:
                return false;
        }
    }
}
