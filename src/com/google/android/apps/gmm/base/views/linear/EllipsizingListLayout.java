package com.google.android.apps.gmm.base.views.linear;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.maps.android.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class EllipsizingListLayout extends ViewGroup {
    private static final j c = j.e("com.google.android.apps.gmm.base.views.linear.EllipsizingListLayout");
    public boolean a;
    public int b;

    public EllipsizingListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = -2;
    }

    public static e a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof f) {
            return ((f) layoutParams).a;
        }
        ((h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(9)).y("View is not a child of an EllipsizingListLayout - %s, view:%s parent:%s", layoutParams != null ? layoutParams.getClass().getName() : BuildConfig.TRAVIS, view, view.getParent());
        return new e();
    }

    private static int b(f fVar, boolean z) {
        int i;
        int i2;
        if (z) {
            i = fVar.leftMargin;
            i2 = fVar.rightMargin;
        } else {
            i = fVar.bottomMargin;
            i2 = fVar.topMargin;
        }
        return i + i2;
    }

    private final int c(boolean z) {
        int paddingTop;
        int paddingBottom;
        if (z) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        return paddingTop + paddingBottom;
    }

    private final int d() {
        return c(this.a);
    }

    private final int e() {
        return c(!this.a);
    }

    private final boolean f(int i, int i2, int i3, View[] viewArr) {
        boolean z;
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        int measuredWidthAndState = 0;
        while (true) {
            if (i4 >= viewArr.length) {
                z = true;
                break;
            }
            View view = viewArr[i4];
            e eVarA = a(view);
            if (com.google.android.libraries.navigation.internal.kj.c.c(view)) {
                f fVar = (f) view.getLayoutParams();
                int iB = b(fVar, this.a);
                int iB2 = b(fVar, !this.a);
                int i6 = (i3 - i5) + 1;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
                int childMeasureSpec = getChildMeasureSpec(i, d() + iB, this.a ? fVar.width : fVar.height);
                int childMeasureSpec2 = getChildMeasureSpec(iMakeMeasureSpec, e() + iB2, this.a ? fVar.height : fVar.width);
                boolean z2 = this.a;
                int i7 = true != z2 ? childMeasureSpec2 : childMeasureSpec;
                if (true == z2) {
                    childMeasureSpec = childMeasureSpec2;
                }
                view.measure(i7, childMeasureSpec);
                int measuredWidth = this.a ? view.getMeasuredWidth() : view.getMeasuredHeight();
                int measuredHeight = (this.a ? view.getMeasuredHeight() : view.getMeasuredWidth()) + iB2;
                if (measuredHeight >= i6) {
                    z = false;
                    break;
                }
                eVarA.d = true;
                i5 += measuredHeight;
                iMax = Math.max(iMax, measuredWidth + iB);
                measuredWidthAndState |= (this.a ? view.getMeasuredWidthAndState() : view.getMeasuredHeightAndState()) & ViewCompat.MEASURED_STATE_MASK;
            }
            i4++;
        }
        int suggestedMinimumWidth = this.a ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight();
        int suggestedMinimumHeight = this.a ? getSuggestedMinimumHeight() : getSuggestedMinimumWidth();
        int iResolveSizeAndState = resolveSizeAndState(Math.max(iMax + d(), suggestedMinimumWidth), i, measuredWidthAndState);
        int iResolveSizeAndState2 = resolveSizeAndState(Math.max(i5 + e(), suggestedMinimumHeight), i2, true != z ? 16777216 : 0);
        boolean z3 = this.a;
        int i8 = true != z3 ? iResolveSizeAndState2 : iResolveSizeAndState;
        if (true == z3) {
            iResolveSizeAndState = iResolveSizeAndState2;
        }
        setMeasuredDimension(i8, iResolveSizeAndState);
        return z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        e eVar;
        int size = arrayList.size();
        super.addFocusables(arrayList, i, i2);
        int i3 = size;
        while (size < arrayList.size()) {
            View view = (View) arrayList.get(size);
            int i4 = 0;
            while (true) {
                eVar = null;
                if (i4 >= 30) {
                    break;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                e eVar2 = layoutParams instanceof f ? ((f) layoutParams).a : null;
                Object parent = view.getParent();
                if (eVar2 != null && parent == this) {
                    eVar = eVar2;
                    break;
                } else {
                    if (!(parent instanceof View) || parent == this) {
                        break;
                    }
                    view = (View) parent;
                    i4++;
                }
            }
            if (eVar != null && eVar.d) {
                if (i3 != size) {
                    arrayList.set(i3, (View) arrayList.get(size));
                }
                i3++;
            }
            size++;
        }
        while (size > i3) {
            size--;
            arrayList.remove(size);
        }
    }

    @Override // android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    @Override // android.view.ViewGroup
    protected final boolean drawChild(Canvas canvas, View view, long j) {
        if (a(view).d) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected final /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.View
    public final boolean hasFocusable() {
        if (super.hasFocusable()) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (a(childAt).d && childAt.hasFocusable() && childAt.isEnabled() && com.google.android.libraries.navigation.internal.kj.c.c(childAt)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zB = com.google.android.libraries.navigation.internal.kj.c.b(this);
        int paddingLeft = !zB ? getPaddingLeft() : getMeasuredWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (a(childAt).d) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (zB) {
                    childAt.layout((paddingLeft - fVar.rightMargin) - measuredWidth, fVar.topMargin + paddingTop, paddingLeft - fVar.rightMargin, fVar.topMargin + paddingTop + measuredHeight);
                } else {
                    childAt.layout(fVar.leftMargin + paddingLeft, fVar.topMargin + paddingTop, fVar.leftMargin + paddingLeft + measuredWidth, fVar.topMargin + paddingTop + measuredHeight);
                }
                if (this.a) {
                    paddingTop += childAt.getMeasuredHeight() + fVar.topMargin + fVar.bottomMargin;
                } else {
                    int measuredWidth2 = childAt.getMeasuredWidth() + fVar.leftMargin + fVar.rightMargin;
                    if (zB) {
                        measuredWidth2 = -measuredWidth2;
                    }
                    paddingLeft += measuredWidth2;
                }
            } else {
                childAt.layout(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            }
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        View[] viewArr = new View[childCount];
        View view = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVarA = a(childAt);
            viewArr[i3] = childAt;
            eVarA.b = i3;
            eVarA.d = false;
            if (childAt.getId() == this.b && childAt.getParent() == this) {
                eVarA.c = Float.MAX_VALUE;
                view = childAt;
            } else {
                eVarA.c = ((f) childAt.getLayoutParams()).weight;
            }
        }
        boolean z = this.a;
        int i4 = true != z ? i2 : i;
        if (true == z) {
            i = i2;
        }
        int iMax = View.MeasureSpec.getMode(i) == 0 ? Integer.MAX_VALUE : Math.max(View.MeasureSpec.getSize(i) - e(), 0);
        Arrays.sort(viewArr, e.a);
        if (view != null) {
            view.setVisibility(8);
        }
        if (!f(i4, i, iMax, viewArr) && view != null) {
            for (int i5 = 0; i5 < childCount; i5++) {
                a(getChildAt(i5)).d = false;
            }
            view.setVisibility(0);
            f(i4, i, iMax, viewArr);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (!a(childAt2).d && com.google.android.libraries.navigation.internal.kj.c.c(childAt2)) {
                childAt2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        a(view).d = false;
    }

    public EllipsizingListLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = -2;
    }

    @Override // android.view.ViewGroup
    protected final /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f(layoutParams);
    }
}
