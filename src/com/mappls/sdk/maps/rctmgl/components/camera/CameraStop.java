package com.mappls.sdk.maps.rctmgl.components.camera;

import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.perf.util.Constants;
import com.henninghall.date_picker.props.ModeProp;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraMapplsPinPosition;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdateFactory;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CameraStop {
    private Double mBearing;
    private LatLngBounds mBounds;
    private MapplsMap.CancelableCallback mCallback;
    private LatLng mLatLng;
    private String mMapplsPin;
    private List<String> mMapplsPinList;
    private Double mTilt;
    private Double mZoom;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingBottom = 0;
    private int mPaddingTop = 0;
    private int mMode = 2;
    private int mDuration = Constants.MAX_URL_LENGTH;

    public void setBearing(double d) {
        this.mBearing = Double.valueOf(d);
    }

    public void setTilt(double d) {
        this.mTilt = Double.valueOf(d);
    }

    public void setZoom(double d) {
        this.mZoom = Double.valueOf(d);
    }

    public void setLatLng(LatLng latLng) {
        this.mLatLng = latLng;
    }

    public void setMapplsPin(String str) {
        this.mMapplsPin = str;
    }

    public void setMapplsPin(List<String> list, int i, int i2, int i3, int i4) {
        this.mMapplsPinList = list;
        this.mPaddingLeft = i;
        this.mPaddingRight = i2;
        this.mPaddingTop = i3;
        this.mPaddingBottom = i4;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setCallback(MapplsMap.CancelableCallback cancelableCallback) {
        this.mCallback = cancelableCallback;
    }

    public void setBounds(LatLngBounds latLngBounds) {
        this.mBounds = latLngBounds;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingRight = i2;
        this.mPaddingTop = i3;
        this.mPaddingBottom = i4;
    }

    public void setMode(int i) {
        this.mMode = i;
    }

    public CameraMapplsPinUpdateItem toCameraMapplsPinUpdate(RCTMGLMapView rCTMGLMapView) {
        MapplsMap mapplsMap = rCTMGLMapView.getMapplsMap();
        CameraPosition cameraPosition = mapplsMap.getCameraPosition();
        CameraMapplsPinPosition.Builder builder = new CameraMapplsPinPosition.Builder();
        double[] contentInset = rCTMGLMapView.getContentInset();
        int[] iArrClippedPadding = clippedPadding(new int[]{Double.valueOf(contentInset[0] + ((double) this.mPaddingLeft)).intValue(), Double.valueOf(contentInset[1] + ((double) this.mPaddingTop)).intValue(), Double.valueOf(contentInset[2] + ((double) this.mPaddingRight)).intValue(), Double.valueOf(contentInset[3] + ((double) this.mPaddingBottom)).intValue()}, rCTMGLMapView);
        Double d = this.mBearing;
        if (d != null) {
            builder.bearing(d.doubleValue());
        }
        Double d2 = this.mTilt;
        if (d2 != null) {
            builder.tilt(d2.doubleValue());
        }
        Double d3 = this.mZoom;
        if (d3 != null) {
            builder.zoom(d3.doubleValue());
        }
        String str = this.mMapplsPin;
        if (str != null) {
            builder.target(str);
            builder.padding(iArrClippedPadding[0], iArrClippedPadding[1], iArrClippedPadding[2], iArrClippedPadding[3]);
            return new CameraMapplsPinUpdateItem(mapplsMap, CameraMapplsPinUpdateFactory.newCameraPosition(builder.build()), this.mDuration, this.mCallback, this.mMode);
        }
        Double d4 = this.mTilt;
        double dDoubleValue = d4 != null ? d4.doubleValue() : cameraPosition.tilt;
        Double d5 = this.mBearing;
        return new CameraMapplsPinUpdateItem(mapplsMap, CameraMapplsPinUpdateFactory.newMapplsPinBounds(this.mMapplsPinList, d5 != null ? d5.doubleValue() : cameraPosition.bearing, dDoubleValue, iArrClippedPadding[0], iArrClippedPadding[1], iArrClippedPadding[2], iArrClippedPadding[3]), this.mDuration, this.mCallback, this.mMode);
    }

    public boolean isMapplsPinStrategyEnabled() {
        return (this.mMapplsPin == null && this.mMapplsPinList == null) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:26:0x00dd  */
    public CameraUpdateItem toCameraUpdate(RCTMGLMapView rCTMGLMapView) {
        CameraPosition.Builder builder;
        Double d;
        Double d2;
        Double d3;
        MapplsMap mapplsMap = rCTMGLMapView.getMapplsMap();
        CameraPosition cameraPosition = mapplsMap.getCameraPosition();
        CameraPosition.Builder builder2 = new CameraPosition.Builder(cameraPosition);
        double[] contentInset = rCTMGLMapView.getContentInset();
        boolean z = false;
        int[] iArrClippedPadding = clippedPadding(new int[]{Double.valueOf(contentInset[0] + ((double) this.mPaddingLeft)).intValue(), Double.valueOf(contentInset[1] + ((double) this.mPaddingTop)).intValue(), Double.valueOf(contentInset[2] + ((double) this.mPaddingRight)).intValue(), Double.valueOf(contentInset[3] + ((double) this.mPaddingBottom)).intValue()}, rCTMGLMapView);
        LatLng latLng = this.mLatLng;
        if (latLng != null) {
            builder2.target(latLng);
            builder2.padding(iArrClippedPadding[0], iArrClippedPadding[1], iArrClippedPadding[2], iArrClippedPadding[3]);
        } else {
            if (this.mBounds != null) {
                Double d4 = this.mTilt;
                double dDoubleValue = d4 != null ? d4.doubleValue() : cameraPosition.tilt;
                Double d5 = this.mBearing;
                builder = builder2;
                CameraPosition cameraForLatLngBounds = mapplsMap.getCameraForLatLngBounds(this.mBounds, iArrClippedPadding, d5 != null ? d5.doubleValue() : cameraPosition.bearing, dDoubleValue);
                if (cameraForLatLngBounds != null) {
                    builder.target(cameraForLatLngBounds.target);
                    builder.zoom(cameraForLatLngBounds.zoom);
                    builder.padding(cameraForLatLngBounds.padding);
                    z = true;
                } else {
                    return new CameraUpdateItem(mapplsMap, CameraUpdateFactory.newLatLngBounds(this.mBounds, iArrClippedPadding[0], iArrClippedPadding[1], iArrClippedPadding[2], iArrClippedPadding[3]), this.mDuration, this.mCallback, this.mMode);
                }
            }
            d = this.mBearing;
            if (d != null) {
                builder.bearing(d.doubleValue());
            }
            d2 = this.mTilt;
            if (d2 != null) {
                builder.tilt(d2.doubleValue());
            }
            d3 = this.mZoom;
            if (d3 != null && !z) {
                builder.zoom(d3.doubleValue());
            }
            return new CameraUpdateItem(mapplsMap, CameraUpdateFactory.newCameraPosition(builder.build()), this.mDuration, this.mCallback, this.mMode);
        }
        builder = builder2;
        d = this.mBearing;
        if (d != null) {
            builder.bearing(d.doubleValue());
        }
        d2 = this.mTilt;
        if (d2 != null) {
            builder.tilt(d2.doubleValue());
        }
        d3 = this.mZoom;
        if (d3 != null) {
            builder.zoom(d3.doubleValue());
        }
        return new CameraUpdateItem(mapplsMap, CameraUpdateFactory.newCameraPosition(builder.build()), this.mDuration, this.mCallback, this.mMode);
    }

    public static CameraStop fromReadableMap(Context context, ReadableMap readableMap, MapplsMap.CancelableCallback cancelableCallback) {
        CameraStop cameraStop = new CameraStop();
        if (readableMap.hasKey("pitch")) {
            cameraStop.setTilt(readableMap.getDouble("pitch"));
        }
        if (readableMap.hasKey("heading")) {
            cameraStop.setBearing(readableMap.getDouble("heading"));
        }
        int paddingByKey = getPaddingByKey(readableMap, ViewProps.PADDING_TOP);
        int paddingByKey2 = getPaddingByKey(readableMap, ViewProps.PADDING_RIGHT);
        int paddingByKey3 = getPaddingByKey(readableMap, ViewProps.PADDING_BOTTOM);
        int paddingByKey4 = getPaddingByKey(readableMap, ViewProps.PADDING_LEFT);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        cameraStop.setPadding(Float.valueOf(paddingByKey4 * displayMetrics.scaledDensity).intValue(), Float.valueOf(paddingByKey2 * displayMetrics.scaledDensity).intValue(), Float.valueOf(paddingByKey * displayMetrics.scaledDensity).intValue(), Float.valueOf(paddingByKey3 * displayMetrics.scaledDensity).intValue());
        if (readableMap.hasKey("centerCoordinate")) {
            cameraStop.setLatLng(GeoJSONUtils.toLatLng(GeoJSONUtils.toPointGeometry(readableMap.getString("centerCoordinate"))));
        }
        if (readableMap.hasKey("zoom")) {
            cameraStop.setZoom(readableMap.getDouble("zoom"));
        }
        if (readableMap.hasKey("duration")) {
            cameraStop.setDuration(readableMap.getInt("duration"));
        }
        if (readableMap.hasKey("bounds")) {
            cameraStop.setBounds(GeoJSONUtils.toLatLngBounds(FeatureCollection.fromJson(readableMap.getString("bounds"))));
        }
        if (readableMap.hasKey("mapplsPinBounds")) {
            ReadableArray array = readableMap.getArray("mapplsPinBounds");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
            cameraStop.setMapplsPin(arrayList, 0, 0, 0, 0);
        }
        if (readableMap.hasKey("centerMapplsPin")) {
            cameraStop.setMapplsPin(readableMap.getString("centerMapplsPin"));
        }
        if (readableMap.hasKey(ModeProp.name)) {
            int i2 = readableMap.getInt(ModeProp.name);
            if (i2 == 1) {
                cameraStop.setMode(1);
            } else if (i2 == 3) {
                cameraStop.setMode(3);
            } else if (i2 == 4) {
                cameraStop.setMode(4);
            } else {
                cameraStop.setMode(2);
            }
        }
        cameraStop.setCallback(cancelableCallback);
        return cameraStop;
    }

    private static int[] clippedPadding(int[] iArr, RCTMGLMapView rCTMGLMapView) {
        int height = rCTMGLMapView.getHeight();
        int width = rCTMGLMapView.getWidth();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i2 + i4;
        if (i5 >= height) {
            double d = i5;
            double d2 = (d - ((double) height)) + 1.0d;
            double d3 = i2;
            i2 = (int) (d3 - ((d3 * d2) / d));
            double d4 = i4;
            i4 = (int) (d4 - ((d2 * d4) / d));
        }
        int i6 = i + i3;
        if (i6 >= width) {
            double d5 = i6;
            double d6 = (d5 - ((double) width)) + 1.0d;
            double d7 = i;
            i = (int) (d7 - ((d7 * d6) / d5));
            double d8 = i3;
            i3 = (int) (d8 - ((d6 * d8) / d5));
        }
        return new int[]{i, i2, i3, i4};
    }

    private static int getPaddingByKey(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getInt(str);
        }
        return 0;
    }
}
