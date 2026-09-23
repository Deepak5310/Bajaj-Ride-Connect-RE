package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.plugin.directions.view.ManeuverView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InstructionContainerItemBinding extends ViewDataBinding {
    public final RelativeLayout laneGuidanceContainer;
    public final TextView maneuverIdTextView;
    public final ImageView maneuverImage;
    public final ManeuverView maneuverImageView;
    public final TextView navigationStripDist;
    public final TextView navigationStripShortText;
    public final TextView navigationStripText;
    public final LinearLayout repeatCurrentInstructionsLayout;
    public final RecyclerView rvTurnLanes;
    public final LinearLayout stripItemContainer;

    protected InstructionContainerItemBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView, ImageView imageView, ManeuverView maneuverView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.laneGuidanceContainer = relativeLayout;
        this.maneuverIdTextView = textView;
        this.maneuverImage = imageView;
        this.maneuverImageView = maneuverView;
        this.navigationStripDist = textView2;
        this.navigationStripShortText = textView3;
        this.navigationStripText = textView4;
        this.repeatCurrentInstructionsLayout = linearLayout;
        this.rvTurnLanes = recyclerView;
        this.stripItemContainer = linearLayout2;
    }

    public static InstructionContainerItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static InstructionContainerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static InstructionContainerItemBinding bind(View view, Object obj) {
        return (InstructionContainerItemBinding) ViewDataBinding.bind(obj, view, R.layout.instruction_container_item);
    }

    @Deprecated
    public static InstructionContainerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (InstructionContainerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.instruction_container_item, viewGroup, z, obj);
    }

    public static InstructionContainerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static InstructionContainerItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (InstructionContainerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.instruction_container_item, null, false, obj);
    }
}
