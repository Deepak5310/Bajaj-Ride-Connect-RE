package com.h6ah4i.android.widget.advrecyclerview.headerfooter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPathSegment;
import com.h6ah4i.android.widget.advrecyclerview.composedadapter.ComposedAdapter;
import com.h6ah4i.android.widget.advrecyclerview.composedadapter.ComposedChildAdapterTag;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractHeaderFooterWrapperAdapter<HeaderVH extends RecyclerView.ViewHolder, FooterVH extends RecyclerView.ViewHolder> extends ComposedAdapter {
    public static final int SEGMENT_TYPE_FOOTER = 2;
    public static final int SEGMENT_TYPE_HEADER = 0;
    public static final int SEGMENT_TYPE_NORMAL = 1;
    private RecyclerView.Adapter mFooterAdapter;
    private ComposedChildAdapterTag mFooterAdapterTag;
    private RecyclerView.Adapter mHeaderAdapter;
    private ComposedChildAdapterTag mHeaderAdapterTag;
    private RecyclerView.Adapter mWrappedAdapter;
    private ComposedChildAdapterTag mWrappedAdapterTag;

    public abstract int getFooterItemCount();

    public int getFooterItemViewType(int i) {
        return 0;
    }

    public abstract int getHeaderItemCount();

    public int getHeaderItemViewType(int i) {
        return 0;
    }

    public abstract void onBindFooterItemViewHolder(FooterVH footervh, int i);

    public abstract void onBindHeaderItemViewHolder(HeaderVH headervh, int i);

    public abstract FooterVH onCreateFooterItemViewHolder(ViewGroup viewGroup, int i);

    public abstract HeaderVH onCreateHeaderItemViewHolder(ViewGroup viewGroup, int i);

    public AbstractHeaderFooterWrapperAdapter setAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        if (this.mWrappedAdapter != null) {
            throw new IllegalStateException("setAdapter() can call only once");
        }
        this.mWrappedAdapter = adapter;
        this.mHeaderAdapter = onCreateHeaderAdapter();
        this.mFooterAdapter = onCreateFooterAdapter();
        boolean zHasStableIds = adapter.hasStableIds();
        this.mHeaderAdapter.setHasStableIds(zHasStableIds);
        this.mFooterAdapter.setHasStableIds(zHasStableIds);
        setHasStableIds(zHasStableIds);
        this.mHeaderAdapterTag = addAdapter(this.mHeaderAdapter);
        this.mWrappedAdapterTag = addAdapter(this.mWrappedAdapter);
        this.mFooterAdapterTag = addAdapter(this.mFooterAdapter);
        return this;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.composedadapter.ComposedAdapter
    protected void onRelease() {
        super.onRelease();
        this.mHeaderAdapterTag = null;
        this.mWrappedAdapterTag = null;
        this.mFooterAdapterTag = null;
        this.mHeaderAdapter = null;
        this.mWrappedAdapter = null;
        this.mFooterAdapter = null;
    }

    protected RecyclerView.Adapter onCreateHeaderAdapter() {
        return new BaseHeaderAdapter(this);
    }

    protected RecyclerView.Adapter onCreateFooterAdapter() {
        return new BaseFooterAdapter(this);
    }

    public RecyclerView.Adapter getHeaderAdapter() {
        return this.mHeaderAdapter;
    }

    public RecyclerView.Adapter getFooterAdapter() {
        return this.mFooterAdapter;
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.mWrappedAdapter;
    }

    public AdapterPathSegment getWrappedAdapterSegment() {
        return new AdapterPathSegment(this.mWrappedAdapter, this.mWrappedAdapterTag);
    }

    public AdapterPathSegment getHeaderSegment() {
        return new AdapterPathSegment(this.mHeaderAdapter, this.mHeaderAdapterTag);
    }

    public AdapterPathSegment getFooterSegment() {
        return new AdapterPathSegment(this.mFooterAdapter, this.mFooterAdapterTag);
    }

    public void onBindHeaderItemViewHolder(HeaderVH headervh, int i, List<Object> list) {
        onBindHeaderItemViewHolder(headervh, i);
    }

    public void onBindFooterItemViewHolder(FooterVH footervh, int i, List<Object> list) {
        onBindFooterItemViewHolder(footervh, i);
    }

    public long getHeaderItemId(int i) {
        if (hasStableIds()) {
            return -1L;
        }
        return i;
    }

    public long getFooterItemId(int i) {
        if (hasStableIds()) {
            return -1L;
        }
        return i;
    }

    public static class BaseHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected AbstractHeaderFooterWrapperAdapter mHolder;

        public BaseHeaderAdapter(AbstractHeaderFooterWrapperAdapter abstractHeaderFooterWrapperAdapter) {
            this.mHolder = abstractHeaderFooterWrapperAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mHolder.getHeaderItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.mHolder.getHeaderItemId(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.mHolder.getHeaderItemViewType(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.mHolder.onCreateHeaderItemViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            throw new IllegalStateException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
            this.mHolder.onBindHeaderItemViewHolder(viewHolder, i, list);
        }
    }

    public static class BaseFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected AbstractHeaderFooterWrapperAdapter mHolder;

        public BaseFooterAdapter(AbstractHeaderFooterWrapperAdapter abstractHeaderFooterWrapperAdapter) {
            this.mHolder = abstractHeaderFooterWrapperAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mHolder.getFooterItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.mHolder.getFooterItemId(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.mHolder.getFooterItemViewType(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.mHolder.onCreateFooterItemViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            throw new IllegalStateException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
            this.mHolder.onBindFooterItemViewHolder(viewHolder, i, list);
        }
    }
}
