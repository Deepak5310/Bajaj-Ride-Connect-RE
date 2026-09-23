package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes6.dex */
public interface WrappedAdapter<VH extends RecyclerView.ViewHolder> {
    boolean onFailedToRecycleView(VH vh, int i);

    void onViewAttachedToWindow(VH vh, int i);

    void onViewDetachedFromWindow(VH vh, int i);

    void onViewRecycled(VH vh, int i);
}
