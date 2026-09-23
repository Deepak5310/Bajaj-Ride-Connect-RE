package com.mappls.sdk.maps.camera;

import com.mappls.sdk.maps.CoordinateCallback;
import com.mappls.sdk.maps.CoordinateResult;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CameraMapplsPinUpdateFactory {
    public static CameraMapplsPinUpdate newCameraPosition(CameraMapplsPinPosition cameraMapplsPinPosition) {
        return new CameraMapplsPinPositionUpdate(cameraMapplsPinPosition.bearing, cameraMapplsPinPosition.target, cameraMapplsPinPosition.tilt, cameraMapplsPinPosition.zoom, cameraMapplsPinPosition.padding);
    }

    public static CameraMapplsPinUpdate newMapplsPin(String str) {
        return new CameraMapplsPinPositionUpdate(-1.0d, str, -1.0d, -1.0d, null);
    }

    public static CameraMapplsPinBoundUpdate newMapplsPinBounds(List<String> list, int i) {
        return newMapplsPinBounds(list, i, i, i, i);
    }

    public static CameraMapplsPinBoundUpdate newMapplsPinBounds(List<String> list, double d, double d2, int i) {
        return newMapplsPinBounds(list, d, d2, i, i, i, i);
    }

    public static CameraMapplsPinBoundUpdate newMapplsPinBounds(List<String> list, int i, int i2, int i3, int i4) {
        return new CameraMapplsPinBoundsUpdate(list, null, null, i, i2, i3, i4);
    }

    public static CameraMapplsPinBoundUpdate newMapplsPinBounds(List<String> list, double d, double d2, int i, int i2, int i3, int i4) {
        return new CameraMapplsPinBoundsUpdate(list, Double.valueOf(d), Double.valueOf(d2), i, i2, i3, i4);
    }

    public static CameraMapplsPinUpdate newMapplsPinZoom(String str, double d) {
        return new CameraMapplsPinPositionUpdate(-1.0d, str, -1.0d, d, null);
    }

    public static CameraMapplsPinUpdate newMapplsPinPadding(String str, double d, double d2, double d3, double d4) {
        return new CameraMapplsPinPositionUpdate(-1.0d, str, -1.0d, -1.0d, new double[]{d, d2, d3, d4});
    }

    static final class CameraMapplsPinPositionUpdate implements CameraMapplsPinUpdate {
        private final double bearing;
        private final double[] padding;
        private final String target;
        private final double tilt;
        private final double zoom;

        CameraMapplsPinPositionUpdate(double d, String str, double d2, double d3, double[] dArr) {
            this.bearing = d;
            this.target = str;
            this.tilt = d2;
            this.zoom = d3;
            this.padding = dArr;
        }

        public String getTarget() {
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

        @Override // com.mappls.sdk.maps.camera.CameraMapplsPinUpdate
        public CameraMapplsPinPosition getCameraMapplsPinPosition(MapplsMap mapplsMap) {
            return new CameraMapplsPinPosition.Builder(this).build();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CameraMapplsPinPositionUpdate cameraMapplsPinPositionUpdate = (CameraMapplsPinPositionUpdate) obj;
            if (Double.compare(cameraMapplsPinPositionUpdate.bearing, this.bearing) != 0 || Double.compare(cameraMapplsPinPositionUpdate.tilt, this.tilt) != 0 || Double.compare(cameraMapplsPinPositionUpdate.zoom, this.zoom) != 0) {
                return false;
            }
            String str = this.target;
            if (str == null ? cameraMapplsPinPositionUpdate.target == null : str.equals(cameraMapplsPinPositionUpdate.target)) {
                return Arrays.equals(this.padding, cameraMapplsPinPositionUpdate.padding);
            }
            return false;
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

        public String toString() {
            return "CameraMapplsPinPositionUpdate{bearing=" + this.bearing + ", target=" + this.target + ", tilt=" + this.tilt + ", zoom=" + this.zoom + ", padding=" + Arrays.toString(this.padding) + '}';
        }
    }

    static final class CameraMapplsPinBoundsUpdate implements CameraMapplsPinBoundUpdate {
        private final Double bearing;
        private final List<String> bounds;
        private final int[] padding;
        private final Double tilt;

        CameraMapplsPinBoundsUpdate(List<String> list, Double d, Double d2, int[] iArr) {
            this.bounds = list;
            this.padding = iArr;
            this.bearing = d;
            this.tilt = d2;
        }

        CameraMapplsPinBoundsUpdate(List<String> list, Double d, Double d2, int i, int i2, int i3, int i4) {
            this(list, d, d2, new int[]{i, i2, i3, i4});
        }

        public List<String> getBounds() {
            return this.bounds;
        }

        public int[] getPadding() {
            return this.padding;
        }

        @Override // com.mappls.sdk.maps.camera.CameraMapplsPinBoundUpdate
        public void getCameraMapplsPinPosition(MapplsMap mapplsMap, final CameraMapplsPinCallback cameraMapplsPinCallback) {
            try {
                Class<?> cls = Class.forName("com.mappls.sdk.maps.BaseMapplsHelper");
                Object objNewInstance = cls.newInstance();
                Method declaredMethod = cls.getDeclaredMethod("getAnnotation", List.class, CoordinateCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(objNewInstance, this.bounds, new CoordinateCallback() { // from class: com.mappls.sdk.maps.camera.CameraMapplsPinUpdateFactory.CameraMapplsPinBoundsUpdate.1
                    static final /* synthetic */ boolean $assertionsDisabled = false;

                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void coordinateResultSuccess(List<CoordinateResult> list) {
                        if (list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (CoordinateResult coordinateResult : list) {
                                arrayList.add(new LatLng(coordinateResult.getLatitude().doubleValue(), coordinateResult.getLongitude().doubleValue()));
                            }
                            LatLngBounds latLngBoundsBuild = new LatLngBounds.Builder().includes(arrayList).build();
                            if (CameraMapplsPinBoundsUpdate.this.bearing == null && CameraMapplsPinBoundsUpdate.this.tilt == null) {
                                cameraMapplsPinCallback.getCameraUpdate(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, CameraMapplsPinBoundsUpdate.this.padding[0], CameraMapplsPinBoundsUpdate.this.padding[1], CameraMapplsPinBoundsUpdate.this.padding[2], CameraMapplsPinBoundsUpdate.this.padding[3]));
                                return;
                            } else {
                                cameraMapplsPinCallback.getCameraUpdate(CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, CameraMapplsPinBoundsUpdate.this.bearing.doubleValue(), CameraMapplsPinBoundsUpdate.this.tilt.doubleValue(), CameraMapplsPinBoundsUpdate.this.padding[0], CameraMapplsPinBoundsUpdate.this.padding[1], CameraMapplsPinBoundsUpdate.this.padding[2], CameraMapplsPinBoundsUpdate.this.padding[3]));
                                return;
                            }
                        }
                        cameraMapplsPinCallback.onError();
                    }

                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void onFailure() {
                        cameraMapplsPinCallback.onError();
                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CameraMapplsPinBoundsUpdate cameraMapplsPinBoundsUpdate = (CameraMapplsPinBoundsUpdate) obj;
            if (this.bounds.equals(cameraMapplsPinBoundsUpdate.bounds)) {
                return Arrays.equals(this.padding, cameraMapplsPinBoundsUpdate.padding);
            }
            return false;
        }

        public int hashCode() {
            return (this.bounds.hashCode() * 31) + Arrays.hashCode(this.padding);
        }

        public String toString() {
            return "CameraMapplsPinBoundsUpdate{bounds=" + this.bounds + ", padding=" + Arrays.toString(this.padding) + '}';
        }
    }
}
