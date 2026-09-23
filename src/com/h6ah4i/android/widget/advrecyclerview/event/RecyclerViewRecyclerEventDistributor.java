package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class RecyclerViewRecyclerEventDistributor extends BaseRecyclerViewEventDistributor<RecyclerView.RecyclerListener> {
    private InternalRecyclerListener mInternalRecyclerListener = new InternalRecyclerListener(this);

    @Override // com.h6ah4i.android.widget.advrecyclerview.event.BaseRecyclerViewEventDistributor
    protected void onRecyclerViewAttached(RecyclerView recyclerView) {
        super.onRecyclerViewAttached(recyclerView);
        recyclerView.setRecyclerListener(this.mInternalRecyclerListener);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.event.BaseRecyclerViewEventDistributor
    protected void onRelease() {
        super.onRelease();
        InternalRecyclerListener internalRecyclerListener = this.mInternalRecyclerListener;
        if (internalRecyclerListener != null) {
            internalRecyclerListener.release();
            this.mInternalRecyclerListener = null;
        }
    }

    void handleOnViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (this.mListeners == null) {
            return;
        }
        Iterator it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            ((RecyclerView.RecyclerListener) it2.next()).onViewRecycled(viewHolder);
        }
    }

    private static class InternalRecyclerListener implements RecyclerView.RecyclerListener {
        private final WeakReference<RecyclerViewRecyclerEventDistributor> mRefDistributor;

        public InternalRecyclerListener(RecyclerViewRecyclerEventDistributor recyclerViewRecyclerEventDistributor) {
            this.mRefDistributor = new WeakReference<>(recyclerViewRecyclerEventDistributor);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            RecyclerViewRecyclerEventDistributor recyclerViewRecyclerEventDistributor = this.mRefDistributor.get();
            if (recyclerViewRecyclerEventDistributor != null) {
                recyclerViewRecyclerEventDistributor.handleOnViewRecycled(viewHolder);
            }
        }

        public void release() {
            this.mRefDistributor.clear();
        }
    }
}
