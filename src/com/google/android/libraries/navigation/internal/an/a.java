package com.google.android.libraries.navigation.internal.an;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends RecyclerView.LayoutManager {
    public int a = 0;
    public OrientationHelper b = OrientationHelper.createOrientationHelper(this, 0);
    private int d = 0;
    public int c = 0;

    private final int a(View view, int i, boolean z) {
        int width;
        int height;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(view) + layoutParams2.topMargin + layoutParams2.bottomMargin;
        if (this.a == 0) {
            height = ((((getHeight() - getPaddingTop()) - getPaddingBottom()) - decoratedMeasuredHeight) / 2) + getPaddingTop();
            width = 0;
        } else {
            width = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - decoratedMeasuredWidth) / 2) + getPaddingLeft();
            height = 0;
        }
        int decoratedMeasurement = this.b.getDecoratedMeasurement(view);
        layoutDecoratedWithMargins(view, width, height, width + decoratedMeasuredWidth, height + decoratedMeasuredHeight);
        if (!z) {
            this.b.offsetChild(view, i);
            return i + decoratedMeasurement;
        }
        int i2 = i - decoratedMeasurement;
        this.b.offsetChild(view, i2);
        return i2;
    }

    private final int b(int i, RecyclerView.Recycler recycler) {
        if (getChildCount() == 0) {
            return 0;
        }
        int i2 = this.c;
        int i3 = i2 - i;
        if (i >= 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (getPosition(childAt) == getItemCount() - 1) {
                int decoratedEnd = this.b.getDecoratedEnd(childAt);
                int i4 = decoratedEnd - i;
                int end = this.b.getEnd();
                if (decoratedEnd <= end) {
                    i = 0;
                } else if (i4 <= end) {
                    i = decoratedEnd - end;
                }
            }
        } else if (this.d == 0 && i3 >= 0) {
            i = i2;
        }
        this.b.offsetChildren(-i);
        this.c -= i;
        d(recycler);
        return i;
    }

    private final void c(RecyclerView.Recycler recycler, int i, int i2, boolean z) {
        int end = this.b.getEnd();
        while (i >= 0 && i < getItemCount()) {
            if (z && i2 <= 0) {
                return;
            }
            if (!z && i2 >= end) {
                return;
            }
            View viewForPosition = recycler.getViewForPosition(i);
            measureChildWithMargins(viewForPosition, 0, 0);
            if (z) {
                addView(viewForPosition, 0);
            } else {
                addView(viewForPosition);
            }
            i2 = a(viewForPosition, i2, z);
            i = z ? i - 1 : i + 1;
        }
    }

    private final void d(RecyclerView.Recycler recycler) {
        if (getChildCount() == 0) {
            c(recycler, this.d, this.c, false);
            c(recycler, this.d - 1, this.c, true);
            View childAt = getChildAt(0);
            int endAfterPadding = this.b.getEndAfterPadding() - this.b.getDecoratedEnd(getChildAt(getChildCount() - 1));
            if (endAfterPadding > 0) {
                int decoratedStart = this.b.getDecoratedStart(childAt);
                int i = 0;
                for (int position = getPosition(getChildAt(0)) - 1; position >= 0 && endAfterPadding > i; position--) {
                    View viewForPosition = recycler.getViewForPosition(position);
                    addView(viewForPosition, 0);
                    measureChildWithMargins(viewForPosition, 0, 0);
                    int decoratedMeasurement = this.b.getDecoratedMeasurement(viewForPosition);
                    decoratedStart -= decoratedMeasurement;
                    a(viewForPosition, decoratedStart, false);
                    i += decoratedMeasurement;
                }
                this.b.offsetChildren(Math.min(endAfterPadding, i));
            }
        } else {
            View childAt2 = getChildAt(0);
            View childAt3 = getChildAt(getChildCount() - 1);
            int decoratedStart2 = this.b.getDecoratedStart(childAt2);
            c(recycler, getPosition(childAt3) + 1, this.b.getDecoratedEnd(childAt3), false);
            c(recycler, getPosition(childAt2) - 1, decoratedStart2, true);
        }
        int end = this.b.getEnd();
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            View childAt4 = getChildAt(childCount);
            int decoratedStart3 = this.b.getDecoratedStart(childAt4);
            int decoratedEnd = this.b.getDecoratedEnd(childAt4);
            if (decoratedStart3 >= end || decoratedEnd <= 0) {
                detachViewAt(childCount);
                recycler.recycleView(childAt4);
            }
        }
        if (getChildCount() == 0) {
            this.d = 0;
            this.c = 0;
        } else {
            this.d = getPosition(getChildAt(0));
            this.c = this.b.getDecoratedStart(getChildAt(0));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return this.a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return this.a == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChildWithMargins(View view, int i, int i2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(getWidth(), 1073741824, layoutParams.leftMargin + layoutParams.rightMargin + getPaddingLeft() + getPaddingRight(), layoutParams.width, false), getChildMeasureSpec(getHeight(), 1073741824, layoutParams.topMargin + layoutParams.bottomMargin + getPaddingTop() + getPaddingBottom(), layoutParams.height, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int itemCount = getItemCount();
        if (itemCount <= 1) {
            this.d = 0;
        } else if (this.d >= itemCount) {
            this.d = itemCount - 1;
        }
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
        } else {
            detachAndScrapAttachedViews(recycler);
            d(recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return b(i, recycler);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i) {
        if (i < 0 || i >= getItemCount()) {
            getItemCount();
            return;
        }
        this.d = i;
        this.c = 0;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return b(i, recycler);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
