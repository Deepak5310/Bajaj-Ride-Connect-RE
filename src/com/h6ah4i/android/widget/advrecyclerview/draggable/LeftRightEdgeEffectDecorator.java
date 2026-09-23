package com.h6ah4i.android.widget.advrecyclerview.draggable;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
class LeftRightEdgeEffectDecorator extends BaseEdgeEffectDecorator {
    public LeftRightEdgeEffectDecorator(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.BaseEdgeEffectDecorator
    protected int getEdgeDirection(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 2;
        }
        throw new IllegalArgumentException();
    }
}
