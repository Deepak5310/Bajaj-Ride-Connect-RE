package com.google.android.libraries.navigation.internal.kw;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.ld.z;
import com.google.android.libraries.navigation.internal.li.c;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = c.g(parcel);
        String strN = null;
        String strN2 = null;
        String strN3 = null;
        String strN4 = null;
        Uri uri = null;
        String strN5 = null;
        String strN6 = null;
        ArrayList arrayListP = null;
        String strN7 = null;
        String strN8 = null;
        long jH = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (c.d(i)) {
                case 2:
                    strN = c.n(parcel, i);
                    break;
                case 3:
                    strN2 = c.n(parcel, i);
                    break;
                case 4:
                    strN3 = c.n(parcel, i);
                    break;
                case 5:
                    strN4 = c.n(parcel, i);
                    break;
                case 6:
                    uri = (Uri) c.k(parcel, i, Uri.CREATOR);
                    break;
                case 7:
                    strN5 = c.n(parcel, i);
                    break;
                case 8:
                    jH = c.h(parcel, i);
                    break;
                case 9:
                    strN6 = c.n(parcel, i);
                    break;
                case 10:
                    arrayListP = c.p(parcel, i, z.CREATOR);
                    break;
                case 11:
                    strN7 = c.n(parcel, i);
                    break;
                case 12:
                    strN8 = c.n(parcel, i);
                    break;
                default:
                    c.r(parcel, i);
                    break;
            }
        }
        c.q(parcel, iG);
        return new a(strN, strN2, strN3, strN4, uri, strN5, jH, strN6, arrayListP, strN7, strN8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
