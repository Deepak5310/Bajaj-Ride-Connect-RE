package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        String strN = null;
        byte[] bArrT = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            } else if (iD == 2) {
                bArrT = com.google.android.libraries.navigation.internal.li.c.t(parcel, i);
            } else if (iD != 3) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                int iF = com.google.android.libraries.navigation.internal.li.c.f(parcel, i);
                int iDataPosition = parcel.dataPosition();
                if (iF == 0) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = parcel.readInt();
                    for (int i3 = 0; i3 < i2; i3++) {
                        arrayList2.add(Integer.valueOf(parcel.readInt()));
                    }
                    parcel.setDataPosition(iDataPosition + iF);
                    arrayList = arrayList2;
                }
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new b(strN, bArrT, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
