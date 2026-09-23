package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.common.NonSwipeableViewPager;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutInstructionContainerBinding extends ViewDataBinding {
    public final NonSwipeableViewPager navigationInfoLayoutNew;
    public final ImageButton navigationStripLeftImageButton;
    public final ImageButton navigationStripRightImageButton;
    public final TextView otherInfoTextView;
    public final RelativeLayout topStripLayout;

    protected LayoutInstructionContainerBinding(Object obj, View view, int i, NonSwipeableViewPager nonSwipeableViewPager, ImageButton imageButton, ImageButton imageButton2, TextView textView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.navigationInfoLayoutNew = nonSwipeableViewPager;
        this.navigationStripLeftImageButton = imageButton;
        this.navigationStripRightImageButton = imageButton2;
        this.otherInfoTextView = textView;
        this.topStripLayout = relativeLayout;
    }

    public static LayoutInstructionContainerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutInstructionContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutInstructionContainerBinding bind(View view, Object obj) {
        return (LayoutInstructionContainerBinding) ViewDataBinding.bind(obj, view, R.layout.layout_instruction_container);
    }

    @Deprecated
    public static LayoutInstructionContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutInstructionContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_instruction_container, viewGroup, z, obj);
    }

    public static LayoutInstructionContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutInstructionContainerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutInstructionContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_instruction_container, null, false, obj);
    }
}
