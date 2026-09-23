package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;

/* JADX INFO: loaded from: classes6.dex */
public interface ExpandableDraggableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    boolean onCheckChildCanDrop(int i, int i2, int i3, int i4);

    boolean onCheckChildCanStartDrag(CVH cvh, int i, int i2, int i3, int i4);

    boolean onCheckGroupCanDrop(int i, int i2);

    boolean onCheckGroupCanStartDrag(GVH gvh, int i, int i2, int i3);

    void onChildDragFinished(int i, int i2, int i3, int i4, boolean z);

    void onChildDragStarted(int i, int i2);

    ItemDraggableRange onGetChildItemDraggableRange(CVH cvh, int i, int i2);

    ItemDraggableRange onGetGroupItemDraggableRange(GVH gvh, int i);

    void onGroupDragFinished(int i, int i2, boolean z);

    void onGroupDragStarted(int i);

    void onMoveChildItem(int i, int i2, int i3, int i4);

    void onMoveGroupItem(int i, int i2);
}
