package com.google.android.libraries.navigation.internal.us;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.ms.c {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.us.j");
    public final Handler a;
    public final k b;
    private final AnimatorSet d;
    private boolean e;

    public j(k kVar) {
        AnimatorSet animatorSet = new AnimatorSet();
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = kVar;
        this.d = animatorSet;
        this.a = handler;
        this.e = false;
    }

    private final synchronized void b(View view) {
        if (this.e) {
            this.b.a();
            return;
        }
        this.e = true;
        View viewFindViewById = view.findViewById(com.google.android.libraries.navigation.internal.dw.d.p);
        if (viewFindViewById == null) {
            this.b.a();
            ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1911)).p("Layout is badly formed. Cannot perform animation.");
            return;
        }
        View viewFindViewById2 = view.findViewById(com.google.android.libraries.navigation.internal.dw.d.q);
        if (viewFindViewById2 == null) {
            this.b.a();
            ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1910)).p("Layout is badly formed. Cannot perform animation.");
            return;
        }
        int i = ev.d;
        eq eqVar = new eq();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationY", 0.0f, view.getHeight()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(com.google.android.libraries.navigation.internal.k.a.c);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(0L);
        objectAnimatorOfPropertyValuesHolder.setDuration(100L);
        objectAnimatorOfPropertyValuesHolder.addListener(new i(this, viewFindViewById, viewFindViewById2));
        eqVar.h(objectAnimatorOfPropertyValuesHolder);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationY", view.getHeight(), 0.0f));
        objectAnimatorOfPropertyValuesHolder2.setInterpolator(com.google.android.libraries.navigation.internal.k.a.a);
        objectAnimatorOfPropertyValuesHolder2.setStartDelay(0L);
        objectAnimatorOfPropertyValuesHolder2.setDuration(250L);
        eqVar.h(objectAnimatorOfPropertyValuesHolder2);
        this.d.playSequentially(eqVar.g());
        this.d.addListener(new h(this));
        this.d.start();
    }

    @Override // com.google.android.libraries.navigation.internal.ms.c
    public final void a(View view, boolean z) {
        b(view);
    }
}
