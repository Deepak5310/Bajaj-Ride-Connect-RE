package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        LatLng latLng = null;
        String strN = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i, StreetViewPanoramaLink.CREATOR);
            } else if (iD == 3) {
                latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new StreetViewPanoramaLocation(streetViewPanoramaLinkArr, latLng, strN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
