package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionRouteSummaryAllEventFragmentBinding extends ViewDataBinding {
    public final MapplsDirectionCommonToolbarBinding layoutSummaryCommonToolbar;
    public final View previewView;
    public final RecyclerView routeAllSummaryRecyclerView;

    protected MapplsDirectionRouteSummaryAllEventFragmentBinding(Object obj, View view, int i, MapplsDirectionCommonToolbarBinding mapplsDirectionCommonToolbarBinding, View view2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.layoutSummaryCommonToolbar = mapplsDirectionCommonToolbarBinding;
        this.previewView = view2;
        this.routeAllSummaryRecyclerView = recyclerView;
    }

    public static MapplsDirectionRouteSummaryAllEventFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryAllEventFragmentBinding bind(View view, Object obj) {
        return (MapplsDirectionRouteSummaryAllEventFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_route_summary_all_event_fragment);
    }

    public static MapplsDirectionRouteSummaryAllEventFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionRouteSummaryAllEventFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryAllEventFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionRouteSummaryAllEventFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_all_event_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryAllEventFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionRouteSummaryAllEventFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_all_event_fragment, null, false, obj);
    }
}
