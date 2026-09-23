package com.mappls.sdk.maps.camera;

import android.os.Parcel;
import android.os.Parcelable;
import com.mappls.sdk.maps.utils.MathUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class CameraMapplsPinPosition implements Parcelable {
    public static final Parcelable.Creator<CameraMapplsPinPosition> CREATOR = new Parcelable.Creator<CameraMapplsPinPosition>() { // from class: com.mappls.sdk.maps.camera.CameraMapplsPinPosition.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraMapplsPinPosition createFromParcel(Parcel parcel) {
            double[] dArr;
            double d = parcel.readDouble();
            String string = parcel.readString();
            double d2 = parcel.readDouble();
            double d3 = parcel.readDouble();
            int i = parcel.readInt();
            if (i > 0) {
                dArr = new double[i];
                for (int i2 = 0; i2 < i; i2++) {
                    dArr[i2] = parcel.readDouble();
                }
            } else {
                dArr = null;
            }
            return new CameraMapplsPinPosition(string, d3, d2, d, dArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraMapplsPinPosition[] newArray(int i) {
            return new CameraMapplsPinPosition[i];
        }
    };
    public final double bearing;
    public final double[] padding;
    public final String target;
    public final double tilt;
    public final double zoom;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    CameraMapplsPinPosition(String str, double d, double d2, double d3, double[] dArr) {
        this.target = str;
        this.bearing = d3;
        this.tilt = d2;
        this.zoom = d;
        this.padding = dArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.bearing);
        parcel.writeString(this.target);
        parcel.writeDouble(this.tilt);
        parcel.writeDouble(this.zoom);
        double[] dArr = this.padding;
        if (dArr != null) {
            parcel.writeInt(dArr.length);
            for (double d : this.padding) {
                parcel.writeDouble(d);
            }
            return;
        }
        parcel.writeInt(-1);
    }

    public String toString() {
        return "Target: " + this.target + ", Zoom:" + this.zoom + ", Bearing:" + this.bearing + ", Tilt:" + this.tilt + ", Padding:" + Arrays.toString(this.padding);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CameraMapplsPinPosition cameraMapplsPinPosition = (CameraMapplsPinPosition) obj;
        String str = this.target;
        return (str == null || str.equals(cameraMapplsPinPosition.target)) && this.zoom == cameraMapplsPinPosition.zoom && this.tilt == cameraMapplsPinPosition.tilt && this.bearing == cameraMapplsPinPosition.bearing && Arrays.equals(this.padding, cameraMapplsPinPosition.padding);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.bearing);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31;
        String str = this.target;
        int iHashCode = str != null ? str.hashCode() : 0;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.tilt);
        int i2 = ((i + iHashCode) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.zoom);
        return (((i2 * 31) + ((int) ((jDoubleToLongBits3 >>> 32) ^ jDoubleToLongBits3))) * 31) + Arrays.hashCode(this.padding);
    }

    public static final class Builder {
        private double bearing;
        private double[] padding;
        private String target;
        private double tilt;
        private double zoom;

        public Builder() {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
        }

        public Builder(CameraMapplsPinPosition cameraMapplsPinPosition) {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
            if (cameraMapplsPinPosition != null) {
                this.bearing = cameraMapplsPinPosition.bearing;
                this.target = cameraMapplsPinPosition.target;
                this.tilt = cameraMapplsPinPosition.tilt;
                this.zoom = cameraMapplsPinPosition.zoom;
                this.padding = cameraMapplsPinPosition.padding;
            }
        }

        public Builder(CameraMapplsPinUpdateFactory.CameraMapplsPinPositionUpdate cameraMapplsPinPositionUpdate) {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
            if (cameraMapplsPinPositionUpdate != null) {
                this.bearing = cameraMapplsPinPositionUpdate.getBearing();
                this.target = cameraMapplsPinPositionUpdate.getTarget();
                this.tilt = cameraMapplsPinPositionUpdate.getTilt();
                this.zoom = cameraMapplsPinPositionUpdate.getZoom();
                this.padding = cameraMapplsPinPositionUpdate.getPadding();
            }
        }

        public Builder(CameraUpdateFactory.ZoomUpdate zoomUpdate) {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
            if (zoomUpdate != null) {
                this.zoom = zoomUpdate.getZoom();
            }
        }

        public Builder bearing(double d) {
            while (d >= 360.0d) {
                d -= 360.0d;
            }
            while (d < 0.0d) {
                d += 360.0d;
            }
            this.bearing = d;
            return this;
        }

        public Builder target(String str) {
            this.target = str;
            return this;
        }

        public Builder tilt(double d) {
            this.tilt = MathUtils.clamp(d, 0.0d, 60.0d);
            return this;
        }

        public Builder zoom(double d) {
            this.zoom = d;
            return this;
        }

        public Builder padding(double[] dArr) {
            this.padding = dArr;
            return this;
        }

        public Builder padding(double d, double d2, double d3, double d4) {
            this.padding = new double[]{d, d2, d3, d4};
            return this;
        }

        public CameraMapplsPinPosition build() {
            return new CameraMapplsPinPosition(this.target, this.zoom, this.tilt, this.bearing, this.padding);
        }
    }
}
