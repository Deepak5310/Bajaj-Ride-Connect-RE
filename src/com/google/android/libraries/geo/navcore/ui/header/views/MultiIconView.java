package com.google.android.libraries.geo.navcore.ui.header.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class MultiIconView extends View {
    int a;
    int b;
    private List c;

    public MultiIconView(Context context) {
        super(context);
        this.c = new ArrayList();
    }

    private static int a(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == 0) {
            size = 16777215;
        }
        if (size <= i2 || mode == 1073741824) {
            return size >= i2 ? size : 16777216 | size;
        }
        return i2;
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        if (this.c.isEmpty()) {
            return;
        }
        canvas.translate(this.a, this.b);
        int size = this.c.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            canvas.save();
            g gVar = (g) this.c.get(size);
            canvas.translate(gVar.c, gVar.d);
            if (gVar.e) {
                canvas.scale(-1.0f, 1.0f);
            }
            canvas.translate(-gVar.b, -gVar.a.getIntrinsicHeight());
            gVar.a.setColorFilter(gVar.f);
            gVar.a.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.c.isEmpty()) {
            setMeasuredDimension(a(i, 0), a(i2, 0));
            return;
        }
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MIN_VALUE;
        for (g gVar : this.c) {
            int intrinsicWidth = gVar.a.getIntrinsicWidth();
            int intrinsicHeight = gVar.a.getIntrinsicHeight();
            int i9 = gVar.c;
            if (gVar.e) {
                i3 = i9 + gVar.b;
                i4 = i3 - intrinsicWidth;
            } else {
                int i10 = i9 - gVar.b;
                i3 = intrinsicWidth + i10;
                i4 = i10;
            }
            if (i4 < i6) {
                i6 = i4;
            }
            if (i3 > i5) {
                i5 = i3;
            }
            int i11 = gVar.d;
            int i12 = i11 - intrinsicHeight;
            if (i12 < i7) {
                i7 = i12;
            }
            if (i11 > i8) {
                i8 = i11;
            }
        }
        int paddingLeft = i6 - getPaddingLeft();
        int paddingRight = i5 + getPaddingRight();
        int paddingTop = i7 - getPaddingTop();
        int paddingBottom = i8 + getPaddingBottom();
        int i13 = paddingRight - paddingLeft;
        int iA = a(i, i13);
        this.a = (-paddingLeft) + Math.round(((iA & 16777215) - i13) * 0.5f);
        int iA2 = a(i2, paddingBottom - paddingTop);
        this.b = (-paddingBottom) + (16777215 & iA2);
        setMeasuredDimension(iA, iA2);
    }

    public final void setIcons(List<g> list) {
        this.c = list;
        invalidate();
        requestLayout();
    }

    public final void setIconsFromProvider$ar$class_merging(d dVar) {
        if (dVar != null) {
            dVar.a(this);
        } else {
            int i = ev.d;
            setIcons(lv.a);
        }
    }

    public MultiIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
    }
}
