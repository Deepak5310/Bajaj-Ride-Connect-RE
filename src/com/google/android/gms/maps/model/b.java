package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = com.google.android.libraries.navigation.internal.li.c.g(parcel);
        BitmapDescriptor bitmapDescriptor = null;
        int iE = 0;
        IBinder iBinderJ = null;
        Float fL = null;
        while (parcel.dataPosition() < iG) {
            int i = parcel.readInt();
            int iD = com.google.android.libraries.navigation.internal.li.c.d(i);
            if (iD == 2) {
                iE = com.google.android.libraries.navigation.internal.li.c.e(parcel, i);
            } else if (iD == 3) {
                iBinderJ = com.google.android.libraries.navigation.internal.li.c.j(parcel, i);
            } else if (iD != 4) {
                com.google.android.libraries.navigation.internal.li.c.r(parcel, i);
            } else {
                fL = com.google.android.libraries.navigation.internal.li.c.l(parcel, i);
            }
        }
        com.google.android.libraries.navigation.internal.li.c.q(parcel, iG);
        if (iBinderJ != null) {
            IInterface iInterfaceQueryLocalInterface = iBinderJ.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            bitmapDescriptor = new BitmapDescriptor(iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(iBinderJ));
        }
        return new Cap(iE, bitmapDescriptor, fL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Cap[i];
    }
}
