package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class StrokeStyle extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<StrokeStyle> CREATOR = new aa();
    public final float a;
    public final int b;
    public final int c;
    private final boolean d;
    private final StampStyle e;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        public float a;
        public int b;
        public int c;
        public boolean d;
        private StampStyle e;

        public Builder() {
        }

        public Builder(StrokeStyle strokeStyle) {
            this.a = strokeStyle.a;
            Pair pairA = strokeStyle.a();
            this.b = ((Integer) pairA.first).intValue();
            this.c = ((Integer) pairA.second).intValue();
            this.d = strokeStyle.isVisible();
            this.e = strokeStyle.getStamp();
        }

        public final Pair a() {
            return new Pair(Integer.valueOf(this.b), Integer.valueOf(this.c));
        }

        public final void b(int i) {
            this.b = i;
            this.c = i;
        }

        public StrokeStyle build() {
            return new StrokeStyle(this.a, this.b, this.c, this.d, this.e);
        }

        public Builder stamp(StampStyle stampStyle) {
            this.e = stampStyle;
            return this;
        }
    }

    public StrokeStyle(float f, int i, int i2, boolean z, StampStyle stampStyle) {
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = stampStyle;
    }

    public static Builder colorBuilder(int i) {
        Builder builder = new Builder();
        builder.b(i);
        return builder;
    }

    public static Builder gradientBuilder(int i, int i2) {
        Builder builder = new Builder();
        builder.b = i;
        builder.c = i2;
        return builder;
    }

    public static Builder transparentColorBuilder() {
        Builder builder = new Builder();
        builder.b(0);
        return builder;
    }

    public final Pair a() {
        return new Pair(Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public StampStyle getStamp() {
        return this.e;
    }

    public boolean isVisible() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        float f = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 2, f);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 5, isVisible());
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 6, getStamp(), i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
