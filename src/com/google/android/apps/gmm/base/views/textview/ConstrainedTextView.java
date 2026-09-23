package com.google.android.apps.gmm.base.views.textview;

import android.content.Context;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstrainedTextView extends AppCompatTextView {
    public static final b a = new b();
    public b b;
    private float c;
    private final TextPaint d;

    public ConstrainedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = a;
        this.c = -1.0f;
        this.d = new TextPaint();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected final void onMeasure(int i, int i2) {
        int iCeil;
        int iCeil2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 1073741824) {
                super.onMeasure(i, i2);
                return;
            }
            mode = 1073741824;
        }
        if (this.c > 0.0f) {
            this.d.set(getPaint());
            this.d.setTextSize(this.c);
            iCeil = ((int) Math.ceil(Layout.getDesiredWidth(getText(), this.d))) + getPaddingLeft() + getPaddingRight();
            Paint.FontMetrics fontMetrics = this.d.getFontMetrics();
            iCeil2 = ((int) Math.ceil(fontMetrics.bottom - fontMetrics.top)) + getPaddingTop() + getPaddingBottom();
        } else {
            iCeil = Integer.MAX_VALUE;
            iCeil2 = Integer.MAX_VALUE;
        }
        b.a();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(Integer.MAX_VALUE, size) : Integer.MAX_VALUE;
        int iMin2 = Math.min(iCeil2, size2);
        int iMin3 = Math.min(iCeil, iMin);
        if (mode != 1073741824) {
            i = View.MeasureSpec.makeMeasureSpec(iMin3, 1073741824);
        }
        if (mode2 != 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(iMin2, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public ConstrainedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = a;
        this.c = -1.0f;
        this.d = new TextPaint();
    }
}
