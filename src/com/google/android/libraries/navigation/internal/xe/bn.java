package com.google.android.libraries.navigation.internal.xe;

import android.animation.Animator;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.CustomControlPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bn extends bo {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ CustomControlPosition b;
    final /* synthetic */ bp c;

    public bn(bp bpVar, ViewGroup viewGroup, CustomControlPosition customControlPosition) {
        this.a = viewGroup;
        this.b = customControlPosition;
        this.c = bpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.bo, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ds dsVar;
        this.a.removeAllViews();
        this.a.setTranslationY(0.0f);
        if (this.b != CustomControlPosition.SECONDARY_HEADER || (dsVar = this.c.l) == null) {
            return;
        }
        dsVar.F(false);
    }
}
