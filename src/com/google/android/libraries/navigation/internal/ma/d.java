package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        long jH = 0;
        String strN = null;
        String strN2 = null;
        a[] aVarArr = null;
        byte[] bArrT = null;
        boolean zS = false;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 3:
                    strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 4:
                    aVarArr = (a[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i, a.CREATOR);
                    break;
                case 5:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 6:
                    bArrT = com.google.android.libraries.navigation.internal.li.c.t(parcel, i);
                    break;
                case 7:
                    jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new c(strN, strN2, aVarArr, zS, bArrT, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new c[i];
    }
}
