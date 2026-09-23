package com.google.android.libraries.navigation.internal.vf;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements com.google.android.libraries.navigation.internal.ms.c {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.vf.ab");
    public final Handler b;
    public final Context c;
    public final com.google.android.libraries.navigation.internal.ms.be d;
    public final AnimatedVectorDrawableCompat e;
    public final Runnable f;
    private final AnimatedVectorDrawableCompat g;
    private boolean h = false;

    public ab(Handler handler, Context context, com.google.android.libraries.navigation.internal.ms.be beVar, AnimatedVectorDrawableCompat animatedVectorDrawableCompat, AnimatedVectorDrawableCompat animatedVectorDrawableCompat2, Runnable runnable) {
        this.b = handler;
        this.c = context;
        this.d = beVar;
        this.e = animatedVectorDrawableCompat;
        this.g = animatedVectorDrawableCompat2;
        this.f = runnable;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.c
    public final void a(View view, boolean z) {
        if (this.h) {
            return;
        }
        this.h = true;
        TextView textView = (TextView) com.google.android.libraries.navigation.internal.ms.be.a(view, ai.c);
        if (textView == null) {
            this.f.run();
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1934)).p("TextView not found. Cannot perform animation.");
            return;
        }
        View viewA = com.google.android.libraries.navigation.internal.ms.be.a(view, ai.b);
        if (viewA == null) {
            this.f.run();
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1933)).p("IconView not found. Cannot perform animation.");
            return;
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.e;
        if (animatedVectorDrawableCompat == null) {
            this.f.run();
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1932)).p("IconAnimator not found. Cannot perform animation.");
            return;
        }
        ((ImageView) viewA).setImageDrawable(animatedVectorDrawableCompat);
        this.e.registerAnimationCallback(new z(this));
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.g;
        if (animatedVectorDrawableCompat2 == null) {
            this.f.run();
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1931)).p("BackgroundAnimator not found. Cannot perform animation.");
        } else {
            view.setBackground(animatedVectorDrawableCompat2);
            this.g.registerAnimationCallback(new aa(this, textView, view, viewA));
            this.g.start();
        }
    }
}
