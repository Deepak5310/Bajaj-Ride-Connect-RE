package com.mappls.sdk.category.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.mappls.sdk.category.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsCategoryResultFragmentBinding extends ViewDataBinding {
    public final View mapplsCategoryLayoutEmptyErrorState;
    public final RecyclerView mapplsCategoryPoiList;
    public final RelativeLayout mapplsCategoryPoiListBottomSheetContainer;
    public final View mapplsCategoryProgressLayout;
    public final ImageView mapplsCategoryResultBackIcon;
    public final TextView mapplsCategoryResultSearchInput;
    public final LinearLayout mapplsCategoryResultSearchLayoutParent;
    public final ImageButton mapplsCategorySearchClearBtn;
    public final TextView mapplsCategoryTextViewResults;
    public final AppBarLayout resultAppbar;
    public final View view2;

    protected MapplsCategoryResultFragmentBinding(Object obj, View view, int i, View view2, RecyclerView recyclerView, RelativeLayout relativeLayout, View view3, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageButton imageButton, TextView textView2, AppBarLayout appBarLayout, View view4) {
        super(obj, view, i);
        this.mapplsCategoryLayoutEmptyErrorState = view2;
        this.mapplsCategoryPoiList = recyclerView;
        this.mapplsCategoryPoiListBottomSheetContainer = relativeLayout;
        this.mapplsCategoryProgressLayout = view3;
        this.mapplsCategoryResultBackIcon = imageView;
        this.mapplsCategoryResultSearchInput = textView;
        this.mapplsCategoryResultSearchLayoutParent = linearLayout;
        this.mapplsCategorySearchClearBtn = imageButton;
        this.mapplsCategoryTextViewResults = textView2;
        this.resultAppbar = appBarLayout;
        this.view2 = view4;
    }

    public static MapplsCategoryResultFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsCategoryResultFragmentBinding bind(View view, Object obj) {
        return (MapplsCategoryResultFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_category_result_fragment);
    }

    public static MapplsCategoryResultFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsCategoryResultFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsCategoryResultFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsCategoryResultFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_category_result_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsCategoryResultFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsCategoryResultFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_category_result_fragment, null, false, obj);
    }
}
