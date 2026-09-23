package com.google.android.apps.gmm.base.views.viewpager;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class f {
    private final View a;
    private boolean b;
    private float c;
    private float d;
    private final int e;

    public f(ArrowViewPager arrowViewPager, View view) {
        this.a = view;
        this.e = ViewConfiguration.get(arrowViewPager.getContext()).getScaledPagingTouchSlop();
    }

    private final boolean b(float f, float f2, float f3, float f4) {
        int i = this.e;
        float fAbs = Math.abs(f - f3);
        float f5 = i;
        return fAbs < f5 && Math.abs(f2 - f4) < f5;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.a.getVisibility() == 0 && motionEvent.getX() >= this.a.getLeft() && motionEvent.getX() <= this.a.getRight() && motionEvent.getY() >= this.a.getTop() && motionEvent.getY() <= this.a.getBottom()) {
            this.b = true;
            this.a.setPressed(true);
            this.c = motionEvent.getX();
            this.d = motionEvent.getY();
            return false;
        }
        if (motionEvent.getAction() == 2 && this.b) {
            if (!b(this.c, this.d, motionEvent.getX(), motionEvent.getY())) {
                this.b = false;
                this.a.setPressed(false);
            }
            return false;
        }
        if (motionEvent.getAction() == 1 && this.b) {
            this.b = false;
            this.a.setPressed(false);
            return b(this.c, this.d, motionEvent.getX(), motionEvent.getY());
        }
        this.b = false;
        this.a.setPressed(false);
        return false;
    }
}
