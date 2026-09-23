package com.google.android.libraries.navigation.internal.la;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int iE = 0;
        int iE2 = 0;
        boolean zS = false;
        int iE3 = 0;
        boolean zS2 = false;
        int iE4 = 0;
        String strN = null;
        String strN2 = null;
        String strN3 = null;
        Integer numM = null;
        boolean zS3 = true;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 3:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 4:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 5:
                    strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 6:
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
                case 7:
                    zS3 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 8:
                    strN3 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 9:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 10:
                    iE3 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 11:
                    numM = com.google.android.libraries.navigation.internal.li.c.m(parcel, i);
                    break;
                case 12:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 13:
                    iE4 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new y(strN, iE, iE2, strN2, zS3, strN3, zS, iE3, numM, zS2, iE4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new y[i];
    }
}
