package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyFragmentResultListBinding extends ViewDataBinding {
    public final RecyclerView mapplsNearbyRecyclerView;

    protected MapplsNearbyFragmentResultListBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.mapplsNearbyRecyclerView = recyclerView;
    }

    public static MapplsNearbyFragmentResultListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyFragmentResultListBinding bind(View view, Object obj) {
        return (MapplsNearbyFragmentResultListBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_fragment_result_list);
    }

    public static MapplsNearbyFragmentResultListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyFragmentResultListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyFragmentResultListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyFragmentResultListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_fragment_result_list, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyFragmentResultListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyFragmentResultListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_fragment_result_list, null, false, obj);
    }
}
