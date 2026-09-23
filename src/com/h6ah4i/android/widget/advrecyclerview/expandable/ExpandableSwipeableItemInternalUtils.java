package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;

/* JADX INFO: loaded from: classes6.dex */
class ExpandableSwipeableItemInternalUtils {
    private ExpandableSwipeableItemInternalUtils() {
    }

    public static SwipeResultAction invokeOnSwipeItem(BaseExpandableSwipeableItemAdapter<?, ?> baseExpandableSwipeableItemAdapter, RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
        if (i2 == -1) {
            return ((ExpandableSwipeableItemAdapter) baseExpandableSwipeableItemAdapter).onSwipeGroupItem(viewHolder, i, i3);
        }
        return ((ExpandableSwipeableItemAdapter) baseExpandableSwipeableItemAdapter).onSwipeChildItem(viewHolder, i, i2, i3);
    }
}
