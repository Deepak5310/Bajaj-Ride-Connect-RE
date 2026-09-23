package com.google.android.libraries.navigation.internal.lv;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        long jH = Long.MAX_VALUE;
        boolean zS = false;
        boolean zS2 = false;
        boolean zS3 = false;
        boolean zS4 = false;
        com.google.android.libraries.navigation.internal.lu.z zVar = null;
        ArrayList arrayListP = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                zVar = (com.google.android.libraries.navigation.internal.lu.z) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.lu.z.CREATOR);
            } else if (iD == 5) {
                arrayListP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, com.google.android.libraries.navigation.internal.lh.l.CREATOR);
            } else if (iD == 8) {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            } else if (iD != 9) {
                switch (iD) {
                    case 11:
                        zS3 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                        break;
                    case 12:
                        zS4 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                        break;
                    case 13:
                        com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                        break;
                    case 14:
                        jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                        break;
                    default:
                        com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                        break;
                }
            } else {
                zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new ak(zVar, arrayListP, zS, zS2, zS3, zS4, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ak[i];
    }
}
