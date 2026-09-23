package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        float fC = 0.0f;
        float fC2 = 0.0f;
        float fC3 = 0.0f;
        float fC4 = 0.0f;
        byte bA = 0;
        long jH = 0;
        while (true) {
            float[] fArr = null;
            while (true) {
                if (parcel.dataPosition() >= iG) {
                    com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
                    return new f(fArr, fC, fC2, jH, bA, fC3, fC4);
                }
                int i = parcel.readInt();
                int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
                if (iD != 1) {
                    switch (iD) {
                        case 4:
                            fC = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                            break;
                        case 5:
                            fC2 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                            break;
                        case 6:
                            jH = com.google.android.libraries.navigation.internal.li.c.h(parcel, i);
                            break;
                        case 7:
                            bA = com.google.android.libraries.navigation.internal.li.c.a(parcel, i);
                            break;
                        case 8:
                            fC3 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                            break;
                        case 9:
                            fC4 = com.google.android.libraries.navigation.internal.li.c.c(parcel, i);
                            break;
                        default:
                            com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                            break;
                    }
                } else {
                    int iF = com.google.android.libraries.navigation.internal.li.c.f(parcel, i);
                    int iDataPosition = parcel.dataPosition();
                    if (iF == 0) {
                        break;
                    }
                    float[] fArrCreateFloatArray = parcel.createFloatArray();
                    parcel.setDataPosition(iDataPosition + iF);
                    fArr = fArrCreateFloatArray;
                }
            }
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new f[i];
    }
}
