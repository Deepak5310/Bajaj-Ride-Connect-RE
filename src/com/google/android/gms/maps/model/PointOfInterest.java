package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class PointOfInterest extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new r();
    public final LatLng latLng;
    public final String name;
    public final String placeId;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.latLng = latLng;
        this.placeId = str;
        this.name = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.latLng, i);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 3, this.placeId);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 4, this.name);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
