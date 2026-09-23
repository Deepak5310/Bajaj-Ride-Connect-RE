package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CircularBounds implements LocationBias, LocationRestriction, Parcelable {
    public static CircularBounds newInstance(LatLng latLng, double d) {
        return new zzay(latLng, d);
    }

    public abstract LatLng getCenter();

    public abstract double getRadius();
}
