package com.google.android.libraries.navigation.internal.lc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        boolean zS = false;
        int iE = 0;
        String strN = null;
        int iE2 = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            } else if (iD == 2) {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            } else if (iD == 3) {
                iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new x(zS, strN, iE2, iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new x[i];
    }
}
