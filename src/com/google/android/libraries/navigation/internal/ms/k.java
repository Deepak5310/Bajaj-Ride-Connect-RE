package com.google.android.libraries.navigation.internal.ms;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public static final /* synthetic */ int a = 0;
    private final c b;
    private final ck c;
    private final View d;
    private final boolean e;
    private ViewTreeObserver f;

    public k(c cVar, ck ckVar) {
        this.b = cVar;
        this.c = ckVar;
        View view = ckVar.c;
        this.d = view;
        view.addOnAttachStateChangeListener(this);
        if (view.getWindowToken() != null) {
            onViewAttachedToWindow(null);
            this.e = true;
        } else {
            onViewDetachedFromWindow(null);
            this.e = false;
        }
    }

    public final void a() {
        this.d.removeOnAttachStateChangeListener(this);
        onViewDetachedFromWindow(null);
        this.c.o(m.c, null);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        a();
        this.b.a(this.d, !this.e);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.d.getViewTreeObserver();
        this.f = viewTreeObserver;
        viewTreeObserver.addOnPreDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            this.f.removeOnPreDrawListener(this);
        }
        this.f = null;
    }
}
