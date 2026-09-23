package com.mappls.sdk.maps.location;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes4.dex */
class MapplsFloatAnimator extends MapplsAnimator<Float> {
    MapplsFloatAnimator(Float[] fArr, MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i) {
        super(fArr, animationsValueChangeListener, i);
    }

    @Override // com.mappls.sdk.maps.location.MapplsAnimator
    TypeEvaluator provideEvaluator() {
        return new FloatEvaluator();
    }
}
