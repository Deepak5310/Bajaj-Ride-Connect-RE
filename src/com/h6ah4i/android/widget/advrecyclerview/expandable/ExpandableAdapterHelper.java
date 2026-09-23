package com.h6ah4i.android.widget.advrecyclerview.expandable;

/* JADX INFO: loaded from: classes6.dex */
class ExpandableAdapterHelper {
    private static final long LOWER_31BIT_MASK = 2147483647L;
    private static final long LOWER_32BIT_MASK = 4294967295L;
    public static final long NO_EXPANDABLE_POSITION = -1;

    public static int getPackedPositionChild(long j) {
        return (int) (j >>> 32);
    }

    public static long getPackedPositionForChild(int i, int i2) {
        return (((long) i) & LOWER_32BIT_MASK) | (((long) i2) << 32);
    }

    public static long getPackedPositionForGroup(int i) {
        return (((long) i) & LOWER_32BIT_MASK) | (-4294967296L);
    }

    public static int getPackedPositionGroup(long j) {
        return (int) (j & LOWER_32BIT_MASK);
    }

    private ExpandableAdapterHelper() {
    }
}
