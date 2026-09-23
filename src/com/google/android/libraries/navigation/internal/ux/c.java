package com.google.android.libraries.navigation.internal.ux;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.ms.d {
    public static final com.google.android.libraries.navigation.internal.nc.a a = com.google.android.libraries.navigation.internal.nc.a.g(55);
    public static final com.google.android.libraries.navigation.internal.nc.a b = com.google.android.libraries.navigation.internal.nc.a.i(55);
    public static final com.google.android.libraries.navigation.internal.nc.a c = com.google.android.libraries.navigation.internal.nc.a.i(98);
    public static final com.google.android.libraries.navigation.internal.nc.a d = com.google.android.libraries.navigation.internal.nc.a.i(107);
    public static final com.google.android.libraries.navigation.internal.nc.a e = com.google.android.libraries.navigation.internal.nc.a.i(100);
    public static final com.google.android.libraries.navigation.internal.nc.a f = com.google.android.libraries.navigation.internal.nc.a.i(103);
    public boolean g;
    private final com.google.android.libraries.navigation.internal.nc.a h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final int m;

    public c(int i, f fVar) {
        this.m = i;
        this.i = !fVar.f().g().equals("--");
        this.j = fVar.k().booleanValue();
        this.k = fVar.o().booleanValue();
        fVar.n().booleanValue();
        this.l = true;
        this.g = i == 4;
        this.h = fVar.l().booleanValue() ? fVar.j().booleanValue() ? d : f : fVar.j().booleanValue() ? c : e;
    }

    private final synchronized void b(View view) {
        boolean z;
        View viewFindViewById = view.findViewById(com.google.android.libraries.navigation.internal.dw.d.z);
        View viewFindViewById2 = view.findViewById(com.google.android.libraries.navigation.internal.dw.d.A);
        int i = this.m;
        if (i != 1) {
            viewFindViewById2 = viewFindViewById;
        }
        if (i != 2 || !this.j) {
            z = i == 1 && this.k;
        }
        float f2 = 0.0f;
        float f3 = 1.0f;
        if ((i == 2 && !this.k) || (i == 1 && !this.j)) {
            if (true == z) {
                f2 = 1.0f;
            }
            viewFindViewById2.setAlpha(f2);
            viewFindViewById2.setVisibility(true != z ? 8 : 0);
            return;
        }
        ValueAnimator duration = ValueAnimator.ofInt(view.getMeasuredWidth(), z ? this.h.e(view.getContext()) : a.e(view.getContext())).setDuration(200L);
        duration.addUpdateListener(new b(view));
        viewFindViewById2.setAlpha(true != z ? 1.0f : 0.0f);
        viewFindViewById2.setVisibility(0);
        if (this.m == 2 && !z && !this.i) {
            viewFindViewById.setVisibility(4);
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(viewFindViewById2, "alpha", true != z ? 0.0f : 1.0f).setDuration(100L);
        if (z) {
            duration2.setStartDelay(100L);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[5];
        if (true == z) {
            f3 = 0.95f;
        }
        animatorArr[0] = ObjectAnimator.ofFloat(viewFindViewById, "scaleX", f3);
        animatorArr[1] = ObjectAnimator.ofFloat(viewFindViewById, "scaleY", f3);
        animatorArr[2] = ObjectAnimator.ofFloat(view, "scaleX", f3);
        animatorArr[3] = ObjectAnimator.ofFloat(view, "scaleY", f3);
        if (true == z) {
            f2 = -10.0f;
        }
        animatorArr[4] = ObjectAnimator.ofFloat(view, "X", f2);
        animatorSet.playTogether(animatorArr);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, duration2, animatorSet);
        animatorSet2.setInterpolator(com.google.android.libraries.navigation.internal.k.a.a);
        animatorSet2.start();
    }

    private final synchronized void c(View view) {
        ValueAnimator duration = ValueAnimator.ofInt(view.getMeasuredWidth(), this.h.e(view.getContext())).setDuration(200L);
        duration.addUpdateListener(new a(view));
        duration.start();
    }

    @Override // com.google.android.libraries.navigation.internal.ms.d
    public final void a(View view) {
        if (!this.l || this.g) {
            return;
        }
        this.g = true;
        int i = this.m;
        if (i == 3) {
            c(view);
        } else if (i != 4) {
            b(view);
        }
    }
}
