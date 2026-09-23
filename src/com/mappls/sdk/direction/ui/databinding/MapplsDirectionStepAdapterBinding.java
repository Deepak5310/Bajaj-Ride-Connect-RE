package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.plugin.directions.view.ManeuverView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionStepAdapterBinding extends ViewDataBinding {
    public final TextView distanceText;
    public final FrameLayout maneuverViewContainer;
    public final RelativeLayout mapplsDirectionSteplistContainer;
    public final ManeuverView navigateIcon;
    public final ImageView navigateManeuverIcon;
    public final View stepsListSeperator;
    public final TextView stepsText;

    protected MapplsDirectionStepAdapterBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, RelativeLayout relativeLayout, ManeuverView maneuverView, ImageView imageView, View view2, TextView textView2) {
        super(obj, view, i);
        this.distanceText = textView;
        this.maneuverViewContainer = frameLayout;
        this.mapplsDirectionSteplistContainer = relativeLayout;
        this.navigateIcon = maneuverView;
        this.navigateManeuverIcon = imageView;
        this.stepsListSeperator = view2;
        this.stepsText = textView2;
    }

    public static MapplsDirectionStepAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionStepAdapterBinding bind(View view, Object obj) {
        return (MapplsDirectionStepAdapterBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_step_adapter);
    }

    public static MapplsDirectionStepAdapterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionStepAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionStepAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionStepAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_step_adapter, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionStepAdapterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionStepAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_step_adapter, null, false, obj);
    }
}
