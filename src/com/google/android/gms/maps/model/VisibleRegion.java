package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.ay;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class VisibleRegion extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new ag();
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
    }

    public String toString() {
        ay ayVar = new ay(this);
        ayVar.a("nearLeft", this.nearLeft);
        ayVar.a("nearRight", this.nearRight);
        ayVar.a("farLeft", this.farLeft);
        ayVar.a("farRight", this.farRight);
        ayVar.a("latLngBounds", this.latLngBounds);
        return ayVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.nearLeft, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, this.nearRight, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, this.farLeft, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 5, this.farRight, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 6, this.latLngBounds, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
