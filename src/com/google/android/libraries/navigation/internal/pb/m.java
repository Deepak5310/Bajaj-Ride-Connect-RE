package com.google.android.libraries.navigation.internal.pb;

import android.util.DisplayMetrics;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    float a;
    public l b;
    private volatile boolean c = false;
    private final DisplayMetrics d;

    public m(DisplayMetrics displayMetrics, float f) {
        this.a = 65.0f;
        this.d = displayMetrics;
        this.a = f;
    }

    public static float a(float f) {
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return 0.0f;
        }
        return (f % 360.0f) + (f < 0.0f ? 360 : 0);
    }

    public static float b(float f) {
        if (Float.isNaN(f)) {
            return 2.0f;
        }
        return Math.max(2.0f, Math.min(f, 21.0f));
    }

    public final float c(float f, com.google.android.libraries.navigation.internal.oe.x xVar) {
        l lVar = this.b;
        float fMin = 21.0f;
        float fMax = 2.0f;
        if (lVar != null) {
            fMin = Math.min(21.0f, lVar.a(xVar));
            fMax = Math.max(2.0f, this.b.b());
        }
        float fMax2 = Math.max(fMax, Math.min(f, fMin));
        return Float.isNaN(fMax2) ? fMax : fMax2;
    }

    public final com.google.android.libraries.navigation.internal.pd.d d(com.google.android.libraries.navigation.internal.pd.d dVar) {
        com.google.android.libraries.navigation.internal.pd.d dVar2 = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a(dVar);
        e(aVar);
        return aVar.a();
    }

    public final void e(com.google.android.libraries.navigation.internal.pd.a aVar) {
        float f;
        com.google.android.libraries.navigation.internal.oe.x xVar = aVar.b;
        ar.q(xVar);
        float fC = c(aVar.c, xVar);
        aVar.c = fC;
        DisplayMetrics displayMetrics = this.d;
        if (displayMetrics != null) {
            xVar.P(xVar, fC, displayMetrics.heightPixels / this.d.density);
        } else {
            xVar.O(xVar);
        }
        aVar.e(xVar);
        if (fC >= 13.5f) {
            f = this.a;
        } else if (fC > 11.75f) {
            f = 45.0f + (((fC - 11.75f) * (this.a - 45.0f)) / 1.75f);
        } else {
            f = fC > 10.0f ? (((fC - 10.0f) * 15.0f) / 1.75f) + 30.0f : 30.0f;
        }
        float fMax = Math.max(0.0f, Math.min(aVar.d, f));
        aVar.d = true != Float.isNaN(fMax) ? fMax : 0.0f;
        aVar.e = a(aVar.e);
        aVar.f = com.google.android.libraries.navigation.internal.pd.e.e(aVar.f);
    }
}
