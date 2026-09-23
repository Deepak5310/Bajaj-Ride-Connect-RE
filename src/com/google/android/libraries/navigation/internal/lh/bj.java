package com.google.android.libraries.navigation.internal.lh;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int iE = 0;
        boolean zS = false;
        boolean zS2 = false;
        IBinder iBinderJ = null;
        com.google.android.libraries.navigation.internal.lc.a aVar = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 2) {
                iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            } else if (iD == 3) {
                aVar = (com.google.android.libraries.navigation.internal.lc.a) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.lc.a.CREATOR);
            } else if (iD == 4) {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            } else if (iD != 5) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new bi(iE, iBinderJ, aVar, zS, zS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new bi[i];
    }
}
