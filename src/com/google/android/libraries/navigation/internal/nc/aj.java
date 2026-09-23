package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj {
    public static ah a(x xVar) {
        bc bcVar = new bc(new Object[0]);
        Paint.Style style = Paint.Style.FILL;
        return new ak(new Object[]{bcVar, xVar, style, null, null}, bcVar, xVar, style);
    }

    public static ah b(final ah ahVar, final ap apVar) {
        return new ah(new Object[]{ahVar, apVar}) { // from class: com.google.android.libraries.navigation.internal.nc.aj.2
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                ap apVar2 = apVar;
                Drawable drawableA = ahVar.a(context);
                int iE = apVar2.e(context);
                int intrinsicHeight = drawableA.getIntrinsicHeight();
                int intrinsicWidth = drawableA.getIntrinsicWidth();
                if (intrinsicHeight > 0 && intrinsicWidth > 0) {
                    intrinsicWidth = Math.round((intrinsicWidth * iE) / intrinsicHeight);
                }
                return new com.google.android.libraries.navigation.internal.mu.h(drawableA, intrinsicWidth, iE);
            }
        };
    }

    public static ah c() {
        return new ah(new Object[0]) { // from class: com.google.android.libraries.navigation.internal.nc.aj.3
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                return new com.google.android.libraries.navigation.internal.mu.f();
            }
        };
    }

    public static ah d(final ah ahVar, float f) {
        final int iRound = Math.round(10000.0f * f);
        return new ah(new Object[]{ahVar, Float.valueOf(f)}) { // from class: com.google.android.libraries.navigation.internal.nc.aj.1
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                ScaleDrawable scaleDrawable = new ScaleDrawable(ahVar.a(context), 17, 1.0f, 1.0f);
                scaleDrawable.setLevel(iRound);
                return new ai(scaleDrawable);
            }
        };
    }
}
