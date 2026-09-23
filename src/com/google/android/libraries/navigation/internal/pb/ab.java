package com.google.android.libraries.navigation.internal.pb;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    private float a;
    private float b;
    private float c;
    private float d;

    public final float a(float f) {
        float f2 = this.d;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return b(f) / f2;
    }

    final float b(float f) {
        float f2 = this.c;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = this.a;
        float f4 = ((this.b - f3) * f) + f3;
        return (f2 * 1.1f * (f4 - f3)) + (((float) (Math.pow(f3, 3.0d) - Math.pow(f4, 3.0d))) / 3.0f);
    }

    public final float c(float f) {
        float f2 = this.c;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = this.a;
        return (float) (1.0d - (Math.pow(f3 + ((this.b - f3) * f), 2.0d) / ((double) f2)));
    }

    public final void d(float f, float f2) {
        ar.f(f >= 0.0f, "startValue of %s less than 0", Float.valueOf(f));
        ar.f(f2 >= 0.0f, "endValue of %s less than 0", Float.valueOf(f2));
        float fMax = Math.max(f, f2);
        if (fMax > 4.0f) {
            f = (f * 4.0f) / fMax;
            f2 = (f2 * 4.0f) / fMax;
        }
        this.a = (float) (-Math.pow(f, 0.5d));
        this.b = (float) Math.pow(f2, 0.5d);
        this.c = Math.max(f, f2);
        this.d = b(1.0f);
    }
}
