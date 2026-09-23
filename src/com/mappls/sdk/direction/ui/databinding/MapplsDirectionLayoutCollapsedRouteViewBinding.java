package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionLayoutCollapsedRouteViewBinding extends ViewDataBinding {
    public final LinearLayout collapsedRouteTimeline;
    public final ImageButton editWaypointsBtn;
    public final ImageView imgDestination;
    public final ImageView imgSourceLocation;
    public final ImageView imgWaypoints;

    @Bindable
    protected String mDestinationRouteLocation;

    @Bindable
    protected View.OnClickListener mOnclickHandleBack;

    @Bindable
    protected String mSourceRouteLocation;

    @Bindable
    protected String mWayPoints;
    public final LinearLayout soucreLocationLayout;
    public final TextView textDestinationRoute;
    public final TextView textSourceRoute;
    public final TextView textViewWaypoints;
    public final LinearLayout viewSourceLocation;
    public final LinearLayout viewWaypoints;
    public final LinearLayout waypointsLayout;

    protected MapplsDirectionLayoutCollapsedRouteViewBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageButton imageButton, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5) {
        super(obj, view, i);
        this.collapsedRouteTimeline = linearLayout;
        this.editWaypointsBtn = imageButton;
        this.imgDestination = imageView;
        this.imgSourceLocation = imageView2;
        this.imgWaypoints = imageView3;
        this.soucreLocationLayout = linearLayout2;
        this.textDestinationRoute = textView;
        this.textSourceRoute = textView2;
        this.textViewWaypoints = textView3;
        this.viewSourceLocation = linearLayout3;
        this.viewWaypoints = linearLayout4;
        this.waypointsLayout = linearLayout5;
    }

    public static MapplsDirectionLayoutCollapsedRouteViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionLayoutCollapsedRouteViewBinding bind(View view, Object obj) {
        return (MapplsDirectionLayoutCollapsedRouteViewBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_layout_collapsed_route_view);
    }

    public static MapplsDirectionLayoutCollapsedRouteViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionLayoutCollapsedRouteViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionLayoutCollapsedRouteViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionLayoutCollapsedRouteViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_layout_collapsed_route_view, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionLayoutCollapsedRouteViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionLayoutCollapsedRouteViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_layout_collapsed_route_view, null, false, obj);
    }

    public String getDestinationRouteLocation() {
        return this.mDestinationRouteLocation;
    }

    public View.OnClickListener getOnclickHandleBack() {
        return this.mOnclickHandleBack;
    }

    public String getSourceRouteLocation() {
        return this.mSourceRouteLocation;
    }

    public String getWayPoints() {
        return this.mWayPoints;
    }

    public abstract void setDestinationRouteLocation(String str);

    public abstract void setOnclickHandleBack(View.OnClickListener onClickListener);

    public abstract void setSourceRouteLocation(String str);

    public abstract void setWayPoints(String str);
}
