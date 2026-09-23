package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureLayerOptions extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<FeatureLayerOptions> CREATOR = new f();
    public static final fy a = fy.u(FeatureType.ADMINISTRATIVE_AREA_LEVEL_1, FeatureType.ADMINISTRATIVE_AREA_LEVEL_2, FeatureType.COUNTRY, FeatureType.LOCALITY, FeatureType.POSTAL_CODE, FeatureType.SCHOOL_DISTRICT, FeatureType.DATASET);

    @FeatureType
    private final String b;
    private final String c;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        public String a;
        public String b;

        public FeatureLayerOptions build() {
            String str = this.a;
            if (str == null) {
                throw new IllegalArgumentException("FeatureType must be specified.");
            }
            if (str.equals(FeatureType.DATASET) && this.b == null) {
                throw new IllegalArgumentException("A datasetId must be specified for DATASET feature layers.");
            }
            return new FeatureLayerOptions(this);
        }

        public Builder datasetId(String str) {
            this.b = str;
            return this;
        }

        public Builder featureType(@FeatureType String str) {
            be.b(FeatureLayerOptions.a.contains(str), "Invalid FeatureType value");
            this.a = str;
            return this;
        }
    }

    public FeatureLayerOptions(Builder builder) {
        this.b = builder.a;
        this.c = builder.b;
    }

    public FeatureLayerOptions(@FeatureType String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDatasetId() {
        return this.c;
    }

    @FeatureType
    public String getFeatureType() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 1, getFeatureType());
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, getDatasetId());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
