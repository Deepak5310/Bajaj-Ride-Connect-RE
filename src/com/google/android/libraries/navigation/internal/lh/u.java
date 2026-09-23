package com.google.android.libraries.navigation.internal.lh;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        bl blVar = null;
        int[] iArrU = null;
        int[] iArrU2 = null;
        boolean zS = false;
        boolean zS2 = false;
        int iE = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 1:
                    blVar = (bl) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, bl.CREATOR);
                    break;
                case 2:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 3:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 4:
                    iArrU = com.google.android.libraries.navigation.internal.li.c.u(parcel, i);
                    break;
                case 5:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 6:
                    iArrU2 = com.google.android.libraries.navigation.internal.li.c.u(parcel, i);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new t(blVar, zS, zS2, iArrU, iE, iArrU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new t[i];
    }
}
