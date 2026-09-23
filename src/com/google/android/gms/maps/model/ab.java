package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ab implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        double dB = 0.0d;
        StrokeStyle strokeStyle = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                strokeStyle = (StrokeStyle) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, StrokeStyle.CREATOR);
            } else if (iD != 3) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                dB = com.google.android.libraries.navigation.internal.li.c.b(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new StyleSpan(strokeStyle, dB);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new StyleSpan[i];
    }
}
