package com.google.android.apps.gmm.base.views.linear;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.libraries.navigation.internal.ms.bk;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class GmmLinearLayout extends LinearLayout {
    private boolean a;
    private g[] b;

    public GmmLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static boolean a(View view) {
        return (view == null || view.getVisibility() == 8 || (view instanceof bk)) ? false : true;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (this.a && getOrientation() == 0 && com.google.android.libraries.navigation.internal.kj.c.b(this)) {
            int showDividers = getShowDividers();
            if ((showDividers & 6) == 0) {
                return false;
            }
            for (int i2 = i + 1; i2 < getChildCount(); i2++) {
                if (!a(getChildAt(i2))) {
                }
            }
            return (showDividers & 4) != 0;
        }
        int showDividers2 = getShowDividers();
        if (i == 0) {
            return (showDividers2 & 1) != 0;
        }
        if (i == getChildCount()) {
            return (showDividers2 & 4) != 0;
        }
        if ((showDividers2 & 2) == 0) {
            return false;
        }
        do {
            i--;
            if (i < 0) {
                return false;
            }
        } while (!a(getChildAt(i)));
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a = true;
        try {
            super.onLayout(z, i, i2, i3, i4);
        } finally {
            this.a = false;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        int length;
        super.onMeasure(i, i2);
        g[] gVarArr = this.b;
        this.b = null;
        if (getShowDividers() == 0) {
            return;
        }
        int orientation = getOrientation();
        Drawable dividerDrawable = getDividerDrawable();
        if (orientation == 0) {
            if (dividerDrawable.getIntrinsicWidth() == 0) {
                return;
            }
        } else if (orientation == 1 && dividerDrawable.getIntrinsicHeight() == 0) {
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (a(childAt) && ((LinearLayout.LayoutParams) childAt.getLayoutParams()).weight != 0.0f) {
                int childCount = getChildCount();
                if (gVarArr == null) {
                    gVarArr = new g[childCount];
                    length = 0;
                } else {
                    length = gVarArr.length;
                    if (length != childCount) {
                        gVarArr = (g[]) Arrays.copyOf(gVarArr, childCount);
                    }
                }
                while (length < childCount) {
                    gVarArr[length] = new g();
                    length++;
                }
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = getChildAt(i4);
                    g gVar = gVarArr[i4];
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
                    gVar.a = layoutParams.weight;
                    gVar.b = layoutParams.width;
                    gVar.c = layoutParams.height;
                    layoutParams.weight = 0.0f;
                    layoutParams.width = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredWidth(), 1073741824);
                    layoutParams.height = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                }
                super.onMeasure(i, i2);
                for (int i5 = 0; i5 < childCount; i5++) {
                    g gVar2 = gVarArr[i5];
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                    layoutParams2.weight = gVar2.a;
                    layoutParams2.width = gVar2.b;
                    layoutParams2.height = gVar2.c;
                }
                this.b = gVarArr;
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        int layoutDirection = getLayoutDirection();
        super.onRtlPropertiesChanged(i);
        if (i == layoutDirection || getOrientation() == 0) {
            return;
        }
        requestLayout();
    }

    public GmmLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
