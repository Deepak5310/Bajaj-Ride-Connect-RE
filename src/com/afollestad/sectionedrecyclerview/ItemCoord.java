package com.afollestad.sectionedrecyclerview;

/* JADX INFO: loaded from: classes3.dex */
public class ItemCoord {
    private final int relativePos;
    private final int section;

    ItemCoord(int i, int i2) {
        this.section = i;
        this.relativePos = i2;
    }

    public int section() {
        return this.section;
    }

    public int relativePos() {
        return this.relativePos;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ItemCoord) {
            ItemCoord itemCoord = (ItemCoord) obj;
            if (itemCoord.section() == section() && itemCoord.relativePos() == relativePos()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.section + ":" + this.relativePos;
    }
}
