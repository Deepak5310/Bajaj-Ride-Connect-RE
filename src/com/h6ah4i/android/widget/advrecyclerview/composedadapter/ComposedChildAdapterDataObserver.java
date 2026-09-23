package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class ComposedChildAdapterDataObserver extends BridgeAdapterDataObserver {
    public ComposedChildAdapterDataObserver(BridgeAdapterDataObserver.Subscriber subscriber, RecyclerView.Adapter adapter) {
        super(subscriber, adapter, new ArrayList());
    }

    private List<ComposedChildAdapterTag> getChildAdapterTags() {
        return (List) getTag();
    }

    public void registerChildAdapterTag(ComposedChildAdapterTag composedChildAdapterTag) {
        getChildAdapterTags().add(composedChildAdapterTag);
    }

    public void unregisterChildAdapterTag(ComposedChildAdapterTag composedChildAdapterTag) {
        getChildAdapterTags().remove(composedChildAdapterTag);
    }

    public boolean hasChildAdapters() {
        return !getChildAdapterTags().isEmpty();
    }

    public void release() {
        getChildAdapterTags().clear();
    }
}
