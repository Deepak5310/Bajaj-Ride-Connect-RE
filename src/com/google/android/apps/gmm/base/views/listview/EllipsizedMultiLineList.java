package com.google.android.apps.gmm.base.views.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.internal.f.j;
import com.google.android.libraries.navigation.internal.kj.c;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class EllipsizedMultiLineList extends ViewGroup {
    public int a;
    private int b;
    private int c;
    private ev d;
    private int e;

    public EllipsizedMultiLineList(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private final int c(int i, int i2) {
        this.e = 1;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i3 = i;
        while (true) {
            int i4 = this.e;
            if (i4 >= 2 || i2 <= i3) {
                break;
            }
            int i5 = i4 + 1;
            this.e = i5;
            i3 = (i - paddingLeft) * i5;
        }
        return i3;
    }

    public final View a() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (b(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean b(View view) {
        return view.getId() == this.a && view.getParent() == this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        ev evVar = this.d;
        int i5 = ((lv) evVar).c;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i3 - i;
            View view = (View) evVar.get(i6);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i8 = c.b(this) ? (i7 - paddingStart) - measuredWidth : paddingStart;
            if (paddingStart + measuredWidth > i7) {
                paddingTop += this.c + measuredHeight;
                paddingStart = getPaddingStart();
                i8 = c.b(this) ? (i7 - paddingStart) - measuredWidth : paddingStart;
            }
            view.layout(i8, paddingTop, i8 + measuredWidth, paddingTop + measuredHeight);
            paddingStart = paddingStart + measuredWidth + this.b;
            if (paddingStart > i7 && paddingStart > i7) {
                paddingTop += measuredHeight + this.c;
                paddingStart = getPaddingStart() + this.b;
            }
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        boolean z;
        int measuredWidth;
        int i3;
        int i4 = 0;
        while (true) {
            z = true;
            if (i4 >= getChildCount()) {
                break;
            }
            c.d(getChildAt(i4), true);
            i4++;
        }
        this.e = 1;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        measureChildren(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 0), i2);
        int size = View.MeasureSpec.getMode(i) == 0 ? Integer.MAX_VALUE : View.MeasureSpec.getSize(i) - paddingLeft;
        c.d(a(), false);
        int paddingStart = getPaddingStart() + getPaddingEnd();
        int i5 = 0;
        int i6 = paddingStart;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (!b(childAt)) {
                int measuredWidth2 = childAt.getMeasuredWidth();
                int i8 = i5 + measuredWidth2;
                if (i6 + measuredWidth2 > size) {
                    i8 += size - i6;
                    i6 = paddingStart;
                }
                int i9 = i6 + measuredWidth2;
                int i10 = this.b;
                int i11 = i9 + i10;
                if (i11 > size) {
                    i8 += size - i9;
                    i6 = paddingStart + i10;
                } else {
                    i6 = i11;
                }
                i5 = i8 + i10;
            }
        }
        int i12 = i5 - this.b;
        int iC = c(size, i12);
        if (i12 >= iC && i12 > iC) {
            View viewA = a();
            if (viewA != null) {
                c.d(viewA, true);
                measuredWidth = viewA.getMeasuredWidth();
            } else {
                measuredWidth = 0;
            }
            int i13 = 0;
            while (i13 < getChildCount()) {
                View childAt2 = getChildAt(i13);
                if (!b(childAt2)) {
                    int measuredWidth3 = childAt2.getMeasuredWidth();
                    if (!z || viewA != null) {
                        int i14 = this.b;
                        measuredWidth3 += i14;
                    }
                    if (measuredWidth3 > size || (i3 = measuredWidth3 + measuredWidth) > iC) {
                        while (i13 < getChildCount()) {
                            if (!b(getChildAt(i13))) {
                                c.d(getChildAt(i13), false);
                            }
                            i13++;
                        }
                        break;
                    }
                    z = false;
                    measuredWidth = i3;
                }
                i13++;
            }
            c(size, measuredWidth);
        }
        int iMax = 0;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt3 = getChildAt(i15);
            if (c.c(childAt3)) {
                iMax = Math.max(iMax, childAt3.getMeasuredHeight());
            }
        }
        int i16 = this.e;
        int i17 = this.c;
        setMeasuredDimension(resolveSizeAndState(Math.max(size, getSuggestedMinimumWidth()), i, 0), resolveSizeAndState(Math.max((((iMax * i16) + (i16 * i17)) - i17) + paddingTop, getSuggestedMinimumHeight()), i2, 0));
        int i18 = ev.d;
        eq eqVar = new eq();
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            View childAt4 = getChildAt(i19);
            if (!b(childAt4) && c.c(childAt4)) {
                eqVar.h(childAt4);
            }
        }
        View viewA2 = a();
        if (c.c(viewA2)) {
            eqVar.h(viewA2);
        }
        this.d = eqVar.g();
    }

    public final void setMarginBetweenItems(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        requestLayout();
        invalidate();
    }

    public final void setMarginBetweenLines(int i) {
        if (this.c == i) {
            return;
        }
        this.c = i;
        requestLayout();
        invalidate();
    }

    public EllipsizedMultiLineList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = 0;
        int i2 = ev.d;
        this.d = lv.a;
        this.a = -2;
        this.e = 1;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.f, i, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.g, 0);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.h, 0);
        typedArrayObtainStyledAttributes.recycle();
        setMarginBetweenItems(dimensionPixelSize);
        setMarginBetweenLines(dimensionPixelSize2);
    }
}
