package com.h6ah4i.android.widget.advrecyclerview.animator;

import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAddAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemMoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager;

/* JADX INFO: loaded from: classes6.dex */
public abstract class GeneralItemAnimator extends BaseItemAnimator {
    private static final String TAG = "ARVGeneralItemAnimator";
    private ItemAddAnimationManager mAddAnimationsManager;
    private ItemChangeAnimationManager mChangeAnimationsManager;
    private boolean mDebug;
    private ItemMoveAnimationManager mMoveAnimationsManager;
    private ItemRemoveAnimationManager mRemoveAnimationManager;

    protected abstract void onSetup();

    protected GeneralItemAnimator() {
        setup();
    }

    private void setup() {
        onSetup();
        if (this.mRemoveAnimationManager == null || this.mAddAnimationsManager == null || this.mChangeAnimationsManager == null || this.mMoveAnimationsManager == null) {
            throw new IllegalStateException("setup incomplete");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        if (hasPendingAnimations()) {
            onSchedulePendingAnimations();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        if (this.mDebug) {
            Log.d(TAG, "animateRemove(id = " + viewHolder.getItemId() + ", position = " + viewHolder.getLayoutPosition() + ")");
        }
        return this.mRemoveAnimationManager.addPendingAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        if (this.mDebug) {
            Log.d(TAG, "animateAdd(id = " + viewHolder.getItemId() + ", position = " + viewHolder.getLayoutPosition() + ")");
        }
        return this.mAddAnimationsManager.addPendingAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        if (this.mDebug) {
            Log.d(TAG, "animateMove(id = " + viewHolder.getItemId() + ", position = " + viewHolder.getLayoutPosition() + ", fromX = " + i + ", fromY = " + i2 + ", toX = " + i3 + ", toY = " + i4 + ")");
        }
        return this.mMoveAnimationsManager.addPendingAnimation(viewHolder, i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        String string;
        String string2;
        if (viewHolder == viewHolder2) {
            return this.mMoveAnimationsManager.addPendingAnimation(viewHolder, i, i2, i3, i4);
        }
        if (this.mDebug) {
            String string3 = "-";
            String string4 = viewHolder != null ? Long.toString(viewHolder.getItemId()) : "-";
            if (viewHolder == null) {
                string = "-";
            } else {
                string = Long.toString(viewHolder.getLayoutPosition());
            }
            if (viewHolder2 == null) {
                string2 = "-";
            } else {
                string2 = Long.toString(viewHolder2.getItemId());
            }
            if (viewHolder2 != null) {
                string3 = Long.toString(viewHolder2.getLayoutPosition());
            }
            Log.d(TAG, "animateChange(old.id = " + string4 + ", old.position = " + string + ", new.id = " + string2 + ", new.position = " + string3 + ", fromX = " + i + ", fromY = " + i2 + ", toX = " + i3 + ", toY = " + i4 + ")");
        }
        return this.mChangeAnimationsManager.addPendingAnimation(viewHolder, viewHolder2, i, i2, i3, i4);
    }

    protected void cancelAnimations(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.animate(viewHolder.itemView).cancel();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        cancelAnimations(viewHolder);
        this.mMoveAnimationsManager.endPendingAnimations(viewHolder);
        this.mChangeAnimationsManager.endPendingAnimations(viewHolder);
        this.mRemoveAnimationManager.endPendingAnimations(viewHolder);
        this.mAddAnimationsManager.endPendingAnimations(viewHolder);
        this.mMoveAnimationsManager.endDeferredReadyAnimations(viewHolder);
        this.mChangeAnimationsManager.endDeferredReadyAnimations(viewHolder);
        this.mRemoveAnimationManager.endDeferredReadyAnimations(viewHolder);
        this.mAddAnimationsManager.endDeferredReadyAnimations(viewHolder);
        if (this.mRemoveAnimationManager.removeFromActive(viewHolder) && this.mDebug) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [remove]");
        }
        if (this.mAddAnimationsManager.removeFromActive(viewHolder) && this.mDebug) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [add]");
        }
        if (this.mChangeAnimationsManager.removeFromActive(viewHolder) && this.mDebug) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [change]");
        }
        if (this.mMoveAnimationsManager.removeFromActive(viewHolder) && this.mDebug) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [move]");
        }
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return this.mRemoveAnimationManager.isRunning() || this.mAddAnimationsManager.isRunning() || this.mChangeAnimationsManager.isRunning() || this.mMoveAnimationsManager.isRunning();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        this.mMoveAnimationsManager.endAllPendingAnimations();
        this.mRemoveAnimationManager.endAllPendingAnimations();
        this.mAddAnimationsManager.endAllPendingAnimations();
        this.mChangeAnimationsManager.endAllPendingAnimations();
        if (isRunning()) {
            this.mMoveAnimationsManager.endAllDeferredReadyAnimations();
            this.mAddAnimationsManager.endAllDeferredReadyAnimations();
            this.mChangeAnimationsManager.endAllDeferredReadyAnimations();
            this.mRemoveAnimationManager.cancelAllStartedAnimations();
            this.mMoveAnimationsManager.cancelAllStartedAnimations();
            this.mAddAnimationsManager.cancelAllStartedAnimations();
            this.mChangeAnimationsManager.cancelAllStartedAnimations();
            dispatchAnimationsFinished();
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator
    public boolean debugLogEnabled() {
        return this.mDebug;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator
    public boolean dispatchFinishedWhenDone() {
        if (this.mDebug && !isRunning()) {
            Log.d(TAG, "dispatchFinishedWhenDone()");
        }
        return super.dispatchFinishedWhenDone();
    }

    protected boolean hasPendingAnimations() {
        return this.mRemoveAnimationManager.hasPending() || this.mMoveAnimationsManager.hasPending() || this.mChangeAnimationsManager.hasPending() || this.mAddAnimationsManager.hasPending();
    }

    protected ItemRemoveAnimationManager getRemoveAnimationManager() {
        return this.mRemoveAnimationManager;
    }

    protected void setItemRemoveAnimationManager(ItemRemoveAnimationManager itemRemoveAnimationManager) {
        this.mRemoveAnimationManager = itemRemoveAnimationManager;
    }

    protected ItemAddAnimationManager getItemAddAnimationsManager() {
        return this.mAddAnimationsManager;
    }

    protected void setItemAddAnimationsManager(ItemAddAnimationManager itemAddAnimationManager) {
        this.mAddAnimationsManager = itemAddAnimationManager;
    }

    protected ItemChangeAnimationManager getItemChangeAnimationsManager() {
        return this.mChangeAnimationsManager;
    }

    protected void setItemChangeAnimationsManager(ItemChangeAnimationManager itemChangeAnimationManager) {
        this.mChangeAnimationsManager = itemChangeAnimationManager;
    }

    protected ItemMoveAnimationManager getItemMoveAnimationsManager() {
        return this.mMoveAnimationsManager;
    }

    protected void setItemMoveAnimationsManager(ItemMoveAnimationManager itemMoveAnimationManager) {
        this.mMoveAnimationsManager = itemMoveAnimationManager;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    protected void onSchedulePendingAnimations() {
        schedulePendingAnimationsByDefaultRule();
    }

    protected void schedulePendingAnimationsByDefaultRule() {
        boolean zHasPending = this.mRemoveAnimationManager.hasPending();
        boolean zHasPending2 = this.mMoveAnimationsManager.hasPending();
        boolean zHasPending3 = this.mChangeAnimationsManager.hasPending();
        boolean zHasPending4 = this.mAddAnimationsManager.hasPending();
        long removeDuration = zHasPending ? getRemoveDuration() : 0L;
        long moveDuration = zHasPending2 ? getMoveDuration() : 0L;
        long changeDuration = zHasPending3 ? getChangeDuration() : 0L;
        if (zHasPending) {
            this.mRemoveAnimationManager.runPendingAnimations(false, 0L);
        }
        if (zHasPending2) {
            this.mMoveAnimationsManager.runPendingAnimations(zHasPending, removeDuration);
        }
        if (zHasPending3) {
            this.mChangeAnimationsManager.runPendingAnimations(zHasPending, removeDuration);
        }
        if (zHasPending4) {
            boolean z = zHasPending || zHasPending2 || zHasPending3;
            this.mAddAnimationsManager.runPendingAnimations(z, z ? removeDuration + Math.max(moveDuration, changeDuration) : 0L);
        }
    }
}
