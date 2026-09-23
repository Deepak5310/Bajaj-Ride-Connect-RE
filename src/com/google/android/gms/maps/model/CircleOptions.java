package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class CircleOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new c();
    private LatLng a;
    private double b;
    private float c;
    private int d;
    private int e;
    private float f;
    private boolean g;
    private boolean h;
    private List i;

    public CircleOptions() {
        this.a = null;
        this.b = 0.0d;
        this.c = 10.0f;
        this.d = ViewCompat.MEASURED_STATE_MASK;
        this.e = 0;
        this.f = 0.0f;
        this.g = true;
        this.h = false;
        this.i = null;
    }

    public CircleOptions(LatLng latLng, double d, float f, int i, int i2, float f2, boolean z, boolean z2, List list) {
        this.a = latLng;
        this.b = d;
        this.c = f;
        this.d = i;
        this.e = i2;
        this.f = f2;
        this.g = z;
        this.h = z2;
        this.i = list;
    }

    public CircleOptions center(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public CircleOptions clickable(boolean z) {
        this.h = z;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.e = i;
        return this;
    }

    public LatLng getCenter() {
        return this.a;
    }

    public int getFillColor() {
        return this.e;
    }

    public double getRadius() {
        return this.b;
    }

    public int getStrokeColor() {
        return this.d;
    }

    public List<PatternItem> getStrokePattern() {
        return this.i;
    }

    public float getStrokeWidth() {
        return this.c;
    }

    public float getZIndex() {
        return this.f;
    }

    public boolean isClickable() {
        return this.h;
    }

    public boolean isVisible() {
        return this.g;
    }

    public CircleOptions radius(double d) {
        this.b = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.d = i;
        return this;
    }

    public CircleOptions strokePattern(List<PatternItem> list) {
        this.i = list;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.c = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.g = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, getCenter(), i);
        com.google.android.libraries.navigation.internal.li.d.f(parcel, 3, getRadius());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 4, getStrokeWidth());
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 5, getStrokeColor());
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 6, getFillColor());
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 7, getZIndex());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 8, isVisible());
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 9, isClickable());
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 10, getStrokePattern());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public CircleOptions zIndex(float f) {
        this.f = f;
        return this;
    }
}
