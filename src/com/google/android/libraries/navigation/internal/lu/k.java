package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        boolean zS = false;
        long jH = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
            } else if (iD != 6) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new j(jH, zS);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new j[i];
    }
}
