package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionLayoutBinding extends ViewDataBinding {
    public final FrameLayout fragmentContainer;
    public final FrameLayout mapContainer;

    protected MapplsDirectionLayoutBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.fragmentContainer = frameLayout;
        this.mapContainer = frameLayout2;
    }

    public static MapplsDirectionLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionLayoutBinding bind(View view, Object obj) {
        return (MapplsDirectionLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_layout);
    }

    public static MapplsDirectionLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_layout, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_layout, null, false, obj);
    }
}
