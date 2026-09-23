package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyResultViewBinding extends ViewDataBinding {
    public final FrameLayout mapplsNearbyMapContainer;
    public final CardView mapplsNearbyNext;
    public final CardView mapplsNearbyPageCurrent;
    public final TextView mapplsNearbyPageCurrentTv;
    public final CardView mapplsNearbyPageNext;
    public final TextView mapplsNearbyPageNextTv;
    public final View mapplsNearbyPageShadow;
    public final CardView mapplsNearbyPrev;
    public final ConstraintLayout mapplsNearbyResultCategoryBg;
    public final RecyclerView mapplsNearbyResultCategoryRv;
    public final ConstraintLayout mapplsNearbyResultPage;
    public final RelativeLayout mapplsNearbyResultProgressBar;
    public final ConstraintLayout mapplsNearbyResultToolbar;
    public final TextView mapplsNearbyResultToolbarTextView;
    public final TabLayout mapplsNearbyTabLayout;
    public final View mapplsNearbyTabShadow;
    public final ImageView mapplsNearbyToolbarBackButton;
    public final ViewPager2 mapplsNearbyViewPager;

    protected MapplsNearbyResultViewBinding(Object obj, View view, int i, FrameLayout frameLayout, CardView cardView, CardView cardView2, TextView textView, CardView cardView3, TextView textView2, View view2, CardView cardView4, ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2, RelativeLayout relativeLayout, ConstraintLayout constraintLayout3, TextView textView3, TabLayout tabLayout, View view3, ImageView imageView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.mapplsNearbyMapContainer = frameLayout;
        this.mapplsNearbyNext = cardView;
        this.mapplsNearbyPageCurrent = cardView2;
        this.mapplsNearbyPageCurrentTv = textView;
        this.mapplsNearbyPageNext = cardView3;
        this.mapplsNearbyPageNextTv = textView2;
        this.mapplsNearbyPageShadow = view2;
        this.mapplsNearbyPrev = cardView4;
        this.mapplsNearbyResultCategoryBg = constraintLayout;
        this.mapplsNearbyResultCategoryRv = recyclerView;
        this.mapplsNearbyResultPage = constraintLayout2;
        this.mapplsNearbyResultProgressBar = relativeLayout;
        this.mapplsNearbyResultToolbar = constraintLayout3;
        this.mapplsNearbyResultToolbarTextView = textView3;
        this.mapplsNearbyTabLayout = tabLayout;
        this.mapplsNearbyTabShadow = view3;
        this.mapplsNearbyToolbarBackButton = imageView;
        this.mapplsNearbyViewPager = viewPager2;
    }

    public static MapplsNearbyResultViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultViewBinding bind(View view, Object obj) {
        return (MapplsNearbyResultViewBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_result_view);
    }

    public static MapplsNearbyResultViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyResultViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyResultViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyResultViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_view, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyResultViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyResultViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_result_view, null, false, obj);
    }
}
