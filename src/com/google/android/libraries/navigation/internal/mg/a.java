package com.google.android.libraries.navigation.internal.mg;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.mf.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends com.google.android.libraries.navigation.internal.d.b implements b {
    public a() {
        super("com.google.android.gms.usagereporting.internal.IUsageReportingCallbacks");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i) {
            case 2:
                ab abVar = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                x xVar = (x) com.google.android.libraries.navigation.internal.d.c.a(parcel, x.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                b(abVar, xVar);
                return true;
            case 3:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                n();
                return true;
            case 4:
                ab abVar2 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                c(abVar2);
                return true;
            case 5:
                ab abVar3 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                d(abVar3);
                return true;
            case 6:
                parcel.createStringArrayList();
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                g();
                return true;
            case 7:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                l();
                return true;
            case 8:
                com.google.android.libraries.navigation.internal.d.c.e(parcel);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                e();
                return true;
            case 9:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                j();
                return true;
            case 10:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                h();
                return true;
            case 11:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                m();
                return true;
            case 12:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                i();
                return true;
            case 13:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                o();
                return true;
            case 14:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                k();
                return true;
            case 15:
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                f();
                return true;
            default:
                return false;
        }
    }
}
