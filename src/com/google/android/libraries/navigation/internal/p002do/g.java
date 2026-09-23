package com.google.android.libraries.navigation.internal.p002do;

import android.animation.ValueAnimator;
import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ k a;

    public g(k kVar) {
        this.a = kVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.g.a = (x) valueAnimator.getAnimatedValue();
    }
}
