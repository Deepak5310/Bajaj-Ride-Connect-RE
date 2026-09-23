package com.google.android.libraries.navigation.internal.lu;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        ArrayList arrayListP = null;
        Bundle bundleI = null;
        int iE = 0;
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                arrayListP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, d.CREATOR);
            } else if (iD == 2) {
                jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
            } else if (iD == 3) {
                jH2 = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
            } else if (iD == 4) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD != 5) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                bundleI = com.google.android.libraries.navigation.internal.li.c.i(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new b(arrayListP, jH, jH2, iE, bundleI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
