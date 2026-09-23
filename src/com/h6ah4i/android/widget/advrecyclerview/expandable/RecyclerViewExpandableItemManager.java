package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPath;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

/* JADX INFO: loaded from: classes6.dex */
public class RecyclerViewExpandableItemManager implements ExpandableItemConstants {
    public static final long NO_EXPANDABLE_POSITION = -1;
    private static final String TAG = "ARVExpandableItemMgr";
    private int mInitialTouchX;
    private int mInitialTouchY;
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;
    private RecyclerView mRecyclerView;
    private SavedState mSavedState;
    private int mTouchSlop;
    private ExpandableRecyclerViewWrapperAdapter mWrapperAdapter;
    private long mTouchedItemId = -1;
    private boolean mDefaultGroupsExpandedState = false;
    private RecyclerView.OnItemTouchListener mInternalUseOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewExpandableItemManager.this.onInterceptTouchEvent(recyclerView, motionEvent);
        }
    };

    public interface OnGroupCollapseListener {
        void onGroupCollapse(int i, boolean z, Object obj);
    }

    public interface OnGroupExpandListener {
        void onGroupExpand(int i, boolean z, Object obj);
    }

    public RecyclerViewExpandableItemManager(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mSavedState = (SavedState) parcelable;
        }
    }

    public boolean isReleased() {
        return this.mInternalUseOnItemTouchListener == null;
    }

    public void attachRecyclerView(RecyclerView recyclerView) {
        if (isReleased()) {
            throw new IllegalStateException("Accessing released object");
        }
        if (this.mRecyclerView != null) {
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        this.mRecyclerView = recyclerView;
        recyclerView.addOnItemTouchListener(this.mInternalUseOnItemTouchListener);
        this.mTouchSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    }

    public void release() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (onItemTouchListener = this.mInternalUseOnItemTouchListener) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.mInternalUseOnItemTouchListener = null;
        this.mOnGroupExpandListener = null;
        this.mOnGroupCollapseListener = null;
        this.mRecyclerView = null;
        this.mSavedState = null;
    }

    public RecyclerView.Adapter createWrappedAdapter(RecyclerView.Adapter adapter) {
        if (!adapter.hasStableIds()) {
            throw new IllegalArgumentException("The passed adapter does not support stable IDs");
        }
        if (this.mWrapperAdapter != null) {
            throw new IllegalStateException("already have a wrapped adapter");
        }
        SavedState savedState = this.mSavedState;
        long[] jArr = savedState != null ? savedState.adapterSavedState : null;
        this.mSavedState = null;
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = new ExpandableRecyclerViewWrapperAdapter(this, adapter, jArr);
        this.mWrapperAdapter = expandableRecyclerViewWrapperAdapter;
        expandableRecyclerViewWrapperAdapter.setOnGroupExpandListener(this.mOnGroupExpandListener);
        this.mOnGroupExpandListener = null;
        this.mWrapperAdapter.setOnGroupCollapseListener(this.mOnGroupCollapseListener);
        this.mOnGroupCollapseListener = null;
        return this.mWrapperAdapter;
    }

    public Parcelable getSavedState() {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        return new SavedState(expandableRecyclerViewWrapperAdapter != null ? expandableRecyclerViewWrapperAdapter.getExpandedItemsSavedStateArray() : null);
    }

    boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mWrapperAdapter == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            handleActionDown(recyclerView, motionEvent);
        } else if (actionMasked == 1 || actionMasked == 3) {
            handleActionUpOrCancel(recyclerView, motionEvent);
            return false;
        }
        return false;
    }

    private void handleActionDown(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
        this.mInitialTouchX = (int) (motionEvent.getX() + 0.5f);
        this.mInitialTouchY = (int) (motionEvent.getY() + 0.5f);
        if (viewHolderFindChildViewHolderUnderWithTranslation instanceof ExpandableItemViewHolder) {
            this.mTouchedItemId = viewHolderFindChildViewHolderUnderWithTranslation.getItemId();
        } else {
            this.mTouchedItemId = -1L;
        }
    }

    private boolean handleActionUpOrCancel(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.ViewHolder viewHolderFindChildViewHolderUnderWithTranslation;
        long j = this.mTouchedItemId;
        int i = this.mInitialTouchX;
        int i2 = this.mInitialTouchY;
        this.mTouchedItemId = -1L;
        this.mInitialTouchX = 0;
        this.mInitialTouchY = 0;
        if (j == -1 || motionEvent.getActionMasked() != 1 || this.mRecyclerView.isComputingLayout()) {
            return false;
        }
        int x = (int) (motionEvent.getX() + 0.5f);
        int y = (int) (motionEvent.getY() + 0.5f);
        int i3 = y - i2;
        if (Math.abs(x - i) < this.mTouchSlop && Math.abs(i3) < this.mTouchSlop && (viewHolderFindChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY())) != null && viewHolderFindChildViewHolderUnderWithTranslation.getItemId() == j) {
            int iUnwrapPosition = WrapperAdapterUtils.unwrapPosition(this.mRecyclerView.getAdapter(), this.mWrapperAdapter, CustomRecyclerViewUtils.getSynchronizedPosition(viewHolderFindChildViewHolderUnderWithTranslation));
            if (iUnwrapPosition == -1) {
                return false;
            }
            View view = viewHolderFindChildViewHolderUnderWithTranslation.itemView;
            return this.mWrapperAdapter.onTapItem(viewHolderFindChildViewHolderUnderWithTranslation, iUnwrapPosition, x - (view.getLeft() + ((int) (view.getTranslationX() + 0.5f))), y - (view.getTop() + ((int) (view.getTranslationY() + 0.5f))));
        }
        return false;
    }

    public void expandAll() {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        if (expandableRecyclerViewWrapperAdapter != null) {
            expandableRecyclerViewWrapperAdapter.expandAll();
        }
    }

    public void collapseAll() {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        if (expandableRecyclerViewWrapperAdapter != null) {
            expandableRecyclerViewWrapperAdapter.collapseAll();
        }
    }

    public boolean expandGroup(int i) {
        return expandGroup(i, null);
    }

    public boolean expandGroup(int i, Object obj) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        return expandableRecyclerViewWrapperAdapter != null && expandableRecyclerViewWrapperAdapter.expandGroup(i, false, obj);
    }

    public boolean collapseGroup(int i) {
        return collapseGroup(i, null);
    }

    public boolean collapseGroup(int i, Object obj) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        return expandableRecyclerViewWrapperAdapter != null && expandableRecyclerViewWrapperAdapter.collapseGroup(i, false, obj);
    }

    public long getExpandablePosition(int i) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        if (expandableRecyclerViewWrapperAdapter == null) {
            return -1L;
        }
        return expandableRecyclerViewWrapperAdapter.getExpandablePosition(i);
    }

    public int getFlatPosition(long j) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        if (expandableRecyclerViewWrapperAdapter == null) {
            return -1;
        }
        return expandableRecyclerViewWrapperAdapter.getFlatPosition(j);
    }

    public static int getPackedPositionChild(long j) {
        return ExpandableAdapterHelper.getPackedPositionChild(j);
    }

    public static long getPackedPositionForChild(int i, int i2) {
        return ExpandableAdapterHelper.getPackedPositionForChild(i, i2);
    }

    public static long getPackedPositionForGroup(int i) {
        return ExpandableAdapterHelper.getPackedPositionForGroup(i);
    }

    public static int getPackedPositionGroup(long j) {
        return ExpandableAdapterHelper.getPackedPositionGroup(j);
    }

    public boolean isGroupExpanded(int i) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        return expandableRecyclerViewWrapperAdapter != null && expandableRecyclerViewWrapperAdapter.isGroupExpanded(i);
    }

    public static long getCombinedChildId(long j, long j2) {
        return ItemIdComposer.composeExpandableChildId(j, j2);
    }

    public static long getCombinedGroupId(long j) {
        return ItemIdComposer.composeExpandableGroupId(j);
    }

    public static boolean isGroupViewType(int i) {
        return ItemViewTypeComposer.isExpandableGroup(i);
    }

    public static int getGroupViewType(int i) {
        return ItemViewTypeComposer.extractWrappedViewTypePart(i);
    }

    public static int getChildViewType(int i) {
        return ItemViewTypeComposer.extractWrappedViewTypePart(i);
    }

    public static boolean isGroupItemId(long j) {
        return ItemIdComposer.isExpandableGroup(j);
    }

    public static long getGroupItemId(long j) {
        return ItemIdComposer.extractExpandableGroupIdPart(j);
    }

    public static long getChildItemId(long j) {
        return ItemIdComposer.extractExpandableChildIdPart(j);
    }

    public void setOnGroupExpandListener(OnGroupExpandListener onGroupExpandListener) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        if (expandableRecyclerViewWrapperAdapter != null) {
            expandableRecyclerViewWrapperAdapter.setOnGroupExpandListener(onGroupExpandListener);
        } else {
            this.mOnGroupExpandListener = onGroupExpandListener;
        }
    }

    public void setOnGroupCollapseListener(OnGroupCollapseListener onGroupCollapseListener) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        if (expandableRecyclerViewWrapperAdapter != null) {
            expandableRecyclerViewWrapperAdapter.setOnGroupCollapseListener(onGroupCollapseListener);
        } else {
            this.mOnGroupCollapseListener = onGroupCollapseListener;
        }
    }

    public void restoreState(Parcelable parcelable) {
        restoreState(parcelable, false, false);
    }

    public void restoreState(Parcelable parcelable, boolean z, boolean z2) {
        if (parcelable == null) {
            return;
        }
        if (!(parcelable instanceof SavedState)) {
            throw new IllegalArgumentException("Illegal saved state object passed");
        }
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.mWrapperAdapter;
        if (expandableRecyclerViewWrapperAdapter == null || this.mRecyclerView == null) {
            throw new IllegalStateException("RecyclerView has not been attached");
        }
        expandableRecyclerViewWrapperAdapter.restoreState(((SavedState) parcelable).adapterSavedState, z, z2);
    }

    public void notifyGroupItemChanged(int i) {
        this.mWrapperAdapter.notifyGroupItemChanged(i, null);
    }

    public void notifyGroupItemChanged(int i, Object obj) {
        this.mWrapperAdapter.notifyGroupItemChanged(i, obj);
    }

    public void notifyGroupAndChildrenItemsChanged(int i) {
        this.mWrapperAdapter.notifyGroupAndChildrenItemsChanged(i, null);
    }

    public void notifyGroupAndChildrenItemsChanged(int i, Object obj) {
        this.mWrapperAdapter.notifyGroupAndChildrenItemsChanged(i, obj);
    }

    public void notifyChildrenOfGroupItemChanged(int i) {
        this.mWrapperAdapter.notifyChildrenOfGroupItemChanged(i, null);
    }

    public void notifyChildrenOfGroupItemChanged(int i, Object obj) {
        this.mWrapperAdapter.notifyChildrenOfGroupItemChanged(i, obj);
    }

    public void notifyChildItemChanged(int i, int i2) {
        this.mWrapperAdapter.notifyChildItemChanged(i, i2, null);
    }

    public void notifyChildItemChanged(int i, int i2, Object obj) {
        this.mWrapperAdapter.notifyChildItemChanged(i, i2, obj);
    }

    public void notifyChildItemRangeChanged(int i, int i2, int i3) {
        this.mWrapperAdapter.notifyChildItemRangeChanged(i, i2, i3, null);
    }

    public void notifyChildItemRangeChanged(int i, int i2, int i3, Object obj) {
        this.mWrapperAdapter.notifyChildItemRangeChanged(i, i2, i3, obj);
    }

    public void notifyGroupItemInserted(int i) {
        notifyGroupItemInserted(i, this.mDefaultGroupsExpandedState);
    }

    public void notifyGroupItemInserted(int i, boolean z) {
        this.mWrapperAdapter.notifyGroupItemInserted(i, z);
    }

    public void notifyGroupItemRangeInserted(int i, int i2) {
        notifyGroupItemRangeInserted(i, i2, this.mDefaultGroupsExpandedState);
    }

    public void notifyGroupItemRangeInserted(int i, int i2, boolean z) {
        this.mWrapperAdapter.notifyGroupItemRangeInserted(i, i2, z);
    }

    public void notifyChildItemInserted(int i, int i2) {
        this.mWrapperAdapter.notifyChildItemInserted(i, i2);
    }

    public void notifyChildItemRangeInserted(int i, int i2, int i3) {
        this.mWrapperAdapter.notifyChildItemRangeInserted(i, i2, i3);
    }

    public void notifyGroupItemRemoved(int i) {
        this.mWrapperAdapter.notifyGroupItemRemoved(i);
    }

    public void notifyGroupItemRangeRemoved(int i, int i2) {
        this.mWrapperAdapter.notifyGroupItemRangeRemoved(i, i2);
    }

    public void notifyChildItemRemoved(int i, int i2) {
        this.mWrapperAdapter.notifyChildItemRemoved(i, i2);
    }

    public void notifyChildItemRangeRemoved(int i, int i2, int i3) {
        this.mWrapperAdapter.notifyChildItemRangeRemoved(i, i2, i3);
    }

    public void notifyGroupItemMoved(int i, int i2) {
        this.mWrapperAdapter.notifyGroupItemMoved(i, i2);
    }

    public void notifyChildItemMoved(int i, int i2, int i3) {
        this.mWrapperAdapter.notifyChildItemMoved(i, i2, i3);
    }

    public void notifyChildItemMoved(int i, int i2, int i3, int i4) {
        this.mWrapperAdapter.notifyChildItemMoved(i, i2, i3, i4);
    }

    public int getGroupCount() {
        return this.mWrapperAdapter.getGroupCount();
    }

    public int getChildCount(int i) {
        return this.mWrapperAdapter.getChildCount(i);
    }

    public void scrollToGroup(int i, int i2) {
        scrollToGroup(i, i2, 0, 0, null);
    }

    public void scrollToGroup(int i, int i2, int i3, int i4) {
        scrollToGroupWithTotalChildrenHeight(i, getChildCount(i) * i2, i3, i4, null);
    }

    public void scrollToGroup(int i, int i2, int i3, int i4, AdapterPath adapterPath) {
        scrollToGroupWithTotalChildrenHeight(i, getChildCount(i) * i2, i3, i4, adapterPath);
    }

    public void scrollToGroupWithTotalChildrenHeight(int i, int i2, int i3, int i4) {
        scrollToGroupWithTotalChildrenHeight(i, i2, i3, i4, null);
    }

    public void scrollToGroupWithTotalChildrenHeight(int i, int i2, int i3, int i4, AdapterPath adapterPath) {
        int flatPosition = getFlatPosition(getPackedPositionForGroup(i));
        if (adapterPath != null) {
            flatPosition = WrapperAdapterUtils.wrapPosition(adapterPath, this.mWrapperAdapter, this.mRecyclerView.getAdapter(), flatPosition);
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = this.mRecyclerView.findViewHolderForLayoutPosition(flatPosition);
        if (viewHolderFindViewHolderForLayoutPosition == null) {
            return;
        }
        if (!isGroupExpanded(i)) {
            i2 = 0;
        }
        int top = viewHolderFindViewHolderForLayoutPosition.itemView.getTop();
        int height = this.mRecyclerView.getHeight() - viewHolderFindViewHolderForLayoutPosition.itemView.getBottom();
        if (top <= i3) {
            ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(flatPosition, (i3 - this.mRecyclerView.getPaddingTop()) - ((RecyclerView.LayoutParams) viewHolderFindViewHolderForLayoutPosition.itemView.getLayoutParams()).topMargin);
            return;
        }
        int i5 = i2 + i4;
        if (height >= i5) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(0, Math.min(top - i3, Math.max(0, i5 - height)));
    }

    public int getExpandedGroupsCount() {
        return this.mWrapperAdapter.getExpandedGroupsCount();
    }

    public int getCollapsedGroupsCount() {
        return this.mWrapperAdapter.getCollapsedGroupsCount();
    }

    public boolean isAllGroupsExpanded() {
        return this.mWrapperAdapter.isAllGroupsExpanded();
    }

    public boolean isAllGroupsCollapsed() {
        return this.mWrapperAdapter.isAllGroupsCollapsed();
    }

    public void setDefaultGroupsExpandedState(boolean z) {
        this.mDefaultGroupsExpandedState = z;
    }

    public boolean getDefaultGroupsExpandedState() {
        return this.mDefaultGroupsExpandedState;
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final long[] adapterSavedState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState(long[] jArr) {
            this.adapterSavedState = jArr;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLongArray(this.adapterSavedState);
        }

        SavedState(Parcel parcel) {
            this.adapterSavedState = parcel.createLongArray();
        }
    }
}
