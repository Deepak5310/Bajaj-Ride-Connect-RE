package com.google.android.libraries.navigation.internal.lh;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        Bundle bundleI = null;
        t tVar = null;
        int iE = 0;
        com.google.android.libraries.navigation.internal.lc.d[] dVarArr = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                bundleI = com.google.android.libraries.navigation.internal.li.c.i(parcel, i);
            } else if (iD == 2) {
                dVarArr = (com.google.android.libraries.navigation.internal.lc.d[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i, com.google.android.libraries.navigation.internal.lc.d.CREATOR);
            } else if (iD == 3) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                tVar = (t) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, t.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new r(bundleI, dVarArr, iE, tVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new r[i];
    }
}
