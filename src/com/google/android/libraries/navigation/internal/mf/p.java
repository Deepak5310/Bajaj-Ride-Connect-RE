package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<p> CREATOR = new q();
    public final boolean a;
    public final boolean b;
    public final int c;

    public p(boolean z, boolean z2, int i) {
        this.a = z;
        this.b = z2;
        this.c = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
