package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ag implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
            } else if (iD == 3) {
                latLng2 = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
            } else if (iD == 4) {
                latLng3 = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
            } else if (iD == 5) {
                latLng4 = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
            } else if (iD != 6) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                latLngBounds = (LatLngBounds) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLngBounds.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new VisibleRegion(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
