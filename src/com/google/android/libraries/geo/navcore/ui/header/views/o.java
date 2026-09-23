package com.google.android.libraries.geo.navcore.ui.header.views;

import android.animation.Animator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class o implements Animator.AnimatorListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ SwipeableHeaderView c;
    private boolean d;

    public o(SwipeableHeaderView swipeableHeaderView, float f, float f2) {
        this.a = f;
        this.b = f2;
        this.c = swipeableHeaderView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.d = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.d) {
            this.c.setTranslationX(this.a * this.b);
        }
        this.c.t = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.c.t = animator;
    }
}
