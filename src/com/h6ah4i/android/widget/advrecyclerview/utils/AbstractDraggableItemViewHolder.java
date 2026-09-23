package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemState;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractDraggableItemViewHolder extends RecyclerView.ViewHolder implements DraggableItemViewHolder {
    private final DraggableItemState mDragState;

    public AbstractDraggableItemViewHolder(View view) {
        super(view);
        this.mDragState = new DraggableItemState();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder
    public void setDragStateFlags(int i) {
        this.mDragState.setFlags(i);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder
    public int getDragStateFlags() {
        return this.mDragState.getFlags();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder
    public DraggableItemState getDragState() {
        return this.mDragState;
    }
}
