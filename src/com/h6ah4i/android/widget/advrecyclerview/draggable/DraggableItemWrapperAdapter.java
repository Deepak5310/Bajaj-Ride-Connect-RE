package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultActionDefault;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class DraggableItemWrapperAdapter<VH extends RecyclerView.ViewHolder> extends SimpleWrapperAdapter<VH> implements SwipeableItemAdapter<VH> {
    private static final boolean DEBUG_BYPASS_MOVE_OPERATION_MODE = false;
    private static final boolean LOCAL_LOGD = false;
    private static final boolean LOCAL_LOGI = true;
    private static final boolean LOCAL_LOGV = false;
    private static final int STATE_FLAG_INITIAL_VALUE = -1;
    private static final String TAG = "ARVDraggableWrapper";
    private boolean mCallingDragStarted;
    private RecyclerViewDragDropManager mDragDropManager;
    private DraggableItemAdapter mDraggableItemAdapter;
    private ItemDraggableRange mDraggableRange;
    private int mDraggingItemCurrentPosition;
    private DraggingItemInfo mDraggingItemInfo;
    private int mDraggingItemInitialPosition;
    private RecyclerView.ViewHolder mDraggingItemViewHolder;
    private int mItemMoveMode;

    private interface Constants extends DraggableItemConstants {
    }

    public DraggableItemWrapperAdapter(RecyclerViewDragDropManager recyclerViewDragDropManager, RecyclerView.Adapter<VH> adapter) {
        super(adapter);
        this.mDraggingItemInitialPosition = -1;
        this.mDraggingItemCurrentPosition = -1;
        if (recyclerViewDragDropManager == null) {
            throw new IllegalArgumentException("manager cannot be null");
        }
        this.mDragDropManager = recyclerViewDragDropManager;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onRelease() {
        super.onRelease();
        this.mDraggingItemViewHolder = null;
        this.mDraggableItemAdapter = null;
        this.mDragDropManager = null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        VH vh = (VH) super.onCreateViewHolder(viewGroup, i);
        if (vh instanceof DraggableItemViewHolder) {
            ((DraggableItemViewHolder) vh).setDragStateFlags(-1);
        }
        return vh;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        if (isDragging()) {
            long j = this.mDraggingItemInfo.id;
            long itemId = vh.getItemId();
            int iConvertToOriginalPosition = convertToOriginalPosition(i, this.mDraggingItemInitialPosition, this.mDraggingItemCurrentPosition, this.mItemMoveMode);
            if (itemId == j && vh != this.mDraggingItemViewHolder) {
                Log.i(TAG, "a new view holder object for the currently dragging item is assigned");
                this.mDraggingItemViewHolder = vh;
                this.mDragDropManager.onNewDraggingItemViewBound(vh);
            }
            int i2 = itemId == j ? 3 : 1;
            if (this.mDraggableRange.checkInRange(i)) {
                i2 |= 4;
            }
            safeUpdateFlags(vh, i2);
            super.onBindViewHolder(vh, iConvertToOriginalPosition, list);
            return;
        }
        safeUpdateFlags(vh, 0);
        super.onBindViewHolder(vh, i, list);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (isDragging()) {
            return super.getItemId(convertToOriginalPosition(i, this.mDraggingItemInitialPosition, this.mDraggingItemCurrentPosition, this.mItemMoveMode));
        }
        return super.getItemId(i);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (isDragging()) {
            return super.getItemViewType(convertToOriginalPosition(i, this.mDraggingItemInitialPosition, this.mDraggingItemCurrentPosition, this.mItemMoveMode));
        }
        return super.getItemViewType(i);
    }

    protected static int convertToOriginalPosition(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i3 < 0) {
            return i;
        }
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("unexpected state");
            }
            if (i == i3) {
                return i2;
            }
            return i == i2 ? i3 : i;
        }
        if (i2 == i3) {
            return i;
        }
        if (i < i2 && i < i3) {
            return i;
        }
        if (i > i2 && i > i3) {
            return i;
        }
        if (i3 < i2) {
            return i == i3 ? i2 : i - 1;
        }
        return i == i3 ? i2 : i + 1;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterChanged() {
        if (shouldCancelDragOnDataUpdated()) {
            cancelDrag();
        } else {
            super.onHandleWrappedAdapterChanged();
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeChanged(int i, int i2) {
        if (shouldCancelDragOnDataUpdated()) {
            cancelDrag();
        } else {
            super.onHandleWrappedAdapterItemRangeChanged(i, i2);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeInserted(int i, int i2) {
        if (shouldCancelDragOnDataUpdated()) {
            cancelDrag();
        } else {
            super.onHandleWrappedAdapterItemRangeInserted(i, i2);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeRemoved(int i, int i2) {
        if (shouldCancelDragOnDataUpdated()) {
            cancelDrag();
        } else {
            super.onHandleWrappedAdapterItemRangeRemoved(i, i2);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterRangeMoved(int i, int i2, int i3) {
        if (shouldCancelDragOnDataUpdated()) {
            cancelDrag();
        } else {
            super.onHandleWrappedAdapterRangeMoved(i, i2, i3);
        }
    }

    private boolean shouldCancelDragOnDataUpdated() {
        return isDragging() && !this.mCallingDragStarted;
    }

    private void cancelDrag() {
        RecyclerViewDragDropManager recyclerViewDragDropManager = this.mDragDropManager;
        if (recyclerViewDragDropManager != null) {
            recyclerViewDragDropManager.cancelDrag();
        }
    }

    void startDraggingItem(DraggingItemInfo draggingItemInfo, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange, int i, int i2) {
        if (viewHolder.getItemId() == -1) {
            throw new IllegalStateException("dragging target must provides valid ID");
        }
        DraggableItemAdapter draggableItemAdapter = (DraggableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(this, DraggableItemAdapter.class, i);
        this.mDraggableItemAdapter = draggableItemAdapter;
        if (draggableItemAdapter == null) {
            throw new IllegalStateException("DraggableItemAdapter not found!");
        }
        this.mDraggingItemCurrentPosition = i;
        this.mDraggingItemInitialPosition = i;
        this.mDraggingItemInfo = draggingItemInfo;
        this.mDraggingItemViewHolder = viewHolder;
        this.mDraggableRange = itemDraggableRange;
        this.mItemMoveMode = i2;
    }

    void onDragItemStarted() {
        this.mCallingDragStarted = true;
        this.mDraggableItemAdapter.onItemDragStarted(getDraggingItemInitialPosition());
        this.mCallingDragStarted = false;
    }

    void onDragItemFinished(int i, int i2, boolean z) {
        DraggableItemAdapter draggableItemAdapter = this.mDraggableItemAdapter;
        this.mDraggingItemInitialPosition = -1;
        this.mDraggingItemCurrentPosition = -1;
        this.mDraggableRange = null;
        this.mDraggingItemInfo = null;
        this.mDraggingItemViewHolder = null;
        this.mDraggableItemAdapter = null;
        if (z && i2 != i) {
            draggableItemAdapter.onMoveItem(i, i2);
        }
        draggableItemAdapter.onItemDragFinished(i, i2, z);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(VH vh, int i) {
        if (isDragging()) {
            this.mDragDropManager.onItemViewRecycled(vh);
            this.mDraggingItemViewHolder = this.mDragDropManager.getDraggingItemViewHolder();
        }
        super.onViewRecycled(vh, i);
    }

    boolean canStartDrag(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
        DraggableItemAdapter draggableItemAdapter = (DraggableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(this, DraggableItemAdapter.class, i);
        if (draggableItemAdapter == null) {
            return false;
        }
        return draggableItemAdapter.onCheckCanStartDrag(viewHolder, i, i2, i3);
    }

    boolean canDropItems(int i, int i2) {
        return this.mDraggableItemAdapter.onCheckCanDrop(i, i2);
    }

    ItemDraggableRange getItemDraggableRange(RecyclerView.ViewHolder viewHolder, int i) {
        DraggableItemAdapter draggableItemAdapter = (DraggableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(this, DraggableItemAdapter.class, i);
        if (draggableItemAdapter == null) {
            return null;
        }
        return draggableItemAdapter.onGetItemDraggableRange(viewHolder, i);
    }

    void moveItem(int i, int i2, int i3) {
        int iConvertToOriginalPosition = convertToOriginalPosition(i, this.mDraggingItemInitialPosition, this.mDraggingItemCurrentPosition, this.mItemMoveMode);
        if (iConvertToOriginalPosition != this.mDraggingItemInitialPosition) {
            throw new IllegalStateException("onMoveItem() - may be a bug or has duplicate IDs  --- mDraggingItemInitialPosition = " + this.mDraggingItemInitialPosition + ", mDraggingItemCurrentPosition = " + this.mDraggingItemCurrentPosition + ", origFromPosition = " + iConvertToOriginalPosition + ", fromPosition = " + i + ", toPosition = " + i2);
        }
        this.mDraggingItemCurrentPosition = i2;
        if (this.mItemMoveMode == 0 && CustomRecyclerViewUtils.isLinearLayout(i3)) {
            notifyItemMoved(i, i2);
        } else {
            notifyDataSetChanged();
        }
    }

    protected boolean isDragging() {
        return this.mDraggingItemInfo != null;
    }

    int getDraggingItemInitialPosition() {
        return this.mDraggingItemInitialPosition;
    }

    int getDraggingItemCurrentPosition() {
        return this.mDraggingItemCurrentPosition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void safeUpdateFlags(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof DraggableItemViewHolder) {
            DraggableItemViewHolder draggableItemViewHolder = (DraggableItemViewHolder) viewHolder;
            int dragStateFlags = draggableItemViewHolder.getDragStateFlags();
            if (dragStateFlags == -1 || ((dragStateFlags ^ i) & Integer.MAX_VALUE) != 0) {
                i |= Integer.MIN_VALUE;
            }
            draggableItemViewHolder.setDragStateFlags(i);
        }
    }

    private int getOriginalPosition(int i) {
        return isDragging() ? convertToOriginalPosition(i, this.mDraggingItemInitialPosition, this.mDraggingItemCurrentPosition, this.mItemMoveMode) : i;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public int onGetSwipeReactionType(VH vh, int i, int i2, int i3) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (!(wrappedAdapter instanceof SwipeableItemAdapter)) {
            return 0;
        }
        return ((SwipeableItemAdapter) wrappedAdapter).onGetSwipeReactionType(vh, getOriginalPosition(i), i2, i3);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSwipeItemStarted(VH vh, int i) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (wrappedAdapter instanceof SwipeableItemAdapter) {
            ((SwipeableItemAdapter) wrappedAdapter).onSwipeItemStarted(vh, getOriginalPosition(i));
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSetSwipeBackground(VH vh, int i, int i2) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (wrappedAdapter instanceof SwipeableItemAdapter) {
            ((SwipeableItemAdapter) wrappedAdapter).onSetSwipeBackground(vh, getOriginalPosition(i), i2);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public SwipeResultAction onSwipeItem(VH vh, int i, int i2) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (!(wrappedAdapter instanceof SwipeableItemAdapter)) {
            return new SwipeResultActionDefault();
        }
        return ((SwipeableItemAdapter) wrappedAdapter).onSwipeItem(vh, getOriginalPosition(i), i2);
    }
}
