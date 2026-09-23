package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutDirectionAdapterHeaderBinding extends ViewDataBinding {
    public final ImageView directionImage;
    public final FrameLayout maneuverViewContainer;
    public final TextView navigationDirectionPlaceName;
    public final TextView navigationListDesc;

    protected LayoutDirectionAdapterHeaderBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.directionImage = imageView;
        this.maneuverViewContainer = frameLayout;
        this.navigationDirectionPlaceName = textView;
        this.navigationListDesc = textView2;
    }

    public static LayoutDirectionAdapterHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutDirectionAdapterHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutDirectionAdapterHeaderBinding bind(View view, Object obj) {
        return (LayoutDirectionAdapterHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.layout_direction_adapter_header);
    }

    @Deprecated
    public static LayoutDirectionAdapterHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutDirectionAdapterHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_direction_adapter_header, viewGroup, z, obj);
    }

    public static LayoutDirectionAdapterHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutDirectionAdapterHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutDirectionAdapterHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_direction_adapter_header, null, false, obj);
    }
}
