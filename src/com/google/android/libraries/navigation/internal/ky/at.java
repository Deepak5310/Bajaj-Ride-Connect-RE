package com.google.android.libraries.navigation.internal.ky;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        com.google.android.libraries.navigation.internal.la.y yVar = null;
        byte[] bArrT = null;
        int[] iArrU = null;
        String[] strArrW = null;
        int[] iArrU2 = null;
        byte[][] bArrX = null;
        com.google.android.libraries.navigation.internal.ma.l[] lVarArr = null;
        com.google.android.libraries.navigation.internal.la.w wVar = null;
        String[] strArrW2 = null;
        com.google.android.libraries.navigation.internal.la.k kVar = null;
        int iE = 0;
        boolean zS = true;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    yVar = (com.google.android.libraries.navigation.internal.la.y) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.la.y.CREATOR);
                    break;
                case 3:
                    bArrT = com.google.android.libraries.navigation.internal.li.c.t(parcel, i);
                    break;
                case 4:
                    iArrU = com.google.android.libraries.navigation.internal.li.c.u(parcel, i);
                    break;
                case 5:
                    strArrW = com.google.android.libraries.navigation.internal.li.c.w(parcel, i);
                    break;
                case 6:
                    iArrU2 = com.google.android.libraries.navigation.internal.li.c.u(parcel, i);
                    break;
                case 7:
                    bArrX = com.google.android.libraries.navigation.internal.li.c.x(parcel, i);
                    break;
                case 8:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 9:
                    lVarArr = (com.google.android.libraries.navigation.internal.ma.l[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i, com.google.android.libraries.navigation.internal.ma.l.CREATOR);
                    break;
                case 10:
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
                case 11:
                    wVar = (com.google.android.libraries.navigation.internal.la.w) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.la.w.CREATOR);
                    break;
                case 12:
                    strArrW2 = com.google.android.libraries.navigation.internal.li.c.w(parcel, i);
                    break;
                case 13:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 14:
                    kVar = (com.google.android.libraries.navigation.internal.la.k) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.la.k.CREATOR);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new as(yVar, bArrT, iArrU, strArrW, iArrU2, bArrX, zS, lVarArr, wVar, strArrW2, iE, kVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new as[i];
    }
}
