package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<e> CREATOR = new f();
    public final byte[] a;

    public e(byte[] bArr) {
        this.a = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.k(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
