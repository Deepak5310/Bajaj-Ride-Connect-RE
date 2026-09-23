package com.google.android.libraries.geo.navcore.ui.header.views;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public final Drawable a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final ColorFilter f;

    public g(Drawable drawable, int i, int i2, int i3, boolean z, int i4) {
        this.a = drawable;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = new PorterDuffColorFilter(i4, PorterDuff.Mode.SRC_IN);
        drawable.mutate();
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }
}
