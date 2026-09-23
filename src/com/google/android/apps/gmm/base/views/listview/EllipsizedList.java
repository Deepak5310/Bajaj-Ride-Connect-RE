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
public class EllipsizedList extends ViewGroup {
    public int a;
    private int b;
    private ev c;

    public EllipsizedList(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected int a() {
        c.d(b(), false);
        boolean z = true;
        int measuredWidth = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!c(childAt)) {
                if (!z) {
                    measuredWidth += this.b;
                }
                measuredWidth += childAt.getMeasuredWidth();
                z = false;
            }
        }
        return measuredWidth;
    }

    public final View b() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (c(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean c(View view) {
        return view.getId() == this.a && view.getParent() == this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        int paddingStart = getPaddingStart();
        ev evVar = this.c;
        int i5 = ((lv) evVar).c;
        for (int i6 = 0; i6 < i5; i6++) {
            View view = (View) evVar.get(i6);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int paddingTop2 = getPaddingTop() + ((paddingTop - measuredHeight) / 2);
            int i7 = c.b(this) ? ((i3 - i) - paddingStart) - measuredWidth : paddingStart;
            view.layout(i7, paddingTop2, i7 + measuredWidth, measuredHeight + paddingTop2);
            paddingStart += measuredWidth + this.b;
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        boolean z;
        int measuredWidth;
        int i3 = 0;
        while (true) {
            z = true;
            if (i3 >= getChildCount()) {
                break;
            }
            c.d(getChildAt(i3), true);
            i3++;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        measureChildren(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 0), i2);
        int size = View.MeasureSpec.getMode(i) == 0 ? Integer.MAX_VALUE : View.MeasureSpec.getSize(i) - paddingLeft;
        int iA = a();
        if (iA > size && iA > size) {
            View viewB = b();
            if (viewB != null) {
                c.d(viewB, true);
                measuredWidth = viewB.getMeasuredWidth();
            } else {
                measuredWidth = 0;
            }
            int i4 = 0;
            while (i4 < getChildCount()) {
                View childAt = getChildAt(i4);
                if (!c(childAt)) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (!z || viewB != null) {
                        int i5 = this.b;
                        measuredWidth2 += i5;
                    }
                    int i6 = measuredWidth2 + measuredWidth;
                    if (i6 > size) {
                        while (i4 < getChildCount()) {
                            if (!c(getChildAt(i4))) {
                                c.d(getChildAt(i4), false);
                            }
                            i4++;
                        }
                        break;
                    }
                    z = false;
                    measuredWidth = i6;
                }
                i4++;
            }
            iA = measuredWidth;
        }
        int i7 = iA + paddingLeft;
        int iMax = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt2 = getChildAt(i8);
            if (c.c(childAt2)) {
                iMax = Math.max(iMax, childAt2.getMeasuredHeight());
            }
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(i7, getSuggestedMinimumWidth()), i, 0), resolveSizeAndState(Math.max(iMax + paddingTop, getSuggestedMinimumHeight()), i2, 0));
        int i9 = ev.d;
        eq eqVar = new eq();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt3 = getChildAt(i10);
            if (!c(childAt3) && c.c(childAt3)) {
                eqVar.h(childAt3);
            }
        }
        View viewB2 = b();
        if (c.c(viewB2)) {
            eqVar.h(viewB2);
        }
        this.c = eqVar.g();
    }

    public final void setMarginBetweenItems(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        requestLayout();
        invalidate();
    }

    public EllipsizedList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        int i2 = ev.d;
        this.c = lv.a;
        this.a = -2;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.d, i, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.e, 0);
        typedArrayObtainStyledAttributes.recycle();
        setMarginBetweenItems(dimensionPixelSize);
    }
}
