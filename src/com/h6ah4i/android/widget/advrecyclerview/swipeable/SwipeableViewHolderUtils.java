package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
class SwipeableViewHolderUtils {
    SwipeableViewHolderUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static View getSwipeableContainerView(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof SwipeableItemViewHolder) {
            return getSwipeableContainerView((SwipeableItemViewHolder) viewHolder);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static View getSwipeableContainerView(SwipeableItemViewHolder swipeableItemViewHolder) {
        if (!(swipeableItemViewHolder instanceof RecyclerView.ViewHolder)) {
            return null;
        }
        View swipeableContainerView = swipeableItemViewHolder.getSwipeableContainerView();
        if (swipeableContainerView != ((RecyclerView.ViewHolder) swipeableItemViewHolder).itemView) {
            return swipeableContainerView;
        }
        throw new IllegalStateException("Inconsistency detected! getSwipeableContainerView() returns itemView");
    }
}
