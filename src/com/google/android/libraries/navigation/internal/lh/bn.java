package com.google.android.libraries.navigation.internal.lh;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bn extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<bn> CREATOR = new bo();
    public final int a;
    public List b;

    public bn(int i, List list) {
        this.a = i;
        this.b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, i2);
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
