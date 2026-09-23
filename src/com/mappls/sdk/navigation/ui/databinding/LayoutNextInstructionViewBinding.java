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
import com.mappls.sdk.plugin.directions.view.ManeuverView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutNextInstructionViewBinding extends ViewDataBinding {
    public final TextView nextAdviceDuration;
    public final LinearLayout nextAdviseContainer;
    public final ManeuverView nextInstructionImageView;
    public final ImageView nextInstructionImageViewIcon;
    public final TextView tvThen;

    protected LayoutNextInstructionViewBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ManeuverView maneuverView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.nextAdviceDuration = textView;
        this.nextAdviseContainer = linearLayout;
        this.nextInstructionImageView = maneuverView;
        this.nextInstructionImageViewIcon = imageView;
        this.tvThen = textView2;
    }

    public static LayoutNextInstructionViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutNextInstructionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNextInstructionViewBinding bind(View view, Object obj) {
        return (LayoutNextInstructionViewBinding) ViewDataBinding.bind(obj, view, R.layout.layout_next_instruction_view);
    }

    @Deprecated
    public static LayoutNextInstructionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutNextInstructionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_next_instruction_view, viewGroup, z, obj);
    }

    public static LayoutNextInstructionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNextInstructionViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutNextInstructionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_next_instruction_view, null, false, obj);
    }
}
