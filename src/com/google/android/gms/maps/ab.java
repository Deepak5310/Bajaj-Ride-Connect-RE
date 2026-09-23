package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ab implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int iE = 0;
        int iE2 = 0;
        byte bA = -1;
        byte bA2 = -1;
        byte bA3 = -1;
        byte bA4 = -1;
        byte bA5 = -1;
        byte bA6 = -1;
        byte bA7 = -1;
        byte bA8 = -1;
        byte bA9 = -1;
        byte bA10 = -1;
        byte bA11 = -1;
        byte bA12 = -1;
        byte bA13 = -1;
        CameraPosition cameraPosition = null;
        Float fL = null;
        Float fL2 = null;
        LatLngBounds latLngBounds = null;
        Integer numM = null;
        String strN = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    bA = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 3:
                    bA2 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 4:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, CameraPosition.CREATOR);
                    break;
                case 6:
                    bA3 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 7:
                    bA4 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 8:
                    bA5 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 9:
                    bA6 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 10:
                    bA7 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 11:
                    bA8 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 12:
                    bA9 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 13:
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
                case 14:
                    bA10 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 15:
                    bA11 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 16:
                    fL = com.google.android.libraries.navigation.internal.li.c.l(parcel, i);
                    break;
                case 17:
                    fL2 = com.google.android.libraries.navigation.internal.li.c.l(parcel, i);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLngBounds.CREATOR);
                    break;
                case 19:
                    bA12 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 20:
                    numM = com.google.android.libraries.navigation.internal.li.c.m(parcel, i);
                    break;
                case 21:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 22:
                    bA13 = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                    break;
                case 23:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new GoogleMapOptions(bA, bA2, iE, cameraPosition, bA3, bA4, bA5, bA6, bA7, bA8, bA9, bA10, bA11, fL, fL2, latLngBounds, bA12, numM, strN, bA13, iE2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
