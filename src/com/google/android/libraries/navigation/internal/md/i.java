package com.google.android.libraries.navigation.internal.md;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        ArrayList arrayListO = null;
        String strN = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                arrayListO = com.google.android.libraries.navigation.internal.li.c.o(parcel, i);
            } else if (iD != 2) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new h(arrayListO, strN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new h[i];
    }
}
