package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class af implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        float fC = 0.0f;
        boolean zS = false;
        boolean zS2 = true;
        float fC2 = 0.0f;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            } else if (iD == 3) {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            } else if (iD == 4) {
                fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
            } else if (iD == 5) {
                zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            } else if (iD != 6) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                fC2 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new TileOverlayOptions(zS, fC, zS2, fC2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
