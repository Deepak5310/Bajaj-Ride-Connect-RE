package com.google.android.libraries.navigation.internal.nc;

import android.R;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ba extends ah {
    private final x a;
    private final x b;
    private final ap c;

    public ba(x xVar, x xVar2, ap apVar) {
        super(new Object[]{xVar, xVar2, apVar});
        this.a = xVar;
        this.b = xVar2;
        this.c = apVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        Drawable drawableA;
        Drawable drawableA2;
        if (this.c == null) {
            drawableA2 = this.a.a(context);
            drawableA = this.b.a(context);
        } else {
            int iB = this.a.b(context);
            int iB2 = this.b.b(context);
            PaintDrawable paintDrawable = new PaintDrawable(iB);
            PaintDrawable paintDrawable2 = new PaintDrawable(iB2);
            paintDrawable.setCornerRadius(this.c.a(context));
            paintDrawable2.setCornerRadius(this.c.a(context));
            drawableA = paintDrawable2;
            drawableA2 = paintDrawable;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableA2, new ClipDrawable(drawableA, 3, 1)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }
}
