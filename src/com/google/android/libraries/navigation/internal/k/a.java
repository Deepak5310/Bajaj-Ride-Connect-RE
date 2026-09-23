package com.google.android.libraries.navigation.internal.k;

import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final Interpolator a;
    public static final Interpolator b;
    public static final Interpolator c;

    static {
        PathInterpolatorCompat.create(0.25f, 0.0f, 0.0f, 1.0f);
        a = PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f);
        b = PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f);
        c = PathInterpolatorCompat.create(0.4f, 0.0f, 1.0f, 1.0f);
        PathInterpolatorCompat.create(0.2f, 0.0f, 0.0f, 1.0f);
    }
}
