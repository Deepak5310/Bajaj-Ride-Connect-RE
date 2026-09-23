package com.google.android.libraries.navigation.internal.ms;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public static final /* synthetic */ int c = 0;
    public final ck a;
    public final View b;
    private final d d;
    private ViewTreeObserver e;

    public l(d dVar, ck ckVar) {
        this.d = dVar;
        this.a = ckVar;
        View view = ckVar.c;
        this.b = view;
        view.addOnAttachStateChangeListener(this);
        if (view.getWindowToken() != null) {
            onViewAttachedToWindow(null);
        } else {
            onViewDetachedFromWindow(null);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.d.a(this.b);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
        this.e = viewTreeObserver;
        viewTreeObserver.addOnPreDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.e;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            this.e.removeOnPreDrawListener(this);
        }
        this.e = null;
    }
}
