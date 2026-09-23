package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class aa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        StampStyle stampStyle = null;
        int iE = 0;
        int iE2 = 0;
        boolean zS = false;
        float fC = 0.0f;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
            } else if (iD == 3) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 4) {
                iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 5) {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            } else if (iD != 6) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                stampStyle = (StampStyle) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, StampStyle.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new StrokeStyle(fC, iE, iE2, zS, stampStyle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new StrokeStyle[i];
    }
}
