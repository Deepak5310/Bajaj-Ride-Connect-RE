package com.mappls.sdk.maps.location;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.location.Location;
import android.view.MotionEvent;
import com.mappls.sdk.gestures.AndroidGesturesManager;
import com.mappls.sdk.gestures.MoveGestureDetector;
import com.mappls.sdk.gestures.RotateGestureDetector;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Transform;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdate;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class LocationCameraController {
    private int cameraMode;
    private final AndroidGesturesManager initialGesturesManager;
    private final OnCameraTrackingChangedListener internalCameraTrackingChangedListener;
    private final AndroidGesturesManager internalGesturesManager;
    private boolean isEnabled;
    private boolean isTransitioning;
    private LatLng lastLocation;
    private final MapplsMap mapplsMap;
    private final MoveGestureDetector moveGestureDetector;
    private final OnCameraMoveInvalidateListener onCameraMoveInvalidateListener;
    private LocationComponentOptions options;
    private final Transform transform;
    private final MapplsAnimator.AnimationsValueChangeListener<LatLng> latLngValueListener = new MapplsAnimator.AnimationsValueChangeListener<LatLng>() { // from class: com.mappls.sdk.maps.location.LocationCameraController.2
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(LatLng latLng) {
            LocationCameraController.this.setLatLng(latLng);
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> gpsBearingValueListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationCameraController.3
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            if (LocationCameraController.this.cameraMode == 36 && LocationCameraController.this.mapplsMap.getCameraPosition().bearing == 0.0d) {
                return;
            }
            LocationCameraController.this.setBearing(f.floatValue());
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> compassBearingValueListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationCameraController.4
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            if (LocationCameraController.this.cameraMode == 32 || LocationCameraController.this.cameraMode == 16) {
                LocationCameraController.this.setBearing(f.floatValue());
            }
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> zoomValueListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationCameraController.5
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationCameraController.this.setZoom(f.floatValue());
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> tiltValueListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationCameraController.6
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationCameraController.this.setTilt(f.floatValue());
        }
    };
    private MapplsMap.OnCameraMoveListener onCameraMoveListener = new MapplsMap.OnCameraMoveListener() { // from class: com.mappls.sdk.maps.location.LocationCameraController.7
        @Override // com.mappls.sdk.maps.MapplsMap.OnCameraMoveListener
        public void onCameraMove() {
            if (LocationCameraController.this.isLocationTracking() && LocationCameraController.this.lastLocation != null && LocationCameraController.this.options.trackingGesturesManagement()) {
                PointF screenLocation = LocationCameraController.this.mapplsMap.getProjection().toScreenLocation(LocationCameraController.this.lastLocation);
                if (LocationCameraController.this.mapplsMap.getUiSettings() != null) {
                    LocationCameraController.this.mapplsMap.getUiSettings().setFocalPoint(screenLocation);
                }
            }
        }
    };
    MapplsMap.OnMoveListener onMoveListener = new MapplsMap.OnMoveListener() { // from class: com.mappls.sdk.maps.location.LocationCameraController.8
        private boolean interrupt;

        @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
        public void onMoveBegin(MoveGestureDetector moveGestureDetector) {
            if (LocationCameraController.this.options.trackingGesturesManagement() && LocationCameraController.this.isLocationTracking()) {
                if (moveGestureDetector.getPointersCount() > 1) {
                    applyMultiFingerThresholdArea(moveGestureDetector);
                    applyMultiFingerMoveThreshold(moveGestureDetector);
                    return;
                } else {
                    applySingleFingerMoveThreshold(moveGestureDetector);
                    return;
                }
            }
            LocationCameraController.this.setCameraMode(8);
        }

        private void applyMultiFingerThresholdArea(MoveGestureDetector moveGestureDetector) {
            RectF moveThresholdRect = moveGestureDetector.getMoveThresholdRect();
            if (moveThresholdRect == null || moveThresholdRect.equals(LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea())) {
                if (moveThresholdRect != null || LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea() == null) {
                    return;
                }
                moveGestureDetector.setMoveThresholdRect(LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea());
                this.interrupt = true;
                return;
            }
            moveGestureDetector.setMoveThresholdRect(LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea());
            this.interrupt = true;
        }

        private void applyMultiFingerMoveThreshold(MoveGestureDetector moveGestureDetector) {
            if (moveGestureDetector.getMoveThreshold() != LocationCameraController.this.options.trackingMultiFingerMoveThreshold()) {
                moveGestureDetector.setMoveThreshold(LocationCameraController.this.options.trackingMultiFingerMoveThreshold());
                this.interrupt = true;
            }
        }

        private void applySingleFingerMoveThreshold(MoveGestureDetector moveGestureDetector) {
            if (moveGestureDetector.getMoveThreshold() != LocationCameraController.this.options.trackingInitialMoveThreshold()) {
                moveGestureDetector.setMoveThreshold(LocationCameraController.this.options.trackingInitialMoveThreshold());
                this.interrupt = true;
            }
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
        public void onMove(MoveGestureDetector moveGestureDetector) {
            if (!this.interrupt) {
                if (LocationCameraController.this.isLocationTracking() || LocationCameraController.this.isBearingTracking()) {
                    LocationCameraController.this.setCameraMode(8);
                    moveGestureDetector.interrupt();
                    return;
                }
                return;
            }
            moveGestureDetector.interrupt();
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
        public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
            if (LocationCameraController.this.options.trackingGesturesManagement() && !this.interrupt && LocationCameraController.this.isLocationTracking()) {
                moveGestureDetector.setMoveThreshold(LocationCameraController.this.options.trackingInitialMoveThreshold());
                moveGestureDetector.setMoveThresholdRect(null);
            }
            this.interrupt = false;
        }
    };
    private MapplsMap.OnRotateListener onRotateListener = new MapplsMap.OnRotateListener() { // from class: com.mappls.sdk.maps.location.LocationCameraController.9
        @Override // com.mappls.sdk.maps.MapplsMap.OnRotateListener
        public void onRotate(RotateGestureDetector rotateGestureDetector) {
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnRotateListener
        public void onRotateEnd(RotateGestureDetector rotateGestureDetector) {
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnRotateListener
        public void onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            if (LocationCameraController.this.isBearingTracking()) {
                LocationCameraController.this.setCameraMode(8);
            }
        }
    };
    private MapplsMap.OnFlingListener onFlingListener = new MapplsMap.OnFlingListener() { // from class: com.mappls.sdk.maps.location.LocationCameraController.10
        @Override // com.mappls.sdk.maps.MapplsMap.OnFlingListener
        public void onFling() {
            LocationCameraController.this.setCameraMode(8);
        }
    };

    LocationCameraController(Context context, MapplsMap mapplsMap, Transform transform, OnCameraTrackingChangedListener onCameraTrackingChangedListener, LocationComponentOptions locationComponentOptions, OnCameraMoveInvalidateListener onCameraMoveInvalidateListener) {
        this.mapplsMap = mapplsMap;
        this.transform = transform;
        this.initialGesturesManager = mapplsMap.getGesturesManager();
        LocationGesturesManager locationGesturesManager = new LocationGesturesManager(context);
        this.internalGesturesManager = locationGesturesManager;
        this.moveGestureDetector = locationGesturesManager.getMoveGestureDetector();
        mapplsMap.addOnRotateListener(this.onRotateListener);
        mapplsMap.addOnFlingListener(this.onFlingListener);
        mapplsMap.addOnMoveListener(this.onMoveListener);
        mapplsMap.addOnCameraMoveListener(this.onCameraMoveListener);
        this.internalCameraTrackingChangedListener = onCameraTrackingChangedListener;
        this.onCameraMoveInvalidateListener = onCameraMoveInvalidateListener;
        initializeOptions(locationComponentOptions);
    }

    LocationCameraController(MapplsMap mapplsMap, Transform transform, MoveGestureDetector moveGestureDetector, OnCameraTrackingChangedListener onCameraTrackingChangedListener, OnCameraMoveInvalidateListener onCameraMoveInvalidateListener, AndroidGesturesManager androidGesturesManager, AndroidGesturesManager androidGesturesManager2) {
        this.mapplsMap = mapplsMap;
        mapplsMap.addOnCameraMoveListener(this.onCameraMoveListener);
        this.transform = transform;
        this.moveGestureDetector = moveGestureDetector;
        this.internalCameraTrackingChangedListener = onCameraTrackingChangedListener;
        this.onCameraMoveInvalidateListener = onCameraMoveInvalidateListener;
        this.internalGesturesManager = androidGesturesManager2;
        this.initialGesturesManager = androidGesturesManager;
    }

    void initializeOptions(LocationComponentOptions locationComponentOptions) {
        this.options = locationComponentOptions;
        if (locationComponentOptions.trackingGesturesManagement()) {
            AndroidGesturesManager gesturesManager = this.mapplsMap.getGesturesManager();
            AndroidGesturesManager androidGesturesManager = this.internalGesturesManager;
            if (gesturesManager != androidGesturesManager) {
                this.mapplsMap.setGesturesManager(androidGesturesManager, true, true);
            }
            adjustGesturesThresholds();
            return;
        }
        AndroidGesturesManager gesturesManager2 = this.mapplsMap.getGesturesManager();
        AndroidGesturesManager androidGesturesManager2 = this.initialGesturesManager;
        if (gesturesManager2 != androidGesturesManager2) {
            this.mapplsMap.setGesturesManager(androidGesturesManager2, true, true);
        }
    }

    void setCameraMode(int i) {
        setCameraMode(i, null, 750L, null, null, null, null);
    }

    void setCameraMode(int i, Location location, long j, Double d, Double d2, Double d3, OnLocationCameraTransitionListener onLocationCameraTransitionListener) {
        if (this.cameraMode == i) {
            if (onLocationCameraTransitionListener != null) {
                onLocationCameraTransitionListener.onLocationCameraTransitionFinished(i);
                return;
            }
            return;
        }
        boolean zIsLocationTracking = isLocationTracking();
        this.cameraMode = i;
        if (i != 8) {
            this.mapplsMap.cancelTransitions();
        }
        adjustGesturesThresholds();
        notifyCameraTrackingChangeListener(zIsLocationTracking);
        transitionToCurrentLocation(zIsLocationTracking, location, j, d, d2, d3, onLocationCameraTransitionListener);
    }

    private void transitionToCurrentLocation(boolean z, Location location, long j, Double d, Double d2, Double d3, final OnLocationCameraTransitionListener onLocationCameraTransitionListener) {
        if (z || !isLocationTracking() || location == null || !this.isEnabled) {
            if (onLocationCameraTransitionListener != null) {
                onLocationCameraTransitionListener.onLocationCameraTransitionFinished(this.cameraMode);
                return;
            }
            return;
        }
        this.isTransitioning = true;
        LatLng latLng = new LatLng(location);
        CameraPosition.Builder builderTarget = new CameraPosition.Builder().target(latLng);
        if (d != null) {
            builderTarget.zoom(d.doubleValue());
        }
        if (d3 != null) {
            builderTarget.tilt(d3.doubleValue());
        }
        if (d2 != null) {
            builderTarget.bearing(d2.doubleValue());
        } else if (isLocationBearingTracking()) {
            builderTarget.bearing(this.cameraMode == 36 ? 0.0d : location.getBearing());
        }
        CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(builderTarget.build());
        MapplsMap.CancelableCallback cancelableCallback = new MapplsMap.CancelableCallback() { // from class: com.mappls.sdk.maps.location.LocationCameraController.1
            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onCancel() {
                LocationCameraController.this.isTransitioning = false;
                OnLocationCameraTransitionListener onLocationCameraTransitionListener2 = onLocationCameraTransitionListener;
                if (onLocationCameraTransitionListener2 != null) {
                    onLocationCameraTransitionListener2.onLocationCameraTransitionCanceled(LocationCameraController.this.cameraMode);
                }
            }

            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onFinish() {
                LocationCameraController.this.isTransitioning = false;
                OnLocationCameraTransitionListener onLocationCameraTransitionListener2 = onLocationCameraTransitionListener;
                if (onLocationCameraTransitionListener2 != null) {
                    onLocationCameraTransitionListener2.onLocationCameraTransitionFinished(LocationCameraController.this.cameraMode);
                }
            }
        };
        if (Utils.immediateAnimation(this.mapplsMap.getProjection(), this.mapplsMap.getCameraPosition().target, latLng)) {
            this.transform.moveCamera(this.mapplsMap, cameraUpdateNewCameraPosition, cancelableCallback);
        } else {
            this.transform.animateCamera(this.mapplsMap, cameraUpdateNewCameraPosition, (int) j, cancelableCallback);
        }
    }

    int getCameraMode() {
        return this.cameraMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBearing(float f) {
        if (this.isTransitioning) {
            return;
        }
        this.transform.moveCamera(this.mapplsMap, CameraUpdateFactory.bearingTo(f), (MapplsMap.CancelableCallback) null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLatLng(LatLng latLng) {
        if (this.isTransitioning) {
            return;
        }
        this.lastLocation = latLng;
        this.transform.moveCamera(this.mapplsMap, CameraUpdateFactory.newLatLng(latLng), (MapplsMap.CancelableCallback) null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoom(float f) {
        if (this.isTransitioning) {
            return;
        }
        this.transform.moveCamera(this.mapplsMap, CameraUpdateFactory.zoomTo(f), (MapplsMap.CancelableCallback) null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTilt(float f) {
        if (this.isTransitioning) {
            return;
        }
        this.transform.moveCamera(this.mapplsMap, CameraUpdateFactory.tiltTo(f), (MapplsMap.CancelableCallback) null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    Set<AnimatorListenerHolder> getAnimationListeners() {
        HashSet hashSet = new HashSet();
        if (isLocationTracking()) {
            hashSet.add(new AnimatorListenerHolder(1, this.latLngValueListener));
        }
        if (isLocationBearingTracking()) {
            hashSet.add(new AnimatorListenerHolder(4, this.gpsBearingValueListener));
        }
        if (isConsumingCompass()) {
            hashSet.add(new AnimatorListenerHolder(5, this.compassBearingValueListener));
        }
        hashSet.add(new AnimatorListenerHolder(7, this.zoomValueListener));
        hashSet.add(new AnimatorListenerHolder(8, this.tiltValueListener));
        return hashSet;
    }

    boolean isTransitioning() {
        return this.isTransitioning;
    }

    void setTransitioning(boolean z) {
        this.isTransitioning = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustGesturesThresholds() {
        if (this.options.trackingGesturesManagement()) {
            if (isLocationTracking()) {
                this.moveGestureDetector.setMoveThreshold(this.options.trackingInitialMoveThreshold());
            } else {
                this.moveGestureDetector.setMoveThreshold(0.0f);
                this.moveGestureDetector.setMoveThresholdRect(null);
            }
        }
    }

    boolean isConsumingCompass() {
        int i = this.cameraMode;
        return i == 32 || i == 16;
    }

    void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocationTracking() {
        int i = this.cameraMode;
        return i == 24 || i == 32 || i == 34 || i == 36;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBearingTracking() {
        int i = this.cameraMode;
        return i == 16 || i == 32 || i == 22 || i == 34 || i == 36;
    }

    private boolean isLocationBearingTracking() {
        int i = this.cameraMode;
        return i == 34 || i == 36 || i == 22;
    }

    private void notifyCameraTrackingChangeListener(boolean z) {
        this.internalCameraTrackingChangedListener.onCameraTrackingChanged(this.cameraMode);
        if (!z || isLocationTracking()) {
            return;
        }
        if (this.mapplsMap.getUiSettings() != null) {
            this.mapplsMap.getUiSettings().setFocalPoint(null);
        }
        this.internalCameraTrackingChangedListener.onCameraTrackingDismissed();
    }

    private class LocationGesturesManager extends AndroidGesturesManager {
        LocationGesturesManager(Context context) {
            super(context);
        }

        @Override // com.mappls.sdk.gestures.AndroidGesturesManager
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent != null && motionEvent.getActionMasked() == 1) {
                LocationCameraController.this.adjustGesturesThresholds();
            }
            return super.onTouchEvent(motionEvent);
        }
    }
}
