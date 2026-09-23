package com.google.android.libraries.navigation.internal.lv;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        IBinder iBinderJ = null;
        IBinder iBinderJ2 = null;
        PendingIntent pendingIntent = null;
        String strN = null;
        int iE = 0;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 1) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 2) {
                iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            } else if (iD == 3) {
                iBinderJ2 = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            } else if (iD == 4) {
                pendingIntent = (PendingIntent) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, PendingIntent.CREATOR);
            } else if (iD != 6) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new ai(iE, iBinderJ, iBinderJ2, pendingIntent, strN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ai[i];
    }
}
