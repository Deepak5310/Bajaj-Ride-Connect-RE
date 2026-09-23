package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DraggingItemInfo {
    public final int grabbedPositionX;
    public final int grabbedPositionY;
    public final int height;
    public final long id;
    public final int initialItemLeft;
    public final int initialItemTop;
    public final Rect margins;
    public final int spanSize;
    public final int width;

    public DraggingItemInfo(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, int i2) {
        this.width = viewHolder.itemView.getWidth();
        this.height = viewHolder.itemView.getHeight();
        this.id = viewHolder.getItemId();
        int left = viewHolder.itemView.getLeft();
        this.initialItemLeft = left;
        int top = viewHolder.itemView.getTop();
        this.initialItemTop = top;
        this.grabbedPositionX = i - left;
        this.grabbedPositionY = i2 - top;
        Rect rect = new Rect();
        this.margins = rect;
        CustomRecyclerViewUtils.getLayoutMargins(viewHolder.itemView, rect);
        this.spanSize = CustomRecyclerViewUtils.getSpanSize(viewHolder);
    }

    private DraggingItemInfo(DraggingItemInfo draggingItemInfo, RecyclerView.ViewHolder viewHolder) {
        this.id = draggingItemInfo.id;
        int width = viewHolder.itemView.getWidth();
        this.width = width;
        int height = viewHolder.itemView.getHeight();
        this.height = height;
        this.margins = new Rect(draggingItemInfo.margins);
        this.spanSize = CustomRecyclerViewUtils.getSpanSize(viewHolder);
        this.initialItemLeft = draggingItemInfo.initialItemLeft;
        this.initialItemTop = draggingItemInfo.initialItemTop;
        float f = draggingItemInfo.width * 0.5f;
        float f2 = draggingItemInfo.height * 0.5f;
        float f3 = width * 0.5f;
        float f4 = height * 0.5f;
        float f5 = (draggingItemInfo.grabbedPositionX - f) + f3;
        float f6 = (draggingItemInfo.grabbedPositionY - f2) + f4;
        if (f5 >= 0.0f && f5 < width) {
            f3 = f5;
        }
        this.grabbedPositionX = (int) f3;
        if (f6 >= 0.0f && f6 < height) {
            f4 = f6;
        }
        this.grabbedPositionY = (int) f4;
    }

    public static DraggingItemInfo createWithNewView(DraggingItemInfo draggingItemInfo, RecyclerView.ViewHolder viewHolder) {
        return new DraggingItemInfo(draggingItemInfo, viewHolder);
    }
}
