package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class av implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String strN = null;
        LatLng latLng = null;
        Integer numM = null;
        StreetViewSource streetViewSource = null;
        byte bA = 0;
        byte bA2 = 0;
        byte bA3 = 0;
        byte bA4 = 0;
        byte bA5 = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 4:
                    latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
                    break;
                case 5:
                    numM = com.google.android.libraries.navigation.internal.li.c.m(parcel, i);
                    break;
                case 6:
                    bA = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 7:
                    bA2 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 8:
                    bA3 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 9:
                    bA4 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 10:
                    bA5 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, StreetViewSource.CREATOR);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, strN, latLng, numM, bA, bA2, bA3, bA4, bA5, streetViewSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
