package com.mappls.sdk.maps.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.turf.TurfMeasurement;

/* JADX INFO: loaded from: classes4.dex */
public class OfflineGeometryRegionDefinition implements OfflineRegionDefinition {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.mappls.sdk.maps.offline.OfflineGeometryRegionDefinition.1
        @Override // android.os.Parcelable.Creator
        public OfflineGeometryRegionDefinition createFromParcel(Parcel parcel) {
            return new OfflineGeometryRegionDefinition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public OfflineGeometryRegionDefinition[] newArray(int i) {
            return new OfflineGeometryRegionDefinition[i];
        }
    };
    private Geometry geometry;
    private boolean includeIdeographs;
    private double maxZoom;
    private double minZoom;
    private float pixelRatio;
    private String styleURL;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OfflineGeometryRegionDefinition(String str, Geometry geometry, double d, double d2, float f) {
        this(str, geometry, d, d2, f, false);
    }

    public OfflineGeometryRegionDefinition(String str, Geometry geometry, double d, double d2, float f, boolean z) {
        this.styleURL = str;
        this.geometry = geometry;
        this.minZoom = d;
        this.maxZoom = d2;
        this.pixelRatio = f;
        this.includeIdeographs = z;
    }

    public OfflineGeometryRegionDefinition(Parcel parcel) {
        this.styleURL = parcel.readString();
        this.geometry = Feature.fromJson(parcel.readString()).geometry();
        this.minZoom = parcel.readDouble();
        this.maxZoom = parcel.readDouble();
        this.pixelRatio = parcel.readFloat();
        this.includeIdeographs = parcel.readByte() != 0;
    }

    @Override // com.mappls.sdk.maps.offline.OfflineRegionDefinition
    public String getStyleURL() {
        return this.styleURL;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    @Override // com.mappls.sdk.maps.offline.OfflineRegionDefinition
    public LatLngBounds getBounds() {
        Geometry geometry = this.geometry;
        if (geometry == null) {
            return null;
        }
        double[] dArrBbox = TurfMeasurement.bbox(geometry);
        return LatLngBounds.from(dArrBbox[3], dArrBbox[2], dArrBbox[1], dArrBbox[0]);
    }

    @Override // com.mappls.sdk.maps.offline.OfflineRegionDefinition
    public double getMinZoom() {
        return this.minZoom;
    }

    @Override // com.mappls.sdk.maps.offline.OfflineRegionDefinition
    public double getMaxZoom() {
        return this.maxZoom;
    }

    @Override // com.mappls.sdk.maps.offline.OfflineRegionDefinition
    public float getPixelRatio() {
        return this.pixelRatio;
    }

    @Override // com.mappls.sdk.maps.offline.OfflineRegionDefinition
    public boolean getIncludeIdeographs() {
        return this.includeIdeographs;
    }

    @Override // com.mappls.sdk.maps.offline.OfflineRegionDefinition
    public String getType() {
        return "shaperegion";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.styleURL);
        parcel.writeString(Feature.fromGeometry(this.geometry).toJson());
        parcel.writeDouble(this.minZoom);
        parcel.writeDouble(this.maxZoom);
        parcel.writeFloat(this.pixelRatio);
        parcel.writeByte(this.includeIdeographs ? (byte) 1 : (byte) 0);
    }
}
