package com.h6ah4i.android.widget.advrecyclerview.draggable;

/* JADX INFO: loaded from: classes6.dex */
public class ItemDraggableRange {
    private final int mEnd;
    private final int mStart;

    public ItemDraggableRange(int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException("end position (= " + i2 + ") is smaller than start position (=" + i + ")");
        }
        this.mStart = i;
        this.mEnd = i2;
    }

    public int getStart() {
        return this.mStart;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public boolean checkInRange(int i) {
        return i >= this.mStart && i <= this.mEnd;
    }

    protected String getClassName() {
        return "ItemDraggableRange";
    }

    public String toString() {
        return getClassName() + "{mStart=" + this.mStart + ", mEnd=" + this.mEnd + '}';
    }
}
