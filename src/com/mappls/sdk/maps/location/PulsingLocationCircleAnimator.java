package com.mappls.sdk.maps.location;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes4.dex */
public class PulsingLocationCircleAnimator extends MapplsFloatAnimator {
    @Override // com.mappls.sdk.maps.location.MapplsAnimator
    public /* bridge */ /* synthetic */ void makeInvalid() {
        super.makeInvalid();
    }

    @Override // com.mappls.sdk.maps.location.MapplsAnimator, android.animation.ValueAnimator.AnimatorUpdateListener
    public /* bridge */ /* synthetic */ void onAnimationUpdate(ValueAnimator valueAnimator) {
        super.onAnimationUpdate(valueAnimator);
    }

    public PulsingLocationCircleAnimator(MapplsAnimator.AnimationsValueChangeListener animationsValueChangeListener, int i, float f) {
        super(new Float[]{Float.valueOf(0.0f), Float.valueOf(f)}, animationsValueChangeListener, i);
    }
}
