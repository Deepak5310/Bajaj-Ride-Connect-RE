package com.mappls.sdk.navigation.ui.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutNavigationFinishedBindingImpl extends LayoutNavigationFinishedBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.navigation_finished_layout, 1);
        sparseIntArray.put(R.id.navigation_finished_container_layout, 2);
        sparseIntArray.put(R.id.container_destination_header, 3);
        sparseIntArray.put(R.id.okay_button, 4);
        sparseIntArray.put(R.id.nav_finished_header_text, 5);
        sparseIntArray.put(R.id.finished_button, 6);
        sparseIntArray.put(R.id.view, 7);
        sparseIntArray.put(R.id.container_destination_reached, 8);
        sparseIntArray.put(R.id.welcome_to_a_place_text_view, 9);
        sparseIntArray.put(R.id.destination_text_view, 10);
        sparseIntArray.put(R.id.trip_stats_text_view, 11);
        sparseIntArray.put(R.id.trip_stats_recycler_view, 12);
        sparseIntArray.put(R.id.container_buttons, 13);
        sparseIntArray.put(R.id.know_more_button, 14);
        sparseIntArray.put(R.id.ok_button, 15);
    }

    public LayoutNavigationFinishedBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
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

    private LayoutNavigationFinishedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[13], (LinearLayout) objArr[3], (LinearLayout) objArr[8], (TextView) objArr[10], (ImageButton) objArr[6], (TextView) objArr[14], (TextView) objArr[5], (LinearLayout) objArr[2], (RelativeLayout) objArr[1], (TextView) objArr[15], (ImageButton) objArr[4], (RecyclerView) objArr[12], (TextView) objArr[11], (View) objArr[7], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
