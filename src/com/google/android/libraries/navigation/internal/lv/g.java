package com.google.android.libraries.navigation.internal.lv;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        com.google.android.libraries.navigation.internal.ld.ab abVar = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            if (com.google.android.libraries.navigation.internal.li.c.d(i) != 1) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                abVar = (com.google.android.libraries.navigation.internal.ld.ab) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, com.google.android.libraries.navigation.internal.ld.ab.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new f(abVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new f[i];
    }
}
