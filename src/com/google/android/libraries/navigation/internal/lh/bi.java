package com.google.android.libraries.navigation.internal.lh;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<bi> CREATOR = new bj();
    final int a;
    final IBinder b;
    public final com.google.android.libraries.navigation.internal.lc.a c;
    public final boolean d;
    public final boolean e;

    public bi(int i, IBinder iBinder, com.google.android.libraries.navigation.internal.lc.a aVar, boolean z, boolean z2) {
        this.a = i;
        this.b = iBinder;
        this.c = aVar;
        this.d = z;
        this.e = z2;
    }

    public final al a() {
        IBinder iBinder = this.b;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return iInterfaceQueryLocalInterface instanceof al ? (al) iInterfaceQueryLocalInterface : new ak(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bi)) {
            return false;
        }
        bi biVar = (bi) obj;
        return this.c.equals(biVar.c) && az.a(a(), biVar.a());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, this.c, i);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 4, this.d);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 5, this.e);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
