package com.google.android.libraries.navigation.internal.p002do;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ k a;

    public i(k kVar) {
        this.a = kVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.g.f = ((Integer) valueAnimator.getAnimatedValue()).intValue();
    }
}
