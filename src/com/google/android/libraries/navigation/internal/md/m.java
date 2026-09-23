package com.google.android.libraries.navigation.internal.md;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.bi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<m> CREATOR = new n();
    final int a;
    public final com.google.android.libraries.navigation.internal.lc.a b;
    public final bi c;

    public m(int i, com.google.android.libraries.navigation.internal.lc.a aVar, bi biVar) {
        this.a = i;
        this.b = aVar;
        this.c = biVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.b, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, this.c, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
