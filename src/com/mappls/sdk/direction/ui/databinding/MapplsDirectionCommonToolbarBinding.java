package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionCommonToolbarBinding extends ViewDataBinding {
    public final AppBarLayout commonAppBar;
    public final LinearLayout layoutCommonToolbar;
    public final Toolbar toolbar;

    protected MapplsDirectionCommonToolbarBinding(Object obj, View view, int i, AppBarLayout appBarLayout, LinearLayout linearLayout, Toolbar toolbar) {
        super(obj, view, i);
        this.commonAppBar = appBarLayout;
        this.layoutCommonToolbar = linearLayout;
        this.toolbar = toolbar;
    }

    public static MapplsDirectionCommonToolbarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionCommonToolbarBinding bind(View view, Object obj) {
        return (MapplsDirectionCommonToolbarBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_common_toolbar);
    }

    public static MapplsDirectionCommonToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionCommonToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionCommonToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionCommonToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_common_toolbar, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionCommonToolbarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionCommonToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_common_toolbar, null, false, obj);
    }
}
