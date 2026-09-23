package com.google.android.libraries.navigation.internal.lc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<x> CREATOR = new y();
    public final boolean a;
    public final String b;
    public final int c;
    public final int d;

    public x(boolean z, String str, int i, int i2) {
        this.a = z;
        this.b = str;
        this.c = ad.a(i) - 1;
        this.d = f.a(i2) - 1;
    }

    public final int a() {
        return f.a(this.d);
    }

    public final int b() {
        return ad.a(this.c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 1, z);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, this.d);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
