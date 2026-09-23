package com.google.android.libraries.navigation.internal.ur;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends Drawable {
    private final Paint a;
    private final RectF b;
    private int c;

    public m(float f, int i) {
        Paint paint = new Paint();
        this.a = paint;
        this.b = new RectF();
        this.c = 0;
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float f = this.c;
        float fMin = Math.min(bounds.height(), bounds.width());
        this.b.set(bounds.left, bounds.top, bounds.left + fMin, bounds.top + fMin);
        this.b.inset(this.a.getStrokeWidth() / 2.0f, this.a.getStrokeWidth() / 2.0f);
        canvas.drawArc(this.b, -90.0f, (f * 360.0f) / 10000.0f, false, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected final boolean onLevelChange(int i) {
        if (i == this.c) {
            return false;
        }
        this.c = i;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
