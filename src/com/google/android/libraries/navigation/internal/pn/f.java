package com.google.android.libraries.navigation.internal.pn;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final int a = ViewConfiguration.getLongPressTimeout();
    public static final int b = ViewConfiguration.getTapTimeout();
    public static final int c = ViewConfiguration.getDoubleTapTimeout();
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final Handler j;
    public final d k;
    public GestureDetector.OnDoubleTapListener l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f517n;
    public boolean o;
    public boolean p;
    public MotionEvent q;
    public MotionEvent r;
    public boolean s;
    public float t;
    public float u;
    public float v;
    public float w;
    public boolean x;
    public final boolean y;
    public VelocityTracker z;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context context, d dVar, Handler handler, boolean z) {
        int scaledTouchSlop;
        int touchSlop;
        int i;
        this.j = new c(this, handler);
        this.k = dVar;
        if (dVar instanceof GestureDetector.OnDoubleTapListener) {
            this.l = dVar;
        }
        this.y = z;
        if (dVar == 0) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.x = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            i = touchSlop + touchSlop;
            this.h = ViewConfiguration.getMinimumFlingVelocity();
            this.i = ViewConfiguration.getMaximumFlingVelocity();
            scaledTouchSlop = touchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop2 = viewConfiguration.getScaledTouchSlop();
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.h = viewConfiguration.getScaledMinimumFlingVelocity();
            this.i = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop2;
            i = scaledDoubleTapSlop;
        }
        this.d = touchSlop;
        this.e = touchSlop * touchSlop;
        this.f = scaledTouchSlop * scaledTouchSlop;
        this.g = i * i;
    }

    public final void a(MotionEvent motionEvent) {
        this.j.removeMessages(1);
        this.j.removeMessages(2);
        this.j.removeMessages(3);
        if (this.s && this.l != null) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getPressure(), motionEvent.getSize(), motionEvent.getMetaState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags());
            GestureDetector.OnDoubleTapListener onDoubleTapListener = this.l;
            ar.q(onDoubleTapListener);
            onDoubleTapListener.onDoubleTapEvent(motionEventObtain);
        }
        this.s = false;
        this.o = false;
        this.p = false;
        if (this.f517n) {
            this.f517n = false;
        }
    }
}
