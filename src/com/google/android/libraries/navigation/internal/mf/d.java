package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        boolean zS = false;
        ArrayList arrayListP = null;
        boolean zS2 = false;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                arrayListP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, b.CREATOR);
            } else if (iD == 2) {
                zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            } else if (iD != 3) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new c(arrayListP, zS, zS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new c[i];
    }
}
