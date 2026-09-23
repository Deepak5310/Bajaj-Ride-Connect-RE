package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemState;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSwipeableItemViewHolder extends RecyclerView.ViewHolder implements SwipeableItemViewHolder {
    private int mAfterSwipeReaction;
    private float mHorizontalSwipeAmount;
    private boolean mIsProportionalAmountModeEnabled;
    private float mMaxDownSwipeAmount;
    private float mMaxLeftSwipeAmount;
    private float mMaxRightSwipeAmount;
    private float mMaxUpSwipeAmount;
    private int mSwipeResult;
    private SwipeableItemState mSwipeState;
    private float mVerticalSwipeAmount;

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public abstract View getSwipeableContainerView();

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void onSlideAmountUpdated(float f, float f2, boolean z) {
    }

    public AbstractSwipeableItemViewHolder(View view) {
        super(view);
        this.mSwipeState = new SwipeableItemState();
        this.mSwipeResult = 0;
        this.mAfterSwipeReaction = 0;
        this.mIsProportionalAmountModeEnabled = true;
        this.mMaxLeftSwipeAmount = -65536.0f;
        this.mMaxUpSwipeAmount = -65537.0f;
        this.mMaxRightSwipeAmount = 65536.0f;
        this.mMaxDownSwipeAmount = 65537.0f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeStateFlags(int i) {
        this.mSwipeState.setFlags(i);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public int getSwipeStateFlags() {
        return this.mSwipeState.getFlags();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public SwipeableItemState getSwipeState() {
        return this.mSwipeState;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeResult(int i) {
        this.mSwipeResult = i;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public int getSwipeResult() {
        return this.mSwipeResult;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public int getAfterSwipeReaction() {
        return this.mAfterSwipeReaction;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setAfterSwipeReaction(int i) {
        this.mAfterSwipeReaction = i;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setProportionalSwipeAmountModeEnabled(boolean z) {
        this.mIsProportionalAmountModeEnabled = z;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public boolean isProportionalSwipeAmountModeEnabled() {
        return this.mIsProportionalAmountModeEnabled;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeItemVerticalSlideAmount(float f) {
        this.mVerticalSwipeAmount = f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getSwipeItemVerticalSlideAmount() {
        return this.mVerticalSwipeAmount;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setSwipeItemHorizontalSlideAmount(float f) {
        this.mHorizontalSwipeAmount = f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getSwipeItemHorizontalSlideAmount() {
        return this.mHorizontalSwipeAmount;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxLeftSwipeAmount(float f) {
        this.mMaxLeftSwipeAmount = f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxLeftSwipeAmount() {
        return this.mMaxLeftSwipeAmount;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxUpSwipeAmount(float f) {
        this.mMaxUpSwipeAmount = f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxUpSwipeAmount() {
        return this.mMaxUpSwipeAmount;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxRightSwipeAmount(float f) {
        this.mMaxRightSwipeAmount = f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxRightSwipeAmount() {
        return this.mMaxRightSwipeAmount;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public void setMaxDownSwipeAmount(float f) {
        this.mMaxDownSwipeAmount = f;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder
    public float getMaxDownSwipeAmount() {
        return this.mMaxDownSwipeAmount;
    }
}
