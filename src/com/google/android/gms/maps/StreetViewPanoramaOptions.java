package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class StreetViewPanoramaOptions extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new av();
    private StreetViewPanoramaCamera a;
    private String b;
    private LatLng c;
    private Integer d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private StreetViewSource j;

    public StreetViewPanoramaOptions() {
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.j = StreetViewSource.DEFAULT;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.g;
    }

    public String getPanoramaId() {
        return this.b;
    }

    public LatLng getPosition() {
        return this.c;
    }

    public Integer getRadius() {
        return this.d;
    }

    public StreetViewSource getSource() {
        return this.j;
    }

    public Boolean getStreetNamesEnabled() {
        return this.h;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.a;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.i;
    }

    public Boolean getUserNavigationEnabled() {
        return this.e;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.g = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.a = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.b = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, StreetViewSource streetViewSource) {
        this.c = latLng;
        this.j = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.c = latLng;
        this.d = num;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num, StreetViewSource streetViewSource) {
        this.c = latLng;
        this.d = num;
        this.j = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.h = Boolean.valueOf(z);
        return this;
    }

    public String toString() {
        com.google.android.libraries.navigation.internal.lh.ay ayVar = new com.google.android.libraries.navigation.internal.lh.ay(this);
        ayVar.a("PanoramaId", this.b);
        ayVar.a("Position", this.c);
        ayVar.a("Radius", this.d);
        ayVar.a("Source", this.j);
        ayVar.a("StreetViewPanoramaCamera", this.a);
        ayVar.a("UserNavigationEnabled", this.e);
        ayVar.a("ZoomGesturesEnabled", this.f);
        ayVar.a("PanningGesturesEnabled", this.g);
        ayVar.a("StreetNamesEnabled", this.h);
        ayVar.a("UseViewLifecycleInFragment", this.i);
        return ayVar.toString();
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.e = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, getStreetViewPanoramaCamera(), i);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 3, getPanoramaId());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, getPosition(), i);
        com.google.android.libraries.navigation.internal.li.d.p(parcel, 5, getRadius());
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 6, com.google.android.libraries.navigation.internal.ly.a.a(this.e));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 7, com.google.android.libraries.navigation.internal.ly.a.a(this.f));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 8, com.google.android.libraries.navigation.internal.ly.a.a(this.g));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 9, com.google.android.libraries.navigation.internal.ly.a.a(this.h));
        com.google.android.libraries.navigation.internal.li.d.e(parcel, 10, com.google.android.libraries.navigation.internal.ly.a.a(this.i));
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 11, getSource(), i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.f = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5, StreetViewSource streetViewSource) {
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.j = StreetViewSource.DEFAULT;
        this.a = streetViewPanoramaCamera;
        this.c = latLng;
        this.d = num;
        this.b = str;
        this.e = com.google.android.libraries.navigation.internal.ly.a.b(b);
        this.f = com.google.android.libraries.navigation.internal.ly.a.b(b2);
        this.g = com.google.android.libraries.navigation.internal.ly.a.b(b3);
        this.h = com.google.android.libraries.navigation.internal.ly.a.b(b4);
        this.i = com.google.android.libraries.navigation.internal.ly.a.b(b5);
        this.j = streetViewSource;
    }
}
