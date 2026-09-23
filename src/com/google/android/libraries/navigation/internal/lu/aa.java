package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        WorkSource workSource = new WorkSource();
        com.google.android.libraries.navigation.internal.lr.a aVar = null;
        boolean zS = false;
        int iE = 0;
        int iE2 = 0;
        boolean zS2 = false;
        long jH = -1;
        float fC = 0.0f;
        int iE3 = Integer.MAX_VALUE;
        long jH2 = Long.MAX_VALUE;
        long jH3 = Long.MAX_VALUE;
        long jH4 = 0;
        long jH5 = 600000;
        long jH6 = 3600000;
        int iE4 = 102;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 1:
                    iE4 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 2:
                    jH6 = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 3:
                    jH5 = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 4:
                case 14:
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
                case 5:
                    jH2 = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 6:
                    iE3 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 7:
                    fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 8:
                    jH4 = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 9:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 10:
                    jH3 = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 11:
                    jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 12:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 13:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 15:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 16:
                    workSource = (WorkSource) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, WorkSource.CREATOR);
                    break;
                case 17:
                    aVar = (com.google.android.libraries.navigation.internal.lr.a) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.lr.a.CREATOR);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new z(iE4, jH6, jH5, jH4, jH2, jH3, iE3, fC, zS, jH, iE, iE2, zS2, workSource, aVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new z[i];
    }
}
