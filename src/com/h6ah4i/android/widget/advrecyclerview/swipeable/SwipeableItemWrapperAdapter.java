package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class SwipeableItemWrapperAdapter<VH extends RecyclerView.ViewHolder> extends SimpleWrapperAdapter<VH> {
    private static final boolean LOCAL_LOGD = false;
    private static final boolean LOCAL_LOGV = false;
    private static final int STATE_FLAG_INITIAL_VALUE = -1;
    private static final String TAG = "ARVSwipeableWrapper";
    private boolean mCallingSwipeStarted;
    private RecyclerViewSwipeManager mSwipeManager;
    private SwipeableItemAdapter mSwipeableItemAdapter;
    private long mSwipingItemId;

    private interface Constants extends SwipeableItemConstants {
    }

    private static boolean checkInRange(int i, int i2, int i3) {
        return i >= i2 && i < i2 + i3;
    }

    private static float getSwipeAmountFromAfterReaction(int i, int i2) {
        if (i2 != 1 && i2 != 2) {
            return 0.0f;
        }
        if (i == 2) {
            return -65536.0f;
        }
        if (i == 3) {
            return -65537.0f;
        }
        if (i != 4) {
            return i != 5 ? 0.0f : 65537.0f;
        }
        return 65536.0f;
    }

    public SwipeableItemWrapperAdapter(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.Adapter<VH> adapter) {
        super(adapter);
        this.mSwipingItemId = -1L;
        SwipeableItemAdapter swipeableItemAdapter = (SwipeableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(adapter, SwipeableItemAdapter.class);
        this.mSwipeableItemAdapter = swipeableItemAdapter;
        if (swipeableItemAdapter == null) {
            throw new IllegalArgumentException("adapter does not implement SwipeableItemAdapter");
        }
        if (recyclerViewSwipeManager == null) {
            throw new IllegalArgumentException("manager cannot be null");
        }
        this.mSwipeManager = recyclerViewSwipeManager;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onRelease() {
        super.onRelease();
        this.mSwipeableItemAdapter = null;
        this.mSwipeManager = null;
        this.mSwipingItemId = -1L;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(VH vh, int i) {
        super.onViewRecycled(vh, i);
        long j = this.mSwipingItemId;
        if (j != -1 && j == vh.getItemId()) {
            this.mSwipeManager.cancelSwipe();
        }
        if (vh instanceof SwipeableItemViewHolder) {
            RecyclerViewSwipeManager recyclerViewSwipeManager = this.mSwipeManager;
            if (recyclerViewSwipeManager != null) {
                recyclerViewSwipeManager.cancelPendingAnimations(vh);
            }
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) vh;
            swipeableItemViewHolder.setSwipeResult(0);
            swipeableItemViewHolder.setAfterSwipeReaction(0);
            swipeableItemViewHolder.setSwipeItemHorizontalSlideAmount(0.0f);
            swipeableItemViewHolder.setSwipeItemVerticalSlideAmount(0.0f);
            swipeableItemViewHolder.setProportionalSwipeAmountModeEnabled(true);
            View swipeableContainerView = SwipeableViewHolderUtils.getSwipeableContainerView(swipeableItemViewHolder);
            if (swipeableContainerView != null) {
                ViewCompat.animate(swipeableContainerView).cancel();
                swipeableContainerView.setTranslationX(0.0f);
                swipeableContainerView.setTranslationY(0.0f);
            }
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        VH vh = (VH) super.onCreateViewHolder(viewGroup, i);
        if (vh instanceof SwipeableItemViewHolder) {
            ((SwipeableItemViewHolder) vh).setSwipeStateFlags(-1);
        }
        return vh;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        SwipeableItemViewHolder swipeableItemViewHolder = vh instanceof SwipeableItemViewHolder ? (SwipeableItemViewHolder) vh : null;
        float swipeItemSlideAmount = swipeableItemViewHolder != null ? getSwipeItemSlideAmount((SwipeableItemViewHolder) vh, swipeHorizontal()) : 0.0f;
        if (isSwiping()) {
            safeUpdateFlags(vh, vh.getItemId() == this.mSwipingItemId ? 3 : 1);
            super.onBindViewHolder(vh, i, list);
        } else {
            safeUpdateFlags(vh, 0);
            super.onBindViewHolder(vh, i, list);
        }
        if (swipeableItemViewHolder != null) {
            float swipeItemSlideAmount2 = getSwipeItemSlideAmount(swipeableItemViewHolder, swipeHorizontal());
            boolean zIsProportionalSwipeAmountModeEnabled = swipeableItemViewHolder.isProportionalSwipeAmountModeEnabled();
            boolean zIsSwiping = this.mSwipeManager.isSwiping();
            boolean zIsAnimationRunning = this.mSwipeManager.isAnimationRunning(vh);
            if (swipeItemSlideAmount == swipeItemSlideAmount2 && (zIsSwiping || zIsAnimationRunning)) {
                return;
            }
            this.mSwipeManager.applySlideItem(vh, i, swipeItemSlideAmount, swipeItemSlideAmount2, zIsProportionalSwipeAmountModeEnabled, swipeHorizontal(), true, zIsSwiping);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterChanged() {
        if (isSwiping() && !this.mCallingSwipeStarted) {
            cancelSwipe();
        }
        super.onHandleWrappedAdapterChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeChanged(int i, int i2) {
        super.onHandleWrappedAdapterItemRangeChanged(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeChanged(int i, int i2, Object obj) {
        super.onHandleWrappedAdapterItemRangeChanged(i, i2, obj);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeInserted(int i, int i2) {
        int swipingItemPosition;
        if (isSwiping() && (swipingItemPosition = this.mSwipeManager.getSwipingItemPosition()) >= i) {
            this.mSwipeManager.syncSwipingItemPosition(swipingItemPosition + i2);
        }
        super.onHandleWrappedAdapterItemRangeInserted(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeRemoved(int i, int i2) {
        if (isSwiping()) {
            int swipingItemPosition = this.mSwipeManager.getSwipingItemPosition();
            if (checkInRange(swipingItemPosition, i, i2)) {
                cancelSwipe();
            } else if (i < swipingItemPosition) {
                this.mSwipeManager.syncSwipingItemPosition(swipingItemPosition - i2);
            }
        }
        super.onHandleWrappedAdapterItemRangeRemoved(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterRangeMoved(int i, int i2, int i3) {
        if (isSwiping()) {
            this.mSwipeManager.syncSwipingItemPosition();
        }
        super.onHandleWrappedAdapterRangeMoved(i, i2, i3);
    }

    private void cancelSwipe() {
        RecyclerViewSwipeManager recyclerViewSwipeManager = this.mSwipeManager;
        if (recyclerViewSwipeManager != null) {
            recyclerViewSwipeManager.cancelSwipe();
        }
    }

    int getSwipeReactionType(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
        return this.mSwipeableItemAdapter.onGetSwipeReactionType(viewHolder, i, i2, i3);
    }

    void onUpdateSlideAmount(RecyclerView.ViewHolder viewHolder, int i, float f, boolean z, boolean z2, boolean z3, int i2) {
        this.mSwipeableItemAdapter.onSetSwipeBackground(viewHolder, i, i2);
        onUpdateSlideAmount(viewHolder, i, f, z, z2, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void onUpdateSlideAmount(RecyclerView.ViewHolder viewHolder, int i, float f, boolean z, boolean z2, boolean z3) {
        SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
        float fAdaptAmount = RecyclerViewSwipeManager.adaptAmount(swipeableItemViewHolder, z2, f, z, swipeableItemViewHolder.isProportionalSwipeAmountModeEnabled());
        float f2 = z2 ? fAdaptAmount : 0.0f;
        if (z2) {
            fAdaptAmount = 0.0f;
        }
        swipeableItemViewHolder.onSlideAmountUpdated(f2, fAdaptAmount, z3);
    }

    void onSwipeItemStarted(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.ViewHolder viewHolder, int i, long j) {
        this.mSwipingItemId = j;
        this.mCallingSwipeStarted = true;
        this.mSwipeableItemAdapter.onSwipeItemStarted(viewHolder, i);
        this.mCallingSwipeStarted = false;
    }

    SwipeResultAction onSwipeItemFinished(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        this.mSwipingItemId = -1L;
        return this.mSwipeableItemAdapter.onSwipeItem(viewHolder, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void onSwipeItemFinished2(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, SwipeResultAction swipeResultAction) {
        SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
        swipeableItemViewHolder.setSwipeResult(i2);
        swipeableItemViewHolder.setAfterSwipeReaction(i3);
        if (i3 != 3) {
            setSwipeItemSlideAmount(swipeableItemViewHolder, getSwipeAmountFromAfterReaction(i2, i3), swipeHorizontal());
        }
        swipeResultAction.performAction();
        notifyDataSetChanged();
    }

    protected boolean isSwiping() {
        return this.mSwipingItemId != -1;
    }

    private boolean swipeHorizontal() {
        return this.mSwipeManager.swipeHorizontal();
    }

    private static float getSwipeItemSlideAmount(SwipeableItemViewHolder swipeableItemViewHolder, boolean z) {
        if (z) {
            return swipeableItemViewHolder.getSwipeItemHorizontalSlideAmount();
        }
        return swipeableItemViewHolder.getSwipeItemVerticalSlideAmount();
    }

    private static void setSwipeItemSlideAmount(SwipeableItemViewHolder swipeableItemViewHolder, float f, boolean z) {
        if (z) {
            swipeableItemViewHolder.setSwipeItemHorizontalSlideAmount(f);
        } else {
            swipeableItemViewHolder.setSwipeItemVerticalSlideAmount(f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void safeUpdateFlags(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof SwipeableItemViewHolder) {
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
            int swipeStateFlags = swipeableItemViewHolder.getSwipeStateFlags();
            if (swipeStateFlags == -1 || ((swipeStateFlags ^ i) & Integer.MAX_VALUE) != 0) {
                i |= Integer.MIN_VALUE;
            }
            swipeableItemViewHolder.setSwipeStateFlags(i);
        }
    }
}
