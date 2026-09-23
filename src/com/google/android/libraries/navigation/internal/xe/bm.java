package com.google.android.libraries.navigation.internal.xe;

import android.animation.Animator;
import android.view.ViewGroup;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bm extends bo {
    final /* synthetic */ ViewGroup a;

    public bm(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.bo, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.a.setVisibility(0);
    }
}
