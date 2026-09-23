package com.google.android.apps.gmm.base.views.linear;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class ClippingLinearLayout extends GmmLinearLayout {
    public static final int a = com.google.android.libraries.navigation.internal.f.e.d;
    private static final int b = com.google.android.libraries.navigation.internal.f.e.f;
    private final HashSet c;
    private final ArrayList d;

    public ClippingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new HashSet();
        this.d = new ArrayList();
    }

    public static boolean a(View view) {
        Boolean bool = (Boolean) view.getTag(a);
        return bool != null && bool.booleanValue();
    }

    private static boolean c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return (layoutParams instanceof b) && ((b) layoutParams).a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        super.addFocusables(arrayList, i, i2);
        while (size < arrayList.size()) {
            View view = (View) arrayList.get(size);
            int i3 = 0;
            while (true) {
                if (i3 < 30) {
                    Object parent = view.getParent();
                    if (view != null && parent == this) {
                        break;
                    }
                    if ((parent instanceof View) && parent != this) {
                        view = (View) parent;
                        i3++;
                    }
                }
                view = null;
                break;
            }
            if (view != null && !b(view) && view.getParent() == this) {
                arrayList.remove(size);
                size--;
            }
            size++;
        }
    }

    final boolean b(View view) {
        return !this.c.contains(view);
    }

    @Override // android.view.ViewGroup
    protected final boolean drawChild(Canvas canvas, View view, long j) {
        if (b(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.View
    public final boolean hasFocusable() {
        if (super.hasFocusable()) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (b(childAt) && childAt.hasFocusable() && childAt.isEnabled() && com.google.android.libraries.navigation.internal.kj.c.c(childAt)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.apps.gmm.base.views.linear.GmmLinearLayout, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c.clear();
        int measuredWidth = getMeasuredWidth();
        int childCount = getChildCount();
        View view = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && !c(childAt)) {
                int i6 = b;
                childAt.setTag(i6, false);
                if (a(childAt)) {
                    int i7 = childAt.getLayoutParams().width;
                    int i8 = childAt.getLayoutParams().height;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, i7 >= 0 ? 1073741824 : 0), View.MeasureSpec.makeMeasureSpec(i8, i8 < 0 ? 0 : 1073741824));
                }
                int measuredWidth2 = childAt.getMeasuredWidth();
                if (childAt.getRight() - measuredWidth2 >= 0 && childAt.getLeft() + measuredWidth2 <= measuredWidth) {
                    view = childAt;
                } else if (a(childAt)) {
                    this.c.add(childAt);
                    childAt.setTag(i6, true);
                }
            }
        }
        this.d.clear();
        ArrayList arrayList = this.d;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt2 = getChildAt(i9);
            if (c(childAt2)) {
                arrayList.add(childAt2);
            }
        }
        ArrayList arrayList2 = this.d;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) arrayList2.get(i10);
            if (view == null) {
                this.c.add(view2);
            } else {
                view2.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
    }
}
