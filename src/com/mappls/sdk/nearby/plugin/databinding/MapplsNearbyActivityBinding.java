package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyActivityBinding extends ViewDataBinding {
    public final FrameLayout mapplsNearbyFragmentContainer;

    protected MapplsNearbyActivityBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.mapplsNearbyFragmentContainer = frameLayout;
    }

    public static MapplsNearbyActivityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyActivityBinding bind(View view, Object obj) {
        return (MapplsNearbyActivityBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_activity);
    }

    public static MapplsNearbyActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_activity, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_activity, null, false, obj);
    }
}
