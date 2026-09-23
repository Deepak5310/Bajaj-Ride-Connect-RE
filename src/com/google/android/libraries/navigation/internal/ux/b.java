package com.google.android.libraries.navigation.internal.ux;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ View a;

    public b(View view) {
        this.a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = iIntValue;
        this.a.setLayoutParams(layoutParams);
    }
}
