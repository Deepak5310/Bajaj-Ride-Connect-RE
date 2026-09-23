package com.google.android.libraries.navigation.internal.oq;

import androidx.core.math.MathUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class j {
    public static final j c = new c(0.0f, 0.0f);

    public static j c(float f, float f2) {
        return new c(d(f), d(f2));
    }

    private static float d(float f) {
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        return MathUtils.clamp(f, -1.0f, 1.0f);
    }

    public abstract float a();

    public abstract float b();
}
