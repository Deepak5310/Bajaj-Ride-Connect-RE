package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyFragmentBinding extends ViewDataBinding {
    public final FrameLayout mapplsNearbyView;
    public final ConstraintLayout nearbyRoot;

    protected MapplsNearbyFragmentBinding(Object obj, View view, int i, FrameLayout frameLayout, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.mapplsNearbyView = frameLayout;
        this.nearbyRoot = constraintLayout;
    }

    public static MapplsNearbyFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyFragmentBinding bind(View view, Object obj) {
        return (MapplsNearbyFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_fragment);
    }

    public static MapplsNearbyFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_fragment, null, false, obj);
    }
}
