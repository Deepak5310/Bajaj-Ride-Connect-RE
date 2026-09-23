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
import com.mappls.sdk.plugin.directions.view.ManeuverView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutDirectionAdapterLightBinding extends ViewDataBinding {
    public final ManeuverView directionImage;
    public final ImageView directionImageIcon;
    public final TextView directionText;
    public final FrameLayout maneuverViewContainer;
    public final TextView tvDistance;

    protected LayoutDirectionAdapterLightBinding(Object obj, View view, int i, ManeuverView maneuverView, ImageView imageView, TextView textView, FrameLayout frameLayout, TextView textView2) {
        super(obj, view, i);
        this.directionImage = maneuverView;
        this.directionImageIcon = imageView;
        this.directionText = textView;
        this.maneuverViewContainer = frameLayout;
        this.tvDistance = textView2;
    }

    public static LayoutDirectionAdapterLightBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutDirectionAdapterLightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutDirectionAdapterLightBinding bind(View view, Object obj) {
        return (LayoutDirectionAdapterLightBinding) ViewDataBinding.bind(obj, view, R.layout.layout_direction_adapter_light);
    }

    @Deprecated
    public static LayoutDirectionAdapterLightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutDirectionAdapterLightBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_direction_adapter_light, viewGroup, z, obj);
    }

    public static LayoutDirectionAdapterLightBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutDirectionAdapterLightBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutDirectionAdapterLightBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_direction_adapter_light, null, false, obj);
    }
}
