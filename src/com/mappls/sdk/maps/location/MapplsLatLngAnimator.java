package com.mappls.sdk.maps.location;

import android.animation.TypeEvaluator;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes4.dex */
class MapplsLatLngAnimator extends MapplsAnimator<LatLng> {
    MapplsLatLngAnimator(LatLng[] latLngArr, MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        super(latLngArr, animationsValueChangeListener, i);
    }

    @Override // com.mappls.sdk.maps.location.MapplsAnimator
    TypeEvaluator provideEvaluator() {
        return new LatLngEvaluator();
    }
}
