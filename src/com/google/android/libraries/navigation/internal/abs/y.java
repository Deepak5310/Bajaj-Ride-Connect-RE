package com.google.android.libraries.navigation.internal.abs;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public static final String a = "y";
    public final Bitmap.Config b;
    public final x c;

    public y(Bitmap.Config config) {
        x xVar = x.a;
        com.google.android.libraries.navigation.internal.abf.s.b(true, "paintTextSizePx[%s] <= 0", Float.valueOf(50.0f));
        com.google.android.libraries.navigation.internal.abf.s.b(true, "outlineWidthPx[%s] <= 0", Float.valueOf(1.5f));
        com.google.android.libraries.navigation.internal.abf.s.k(config, "bitmapConfig");
        this.b = config;
        this.c = xVar;
    }
}
