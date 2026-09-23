package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        Integer numM = null;
        Integer numM2 = null;
        Float fL = null;
        Float fL2 = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                numM = com.google.android.libraries.navigation.internal.li.c.m(parcel, i);
            } else if (iD == 2) {
                numM2 = com.google.android.libraries.navigation.internal.li.c.m(parcel, i);
            } else if (iD == 3) {
                fL = com.google.android.libraries.navigation.internal.li.c.l(parcel, i);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                fL2 = com.google.android.libraries.navigation.internal.li.c.l(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new FeatureStyle(numM, numM2, fL, fL2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FeatureStyle[i];
    }
}
