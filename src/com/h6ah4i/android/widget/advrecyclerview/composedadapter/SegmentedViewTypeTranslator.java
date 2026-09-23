package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import android.util.SparseIntArray;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
class SegmentedViewTypeTranslator {
    private SparseIntArray mWrapSegmentMap = new SparseIntArray();
    private SparseIntArray mUnwrapSegmentMap = new SparseIntArray();

    public static int extractWrapperSegment(long j) {
        return (int) ((j >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    public int wrapItemViewType(int i, int i2) {
        int iValueAt;
        int iExtractSegmentPart = (i << 16) | ItemViewTypeComposer.extractSegmentPart(i2);
        int iIndexOfKey = this.mWrapSegmentMap.indexOfKey(iExtractSegmentPart);
        if (iIndexOfKey >= 0) {
            iValueAt = this.mWrapSegmentMap.valueAt(iIndexOfKey);
        } else {
            int size = this.mWrapSegmentMap.size() + 1;
            if (size > 127) {
                throw new IllegalStateException("Failed to allocate a new wrapped view type.");
            }
            this.mWrapSegmentMap.put(iExtractSegmentPart, size);
            this.mUnwrapSegmentMap.put(size, iExtractSegmentPart);
            iValueAt = size;
        }
        return ItemViewTypeComposer.composeSegment(iValueAt, i2);
    }

    public long unwrapViewType(int i) {
        int iIndexOfKey = this.mUnwrapSegmentMap.indexOfKey(ItemViewTypeComposer.extractSegmentPart(i));
        if (iIndexOfKey < 0) {
            throw new IllegalStateException("Corresponding wrapped view type is not found!");
        }
        return (((long) this.mUnwrapSegmentMap.valueAt(iIndexOfKey)) << 32) | (((long) i) & 4294967295L);
    }

    public static int extractWrappedViewType(long j) {
        return ItemViewTypeComposer.composeSegment(((int) (j >>> 32)) & 65535, (int) (j & 4294967295L));
    }
}
