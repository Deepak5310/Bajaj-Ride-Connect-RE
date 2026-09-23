package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class StyleSpan extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<StyleSpan> CREATOR = new ab();
    private final StrokeStyle a;
    private final double b;

    public StyleSpan(int i) {
        this.a = StrokeStyle.colorBuilder(i).build();
        this.b = 1.0d;
    }

    public StyleSpan(StrokeStyle strokeStyle) {
        this.a = strokeStyle;
        this.b = 1.0d;
    }

    public StyleSpan(StrokeStyle strokeStyle, double d) {
        if (d <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.a = strokeStyle;
        this.b = d;
    }

    public double getSegments() {
        return this.b;
    }

    public StrokeStyle getStyle() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, getStyle(), i);
        com.google.android.libraries.navigation.internal.li.d.f(parcel, 3, getSegments());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public StyleSpan(int i, double d) {
        if (d <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.a = StrokeStyle.colorBuilder(i).build();
        this.b = d;
    }
}
