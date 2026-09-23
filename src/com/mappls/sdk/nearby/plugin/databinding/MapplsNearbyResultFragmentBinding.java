package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyResultFragmentBinding extends ViewDataBinding {
    public final FrameLayout mapplsNearbyResultView;

    protected MapplsNearbyResultFragmentBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.mapplsNearbyResultView = frameLayout;
    }

    public static MapplsNearbyResultFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultFragmentBinding bind(View view, Object obj) {
        return (MapplsNearbyResultFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_result_fragment);
    }

    public static MapplsNearbyResultFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyResultFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyResultFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyResultFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyResultFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_fragment, null, false, obj);
    }
}
