package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionTollCostFragmentBinding extends ViewDataBinding {
    public final ImageView imageViewFuelCost;
    public final ImageView imageViewGrandTotalCost;
    public final ImageView imageViewShowHideTollInfo;
    public final ImageView imageViewTotalTollCost;
    public final ConstraintLayout layoutAfterFuelCostCalculated;
    public final ConstraintLayout layoutFuelAndTotalCost;
    public final MapplsDirectionCommonToolbarBinding layoutTollCost;
    public final NestedScrollView nestedScrollView;
    public final View previewView;
    public final RecyclerView recyclerViewToll;
    public final TextView textViewAddUpdateFuelCost;
    public final TextView textViewFuelCostInfo;
    public final TextView textViewGrandTotal;
    public final TextView textViewGrandTotalFee;
    public final TextView textViewGrandTotalInfo;
    public final TextView textViewNumberOfToll;
    public final TextView textViewTollRoute;
    public final TextView textViewTotalFuelCost;
    public final TextView textViewTotalFuelCostDisplay;
    public final TextView textViewTotalTollFee;
    public final ConstraintLayout tollCostLayout;
    public final View view1;
    public final View viewTollSeperator;

    protected MapplsDirectionTollCostFragmentBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, MapplsDirectionCommonToolbarBinding mapplsDirectionCommonToolbarBinding, NestedScrollView nestedScrollView, View view2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ConstraintLayout constraintLayout3, View view3, View view4) {
        super(obj, view, i);
        this.imageViewFuelCost = imageView;
        this.imageViewGrandTotalCost = imageView2;
        this.imageViewShowHideTollInfo = imageView3;
        this.imageViewTotalTollCost = imageView4;
        this.layoutAfterFuelCostCalculated = constraintLayout;
        this.layoutFuelAndTotalCost = constraintLayout2;
        this.layoutTollCost = mapplsDirectionCommonToolbarBinding;
        this.nestedScrollView = nestedScrollView;
        this.previewView = view2;
        this.recyclerViewToll = recyclerView;
        this.textViewAddUpdateFuelCost = textView;
        this.textViewFuelCostInfo = textView2;
        this.textViewGrandTotal = textView3;
        this.textViewGrandTotalFee = textView4;
        this.textViewGrandTotalInfo = textView5;
        this.textViewNumberOfToll = textView6;
        this.textViewTollRoute = textView7;
        this.textViewTotalFuelCost = textView8;
        this.textViewTotalFuelCostDisplay = textView9;
        this.textViewTotalTollFee = textView10;
        this.tollCostLayout = constraintLayout3;
        this.view1 = view3;
        this.viewTollSeperator = view4;
    }

    public static MapplsDirectionTollCostFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionTollCostFragmentBinding bind(View view, Object obj) {
        return (MapplsDirectionTollCostFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_toll_cost_fragment);
    }

    public static MapplsDirectionTollCostFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionTollCostFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionTollCostFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionTollCostFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_toll_cost_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionTollCostFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionTollCostFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_toll_cost_fragment, null, false, obj);
    }
}
