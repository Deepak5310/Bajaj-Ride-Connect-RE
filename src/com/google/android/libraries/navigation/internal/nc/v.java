package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class v extends ah {
    private final ah a;
    private final x b;
    private final PorterDuff.Mode c;
    private ColorFilter d;
    private int e;

    public v(ah ahVar, x xVar, PorterDuff.Mode mode) {
        super(new Object[]{ahVar, xVar, mode});
        this.a = ahVar;
        this.b = xVar;
        this.c = mode;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        Drawable drawableA = this.a.a(context);
        drawableA.mutate();
        int iB = this.b.b(context);
        if (this.d == null || iB != this.e) {
            this.d = new PorterDuffColorFilter(iB, this.c);
            this.e = iB;
        }
        drawableA.setColorFilter(this.d);
        return drawableA;
    }
}
