package com.mappls.sdk.navigation.ui.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.navigation.alert.NavigationEventAlertView;
import com.mappls.sdk.navigation.ui.navigation.directions.DirectionsListView;
import com.mappls.sdk.navigation.ui.navigation.finished.NavigationFinishedView;
import com.mappls.sdk.navigation.ui.navigation.infobar.InfobarBottomSheetView;
import com.mappls.sdk.navigation.ui.navigation.instructioncontainer.InstructionContainerView;
import com.mappls.sdk.navigation.ui.navigation.instructioncontainer.InstructionContainrPIPView;
import com.mappls.sdk.navigation.ui.navigation.nextinstruction.NextInstructionView;
import com.mappls.sdk.navigation.ui.navigation.recenter.RecenterButton;
import com.mappls.sdk.navigation.ui.navigation.searchalongroute.SearchAlongRouteView;
import com.mappls.sdk.navigation.ui.navigation.settings.SettingView;
import com.mappls.sdk.navigation.ui.navigation.sound.SoundControllerView;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutNavigationViewBindingLandImpl extends LayoutNavigationViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.map_layout, 1);
        sparseIntArray.put(R.id.constraintLayout2, 2);
        sparseIntArray.put(R.id.instruction_container, 3);
        sparseIntArray.put(R.id.warning_text_view, 4);
        sparseIntArray.put(R.id.next_advise_view, 5);
        sparseIntArray.put(R.id.alert_view, 6);
        sparseIntArray.put(R.id.tv_speed, 7);
        sparseIntArray.put(R.id.sound_view, 8);
        sparseIntArray.put(R.id.speed_warning_button, 9);
        sparseIntArray.put(R.id.search_along_route, 10);
        sparseIntArray.put(R.id.reset_bounds_button, 11);
        sparseIntArray.put(R.id.follow_button, 12);
        sparseIntArray.put(R.id.events_text, 13);
        sparseIntArray.put(R.id.infobar_view, 14);
        sparseIntArray.put(R.id.instruction_container_pip, 15);
        sparseIntArray.put(R.id.search_along_route_view, 16);
        sparseIntArray.put(R.id.direction_list, 17);
        sparseIntArray.put(R.id.settings_view, 18);
        sparseIntArray.put(R.id.navigation_finished_view, 19);
    }

    public LayoutNavigationViewBindingLandImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
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

    private LayoutNavigationViewBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NavigationEventAlertView) objArr[6], (ConstraintLayout) objArr[2], (DirectionsListView) objArr[17], (TextView) objArr[13], (RecenterButton) objArr[12], (InfobarBottomSheetView) objArr[14], (InstructionContainerView) objArr[3], (InstructionContainrPIPView) objArr[15], (FrameLayout) objArr[1], (NavigationFinishedView) objArr[19], (NextInstructionView) objArr[5], (FloatingActionButton) objArr[11], (ImageView) objArr[10], (SearchAlongRouteView) objArr[16], (SettingView) objArr[18], (SoundControllerView) objArr[8], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
