package com.google.android.libraries.navigation.internal.k;

import android.view.animation.Interpolator;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Interpolator {
    public static final b a = new b();

    public b() {
        ar.f(true, "The exponent should be greater than 0 and less than 1, but %s was given.", Double.valueOf(0.01d));
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return (float) ((1.0d - Math.pow(0.01d, f)) / 0.99d);
    }
}
