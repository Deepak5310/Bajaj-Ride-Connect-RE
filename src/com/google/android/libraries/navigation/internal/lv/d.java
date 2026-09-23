package com.google.android.libraries.navigation.internal.lv;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<d> CREATOR = new e();
    final int a;
    final b b;
    final com.google.android.libraries.navigation.internal.lu.p c;
    final j d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.b, i);
        com.google.android.libraries.navigation.internal.lu.p pVar = this.c;
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 3, pVar == null ? null : pVar.asBinder());
        j jVar = this.d;
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 4, jVar != null ? jVar.asBinder() : null);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public d(int i, b bVar, IBinder iBinder, IBinder iBinder2) {
        com.google.android.libraries.navigation.internal.lu.p nVar;
        this.a = i;
        this.b = bVar;
        j hVar = null;
        if (iBinder == null) {
            nVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
            nVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lu.p ? (com.google.android.libraries.navigation.internal.lu.p) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lu.n(iBinder);
        }
        this.c = nVar;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            hVar = iInterfaceQueryLocalInterface2 instanceof j ? (j) iInterfaceQueryLocalInterface2 : new h(iBinder2);
        }
        this.d = hVar;
    }
}
