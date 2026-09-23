package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutJunctionViewBinding extends ViewDataBinding {
    public final ImageView ivJunctionImage;
    public final TextView tvJunctionLeftDistance;

    protected LayoutJunctionViewBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.ivJunctionImage = imageView;
        this.tvJunctionLeftDistance = textView;
    }

    public static LayoutJunctionViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutJunctionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutJunctionViewBinding bind(View view, Object obj) {
        return (LayoutJunctionViewBinding) ViewDataBinding.bind(obj, view, R.layout.layout_junction_view);
    }

    @Deprecated
    public static LayoutJunctionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutJunctionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_junction_view, viewGroup, z, obj);
    }

    public static LayoutJunctionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutJunctionViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutJunctionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_junction_view, null, false, obj);
    }
}
