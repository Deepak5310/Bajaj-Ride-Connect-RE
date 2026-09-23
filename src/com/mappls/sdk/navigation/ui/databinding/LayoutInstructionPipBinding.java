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
public abstract class LayoutInstructionPipBinding extends ViewDataBinding {
    public final ManeuverView maneuverImageView;
    public final ImageView maneuverImageViewIcon;
    public final TextView navigationStripDist;
    public final TextView navigationStripText;
    public final TextView otherInfoTextView;
    public final LinearLayout repeatCurrentInstructionsLayout;
    public final LinearLayout stripItemContainer;

    protected LayoutInstructionPipBinding(Object obj, View view, int i, ManeuverView maneuverView, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.maneuverImageView = maneuverView;
        this.maneuverImageViewIcon = imageView;
        this.navigationStripDist = textView;
        this.navigationStripText = textView2;
        this.otherInfoTextView = textView3;
        this.repeatCurrentInstructionsLayout = linearLayout;
        this.stripItemContainer = linearLayout2;
    }

    public static LayoutInstructionPipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutInstructionPipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutInstructionPipBinding bind(View view, Object obj) {
        return (LayoutInstructionPipBinding) ViewDataBinding.bind(obj, view, R.layout.layout_instruction_pip);
    }

    @Deprecated
    public static LayoutInstructionPipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutInstructionPipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_instruction_pip, viewGroup, z, obj);
    }

    public static LayoutInstructionPipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutInstructionPipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutInstructionPipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_instruction_pip, null, false, obj);
    }
}
