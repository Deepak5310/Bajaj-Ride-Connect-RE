package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ak extends ah {
    final /* synthetic */ bb a;
    final /* synthetic */ x b;
    final /* synthetic */ Paint.Style c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(Object[] objArr, bb bbVar, x xVar, Paint.Style style) {
        super(objArr);
        this.a = bbVar;
        this.b = xVar;
        this.c = style;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.b.b(context));
        paint.setStyle(this.c);
        return shapeDrawable;
    }
}
