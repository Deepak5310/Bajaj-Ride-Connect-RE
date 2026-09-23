package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.ay;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class StreetViewPanoramaLink extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new w();
    public final float bearing;
    public final String panoId;

    public StreetViewPanoramaLink(String str, float f) {
        this.panoId = str;
        this.bearing = (((double) f) <= 0.0d ? (f % 360.0f) + 360.0f : f) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.panoId, Float.valueOf(this.bearing)});
    }

    public String toString() {
        ay ayVar = new ay(this);
        ayVar.a("panoId", this.panoId);
        ayVar.a("bearing", Float.valueOf(this.bearing));
        return ayVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.panoId);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 3, this.bearing);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
