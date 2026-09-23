package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutBottomInfobarBinding extends ViewDataBinding {
    public final ImageView carSpeedLightImageview;
    public final CardView cardView;
    public final TextView destinationText;
    public final ImageView imageRouteOverview;
    public final ImageView ivBottomSheetArrow;
    public final ImageView navDestinationImageview;
    public final ProgressBar navProgress;
    public final RelativeLayout optionsRecyclerViewContainer;
    public final LinearLayout progressBarLayout;
    public final TextView remainingDistanceTextView;
    public final RecyclerView rvBottomItem;
    public final RelativeLayout seperatorView;
    public final ImageView stopNavigation;
    public final TextView textViewReachEta;
    public final TextView textViewTotalDistanceLeft;
    public final TextView textViewTotalTimeLeft;
    public final View topSeparatorViewDayMode;
    public final View topSeparatorViewNightMode;
    public final View verticalSeperatorView;

    protected LayoutBottomInfobarBinding(Object obj, View view, int i, ImageView imageView, CardView cardView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ProgressBar progressBar, RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView2, RecyclerView recyclerView, RelativeLayout relativeLayout2, ImageView imageView5, TextView textView3, TextView textView4, TextView textView5, View view2, View view3, View view4) {
        super(obj, view, i);
        this.carSpeedLightImageview = imageView;
        this.cardView = cardView;
        this.destinationText = textView;
        this.imageRouteOverview = imageView2;
        this.ivBottomSheetArrow = imageView3;
        this.navDestinationImageview = imageView4;
        this.navProgress = progressBar;
        this.optionsRecyclerViewContainer = relativeLayout;
        this.progressBarLayout = linearLayout;
        this.remainingDistanceTextView = textView2;
        this.rvBottomItem = recyclerView;
        this.seperatorView = relativeLayout2;
        this.stopNavigation = imageView5;
        this.textViewReachEta = textView3;
        this.textViewTotalDistanceLeft = textView4;
        this.textViewTotalTimeLeft = textView5;
        this.topSeparatorViewDayMode = view2;
        this.topSeparatorViewNightMode = view3;
        this.verticalSeperatorView = view4;
    }

    public static LayoutBottomInfobarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutBottomInfobarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutBottomInfobarBinding bind(View view, Object obj) {
        return (LayoutBottomInfobarBinding) ViewDataBinding.bind(obj, view, R.layout.layout_bottom_infobar);
    }

    @Deprecated
    public static LayoutBottomInfobarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutBottomInfobarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_bottom_infobar, viewGroup, z, obj);
    }

    public static LayoutBottomInfobarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutBottomInfobarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutBottomInfobarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_bottom_infobar, null, false, obj);
    }
}
