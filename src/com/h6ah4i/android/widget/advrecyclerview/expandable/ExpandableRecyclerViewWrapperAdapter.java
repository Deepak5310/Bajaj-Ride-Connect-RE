package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class ExpandableRecyclerViewWrapperAdapter extends SimpleWrapperAdapter<RecyclerView.ViewHolder> implements DraggableItemAdapter<RecyclerView.ViewHolder>, SwipeableItemAdapter<RecyclerView.ViewHolder> {
    private static final int STATE_FLAG_INITIAL_VALUE = -1;
    private static final String TAG = "ARVExpandableWrapper";
    private static final int VIEW_TYPE_FLAG_IS_GROUP = Integer.MIN_VALUE;
    private int mDraggingItemChildRangeEnd;
    private int mDraggingItemChildRangeStart;
    private int mDraggingItemGroupRangeEnd;
    private int mDraggingItemGroupRangeStart;
    private ExpandableItemAdapter mExpandableItemAdapter;
    private RecyclerViewExpandableItemManager mExpandableListManager;
    private RecyclerViewExpandableItemManager.OnGroupCollapseListener mOnGroupCollapseListener;
    private RecyclerViewExpandableItemManager.OnGroupExpandListener mOnGroupExpandListener;
    private ExpandablePositionTranslator mPositionTranslator;
    private int mSavedFromChildPosition;
    private int mSavedFromGroupPosition;
    private int mSavedToChildPosition;
    private int mSavedToGroupPosition;

    private interface Constants extends ExpandableItemConstants {
    }

    public ExpandableRecyclerViewWrapperAdapter(RecyclerViewExpandableItemManager recyclerViewExpandableItemManager, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, long[] jArr) {
        super(adapter);
        this.mDraggingItemGroupRangeStart = -1;
        this.mDraggingItemGroupRangeEnd = -1;
        this.mDraggingItemChildRangeStart = -1;
        this.mDraggingItemChildRangeEnd = -1;
        this.mSavedFromGroupPosition = -1;
        this.mSavedFromChildPosition = -1;
        this.mSavedToGroupPosition = -1;
        this.mSavedToChildPosition = -1;
        ExpandableItemAdapter expandableItemAdapter = getExpandableItemAdapter(adapter);
        this.mExpandableItemAdapter = expandableItemAdapter;
        if (expandableItemAdapter == null) {
            throw new IllegalArgumentException("adapter does not implement ExpandableItemAdapter");
        }
        if (recyclerViewExpandableItemManager == null) {
            throw new IllegalArgumentException("manager cannot be null");
        }
        this.mExpandableListManager = recyclerViewExpandableItemManager;
        ExpandablePositionTranslator expandablePositionTranslator = new ExpandablePositionTranslator();
        this.mPositionTranslator = expandablePositionTranslator;
        expandablePositionTranslator.build(this.mExpandableItemAdapter, 0, this.mExpandableListManager.getDefaultGroupsExpandedState());
        if (jArr != null) {
            this.mPositionTranslator.restoreExpandedGroupItems(jArr, null, null, null);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onRelease() {
        super.onRelease();
        this.mExpandableItemAdapter = null;
        this.mExpandableListManager = null;
        this.mOnGroupExpandListener = null;
        this.mOnGroupCollapseListener = null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mPositionTranslator.getItemCount();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (this.mExpandableItemAdapter == null) {
            return -1L;
        }
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
        if (packedPositionChild == -1) {
            return ItemIdComposer.composeExpandableGroupId(this.mExpandableItemAdapter.getGroupId(packedPositionGroup));
        }
        return ItemIdComposer.composeExpandableChildId(this.mExpandableItemAdapter.getGroupId(packedPositionGroup), this.mExpandableItemAdapter.getChildId(packedPositionGroup, packedPositionChild));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int childItemViewType;
        if (this.mExpandableItemAdapter == null) {
            return 0;
        }
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
        if (packedPositionChild == -1) {
            childItemViewType = this.mExpandableItemAdapter.getGroupItemViewType(packedPositionGroup);
        } else {
            childItemViewType = this.mExpandableItemAdapter.getChildItemViewType(packedPositionGroup, packedPositionChild);
        }
        if ((childItemViewType & Integer.MIN_VALUE) == 0) {
            return packedPositionChild == -1 ? childItemViewType | Integer.MIN_VALUE : childItemViewType;
        }
        throw new IllegalStateException("Illegal view type (type = " + Integer.toHexString(childItemViewType) + ")");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolderOnCreateChildViewHolder;
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (expandableItemAdapter == null) {
            throw new IllegalStateException();
        }
        int i2 = Integer.MAX_VALUE & i;
        if ((i & Integer.MIN_VALUE) != 0) {
            viewHolderOnCreateChildViewHolder = expandableItemAdapter.onCreateGroupViewHolder(viewGroup, i2);
        } else {
            viewHolderOnCreateChildViewHolder = expandableItemAdapter.onCreateChildViewHolder(viewGroup, i2);
        }
        if (viewHolderOnCreateChildViewHolder instanceof ExpandableItemViewHolder) {
            ((ExpandableItemViewHolder) viewHolderOnCreateChildViewHolder).setExpandStateFlags(-1);
        }
        return viewHolderOnCreateChildViewHolder;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        if (this.mExpandableItemAdapter == null) {
            return;
        }
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
        int itemViewType = viewHolder.getItemViewType() & Integer.MAX_VALUE;
        int i2 = packedPositionChild == -1 ? 1 : 2;
        if (this.mPositionTranslator.isGroupExpanded(packedPositionGroup)) {
            i2 |= 4;
        }
        safeUpdateExpandStateFlags(viewHolder, i2);
        correctItemDragStateFlags(viewHolder, packedPositionGroup, packedPositionChild);
        if (packedPositionChild == -1) {
            this.mExpandableItemAdapter.onBindGroupViewHolder(viewHolder, packedPositionGroup, itemViewType, list);
        } else {
            this.mExpandableItemAdapter.onBindChildViewHolder(viewHolder, packedPositionGroup, packedPositionChild, itemViewType, list);
        }
    }

    private void rebuildPositionTranslator() {
        ExpandablePositionTranslator expandablePositionTranslator = this.mPositionTranslator;
        if (expandablePositionTranslator != null) {
            long[] savedStateArray = expandablePositionTranslator.getSavedStateArray();
            this.mPositionTranslator.build(this.mExpandableItemAdapter, 0, this.mExpandableListManager.getDefaultGroupsExpandedState());
            this.mPositionTranslator.restoreExpandedGroupItems(savedStateArray, null, null, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ExpandableItemViewHolder) {
            ((ExpandableItemViewHolder) viewHolder).setExpandStateFlags(-1);
        }
        super.onViewRecycled(viewHolder, i);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterChanged() {
        rebuildPositionTranslator();
        super.onHandleWrappedAdapterChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeChanged(int i, int i2) {
        super.onHandleWrappedAdapterItemRangeChanged(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeInserted(int i, int i2) {
        rebuildPositionTranslator();
        super.onHandleWrappedAdapterItemRangeInserted(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterItemRangeRemoved(int i, int i2) {
        if (i2 == 1) {
            long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
            int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
            int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
            if (packedPositionChild == -1) {
                this.mPositionTranslator.removeGroupItem(packedPositionGroup);
            } else {
                this.mPositionTranslator.removeChildItem(packedPositionGroup, packedPositionChild);
            }
        } else {
            rebuildPositionTranslator();
        }
        super.onHandleWrappedAdapterItemRangeRemoved(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void onHandleWrappedAdapterRangeMoved(int i, int i2, int i3) {
        rebuildPositionTranslator();
        super.onHandleWrappedAdapterRangeMoved(i, i2, i3);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanStartDrag(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
        boolean zOnCheckChildCanStartDrag;
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter)) {
            return false;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) expandableItemAdapter;
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
        if (packedPositionChild == -1) {
            zOnCheckChildCanStartDrag = expandableDraggableItemAdapter.onCheckGroupCanStartDrag(viewHolder, packedPositionGroup, i2, i3);
        } else {
            zOnCheckChildCanStartDrag = expandableDraggableItemAdapter.onCheckChildCanStartDrag(viewHolder, packedPositionGroup, packedPositionChild, i2, i3);
        }
        this.mDraggingItemGroupRangeStart = -1;
        this.mDraggingItemGroupRangeEnd = -1;
        this.mDraggingItemChildRangeStart = -1;
        this.mDraggingItemChildRangeEnd = -1;
        return zOnCheckChildCanStartDrag;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public ItemDraggableRange onGetItemDraggableRange(RecyclerView.ViewHolder viewHolder, int i) {
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter) || expandableItemAdapter.getGroupCount() < 1) {
            return null;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) this.mExpandableItemAdapter;
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
        if (packedPositionChild == -1) {
            ItemDraggableRange itemDraggableRangeOnGetGroupItemDraggableRange = expandableDraggableItemAdapter.onGetGroupItemDraggableRange(viewHolder, packedPositionGroup);
            if (itemDraggableRangeOnGetGroupItemDraggableRange == null) {
                return new ItemDraggableRange(0, Math.max(0, (this.mPositionTranslator.getItemCount() - this.mPositionTranslator.getVisibleChildCount(Math.max(0, this.mExpandableItemAdapter.getGroupCount() - 1))) - 1));
            }
            if (!isGroupPositionRange(itemDraggableRangeOnGetGroupItemDraggableRange)) {
                throw new IllegalStateException("Invalid range specified: " + itemDraggableRangeOnGetGroupItemDraggableRange);
            }
            long packedPositionForGroup = ExpandableAdapterHelper.getPackedPositionForGroup(itemDraggableRangeOnGetGroupItemDraggableRange.getStart());
            long packedPositionForGroup2 = ExpandableAdapterHelper.getPackedPositionForGroup(itemDraggableRangeOnGetGroupItemDraggableRange.getEnd());
            int flatPosition = this.mPositionTranslator.getFlatPosition(packedPositionForGroup);
            int flatPosition2 = this.mPositionTranslator.getFlatPosition(packedPositionForGroup2);
            if (itemDraggableRangeOnGetGroupItemDraggableRange.getEnd() > packedPositionGroup) {
                flatPosition2 += this.mPositionTranslator.getVisibleChildCount(itemDraggableRangeOnGetGroupItemDraggableRange.getEnd());
            }
            this.mDraggingItemGroupRangeStart = itemDraggableRangeOnGetGroupItemDraggableRange.getStart();
            this.mDraggingItemGroupRangeEnd = itemDraggableRangeOnGetGroupItemDraggableRange.getEnd();
            return new ItemDraggableRange(flatPosition, flatPosition2);
        }
        ItemDraggableRange itemDraggableRangeOnGetChildItemDraggableRange = expandableDraggableItemAdapter.onGetChildItemDraggableRange(viewHolder, packedPositionGroup, packedPositionChild);
        if (itemDraggableRangeOnGetChildItemDraggableRange == null) {
            return new ItemDraggableRange(1, Math.max(1, this.mPositionTranslator.getItemCount() - 1));
        }
        if (isGroupPositionRange(itemDraggableRangeOnGetChildItemDraggableRange)) {
            long packedPositionForGroup3 = ExpandableAdapterHelper.getPackedPositionForGroup(itemDraggableRangeOnGetChildItemDraggableRange.getStart());
            int flatPosition3 = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(itemDraggableRangeOnGetChildItemDraggableRange.getEnd())) + this.mPositionTranslator.getVisibleChildCount(itemDraggableRangeOnGetChildItemDraggableRange.getEnd());
            int iMin = Math.min(this.mPositionTranslator.getFlatPosition(packedPositionForGroup3) + 1, flatPosition3);
            this.mDraggingItemGroupRangeStart = itemDraggableRangeOnGetChildItemDraggableRange.getStart();
            this.mDraggingItemGroupRangeEnd = itemDraggableRangeOnGetChildItemDraggableRange.getEnd();
            return new ItemDraggableRange(iMin, flatPosition3);
        }
        if (!isChildPositionRange(itemDraggableRangeOnGetChildItemDraggableRange)) {
            throw new IllegalStateException("Invalid range specified: " + itemDraggableRangeOnGetChildItemDraggableRange);
        }
        int iMax = Math.max(this.mPositionTranslator.getVisibleChildCount(packedPositionGroup) - 1, 0);
        int iMin2 = Math.min(itemDraggableRangeOnGetChildItemDraggableRange.getStart(), iMax);
        int iMin3 = Math.min(itemDraggableRangeOnGetChildItemDraggableRange.getEnd(), iMax);
        long packedPositionForChild = ExpandableAdapterHelper.getPackedPositionForChild(packedPositionGroup, iMin2);
        long packedPositionForChild2 = ExpandableAdapterHelper.getPackedPositionForChild(packedPositionGroup, iMin3);
        int flatPosition4 = this.mPositionTranslator.getFlatPosition(packedPositionForChild);
        int flatPosition5 = this.mPositionTranslator.getFlatPosition(packedPositionForChild2);
        this.mDraggingItemChildRangeStart = iMin2;
        this.mDraggingItemChildRangeEnd = iMin3;
        return new ItemDraggableRange(flatPosition4, flatPosition5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanDrop(int i, int i2) {
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        boolean z = true;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter)) {
            return true;
        }
        if (expandableItemAdapter.getGroupCount() < 1) {
            return false;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) this.mExpandableItemAdapter;
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
        long expandablePosition2 = this.mPositionTranslator.getExpandablePosition(i2);
        int packedPositionGroup2 = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition2);
        int packedPositionChild2 = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition2);
        boolean z2 = packedPositionChild == -1;
        boolean z3 = packedPositionChild2 == -1;
        if (z2) {
            if (packedPositionGroup != packedPositionGroup2 && i < i2) {
                boolean zIsGroupExpanded = this.mPositionTranslator.isGroupExpanded(packedPositionGroup2);
                int visibleChildCount = this.mPositionTranslator.getVisibleChildCount(packedPositionGroup2);
                if (z3) {
                    z3 = !zIsGroupExpanded;
                } else {
                    z3 = packedPositionChild2 == visibleChildCount - 1;
                }
            }
            if (z3) {
                return expandableDraggableItemAdapter.onCheckGroupCanDrop(packedPositionGroup, packedPositionGroup2);
            }
            return false;
        }
        boolean zIsGroupExpanded2 = this.mPositionTranslator.isGroupExpanded(packedPositionGroup2);
        if (i < i2) {
            if (z3) {
                packedPositionChild2 = zIsGroupExpanded2 ? 0 : this.mPositionTranslator.getChildCount(packedPositionGroup2);
            }
        } else if (z3) {
            if (packedPositionGroup2 > 0) {
                packedPositionGroup2--;
                packedPositionChild2 = this.mPositionTranslator.getChildCount(packedPositionGroup2);
            } else {
                z = false;
            }
        }
        if (z) {
            return expandableDraggableItemAdapter.onCheckChildCanDrop(packedPositionGroup, packedPositionChild, packedPositionGroup2, packedPositionChild2);
        }
        return false;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragStarted(int i) {
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (expandableItemAdapter instanceof ExpandableDraggableItemAdapter) {
            ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) expandableItemAdapter;
            long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
            int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
            int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
            if (packedPositionChild == -1) {
                expandableDraggableItemAdapter.onGroupDragStarted(packedPositionGroup);
            } else {
                expandableDraggableItemAdapter.onChildDragStarted(packedPositionGroup, packedPositionChild);
            }
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragFinished(int i, int i2, boolean z) {
        int i3;
        int packedPositionChild;
        int i4;
        int i5;
        int i6 = this.mSavedFromGroupPosition;
        int i7 = this.mSavedFromChildPosition;
        int i8 = this.mSavedToGroupPosition;
        int i9 = this.mSavedToChildPosition;
        this.mDraggingItemGroupRangeStart = -1;
        this.mDraggingItemGroupRangeEnd = -1;
        this.mDraggingItemChildRangeStart = -1;
        this.mDraggingItemChildRangeEnd = -1;
        this.mSavedFromGroupPosition = -1;
        this.mSavedFromChildPosition = -1;
        this.mSavedToGroupPosition = -1;
        this.mSavedToChildPosition = -1;
        if (this.mExpandableItemAdapter instanceof ExpandableDraggableItemAdapter) {
            if (i6 == -1 && i7 == -1) {
                long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
                int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
                packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
                i5 = packedPositionChild;
                i3 = packedPositionGroup;
                i4 = i3;
            } else {
                i3 = i6;
                packedPositionChild = i7;
                i4 = i8;
                i5 = i9;
            }
            ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) this.mExpandableItemAdapter;
            if (packedPositionChild == -1) {
                expandableDraggableItemAdapter.onGroupDragFinished(i3, i4, z);
            } else {
                expandableDraggableItemAdapter.onChildDragFinished(i3, packedPositionChild, i4, i5, z);
            }
        }
    }

    private static boolean isGroupPositionRange(ItemDraggableRange itemDraggableRange) {
        return itemDraggableRange.getClass().equals(GroupPositionItemDraggableRange.class) || itemDraggableRange.getClass().equals(ItemDraggableRange.class);
    }

    private static boolean isChildPositionRange(ItemDraggableRange itemDraggableRange) {
        return itemDraggableRange.getClass().equals(ChildPositionItemDraggableRange.class);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onMoveItem(int i, int i2) {
        int childCount;
        int i3;
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (expandableItemAdapter instanceof ExpandableDraggableItemAdapter) {
            ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) expandableItemAdapter;
            long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
            int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
            int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
            long expandablePosition2 = this.mPositionTranslator.getExpandablePosition(i2);
            int packedPositionGroup2 = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition2);
            int packedPositionChild2 = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition2);
            boolean z = packedPositionChild == -1;
            boolean z2 = packedPositionChild2 == -1;
            if (z && z2) {
                expandableDraggableItemAdapter.onMoveGroupItem(packedPositionGroup, packedPositionGroup2);
                this.mPositionTranslator.moveGroupItem(packedPositionGroup, packedPositionGroup2);
            } else if (!z && !z2) {
                if (packedPositionGroup != packedPositionGroup2 && i < i2) {
                    packedPositionChild2++;
                }
                i2 = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForChild(packedPositionGroup, packedPositionChild2));
                expandableDraggableItemAdapter.onMoveChildItem(packedPositionGroup, packedPositionChild, packedPositionGroup2, packedPositionChild2);
                this.mPositionTranslator.moveChildItem(packedPositionGroup, packedPositionChild, packedPositionGroup2, packedPositionChild2);
            } else if (!z) {
                if (i2 < i) {
                    if (packedPositionGroup2 == 0) {
                        i3 = packedPositionGroup2;
                        childCount = 0;
                    } else {
                        i3 = packedPositionGroup2 - 1;
                        childCount = this.mPositionTranslator.getChildCount(i3);
                    }
                } else if (this.mPositionTranslator.isGroupExpanded(packedPositionGroup2)) {
                    i3 = packedPositionGroup2;
                    childCount = 0;
                } else {
                    childCount = this.mPositionTranslator.getChildCount(packedPositionGroup2);
                    i3 = packedPositionGroup2;
                }
                int iMin = packedPositionGroup == i3 ? Math.min(childCount, Math.max(0, this.mPositionTranslator.getChildCount(i3) - 1)) : childCount;
                if (packedPositionGroup == i3 && packedPositionChild == iMin) {
                    i2 = i;
                } else {
                    if (!this.mPositionTranslator.isGroupExpanded(packedPositionGroup2)) {
                        i2 = -1;
                    }
                    expandableDraggableItemAdapter.onMoveChildItem(packedPositionGroup, packedPositionChild, i3, iMin);
                    this.mPositionTranslator.moveChildItem(packedPositionGroup, packedPositionChild, i3, iMin);
                }
                packedPositionGroup2 = i3;
                packedPositionChild2 = iMin;
            } else if (packedPositionGroup != packedPositionGroup2) {
                i2 = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(packedPositionGroup2));
                expandableDraggableItemAdapter.onMoveGroupItem(packedPositionGroup, packedPositionGroup2);
                this.mPositionTranslator.moveGroupItem(packedPositionGroup, packedPositionGroup2);
            } else {
                i2 = i;
            }
            if (i2 != i) {
                if (i2 != -1) {
                    notifyItemMoved(i, i2);
                } else {
                    notifyItemRemoved(i);
                }
            }
            this.mSavedFromGroupPosition = packedPositionGroup;
            this.mSavedFromChildPosition = packedPositionChild;
            this.mSavedToGroupPosition = packedPositionGroup2;
            this.mSavedToChildPosition = packedPositionChild2;
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public int onGetSwipeReactionType(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (!(expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter)) {
            return 0;
        }
        BaseExpandableSwipeableItemAdapter baseExpandableSwipeableItemAdapter = (BaseExpandableSwipeableItemAdapter) expandableItemAdapter;
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
        if (packedPositionChild == -1) {
            return baseExpandableSwipeableItemAdapter.onGetGroupItemSwipeReactionType(viewHolder, packedPositionGroup, i2, i3);
        }
        return baseExpandableSwipeableItemAdapter.onGetChildItemSwipeReactionType(viewHolder, packedPositionGroup, packedPositionChild, i2, i3);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSwipeItemStarted(RecyclerView.ViewHolder viewHolder, int i) {
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter) {
            BaseExpandableSwipeableItemAdapter baseExpandableSwipeableItemAdapter = (BaseExpandableSwipeableItemAdapter) expandableItemAdapter;
            long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
            int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
            int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
            if (packedPositionChild == -1) {
                baseExpandableSwipeableItemAdapter.onSwipeGroupItemStarted(viewHolder, packedPositionGroup);
            } else {
                baseExpandableSwipeableItemAdapter.onSwipeChildItemStarted(viewHolder, packedPositionGroup, packedPositionChild);
            }
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSetSwipeBackground(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter) {
            BaseExpandableSwipeableItemAdapter baseExpandableSwipeableItemAdapter = (BaseExpandableSwipeableItemAdapter) expandableItemAdapter;
            long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
            int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
            int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(expandablePosition);
            if (packedPositionChild == -1) {
                baseExpandableSwipeableItemAdapter.onSetGroupItemSwipeBackground(viewHolder, packedPositionGroup, i2);
            } else {
                baseExpandableSwipeableItemAdapter.onSetChildItemSwipeBackground(viewHolder, packedPositionGroup, packedPositionChild, i2);
            }
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public SwipeResultAction onSwipeItem(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        ExpandableItemAdapter expandableItemAdapter = this.mExpandableItemAdapter;
        if (!(expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter) || i == -1) {
            return null;
        }
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        return ExpandableSwipeableItemInternalUtils.invokeOnSwipeItem((BaseExpandableSwipeableItemAdapter) expandableItemAdapter, viewHolder, ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition), ExpandableAdapterHelper.getPackedPositionChild(expandablePosition), i2);
    }

    boolean onTapItem(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
        if (this.mExpandableItemAdapter == null) {
            return false;
        }
        long expandablePosition = this.mPositionTranslator.getExpandablePosition(i);
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(expandablePosition);
        if (ExpandableAdapterHelper.getPackedPositionChild(expandablePosition) != -1) {
            return false;
        }
        boolean zIsGroupExpanded = this.mPositionTranslator.isGroupExpanded(packedPositionGroup);
        if (!this.mExpandableItemAdapter.onCheckCanExpandOrCollapseGroup(viewHolder, packedPositionGroup, i2, i3, !zIsGroupExpanded)) {
            return false;
        }
        if (!zIsGroupExpanded) {
            expandGroup(packedPositionGroup, true, null);
        } else {
            collapseGroup(packedPositionGroup, true, null);
        }
        return true;
    }

    void expandAll() {
        if (this.mPositionTranslator.isEmpty() || this.mPositionTranslator.isAllExpanded()) {
            return;
        }
        this.mPositionTranslator.build(this.mExpandableItemAdapter, 1, this.mExpandableListManager.getDefaultGroupsExpandedState());
        notifyDataSetChanged();
    }

    void collapseAll() {
        if (this.mPositionTranslator.isEmpty() || this.mPositionTranslator.isAllCollapsed()) {
            return;
        }
        this.mPositionTranslator.build(this.mExpandableItemAdapter, 2, this.mExpandableListManager.getDefaultGroupsExpandedState());
        notifyDataSetChanged();
    }

    boolean collapseGroup(int i, boolean z, Object obj) {
        if (!this.mPositionTranslator.isGroupExpanded(i) || !this.mExpandableItemAdapter.onHookGroupCollapse(i, z, obj)) {
            return false;
        }
        if (this.mPositionTranslator.collapseGroup(i)) {
            notifyItemRangeRemoved(this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i)) + 1, this.mPositionTranslator.getChildCount(i));
        }
        notifyItemChanged(this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i)), obj);
        RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener = this.mOnGroupCollapseListener;
        if (onGroupCollapseListener != null) {
            onGroupCollapseListener.onGroupCollapse(i, z, obj);
        }
        return true;
    }

    boolean expandGroup(int i, boolean z, Object obj) {
        if (this.mPositionTranslator.isGroupExpanded(i) || !this.mExpandableItemAdapter.onHookGroupExpand(i, z, obj)) {
            return false;
        }
        if (this.mPositionTranslator.expandGroup(i)) {
            notifyItemRangeInserted(this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i)) + 1, this.mPositionTranslator.getChildCount(i));
        }
        notifyItemChanged(this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i)), obj);
        RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener = this.mOnGroupExpandListener;
        if (onGroupExpandListener != null) {
            onGroupExpandListener.onGroupExpand(i, z, obj);
        }
        return true;
    }

    boolean isGroupExpanded(int i) {
        return this.mPositionTranslator.isGroupExpanded(i);
    }

    long getExpandablePosition(int i) {
        return this.mPositionTranslator.getExpandablePosition(i);
    }

    int getFlatPosition(long j) {
        return this.mPositionTranslator.getFlatPosition(j);
    }

    long[] getExpandedItemsSavedStateArray() {
        ExpandablePositionTranslator expandablePositionTranslator = this.mPositionTranslator;
        if (expandablePositionTranslator != null) {
            return expandablePositionTranslator.getSavedStateArray();
        }
        return null;
    }

    void setOnGroupExpandListener(RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener) {
        this.mOnGroupExpandListener = onGroupExpandListener;
    }

    void setOnGroupCollapseListener(RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener) {
        this.mOnGroupCollapseListener = onGroupCollapseListener;
    }

    void restoreState(long[] jArr, boolean z, boolean z2) {
        this.mPositionTranslator.restoreExpandedGroupItems(jArr, z ? this.mExpandableItemAdapter : null, z2 ? this.mOnGroupExpandListener : null, z2 ? this.mOnGroupCollapseListener : null);
    }

    void notifyGroupItemChanged(int i, Object obj) {
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i));
        if (flatPosition != -1) {
            notifyItemChanged(flatPosition, obj);
        }
    }

    void notifyGroupAndChildrenItemsChanged(int i, Object obj) {
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i));
        int visibleChildCount = this.mPositionTranslator.getVisibleChildCount(i);
        if (flatPosition != -1) {
            notifyItemRangeChanged(flatPosition, visibleChildCount + 1, obj);
        }
    }

    void notifyChildrenOfGroupItemChanged(int i, Object obj) {
        int visibleChildCount = this.mPositionTranslator.getVisibleChildCount(i);
        if (visibleChildCount > 0) {
            int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForChild(i, 0));
            if (flatPosition != -1) {
                notifyItemRangeChanged(flatPosition, visibleChildCount, obj);
            }
        }
    }

    void notifyChildItemChanged(int i, int i2, Object obj) {
        notifyChildItemRangeChanged(i, i2, 1, obj);
    }

    void notifyChildItemRangeChanged(int i, int i2, int i3, Object obj) {
        int visibleChildCount = this.mPositionTranslator.getVisibleChildCount(i);
        if (visibleChildCount <= 0 || i2 >= visibleChildCount) {
            return;
        }
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForChild(i, 0));
        if (flatPosition != -1) {
            notifyItemRangeChanged(flatPosition + i2, Math.min(i3, visibleChildCount - i2), obj);
        }
    }

    void notifyChildItemInserted(int i, int i2) {
        this.mPositionTranslator.insertChildItem(i, i2);
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForChild(i, i2));
        if (flatPosition != -1) {
            notifyItemInserted(flatPosition);
        }
    }

    void notifyChildItemRangeInserted(int i, int i2, int i3) {
        this.mPositionTranslator.insertChildItems(i, i2, i3);
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForChild(i, i2));
        if (flatPosition != -1) {
            notifyItemRangeInserted(flatPosition, i3);
        }
    }

    void notifyChildItemRemoved(int i, int i2) {
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForChild(i, i2));
        this.mPositionTranslator.removeChildItem(i, i2);
        if (flatPosition != -1) {
            notifyItemRemoved(flatPosition);
        }
    }

    void notifyChildItemRangeRemoved(int i, int i2, int i3) {
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForChild(i, i2));
        this.mPositionTranslator.removeChildItems(i, i2, i3);
        if (flatPosition != -1) {
            notifyItemRangeRemoved(flatPosition, i3);
        }
    }

    void notifyGroupItemInserted(int i, boolean z) {
        if (this.mPositionTranslator.insertGroupItem(i, z) > 0) {
            notifyItemInserted(this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i)));
            raiseOnGroupExpandedSequentially(i, 1, false, null);
        }
    }

    void notifyGroupItemRangeInserted(int i, int i2, boolean z) {
        int iInsertGroupItems = this.mPositionTranslator.insertGroupItems(i, i2, z);
        if (iInsertGroupItems > 0) {
            notifyItemRangeInserted(this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i)), iInsertGroupItems);
            raiseOnGroupExpandedSequentially(i, i2, false, null);
        }
    }

    void notifyGroupItemMoved(int i, int i2) {
        long packedPositionForGroup = RecyclerViewExpandableItemManager.getPackedPositionForGroup(i);
        long packedPositionForGroup2 = RecyclerViewExpandableItemManager.getPackedPositionForGroup(i2);
        int flatPosition = getFlatPosition(packedPositionForGroup);
        int flatPosition2 = getFlatPosition(packedPositionForGroup2);
        boolean zIsGroupExpanded = isGroupExpanded(i);
        boolean zIsGroupExpanded2 = isGroupExpanded(i2);
        this.mPositionTranslator.moveGroupItem(i, i2);
        if (!zIsGroupExpanded && !zIsGroupExpanded2) {
            notifyItemMoved(flatPosition, flatPosition2);
        } else {
            notifyDataSetChanged();
        }
    }

    void notifyChildItemMoved(int i, int i2, int i3) {
        notifyChildItemMoved(i, i2, i, i3);
    }

    void notifyChildItemMoved(int i, int i2, int i3, int i4) {
        long packedPositionForChild = RecyclerViewExpandableItemManager.getPackedPositionForChild(i, i2);
        long packedPositionForChild2 = RecyclerViewExpandableItemManager.getPackedPositionForChild(i3, i4);
        int flatPosition = getFlatPosition(packedPositionForChild);
        int flatPosition2 = getFlatPosition(packedPositionForChild2);
        this.mPositionTranslator.moveChildItem(i, i2, i3, i4);
        if (flatPosition != -1 && flatPosition2 != -1) {
            notifyItemMoved(flatPosition, flatPosition2);
        } else if (flatPosition != -1) {
            notifyItemRemoved(flatPosition);
        } else if (flatPosition2 != -1) {
            notifyItemInserted(flatPosition2);
        }
    }

    private void raiseOnGroupExpandedSequentially(int i, int i2, boolean z, Object obj) {
        if (this.mOnGroupExpandListener != null) {
            for (int i3 = 0; i3 < i2; i3++) {
                this.mOnGroupExpandListener.onGroupExpand(i + i3, z, obj);
            }
        }
    }

    void notifyGroupItemRemoved(int i) {
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i));
        int iRemoveGroupItem = this.mPositionTranslator.removeGroupItem(i);
        if (iRemoveGroupItem > 0) {
            notifyItemRangeRemoved(flatPosition, iRemoveGroupItem);
        }
    }

    void notifyGroupItemRangeRemoved(int i, int i2) {
        int flatPosition = this.mPositionTranslator.getFlatPosition(ExpandableAdapterHelper.getPackedPositionForGroup(i));
        int iRemoveGroupItems = this.mPositionTranslator.removeGroupItems(i, i2);
        if (iRemoveGroupItems > 0) {
            notifyItemRangeRemoved(flatPosition, iRemoveGroupItems);
        }
    }

    int getGroupCount() {
        return this.mExpandableItemAdapter.getGroupCount();
    }

    int getChildCount(int i) {
        return this.mExpandableItemAdapter.getChildCount(i);
    }

    int getExpandedGroupsCount() {
        return this.mPositionTranslator.getExpandedGroupsCount();
    }

    int getCollapsedGroupsCount() {
        return this.mPositionTranslator.getCollapsedGroupsCount();
    }

    boolean isAllGroupsExpanded() {
        return this.mPositionTranslator.isAllExpanded();
    }

    boolean isAllGroupsCollapsed() {
        return this.mPositionTranslator.isAllCollapsed();
    }

    private static ExpandableItemAdapter getExpandableItemAdapter(RecyclerView.Adapter adapter) {
        return (ExpandableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(adapter, ExpandableItemAdapter.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void safeUpdateExpandStateFlags(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ExpandableItemViewHolder) {
            ExpandableItemViewHolder expandableItemViewHolder = (ExpandableItemViewHolder) viewHolder;
            int expandStateFlags = expandableItemViewHolder.getExpandStateFlags();
            if (expandStateFlags != -1 && ((expandStateFlags ^ i) & 4) != 0) {
                i |= 8;
            }
            if (expandStateFlags == -1 || ((expandStateFlags ^ i) & Integer.MAX_VALUE) != 0) {
                i |= Integer.MIN_VALUE;
            }
            expandableItemViewHolder.setExpandStateFlags(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void correctItemDragStateFlags(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        if (viewHolder instanceof DraggableItemViewHolder) {
            DraggableItemViewHolder draggableItemViewHolder = (DraggableItemViewHolder) viewHolder;
            int i3 = this.mDraggingItemGroupRangeStart;
            boolean z = false;
            boolean z2 = (i3 == -1 || this.mDraggingItemGroupRangeEnd == -1) ? false : true;
            int i4 = this.mDraggingItemChildRangeStart;
            boolean z3 = (i4 == -1 || this.mDraggingItemChildRangeEnd == -1) ? false : true;
            boolean z4 = i >= i3 && i <= this.mDraggingItemGroupRangeEnd;
            if (i != -1 && i2 >= i4 && i2 <= this.mDraggingItemChildRangeEnd) {
                z = true;
            }
            int dragStateFlags = draggableItemViewHolder.getDragStateFlags();
            if ((dragStateFlags & 1) == 0 || (dragStateFlags & 4) != 0) {
                return;
            }
            if (!z2 || z4) {
                if (!z3 || (z3 && z)) {
                    draggableItemViewHolder.setDragStateFlags(dragStateFlags | (-2147483644));
                }
            }
        }
    }
}
