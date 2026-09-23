package com.google.android.libraries.navigation.internal.ag;

import android.animation.ValueAnimator;
import com.google.android.libraries.navigation.internal.ms.cy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        e eVar = this.a;
        ValueAnimator valueAnimator2 = eVar.b;
        if (valueAnimator2 != null) {
            eVar.a = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
            cy.a(this.a);
        }
    }
}
