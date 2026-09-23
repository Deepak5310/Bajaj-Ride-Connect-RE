package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class Tile extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<Tile> CREATOR = new ac();
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i, int i2, byte[] bArr) {
        this.width = i;
        this.height = i2;
        this.data = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.width);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.height);
        com.google.android.libraries.navigation.internal.li.d.k(parcel, 4, this.data);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
