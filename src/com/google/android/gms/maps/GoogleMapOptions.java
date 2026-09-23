package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapColorScheme;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleMapOptions extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new ab();
    private static final Integer a = Integer.valueOf(Color.argb(255, 236, 233, JfifUtil.MARKER_APP1));
    private Boolean b;
    private Boolean c;
    private int d;
    private CameraPosition e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Boolean f45n;
    private Float o;
    private Float p;
    private LatLngBounds q;
    private Boolean r;
    private Integer s;
    private String t;
    private Boolean u;

    @MapColorScheme
    private int v;

    public GoogleMapOptions() {
        this.d = -1;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.t = null;
    }

    public GoogleMapOptions(byte b, byte b2, int i, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds, byte b12, Integer num, String str, byte b13, @MapColorScheme int i2) {
        this.d = -1;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.t = null;
        this.b = com.google.android.libraries.navigation.internal.ly.a.b(b);
        this.c = com.google.android.libraries.navigation.internal.ly.a.b(b2);
        this.d = i;
        this.e = cameraPosition;
        this.f = com.google.android.libraries.navigation.internal.ly.a.b(b3);
        this.g = com.google.android.libraries.navigation.internal.ly.a.b(b4);
        this.h = com.google.android.libraries.navigation.internal.ly.a.b(b5);
        this.i = com.google.android.libraries.navigation.internal.ly.a.b(b6);
        this.j = com.google.android.libraries.navigation.internal.ly.a.b(b7);
        this.k = com.google.android.libraries.navigation.internal.ly.a.b(b8);
        this.l = com.google.android.libraries.navigation.internal.ly.a.b(b9);
        this.m = com.google.android.libraries.navigation.internal.ly.a.b(b10);
        this.f45n = com.google.android.libraries.navigation.internal.ly.a.b(b11);
        this.o = f;
        this.p = f2;
        this.q = latLngBounds;
        this.r = com.google.android.libraries.navigation.internal.ly.a.b(b12);
        this.s = num;
        this.t = str;
        this.u = com.google.android.libraries.navigation.internal.ly.a.b(b13);
        this.v = i2;
    }

    public static CameraPosition a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, an.a);
        LatLng latLng = new LatLng(typedArrayObtainAttributes.hasValue(an.g) ? typedArrayObtainAttributes.getFloat(an.g, 0.0f) : 0.0f, typedArrayObtainAttributes.hasValue(an.h) ? typedArrayObtainAttributes.getFloat(an.h, 0.0f) : 0.0f);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        if (typedArrayObtainAttributes.hasValue(an.j)) {
            builder.zoom(typedArrayObtainAttributes.getFloat(an.j, 0.0f));
        }
        if (typedArrayObtainAttributes.hasValue(an.d)) {
            builder.bearing(typedArrayObtainAttributes.getFloat(an.d, 0.0f));
        }
        if (typedArrayObtainAttributes.hasValue(an.i)) {
            builder.tilt(typedArrayObtainAttributes.getFloat(an.i, 0.0f));
        }
        typedArrayObtainAttributes.recycle();
        return builder.build();
    }

    public static LatLngBounds b(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, an.a);
        Float fValueOf = typedArrayObtainAttributes.hasValue(an.m) ? Float.valueOf(typedArrayObtainAttributes.getFloat(an.m, 0.0f)) : null;
        Float fValueOf2 = typedArrayObtainAttributes.hasValue(an.f48n) ? Float.valueOf(typedArrayObtainAttributes.getFloat(an.f48n, 0.0f)) : null;
        Float fValueOf3 = typedArrayObtainAttributes.hasValue(an.k) ? Float.valueOf(typedArrayObtainAttributes.getFloat(an.k, 0.0f)) : null;
        Float fValueOf4 = typedArrayObtainAttributes.hasValue(an.l) ? Float.valueOf(typedArrayObtainAttributes.getFloat(an.l, 0.0f)) : null;
        typedArrayObtainAttributes.recycle();
        if (fValueOf == null || fValueOf2 == null || fValueOf3 == null || fValueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(fValueOf.floatValue(), fValueOf2.floatValue()), new LatLng(fValueOf3.floatValue(), fValueOf4.floatValue()));
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        String string;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, an.a);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(an.r)) {
            googleMapOptions.mapType(typedArrayObtainAttributes.getInt(an.r, -1));
        }
        if (typedArrayObtainAttributes.hasValue(an.B)) {
            googleMapOptions.zOrderOnTop(typedArrayObtainAttributes.getBoolean(an.B, false));
        }
        if (typedArrayObtainAttributes.hasValue(an.A)) {
            googleMapOptions.useViewLifecycleInFragment(typedArrayObtainAttributes.getBoolean(an.A, false));
        }
        if (typedArrayObtainAttributes.hasValue(an.s)) {
            googleMapOptions.compassEnabled(typedArrayObtainAttributes.getBoolean(an.s, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.u)) {
            googleMapOptions.rotateGesturesEnabled(typedArrayObtainAttributes.getBoolean(an.u, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.w)) {
            googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(typedArrayObtainAttributes.getBoolean(an.w, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.v)) {
            googleMapOptions.scrollGesturesEnabled(typedArrayObtainAttributes.getBoolean(an.v, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.x)) {
            googleMapOptions.tiltGesturesEnabled(typedArrayObtainAttributes.getBoolean(an.x, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.z)) {
            googleMapOptions.zoomGesturesEnabled(typedArrayObtainAttributes.getBoolean(an.z, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.y)) {
            googleMapOptions.zoomControlsEnabled(typedArrayObtainAttributes.getBoolean(an.y, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.o)) {
            googleMapOptions.liteMode(typedArrayObtainAttributes.getBoolean(an.o, false));
        }
        if (typedArrayObtainAttributes.hasValue(an.t)) {
            googleMapOptions.mapToolbarEnabled(typedArrayObtainAttributes.getBoolean(an.t, true));
        }
        if (typedArrayObtainAttributes.hasValue(an.b)) {
            typedArrayObtainAttributes.getBoolean(an.b, false);
        }
        if (typedArrayObtainAttributes.hasValue(an.f)) {
            googleMapOptions.minZoomPreference(typedArrayObtainAttributes.getFloat(an.f, Float.NEGATIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(an.f)) {
            googleMapOptions.maxZoomPreference(typedArrayObtainAttributes.getFloat(an.e, Float.POSITIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(an.q) && (string = typedArrayObtainAttributes.getString(an.q)) != null && !string.isEmpty()) {
            googleMapOptions.mapId(string);
        }
        if (typedArrayObtainAttributes.hasValue(an.c)) {
            googleMapOptions.backgroundColor(Integer.valueOf(typedArrayObtainAttributes.getColor(an.c, a.intValue())));
        }
        if (typedArrayObtainAttributes.hasValue(an.p)) {
            googleMapOptions.mapColorScheme(typedArrayObtainAttributes.getInt(an.p, 0));
        }
        googleMapOptions.latLngBoundsForCameraTarget(b(context, attributeSet));
        googleMapOptions.camera(a(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions ambientEnabled(boolean z) {
        return this;
    }

    public GoogleMapOptions backgroundColor(Integer num) {
        this.s = num;
        return this;
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.e = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.g = Boolean.valueOf(z);
        return this;
    }

    public Boolean getAmbientEnabled() {
        return this.f45n;
    }

    public Integer getBackgroundColor() {
        return this.s;
    }

    public CameraPosition getCamera() {
        return this.e;
    }

    public Boolean getCompassEnabled() {
        return this.g;
    }

    public LatLngBounds getLatLngBoundsForCameraTarget() {
        LatLngBounds latLngBounds = this.q;
        if (latLngBounds != null) {
            return new LatLngBounds(latLngBounds);
        }
        return null;
    }

    public Boolean getLiteMode() {
        return this.l;
    }

    @MapColorScheme
    public int getMapColorScheme() {
        return this.v;
    }

    public String getMapId() {
        return this.t;
    }

    public Boolean getMapToolbarEnabled() {
        return this.m;
    }

    public int getMapType() {
        return this.d;
    }

    public Float getMaxZoomPreference() {
        return this.p;
    }

    public Float getMinZoomPreference() {
        return this.o;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.k;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.h;
    }

    public Boolean getScrollGesturesEnabledDuringRotateOrZoom() {
        return this.r;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.j;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.c;
    }

    public Boolean getZOrderOnTop() {
        return this.b;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.i;
    }

    public GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.q = latLngBounds;
        return this;
    }

    public GoogleMapOptions mapColorScheme(@MapColorScheme int i) {
        this.v = i;
        return this;
    }

    public GoogleMapOptions mapId(String str) {
        this.t = str;
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.m = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.d = i;
        return this;
    }

    public GoogleMapOptions maxZoomPreference(float f) {
        this.p = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions minZoomPreference(float f) {
        this.o = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.k = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.h = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z) {
        this.r = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.j = Boolean.valueOf(z);
        return this;
    }

    public String toString() {
        com.google.android.libraries.navigation.internal.lh.ay ayVar = new com.google.android.libraries.navigation.internal.lh.ay(this);
        ayVar.a("MapType", Integer.valueOf(this.d));
        ayVar.a("LiteMode", this.l);
        ayVar.a("Camera", this.e);
        ayVar.a("CompassEnabled", this.g);
        ayVar.a("ZoomControlsEnabled", this.f);
        ayVar.a("ScrollGesturesEnabled", this.h);
        ayVar.a("ZoomGesturesEnabled", this.i);
        ayVar.a("TiltGesturesEnabled", this.j);
        ayVar.a("RotateGesturesEnabled", this.k);
        ayVar.a("ScrollGesturesEnabledDuringRotateOrZoom", this.r);
        ayVar.a("MapToolbarEnabled", this.m);
        ayVar.a("AmbientEnabled", this.f45n);
        ayVar.a("MinZoomPreference", this.o);
        ayVar.a("MaxZoomPreference", this.p);
        ayVar.a("BackgroundColor", this.s);
        ayVar.a("LatLngBoundsForCameraTarget", this.q);
        ayVar.a("ZOrderOnTop", this.b);
        ayVar.a("UseViewLifecycleInFragment", this.c);
        ayVar.a("isInstrumentClusterMap", this.u);
        ayVar.a("mapColorScheme", Integer.valueOf(this.v));
        return ayVar.toString();
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.c = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 2, com.google.android.libraries.navigation.internal.ly.a.a(this.b));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 3, com.google.android.libraries.navigation.internal.ly.a.a(this.c));
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, getMapType());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 5, getCamera(), i);
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 6, com.google.android.libraries.navigation.internal.ly.a.a(this.f));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 7, com.google.android.libraries.navigation.internal.ly.a.a(this.g));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 8, com.google.android.libraries.navigation.internal.ly.a.a(this.h));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 9, com.google.android.libraries.navigation.internal.ly.a.a(this.i));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 10, com.google.android.libraries.navigation.internal.ly.a.a(this.j));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 11, com.google.android.libraries.navigation.internal.ly.a.a(this.k));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 12, com.google.android.libraries.navigation.internal.ly.a.a(this.l));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 14, com.google.android.libraries.navigation.internal.ly.a.a(this.m));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 15, com.google.android.libraries.navigation.internal.ly.a.a(this.f45n));
        com.google.android.libraries.navigation.internal.li.d.m(parcel, 16, getMinZoomPreference());
        com.google.android.libraries.navigation.internal.li.d.m(parcel, 17, getMaxZoomPreference());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 18, getLatLngBoundsForCameraTarget(), i);
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 19, com.google.android.libraries.navigation.internal.ly.a.a(this.r));
        com.google.android.libraries.navigation.internal.li.d.p(parcel, 20, getBackgroundColor());
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 21, getMapId());
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 22, com.google.android.libraries.navigation.internal.ly.a.a(this.u));
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 23, getMapColorScheme());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.f = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions liteMode(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Lite mode does not apply to the Navigation SDK. It exists for compile time compatibility with com.google.android.gms:play-services-maps only");
        }
        this.l = false;
        return this;
    }
}
