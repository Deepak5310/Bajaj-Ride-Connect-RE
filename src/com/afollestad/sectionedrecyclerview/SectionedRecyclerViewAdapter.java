package com.afollestad.sectionedrecyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import com.afollestad.sectionedrecyclerview.SectionedViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SectionedRecyclerViewAdapter<VH extends SectionedViewHolder> extends RecyclerView.Adapter<VH> implements ItemProvider {
    private static final String TAG = "SectionedRVAdapter";
    protected static final int VIEW_TYPE_FOOTER = -3;
    protected static final int VIEW_TYPE_HEADER = -2;
    protected static final int VIEW_TYPE_ITEM = -1;
    private GridLayoutManager layoutManager;
    private PositionManager positionManager = new PositionManager();
    private boolean showFooters;
    private boolean showHeadersForEmptySections;

    public int getFooterViewType(int i) {
        return -3;
    }

    public int getHeaderViewType(int i) {
        return -2;
    }

    @Override // com.afollestad.sectionedrecyclerview.ItemProvider
    public abstract int getItemCount(int i);

    public int getItemViewType(int i, int i2, int i3) {
        return -1;
    }

    protected int getRowSpan(int i, int i2, int i3, int i4) {
        return 1;
    }

    @Override // com.afollestad.sectionedrecyclerview.ItemProvider
    public abstract int getSectionCount();

    public abstract void onBindFooterViewHolder(VH vh, int i);

    public abstract void onBindHeaderViewHolder(VH vh, int i, boolean z);

    public abstract void onBindViewHolder(VH vh, int i, int i2, int i3);

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @Deprecated
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((SectionedViewHolder) viewHolder, i, (List<Object>) list);
    }

    public void notifySectionChanged(int i) {
        if (i < 0 || i > getSectionCount() - 1) {
            throw new IllegalArgumentException("Section " + i + " is out of range of existing sections.");
        }
        int iSectionHeaderIndex = this.positionManager.sectionHeaderIndex(i);
        Integer numValueOf = Integer.valueOf(iSectionHeaderIndex);
        numValueOf.getClass();
        if (iSectionHeaderIndex == -1) {
            throw new IllegalStateException("No header position mapped for section " + i);
        }
        int itemCount = getItemCount(i);
        if (itemCount == 0) {
            Log.d(TAG, "There are no items in section " + i + " to notify.");
            return;
        }
        Log.d(TAG, "Invalidating " + itemCount + " items starting at index " + numValueOf);
        numValueOf.getClass();
        notifyItemRangeChanged(iSectionHeaderIndex, itemCount);
    }

    public void expandSection(int i) {
        this.positionManager.expandSection(i);
        notifyDataSetChanged();
    }

    public void collapseSection(int i) {
        this.positionManager.collapseSection(i);
        notifyDataSetChanged();
    }

    public void expandAllSections() {
        if (!this.positionManager.hasInvalidated()) {
            this.positionManager.invalidate(this);
        }
        this.positionManager.expandAllSections();
        notifyDataSetChanged();
    }

    public void collapseAllSections() {
        if (!this.positionManager.hasInvalidated()) {
            this.positionManager.invalidate(this);
        }
        this.positionManager.collapseAllSections();
        notifyDataSetChanged();
    }

    public void toggleSectionExpanded(int i) {
        this.positionManager.toggleSectionExpanded(i);
        notifyDataSetChanged();
    }

    public final boolean isHeader(int i) {
        return this.positionManager.isHeader(i);
    }

    public final boolean isFooter(int i) {
        return this.positionManager.isFooter(i);
    }

    public final boolean isSectionExpanded(int i) {
        return this.positionManager.isSectionExpanded(i);
    }

    public final int getSectionHeaderIndex(int i) {
        return this.positionManager.sectionHeaderIndex(i);
    }

    public final int getSectionFooterIndex(int i) {
        return this.positionManager.sectionFooterIndex(i);
    }

    public final void shouldShowHeadersForEmptySections(boolean z) {
        this.showHeadersForEmptySections = z;
        notifyDataSetChanged();
    }

    public final void shouldShowFooters(boolean z) {
        this.showFooters = z;
        notifyDataSetChanged();
    }

    public final void setLayoutManager(GridLayoutManager gridLayoutManager) {
        this.layoutManager = gridLayoutManager;
        if (gridLayoutManager == null) {
            return;
        }
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter.1
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (SectionedRecyclerViewAdapter.this.isHeader(i) || SectionedRecyclerViewAdapter.this.isFooter(i)) {
                    return SectionedRecyclerViewAdapter.this.layoutManager.getSpanCount();
                }
                ItemCoord relativePosition = SectionedRecyclerViewAdapter.this.getRelativePosition(i);
                int iSection = i - (relativePosition.section() + 1);
                SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter.this;
                return sectionedRecyclerViewAdapter.getRowSpan(sectionedRecyclerViewAdapter.layoutManager.getSpanCount(), relativePosition.section(), relativePosition.relativePos(), iSection);
            }
        });
    }

    public ItemCoord getRelativePosition(int i) {
        return this.positionManager.relativePosition(i);
    }

    public int getAbsolutePosition(int i, int i2) {
        return this.positionManager.absolutePosition(i, i2);
    }

    public int getAbsolutePosition(ItemCoord itemCoord) {
        return this.positionManager.absolutePosition(itemCoord);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.positionManager.invalidate(this);
    }

    @Override // com.afollestad.sectionedrecyclerview.ItemProvider
    public final boolean showHeadersForEmptySections() {
        return this.showHeadersForEmptySections;
    }

    @Override // com.afollestad.sectionedrecyclerview.ItemProvider
    public boolean showFooters() {
        return this.showFooters;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @Deprecated
    public long getItemId(int i) {
        if (isHeader(i)) {
            return getHeaderId(this.positionManager.sectionId(i));
        }
        if (isFooter(i)) {
            return getFooterId(this.positionManager.footerId(i));
        }
        ItemCoord relativePosition = getRelativePosition(i);
        return getItemId(relativePosition.section(), relativePosition.relativePos());
    }

    public long getHeaderId(int i) {
        return super.getItemId(i);
    }

    public long getFooterId(int i) {
        return super.getItemId(i) + ((long) getItemCount(i));
    }

    public long getItemId(int i, int i2) {
        return super.getItemId(i2);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @Deprecated
    public final int getItemViewType(int i) {
        if (isHeader(i)) {
            return getHeaderViewType(this.positionManager.sectionId(i));
        }
        if (isFooter(i)) {
            return getFooterViewType(this.positionManager.footerId(i));
        }
        ItemCoord relativePosition = getRelativePosition(i);
        return getItemViewType(relativePosition.section(), relativePosition.relativePos(), i - (relativePosition.section() + 1));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @Deprecated
    public final void onBindViewHolder(VH vh, int i) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        vh.setPositionDelegate(this.positionManager);
        if (vh.itemView.getLayoutParams() instanceof GridLayoutManager.LayoutParams) {
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        } else {
            layoutParams = vh.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams ? (StaggeredGridLayoutManager.LayoutParams) vh.itemView.getLayoutParams() : null;
        }
        if (isHeader(i)) {
            if (layoutParams != null) {
                layoutParams.setFullSpan(true);
            }
            int iSectionId = this.positionManager.sectionId(i);
            onBindHeaderViewHolder(vh, iSectionId, isSectionExpanded(iSectionId));
        } else if (isFooter(i)) {
            if (layoutParams != null) {
                layoutParams.setFullSpan(true);
            }
            onBindFooterViewHolder(vh, this.positionManager.footerId(i));
        } else {
            if (layoutParams != null) {
                layoutParams.setFullSpan(false);
            }
            ItemCoord relativePosition = getRelativePosition(i);
            onBindViewHolder(vh, relativePosition.section(), relativePosition.relativePos(), getAbsolutePosition(relativePosition));
        }
        if (layoutParams != null) {
            vh.itemView.setLayoutParams(layoutParams);
        }
    }

    @Deprecated
    public final void onBindViewHolder(VH vh, int i, List<Object> list) {
        super.onBindViewHolder(vh, i, list);
    }
}
