package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionRouteEventFragmentBinding extends ViewDataBinding {
    public final RecyclerView routeEventRecyclerView;

    protected MapplsDirectionRouteEventFragmentBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.routeEventRecyclerView = recyclerView;
    }

    public static MapplsDirectionRouteEventFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteEventFragmentBinding bind(View view, Object obj) {
        return (MapplsDirectionRouteEventFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_route_event_fragment);
    }

    public static MapplsDirectionRouteEventFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionRouteEventFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteEventFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionRouteEventFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_event_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionRouteEventFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionRouteEventFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_event_fragment, null, false, obj);
    }
}
