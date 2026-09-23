package com.google.android.libraries.navigation.internal.us;

import android.animation.Animator;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements Animator.AnimatorListener {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ j c;

    public i(j jVar, View view, View view2) {
        this.a = view;
        this.b = view2;
        this.c = jVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.c.b.a.l = true;
        this.a.setVisibility(8);
        this.b.setVisibility(0);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
