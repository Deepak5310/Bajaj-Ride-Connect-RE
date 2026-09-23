package com.google.android.libraries.navigation.internal.ot;

import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import com.google.android.libraries.navigation.internal.ol.ay;
import com.google.android.libraries.navigation.internal.ol.bd;
import com.google.android.libraries.navigation.internal.ol.t;
import com.google.android.libraries.navigation.internal.ol.u;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements t {
    private long a = -1;
    private final OvershootInterpolator b = new OvershootInterpolator();

    @Override // com.google.android.libraries.navigation.internal.ol.t
    public final bd a(u uVar) {
        if (this.a == -1) {
            this.a = AnimationUtils.currentAnimationTimeMillis();
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.a;
        ay ayVar = (ay) bd.a.q();
        float f = jCurrentAnimationTimeMillis / 300.0f;
        if (f > 1.0f) {
            if (!ayVar.b.H()) {
                ayVar.v();
            }
            bd bdVar = (bd) ayVar.b;
            bdVar.b |= 2;
            bdVar.d = 1.0f;
            uVar.c((bd) ayVar.t());
            uVar.a();
        } else {
            float interpolation = this.b.getInterpolation(f) + 0.0f;
            if (!ayVar.b.H()) {
                ayVar.v();
            }
            bd bdVar2 = (bd) ayVar.b;
            bdVar2.b |= 2;
            bdVar2.d = interpolation;
        }
        return (bd) ayVar.t();
    }
}
