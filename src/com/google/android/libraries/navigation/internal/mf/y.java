package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int iE = 0;
        boolean zS = false;
        int iE2 = 0;
        boolean zS2 = false;
        ArrayList arrayListO = null;
        String strN = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 2:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 3:
                    zS = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                case 4:
                    arrayListO = com.google.android.libraries.navigation.internal.li.c.o(parcel, i);
                    break;
                case 5:
                    iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 6:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
                case 7:
                    zS2 = com.google.android.libraries.navigation.internal.li.c.s(parcel, i);
                    break;
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new x(iE, zS, arrayListO, iE2, strN, zS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new x[i];
    }
}
