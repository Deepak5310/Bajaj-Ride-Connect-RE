package com.mappls.sdk.maps;

import android.graphics.PointF;
import android.os.Handler;
import com.mappls.sdk.maps.camera.CameraMapplsPinPosition;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdate;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdate;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.log.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Transform implements MapView.OnCameraDidChangeListener {
    private static final String TAG = "Mbgl-Transform";
    private MapplsMap.CancelableCallback cameraCancelableCallback;
    private CameraChangeDispatcher cameraChangeDispatcher;
    private CameraPosition cameraPosition;
    private final Handler handler;
    private final MapView mapView;
    private final MapView.OnCameraDidChangeListener moveByChangeListener;
    private final NativeMap nativeMap;

    Transform(NativeMap nativeMap, CameraChangeDispatcher cameraChangeDispatcher) {
        this.handler = new Handler();
        this.moveByChangeListener = new MapView.OnCameraDidChangeListener() { // from class: com.mappls.sdk.maps.Transform.1
            @Override // com.mappls.sdk.maps.MapView.OnCameraDidChangeListener
            public void onCameraDidChange(boolean z) {
                if (z) {
                    Transform.this.cameraChangeDispatcher.onCameraIdle();
                    if (Transform.this.mapView != null) {
                        Transform.this.mapView.removeOnCameraDidChangeListener(this);
                    }
                }
            }
        };
        this.mapView = null;
        this.nativeMap = nativeMap;
        this.cameraChangeDispatcher = cameraChangeDispatcher;
    }

    Transform(MapView mapView, NativeMap nativeMap, CameraChangeDispatcher cameraChangeDispatcher) {
        this.handler = new Handler();
        this.moveByChangeListener = new MapView.OnCameraDidChangeListener() { // from class: com.mappls.sdk.maps.Transform.1
            @Override // com.mappls.sdk.maps.MapView.OnCameraDidChangeListener
            public void onCameraDidChange(boolean z) {
                if (z) {
                    Transform.this.cameraChangeDispatcher.onCameraIdle();
                    if (Transform.this.mapView != null) {
                        Transform.this.mapView.removeOnCameraDidChangeListener(this);
                    }
                }
            }
        };
        this.mapView = mapView;
        this.nativeMap = nativeMap;
        this.cameraChangeDispatcher = cameraChangeDispatcher;
    }

    void initialise(MapplsMap mapplsMap, MapplsMapOptions mapplsMapOptions) {
        CameraPosition camera = mapplsMapOptions.getCamera();
        if (camera != null && !camera.equals(CameraPosition.DEFAULT)) {
            moveCamera(mapplsMap, CameraUpdateFactory.newCameraPosition(camera), (MapplsMap.CancelableCallback) null);
        }
        setMinZoom(mapplsMapOptions.getMinZoomPreference());
        setMaxZoom(mapplsMapOptions.getMaxZoomPreference());
        setMinPitch(mapplsMapOptions.getMinPitchPreference());
        setMaxPitch(mapplsMapOptions.getMaxPitchPreference());
    }

    public final CameraPosition getCameraPosition() {
        if (this.cameraPosition == null) {
            this.cameraPosition = invalidateCameraPosition();
        }
        return this.cameraPosition;
    }

    @Override // com.mappls.sdk.maps.MapView.OnCameraDidChangeListener
    public void onCameraDidChange(boolean z) {
        if (z) {
            invalidateCameraPosition();
            final MapplsMap.CancelableCallback cancelableCallback = this.cameraCancelableCallback;
            if (cancelableCallback != null) {
                this.cameraCancelableCallback = null;
                this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.Transform.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cancelableCallback.onFinish();
                    }
                });
            }
            this.cameraChangeDispatcher.onCameraIdle();
            MapView mapView = this.mapView;
            if (mapView != null) {
                mapView.removeOnCameraDidChangeListener(this);
            }
        }
    }

    public final void moveCamera(MapplsMap mapplsMap, CameraUpdate cameraUpdate, final MapplsMap.CancelableCallback cancelableCallback) {
        CameraPosition cameraPosition = cameraUpdate.getCameraPosition(mapplsMap);
        if (!isValidCameraPosition(cameraPosition)) {
            if (cancelableCallback != null) {
                cancelableCallback.onFinish();
            }
        } else {
            cancelTransitions();
            this.cameraChangeDispatcher.onCameraMoveStarted(3);
            this.nativeMap.jumpTo(cameraPosition.target, cameraPosition.zoom, cameraPosition.tilt, cameraPosition.bearing, cameraPosition.padding);
            invalidateCameraPosition();
            this.cameraChangeDispatcher.onCameraIdle();
            this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.Transform.3
                @Override // java.lang.Runnable
                public void run() {
                    MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onFinish();
                    }
                }
            });
        }
    }

    public final void moveCamera(MapplsMap mapplsMap, CameraMapplsPinUpdate cameraMapplsPinUpdate, final MapplsMap.CancelableCallback cancelableCallback) {
        final CameraMapplsPinPosition cameraMapplsPinPosition = cameraMapplsPinUpdate.getCameraMapplsPinPosition(mapplsMap);
        if (isValidCameraMapplsPinPosition(cameraMapplsPinPosition)) {
            MapplsPinHelper.getInstance().getAnnotation(cameraMapplsPinPosition.target, new CoordinateCallback() { // from class: com.mappls.sdk.maps.Transform.4
                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void coordinateResultSuccess(List<CoordinateResult> list) {
                    if (list.size() > 0) {
                        LatLng latLng = new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue());
                        Transform.this.cancelTransitions();
                        Transform.this.cameraChangeDispatcher.onCameraMoveStarted(3);
                        Transform.this.nativeMap.jumpTo(latLng, cameraMapplsPinPosition.zoom, cameraMapplsPinPosition.tilt, cameraMapplsPinPosition.bearing, cameraMapplsPinPosition.padding);
                        Transform.this.invalidateCameraPosition();
                        Transform.this.cameraChangeDispatcher.onCameraIdle();
                        Transform.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.Transform.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (cancelableCallback != null) {
                                    cancelableCallback.onFinish();
                                }
                            }
                        });
                        return;
                    }
                    MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onFinish();
                    }
                }

                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void onFailure() {
                    MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onFinish();
                    }
                }
            });
        } else if (cancelableCallback != null) {
            cancelableCallback.onFinish();
        }
    }

    final void easeCamera(MapplsMap mapplsMap, CameraUpdate cameraUpdate, int i, boolean z, MapplsMap.CancelableCallback cancelableCallback) {
        CameraPosition cameraPosition = cameraUpdate.getCameraPosition(mapplsMap);
        if (!isValidCameraPosition(cameraPosition)) {
            if (cancelableCallback != null) {
                cancelableCallback.onFinish();
                return;
            }
            return;
        }
        cancelTransitions();
        this.cameraChangeDispatcher.onCameraMoveStarted(3);
        if (cancelableCallback != null) {
            this.cameraCancelableCallback = cancelableCallback;
        }
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.addOnCameraDidChangeListener(this);
        }
        this.nativeMap.easeTo(cameraPosition.target, cameraPosition.zoom, cameraPosition.bearing, cameraPosition.tilt, cameraPosition.padding, i, z);
    }

    final void easeCamera(MapplsMap mapplsMap, CameraMapplsPinUpdate cameraMapplsPinUpdate, final int i, final boolean z, final MapplsMap.CancelableCallback cancelableCallback) {
        final CameraMapplsPinPosition cameraMapplsPinPosition = cameraMapplsPinUpdate.getCameraMapplsPinPosition(mapplsMap);
        if (isValidCameraMapplsPinPosition(cameraMapplsPinPosition)) {
            MapplsPinHelper.getInstance().getAnnotation(cameraMapplsPinPosition.target, new CoordinateCallback() { // from class: com.mappls.sdk.maps.Transform.5
                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void coordinateResultSuccess(List<CoordinateResult> list) {
                    if (list.size() > 0) {
                        LatLng latLng = new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue());
                        Transform.this.cancelTransitions();
                        Transform.this.cameraChangeDispatcher.onCameraMoveStarted(3);
                        MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                        if (cancelableCallback2 != null) {
                            Transform.this.cameraCancelableCallback = cancelableCallback2;
                        }
                        if (Transform.this.mapView != null) {
                            Transform.this.mapView.addOnCameraDidChangeListener(Transform.this);
                        }
                        Transform.this.nativeMap.easeTo(latLng, cameraMapplsPinPosition.zoom, cameraMapplsPinPosition.bearing, cameraMapplsPinPosition.tilt, cameraMapplsPinPosition.padding, i, z);
                        return;
                    }
                    MapplsMap.CancelableCallback cancelableCallback3 = cancelableCallback;
                    if (cancelableCallback3 != null) {
                        cancelableCallback3.onFinish();
                    }
                }

                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void onFailure() {
                    MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onFinish();
                    }
                }
            });
        } else if (cancelableCallback != null) {
            cancelableCallback.onFinish();
        }
    }

    public final void animateCamera(MapplsMap mapplsMap, CameraUpdate cameraUpdate, int i, MapplsMap.CancelableCallback cancelableCallback) {
        CameraPosition cameraPosition = cameraUpdate.getCameraPosition(mapplsMap);
        if (!isValidCameraPosition(cameraPosition)) {
            if (cancelableCallback != null) {
                cancelableCallback.onFinish();
                return;
            }
            return;
        }
        cancelTransitions();
        this.cameraChangeDispatcher.onCameraMoveStarted(3);
        if (cancelableCallback != null) {
            this.cameraCancelableCallback = cancelableCallback;
        }
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.addOnCameraDidChangeListener(this);
        }
        this.nativeMap.flyTo(cameraPosition.target, cameraPosition.zoom, cameraPosition.bearing, cameraPosition.tilt, cameraPosition.padding, i);
    }

    public final void animateCamera(MapplsMap mapplsMap, CameraMapplsPinUpdate cameraMapplsPinUpdate, final int i, final MapplsMap.CancelableCallback cancelableCallback) {
        final CameraMapplsPinPosition cameraMapplsPinPosition = cameraMapplsPinUpdate.getCameraMapplsPinPosition(mapplsMap);
        if (isValidCameraMapplsPinPosition(cameraMapplsPinPosition)) {
            MapplsPinHelper.getInstance().getAnnotation(cameraMapplsPinPosition.target, new CoordinateCallback() { // from class: com.mappls.sdk.maps.Transform.6
                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void coordinateResultSuccess(List<CoordinateResult> list) {
                    if (list.size() > 0) {
                        LatLng latLng = new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue());
                        Transform.this.cancelTransitions();
                        Transform.this.cameraChangeDispatcher.onCameraMoveStarted(3);
                        MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                        if (cancelableCallback2 != null) {
                            Transform.this.cameraCancelableCallback = cancelableCallback2;
                        }
                        if (Transform.this.mapView != null) {
                            Transform.this.mapView.addOnCameraDidChangeListener(Transform.this);
                        }
                        Transform.this.nativeMap.flyTo(latLng, cameraMapplsPinPosition.zoom, cameraMapplsPinPosition.bearing, cameraMapplsPinPosition.tilt, cameraMapplsPinPosition.padding, i);
                        return;
                    }
                    MapplsMap.CancelableCallback cancelableCallback3 = cancelableCallback;
                    if (cancelableCallback3 != null) {
                        cancelableCallback3.onFinish();
                    }
                }

                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void onFailure() {
                    MapplsMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onFinish();
                    }
                }
            });
        } else if (cancelableCallback != null) {
            cancelableCallback.onFinish();
        }
    }

    private boolean isValidCameraPosition(CameraPosition cameraPosition) {
        return (cameraPosition == null || cameraPosition.equals(this.cameraPosition)) ? false : true;
    }

    private boolean isValidCameraMapplsPinPosition(CameraMapplsPinPosition cameraMapplsPinPosition) {
        return (cameraMapplsPinPosition == null || cameraMapplsPinPosition.equals(this.cameraPosition)) ? false : true;
    }

    CameraPosition invalidateCameraPosition() {
        NativeMap nativeMap = this.nativeMap;
        if (nativeMap != null) {
            CameraPosition cameraPosition = nativeMap.getCameraPosition();
            CameraPosition cameraPosition2 = this.cameraPosition;
            if (cameraPosition2 != null && !cameraPosition2.equals(cameraPosition)) {
                this.cameraChangeDispatcher.onCameraMove();
            }
            this.cameraPosition = cameraPosition;
        }
        return this.cameraPosition;
    }

    void cancelTransitions() {
        this.cameraChangeDispatcher.onCameraMoveCanceled();
        final MapplsMap.CancelableCallback cancelableCallback = this.cameraCancelableCallback;
        if (cancelableCallback != null) {
            this.cameraChangeDispatcher.onCameraIdle();
            this.cameraCancelableCallback = null;
            this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.Transform.7
                @Override // java.lang.Runnable
                public void run() {
                    cancelableCallback.onCancel();
                }
            });
        }
        this.nativeMap.cancelTransitions();
        this.cameraChangeDispatcher.onCameraIdle();
    }

    void resetNorth() {
        cancelTransitions();
        this.nativeMap.resetNorth();
    }

    double getRawZoom() {
        return this.nativeMap.getZoom();
    }

    void zoomBy(double d, PointF pointF) {
        setZoom(this.nativeMap.getZoom() + d, pointF);
    }

    void setZoom(double d, PointF pointF) {
        this.nativeMap.setZoom(d, pointF, 0L);
    }

    double getBearing() {
        double d = -this.nativeMap.getBearing();
        while (d > 360.0d) {
            d -= 360.0d;
        }
        while (d < 0.0d) {
            d += 360.0d;
        }
        return d;
    }

    double getRawBearing() {
        return this.nativeMap.getBearing();
    }

    void setBearing(double d) {
        this.nativeMap.setBearing(d, 0L);
    }

    void setBearing(double d, float f, float f2) {
        this.nativeMap.setBearing(d, f, f2, 0L);
    }

    void setBearing(double d, float f, float f2, long j) {
        this.nativeMap.setBearing(d, f, f2, j);
    }

    LatLng getLatLng() {
        return this.nativeMap.getLatLng();
    }

    double getTilt() {
        return this.nativeMap.getPitch();
    }

    void setTilt(Double d) {
        this.nativeMap.setPitch(d.doubleValue(), 0L);
    }

    LatLng getCenterCoordinate() {
        return this.nativeMap.getLatLng();
    }

    void setCenterCoordinate(LatLng latLng) {
        this.nativeMap.setLatLng(latLng, 0L);
    }

    void setGestureInProgress(boolean z) {
        this.nativeMap.setGestureInProgress(z);
        if (z) {
            return;
        }
        invalidateCameraPosition();
    }

    void moveBy(double d, double d2, long j) {
        MapView mapView;
        if (j > 0 && (mapView = this.mapView) != null) {
            mapView.addOnCameraDidChangeListener(this.moveByChangeListener);
        }
        this.nativeMap.moveBy(d, d2, j);
    }

    void setMinZoom(double d) {
        if (d < 1.0d || d > 22.0d) {
            Logger.e(TAG, String.format("Not setting minZoomPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMinZoom(d);
        }
    }

    double getMinZoom() {
        return this.nativeMap.getMinZoom();
    }

    void setMaxZoom(double d) {
        if (d < 1.0d || d > 22.0d) {
            Logger.e(TAG, String.format("Not setting maxZoomPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMaxZoom(d);
        }
    }

    double getMaxZoom() {
        return this.nativeMap.getMaxZoom();
    }

    void setMinPitch(double d) {
        if (d < 0.0d || d > 60.0d) {
            Logger.e(TAG, String.format("Not setting minPitchPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMinPitch(d);
        }
    }

    double getMinPitch() {
        return this.nativeMap.getMinPitch();
    }

    void setMaxPitch(double d) {
        if (d < 0.0d || d > 60.0d) {
            Logger.e(TAG, String.format("Not setting maxPitchPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMaxPitch(d);
        }
    }

    double getMaxPitch() {
        return this.nativeMap.getMaxPitch();
    }
}
