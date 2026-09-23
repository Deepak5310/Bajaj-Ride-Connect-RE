package com.google.android.libraries.navigation.internal.md;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.bg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<k> CREATOR = new l();
    final int a;
    final bg b;

    public k(int i, bg bgVar) {
        this.a = i;
        this.b = bgVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.b, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
