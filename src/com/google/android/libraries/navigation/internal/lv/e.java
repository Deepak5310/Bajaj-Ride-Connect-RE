package com.google.android.libraries.navigation.internal.lv;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        b bVar = null;
        IBinder iBinderJ = null;
        IBinder iBinderJ2 = null;
        int iE = 1;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 2) {
                bVar = (b) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, b.CREATOR);
            } else if (iD == 3) {
                iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                iBinderJ2 = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new d(iE, bVar, iBinderJ, iBinderJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
