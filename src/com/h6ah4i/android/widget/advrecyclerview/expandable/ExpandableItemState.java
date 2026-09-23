package com.h6ah4i.android.widget.advrecyclerview.expandable;

/* JADX INFO: loaded from: classes6.dex */
public class ExpandableItemState {
    private int mFlags;

    public int getFlags() {
        return this.mFlags;
    }

    public void setFlags(int i) {
        this.mFlags = i;
    }

    public boolean isSwiping() {
        return (this.mFlags & 4) != 0;
    }

    public boolean isChild() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isGroup() {
        return (this.mFlags & 1) != 0;
    }

    public boolean isExpanded() {
        return (this.mFlags & 4) != 0;
    }

    public boolean hasExpandedStateChanged() {
        return (this.mFlags & 8) != 0;
    }

    public boolean isUpdated() {
        return (this.mFlags & Integer.MIN_VALUE) != 0;
    }
}
