package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        Float fL = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            if (com.google.android.libraries.navigation.internal.li.c.d(i) != 1) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                fL = com.google.android.libraries.navigation.internal.li.c.l(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new FollowMyLocationOptions(fL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FollowMyLocationOptions[i];
    }
}
