package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureStyle extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<FeatureStyle> CREATOR = new g();
    private final Integer a;
    private final Integer b;
    private final Float c;
    private final Float d;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        public Integer a;
        public Integer b;
        public Float c;
        public Float d;

        public FeatureStyle build() {
            return new FeatureStyle(this);
        }

        public Builder fillColor(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }

        public Builder pointRadius(float f) {
            be.b(f >= 0.0f, "Point radius cannot be negative.");
            be.b(f <= 128.0f, "The max allowed pointRadius value is 128px.");
            this.d = Float.valueOf(f);
            return this;
        }

        public Builder strokeColor(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public Builder strokeWidth(float f) {
            be.b(f >= 0.0f, "Stroke width cannot be negative.");
            this.c = Float.valueOf(f);
            return this;
        }
    }

    public FeatureStyle(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }

    public FeatureStyle(Integer num, Integer num2, Float f, Float f2) {
        this.a = num;
        this.b = num2;
        this.c = f;
        this.d = f2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getFillColor() {
        return this.a;
    }

    public Float getPointRadius() {
        return this.d;
    }

    public Integer getStrokeColor() {
        return this.b;
    }

    public Float getStrokeWidth() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.p(parcel, 1, getFillColor());
        com.google.android.libraries.navigation.internal.li.d.p(parcel, 2, getStrokeColor());
        com.google.android.libraries.navigation.internal.li.d.m(parcel, 3, getStrokeWidth());
        com.google.android.libraries.navigation.internal.li.d.m(parcel, 4, getPointRadius());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
