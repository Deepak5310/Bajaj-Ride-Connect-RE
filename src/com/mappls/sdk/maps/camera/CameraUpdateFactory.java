package com.mappls.sdk.maps.camera;

import android.graphics.Point;
import android.graphics.PointF;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.UiSettings;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class CameraUpdateFactory {
    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraPositionUpdate(cameraPosition.bearing, cameraPosition.target, cameraPosition.tilt, cameraPosition.zoom, cameraPosition.padding);
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraPositionUpdate(-1.0d, latLng, -1.0d, -1.0d, null);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return newLatLngBounds(latLngBounds, i, i, i, i);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, double d, double d2, int i) {
        return newLatLngBounds(latLngBounds, d, d2, i, i, i, i);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        return new CameraBoundsUpdate(latLngBounds, null, null, i, i2, i3, i4);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, double d, double d2, int i, int i2, int i3, int i4) {
        return new CameraBoundsUpdate(latLngBounds, Double.valueOf(d), Double.valueOf(d2), i, i2, i3, i4);
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, double d) {
        return new CameraPositionUpdate(-1.0d, latLng, -1.0d, d, null);
    }

    public static CameraUpdate newLatLngPadding(LatLng latLng, double d, double d2, double d3, double d4) {
        return new CameraPositionUpdate(-1.0d, latLng, -1.0d, -1.0d, new double[]{d, d2, d3, d4});
    }

    public static CameraUpdate zoomBy(double d, Point point) {
        return new ZoomUpdate(d, point.x, point.y);
    }

    public static CameraUpdate zoomBy(double d) {
        return new ZoomUpdate(2, d);
    }

    public static CameraUpdate zoomIn() {
        return new ZoomUpdate(0);
    }

    public static CameraUpdate zoomOut() {
        return new ZoomUpdate(1);
    }

    public static CameraUpdate zoomTo(double d) {
        return new ZoomUpdate(3, d);
    }

    public static CameraUpdate bearingTo(double d) {
        return new CameraPositionUpdate(d, null, -1.0d, -1.0d, null);
    }

    public static CameraUpdate tiltTo(double d) {
        return new CameraPositionUpdate(-1.0d, null, d, -1.0d, null);
    }

    public static CameraUpdate paddingTo(double[] dArr) {
        return new CameraPositionUpdate(-1.0d, null, -1.0d, -1.0d, dArr);
    }

    public static CameraUpdate paddingTo(double d, double d2, double d3, double d4) {
        return paddingTo(new double[]{d, d2, d3, d4});
    }

    static final class CameraPositionUpdate implements CameraUpdate {
        private final double bearing;
        private final double[] padding;
        private final LatLng target;
        private final double tilt;
        private final double zoom;

        CameraPositionUpdate(double d, LatLng latLng, double d2, double d3, double[] dArr) {
            this.bearing = d;
            this.target = latLng;
            this.tilt = d2;
            this.zoom = d3;
            this.padding = dArr;
        }

        public LatLng getTarget() {
            return this.target;
        }

        public double getBearing() {
            return this.bearing;
        }

        public double getTilt() {
            return this.tilt;
        }

        public double getZoom() {
            return this.zoom;
        }

        public double[] getPadding() {
            return this.padding;
        }

        @Override // com.mappls.sdk.maps.camera.CameraUpdate
        public CameraPosition getCameraPosition(MapplsMap mapplsMap) {
            if (this.target == null) {
                return new CameraPosition.Builder(this).target(mapplsMap.getCameraPosition().target).build();
            }
            return new CameraPosition.Builder(this).build();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CameraPositionUpdate cameraPositionUpdate = (CameraPositionUpdate) obj;
            if (Double.compare(cameraPositionUpdate.bearing, this.bearing) != 0 || Double.compare(cameraPositionUpdate.tilt, this.tilt) != 0 || Double.compare(cameraPositionUpdate.zoom, this.zoom) != 0) {
                return false;
            }
            LatLng latLng = this.target;
            if (latLng == null ? cameraPositionUpdate.target == null : latLng.equals(cameraPositionUpdate.target)) {
                return Arrays.equals(this.padding, cameraPositionUpdate.padding);
            }
            return false;
        }

        public int hashCode() {
            long jDoubleToLongBits = Double.doubleToLongBits(this.bearing);
            int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31;
            LatLng latLng = this.target;
            int iHashCode = latLng != null ? latLng.hashCode() : 0;
            long jDoubleToLongBits2 = Double.doubleToLongBits(this.tilt);
            int i2 = ((i + iHashCode) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
            long jDoubleToLongBits3 = Double.doubleToLongBits(this.zoom);
            return (((i2 * 31) + ((int) ((jDoubleToLongBits3 >>> 32) ^ jDoubleToLongBits3))) * 31) + Arrays.hashCode(this.padding);
        }

        public String toString() {
            return "CameraPositionUpdate{bearing=" + this.bearing + ", target=" + this.target + ", tilt=" + this.tilt + ", zoom=" + this.zoom + ", padding=" + Arrays.toString(this.padding) + '}';
        }
    }

    static final class CameraBoundsUpdate implements CameraUpdate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Double bearing;
        private final LatLngBounds bounds;
        private final int[] padding;
        private final Double tilt;

        CameraBoundsUpdate(LatLngBounds latLngBounds, Double d, Double d2, int[] iArr) {
            this.bounds = latLngBounds;
            this.padding = iArr;
            this.bearing = d;
            this.tilt = d2;
        }

        CameraBoundsUpdate(LatLngBounds latLngBounds, Double d, Double d2, int i, int i2, int i3, int i4) {
            this(latLngBounds, d, d2, new int[]{i, i2, i3, i4});
        }

        public LatLngBounds getBounds() {
            return this.bounds;
        }

        public int[] getPadding() {
            return this.padding;
        }

        @Override // com.mappls.sdk.maps.camera.CameraUpdate
        public CameraPosition getCameraPosition(MapplsMap mapplsMap) {
            Double d = this.bearing;
            if (d == null && this.tilt == null) {
                return mapplsMap.getCameraForLatLngBounds(this.bounds, this.padding);
            }
            return mapplsMap.getCameraForLatLngBounds(this.bounds, this.padding, d.doubleValue(), this.tilt.doubleValue());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CameraBoundsUpdate cameraBoundsUpdate = (CameraBoundsUpdate) obj;
            if (this.bounds.equals(cameraBoundsUpdate.bounds)) {
                return Arrays.equals(this.padding, cameraBoundsUpdate.padding);
            }
            return false;
        }

        public int hashCode() {
            return (this.bounds.hashCode() * 31) + Arrays.hashCode(this.padding);
        }

        public String toString() {
            return "CameraBoundsUpdate{bounds=" + this.bounds + ", padding=" + Arrays.toString(this.padding) + '}';
        }
    }

    static final class CameraMoveUpdate implements CameraUpdate {
        private float x;
        private float y;

        CameraMoveUpdate(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        @Override // com.mappls.sdk.maps.camera.CameraUpdate
        public CameraPosition getCameraPosition(MapplsMap mapplsMap) {
            UiSettings uiSettings = mapplsMap.getUiSettings();
            Projection projection = mapplsMap.getProjection();
            float width = uiSettings.getWidth();
            float height = uiSettings.getHeight();
            int[] padding = mapplsMap.getPadding();
            float f = width - padding[0];
            int i = padding[1];
            LatLng latLngFromScreenLocation = projection.fromScreenLocation(new PointF(((f + i) / 2.0f) + this.x, (((height + i) - padding[3]) / 2.0f) + this.y));
            CameraPosition cameraPosition = mapplsMap.getCameraPosition();
            return new CameraPosition.Builder().target(latLngFromScreenLocation).zoom(cameraPosition.zoom).tilt(cameraPosition.tilt).bearing(cameraPosition.bearing).build();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CameraMoveUpdate cameraMoveUpdate = (CameraMoveUpdate) obj;
            return Float.compare(cameraMoveUpdate.x, this.x) == 0 && Float.compare(cameraMoveUpdate.y, this.y) == 0;
        }

        public int hashCode() {
            float f = this.x;
            int iFloatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.y;
            return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
        }

        public String toString() {
            return "CameraMoveUpdate{x=" + this.x + ", y=" + this.y + '}';
        }
    }

    static final class ZoomUpdate implements CameraUpdate {
        static final int ZOOM_BY = 2;
        static final int ZOOM_IN = 0;
        static final int ZOOM_OUT = 1;
        static final int ZOOM_TO = 3;
        static final int ZOOM_TO_POINT = 4;
        private final int type;
        private float x;
        private float y;
        private final double zoom;

        ZoomUpdate(int i) {
            this.type = i;
            this.zoom = 0.0d;
        }

        ZoomUpdate(int i, double d) {
            this.type = i;
            this.zoom = d;
        }

        ZoomUpdate(double d, float f, float f2) {
            this.type = 4;
            this.zoom = d;
            this.x = f;
            this.y = f2;
        }

        public double getZoom() {
            return this.zoom;
        }

        public int getType() {
            return this.type;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        double transformZoom(double d) {
            double zoom;
            int type = getType();
            if (type == 0) {
                return d + 1.0d;
            }
            if (type == 1) {
                double d2 = d - 1.0d;
                if (d2 < 0.0d) {
                    return 0.0d;
                }
                return d2;
            }
            if (type == 2) {
                zoom = getZoom();
            } else {
                if (type == 3) {
                    return getZoom();
                }
                if (type != 4) {
                    return d;
                }
                zoom = getZoom();
            }
            return d + zoom;
        }

        @Override // com.mappls.sdk.maps.camera.CameraUpdate
        public CameraPosition getCameraPosition(MapplsMap mapplsMap) {
            CameraPosition cameraPosition = mapplsMap.getCameraPosition();
            if (getType() != 4) {
                return new CameraPosition.Builder(cameraPosition).zoom(transformZoom(cameraPosition.zoom)).build();
            }
            return new CameraPosition.Builder(cameraPosition).zoom(transformZoom(cameraPosition.zoom)).target(mapplsMap.getProjection().fromScreenLocation(new PointF(getX(), getY()))).build();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ZoomUpdate zoomUpdate = (ZoomUpdate) obj;
            return this.type == zoomUpdate.type && Double.compare(zoomUpdate.zoom, this.zoom) == 0 && Float.compare(zoomUpdate.x, this.x) == 0 && Float.compare(zoomUpdate.y, this.y) == 0;
        }

        public int hashCode() {
            int i = this.type;
            long jDoubleToLongBits = Double.doubleToLongBits(this.zoom);
            int i2 = ((i * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31;
            float f = this.x;
            int iFloatToIntBits = (i2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.y;
            return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
        }

        public String toString() {
            return "ZoomUpdate{type=" + this.type + ", zoom=" + this.zoom + ", x=" + this.x + ", y=" + this.y + '}';
        }
    }
}
