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
public abstract class LayoutRecenterBtnBinding extends ViewDataBinding {
    public final ImageView recenterImageView;
    public final LinearLayout recenterLinearLayout;
    public final TextView recenterTextView;

    protected LayoutRecenterBtnBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.recenterImageView = imageView;
        this.recenterLinearLayout = linearLayout;
        this.recenterTextView = textView;
    }

    public static LayoutRecenterBtnBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutRecenterBtnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutRecenterBtnBinding bind(View view, Object obj) {
        return (LayoutRecenterBtnBinding) ViewDataBinding.bind(obj, view, R.layout.layout_recenter_btn);
    }

    @Deprecated
    public static LayoutRecenterBtnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutRecenterBtnBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_recenter_btn, viewGroup, z, obj);
    }

    public static LayoutRecenterBtnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutRecenterBtnBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutRecenterBtnBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_recenter_btn, null, false, obj);
    }
}
