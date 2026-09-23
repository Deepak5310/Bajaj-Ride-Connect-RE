package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.libraries.navigation.internal.lh.ay;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class StreetViewPanoramaLocation extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new x();
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.links = streetViewPanoramaLinkArr;
        this.position = latLng;
        this.panoId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.position, this.panoId});
    }

    public String toString() {
        ay ayVar = new ay(this);
        ayVar.a("panoId", this.panoId);
        ayVar.a(ViewProps.POSITION, this.position.toString());
        return ayVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 2, this.links, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, this.position, i);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 4, this.panoId);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
