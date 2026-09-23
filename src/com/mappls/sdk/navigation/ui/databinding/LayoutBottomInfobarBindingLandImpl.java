package com.mappls.sdk.navigation.ui.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutBottomInfobarBindingLandImpl extends LayoutBottomInfobarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cardView, 1);
        sparseIntArray.put(R.id.top_separator_view_day_mode, 2);
        sparseIntArray.put(R.id.top_separator_view_night_mode, 3);
        sparseIntArray.put(R.id.iv_bottom_sheet_arrow, 4);
        sparseIntArray.put(R.id.vertical_seperator_view, 5);
        sparseIntArray.put(R.id.image_route_overview, 6);
        sparseIntArray.put(R.id.stop_navigation, 7);
        sparseIntArray.put(R.id.text_view_total_time_left, 8);
        sparseIntArray.put(R.id.text_view_total_distance_left, 9);
        sparseIntArray.put(R.id.text_view_reach_eta, 10);
        sparseIntArray.put(R.id.destination_text, 11);
        sparseIntArray.put(R.id.progress_bar_layout, 12);
        sparseIntArray.put(R.id.car_speed_light_imageview, 13);
        sparseIntArray.put(R.id.nav_progress, 14);
        sparseIntArray.put(R.id.nav_destination_imageview, 15);
        sparseIntArray.put(R.id.remaining_distance_text_view, 16);
        sparseIntArray.put(R.id.rv_bottom_item, 17);
    }

    public LayoutBottomInfobarBindingLandImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
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

    private LayoutBottomInfobarBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[13], (CardView) objArr[1], (TextView) objArr[11], (ImageView) objArr[6], (ImageView) objArr[4], (ImageView) objArr[15], (ProgressBar) objArr[14], (RelativeLayout) objArr[0], (LinearLayout) objArr[12], (TextView) objArr[16], (RecyclerView) objArr[17], null, (ImageView) objArr[7], (TextView) objArr[10], (TextView) objArr[9], (TextView) objArr[8], (View) objArr[2], (View) objArr[3], (View) objArr[5]);
        this.mDirtyFlags = -1L;
        this.optionsRecyclerViewContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
