package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        ArrayList arrayListP = null;
        Cap cap = null;
        Cap cap2 = null;
        ArrayList arrayListP2 = null;
        ArrayList arrayListP3 = null;
        int iE = 0;
        boolean zS = false;
        boolean zS2 = false;
        boolean zS3 = false;
        int iE2 = 0;
        float fC = 0.0f;
        float fC2 = 0.0f;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    arrayListP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 4:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 5:
                    fC2 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                    break;
                case 6:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 7:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 8:
                    zS3 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 9:
                    cap = (Cap) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, Cap.CREATOR);
                    break;
                case 10:
                    cap2 = (Cap) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, Cap.CREATOR);
                    break;
                case 11:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 12:
                    arrayListP2 = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, PatternItem.CREATOR);
                    break;
                case 13:
                    arrayListP3 = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, StyleSpan.CREATOR);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new PolylineOptions(arrayListP, fC, iE, fC2, zS, zS2, zS3, cap, cap2, iE2, arrayListP2, arrayListP3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
