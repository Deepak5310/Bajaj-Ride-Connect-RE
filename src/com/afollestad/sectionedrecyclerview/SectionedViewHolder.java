package com.afollestad.sectionedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SectionedViewHolder extends RecyclerView.ViewHolder {
    private PositionDelegate positionDelegate;

    interface PositionDelegate {
        boolean isFooter(int i);

        boolean isHeader(int i);

        ItemCoord relativePosition(int i);
    }

    public SectionedViewHolder(View view) {
        super(view);
    }

    void setPositionDelegate(PositionDelegate positionDelegate) {
        this.positionDelegate = positionDelegate;
    }

    protected ItemCoord getRelativePosition() {
        return this.positionDelegate.relativePosition(getAdapterPosition());
    }

    protected boolean isHeader() {
        return this.positionDelegate.isHeader(getAdapterPosition());
    }

    protected boolean isFooter() {
        return this.positionDelegate.isFooter(getAdapterPosition());
    }
}
