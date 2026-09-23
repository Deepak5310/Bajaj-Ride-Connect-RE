package com.google.android.libraries.navigation.internal.vf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ TextView a;
    final /* synthetic */ View b;
    final /* synthetic */ View c;
    final /* synthetic */ ab d;

    public aa(ab abVar, TextView textView, View view, View view2) {
        this.a = textView;
        this.b = view;
        this.c = view2;
        this.d = abVar;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        if (this.d.e != null) {
            this.a.setAlpha(1.0f);
            this.c.setAlpha(1.0f);
            this.d.e.start();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        this.a.setAlpha(0.0f);
        this.a.setTranslationX(0.0f);
        this.a.setTextColor(com.google.android.libraries.navigation.internal.w.a.r().b(this.d.c));
        View viewA = com.google.android.libraries.navigation.internal.ms.be.a((View) this.b.getParent(), ai.a);
        if (viewA == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) ab.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1930)).p("ButtonView not found. Cannot perform animation.");
        } else if (viewA.getBackground() instanceof TransitionDrawable) {
            ((TransitionDrawable) viewA.getBackground()).startTransition(350);
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) ab.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1929)).p("ButtonView does not have TransitionDrawable.");
        }
    }
}
