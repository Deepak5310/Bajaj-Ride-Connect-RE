package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionItemTollRowLayoutBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final ConstraintLayout layoutMoreDetailInfo;
    public final TextView textViewAmenities;
    public final TextView textViewAmenitiesLabel;
    public final TextView textViewCost;
    public final TextView textViewCostLabel;
    public final TextView textViewDistance;
    public final TextView textViewDistanceLabel;
    public final TextView textViewDuration;
    public final TextView textViewDurationLabel;
    public final TextView textViewEmergency;
    public final TextView textViewEmergencyLabel;
    public final TextView textViewTollInfo;
    public final TextView textViewTollName;

    protected MapplsDirectionItemTollRowLayoutBinding(Object obj, View view, int i, Barrier barrier, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        super(obj, view, i);
        this.barrier = barrier;
        this.layoutMoreDetailInfo = constraintLayout;
        this.textViewAmenities = textView;
        this.textViewAmenitiesLabel = textView2;
        this.textViewCost = textView3;
        this.textViewCostLabel = textView4;
        this.textViewDistance = textView5;
        this.textViewDistanceLabel = textView6;
        this.textViewDuration = textView7;
        this.textViewDurationLabel = textView8;
        this.textViewEmergency = textView9;
        this.textViewEmergencyLabel = textView10;
        this.textViewTollInfo = textView11;
        this.textViewTollName = textView12;
    }

    public static MapplsDirectionItemTollRowLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionItemTollRowLayoutBinding bind(View view, Object obj) {
        return (MapplsDirectionItemTollRowLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_item_toll_row_layout);
    }

    public static MapplsDirectionItemTollRowLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionItemTollRowLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionItemTollRowLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionItemTollRowLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_item_toll_row_layout, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionItemTollRowLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionItemTollRowLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_item_toll_row_layout, null, false, obj);
    }
}
