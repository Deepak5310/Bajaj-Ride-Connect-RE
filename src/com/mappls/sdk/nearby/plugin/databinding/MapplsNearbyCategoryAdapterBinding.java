package com.mappls.sdk.nearby.plugin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsNearbyCategoryAdapterBinding extends ViewDataBinding {
    public final CardView mapplsNearbyCategoryBackground;
    public final ImageView mapplsNearbyCategoryIcon;
    public final TextView mapplsNearbyKeyword;

    protected MapplsNearbyCategoryAdapterBinding(Object obj, View view, int i, CardView cardView, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.mapplsNearbyCategoryBackground = cardView;
        this.mapplsNearbyCategoryIcon = imageView;
        this.mapplsNearbyKeyword = textView;
    }

    public static MapplsNearbyCategoryAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyCategoryAdapterBinding bind(View view, Object obj) {
        return (MapplsNearbyCategoryAdapterBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_nearby_category_adapter);
    }

    public static MapplsNearbyCategoryAdapterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsNearbyCategoryAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsNearbyCategoryAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsNearbyCategoryAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_category_adapter, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsNearbyCategoryAdapterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsNearbyCategoryAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_nearby_category_adapter, null, false, obj);
    }
}
