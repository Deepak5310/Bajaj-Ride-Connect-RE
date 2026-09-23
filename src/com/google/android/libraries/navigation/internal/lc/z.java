package com.google.android.libraries.navigation.internal.lc;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.lh.ao;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<z> CREATOR = new aa();
    public final String a;
    public final boolean b;
    public final boolean c;
    private final q d;

    public z(String str, IBinder iBinder, boolean z, boolean z2) {
        this.a = str;
        r rVar = null;
        if (iBinder != null) {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                com.google.android.libraries.navigation.internal.lo.l lVarD = (iInterfaceQueryLocalInterface instanceof ao ? (ao) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lh.am(iBinder)).d();
                byte[] bArr = lVarD == null ? null : (byte[]) com.google.android.libraries.navigation.internal.lo.n.b(lVarD);
                if (bArr != null) {
                    rVar = new r(bArr);
                }
            } catch (RemoteException unused) {
            }
        }
        this.d = rVar;
        this.b = z;
        this.c = z2;
    }

    public z(String str, q qVar, boolean z, boolean z2) {
        this.a = str;
        this.d = qVar;
        this.b = z;
        this.c = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 1, str);
        q qVar = this.d;
        if (qVar == null) {
            qVar = null;
        }
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 2, qVar);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
