package com.google.android.libraries.navigation.internal.p002do;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return f < 0.25f ? 1.0f - (f / 0.25f) : k.d.getInterpolation((f - 0.25f) / 0.75f);
    }
}
