package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemState;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractExpandableItemViewHolder extends RecyclerView.ViewHolder implements ExpandableItemViewHolder {
    private final ExpandableItemState mExpandState;

    public AbstractExpandableItemViewHolder(View view) {
        super(view);
        this.mExpandState = new ExpandableItemState();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder
    public void setExpandStateFlags(int i) {
        this.mExpandState.setFlags(i);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder
    public int getExpandStateFlags() {
        return this.mExpandState.getFlags();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder
    public ExpandableItemState getExpandState() {
        return this.mExpandState;
    }
}
