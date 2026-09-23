package com.mappls.sdk.maps.location;

import android.location.Location;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.log.Logger;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class LocationAnimatorCoordinator {
    private static final String TAG = "Mbgl-LocationAnimatorCoordinator";
    private boolean accuracyAnimationEnabled;
    private final MapplsAnimatorProvider animatorProvider;
    private final MapplsAnimatorSetProvider animatorSetProvider;
    private boolean compassAnimationEnabled;
    private float durationMultiplier;
    private Location previousLocation;
    private final Projection projection;
    final SparseArray<MapplsAnimator> animatorArray = new SparseArray<>();
    private float previousAccuracyRadius = -1.0f;
    private float previousCompassBearing = -1.0f;
    private long locationUpdateTimestamp = -1;
    int maxAnimationFps = Integer.MAX_VALUE;
    final SparseArray<MapplsAnimator.AnimationsValueChangeListener> listeners = new SparseArray<>();

    private float checkGpsNorth(boolean z, float f) {
        if (z) {
            return 0.0f;
        }
        return f;
    }

    LocationAnimatorCoordinator(Projection projection, MapplsAnimatorSetProvider mapplsAnimatorSetProvider, MapplsAnimatorProvider mapplsAnimatorProvider) {
        this.projection = projection;
        this.animatorProvider = mapplsAnimatorProvider;
        this.animatorSetProvider = mapplsAnimatorSetProvider;
    }

    void updateAnimatorListenerHolders(Set<AnimatorListenerHolder> set) {
        MapplsAnimator mapplsAnimator;
        this.listeners.clear();
        for (AnimatorListenerHolder animatorListenerHolder : set) {
            this.listeners.append(animatorListenerHolder.getAnimatorType(), animatorListenerHolder.getListener());
        }
        for (int i = 0; i < this.animatorArray.size(); i++) {
            int iKeyAt = this.animatorArray.keyAt(i);
            if (this.listeners.get(iKeyAt) == null && (mapplsAnimator = this.animatorArray.get(iKeyAt)) != null) {
                mapplsAnimator.makeInvalid();
            }
        }
    }

    void feedNewLocation(Location location, CameraPosition cameraPosition, boolean z) {
        feedNewLocation(new Location[]{location}, cameraPosition, z, false);
    }

    void feedNewLocation(Location[] locationArr, CameraPosition cameraPosition, boolean z, boolean z2) {
        Float[] bearingValues;
        Location location = locationArr[locationArr.length - 1];
        if (this.previousLocation == null) {
            this.previousLocation = location;
            this.locationUpdateTimestamp = SystemClock.elapsedRealtime() - 750;
        }
        LatLng previousLayerLatLng = getPreviousLayerLatLng();
        float previousLayerGpsBearing = getPreviousLayerGpsBearing();
        LatLng latLng = cameraPosition.target;
        float fNormalize = Utils.normalize((float) cameraPosition.bearing);
        LatLng[] latLngValues = getLatLngValues(previousLayerLatLng, locationArr);
        updateLayerAnimators(latLngValues, getBearingValues(Float.valueOf(previousLayerGpsBearing), locationArr));
        latLngValues[0] = latLng;
        if (z) {
            bearingValues = new Float[]{Float.valueOf(fNormalize), Float.valueOf(Utils.shortestRotation(0.0f, fNormalize))};
        } else {
            bearingValues = getBearingValues(Float.valueOf(fNormalize), locationArr);
        }
        updateCameraAnimators(latLngValues, bearingValues);
        LatLng latLng2 = new LatLng(location);
        long jMin = 0;
        if (!(Utils.immediateAnimation(this.projection, latLng, latLng2) || Utils.immediateAnimation(this.projection, previousLayerLatLng, latLng2))) {
            long j = this.locationUpdateTimestamp;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.locationUpdateTimestamp = jElapsedRealtime;
            if (j != 0) {
                if (z2) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis > location.getTime()) {
                        Logger.e("LocationAnimatorCoordinator", "Lookahead enabled, but the target location's timestamp is smaller than current timestamp");
                    } else {
                        jMin = location.getTime() - jCurrentTimeMillis;
                    }
                } else {
                    jMin = (long) ((jElapsedRealtime - j) * this.durationMultiplier);
                }
            }
            jMin = Math.min(jMin, 2000L);
        }
        playAnimators(jMin, 0, 2, 1, 4);
        this.previousLocation = location;
    }

    void feedNewCompassBearing(float f, CameraPosition cameraPosition) {
        if (this.previousCompassBearing < 0.0f) {
            this.previousCompassBearing = f;
        }
        updateCompassAnimators(f, getPreviousLayerCompassBearing(), (float) cameraPosition.bearing);
        playAnimators(this.compassAnimationEnabled ? 500L : 0L, 3, 5);
        this.previousCompassBearing = f;
    }

    void feedNewAccuracyRadius(float f, boolean z) {
        if (this.previousAccuracyRadius < 0.0f) {
            this.previousAccuracyRadius = f;
        }
        updateAccuracyAnimators(f, getPreviousAccuracyRadius());
        playAnimators((z || !this.accuracyAnimationEnabled) ? 0L : 250L, 6);
        this.previousAccuracyRadius = f;
    }

    void startLocationComponentCirclePulsing(LocationComponentOptions locationComponentOptions) {
        cancelAnimator(9);
        MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(9);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(9, this.animatorProvider.pulsingCircleAnimator(animationsValueChangeListener, this.maxAnimationFps, locationComponentOptions.pulseSingleDuration(), locationComponentOptions.pulseMaxRadius(), locationComponentOptions.pulseInterpolator() == null ? new DecelerateInterpolator() : locationComponentOptions.pulseInterpolator()));
            playPulsingAnimator();
        }
    }

    void feedNewZoomLevel(double d, CameraPosition cameraPosition, long j, MapplsMap.CancelableCallback cancelableCallback) {
        updateZoomAnimator((float) d, (float) cameraPosition.zoom, cancelableCallback);
        playAnimators(j, 7);
    }

    void feedNewTilt(double d, CameraPosition cameraPosition, long j, MapplsMap.CancelableCallback cancelableCallback) {
        updateTiltAnimator((float) d, (float) cameraPosition.tilt, cancelableCallback);
        playAnimators(j, 8);
    }

    private LatLng getPreviousLayerLatLng() {
        MapplsAnimator mapplsAnimator = this.animatorArray.get(0);
        if (mapplsAnimator != null) {
            return (LatLng) mapplsAnimator.getAnimatedValue();
        }
        return new LatLng(this.previousLocation);
    }

    private float getPreviousLayerGpsBearing() {
        MapplsFloatAnimator mapplsFloatAnimator = (MapplsFloatAnimator) this.animatorArray.get(2);
        if (mapplsFloatAnimator != null) {
            return ((Float) mapplsFloatAnimator.getAnimatedValue()).floatValue();
        }
        return this.previousLocation.getBearing();
    }

    private float getPreviousLayerCompassBearing() {
        MapplsFloatAnimator mapplsFloatAnimator = (MapplsFloatAnimator) this.animatorArray.get(3);
        if (mapplsFloatAnimator != null) {
            return ((Float) mapplsFloatAnimator.getAnimatedValue()).floatValue();
        }
        return this.previousCompassBearing;
    }

    private float getPreviousAccuracyRadius() {
        MapplsAnimator mapplsAnimator = this.animatorArray.get(6);
        if (mapplsAnimator != null) {
            return ((Float) mapplsAnimator.getAnimatedValue()).floatValue();
        }
        return this.previousAccuracyRadius;
    }

    private LatLng[] getLatLngValues(LatLng latLng, Location[] locationArr) {
        int length = locationArr.length + 1;
        LatLng[] latLngArr = new LatLng[length];
        latLngArr[0] = latLng;
        for (int i = 1; i < length; i++) {
            latLngArr[i] = new LatLng(locationArr[i - 1]);
        }
        return latLngArr;
    }

    private Float[] getBearingValues(Float f, Location[] locationArr) {
        int length = locationArr.length + 1;
        Float[] fArr = new Float[length];
        fArr[0] = Float.valueOf(Utils.normalize(f.floatValue()));
        for (int i = 1; i < length; i++) {
            int i2 = i - 1;
            fArr[i] = Float.valueOf(Utils.shortestRotation(locationArr[i2].getBearing(), fArr[i2].floatValue()));
        }
        return fArr;
    }

    private void updateLayerAnimators(LatLng[] latLngArr, Float[] fArr) {
        createNewLatLngAnimator(0, latLngArr);
        createNewFloatAnimator(2, fArr);
    }

    private void updateCameraAnimators(LatLng[] latLngArr, Float[] fArr) {
        createNewLatLngAnimator(1, latLngArr);
        createNewFloatAnimator(4, fArr);
    }

    private void updateCompassAnimators(float f, float f2, float f3) {
        createNewFloatAnimator(3, f2, Utils.shortestRotation(f, f2));
        createNewFloatAnimator(5, f3, Utils.shortestRotation(f, f3));
    }

    private void updateAccuracyAnimators(float f, float f2) {
        createNewFloatAnimator(6, f2, f);
    }

    private void updateZoomAnimator(float f, float f2, MapplsMap.CancelableCallback cancelableCallback) {
        createNewCameraAdapterAnimator(7, new Float[]{Float.valueOf(f2), Float.valueOf(f)}, cancelableCallback);
    }

    private void updateTiltAnimator(float f, float f2, MapplsMap.CancelableCallback cancelableCallback) {
        createNewCameraAdapterAnimator(8, new Float[]{Float.valueOf(f2), Float.valueOf(f)}, cancelableCallback);
    }

    private void createNewLatLngAnimator(int i, LatLng latLng, LatLng latLng2) {
        createNewLatLngAnimator(i, new LatLng[]{latLng, latLng2});
    }

    private void createNewLatLngAnimator(int i, LatLng[] latLngArr) {
        cancelAnimator(i);
        MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(i);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(i, this.animatorProvider.latLngAnimator(latLngArr, animationsValueChangeListener, this.maxAnimationFps));
        }
    }

    private void createNewFloatAnimator(int i, float f, float f2) {
        createNewFloatAnimator(i, new Float[]{Float.valueOf(f), Float.valueOf(f2)});
    }

    private void createNewFloatAnimator(int i, Float[] fArr) {
        cancelAnimator(i);
        MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(i);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(i, this.animatorProvider.floatAnimator(fArr, animationsValueChangeListener, this.maxAnimationFps));
        }
    }

    private void createNewCameraAdapterAnimator(int i, Float[] fArr, MapplsMap.CancelableCallback cancelableCallback) {
        cancelAnimator(i);
        MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(i);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(i, this.animatorProvider.cameraAnimator(fArr, animationsValueChangeListener, cancelableCallback));
        }
    }

    private void playAnimators(long j, int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            MapplsAnimator mapplsAnimator = this.animatorArray.get(i);
            if (mapplsAnimator != null) {
                arrayList.add(mapplsAnimator);
            }
        }
        this.animatorSetProvider.startAnimation(arrayList, new LinearInterpolator(), j);
    }

    private void playPulsingAnimator() {
        MapplsAnimator mapplsAnimator = this.animatorArray.get(9);
        if (mapplsAnimator != null) {
            mapplsAnimator.start();
        }
    }

    void resetAllCameraAnimations(CameraPosition cameraPosition, boolean z) {
        resetCameraCompassAnimation(cameraPosition);
        playAnimators(resetCameraLocationAnimations(cameraPosition, z) ? 0L : 750L, 1, 4);
    }

    private boolean resetCameraLocationAnimations(CameraPosition cameraPosition, boolean z) {
        resetCameraGpsBearingAnimation(cameraPosition, z);
        return resetCameraLatLngAnimation(cameraPosition);
    }

    private boolean resetCameraLatLngAnimation(CameraPosition cameraPosition) {
        MapplsLatLngAnimator mapplsLatLngAnimator = (MapplsLatLngAnimator) this.animatorArray.get(1);
        if (mapplsLatLngAnimator == null) {
            return false;
        }
        LatLng target = mapplsLatLngAnimator.getTarget();
        LatLng latLng = cameraPosition.target;
        createNewLatLngAnimator(1, latLng, target);
        return Utils.immediateAnimation(this.projection, latLng, target);
    }

    private void resetCameraGpsBearingAnimation(CameraPosition cameraPosition, boolean z) {
        MapplsFloatAnimator mapplsFloatAnimator = (MapplsFloatAnimator) this.animatorArray.get(4);
        if (mapplsFloatAnimator == null) {
            return;
        }
        float fCheckGpsNorth = checkGpsNorth(z, mapplsFloatAnimator.getTarget().floatValue());
        float f = (float) cameraPosition.bearing;
        createNewFloatAnimator(4, f, Utils.shortestRotation(fCheckGpsNorth, f));
    }

    private void resetCameraCompassAnimation(CameraPosition cameraPosition) {
        MapplsFloatAnimator mapplsFloatAnimator = (MapplsFloatAnimator) this.animatorArray.get(5);
        if (mapplsFloatAnimator == null) {
            return;
        }
        float fFloatValue = mapplsFloatAnimator.getTarget().floatValue();
        float f = (float) cameraPosition.bearing;
        createNewFloatAnimator(5, f, Utils.shortestRotation(fFloatValue, f));
    }

    void resetAllLayerAnimations() {
        MapplsLatLngAnimator mapplsLatLngAnimator = (MapplsLatLngAnimator) this.animatorArray.get(0);
        MapplsFloatAnimator mapplsFloatAnimator = (MapplsFloatAnimator) this.animatorArray.get(2);
        MapplsFloatAnimator mapplsFloatAnimator2 = (MapplsFloatAnimator) this.animatorArray.get(3);
        MapplsFloatAnimator mapplsFloatAnimator3 = (MapplsFloatAnimator) this.animatorArray.get(6);
        if (mapplsLatLngAnimator != null && mapplsFloatAnimator != null) {
            createNewLatLngAnimator(0, (LatLng) mapplsLatLngAnimator.getAnimatedValue(), mapplsLatLngAnimator.getTarget());
            createNewFloatAnimator(2, ((Float) mapplsFloatAnimator.getAnimatedValue()).floatValue(), mapplsFloatAnimator.getTarget().floatValue());
            playAnimators(mapplsLatLngAnimator.getDuration() - mapplsLatLngAnimator.getCurrentPlayTime(), 0, 2);
        }
        if (mapplsFloatAnimator2 != null) {
            createNewFloatAnimator(3, getPreviousLayerCompassBearing(), mapplsFloatAnimator2.getTarget().floatValue());
            playAnimators(this.compassAnimationEnabled ? 500L : 0L, 3);
        }
        if (mapplsFloatAnimator3 != null) {
            feedNewAccuracyRadius(this.previousAccuracyRadius, false);
        }
    }

    void cancelZoomAnimation() {
        cancelAnimator(7);
    }

    void cancelTiltAnimation() {
        cancelAnimator(8);
    }

    void cancelAndRemoveGpsBearingAnimation() {
        cancelAnimator(2);
        this.animatorArray.remove(2);
    }

    void stopPulsingCircleAnimation() {
        cancelAnimator(9);
    }

    void cancelAllAnimations() {
        for (int i = 0; i < this.animatorArray.size(); i++) {
            cancelAnimator(this.animatorArray.keyAt(i));
        }
    }

    private void cancelAnimator(int i) {
        MapplsAnimator mapplsAnimator = this.animatorArray.get(i);
        if (mapplsAnimator != null) {
            mapplsAnimator.cancel();
            mapplsAnimator.removeAllUpdateListeners();
            mapplsAnimator.removeAllListeners();
        }
    }

    void setTrackingAnimationDurationMultiplier(float f) {
        this.durationMultiplier = f;
    }

    void setCompassAnimationEnabled(boolean z) {
        this.compassAnimationEnabled = z;
    }

    void setAccuracyAnimationEnabled(boolean z) {
        this.accuracyAnimationEnabled = z;
    }

    void setMaxAnimationFps(int i) {
        if (i <= 0) {
            Logger.e(TAG, "Max animation FPS cannot be less or equal to 0.");
        } else {
            this.maxAnimationFps = i;
        }
    }
}
