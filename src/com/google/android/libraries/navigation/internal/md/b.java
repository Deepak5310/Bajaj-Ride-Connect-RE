package com.google.android.libraries.navigation.internal.md;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        Intent intent = null;
        int iE = 0;
        int iE2 = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 2) {
                iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD != 3) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                intent = (Intent) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, Intent.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new a(iE, iE2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
