package com.google.android.apps.gmm.base.views.linear;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.f.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class CompactMultiTextLinearLayout extends LinearLayout {
    private int a;
    private int b;

    public CompactMultiTextLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        int lineCount = this.a;
        if (lineCount == Integer.MAX_VALUE) {
            super.onMeasure(i, i2);
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                int iMin = Math.min(lineCount, Math.min(this.b, textView.getMaxLines()));
                if (iMin >= 0) {
                    textView.setMaxLines(iMin);
                    super.measureChildWithMargins(childAt, i, 0, i2, 0);
                    if (textView.getMeasuredHeight() > 0) {
                        lineCount -= textView.getLineCount();
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setMaxLinesInTotal(int i) {
        if (this.a == i || i <= 0) {
            return;
        }
        this.a = i;
        requestLayout();
    }

    public final void setMaxLinesPerView(int i) {
        if (this.b == i || i <= 0) {
            return;
        }
        this.b = i;
        requestLayout();
    }

    public CompactMultiTextLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = Integer.MAX_VALUE;
        this.b = Integer.MAX_VALUE;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a);
            setMaxLinesInTotal(typedArrayObtainStyledAttributes.getInt(j.b, Integer.MAX_VALUE));
            setMaxLinesPerView(typedArrayObtainStyledAttributes.getInt(j.c, Integer.MAX_VALUE));
            typedArrayObtainStyledAttributes.recycle();
        }
        setOrientation(1);
    }
}
