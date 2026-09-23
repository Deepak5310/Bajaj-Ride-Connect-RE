package com.google.android.libraries.navigation.internal.aj;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import com.google.android.libraries.navigation.internal.gz.i;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.nc.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ ck b;
    final /* synthetic */ c c;

    public a(View view, ck ckVar, c cVar) {
        this.a = view;
        this.b = ckVar;
        this.c = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.b.o(c.b, null);
        ap apVar = this.c.c;
        View view = this.a;
        view.setTranslationX(apVar.a(view.getContext()));
        ap apVar2 = this.c.e;
        View view2 = this.a;
        view2.setTranslationY(apVar2.a(view2.getContext()));
        this.a.setScaleX(1.0f);
        this.a.setScaleY(1.0f);
        this.a.setAlpha(1.0f);
        View view3 = this.a;
        i.d(view3);
        view3.setRotation(0.0f);
        ViewPropertyAnimator viewPropertyAnimatorAlpha = this.a.animate().translationX(this.c.d.a(this.a.getContext())).translationY(this.c.f.a(this.a.getContext())).scaleX(1.0f).scaleY(1.0f).alpha(1.0f);
        i.d(this.a);
        viewPropertyAnimatorAlpha.rotation(0.0f).setDuration(this.c.f341n).setInterpolator(this.c.m).setStartDelay(this.c.o).start();
        return true;
    }
}
