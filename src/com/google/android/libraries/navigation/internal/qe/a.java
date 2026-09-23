package com.google.android.libraries.navigation.internal.qe;

import android.content.Context;
import android.widget.Scroller;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final float a;
    public final float b;
    public final Scroller c;
    public float d;
    public float e;
    public float f;
    public float g;
    public int h;
    public int i;

    public a(Context context) {
        this.c = new Scroller(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.a = context.getResources().getDisplayMetrics().heightPixels * 0.125f;
        this.b = f + f;
    }

    public final int a(int i, int i2) {
        this.c.abortAnimation();
        this.c.fling(0, 0, i, 0, -i2, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.c.getFinalX();
    }
}
