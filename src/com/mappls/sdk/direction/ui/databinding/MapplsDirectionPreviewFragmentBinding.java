package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionPreviewFragmentBinding extends ViewDataBinding {
    public final ImageButton btnNextUp;
    public final ImageButton btnPrevDown;
    public final MapplsDirectionCommonToolbarBinding layoutCommonToolbar;

    @Bindable
    protected View.OnClickListener mOnNextClick;

    @Bindable
    protected View.OnClickListener mOnPreviousClick;
    public final ViewPager pagerDirectionPreview;
    public final LinearLayout previewContainer;
    public final View previewView;

    protected MapplsDirectionPreviewFragmentBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, MapplsDirectionCommonToolbarBinding mapplsDirectionCommonToolbarBinding, ViewPager viewPager, LinearLayout linearLayout, View view2) {
        super(obj, view, i);
        this.btnNextUp = imageButton;
        this.btnPrevDown = imageButton2;
        this.layoutCommonToolbar = mapplsDirectionCommonToolbarBinding;
        this.pagerDirectionPreview = viewPager;
        this.previewContainer = linearLayout;
        this.previewView = view2;
    }

    public static MapplsDirectionPreviewFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionPreviewFragmentBinding bind(View view, Object obj) {
        return (MapplsDirectionPreviewFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_preview_fragment);
    }

    public static MapplsDirectionPreviewFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionPreviewFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionPreviewFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionPreviewFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_preview_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionPreviewFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionPreviewFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_preview_fragment, null, false, obj);
    }

    public View.OnClickListener getOnNextClick() {
        return this.mOnNextClick;
    }

    public View.OnClickListener getOnPreviousClick() {
        return this.mOnPreviousClick;
    }

    public abstract void setOnNextClick(View.OnClickListener onClickListener);

    public abstract void setOnPreviousClick(View.OnClickListener onClickListener);
}
