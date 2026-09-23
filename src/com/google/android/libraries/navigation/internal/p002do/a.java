package com.google.android.libraries.navigation.internal.p002do;

import android.animation.ValueAnimator;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.libraries.navigation.internal.dr.ae;
import com.google.android.libraries.navigation.internal.dt.f;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a {
    private static final fd a;
    private final ValueAnimator b = new ValueAnimator();

    static {
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(1.085f);
        Float fValueOf3 = Float.valueOf(0.0f);
        a = fd.m("chevron_size", fValueOf, "shadow_size", fValueOf2, ViewProps.OPACITY, fValueOf3);
        fd.m("chevron_size", Float.valueOf(0.875f), "shadow_size", Float.valueOf(1.6666666f), ViewProps.OPACITY, fValueOf);
        fd.m("chevron_size", fValueOf, "shadow_size", Float.valueOf(2.3f), ViewProps.OPACITY, fValueOf3);
    }

    private final float c(String str) {
        if (this.b.isRunning()) {
            return ((Float) this.b.getAnimatedValue(str)).floatValue();
        }
        Float f = (Float) a.get(str);
        ar.q(f);
        return f.floatValue();
    }

    public final void a(f fVar, float f) {
        float fC = c("chevron_size") * ae.a(f);
        fVar.m = fC;
        fVar.f413n = c(ViewProps.OPACITY);
        fVar.o = c("shadow_size") / fC;
    }

    public final void b() {
        if (this.b.isRunning()) {
            this.b.end();
        }
    }
}
