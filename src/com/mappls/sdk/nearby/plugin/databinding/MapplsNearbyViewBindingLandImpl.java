package com.mappls.sdk.nearby.plugin.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsNearbyViewBindingLandImpl extends MapplsNearbyViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mappls_nearby_layout_title, 1);
        sparseIntArray.put(R.id.mappls_nearby_toolbar_icon, 2);
        sparseIntArray.put(R.id.mappls_nearby_toolbar_text, 3);
        sparseIntArray.put(R.id.mappls_nearby_location_layout, 4);
        sparseIntArray.put(R.id.mappls_nearby_location_text, 5);
        sparseIntArray.put(R.id.mappls_nearby_tv_address, 6);
        sparseIntArray.put(R.id.mappls_nearby_change_location_btn, 7);
        sparseIntArray.put(R.id.mappls_nearby_current_location_btn, 8);
        sparseIntArray.put(R.id.mappls_nearby_rv_category, 9);
        sparseIntArray.put(R.id.mappls_nearby_bottom_layout, 10);
        sparseIntArray.put(R.id.mappls_nearby_next_btn, 11);
        sparseIntArray.put(R.id.mappls_nearby_progress_bar, 12);
    }

    public MapplsNearbyViewBindingLandImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private MapplsNearbyViewBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (CardView) objArr[10], (TextView) objArr[7], (TextView) objArr[8], (LinearLayout) objArr[1], (CardView) objArr[4], (TextView) objArr[5], (TextView) objArr[11], (RelativeLayout) objArr[12], (RecyclerView) objArr[9], (ImageView) objArr[2], (TextView) objArr[3], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.mapplsNearbyBgLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
