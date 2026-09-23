package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes6.dex */
class RubberBandInterpolator implements Interpolator {
    private final float mLimit;

    public RubberBandInterpolator(float f) {
        this.mLimit = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = 1.0f - f;
        return this.mLimit * (1.0f - (f2 * f2));
    }
}
