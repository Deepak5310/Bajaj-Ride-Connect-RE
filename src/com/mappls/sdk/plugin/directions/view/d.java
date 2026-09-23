package com.mappls.sdk.plugin.directions.view;

import android.graphics.DashPathEffect;

/* JADX INFO: loaded from: classes4.dex */
class d {
    private DashPathEffect a;
    private float b;
    private float c;
    private float d;

    d() {
    }

    DashPathEffect a(float f, float f2, float f3) {
        if (this.b != f || this.c != f2 || this.d != f3) {
            this.b = f;
            this.c = f2;
            this.d = f3;
            this.a = new DashPathEffect(new float[]{f, f2}, f3);
        }
        return this.a;
    }
}
