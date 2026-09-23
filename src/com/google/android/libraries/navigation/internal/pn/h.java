package com.google.android.libraries.navigation.internal.pn;

import android.view.MotionEvent;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    protected final float a;
    protected final float b;
    protected final long c;
    protected final int d;
    private MotionEvent e;

    protected h(MotionEvent motionEvent) {
        this.e = motionEvent;
        int pointerCount = motionEvent.getPointerCount();
        this.d = pointerCount;
        if (pointerCount > 1) {
            int i = 0;
            double x = motionEvent.getX(0);
            double x2 = motionEvent.getX(0);
            double y = motionEvent.getY(0);
            double y2 = motionEvent.getY(0);
            double d = y;
            double d2 = x2;
            int i2 = 1;
            double d3 = x;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i2 < this.d) {
                int i6 = i;
                int i7 = i3;
                double x3 = motionEvent.getX(i2);
                int i8 = i4;
                int i9 = i5;
                double y3 = motionEvent.getY(i2);
                d3 = d3 > x3 ? x3 : d3;
                i8 = d3 > x3 ? i2 : i8;
                d2 = d2 < x3 ? x3 : d2;
                i9 = d2 < x3 ? i2 : i9;
                d = d > y3 ? y3 : d;
                i3 = d > y3 ? i2 : i7;
                y2 = y2 < y3 ? y3 : y2;
                i = y2 < y3 ? i2 : i6;
                i2++;
                i4 = i8;
                i5 = i9;
            }
            int i10 = i3;
            int i11 = i4;
            double d4 = d2 - d3;
            double d5 = y2 - d;
            int i12 = d4 <= d5 ? i : i5;
            int i13 = d4 <= d5 ? i10 : i11;
            float x4 = motionEvent.getX(i13) - motionEvent.getX(i12);
            float y4 = motionEvent.getY(i13) - motionEvent.getY(i12);
            double d6 = x4;
            double d7 = y4;
            this.a = (float) Math.atan2(d6, d7);
            this.b = (float) Math.hypot(d6, d7);
        } else {
            this.a = 0.0f;
            this.b = 0.0f;
        }
        this.c = motionEvent.getEventTime();
    }

    public static float a(float f, float f2, float f3, float f4) {
        return (float) Math.atan2(f3 - f, f4 - f2);
    }

    public final float b(int i) {
        ar.r(this.e, "Event has been recycled.");
        return this.e.getX(i);
    }

    public final float c(int i) {
        ar.r(this.e, "Event has been recycled.");
        return this.e.getY(i);
    }

    public final void d() {
        ar.r(this.e, "Event has been recycled.");
        this.e.recycle();
        this.e = null;
    }
}
