package com.mappls.sdk.navigation.ui.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.plugin.directions.view.ManeuverView;

/* JADX INFO: loaded from: classes4.dex */
public class InstructionContainerItemBindingImpl extends InstructionContainerItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.strip_item_container, 1);
        sparseIntArray.put(R.id.repeat_current_instructions_layout, 2);
        sparseIntArray.put(R.id.maneuver_image_view, 3);
        sparseIntArray.put(R.id.maneuver_image, 4);
        sparseIntArray.put(R.id.navigation_strip_dist, 5);
        sparseIntArray.put(R.id.navigation_strip_text, 6);
        sparseIntArray.put(R.id.navigation_strip_short_text, 7);
        sparseIntArray.put(R.id.lane_guidance_container, 8);
        sparseIntArray.put(R.id.rvTurnLanes, 9);
        sparseIntArray.put(R.id.maneuver_id_text_view, 10);
    }

    public InstructionContainerItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
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

    private InstructionContainerItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[8], (TextView) objArr[10], (ImageView) objArr[4], (ManeuverView) objArr[3], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[6], (LinearLayout) objArr[2], (RecyclerView) objArr[9], (LinearLayout) objArr[1]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
