package com.google.android.libraries.navigation.internal.lh;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<aw> CREATOR = new ax();
    public final int a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    public final String f;
    public final String g;
    public final int h;
    public final int i;

    public aw(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = j2;
        this.f = str;
        this.g = str2;
        this.h = i4;
        this.i = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, i2);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 4, this.d);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 5, this.e);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 6, this.f);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 7, this.g);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 8, this.h);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 9, this.i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
