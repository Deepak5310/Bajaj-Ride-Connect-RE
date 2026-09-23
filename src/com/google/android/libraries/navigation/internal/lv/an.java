package com.google.android.libraries.navigation.internal.lv;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        ak akVar = null;
        IBinder iBinderJ = null;
        IBinder iBinderJ2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderJ3 = null;
        String strN = null;
        int iE = 1;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            switch (com.google.android.libraries.navigation.internal.li.c.d(i)) {
                case 1:
                    iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
                    break;
                case 2:
                    akVar = (ak) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, ak.CREATOR);
                    break;
                case 3:
                    iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) com.google.android.libraries.navigation.internal.li.c.k(parcel, i, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderJ2 = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
                    break;
                case 6:
                    iBinderJ3 = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
                    break;
                case 7:
                default:
                    com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
                    break;
                case 8:
                    strN = com.google.android.libraries.navigation.internal.li.c.n(parcel, i);
                    break;
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        return new am(iE, akVar, iBinderJ, iBinderJ2, pendingIntent, iBinderJ3, strN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new am[i];
    }
}
