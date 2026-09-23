package com.google.android.libraries.navigation.internal.lf;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        int i = 0;
        String[] strArrW = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleI = null;
        int iE = 0;
        int iE2 = 0;
        while (parcel.dataPosition() < iG) {
            int i2 = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i2);
            if (iD == 1) {
                strArrW = com.google.android.libraries.navigation.internal.li.c.w(parcel, i2);
            } else if (iD == 2) {
                cursorWindowArr = (CursorWindow[]) com.google.android.libraries.navigation.internal.li.c.v(parcel, i2, CursorWindow.CREATOR);
            } else if (iD == 3) {
                iE2 = com.google.android.libraries.navigation.internal.li.c.e(parcel, i2);
            } else if (iD == 4) {
                bundleI = com.google.android.libraries.navigation.internal.li.c.i(parcel, i2);
            } else if (iD != 1000) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i2);
            } else {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i2);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        b bVar = new b(iE, strArrW, cursorWindowArr, iE2, bundleI);
        bVar.c = new Bundle();
        int i3 = 0;
        while (true) {
            String[] strArr = bVar.b;
            if (i3 >= strArr.length) {
                break;
            }
            bVar.c.putInt(strArr[i3], i3);
            i3++;
        }
        bVar.g = new int[bVar.d.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = bVar.d;
            if (i >= cursorWindowArr2.length) {
                return bVar;
            }
            bVar.g[i] = numRows;
            numRows += bVar.d[i].getNumRows() - (numRows - cursorWindowArr2[i].getStartPosition());
            i++;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
