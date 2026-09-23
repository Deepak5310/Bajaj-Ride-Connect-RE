package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionFuelCostFragmentBinding extends ViewDataBinding {
    public final EditText editTextAverage;
    public final EditText editTextCost;
    public final MapplsDirectionCommonToolbarBinding fuelCostHeader;
    public final ConstraintLayout fuelCostLayout;
    public final View fuelCostSeperatorView;
    public final ImageView imageViewAutoGraph;
    public final ImageView imageViewDistance;
    public final ImageView imageViewDuration;
    public final ImageView imageViewRupee;
    public final ImageView imageViewRupeeSymbol;
    public final ConstraintLayout layoutBeforeFuelCostCalculated;
    public final ConstraintLayout layoutDistance;
    public final ConstraintLayout layoutDuration;
    public final ConstraintLayout layoutTollInfo;
    public final ConstraintLayout layoutTollLayout;
    public final View previewView;
    public final RecyclerView recyclerViewFuelType;
    public final TextView textViewCalculate;
    public final TextView textViewDistance;
    public final TextView textViewDistanceLebel;
    public final TextView textViewDuration;
    public final TextView textViewDurationLebel;
    public final TextView textViewSelectFuelType;
    public final TextView textViewTollFee;
    public final TextView textViewTollLebel;
    public final View view1;
    public final View view2;

    protected MapplsDirectionFuelCostFragmentBinding(Object obj, View view, int i, EditText editText, EditText editText2, MapplsDirectionCommonToolbarBinding mapplsDirectionCommonToolbarBinding, ConstraintLayout constraintLayout, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, View view3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view4, View view5) {
        super(obj, view, i);
        this.editTextAverage = editText;
        this.editTextCost = editText2;
        this.fuelCostHeader = mapplsDirectionCommonToolbarBinding;
        this.fuelCostLayout = constraintLayout;
        this.fuelCostSeperatorView = view2;
        this.imageViewAutoGraph = imageView;
        this.imageViewDistance = imageView2;
        this.imageViewDuration = imageView3;
        this.imageViewRupee = imageView4;
        this.imageViewRupeeSymbol = imageView5;
        this.layoutBeforeFuelCostCalculated = constraintLayout2;
        this.layoutDistance = constraintLayout3;
        this.layoutDuration = constraintLayout4;
        this.layoutTollInfo = constraintLayout5;
        this.layoutTollLayout = constraintLayout6;
        this.previewView = view3;
        this.recyclerViewFuelType = recyclerView;
        this.textViewCalculate = textView;
        this.textViewDistance = textView2;
        this.textViewDistanceLebel = textView3;
        this.textViewDuration = textView4;
        this.textViewDurationLebel = textView5;
        this.textViewSelectFuelType = textView6;
        this.textViewTollFee = textView7;
        this.textViewTollLebel = textView8;
        this.view1 = view4;
        this.view2 = view5;
    }

    public static MapplsDirectionFuelCostFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionFuelCostFragmentBinding bind(View view, Object obj) {
        return (MapplsDirectionFuelCostFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_fuel_cost_fragment);
    }

    public static MapplsDirectionFuelCostFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionFuelCostFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionFuelCostFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionFuelCostFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_fuel_cost_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionFuelCostFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionFuelCostFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_fuel_cost_fragment, null, false, obj);
    }
}
