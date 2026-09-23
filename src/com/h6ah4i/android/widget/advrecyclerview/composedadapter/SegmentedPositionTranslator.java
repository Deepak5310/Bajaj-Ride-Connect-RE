package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
class SegmentedPositionTranslator {
    private static final int NO_CACHED_ITEM_COUNT = -1;
    private static final int NO_CACHED_SEGMENT = 0;
    private AdaptersSet mAdaptersSet;
    private int[] mSegmentItemCountCache;
    private int mLastOffsetCachedSegment = 0;
    private int mCachedTotalItemCount = -1;
    private int[] mSegmentOffsetCache = new int[128];

    public SegmentedPositionTranslator(AdaptersSet adaptersSet) {
        this.mAdaptersSet = adaptersSet;
        int[] iArr = new int[128];
        this.mSegmentItemCountCache = iArr;
        Arrays.fill(iArr, -1);
    }

    public int getTotalItemCount() {
        if (this.mCachedTotalItemCount == -1) {
            this.mCachedTotalItemCount = countTotalItems();
        }
        return this.mCachedTotalItemCount;
    }

    public int getFlatPosition(int i, int i2) {
        return getSegmentOffset(i) + i2;
    }

    public long getSegmentedPosition(int i) {
        int i2 = -1;
        if (i == -1) {
            return -1L;
        }
        int i3 = 0;
        int iBinarySearch = Arrays.binarySearch(this.mSegmentOffsetCache, 0, this.mLastOffsetCachedSegment, i);
        if (iBinarySearch >= 0) {
            i2 = iBinarySearch;
        } else {
            iBinarySearch = Math.max(0, (~iBinarySearch) - 1);
            i3 = -1;
        }
        int segmentCount = this.mAdaptersSet.getSegmentCount();
        int i4 = this.mSegmentOffsetCache[iBinarySearch];
        while (iBinarySearch < segmentCount) {
            int segmentItemCount = getSegmentItemCount(iBinarySearch) + i4;
            if (segmentItemCount > i) {
                i3 = i - i4;
                i2 = iBinarySearch;
                break;
            }
            iBinarySearch++;
            i4 = segmentItemCount;
        }
        if (i2 >= 0) {
            return AdaptersSet.composeSegmentedPosition(i2, i3);
        }
        return AdaptersSet.NO_SEGMENTED_POSITION;
    }

    private int countTotalItems() {
        int segmentCount = this.mAdaptersSet.getSegmentCount();
        if (segmentCount == 0) {
            return 0;
        }
        int i = segmentCount - 1;
        return getSegmentOffset(i) + getSegmentItemCount(i);
    }

    public int getSegmentOffset(int i) {
        if (i <= this.mLastOffsetCachedSegment) {
            return this.mSegmentOffsetCache[i];
        }
        this.mAdaptersSet.getSegmentCount();
        int i2 = this.mLastOffsetCachedSegment;
        int segmentItemCount = this.mSegmentOffsetCache[i2];
        while (i2 < i) {
            segmentItemCount += getSegmentItemCount(i2);
            i2++;
        }
        return segmentItemCount;
    }

    public int getSegmentItemCount(int i) {
        int i2 = this.mSegmentItemCountCache[i];
        if (i2 != -1) {
            return i2;
        }
        int itemCount = this.mAdaptersSet.getAdapter(i).getItemCount();
        this.mSegmentItemCountCache[i] = itemCount;
        if (i == this.mLastOffsetCachedSegment) {
            int[] iArr = this.mSegmentOffsetCache;
            int i3 = i + 1;
            iArr[i3] = iArr[i] + itemCount;
            this.mLastOffsetCachedSegment = i3;
        }
        return itemCount;
    }

    public void invalidateSegment(int i) {
        this.mCachedTotalItemCount = -1;
        this.mLastOffsetCachedSegment = Math.min(this.mLastOffsetCachedSegment, i);
        this.mSegmentItemCountCache[i] = -1;
    }

    public void invalidateAll() {
        this.mCachedTotalItemCount = -1;
        this.mLastOffsetCachedSegment = 0;
        Arrays.fill(this.mSegmentItemCountCache, -1);
    }

    public void release() {
        this.mAdaptersSet = null;
        this.mSegmentItemCountCache = null;
        this.mSegmentOffsetCache = null;
    }
}
