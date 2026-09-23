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
public abstract class MapplsDirectionRouteSummaryHeaderBinding extends ViewDataBinding {
    public final ImageView mapplsDirectionImageEventType;
    public final TextView textReportSummaryEventCount;
    public final TextView textReportSummaryEventName;
    public final TextView textReportSummaryViewAll;

    protected MapplsDirectionRouteSummaryHeaderBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.mapplsDirectionImageEventType = imageView;
        this.textReportSummaryEventCount = textView;
        this.textReportSummaryEventName = textView2;
        this.textReportSummaryViewAll = textView3;
    }

    public static MapplsDirectionRouteSummaryHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryHeaderBinding bind(View view, Object obj) {
        return (MapplsDirectionRouteSummaryHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_route_summary_header);
    }

    public static MapplsDirectionRouteSummaryHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionRouteSummaryHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionRouteSummaryHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_header, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionRouteSummaryHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_header, null, false, obj);
    }
}
