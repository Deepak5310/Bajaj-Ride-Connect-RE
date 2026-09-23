package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionFragmentAddWayPointDialogBinding extends ViewDataBinding {
    public final ConstraintLayout addWaypointBottomSheet;
    public final TextView buttonAddWaypoint;
    public final TextView itemPlaceResultPlaceAddress;
    public final RatingBar itemPlaceResultRatingBar;
    public final ImageView placeResultImg;
    public final TextView resultPlaceName;
    public final ImageView selectedWaypointBackIcon;
    public final ImageButton selectedWaypointClearBtn;
    public final LinearLayout selectedWaypointLayoutParent;
    public final TextView selectedWaypointSearchInput;
    public final TextView textViewDistance;

    protected MapplsDirectionFragmentAddWayPointDialogBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, RatingBar ratingBar, ImageView imageView, TextView textView3, ImageView imageView2, ImageButton imageButton, LinearLayout linearLayout, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.addWaypointBottomSheet = constraintLayout;
        this.buttonAddWaypoint = textView;
        this.itemPlaceResultPlaceAddress = textView2;
        this.itemPlaceResultRatingBar = ratingBar;
        this.placeResultImg = imageView;
        this.resultPlaceName = textView3;
        this.selectedWaypointBackIcon = imageView2;
        this.selectedWaypointClearBtn = imageButton;
        this.selectedWaypointLayoutParent = linearLayout;
        this.selectedWaypointSearchInput = textView4;
        this.textViewDistance = textView5;
    }

    public static MapplsDirectionFragmentAddWayPointDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionFragmentAddWayPointDialogBinding bind(View view, Object obj) {
        return (MapplsDirectionFragmentAddWayPointDialogBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_fragment_add_way_point_dialog);
    }

    public static MapplsDirectionFragmentAddWayPointDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionFragmentAddWayPointDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionFragmentAddWayPointDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionFragmentAddWayPointDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_fragment_add_way_point_dialog, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionFragmentAddWayPointDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionFragmentAddWayPointDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_fragment_add_way_point_dialog, null, false, obj);
    }
}
