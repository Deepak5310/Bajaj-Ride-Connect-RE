package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.plugin.directions.view.ManeuverView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionPreviewPagerBinding extends ViewDataBinding {
    public final TextView directionPreviewDist;
    public final TextView directionPreviewText;
    public final FrameLayout maneuverViewContainer;
    public final ManeuverView navigateIcon;
    public final ImageView navigateManeuverIcon;

    protected MapplsDirectionPreviewPagerBinding(Object obj, View view, int i, TextView textView, TextView textView2, FrameLayout frameLayout, ManeuverView maneuverView, ImageView imageView) {
        super(obj, view, i);
        this.directionPreviewDist = textView;
        this.directionPreviewText = textView2;
        this.maneuverViewContainer = frameLayout;
        this.navigateIcon = maneuverView;
        this.navigateManeuverIcon = imageView;
    }

    public static MapplsDirectionPreviewPagerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionPreviewPagerBinding bind(View view, Object obj) {
        return (MapplsDirectionPreviewPagerBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_preview_pager);
    }

    public static MapplsDirectionPreviewPagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionPreviewPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionPreviewPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionPreviewPagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_preview_pager, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionPreviewPagerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionPreviewPagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_preview_pager, null, false, obj);
    }
}
