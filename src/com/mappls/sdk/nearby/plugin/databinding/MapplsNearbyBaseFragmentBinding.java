package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyBaseFragmentBinding extends ViewDataBinding {
    public final FrameLayout mapplsNearbyBaseFragmentContainer;

    protected MapplsNearbyBaseFragmentBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.mapplsNearbyBaseFragmentContainer = frameLayout;
    }

    public static MapplsNearbyBaseFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyBaseFragmentBinding bind(View view, Object obj) {
        return (MapplsNearbyBaseFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_base_fragment);
    }

    public static MapplsNearbyBaseFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyBaseFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyBaseFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyBaseFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_base_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyBaseFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyBaseFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_base_fragment, null, false, obj);
    }
}
