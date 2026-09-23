package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        ArrayList arrayList = new ArrayList();
        float fC = 0.0f;
        ArrayList arrayListP = null;
        int iE = 0;
        int iE2 = 0;
        boolean zS = false;
        boolean zS2 = false;
        boolean zS3 = false;
        int iE3 = 0;
        float fC2 = 0.0f;
        ArrayList arrayListP2 = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    arrayListP2 = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    ClassLoader classLoader = getClass().getClassLoader();
                    int iF = com.google.android.libraries.navigation.internal.li.c.f(parcel, i);
                    int iDataPosition = parcel.dataPosition();
                    if (iF != 0) {
                        parcel.readList(arrayList, classLoader);
                        parcel.setDataPosition(iDataPosition + iF);
                    }
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
                    zS3 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 11:
                    iE3 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 12:
                    arrayListP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, PatternItem.CREATOR);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new PolygonOptions(arrayListP2, arrayList, fC, iE, iE2, fC2, zS, zS2, zS3, iE3, arrayListP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
