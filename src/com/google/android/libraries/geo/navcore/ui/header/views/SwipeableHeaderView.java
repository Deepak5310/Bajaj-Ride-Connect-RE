package com.google.android.libraries.geo.navcore.ui.header.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.google.android.apps.gmm.base.views.viewpager.ArrowViewPager;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.mx.w;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class SwipeableHeaderView extends ArrowViewPager {
    static final cx q = new q();
    private float A;
    private boolean B;
    private int C;
    public boolean r;
    public long s;
    public Animator t;
    public int u;
    private final Context v;
    private final GestureDetector w;
    private final GestureDetector.OnGestureListener x;
    private int y;
    private int z;

    public SwipeableHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = false;
        this.C = -1;
        this.u = 1;
        this.v = context;
        p pVar = new p(this);
        this.x = pVar;
        this.w = new GestureDetector(context, pVar, k());
        l(context);
    }

    public static w h(Long l) {
        return ch.f(com.google.android.libraries.navigation.internal.ad.b.DURATION, l, q);
    }

    private final float j(float f, float f2) {
        return (i() ? f2 - f : f - f2) / this.z;
    }

    private static Handler k() {
        return new Handler(Looper.getMainLooper());
    }

    private final void l(Context context) {
        this.y = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        this.z = context.getResources().getDisplayMetrics().widthPixels;
    }

    private final Animator m(float f, int i, Interpolator interpolator) {
        if (i == 1) {
            return ValueAnimator.ofFloat(new float[0]);
        }
        float f2 = i == 2 ? 0.0f : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.setDuration((long) (Math.abs(f2 - f) * this.s));
        final float f3 = i() ? -this.z : this.z;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.libraries.geo.navcore.ui.header.views.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * f3);
            }
        });
        if (this.r) {
            valueAnimatorOfFloat.addListener(new o(this, f2, f3));
        }
        return valueAnimatorOfFloat;
    }

    private final void n(float f, int i) {
        m(f, i, i == 2 ? new FastOutSlowInInterpolator() : new FastOutLinearInInterpolator()).start();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00dc  */
    @Override // com.google.android.apps.gmm.base.views.viewpager.ArrowViewPager, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Animator animator;
        if (a() != 0 || this.o || !this.r) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!i() ? getTranslationX() >= 0.0f : getTranslationX() <= 0.0f) {
            this.B = false;
            setTranslationX(0.0f);
            return super.dispatchTouchEvent(motionEvent);
        }
        motionEvent.offsetLocation(getTranslationX(), getTranslationY());
        this.w.onTouchEvent(motionEvent);
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        int i = this.C;
        if (i == -1 || pointerId == i) {
            float x = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (!this.B && (!i() ? x - this.A > this.y : this.A - x > this.y)) {
                            this.B = true;
                            this.C = pointerId;
                        }
                        if (this.B) {
                            setTranslationX(x - this.A);
                            return true;
                        }
                    } else if (actionMasked == 5) {
                        this.C = pointerId;
                        this.u = 1;
                        this.A = x;
                        this.B = false;
                        animator = this.t;
                        if (animator != null) {
                            animator.cancel();
                            this.A -= getTranslationX();
                            this.B = true;
                            return true;
                        }
                    } else if (actionMasked == 6) {
                    }
                }
                if (this.B) {
                    this.B = false;
                    this.C = -1;
                    float fJ = j(x, this.A);
                    int i2 = this.u;
                    if (i2 != 1) {
                        m(fJ, i2, i2 == 2 ? new LinearOutSlowInInterpolator() : new LinearInterpolator()).start();
                    } else {
                        n(fJ, fJ > 0.3f ? 3 : 2);
                    }
                }
            } else {
                this.C = pointerId;
                this.u = 1;
                this.A = x;
                this.B = false;
                animator = this.t;
                if (animator != null) {
                    animator.cancel();
                    this.A -= getTranslationX();
                    this.B = true;
                    return true;
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public final boolean i() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.y = ViewConfiguration.get(this.v).getScaledPagingTouchSlop();
        this.z = this.v.getResources().getDisplayMetrics().widthPixels;
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(View view, int i) {
        if (view == this && i == 0) {
            this.B = false;
            this.C = -1;
            n(j(getTranslationX(), 0.0f), 2);
        }
    }

    public SwipeableHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = false;
        this.C = -1;
        this.u = 1;
        this.v = context;
        p pVar = new p(this);
        this.x = pVar;
        this.w = new GestureDetector(context, pVar, k());
        l(context);
    }
}
