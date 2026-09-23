package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int iE = 0;
        String strN = null;
        IBinder iBinderJ = null;
        int iE2 = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            } else if (iD == 3) {
                iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            } else if (iD == 4) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD != 5) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new PinConfig.Glyph(strN, iBinderJ, iE, iE2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PinConfig.Glyph[i];
    }
}
