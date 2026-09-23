package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionItemStopBinding extends ViewDataBinding {
    public final View connector;
    public final ImageView imgClear;
    public final ImageView imgDrag;
    public final ImageView imgStopType;
    public final View mapplsDirectionRouteStepSeperatorView;
    public final TextView textViewAddStop;

    protected MapplsDirectionItemStopBinding(Object obj, View view, int i, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, View view3, TextView textView) {
        super(obj, view, i);
        this.connector = view2;
        this.imgClear = imageView;
        this.imgDrag = imageView2;
        this.imgStopType = imageView3;
        this.mapplsDirectionRouteStepSeperatorView = view3;
        this.textViewAddStop = textView;
    }

    public static MapplsDirectionItemStopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionItemStopBinding bind(View view, Object obj) {
        return (MapplsDirectionItemStopBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_item_stop);
    }

    public static MapplsDirectionItemStopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionItemStopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionItemStopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionItemStopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_item_stop, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionItemStopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionItemStopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_item_stop, null, false, obj);
    }
}
