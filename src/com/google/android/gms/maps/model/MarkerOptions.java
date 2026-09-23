package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class MarkerOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new o();
    public int a;
    public View b;
    public int c;
    private LatLng d;
    private String e;
    private String f;
    private BitmapDescriptor g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;
    private boolean l;
    private float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f49n;
    private float o;
    private float p;
    private float q;
    private String r;

    public MarkerOptions() {
        this.h = 0.5f;
        this.i = 1.0f;
        this.k = true;
        this.l = false;
        this.m = 0.0f;
        this.f49n = 0.5f;
        this.o = 0.0f;
        this.p = 1.0f;
        this.a = 0;
    }

    public MarkerOptions alpha(float f) {
        this.p = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.h = f;
        this.i = f2;
        return this;
    }

    @Deprecated
    public MarkerOptions collisionBehavior(@Marker.CollisionBehavior int i) {
        this.a = i;
        return this;
    }

    public MarkerOptions contentDescription(String str) {
        this.r = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.j = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.l = z;
        return this;
    }

    public float getAlpha() {
        return this.p;
    }

    public float getAnchorU() {
        return this.h;
    }

    public float getAnchorV() {
        return this.i;
    }

    @Deprecated
    public int getCollisionBehavior() {
        return this.a;
    }

    public String getContentDescription() {
        return this.r;
    }

    public BitmapDescriptor getIcon() {
        return this.g;
    }

    public float getInfoWindowAnchorU() {
        return this.f49n;
    }

    public float getInfoWindowAnchorV() {
        return this.o;
    }

    public LatLng getPosition() {
        return this.d;
    }

    public float getRotation() {
        return this.m;
    }

    public String getSnippet() {
        return this.f;
    }

    public String getTitle() {
        return this.e;
    }

    public float getZIndex() {
        return this.q;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.g = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f2) {
        this.f49n = f;
        this.o = f2;
        return this;
    }

    public boolean isDraggable() {
        return this.j;
    }

    public boolean isFlat() {
        return this.l;
    }

    public boolean isVisible() {
        return this.k;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.d = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.m = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.e = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.k = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, getPosition(), i);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 3, getTitle());
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 4, getSnippet());
        BitmapDescriptor bitmapDescriptor = this.g;
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 5, bitmapDescriptor == null ? null : bitmapDescriptor.a.asBinder());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 6, getAnchorU());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 7, getAnchorV());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 8, isDraggable());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 9, isVisible());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 10, isFlat());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 11, getRotation());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 12, getInfoWindowAnchorU());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 13, getInfoWindowAnchorV());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 14, getAlpha());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 15, getZIndex());
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 17, getCollisionBehavior());
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 18, new com.google.android.libraries.navigation.internal.lo.n(this.b));
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 19, this.c);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 20, getContentDescription());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public MarkerOptions zIndex(float f) {
        this.q = f;
        return this;
    }

    public MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7, int i, IBinder iBinder2, int i2, String str3) {
        com.google.android.libraries.navigation.internal.lo.l jVar;
        this.h = 0.5f;
        this.i = 1.0f;
        this.k = true;
        this.l = false;
        this.m = 0.0f;
        this.f49n = 0.5f;
        this.o = 0.0f;
        this.p = 1.0f;
        this.a = 0;
        this.d = latLng;
        this.e = str;
        this.f = str2;
        if (iBinder == null) {
            this.g = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            this.g = new BitmapDescriptor(iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lo.j(iBinder));
        }
        this.h = f;
        this.i = f2;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = f3;
        this.f49n = f4;
        this.o = f5;
        this.p = f6;
        this.q = f7;
        this.a = i;
        if (iBinder2 == null) {
            jVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            jVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.libraries.navigation.internal.lo.l ? (com.google.android.libraries.navigation.internal.lo.l) iInterfaceQueryLocalInterface2 : new com.google.android.libraries.navigation.internal.lo.j(iBinder2);
        }
        this.b = jVar != null ? (View) com.google.android.libraries.navigation.internal.lo.n.b(jVar) : null;
        this.c = i2;
        this.r = str3;
    }
}
