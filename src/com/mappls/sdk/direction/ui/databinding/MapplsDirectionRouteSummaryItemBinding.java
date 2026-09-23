package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionRouteSummaryItemBinding extends ViewDataBinding {
    public final ImageView imageRouteSummaryEventType;
    public final TextView subTitle;
    public final TextView title;

    protected MapplsDirectionRouteSummaryItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.imageRouteSummaryEventType = imageView;
        this.subTitle = textView;
        this.title = textView2;
    }

    public static MapplsDirectionRouteSummaryItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryItemBinding bind(View view, Object obj) {
        return (MapplsDirectionRouteSummaryItemBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_route_summary_item);
    }

    public static MapplsDirectionRouteSummaryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionRouteSummaryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionRouteSummaryItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_item, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionRouteSummaryItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_item, null, false, obj);
    }
}
