package com.mappls.sdk.direction.ui.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.mappls.sdk.direction.ui.DirectionViewModel;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public class MapplsRoutingLayoutBindingLandImpl extends MapplsRoutingLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(42);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"mappls_direction_layout_collapsed_route_view"}, new int[]{13}, new int[]{R.layout.mappls_direction_layout_collapsed_route_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.map_container, 14);
        sparseIntArray.put(R.id.appbar_direction, 15);
        sparseIntArray.put(R.id.constraint_layout_message, 16);
        sparseIntArray.put(R.id.direction_decoration_image_view, 17);
        sparseIntArray.put(R.id.mappls_direction_tab_layout, 18);
        sparseIntArray.put(R.id.car_tab_item, 19);
        sparseIntArray.put(R.id.bike_tab_item, 20);
        sparseIntArray.put(R.id.heavy_vehicle_tab_item, 21);
        sparseIntArray.put(R.id.walk_tab_item, 22);
        sparseIntArray.put(R.id.recycler_stop, 23);
        sparseIntArray.put(R.id.error_layout, 24);
        sparseIntArray.put(R.id.iv_error_state_direction, 25);
        sparseIntArray.put(R.id.tv_route_not_found_heading, 26);
        sparseIntArray.put(R.id.tv_route_not_found_text, 27);
        sparseIntArray.put(R.id.bottom_Sheet_details, 28);
        sparseIntArray.put(R.id.container_route_details, 29);
        sparseIntArray.put(R.id.bottom_sheet_shadow, 30);
        sparseIntArray.put(R.id.progressBar, 31);
        sparseIntArray.put(R.id.layout_time_details, 32);
        sparseIntArray.put(R.id.direction_time_layout, 33);
        sparseIntArray.put(R.id.trip_cost_summary, 34);
        sparseIntArray.put(R.id.direction_list_textview, 35);
        sparseIntArray.put(R.id.mappls_direction_eta_seperator, 36);
        sparseIntArray.put(R.id.notification_layout, 37);
        sparseIntArray.put(R.id.tv_class_notification, 38);
        sparseIntArray.put(R.id.recycler_direction_step, 39);
        sparseIntArray.put(R.id.show_on_maps_layout, 40);
        sparseIntArray.put(R.id.show_on_maps_btn, 41);
    }

    public MapplsRoutingLayoutBindingLandImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 42, sIncludes, sViewsWithIds));
    }

    private MapplsRoutingLayoutBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AppBarLayout) objArr[15], (TabItem) objArr[20], (RelativeLayout) objArr[28], (View) objArr[30], (TextView) objArr[5], (TextView) objArr[12], (TabItem) objArr[19], (MapplsDirectionLayoutCollapsedRouteViewBinding) objArr[13], (ConstraintLayout) objArr[16], (LinearLayout) objArr[29], (CoordinatorLayout) objArr[0], (View) objArr[17], (TextView) objArr[9], (TextView) objArr[35], (LinearLayout) objArr[33], (ConstraintLayout) objArr[1], (TextView) objArr[8], (ConstraintLayout) objArr[24], (TabItem) objArr[21], (ImageView) objArr[11], (ImageView) objArr[25], (ConstraintLayout) objArr[32], (FrameLayout) objArr[14], (ImageView) objArr[2], (View) objArr[36], (TabLayout) objArr[18], (ImageView) objArr[7], (LinearLayout) objArr[37], (ProgressBar) objArr[31], (RecyclerView) objArr[39], (RecyclerView) objArr[23], (ImageButton) objArr[4], (TextView) objArr[41], (LinearLayout) objArr[40], (LinearLayout) objArr[10], (TextView) objArr[6], (ImageView) objArr[34], (TextView) objArr[38], (TextView) objArr[26], (TextView) objArr[27], (TextView) objArr[3], (TabItem) objArr[22]);
        this.mDirtyFlags = -1L;
        this.btnRetryRouteNotFound.setTag(null);
        this.btnStart.setTag(null);
        setContainedBinding(this.collapsedRouteTimeline);
        this.directionContainer.setTag(null);
        this.directionEtaTextView.setTag(null);
        this.directionsTopView.setTag(null);
        this.distanceText.setTag(null);
        this.imgStart.setTag(null);
        this.mapplsDirectionBack.setTag(null);
        this.nearbyReport.setTag(null);
        this.searchCategoryFab.setTag(null);
        this.startLayout.setTag(null);
        this.textRoute.setTag(null);
        this.viewGetRoute.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean onChangeCollapsedRouteTimeline(MapplsDirectionLayoutCollapsedRouteViewBinding mapplsDirectionLayoutCollapsedRouteViewBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        Drawable drawable;
        boolean zIsCurrentLocation;
        Context context;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str2 = this.mRouteTime;
        View.OnClickListener onClickListener = this.mRetryButtonClick;
        View.OnClickListener onClickListener2 = this.mOnHandleBack;
        String str3 = this.mDistance;
        View.OnClickListener onClickListener3 = this.mOnRouteReportClick;
        View.OnClickListener onClickListener4 = this.mStartButtonClick;
        String str4 = this.mArrival;
        View.OnClickListener onClickListener5 = this.mOnClickGetRoute;
        DirectionViewModel directionViewModel = this.mOnStartClick;
        View.OnClickListener onClickListener6 = this.mOnClickSearchCategory;
        long j2 = j & 2560;
        String locationText = null;
        if (j2 != 0) {
            if (directionViewModel != null) {
                locationText = directionViewModel.setLocationText();
                zIsCurrentLocation = directionViewModel.isCurrentLocation();
            } else {
                zIsCurrentLocation = false;
            }
            if (j2 != 0) {
                j |= zIsCurrentLocation ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            if (zIsCurrentLocation) {
                context = this.imgStart.getContext();
                i = R.drawable.mappls_direction_baseline_near_me_24;
            } else {
                context = this.imgStart.getContext();
                i = R.drawable.mappls_direction_preview_direction_wt;
            }
            drawable = AppCompatResources.getDrawable(context, i);
            str = locationText;
        } else {
            str = null;
            drawable = null;
        }
        long j3 = j & 3072;
        if ((j & 2052) != 0) {
            this.btnRetryRouteNotFound.setOnClickListener(onClickListener);
        }
        if ((2560 & j) != 0) {
            TextViewBindingAdapter.setText(this.btnStart, str);
            ImageViewBindingAdapter.setImageDrawable(this.imgStart, drawable);
        }
        if ((2176 & j) != 0) {
            TextViewBindingAdapter.setText(this.directionEtaTextView, str4);
        }
        if ((2064 & j) != 0) {
            TextViewBindingAdapter.setText(this.distanceText, str3);
        }
        if ((2056 & j) != 0) {
            this.mapplsDirectionBack.setOnClickListener(onClickListener2);
        }
        if ((2080 & j) != 0) {
            this.nearbyReport.setOnClickListener(onClickListener3);
        }
        if (j3 != 0) {
            this.searchCategoryFab.setOnClickListener(onClickListener6);
        }
        if ((2112 & j) != 0) {
            this.startLayout.setOnClickListener(onClickListener4);
        }
        if ((2050 & j) != 0) {
            TextViewBindingAdapter.setText(this.textRoute, str2);
        }
        if ((j & 2304) != 0) {
            this.viewGetRoute.setOnClickListener(onClickListener5);
        }
        ViewDataBinding.executeBindingsOn(this.collapsedRouteTimeline);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.collapsedRouteTimeline.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        this.collapsedRouteTimeline.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeCollapsedRouteTimeline((MapplsDirectionLayoutCollapsedRouteViewBinding) obj, i2);
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setArrival(String str) {
        this.mArrival = str;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setDistance(String str) {
        this.mDistance = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.collapsedRouteTimeline.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setOnClickGetRoute(View.OnClickListener onClickListener) {
        this.mOnClickGetRoute = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setOnClickSearchCategory(View.OnClickListener onClickListener) {
        this.mOnClickSearchCategory = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setOnHandleBack(View.OnClickListener onClickListener) {
        this.mOnHandleBack = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setOnRouteReportClick(View.OnClickListener onClickListener) {
        this.mOnRouteReportClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setOnStartClick(DirectionViewModel directionViewModel) {
        this.mOnStartClick = directionViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setRetryButtonClick(View.OnClickListener onClickListener) {
        this.mRetryButtonClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setRouteTime(String str) {
        this.mRouteTime = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding
    public void setStartButtonClick(View.OnClickListener onClickListener) {
        this.mStartButtonClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (13 == i) {
            setRouteTime((String) obj);
            return true;
        }
        if (12 == i) {
            setRetryButtonClick((View.OnClickListener) obj);
            return true;
        }
        if (6 == i) {
            setOnHandleBack((View.OnClickListener) obj);
            return true;
        }
        if (3 == i) {
            setDistance((String) obj);
            return true;
        }
        if (9 == i) {
            setOnRouteReportClick((View.OnClickListener) obj);
            return true;
        }
        if (15 == i) {
            setStartButtonClick((View.OnClickListener) obj);
            return true;
        }
        if (1 == i) {
            setArrival((String) obj);
            return true;
        }
        if (4 == i) {
            setOnClickGetRoute((View.OnClickListener) obj);
            return true;
        }
        if (10 == i) {
            setOnStartClick((DirectionViewModel) obj);
            return true;
        }
        if (5 != i) {
            return false;
        }
        setOnClickSearchCategory((View.OnClickListener) obj);
        return true;
    }
}
