package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSearchLongRouteBinding extends ViewDataBinding {
    public final ConstraintLayout addStopConstraintLayout;
    public final TextView addWayPointTextView;
    public final TextView addressTextView;
    public final LinearLayout detailsLayout;
    public final TextView startNewRouteTextView;
    public final TextView tvPlaceTitle;

    protected LayoutSearchLongRouteBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.addStopConstraintLayout = constraintLayout;
        this.addWayPointTextView = textView;
        this.addressTextView = textView2;
        this.detailsLayout = linearLayout;
        this.startNewRouteTextView = textView3;
        this.tvPlaceTitle = textView4;
    }

    public static LayoutSearchLongRouteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutSearchLongRouteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSearchLongRouteBinding bind(View view, Object obj) {
        return (LayoutSearchLongRouteBinding) ViewDataBinding.bind(obj, view, R.layout.layout_search_long_route);
    }

    @Deprecated
    public static LayoutSearchLongRouteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutSearchLongRouteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_search_long_route, viewGroup, z, obj);
    }

    public static LayoutSearchLongRouteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSearchLongRouteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutSearchLongRouteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_search_long_route, null, false, obj);
    }
}
