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
public final class CameraPosition extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new a();
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        private LatLng a;
        private float b;
        private float c;
        private float d;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.a = cameraPosition.target;
            this.b = cameraPosition.zoom;
            this.c = cameraPosition.tilt;
            this.d = cameraPosition.bearing;
        }

        public Builder bearing(float f) {
            this.d = f;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.a, this.b, this.c, this.d);
        }

        public Builder target(LatLng latLng) {
            this.a = latLng;
            return this;
        }

        public Builder tilt(float f) {
            this.c = f;
            return this;
        }

        public Builder zoom(float f) {
            this.b = f;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        be.k(latLng, "null camera target");
        boolean z = false;
        if (f2 >= 0.0f && f2 <= 90.0f) {
            z = true;
        }
        be.c(z, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2 + 0.0f;
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.a(context, attributeSet);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
    }

    public String toString() {
        ay ayVar = new ay(this);
        ayVar.a("target", this.target);
        ayVar.a("zoom", Float.valueOf(this.zoom));
        ayVar.a("tilt", Float.valueOf(this.tilt));
        ayVar.a("bearing", Float.valueOf(this.bearing));
        return ayVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.target, i);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 3, this.zoom);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 4, this.tilt);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 5, this.bearing);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
