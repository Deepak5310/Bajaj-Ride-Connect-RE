package com.google.android.libraries.navigation.internal.lr;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lc.d;
import com.google.android.libraries.navigation.internal.li.c;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = c.g(parcel);
        String packageName = null;
        String strN = null;
        String strN2 = null;
        ArrayList arrayListP = null;
        a aVar = null;
        int iE = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = c.d(i);
            if (iD == 1) {
                iE = c.e(parcel, i);
            } else if (iD == 3) {
                packageName = c.n(parcel, i);
            } else if (iD == 4) {
                strN = c.n(parcel, i);
            } else if (iD == 6) {
                strN2 = c.n(parcel, i);
            } else if (iD == 7) {
                aVar = (a) c.k(parcel, i, a.CREATOR);
            } else if (iD != 8) {
                c.r(parcel, i);
            } else {
                arrayListP = c.p(parcel, i, d.CREATOR);
            }
        }
        c.q(parcel, iG);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new a(iE, packageName, strN, strN2, arrayListP, aVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
