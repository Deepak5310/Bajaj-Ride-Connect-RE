package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GroundOverlayOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new j();
    public static final float NO_DIMENSION = -1.0f;
    private BitmapDescriptor a;
    private LatLng b;
    private float c;
    private float d;
    private LatLngBounds e;
    private float f;
    private float g;
    private boolean h;
    private float i;
    private float j;
    private float k;
    private boolean l;

    public GroundOverlayOptions() {
        this.h = true;
        this.i = 0.0f;
        this.j = 0.5f;
        this.k = 0.5f;
        this.l = false;
    }

    private final void a(LatLng latLng, float f, float f2) {
        this.b = latLng;
        this.c = f;
        this.d = f2;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.j = f;
        this.k = f2;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public GroundOverlayOptions clickable(boolean z) {
        this.l = z;
        return this;
    }

    public float getAnchorU() {
        return this.j;
    }

    public float getAnchorV() {
        return this.k;
    }

    public float getBearing() {
        return this.f;
    }

    public LatLngBounds getBounds() {
        return this.e;
    }

    public float getHeight() {
        return this.d;
    }

    public BitmapDescriptor getImage() {
        return this.a;
    }

    public LatLng getLocation() {
        return this.b;
    }

    public float getTransparency() {
        return this.i;
    }

    public float getWidth() {
        return this.c;
    }

    public float getZIndex() {
        return this.g;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        be.k(bitmapDescriptor, "imageDescriptor must not be null");
        this.a = bitmapDescriptor;
        return this;
    }

    public boolean isClickable() {
        return this.l;
    }

    public boolean isVisible() {
        return this.h;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        be.g(this.e == null, "Position has already been set using positionFromBounds");
        be.b(latLng != null, "Location must be specified");
        be.b(f >= 0.0f, "Width must be non-negative");
        a(latLng, f, -1.0f);
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        LatLng latLng = this.b;
        be.g(latLng == null, "Position has already been set using position: ".concat(String.valueOf(String.valueOf(latLng))));
        this.e = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = false;
        if (f >= 0.0f && f <= 1.0f) {
            z = true;
        }
        be.b(z, "Transparency must be in the range [0..1]");
        this.i = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 2, this.a.a.asBinder());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, getLocation(), i);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 4, getWidth());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 5, getHeight());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 6, getBounds(), i);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 7, getBearing());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 8, getZIndex());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 9, isVisible());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 10, getTransparency());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 11, getAnchorU());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 12, getAnchorV());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 13, isClickable());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.g = f;
        return this;
    }

    public GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        this.h = true;
        this.i = 0.0f;
        this.j = 0.5f;
        this.k = 0.5f;
        this.l = false;
        if (iBinder == null) {
            jVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            jVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(iBinder);
        }
        this.a = new BitmapDescriptor(jVar);
        this.b = latLng;
        this.c = f;
        this.d = f2;
        this.e = latLngBounds;
        this.f = f3;
        this.g = f4;
        this.h = z;
        this.i = f5;
        this.j = f6;
        this.k = f7;
        this.l = z2;
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        be.g(this.e == null, "Position has already been set using positionFromBounds");
        be.b(latLng != null, "Location must be specified");
        be.b(f >= 0.0f, "Width must be non-negative");
        be.b(f2 >= 0.0f, "Height must be non-negative");
        a(latLng, f, f2);
        return this;
    }
}
