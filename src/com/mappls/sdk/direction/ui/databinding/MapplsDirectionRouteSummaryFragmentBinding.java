package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionRouteSummaryFragmentBinding extends ViewDataBinding {
    public final ImageView imageViewClose;
    public final ImageView nearbyReport;
    public final ViewPager routeSummaryEventViewPager;
    public final LinearLayout routeSummaryLayout;
    public final LinearLayout routeSummarySelectorLayout;
    public final TabLayout routeSummaryTabLayout;
    public final LinearLayout routeSummaryTitle;
    public final TextView routeSummaryTitleTxt;

    protected MapplsDirectionRouteSummaryFragmentBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ViewPager viewPager, LinearLayout linearLayout, LinearLayout linearLayout2, TabLayout tabLayout, LinearLayout linearLayout3, TextView textView) {
        super(obj, view, i);
        this.imageViewClose = imageView;
        this.nearbyReport = imageView2;
        this.routeSummaryEventViewPager = viewPager;
        this.routeSummaryLayout = linearLayout;
        this.routeSummarySelectorLayout = linearLayout2;
        this.routeSummaryTabLayout = tabLayout;
        this.routeSummaryTitle = linearLayout3;
        this.routeSummaryTitleTxt = textView;
    }

    public static MapplsDirectionRouteSummaryFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryFragmentBinding bind(View view, Object obj) {
        return (MapplsDirectionRouteSummaryFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_route_summary_fragment);
    }

    public static MapplsDirectionRouteSummaryFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionRouteSummaryFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionRouteSummaryFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionRouteSummaryFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionRouteSummaryFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_route_summary_fragment, null, false, obj);
    }
}
