package com.afollestad.sectionedrecyclerview;

import android.support.v4.util.ArrayMap;

/* JADX INFO: loaded from: classes3.dex */
class PositionManager implements SectionedViewHolder.PositionDelegate {
    private boolean hasInvalidated;
    private ItemProvider itemProvider;
    private final ArrayMap<Integer, Integer> headerLocationMap = new ArrayMap<>(0);
    private final ArrayMap<Integer, Integer> footerLocationMap = new ArrayMap<>(0);
    private final ArrayMap<Integer, Boolean> collapsedSectionMap = new ArrayMap<>(0);

    PositionManager() {
    }

    boolean hasInvalidated() {
        return this.hasInvalidated;
    }

    int invalidate(ItemProvider itemProvider) {
        this.hasInvalidated = true;
        this.itemProvider = itemProvider;
        this.headerLocationMap.clear();
        this.footerLocationMap.clear();
        int i = 0;
        for (int i2 = 0; i2 < itemProvider.getSectionCount(); i2++) {
            int itemCount = itemProvider.getItemCount(i2);
            if (this.collapsedSectionMap.get(Integer.valueOf(i2)) != null) {
                this.headerLocationMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                if (itemProvider.showHeadersForEmptySections() || itemCount > 0) {
                    this.headerLocationMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                    i += itemCount + 1;
                    if (itemProvider.showFooters()) {
                        this.footerLocationMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                    }
                }
            }
            i++;
        }
        return i;
    }

    @Override // com.afollestad.sectionedrecyclerview.SectionedViewHolder.PositionDelegate
    public boolean isHeader(int i) {
        return this.headerLocationMap.get(Integer.valueOf(i)) != null;
    }

    @Override // com.afollestad.sectionedrecyclerview.SectionedViewHolder.PositionDelegate
    public boolean isFooter(int i) {
        return this.footerLocationMap.get(Integer.valueOf(i)) != null;
    }

    int sectionId(int i) {
        Integer num = (Integer) this.headerLocationMap.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    int footerId(int i) {
        Integer num = (Integer) this.footerLocationMap.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    int sectionHeaderIndex(int i) {
        for (Integer num : this.headerLocationMap.keySet()) {
            if (((Integer) this.headerLocationMap.get(num)).intValue() == i) {
                return num.intValue();
            }
        }
        return -1;
    }

    int sectionFooterIndex(int i) {
        for (Integer num : this.footerLocationMap.keySet()) {
            if (((Integer) this.footerLocationMap.get(num)).intValue() == i) {
                return num.intValue();
            }
        }
        return -1;
    }

    @Override // com.afollestad.sectionedrecyclerview.SectionedViewHolder.PositionDelegate
    public ItemCoord relativePosition(int i) {
        Integer num = (Integer) this.headerLocationMap.get(Integer.valueOf(i));
        if (num != null) {
            return new ItemCoord(num.intValue(), -1);
        }
        Integer num2 = -1;
        for (Integer num3 : this.headerLocationMap.keySet()) {
            if (i <= num3.intValue()) {
                break;
            }
            num2 = num3;
        }
        return new ItemCoord(((Integer) this.headerLocationMap.get(num2)).intValue(), (i - num2.intValue()) - 1);
    }

    int absolutePosition(int i, int i2) {
        if (i < 0 || i > this.itemProvider.getSectionCount() - 1) {
            return -1;
        }
        int iSectionHeaderIndex = sectionHeaderIndex(i);
        if (i2 > this.itemProvider.getItemCount(i) - 1) {
            return -1;
        }
        return iSectionHeaderIndex + i2 + 1;
    }

    int absolutePosition(ItemCoord itemCoord) {
        return absolutePosition(itemCoord.section(), itemCoord.relativePos());
    }

    void expandSection(int i) {
        if (i < 0 || i > this.itemProvider.getSectionCount() - 1) {
            throw new IllegalArgumentException("Section " + i + " is out of bounds.");
        }
        this.collapsedSectionMap.remove(Integer.valueOf(i));
    }

    void collapseSection(int i) {
        if (i < 0 || i > this.itemProvider.getSectionCount() - 1) {
            throw new IllegalArgumentException("Section " + i + " is out of bounds.");
        }
        this.collapsedSectionMap.put(Integer.valueOf(i), true);
    }

    void toggleSectionExpanded(int i) {
        if (this.collapsedSectionMap.get(Integer.valueOf(i)) != null) {
            expandSection(i);
        } else {
            collapseSection(i);
        }
    }

    void expandAllSections() {
        for (int i = 0; i < this.itemProvider.getSectionCount(); i++) {
            expandSection(i);
        }
    }

    void collapseAllSections() {
        for (int i = 0; i < this.itemProvider.getSectionCount(); i++) {
            collapseSection(i);
        }
    }

    boolean isSectionExpanded(int i) {
        if (i >= 0 && i <= this.itemProvider.getSectionCount() - 1) {
            return this.collapsedSectionMap.get(Integer.valueOf(i)) == null;
        }
        throw new IllegalArgumentException("Section " + i + " is out of bounds.");
    }
}
