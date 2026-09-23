package com.google.android.libraries.navigation.internal.lc;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<v> CREATOR = new w();
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    private final Context f;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 1, str);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 4, new com.google.android.libraries.navigation.internal.lo.n(this.f));
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 5, this.d);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 6, this.e);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public v(String str, boolean z, boolean z2, IBinder iBinder, boolean z3, boolean z4) {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        this.a = str;
        this.b = z;
        this.c = z2;
        if (iBinder == null) {
            jVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            jVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(iBinder);
        }
        this.f = (Context) com.google.android.libraries.navigation.internal.lo.n.b(jVar);
        this.d = z3;
        this.e = z4;
    }
}
