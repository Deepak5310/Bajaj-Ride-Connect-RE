package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyFragmentMapBinding extends ViewDataBinding {
    public final FloatingActionButton mapplsNearbyUserLocationButton;

    protected MapplsNearbyFragmentMapBinding(Object obj, View view, int i, FloatingActionButton floatingActionButton) {
        super(obj, view, i);
        this.mapplsNearbyUserLocationButton = floatingActionButton;
    }

    public static MapplsNearbyFragmentMapBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyFragmentMapBinding bind(View view, Object obj) {
        return (MapplsNearbyFragmentMapBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_fragment_map);
    }

    public static MapplsNearbyFragmentMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyFragmentMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyFragmentMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyFragmentMapBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_fragment_map, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyFragmentMapBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyFragmentMapBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_fragment_map, null, false, obj);
    }
}
