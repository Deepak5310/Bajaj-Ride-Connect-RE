package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.mappls.sdk.direction.ui.DirectionViewModel;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsRoutingLayoutBinding extends ViewDataBinding {
    public final AppBarLayout appbarDirection;
    public final TabItem bikeTabItem;
    public final RelativeLayout bottomSheetDetails;
    public final View bottomSheetShadow;
    public final TextView btnRetryRouteNotFound;
    public final TextView btnStart;
    public final TabItem carTabItem;
    public final MapplsDirectionLayoutCollapsedRouteViewBinding collapsedRouteTimeline;
    public final ConstraintLayout constraintLayoutMessage;
    public final LinearLayout containerRouteDetails;
    public final CoordinatorLayout directionContainer;
    public final View directionDecorationImageView;
    public final TextView directionEtaTextView;
    public final TextView directionListTextview;
    public final LinearLayout directionTimeLayout;
    public final ConstraintLayout directionsTopView;
    public final TextView distanceText;
    public final ConstraintLayout errorLayout;
    public final TabItem heavyVehicleTabItem;
    public final ImageView imgStart;
    public final ImageView ivErrorStateDirection;
    public final ConstraintLayout layoutTimeDetails;

    @Bindable
    protected String mArrival;

    @Bindable
    protected String mDistance;

    @Bindable
    protected View.OnClickListener mOnClickGetRoute;

    @Bindable
    protected View.OnClickListener mOnClickSearchCategory;

    @Bindable
    protected View.OnClickListener mOnHandleBack;

    @Bindable
    protected View.OnClickListener mOnRouteReportClick;

    @Bindable
    protected DirectionViewModel mOnStartClick;

    @Bindable
    protected View.OnClickListener mRetryButtonClick;

    @Bindable
    protected String mRouteTime;

    @Bindable
    protected View.OnClickListener mStartButtonClick;
    public final FrameLayout mapContainer;
    public final ImageView mapplsDirectionBack;
    public final View mapplsDirectionEtaSeperator;
    public final TabLayout mapplsDirectionTabLayout;
    public final ImageView nearbyReport;
    public final LinearLayout notificationLayout;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerDirectionStep;
    public final RecyclerView recyclerStop;
    public final ImageButton searchCategoryFab;
    public final TextView showOnMapsBtn;
    public final LinearLayout showOnMapsLayout;
    public final LinearLayout startLayout;
    public final TextView textRoute;
    public final ImageView tripCostSummary;
    public final TextView tvClassNotification;
    public final TextView tvRouteNotFoundHeading;
    public final TextView tvRouteNotFoundText;
    public final TextView viewGetRoute;
    public final TabItem walkTabItem;

    protected MapplsRoutingLayoutBinding(Object obj, View view, int i, AppBarLayout appBarLayout, TabItem tabItem, RelativeLayout relativeLayout, View view2, TextView textView, TextView textView2, TabItem tabItem2, MapplsDirectionLayoutCollapsedRouteViewBinding mapplsDirectionLayoutCollapsedRouteViewBinding, ConstraintLayout constraintLayout, LinearLayout linearLayout, CoordinatorLayout coordinatorLayout, View view3, TextView textView3, TextView textView4, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TextView textView5, ConstraintLayout constraintLayout3, TabItem tabItem3, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout4, FrameLayout frameLayout, ImageView imageView3, View view4, TabLayout tabLayout, ImageView imageView4, LinearLayout linearLayout3, ProgressBar progressBar, RecyclerView recyclerView, RecyclerView recyclerView2, ImageButton imageButton, TextView textView6, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView7, ImageView imageView5, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TabItem tabItem4) {
        super(obj, view, i);
        this.appbarDirection = appBarLayout;
        this.bikeTabItem = tabItem;
        this.bottomSheetDetails = relativeLayout;
        this.bottomSheetShadow = view2;
        this.btnRetryRouteNotFound = textView;
        this.btnStart = textView2;
        this.carTabItem = tabItem2;
        this.collapsedRouteTimeline = mapplsDirectionLayoutCollapsedRouteViewBinding;
        this.constraintLayoutMessage = constraintLayout;
        this.containerRouteDetails = linearLayout;
        this.directionContainer = coordinatorLayout;
        this.directionDecorationImageView = view3;
        this.directionEtaTextView = textView3;
        this.directionListTextview = textView4;
        this.directionTimeLayout = linearLayout2;
        this.directionsTopView = constraintLayout2;
        this.distanceText = textView5;
        this.errorLayout = constraintLayout3;
        this.heavyVehicleTabItem = tabItem3;
        this.imgStart = imageView;
        this.ivErrorStateDirection = imageView2;
        this.layoutTimeDetails = constraintLayout4;
        this.mapContainer = frameLayout;
        this.mapplsDirectionBack = imageView3;
        this.mapplsDirectionEtaSeperator = view4;
        this.mapplsDirectionTabLayout = tabLayout;
        this.nearbyReport = imageView4;
        this.notificationLayout = linearLayout3;
        this.progressBar = progressBar;
        this.recyclerDirectionStep = recyclerView;
        this.recyclerStop = recyclerView2;
        this.searchCategoryFab = imageButton;
        this.showOnMapsBtn = textView6;
        this.showOnMapsLayout = linearLayout4;
        this.startLayout = linearLayout5;
        this.textRoute = textView7;
        this.tripCostSummary = imageView5;
        this.tvClassNotification = textView8;
        this.tvRouteNotFoundHeading = textView9;
        this.tvRouteNotFoundText = textView10;
        this.viewGetRoute = textView11;
        this.walkTabItem = tabItem4;
    }

    public static MapplsRoutingLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsRoutingLayoutBinding bind(View view, Object obj) {
        return (MapplsRoutingLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_routing_layout);
    }

    public static MapplsRoutingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsRoutingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsRoutingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsRoutingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_routing_layout, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsRoutingLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsRoutingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_routing_layout, null, false, obj);
    }

    public String getArrival() {
        return this.mArrival;
    }

    public String getDistance() {
        return this.mDistance;
    }

    public View.OnClickListener getOnClickGetRoute() {
        return this.mOnClickGetRoute;
    }

    public View.OnClickListener getOnClickSearchCategory() {
        return this.mOnClickSearchCategory;
    }

    public View.OnClickListener getOnHandleBack() {
        return this.mOnHandleBack;
    }

    public View.OnClickListener getOnRouteReportClick() {
        return this.mOnRouteReportClick;
    }

    public DirectionViewModel getOnStartClick() {
        return this.mOnStartClick;
    }

    public View.OnClickListener getRetryButtonClick() {
        return this.mRetryButtonClick;
    }

    public String getRouteTime() {
        return this.mRouteTime;
    }

    public View.OnClickListener getStartButtonClick() {
        return this.mStartButtonClick;
    }

    public abstract void setArrival(String str);

    public abstract void setDistance(String str);

    public abstract void setOnClickGetRoute(View.OnClickListener onClickListener);

    public abstract void setOnClickSearchCategory(View.OnClickListener onClickListener);

    public abstract void setOnHandleBack(View.OnClickListener onClickListener);

    public abstract void setOnRouteReportClick(View.OnClickListener onClickListener);

    public abstract void setOnStartClick(DirectionViewModel directionViewModel);

    public abstract void setRetryButtonClick(View.OnClickListener onClickListener);

    public abstract void setRouteTime(String str);

    public abstract void setStartButtonClick(View.OnClickListener onClickListener);
}
