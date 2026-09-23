package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int iE = 1000;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 4) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD != 6) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new v(iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new v[i];
    }
}
