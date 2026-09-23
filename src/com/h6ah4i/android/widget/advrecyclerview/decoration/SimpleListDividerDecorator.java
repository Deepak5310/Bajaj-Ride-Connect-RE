package com.h6ah4i.android.widget.advrecyclerview.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleListDividerDecorator extends RecyclerView.ItemDecoration {
    private final int mHorizontalDividerHeight;
    private final Drawable mHorizontalDrawable;
    private final boolean mOverlap;
    private final int mVerticalDividerWidth;
    private final Drawable mVerticalDrawable;

    public SimpleListDividerDecorator(Drawable drawable, boolean z) {
        this(drawable, null, z);
    }

    public SimpleListDividerDecorator(Drawable drawable, Drawable drawable2, boolean z) {
        this.mHorizontalDrawable = drawable;
        this.mVerticalDrawable = drawable2;
        this.mHorizontalDividerHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        this.mVerticalDividerWidth = drawable2 != null ? drawable2.getIntrinsicWidth() : 0;
        this.mOverlap = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        if (childCount == 0) {
            return;
        }
        boolean z = this.mOverlap;
        float f = 1.0f;
        float f2 = z ? 1.0f : this.mVerticalDividerWidth + 1.0f;
        float f3 = z ? 1.0f : this.mHorizontalDividerHeight + 1.0f;
        int i = 0;
        while (i < childCount - 1) {
            View childAt = recyclerView.getChildAt(i);
            i++;
            View childAt2 = recyclerView.getChildAt(i);
            if (childAt.getVisibility() == 0 && childAt2.getVisibility() == 0) {
                float bottom = childAt.getBottom() + childAt.getTranslationY();
                float top = childAt2.getTop() + childAt2.getTranslationY();
                float right = childAt.getRight() + childAt.getTranslationX();
                float left = childAt2.getLeft() + childAt2.getTranslationX();
                if ((this.mHorizontalDividerHeight != 0 && Math.abs(top - bottom) < f3) || (this.mVerticalDividerWidth != 0 && Math.abs(left - right) < f2)) {
                    if (Math.abs((ViewCompat.getTranslationZ(childAt2) + ViewCompat.getElevation(childAt2)) - (ViewCompat.getTranslationZ(childAt) + ViewCompat.getElevation(childAt))) < f) {
                        float alpha = childAt.getAlpha();
                        float alpha2 = childAt2.getAlpha();
                        int translationX = (int) (childAt.getTranslationX() + 0.5f);
                        int translationY = (int) (childAt.getTranslationY() + 0.5f);
                        if (this.mHorizontalDividerHeight != 0) {
                            int left2 = childAt.getLeft();
                            int right2 = childAt.getRight();
                            int bottom2 = childAt.getBottom() - (this.mOverlap ? this.mHorizontalDividerHeight : 0);
                            int i2 = bottom2 + this.mHorizontalDividerHeight;
                            this.mHorizontalDrawable.setAlpha((int) (((alpha + alpha2) * 127.5f) + 0.5f));
                            this.mHorizontalDrawable.setBounds(left2 + translationX, bottom2 + translationY, right2 + translationX, i2 + translationY);
                            this.mHorizontalDrawable.draw(canvas);
                        }
                        if (this.mVerticalDividerWidth != 0) {
                            int right3 = childAt.getRight() - (this.mOverlap ? this.mVerticalDividerWidth : 0);
                            int i3 = this.mVerticalDividerWidth + right3;
                            int top2 = childAt.getTop();
                            int bottom3 = childAt.getBottom();
                            this.mVerticalDrawable.setAlpha((int) (((alpha + alpha2) * 127.5f) + 0.5f));
                            this.mVerticalDrawable.setBounds(right3 + translationX, top2 + translationY, i3 + translationX, bottom3 + translationY);
                            this.mVerticalDrawable.draw(canvas);
                        }
                    }
                }
            }
            f = 1.0f;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mOverlap) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, 0, this.mVerticalDividerWidth, this.mHorizontalDividerHeight);
        }
    }
}
