package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        float fC = 0.0f;
        float fC2 = 0.0f;
        LatLng latLng = null;
        float fC3 = 0.0f;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
            } else if (iD == 3) {
                fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
            } else if (iD == 4) {
                fC3 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
            } else if (iD != 5) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                fC2 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new CameraPosition(latLng, fC, fC3, fC2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new CameraPosition[i];
    }
}
