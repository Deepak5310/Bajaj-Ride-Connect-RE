package com.mappls.sdk.maps.rctmgl.components.camera;

import android.content.Context;
import android.location.Location;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdate;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.geometry.VisibleRegion;
import com.mappls.sdk.maps.location.OnCameraTrackingChangedListener;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.location.LocationComponentManager;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.events.MapChangeEvent;
import com.mappls.sdk.maps.rctmgl.events.MapUserTrackingModeEvent;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.rctmgl.location.LocationManager;
import com.mappls.sdk.maps.rctmgl.location.UserLocation;
import com.mappls.sdk.maps.rctmgl.location.UserTrackingMode;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import com.mappls.sdk.navigation.util.SavingTrackHelper;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLCamera extends AbstractMapFeature {
    public static final int USER_LOCATION_CAMERA_MOVE_DURATION = 1000;
    static final double defaultZoomLevelForUserTracking = 14.0d;
    static final double minimumZoomLevelForUserTracking = 10.5d;
    private boolean hasSentFirstRegion;
    private boolean mAnimated;
    private MapplsMap.CancelableCallback mCameraCallback;
    private CameraStop mCameraStop;
    private CameraUpdateQueue mCameraUpdateQueue;
    private Point mCenterCoordinate;
    private Context mContext;
    private CameraStop mDefaultStop;
    private boolean mFollowUserLocation;
    private String mFollowUserMode;
    private double mHeading;
    private LocationManager.OnUserLocationChange mLocationChangeListener;
    private LocationComponentManager mLocationComponentManager;
    private LocationManager mLocationManager;
    private RCTMGLCameraManager mManager;
    private RCTMGLMapView mMapView;
    private LatLngBounds mMaxBounds;
    private double mMaxZoomLevel;
    private double mMinZoomLevel;
    private double mPitch;
    private UserLocation mUserLocation;
    private int mUserLocationVerticalAlignment;
    private int mUserTrackingMode;
    private int mUserTrackingState;
    private double mZoomLevel;

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void removeFromMap(RCTMGLMapView rCTMGLMapView) {
    }

    public RCTMGLCamera(Context context, RCTMGLCameraManager rCTMGLCameraManager) {
        super(context);
        this.hasSentFirstRegion = false;
        this.mUserTrackingState = 0;
        this.mUserLocationVerticalAlignment = 0;
        this.mZoomLevel = -1.0d;
        this.mMinZoomLevel = -1.0d;
        this.mMaxZoomLevel = -1.0d;
        this.mLocationChangeListener = new LocationManager.OnUserLocationChange() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera.1
            @Override // com.mappls.sdk.maps.rctmgl.location.LocationManager.OnUserLocationChange
            public void onLocationChange(Location location) {
                if (RCTMGLCamera.this.getMapplsMap() == null || RCTMGLCamera.this.mLocationComponentManager == null || !RCTMGLCamera.this.mLocationComponentManager.hasLocationComponent() || !RCTMGLCamera.this.mFollowUserLocation) {
                    return;
                }
                RCTMGLCamera.this.mUserLocation.setCurrentLocation(location);
                RCTMGLCamera.this.sendUserLocationUpdateEvent(location);
            }
        };
        this.mCameraCallback = new MapplsMap.CancelableCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera.2
            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onCancel() {
                if (RCTMGLCamera.this.hasSentFirstRegion) {
                    return;
                }
                RCTMGLCamera.this.mMapView.sendRegionChangeEvent(false);
                RCTMGLCamera.this.hasSentFirstRegion = true;
            }

            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onFinish() {
                if (RCTMGLCamera.this.hasSentFirstRegion) {
                    return;
                }
                RCTMGLCamera.this.mMapView.sendRegionChangeEvent(false);
                RCTMGLCamera.this.hasSentFirstRegion = true;
            }
        };
        this.mContext = context;
        this.mManager = rCTMGLCameraManager;
        this.mCameraUpdateQueue = new CameraUpdateQueue();
        this.mUserLocation = new UserLocation();
        this.mLocationManager = LocationManager.getInstance(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        this.mMapView = rCTMGLMapView;
        setInitialCamera();
        updateMaxMinZoomLevel();
        updateMaxBounds();
        if (this.mCameraStop != null) {
            updateCamera();
        }
        if (this.mFollowUserLocation) {
            enableLocation();
        }
    }

    public void setStop(CameraStop cameraStop) {
        this.mCameraStop = cameraStop;
        cameraStop.setCallback(this.mCameraCallback);
        if (this.mMapView != null) {
            updateCamera();
        }
    }

    public void setDefaultStop(CameraStop cameraStop) {
        this.mDefaultStop = cameraStop;
    }

    public void setFollowPitch(double d) {
        this.mPitch = d;
        updateCameraPositionIfNeeded(true);
    }

    public void setMaxBounds(LatLngBounds latLngBounds) {
        this.mMaxBounds = latLngBounds;
        updateMaxBounds();
    }

    private void updateMaxBounds() {
        LatLngBounds latLngBounds;
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap == null || (latLngBounds = this.mMaxBounds) == null) {
            return;
        }
        mapplsMap.setLatLngBoundsForCameraTarget(latLngBounds);
    }

    private void updateMaxMinZoomLevel() {
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            double d = this.mMinZoomLevel;
            if (d >= 0.0d) {
                mapplsMap.setMinZoomPreference(d);
            }
            double d2 = this.mMaxZoomLevel;
            if (d2 >= 0.0d) {
                mapplsMap.setMaxZoomPreference(d2);
            }
        }
    }

    private void setInitialCamera() {
        CameraStop cameraStop = this.mDefaultStop;
        if (cameraStop != null) {
            cameraStop.setDuration(0);
            this.mDefaultStop.setMode(4);
            if (this.mDefaultStop.isMapplsPinStrategyEnabled()) {
                this.mDefaultStop.toCameraMapplsPinUpdate(this.mMapView).run();
            } else {
                this.mDefaultStop.toCameraUpdate(this.mMapView).run();
            }
        }
    }

    private void updateCamera() {
        this.mCameraUpdateQueue.offer(this.mCameraStop);
        this.mCameraUpdateQueue.execute(this.mMapView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUserTrackingMode(int i) {
        this.mUserLocation.setTrackingMode(i);
        this.mManager.handleEvent(new MapUserTrackingModeEvent(this, i));
    }

    private void updateUserLocation(boolean z) {
        if (!this.mFollowUserLocation || this.mUserLocation.getTrackingMode() == 0) {
            return;
        }
        int i = this.mUserTrackingState;
        if (i == 0) {
            updateUserLocationSignificantly(z);
        } else if (i == 3) {
            updateUserLocationIncrementally(z);
        }
    }

    private CameraPosition getUserLocationUpdateCameraPosition(double d) {
        LatLng latLng;
        LatLng coordinate = this.mUserLocation.getCoordinate();
        if (this.mUserLocationVerticalAlignment != 0) {
            VisibleRegion visibleRegion = this.mMapView.getVisibleRegion(coordinate, d);
            int i = this.mUserLocationVerticalAlignment;
            if (i == 1) {
                latLng = new LatLng(visibleRegion.nearRight.getLatitude(), coordinate.getLongitude());
            } else if (i == 2) {
                latLng = new LatLng(visibleRegion.farLeft.getLatitude(), coordinate.getLongitude());
            }
            coordinate = latLng;
        }
        return new CameraPosition.Builder().target(coordinate).bearing(getDirectionForUserLocationUpdate()).tilt(this.mPitch).zoom(d).build();
    }

    private double getDirectionForUserLocationUpdate() {
        double d = this.mMapView.getCameraPosition().bearing;
        int trackingMode = this.mUserLocation.getTrackingMode();
        if (trackingMode == 3 || trackingMode == 2) {
            return this.mUserLocation.getBearing();
        }
        double d2 = this.mHeading;
        return d2 != 0.0d ? d2 : d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserLocationUpdateEvent(Location location) {
        if (location == null) {
            return;
        }
        this.mManager.handleEvent(new MapChangeEvent(this, EventTypes.USER_LOCATION_UPDATED, makeLocationChangePayload(location)));
    }

    private boolean hasSetCenterCoordinate() {
        LatLng latLng = this.mMapView.getCameraPosition().target;
        return (latLng.getLatitude() == 0.0d || latLng.getLongitude() == 0.0d) ? false : true;
    }

    private void updateUserLocationSignificantly(boolean z) {
        this.mUserTrackingState = 1;
        double d = this.mZoomLevel;
        if (d < 0.0d) {
            d = this.mMapView.getMapplsMap().getCameraPosition().zoom;
            if (d < minimumZoomLevelForUserTracking) {
                d = defaultZoomLevelForUserTracking;
            }
        }
        CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(getUserLocationUpdateCameraPosition(d));
        MapplsMap.CancelableCallback cancelableCallback = new MapplsMap.CancelableCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera.3
            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onCancel() {
                RCTMGLCamera.this.mUserTrackingState = 3;
            }

            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onFinish() {
                RCTMGLCamera.this.mUserTrackingState = 3;
            }
        };
        if (z && hasSetCenterCoordinate()) {
            this.mMapView.animateCamera(cameraUpdateNewCameraPosition, cancelableCallback);
        } else {
            this.mMapView.moveCamera(cameraUpdateNewCameraPosition, cancelableCallback);
        }
    }

    private void updateUserLocationIncrementally(boolean z) {
        this.mUserTrackingState = 1;
        CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(getUserLocationUpdateCameraPosition(this.mMapView.getCameraPosition().zoom));
        MapplsMap.CancelableCallback cancelableCallback = new MapplsMap.CancelableCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera.4
            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onCancel() {
                RCTMGLCamera.this.mUserTrackingState = 3;
            }

            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onFinish() {
                RCTMGLCamera.this.mUserTrackingState = 3;
            }
        };
        if (z) {
            this.mMapView.easeCamera(cameraUpdateNewCameraPosition, 1000, true, cancelableCallback);
        } else {
            this.mMapView.moveCamera(cameraUpdateNewCameraPosition, cancelableCallback);
        }
    }

    private void enableLocation() {
        if (PermissionsManager.areLocationPermissionsGranted(this.mContext)) {
            if (!this.mLocationManager.isActive()) {
                this.mLocationManager.enable();
            }
            this.mMapView.getMapplsMap().getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera.5
                @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
                public void onStyleLoaded(Style style) {
                    RCTMGLCamera.this.enableLocationComponent(style);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableLocationComponent(Style style) {
        updateUserLocation(false);
        updateLocationLayer(style);
        Location lastKnownLocation = this.mLocationManager.getLastKnownLocation();
        this.mLocationManager.addLocationListener(this.mLocationChangeListener);
        if (lastKnownLocation != null) {
            this.mLocationChangeListener.onLocationChange(lastKnownLocation);
            postDelayed(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera.6
                @Override // java.lang.Runnable
                public void run() {
                    RCTMGLCamera.this.mMapView.sendRegionDidChangeEvent();
                }
            }, 200L);
        }
    }

    private void updateLocationLayer(Style style) {
        if (this.mLocationComponentManager == null) {
            this.mLocationComponentManager = this.mMapView.getLocationComponentManager();
        }
        this.mLocationComponentManager.update(style);
        if (this.mFollowUserLocation) {
            this.mLocationComponentManager.setCameraMode(UserTrackingMode.getCameraMode(this.mUserTrackingMode));
        }
        this.mLocationComponentManager.setFollowUserLocation(this.mFollowUserLocation);
        if (this.mFollowUserLocation) {
            this.mLocationComponentManager.setCameraMode(UserTrackingMode.getCameraMode(this.mUserTrackingMode));
            this.mLocationComponentManager.addOnCameraTrackingChangedListener(new OnCameraTrackingChangedListener() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera.7
                @Override // com.mappls.sdk.maps.location.OnCameraTrackingChangedListener
                public void onCameraTrackingDismissed() {
                }

                @Override // com.mappls.sdk.maps.location.OnCameraTrackingChangedListener
                public void onCameraTrackingChanged(int i) {
                    int i2 = 0;
                    if (i != 8) {
                        if (i == 24) {
                            i2 = 1;
                        } else if (i == 32) {
                            i2 = 3;
                        } else if (i == 34) {
                            i2 = 2;
                        }
                    }
                    RCTMGLCamera.this.updateUserTrackingMode(i2);
                }
            });
        } else {
            this.mLocationComponentManager.setCameraMode(8);
        }
    }

    public void setMinZoomLevel(double d) {
        this.mMinZoomLevel = d;
        updateMaxMinZoomLevel();
    }

    public void setMaxZoomLevel(double d) {
        this.mMaxZoomLevel = d;
        updateMaxMinZoomLevel();
    }

    public void setZoomLevel(double d) {
        this.mZoomLevel = d;
        updateCameraPositionIfNeeded(false);
    }

    private CameraPosition buildCamera(CameraPosition cameraPosition, boolean z) {
        CameraPosition.Builder builderZoom = new CameraPosition.Builder(cameraPosition).bearing(this.mHeading).tilt(this.mPitch).zoom(this.mZoomLevel);
        if (z) {
            builderZoom.target(GeoJSONUtils.toLatLng(this.mCenterCoordinate));
        }
        return builderZoom.build();
    }

    private void updateCameraPositionIfNeeded(boolean z) {
        RCTMGLMapView rCTMGLMapView = this.mMapView;
        if (rCTMGLMapView != null) {
            CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(buildCamera(rCTMGLMapView.getCameraPosition(), z));
            if (this.mAnimated) {
                this.mMapView.easeCamera(cameraUpdateNewCameraPosition);
            } else {
                this.mMapView.moveCamera(cameraUpdateNewCameraPosition);
            }
        }
    }

    public void setUserTrackingMode(int i) {
        int i2 = this.mUserTrackingMode;
        this.mUserTrackingMode = i;
        updateUserTrackingMode(i);
        int i3 = this.mUserTrackingMode;
        if (i3 == 0) {
            this.mUserTrackingState = 0;
        } else if ((i3 == 1 || i3 == 2 || i3 == 3) && i2 == 0) {
            this.mUserTrackingState = 0;
        }
        if (getMapplsMap() != null) {
            updateLocationLayer(getMapplsMap().getStyle());
        }
    }

    public void setFollowUserLocation(boolean z) {
        this.mFollowUserLocation = z;
        updatedFollowUserMode();
    }

    public void setFollowUserMode(String str) {
        this.mFollowUserMode = str;
        updatedFollowUserMode();
    }

    private void updatedFollowUserMode() {
        if (this.mFollowUserLocation) {
            setUserTrackingMode(UserTrackingMode.fromString(this.mFollowUserMode));
        } else {
            setUserTrackingMode(0);
        }
    }

    MapplsMap getMapplsMap() {
        RCTMGLMapView rCTMGLMapView = this.mMapView;
        if (rCTMGLMapView == null) {
            return null;
        }
        return rCTMGLMapView.getMapplsMap();
    }

    private WritableMap makeLocationChangePayload(Location location) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("longitude", location.getLongitude());
        writableNativeMap2.putDouble("latitude", location.getLatitude());
        writableNativeMap2.putDouble(SavingTrackHelper.TRACK_COL_ALTITUDE, location.getAltitude());
        writableNativeMap2.putDouble("accuracy", location.getAccuracy());
        writableNativeMap2.putDouble("heading", location.getBearing());
        writableNativeMap2.putDouble("course", location.getBearing());
        writableNativeMap2.putDouble("speed", location.getSpeed());
        writableNativeMap.putMap("coords", writableNativeMap2);
        writableNativeMap.putDouble("timestamp", location.getTime());
        return writableNativeMap;
    }
}
