package com.h6ah4i.android.widget.advrecyclerview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrappedAdapterUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleWrapperAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements WrapperAdapter<VH>, BridgeAdapterDataObserver.Subscriber {
    protected static final List<Object> FULL_UPDATE_PAYLOADS = Collections.emptyList();
    private static final boolean LOCAL_LOGD = false;
    private static final String TAG = "ARVSimpleWAdapter";
    private BridgeAdapterDataObserver mBridgeObserver;
    private RecyclerView.Adapter<VH> mWrappedAdapter;

    protected void onRelease() {
    }

    public SimpleWrapperAdapter(RecyclerView.Adapter<VH> adapter) {
        this.mWrappedAdapter = adapter;
        BridgeAdapterDataObserver bridgeAdapterDataObserver = new BridgeAdapterDataObserver(this, this.mWrappedAdapter, null);
        this.mBridgeObserver = bridgeAdapterDataObserver;
        this.mWrappedAdapter.registerAdapterDataObserver(bridgeAdapterDataObserver);
        super.setHasStableIds(this.mWrappedAdapter.hasStableIds());
    }

    public boolean isWrappedAdapterAlive() {
        return this.mWrappedAdapter != null;
    }

    public RecyclerView.Adapter<VH> getWrappedAdapter() {
        return this.mWrappedAdapter;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void getWrappedAdapters(List<RecyclerView.Adapter> list) {
        RecyclerView.Adapter<VH> adapter = this.mWrappedAdapter;
        if (adapter != null) {
            list.add(adapter);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void release() {
        BridgeAdapterDataObserver bridgeAdapterDataObserver;
        onRelease();
        RecyclerView.Adapter<VH> adapter = this.mWrappedAdapter;
        if (adapter != null && (bridgeAdapterDataObserver = this.mBridgeObserver) != null) {
            adapter.unregisterAdapterDataObserver(bridgeAdapterDataObserver);
        }
        this.mWrappedAdapter = null;
        this.mBridgeObserver = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (isWrappedAdapterAlive()) {
            this.mWrappedAdapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (isWrappedAdapterAlive()) {
            this.mWrappedAdapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(VH vh) {
        onViewAttachedToWindow(vh, vh.getItemViewType());
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewAttachedToWindow(VH vh, int i) {
        if (isWrappedAdapterAlive()) {
            WrappedAdapterUtils.invokeOnViewAttachedToWindow(this.mWrappedAdapter, vh, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(VH vh) {
        onViewDetachedFromWindow(vh, vh.getItemViewType());
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewDetachedFromWindow(VH vh, int i) {
        if (isWrappedAdapterAlive()) {
            WrappedAdapterUtils.invokeOnViewDetachedFromWindow(this.mWrappedAdapter, vh, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(VH vh) {
        onViewRecycled(vh, vh.getItemViewType());
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(VH vh, int i) {
        if (isWrappedAdapterAlive()) {
            WrappedAdapterUtils.invokeOnViewRecycled(this.mWrappedAdapter, vh, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(VH vh) {
        return onFailedToRecycleView(vh, vh.getItemViewType());
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public boolean onFailedToRecycleView(VH vh, int i) {
        if (isWrappedAdapterAlive() ? WrappedAdapterUtils.invokeOnFailedToRecycleView(this.mWrappedAdapter, vh, i) : false) {
            return true;
        }
        return super.onFailedToRecycleView(vh);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        if (isWrappedAdapterAlive()) {
            this.mWrappedAdapter.setHasStableIds(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (VH) this.mWrappedAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i) {
        onBindViewHolder(vh, i, FULL_UPDATE_PAYLOADS);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        if (isWrappedAdapterAlive()) {
            this.mWrappedAdapter.onBindViewHolder(vh, i, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (isWrappedAdapterAlive()) {
            return this.mWrappedAdapter.getItemCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.mWrappedAdapter.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mWrappedAdapter.getItemViewType(i);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void unwrapPosition(UnwrapPositionResult unwrapPositionResult, int i) {
        unwrapPositionResult.adapter = getWrappedAdapter();
        unwrapPositionResult.position = i;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public int wrapPosition(AdapterPathSegment adapterPathSegment, int i) {
        if (adapterPathSegment.adapter == getWrappedAdapter()) {
            return i;
        }
        return -1;
    }

    protected void onHandleWrappedAdapterChanged() {
        notifyDataSetChanged();
    }

    protected void onHandleWrappedAdapterItemRangeChanged(int i, int i2) {
        notifyItemRangeChanged(i, i2);
    }

    protected void onHandleWrappedAdapterItemRangeChanged(int i, int i2, Object obj) {
        notifyItemRangeChanged(i, i2, obj);
    }

    protected void onHandleWrappedAdapterItemRangeInserted(int i, int i2) {
        notifyItemRangeInserted(i, i2);
    }

    protected void onHandleWrappedAdapterItemRangeRemoved(int i, int i2) {
        notifyItemRangeRemoved(i, i2);
    }

    protected void onHandleWrappedAdapterRangeMoved(int i, int i2, int i3) {
        if (i3 != 1) {
            throw new IllegalStateException("itemCount should be always 1  (actual: " + i3 + ")");
        }
        notifyItemMoved(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterChanged(RecyclerView.Adapter adapter, Object obj) {
        onHandleWrappedAdapterChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeChanged(RecyclerView.Adapter adapter, Object obj, int i, int i2) {
        onHandleWrappedAdapterItemRangeChanged(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeChanged(RecyclerView.Adapter adapter, Object obj, int i, int i2, Object obj2) {
        onHandleWrappedAdapterItemRangeChanged(i, i2, obj2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeInserted(RecyclerView.Adapter adapter, Object obj, int i, int i2) {
        onHandleWrappedAdapterItemRangeInserted(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeRemoved(RecyclerView.Adapter adapter, Object obj, int i, int i2) {
        onHandleWrappedAdapterItemRangeRemoved(i, i2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterRangeMoved(RecyclerView.Adapter adapter, Object obj, int i, int i2, int i3) {
        onHandleWrappedAdapterRangeMoved(i, i2, i3);
    }
}
