package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class AdapterPath {
    private final List<AdapterPathSegment> mSegments = new ArrayList();

    public AdapterPath append(UnwrapPositionResult unwrapPositionResult) {
        return append(unwrapPositionResult.adapter, unwrapPositionResult.tag);
    }

    public AdapterPath append(RecyclerView.Adapter adapter, Object obj) {
        return append(new AdapterPathSegment(adapter, obj));
    }

    public AdapterPath append(AdapterPathSegment adapterPathSegment) {
        this.mSegments.add(adapterPathSegment);
        return this;
    }

    public AdapterPath clear() {
        this.mSegments.clear();
        return this;
    }

    public boolean isEmpty() {
        return this.mSegments.isEmpty();
    }

    public List<AdapterPathSegment> segments() {
        return this.mSegments;
    }

    public AdapterPathSegment firstSegment() {
        if (this.mSegments.isEmpty()) {
            return null;
        }
        return this.mSegments.get(0);
    }

    public AdapterPathSegment lastSegment() {
        if (this.mSegments.isEmpty()) {
            return null;
        }
        List<AdapterPathSegment> list = this.mSegments;
        return list.get(list.size() - 1);
    }
}
