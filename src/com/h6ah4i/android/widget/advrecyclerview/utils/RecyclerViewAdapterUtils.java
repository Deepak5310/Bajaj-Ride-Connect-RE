package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class RecyclerViewAdapterUtils {
    private RecyclerViewAdapterUtils() {
    }

    public static RecyclerView getParentRecyclerView(View view) {
        if (view == null) {
            return null;
        }
        Object parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return (RecyclerView) parent;
        }
        if (parent instanceof View) {
            return getParentRecyclerView((View) parent);
        }
        return null;
    }

    public static View getParentViewHolderItemView(View view) {
        RecyclerView parentRecyclerView = getParentRecyclerView(view);
        if (parentRecyclerView == null) {
            return null;
        }
        return parentRecyclerView.findContainingItemView(view);
    }

    public static RecyclerView.ViewHolder getViewHolder(View view) {
        RecyclerView parentRecyclerView = getParentRecyclerView(view);
        if (parentRecyclerView == null) {
            return null;
        }
        return parentRecyclerView.findContainingViewHolder(view);
    }
}
