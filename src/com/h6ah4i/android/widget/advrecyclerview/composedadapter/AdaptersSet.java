package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class AdaptersSet {
    public static long NO_SEGMENTED_POSITION = -1;
    private BridgeAdapterDataObserver.Subscriber mSubscriber;
    private List<ComposedChildAdapterTag> mAdapterTags = new ArrayList();
    private List<RecyclerView.Adapter> mAdapters = new ArrayList();
    private List<RecyclerView.Adapter> mUniqueAdapters = new ArrayList();
    private List<ComposedChildAdapterDataObserver> mObservers = new ArrayList();

    public static long composeSegmentedPosition(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public static int extractSegment(long j) {
        return (int) (j >>> 32);
    }

    public static int extractSegmentOffset(long j) {
        return (int) (j & 4294967295L);
    }

    public AdaptersSet(BridgeAdapterDataObserver.Subscriber subscriber) {
        this.mSubscriber = subscriber;
    }

    public ComposedChildAdapterTag addAdapter(RecyclerView.Adapter adapter, int i) {
        ComposedChildAdapterDataObserver composedChildAdapterDataObserver;
        ComposedChildAdapterTag composedChildAdapterTag = new ComposedChildAdapterTag();
        this.mAdapterTags.add(i, composedChildAdapterTag);
        this.mAdapters.add(i, adapter);
        int iIndexOf = this.mUniqueAdapters.indexOf(adapter);
        if (iIndexOf >= 0) {
            composedChildAdapterDataObserver = this.mObservers.get(iIndexOf);
        } else {
            ComposedChildAdapterDataObserver composedChildAdapterDataObserver2 = new ComposedChildAdapterDataObserver(this.mSubscriber, adapter);
            this.mObservers.add(composedChildAdapterDataObserver2);
            this.mUniqueAdapters.add(adapter);
            adapter.registerAdapterDataObserver(composedChildAdapterDataObserver2);
            composedChildAdapterDataObserver = composedChildAdapterDataObserver2;
        }
        composedChildAdapterDataObserver.registerChildAdapterTag(composedChildAdapterTag);
        return composedChildAdapterTag;
    }

    public RecyclerView.Adapter removeAdapter(ComposedChildAdapterTag composedChildAdapterTag) {
        int adapterSegment = getAdapterSegment(composedChildAdapterTag);
        if (adapterSegment < 0) {
            return null;
        }
        RecyclerView.Adapter adapterRemove = this.mAdapters.remove(adapterSegment);
        this.mAdapterTags.remove(adapterSegment);
        int iIndexOf = this.mUniqueAdapters.indexOf(adapterRemove);
        if (iIndexOf < 0) {
            throw new IllegalStateException("Something wrong. Inconsistency detected.");
        }
        ComposedChildAdapterDataObserver composedChildAdapterDataObserver = this.mObservers.get(iIndexOf);
        composedChildAdapterDataObserver.unregisterChildAdapterTag(composedChildAdapterTag);
        if (!composedChildAdapterDataObserver.hasChildAdapters()) {
            adapterRemove.unregisterAdapterDataObserver(composedChildAdapterDataObserver);
        }
        return adapterRemove;
    }

    public int getAdapterSegment(ComposedChildAdapterTag composedChildAdapterTag) {
        return this.mAdapterTags.indexOf(composedChildAdapterTag);
    }

    public int getSegmentCount() {
        return this.mAdapters.size();
    }

    public RecyclerView.Adapter getAdapter(int i) {
        return this.mAdapters.get(i);
    }

    public ComposedChildAdapterTag getTag(int i) {
        return this.mAdapterTags.get(i);
    }

    public void release() {
        this.mAdapterTags.clear();
        this.mAdapters.clear();
        int size = this.mUniqueAdapters.size();
        for (int i = 0; i < size; i++) {
            ComposedChildAdapterDataObserver composedChildAdapterDataObserver = this.mObservers.get(i);
            this.mUniqueAdapters.get(i).unregisterAdapterDataObserver(composedChildAdapterDataObserver);
            composedChildAdapterDataObserver.release();
        }
        this.mUniqueAdapters.clear();
        this.mObservers.clear();
    }

    public List<RecyclerView.Adapter> getUniqueAdaptersList() {
        return this.mUniqueAdapters;
    }
}
