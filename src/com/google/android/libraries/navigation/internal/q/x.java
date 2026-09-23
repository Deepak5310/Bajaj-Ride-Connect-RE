package com.google.android.libraries.navigation.internal.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class x extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ y b;

    public x(y yVar, View view) {
        this.a = view;
        this.b = yVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (ab.c(this.a)) {
            this.b.b(this.a);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        if (ab.c(this.a)) {
            this.a.setVisibility(0);
        }
    }
}
