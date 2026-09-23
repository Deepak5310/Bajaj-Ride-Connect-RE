package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ExpandableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    int getChildCount(int i);

    long getChildId(int i, int i2);

    int getChildItemViewType(int i, int i2);

    int getGroupCount();

    long getGroupId(int i);

    int getGroupItemViewType(int i);

    boolean getInitialGroupExpandedState(int i);

    void onBindChildViewHolder(CVH cvh, int i, int i2, int i3);

    void onBindChildViewHolder(CVH cvh, int i, int i2, int i3, List<Object> list);

    void onBindGroupViewHolder(GVH gvh, int i, int i2);

    void onBindGroupViewHolder(GVH gvh, int i, int i2, List<Object> list);

    boolean onCheckCanExpandOrCollapseGroup(GVH gvh, int i, int i2, int i3, boolean z);

    CVH onCreateChildViewHolder(ViewGroup viewGroup, int i);

    GVH onCreateGroupViewHolder(ViewGroup viewGroup, int i);

    boolean onHookGroupCollapse(int i, boolean z);

    boolean onHookGroupCollapse(int i, boolean z, Object obj);

    boolean onHookGroupExpand(int i, boolean z);

    boolean onHookGroupExpand(int i, boolean z, Object obj);
}
