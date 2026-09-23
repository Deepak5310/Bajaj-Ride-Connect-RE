package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        LatLng latLng = null;
        String strN = null;
        String strN2 = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
            } else if (iD == 3) {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new PointOfInterest(latLng, strN, strN2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PointOfInterest[i];
    }
}
