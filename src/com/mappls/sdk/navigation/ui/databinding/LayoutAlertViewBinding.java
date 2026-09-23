package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutAlertViewBinding extends ViewDataBinding {
    public final ImageView reportIcon;
    public final LinearLayout reportLayout;
    public final TextView textReportCategoryName;
    public final TextView textReportDistanceLeft;

    protected LayoutAlertViewBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.reportIcon = imageView;
        this.reportLayout = linearLayout;
        this.textReportCategoryName = textView;
        this.textReportDistanceLeft = textView2;
    }

    public static LayoutAlertViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutAlertViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutAlertViewBinding bind(View view, Object obj) {
        return (LayoutAlertViewBinding) ViewDataBinding.bind(obj, view, R.layout.layout_alert_view);
    }

    @Deprecated
    public static LayoutAlertViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutAlertViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_alert_view, viewGroup, z, obj);
    }

    public static LayoutAlertViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutAlertViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutAlertViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_alert_view, null, false, obj);
    }
}
