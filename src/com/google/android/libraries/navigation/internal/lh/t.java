package com.google.android.libraries.navigation.internal.lh;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<t> CREATOR = new u();
    public final bl a;
    public final boolean b;
    public final boolean c;
    public final int[] d;
    public final int e;
    public final int[] f;

    public t(bl blVar, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.a = blVar;
        this.b = z;
        this.c = z2;
        this.d = iArr;
        this.e = i;
        this.f = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        bl blVar = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 1, blVar, i);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.o(parcel, 4, this.d);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 5, this.e);
        com.google.android.libraries.navigation.internal.li.d.o(parcel, 6, this.f);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
