package com.google.android.libraries.navigation.internal.lv;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class am extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<am> CREATOR = new an();
    public final int a;
    public final ak b;
    public final PendingIntent c;
    public final String d;
    private final com.google.android.libraries.navigation.internal.lu.u e;
    private final com.google.android.libraries.navigation.internal.lu.s f;
    private final j g;

    public am(int i, ak akVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        com.google.android.libraries.navigation.internal.lu.u tVar;
        com.google.android.libraries.navigation.internal.lu.s qVar;
        this.a = i;
        this.b = akVar;
        j hVar = null;
        if (iBinder != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            tVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lu.u ? (com.google.android.libraries.navigation.internal.lu.u) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lu.t(iBinder);
        } else {
            tVar = null;
        }
        this.e = tVar;
        this.c = pendingIntent;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            qVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.libraries.navigation.internal.lu.s ? (com.google.android.libraries.navigation.internal.lu.s) iInterfaceQueryLocalInterface2 : new com.google.android.libraries.navigation.internal.lu.q(iBinder2);
        } else {
            qVar = null;
        }
        this.f = qVar;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            hVar = iInterfaceQueryLocalInterface3 instanceof j ? (j) iInterfaceQueryLocalInterface3 : new h(iBinder3);
        }
        this.g = hVar;
        this.d = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, i2);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.b, i);
        com.google.android.libraries.navigation.internal.lu.u uVar = this.e;
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 3, uVar == null ? null : uVar.asBinder());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, this.c, i);
        com.google.android.libraries.navigation.internal.lu.s sVar = this.f;
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 5, sVar == null ? null : sVar.asBinder());
        j jVar = this.g;
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 6, jVar != null ? jVar.asBinder() : null);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 8, this.d);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
