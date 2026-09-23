package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyResultListAdapterBinding extends ViewDataBinding {
    public final TextView mapplsNearbyAddressTv;
    public final TextView mapplsNearbyDistanceTv;
    public final TextView mapplsNearbyPlaceNameTv;
    public final View mapplsNearbyResultSeperator;

    protected MapplsNearbyResultListAdapterBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.mapplsNearbyAddressTv = textView;
        this.mapplsNearbyDistanceTv = textView2;
        this.mapplsNearbyPlaceNameTv = textView3;
        this.mapplsNearbyResultSeperator = view2;
    }

    public static MapplsNearbyResultListAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultListAdapterBinding bind(View view, Object obj) {
        return (MapplsNearbyResultListAdapterBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_result_list_adapter);
    }

    public static MapplsNearbyResultListAdapterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyResultListAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultListAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyResultListAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_list_adapter, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyResultListAdapterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyResultListAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_list_adapter, null, false, obj);
    }
}
