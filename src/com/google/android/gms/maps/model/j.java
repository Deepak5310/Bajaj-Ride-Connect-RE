package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        boolean zS = false;
        boolean zS2 = false;
        float fC = 0.0f;
        float fC2 = 0.0f;
        float fC3 = 0.0f;
        float fC4 = 0.0f;
        float fC5 = 0.0f;
        float fC6 = 0.0f;
        float fC7 = 0.0f;
        IBinder iBinderJ = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
                    break;
                case 3:
                    latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
                    break;
                case 4:
                    fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 5:
                    fC2 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLngBounds.CREATOR);
                    break;
                case 7:
                    fC3 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 8:
                    fC4 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 9:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 10:
                    fC5 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 11:
                    fC6 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 12:
                    fC7 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 13:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new GroundOverlayOptions(iBinderJ, latLng, fC, fC2, latLngBounds, fC3, fC4, zS, fC5, fC6, fC7, zS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
