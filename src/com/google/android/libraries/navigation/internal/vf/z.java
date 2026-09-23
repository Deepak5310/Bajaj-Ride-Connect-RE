package com.google.android.libraries.navigation.internal.vf;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ ab a;

    public z(ab abVar) {
        this.a = abVar;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ab abVar = this.a;
        abVar.b.postDelayed(abVar.f, 1500L);
    }
}
