package com.h6ah4i.android.widget.advrecyclerview.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter;

/* JADX INFO: loaded from: classes6.dex */
public class WrappedAdapterUtils {
    private WrappedAdapterUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void invokeOnViewRecycled(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i) {
        if (adapter instanceof WrapperAdapter) {
            ((WrapperAdapter) adapter).onViewRecycled(viewHolder, i);
        } else {
            adapter.onViewRecycled(viewHolder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean invokeOnFailedToRecycleView(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i) {
        if (adapter instanceof WrappedAdapter) {
            return ((WrappedAdapter) adapter).onFailedToRecycleView(viewHolder, i);
        }
        return adapter.onFailedToRecycleView(viewHolder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void invokeOnViewAttachedToWindow(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i) {
        if (adapter instanceof WrappedAdapter) {
            ((WrappedAdapter) adapter).onViewAttachedToWindow(viewHolder, i);
        } else {
            adapter.onViewAttachedToWindow(viewHolder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void invokeOnViewDetachedFromWindow(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i) {
        if (adapter instanceof WrappedAdapter) {
            ((WrappedAdapter) adapter).onViewDetachedFromWindow(viewHolder, i);
        } else {
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }
}
