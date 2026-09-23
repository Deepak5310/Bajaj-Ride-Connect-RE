package com.google.android.libraries.geo.navcore.turncard.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.libraries.navigation.internal.gz.i;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class FlexibleVerticalPriorityLayout extends LinearLayout {
    private final TreeMap a;

    public FlexibleVerticalPriorityLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new TreeMap();
        b(context);
    }

    private final void b(Context context) {
        setLayoutDirection(i.a(context) ? 1 : 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        this.a.clear();
        int measuredHeight = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                TreeMap treeMap = this.a;
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                treeMap.put(Integer.valueOf(layoutParams instanceof a ? ((a) layoutParams).a : Integer.MAX_VALUE), childAt);
            }
        }
        for (View view : this.a.values()) {
            if (view.getLayoutParams().width == -1) {
                i = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 1073741824);
            }
            measureChild(view, i, View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE));
            size -= view.getMeasuredHeight();
            measuredHeight += view.getMeasuredHeight();
        }
        setMeasuredDimension(i, View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public FlexibleVerticalPriorityLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new TreeMap();
        b(context);
    }
}
