package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements Parcelable.Creator {
    public static boolean a(int i) {
        return i == 0;
    }

    public static boolean b(Object obj) {
        return obj == null;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        boolean zS = false;
        int iE = 0;
        int iE2 = 0;
        int iE3 = 0;
        String strN = null;
        String strN2 = null;
        byte[] bArrT = null;
        double dB = 0.0d;
        long jH = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 3:
                    jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                    break;
                case 4:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 5:
                    dB = com.google.android.libraries.navigation.internal.li.c.b(parcel, i);
                    break;
                case 6:
                    strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 7:
                    bArrT = com.google.android.libraries.navigation.internal.li.c.t(parcel, i);
                    break;
                case 8:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 9:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 10:
                    iE3 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new o(strN, jH, zS, dB, strN2, bArrT, iE, iE2, iE3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new o[i];
    }
}
