package com.mappls.sdk.category.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.category.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsCategorySearchFragmentBinding extends ViewDataBinding {
    public final FrameLayout mapplsCategoryView;

    protected MapplsCategorySearchFragmentBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.mapplsCategoryView = frameLayout;
    }

    public static MapplsCategorySearchFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsCategorySearchFragmentBinding bind(View view, Object obj) {
        return (MapplsCategorySearchFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_category_search_fragment);
    }

    public static MapplsCategorySearchFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsCategorySearchFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsCategorySearchFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsCategorySearchFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_category_search_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsCategorySearchFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsCategorySearchFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_category_search_fragment, null, false, obj);
    }
}
