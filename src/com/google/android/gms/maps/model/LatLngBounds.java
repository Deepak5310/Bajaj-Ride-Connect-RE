package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.libraries.navigation.internal.lh.ay;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class LatLngBounds extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new l();
    public final LatLng northeast;
    public final LatLng southwest;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        private double a = Double.POSITIVE_INFINITY;
        private double b = Double.NEGATIVE_INFINITY;
        private double c = Double.NaN;
        private double d = Double.NaN;

        public LatLngBounds build() {
            be.g(!Double.isNaN(this.c), "no included points");
            return new LatLngBounds(new LatLng(this.a, this.c), new LatLng(this.b, this.d));
        }

        public Builder include(LatLng latLng) {
            double d = this.a;
            double d2 = latLng.latitude;
            this.a = Math.min(d, d2);
            this.b = Math.max(this.b, d2);
            double d3 = latLng.longitude;
            double d4 = this.c;
            if (!Double.isNaN(d4)) {
                double d5 = this.d;
                if (d4 > d5 ? !(d4 <= d3 || d3 <= d5) : !(d4 <= d3 && d3 <= d5)) {
                    if (LatLngBounds.b(d4, d3) < LatLngBounds.a(d5, d3)) {
                        this.c = d3;
                    }
                }
                return this;
            }
            this.c = d3;
            this.d = d3;
            return this;
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        be.k(latLng, "null southwest");
        be.k(latLng2, "null northeast");
        double d = latLng2.latitude;
        double d2 = latLng.latitude;
        be.c(d >= d2, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d2), Double.valueOf(d));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static double a(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public static double b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    private final boolean c(double d) {
        LatLng latLng = this.northeast;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (d2 <= d3) {
            return d2 <= d && d <= d3;
        }
        return d2 <= d || d <= d3;
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.b(context, attributeSet);
    }

    public boolean contains(LatLng latLng) {
        LatLng latLng2 = this.southwest;
        double d = latLng.latitude;
        return latLng2.latitude <= d && d <= this.northeast.latitude && c(latLng.longitude);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        LatLng latLng = this.northeast;
        LatLng latLng2 = this.southwest;
        double d = latLng2.latitude + latLng.latitude;
        double d2 = latLng.longitude;
        double d3 = latLng2.longitude;
        if (d3 > d2) {
            d2 += 360.0d;
        }
        return new LatLng(d / 2.0d, (d2 + d3) / 2.0d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.southwest, this.northeast});
    }

    public LatLngBounds including(LatLng latLng) {
        LatLng latLng2 = this.southwest;
        double d = latLng2.latitude;
        double d2 = latLng.latitude;
        double dMin = Math.min(d, d2);
        LatLng latLng3 = this.northeast;
        double dMax = Math.max(latLng3.latitude, d2);
        double d3 = latLng3.longitude;
        double d4 = latLng2.longitude;
        double d5 = latLng.longitude;
        if (!c(d5)) {
            if (b(d4, d5) < a(d3, d5)) {
                d4 = d5;
            } else {
                d3 = d5;
            }
        }
        return new LatLngBounds(new LatLng(dMin, d4), new LatLng(dMax, d3));
    }

    public String toString() {
        ay ayVar = new ay(this);
        ayVar.a("southwest", this.southwest);
        ayVar.a("northeast", this.northeast);
        return ayVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.southwest, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, this.northeast, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public LatLngBounds(LatLngBounds latLngBounds) {
        this(latLngBounds.southwest, latLngBounds.northeast);
    }
}
