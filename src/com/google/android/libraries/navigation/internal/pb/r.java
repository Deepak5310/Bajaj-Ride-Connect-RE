package com.google.android.libraries.navigation.internal.pb;

import android.animation.TimeInterpolator;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r implements TimeInterpolator {
    public TimeInterpolator a;
    private final ab b;

    public r(TimeInterpolator timeInterpolator, ab abVar) {
        ar.q(timeInterpolator);
        this.a = timeInterpolator;
        this.b = abVar;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float interpolation = this.a.getInterpolation(f);
        float fA = this.b.a(interpolation);
        return fA != 0.0f ? fA : interpolation;
    }
}
