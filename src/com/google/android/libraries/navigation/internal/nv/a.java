package com.google.android.libraries.navigation.internal.nv;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends ReplacementSpan implements LineHeightSpan {
    private final Drawable a;
    private final float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    public a(Drawable drawable, float f) {
        if (drawable instanceof BitmapDrawable) {
            drawable.setFilterBitmap(true);
        }
        this.a = drawable;
        this.b = f;
    }

    private final void a(Paint paint) {
        if (paint.getTextSize() == this.c && paint.getTextScaleX() == this.d) {
            return;
        }
        this.c = paint.getTextSize();
        this.d = paint.getTextScaleX();
        float f = this.b;
        if (f > 0.0f) {
            int iCeil = (int) Math.ceil(this.c * f);
            this.e = iCeil;
            this.f = (int) Math.ceil(((iCeil * this.a.getIntrinsicWidth()) / this.a.getIntrinsicHeight()) * this.d);
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i = fontMetricsInt.ascent + fontMetricsInt.descent;
        int i2 = this.e;
        int i3 = (i + i2) / 2;
        this.g = i3;
        int i4 = i3 - i2;
        this.h = i4;
        this.i = (i4 + fontMetricsInt.top) - fontMetricsInt.ascent;
        this.j = (this.g + fontMetricsInt.bottom) - fontMetricsInt.descent;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5 = fontMetricsInt.ascent;
        int i6 = this.h;
        if (i5 > i6) {
            fontMetricsInt.ascent = i6;
        }
        int i7 = fontMetricsInt.descent;
        int i8 = this.g;
        if (i7 < i8) {
            fontMetricsInt.descent = i8;
        }
        int i9 = fontMetricsInt.top;
        int i10 = this.i;
        if (i9 > i10) {
            fontMetricsInt.top = i10;
        }
        int i11 = fontMetricsInt.bottom;
        int i12 = this.j;
        if (i11 < i12) {
            fontMetricsInt.bottom = i12;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        a(paint);
        Drawable drawable = this.a;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        canvas.translate(f, i4 + this.h);
        canvas.scale(this.f / this.a.getIntrinsicWidth(), this.e / this.a.getIntrinsicHeight());
        this.a.draw(canvas);
        canvas.restore();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.a.equals(this.a) && aVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        a(paint);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = this.h;
            fontMetricsInt.descent = this.g;
            fontMetricsInt.top = this.i;
            fontMetricsInt.bottom = this.j;
        }
        return this.f;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
    }

    public a(Drawable drawable, float f, float f2) {
        if (drawable instanceof BitmapDrawable) {
            drawable.setFilterBitmap(true);
        }
        this.a = drawable;
        this.b = -1.0f;
        this.f = (int) Math.ceil(f);
        this.e = (int) Math.ceil(f2);
    }
}
