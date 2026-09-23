package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        LatLng latLng = null;
        ArrayList arrayListP = null;
        int iE = 0;
        int iE2 = 0;
        boolean zS = false;
        boolean zS2 = false;
        float fC = 0.0f;
        float fC2 = 0.0f;
        double dB = 0.0d;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    latLng = (LatLng) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    dB = com.google.android.libraries.navigation.internal.li.c.b(parcel, i);
                    break;
                case 4:
                    fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 5:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 6:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
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
                    arrayListP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, PatternItem.CREATOR);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new CircleOptions(latLng, dB, fC, iE, iE2, fC2, zS, zS2, arrayListP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new CircleOptions[i];
    }
}
