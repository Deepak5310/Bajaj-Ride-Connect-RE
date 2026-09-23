package com.google.android.libraries.navigation.internal.b;

import com.android.volley.DefaultRetryPolicy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public int a;
    public int b;
    public final int c;
    public final float d;

    public g() {
        this(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public g(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }
}
