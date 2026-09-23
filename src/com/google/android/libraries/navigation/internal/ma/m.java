package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        String strN = null;
        byte[] bArrT = null;
        byte[][] bArrX = null;
        byte[][] bArrX2 = null;
        byte[][] bArrX3 = null;
        byte[][] bArrX4 = null;
        int[] iArrU = null;
        byte[][] bArrX5 = null;
        int[] iArrU2 = null;
        byte[][] bArrX6 = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 3:
                    bArrT = com.google.android.libraries.navigation.internal.li.c.t(parcel, i);
                    break;
                case 4:
                    bArrX = com.google.android.libraries.navigation.internal.li.c.x(parcel, i);
                    break;
                case 5:
                    bArrX2 = com.google.android.libraries.navigation.internal.li.c.x(parcel, i);
                    break;
                case 6:
                    bArrX3 = com.google.android.libraries.navigation.internal.li.c.x(parcel, i);
                    break;
                case 7:
                    bArrX4 = com.google.android.libraries.navigation.internal.li.c.x(parcel, i);
                    break;
                case 8:
                    iArrU = com.google.android.libraries.navigation.internal.li.c.u(parcel, i);
                    break;
                case 9:
                    bArrX5 = com.google.android.libraries.navigation.internal.li.c.x(parcel, i);
                    break;
                case 10:
                    iArrU2 = com.google.android.libraries.navigation.internal.li.c.u(parcel, i);
                    break;
                case 11:
                    bArrX6 = com.google.android.libraries.navigation.internal.li.c.x(parcel, i);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new l(strN, bArrT, bArrX, bArrX2, bArrX3, bArrX4, iArrU, bArrX5, iArrU2, bArrX6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new l[i];
    }
}
