package com.google.android.libraries.navigation.internal.lh;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ax implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int iE = -1;
        int iE2 = 0;
        int iE3 = 0;
        int iE4 = 0;
        int iE5 = 0;
        String strN = null;
        String strN2 = null;
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 1:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 2:
                    iE3 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 3:
                    iE4 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 4:
                    jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 5:
                    jH2 = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 6:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 7:
                    strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 8:
                    iE5 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 9:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new aw(iE2, iE3, iE4, jH, jH2, strN, strN2, iE5, iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new aw[i];
    }
}
