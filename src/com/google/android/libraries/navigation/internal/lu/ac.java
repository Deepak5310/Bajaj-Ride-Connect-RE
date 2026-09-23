package com.google.android.libraries.navigation.internal.lu;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        List listP = ab.a;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            if (com.google.android.libraries.navigation.internal.li.c.d(i) != 1) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                listP = com.google.android.libraries.navigation.internal.li.c.p(parcel, i, Location.CREATOR);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new ab(listP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ab[i];
    }
}
