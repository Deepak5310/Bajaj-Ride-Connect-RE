package com.mappls.sdk.direction.ui.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public class MapplsDirectionPreviewFragmentBindingLandImpl extends MapplsDirectionPreviewFragmentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"mappls_direction_common_toolbar"}, new int[]{4}, new int[]{R.layout.mappls_direction_common_toolbar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.preview_view, 5);
        sparseIntArray.put(R.id.pager_direction_preview, 6);
    }

    public MapplsDirectionPreviewFragmentBindingLandImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private MapplsDirectionPreviewFragmentBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageButton) objArr[3], (ImageButton) objArr[2], (MapplsDirectionCommonToolbarBinding) objArr[4], (ViewPager) objArr[6], (LinearLayout) objArr[1], (View) objArr[5]);
        this.mDirtyFlags = -1L;
        this.btnNextUp.setTag(null);
        this.btnPrevDown.setTag(null);
        setContainedBinding(this.layoutCommonToolbar);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.previewContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean onChangeLayoutCommonToolbar(MapplsDirectionCommonToolbarBinding mapplsDirectionCommonToolbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mOnPreviousClick;
        View.OnClickListener onClickListener2 = this.mOnNextClick;
        long j2 = 10 & j;
        if ((j & 12) != 0) {
            this.btnNextUp.setOnClickListener(onClickListener2);
        }
        if (j2 != 0) {
            this.btnPrevDown.setOnClickListener(onClickListener);
        }
        ViewDataBinding.executeBindingsOn(this.layoutCommonToolbar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.layoutCommonToolbar.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
        }
        this.layoutCommonToolbar.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeLayoutCommonToolbar((MapplsDirectionCommonToolbarBinding) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.layoutCommonToolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsDirectionPreviewFragmentBinding
    public void setOnNextClick(View.OnClickListener onClickListener) {
        this.mOnNextClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsDirectionPreviewFragmentBinding
    public void setOnPreviousClick(View.OnClickListener onClickListener) {
        this.mOnPreviousClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (8 == i) {
            setOnPreviousClick((View.OnClickListener) obj);
        } else {
            if (7 != i) {
                return false;
            }
            setOnNextClick((View.OnClickListener) obj);
        }
        return true;
    }
}
