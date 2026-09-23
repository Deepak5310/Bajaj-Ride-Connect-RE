package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyViewBinding extends ViewDataBinding {
    public final ConstraintLayout mapplsNearbyBgLayout;
    public final CardView mapplsNearbyBottomLayout;
    public final TextView mapplsNearbyChangeLocationBtn;
    public final TextView mapplsNearbyCurrentLocationBtn;
    public final LinearLayout mapplsNearbyLayoutTitle;
    public final CardView mapplsNearbyLocationLayout;
    public final TextView mapplsNearbyLocationText;
    public final TextView mapplsNearbyNextBtn;
    public final RelativeLayout mapplsNearbyProgressBar;
    public final RecyclerView mapplsNearbyRvCategory;
    public final ImageView mapplsNearbyToolbarIcon;
    public final TextView mapplsNearbyToolbarText;
    public final TextView mapplsNearbyTvAddress;

    protected MapplsNearbyViewBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, CardView cardView, TextView textView, TextView textView2, LinearLayout linearLayout, CardView cardView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout, RecyclerView recyclerView, ImageView imageView, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.mapplsNearbyBgLayout = constraintLayout;
        this.mapplsNearbyBottomLayout = cardView;
        this.mapplsNearbyChangeLocationBtn = textView;
        this.mapplsNearbyCurrentLocationBtn = textView2;
        this.mapplsNearbyLayoutTitle = linearLayout;
        this.mapplsNearbyLocationLayout = cardView2;
        this.mapplsNearbyLocationText = textView3;
        this.mapplsNearbyNextBtn = textView4;
        this.mapplsNearbyProgressBar = relativeLayout;
        this.mapplsNearbyRvCategory = recyclerView;
        this.mapplsNearbyToolbarIcon = imageView;
        this.mapplsNearbyToolbarText = textView5;
        this.mapplsNearbyTvAddress = textView6;
    }

    public static MapplsNearbyViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyViewBinding bind(View view, Object obj) {
        return (MapplsNearbyViewBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_view);
    }

    public static MapplsNearbyViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_view, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_view, null, false, obj);
    }
}
