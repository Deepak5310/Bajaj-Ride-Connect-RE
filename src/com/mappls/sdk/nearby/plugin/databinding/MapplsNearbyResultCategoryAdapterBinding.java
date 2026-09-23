package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyResultCategoryAdapterBinding extends ViewDataBinding {
    public final TextView mapplsNearbyCategoryTv;

    protected MapplsNearbyResultCategoryAdapterBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.mapplsNearbyCategoryTv = textView;
    }

    public static MapplsNearbyResultCategoryAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultCategoryAdapterBinding bind(View view, Object obj) {
        return (MapplsNearbyResultCategoryAdapterBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_result_category_adapter);
    }

    public static MapplsNearbyResultCategoryAdapterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyResultCategoryAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultCategoryAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyResultCategoryAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_category_adapter, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyResultCategoryAdapterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyResultCategoryAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_category_adapter, null, false, obj);
    }
}
