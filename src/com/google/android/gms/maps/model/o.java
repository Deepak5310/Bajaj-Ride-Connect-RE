package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        LatLng latLng = null;
        String strN = null;
        String strN2 = null;
        IBinder iBinderJ = null;
        IBinder iBinderJ2 = null;
        String strN3 = null;
        boolean zS = false;
        boolean zS2 = false;
        boolean zS3 = false;
        int iE = 0;
        int iE2 = 0;
        float fC = 0.0f;
        float fC2 = 0.0f;
        float fC3 = 0.0f;
        float fC4 = 0.0f;
        float fC5 = 0.0f;
        float fC6 = 1.0f;
        float fC7 = 0.5f;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 4:
                    strN2 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 5:
                    iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
                    break;
                case 6:
                    fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 7:
                    fC2 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 8:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 9:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 10:
                    zS3 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 11:
                    fC3 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 12:
                    fC7 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 13:
                    fC4 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 14:
                    fC6 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 15:
                    fC5 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 16:
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
                case 17:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 18:
                    iBinderJ2 = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
                    break;
                case 19:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 20:
                    strN3 = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new MarkerOptions(latLng, strN, strN2, iBinderJ, fC, fC2, zS, zS2, zS3, fC3, fC7, fC4, fC6, fC5, iE, iBinderJ2, iE2, strN3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
