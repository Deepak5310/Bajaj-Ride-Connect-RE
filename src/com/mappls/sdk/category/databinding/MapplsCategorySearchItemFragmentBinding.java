package com.mappls.sdk.category.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.mappls.sdk.category.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsCategorySearchItemFragmentBinding extends ViewDataBinding {
    public final AppBarLayout mapplsCategoryAppbar;
    public final ImageView mapplsCategoryBackIcon;
    public final TextView mapplsCategoryButtonNext;
    public final RecyclerView mapplsCategoryCategoryRecyclerView;
    public final CoordinatorLayout mapplsCategoryLayoutBackground;
    public final LinearLayout mapplsCategoryLinearLayout;
    public final RelativeLayout mapplsCategoryProgressBar;
    public final ImageButton mapplsCategorySearchClearBtn;
    public final EditText mapplsCategorySearchInput;
    public final LinearLayout mapplsCategorySearchLayoutParent;

    protected MapplsCategorySearchItemFragmentBinding(Object obj, View view, int i, AppBarLayout appBarLayout, ImageView imageView, TextView textView, RecyclerView recyclerView, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, RelativeLayout relativeLayout, ImageButton imageButton, EditText editText, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.mapplsCategoryAppbar = appBarLayout;
        this.mapplsCategoryBackIcon = imageView;
        this.mapplsCategoryButtonNext = textView;
        this.mapplsCategoryCategoryRecyclerView = recyclerView;
        this.mapplsCategoryLayoutBackground = coordinatorLayout;
        this.mapplsCategoryLinearLayout = linearLayout;
        this.mapplsCategoryProgressBar = relativeLayout;
        this.mapplsCategorySearchClearBtn = imageButton;
        this.mapplsCategorySearchInput = editText;
        this.mapplsCategorySearchLayoutParent = linearLayout2;
    }

    public static MapplsCategorySearchItemFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsCategorySearchItemFragmentBinding bind(View view, Object obj) {
        return (MapplsCategorySearchItemFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_category_search_item_fragment);
    }

    public static MapplsCategorySearchItemFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsCategorySearchItemFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsCategorySearchItemFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsCategorySearchItemFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_category_search_item_fragment, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsCategorySearchItemFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsCategorySearchItemFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_category_search_item_fragment, null, false, obj);
    }
}
