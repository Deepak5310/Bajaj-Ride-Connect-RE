package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemAddAnimationManager extends BaseItemAnimationManager<AddAnimationInfo> {
    private static final String TAG = "ARVItemAddAnimMgr";

    public abstract boolean addPendingAnimation(RecyclerView.ViewHolder viewHolder);

    public ItemAddAnimationManager(BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public long getDuration() {
        return this.mItemAnimator.getAddDuration();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void setDuration(long j) {
        this.mItemAnimator.setAddDuration(j);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchStarting(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (debugLogEnabled()) {
            Log.d(TAG, "dispatchAddStarting(" + viewHolder + ")");
        }
        this.mItemAnimator.dispatchAddStarting(viewHolder);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchFinished(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (debugLogEnabled()) {
            Log.d(TAG, "dispatchAddFinished(" + viewHolder + ")");
        }
        this.mItemAnimator.dispatchAddFinished(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public boolean endNotStartedAnimation(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (addAnimationInfo.holder == null) {
            return false;
        }
        if (viewHolder != null && addAnimationInfo.holder != viewHolder) {
            return false;
        }
        onAnimationEndedBeforeStarted(addAnimationInfo, addAnimationInfo.holder);
        dispatchFinished(addAnimationInfo, addAnimationInfo.holder);
        addAnimationInfo.clear(addAnimationInfo.holder);
        return true;
    }
}
