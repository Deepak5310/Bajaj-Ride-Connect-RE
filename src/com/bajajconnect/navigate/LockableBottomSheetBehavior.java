package com.bajajconnect.navigate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class LockableBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    private boolean mLocked;

    public LockableBottomSheetBehavior() {
        this.mLocked = false;
    }

    public LockableBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLocked = false;
    }

    public void setLocked(boolean z) {
        this.mLocked = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mLocked) {
            return false;
        }
        return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mLocked) {
            return false;
        }
        return super.onTouchEvent(coordinatorLayout, v, motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        if (this.mLocked) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (this.mLocked) {
            return;
        }
        super.onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        if (this.mLocked) {
            return;
        }
        super.onStopNestedScroll(coordinatorLayout, v, view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        if (this.mLocked) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
    }
}
