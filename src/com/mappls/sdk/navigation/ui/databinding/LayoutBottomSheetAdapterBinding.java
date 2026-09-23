package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutBottomSheetAdapterBinding extends ViewDataBinding {
    public final ImageView ivBottomItem;
    public final TextView tvBottomItem;

    protected LayoutBottomSheetAdapterBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.ivBottomItem = imageView;
        this.tvBottomItem = textView;
    }

    public static LayoutBottomSheetAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutBottomSheetAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutBottomSheetAdapterBinding bind(View view, Object obj) {
        return (LayoutBottomSheetAdapterBinding) ViewDataBinding.bind(obj, view, R.layout.layout_bottom_sheet_adapter);
    }

    @Deprecated
    public static LayoutBottomSheetAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutBottomSheetAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_bottom_sheet_adapter, viewGroup, z, obj);
    }

    public static LayoutBottomSheetAdapterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutBottomSheetAdapterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutBottomSheetAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_bottom_sheet_adapter, null, false, obj);
    }
}
