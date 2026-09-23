package com.google.android.libraries.navigation.internal.la;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        ArrayList arrayListP = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            if (com.google.android.libraries.navigation.internal.li.c.d(i) != 1) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                arrayListP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, s.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new a(arrayListP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
