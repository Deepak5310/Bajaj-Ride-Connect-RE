package com.google.android.libraries.navigation.internal.lh;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bl extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<bl> CREATOR = new bm();
    public final int a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;

    public bl(int i, boolean z, boolean z2, int i2, int i3) {
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = i2;
        this.e = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, i2);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, this.d);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 5, this.e);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
