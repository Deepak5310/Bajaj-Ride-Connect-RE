package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<e> CREATOR = new f();
    public final boolean a;
    public final int b;

    public e(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
