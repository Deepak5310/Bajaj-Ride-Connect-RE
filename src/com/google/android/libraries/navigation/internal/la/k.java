package com.google.android.libraries.navigation.internal.la;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<k> CREATOR = new l();
    public final int a;
    public final int b;
    public final int c;

    public k(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, i2);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
