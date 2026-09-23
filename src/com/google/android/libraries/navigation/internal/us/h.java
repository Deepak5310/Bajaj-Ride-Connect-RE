package com.google.android.libraries.navigation.internal.us;

import android.animation.Animator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements Animator.AnimatorListener {
    final /* synthetic */ j a;

    public h(j jVar) {
        this.a = jVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.a.b.a();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.a.a.postDelayed(new Runnable() { // from class: com.google.android.libraries.navigation.internal.us.g
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.b.a();
            }
        }, 600L);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
