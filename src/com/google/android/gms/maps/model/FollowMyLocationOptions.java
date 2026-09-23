package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class FollowMyLocationOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<FollowMyLocationOptions> CREATOR = new h();
    private final Float a;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        public Float a;

        public FollowMyLocationOptions build() {
            return new FollowMyLocationOptions(this);
        }

        public Builder setZoomLevel(float f) {
            if (f < 2.0f || f > 21.0f) {
                throw new IllegalArgumentException("Zoom level should be between 2.0 and 21.0.");
            }
            this.a = Float.valueOf(f);
            return this;
        }
    }

    public FollowMyLocationOptions(Builder builder) {
        this.a = builder.a;
    }

    public FollowMyLocationOptions(Float f) {
        this.a = f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Float getZoomLevel() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.m(parcel, 1, getZoomLevel());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
