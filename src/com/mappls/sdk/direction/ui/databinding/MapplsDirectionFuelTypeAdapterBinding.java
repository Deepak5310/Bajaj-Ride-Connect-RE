package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionFuelTypeAdapterBinding extends ViewDataBinding {
    public final ImageView imageViewFuelType;
    public final ConstraintLayout parentLayout;
    public final TextView textViewTypeFuel;

    protected MapplsDirectionFuelTypeAdapterBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.imageViewFuelType = imageView;
        this.parentLayout = constraintLayout;
        this.textViewTypeFuel = textView;
    }

    public static MapplsDirectionFuelTypeAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionFuelTypeAdapterBinding bind(View view, Object obj) {
        return (MapplsDirectionFuelTypeAdapterBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_fuel_type_adapter);
    }

    public static MapplsDirectionFuelTypeAdapterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionFuelTypeAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionFuelTypeAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionFuelTypeAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_fuel_type_adapter, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionFuelTypeAdapterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionFuelTypeAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_fuel_type_adapter, null, false, obj);
    }
}
