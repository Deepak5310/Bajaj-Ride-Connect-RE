package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutNavigationFinishedBinding extends ViewDataBinding {
    public final LinearLayout containerButtons;
    public final LinearLayout containerDestinationHeader;
    public final LinearLayout containerDestinationReached;
    public final TextView destinationTextView;
    public final ImageButton finishedButton;
    public final TextView knowMoreButton;
    public final TextView navFinishedHeaderText;
    public final LinearLayout navigationFinishedContainerLayout;
    public final RelativeLayout navigationFinishedLayout;
    public final TextView okButton;
    public final ImageButton okayButton;
    public final RecyclerView tripStatsRecyclerView;
    public final TextView tripStatsTextView;
    public final View view;
    public final TextView welcomeToAPlaceTextView;

    protected LayoutNavigationFinishedBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, ImageButton imageButton, TextView textView2, TextView textView3, LinearLayout linearLayout4, RelativeLayout relativeLayout, TextView textView4, ImageButton imageButton2, RecyclerView recyclerView, TextView textView5, View view2, TextView textView6) {
        super(obj, view, i);
        this.containerButtons = linearLayout;
        this.containerDestinationHeader = linearLayout2;
        this.containerDestinationReached = linearLayout3;
        this.destinationTextView = textView;
        this.finishedButton = imageButton;
        this.knowMoreButton = textView2;
        this.navFinishedHeaderText = textView3;
        this.navigationFinishedContainerLayout = linearLayout4;
        this.navigationFinishedLayout = relativeLayout;
        this.okButton = textView4;
        this.okayButton = imageButton2;
        this.tripStatsRecyclerView = recyclerView;
        this.tripStatsTextView = textView5;
        this.view = view2;
        this.welcomeToAPlaceTextView = textView6;
    }

    public static LayoutNavigationFinishedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutNavigationFinishedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNavigationFinishedBinding bind(View view, Object obj) {
        return (LayoutNavigationFinishedBinding) ViewDataBinding.bind(obj, view, R.layout.layout_navigation_finished);
    }

    @Deprecated
    public static LayoutNavigationFinishedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutNavigationFinishedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_navigation_finished, viewGroup, z, obj);
    }

    public static LayoutNavigationFinishedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNavigationFinishedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutNavigationFinishedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_navigation_finished, null, false, obj);
    }
}
