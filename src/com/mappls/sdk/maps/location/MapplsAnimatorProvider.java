package com.mappls.sdk.maps.location;

import android.view.animation.Interpolator;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes4.dex */
final class MapplsAnimatorProvider {
    private static MapplsAnimatorProvider INSTANCE;

    private MapplsAnimatorProvider() {
    }

    public static MapplsAnimatorProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MapplsAnimatorProvider();
        }
        return INSTANCE;
    }

    MapplsLatLngAnimator latLngAnimator(LatLng[] latLngArr, MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        return new MapplsLatLngAnimator(latLngArr, animationsValueChangeListener, i);
    }

    MapplsFloatAnimator floatAnimator(Float[] fArr, MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        return new MapplsFloatAnimator(fArr, animationsValueChangeListener, i);
    }

    MapplsCameraAnimatorAdapter cameraAnimator(Float[] fArr, MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, MapplsMap.CancelableCallback cancelableCallback) {
        return new MapplsCameraAnimatorAdapter(fArr, animationsValueChangeListener, cancelableCallback);
    }

    PulsingLocationCircleAnimator pulsingCircleAnimator(MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i, float f, float f2, Interpolator interpolator) {
        PulsingLocationCircleAnimator pulsingLocationCircleAnimator = new PulsingLocationCircleAnimator(animationsValueChangeListener, i, f2);
        pulsingLocationCircleAnimator.setDuration((long) f);
        pulsingLocationCircleAnimator.setRepeatMode(1);
        pulsingLocationCircleAnimator.setRepeatCount(-1);
        pulsingLocationCircleAnimator.setInterpolator(interpolator);
        return pulsingLocationCircleAnimator;
    }
}
