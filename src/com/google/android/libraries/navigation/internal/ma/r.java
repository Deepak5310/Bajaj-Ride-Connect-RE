package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        boolean zS = false;
        String strN = null;
        String strN2 = null;
        o oVar = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            } else if (iD == 3) {
                strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            } else if (iD == 4) {
                oVar = (o) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, o.CREATOR);
            } else if (iD != 5) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new q(strN, strN2, oVar, zS);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new q[i];
    }
}
