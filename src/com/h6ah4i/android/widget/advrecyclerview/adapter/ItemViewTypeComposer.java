package com.h6ah4i.android.widget.advrecyclerview.adapter;

/* JADX INFO: loaded from: classes6.dex */
public class ItemViewTypeComposer {
    public static final int BIT_MASK_EXPANDABLE_FLAG = Integer.MIN_VALUE;
    public static final int BIT_MASK_SEGMENT = 2130706432;
    public static final int BIT_MASK_WRAPPED_VIEW_TYPE = 16777215;
    public static final int BIT_OFFSET_EXPANDABLE_FLAG = 31;
    public static final int BIT_OFFSET_SEGMENT = 24;
    public static final int BIT_OFFSET_WRAPPED_VIEW_TYPE = 0;
    public static final int BIT_WIDTH_EXPANDABLE_FLAG = 1;
    public static final int BIT_WIDTH_SEGMENT = 7;
    public static final int BIT_WIDTH_WRAPPED_VIEW_TYPE = 24;
    public static final int MAX_SEGMENT = 127;
    public static final int MAX_WRAPPED_VIEW_TYPE = 8388607;
    public static final int MIN_SEGMENT = 0;
    public static final int MIN_WRAPPED_VIEW_TYPE = -8388608;

    public static int extractSegmentPart(int i) {
        return (i & BIT_MASK_SEGMENT) >>> 24;
    }

    public static int extractWrappedViewTypePart(int i) {
        return (i << 8) >> 8;
    }

    public static boolean isExpandableGroup(int i) {
        return (i & Integer.MIN_VALUE) != 0;
    }

    private ItemViewTypeComposer() {
    }

    public static int composeSegment(int i, int i2) {
        if (i >= 0 && i <= 127) {
            return (i << 24) | (i2 & (-2130706433));
        }
        throw new IllegalArgumentException("Segment value is out of range. (segment = " + i + ")");
    }
}
