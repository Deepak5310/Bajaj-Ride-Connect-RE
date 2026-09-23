package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutDirectionListBinding extends ViewDataBinding {
    public final TextView btnShowMap;
    public final ImageView closeBottomSheet;
    public final RelativeLayout directionListView;
    public final RecyclerView rvDirectionList;
    public final CardView toolbarDirection;
    public final TextView toolbarText;

    protected LayoutDirectionListBinding(Object obj, View view, int i, TextView textView, ImageView imageView, RelativeLayout relativeLayout, RecyclerView recyclerView, CardView cardView, TextView textView2) {
        super(obj, view, i);
        this.btnShowMap = textView;
        this.closeBottomSheet = imageView;
        this.directionListView = relativeLayout;
        this.rvDirectionList = recyclerView;
        this.toolbarDirection = cardView;
        this.toolbarText = textView2;
    }

    public static LayoutDirectionListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutDirectionListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutDirectionListBinding bind(View view, Object obj) {
        return (LayoutDirectionListBinding) ViewDataBinding.bind(obj, view, R.layout.layout_direction_list);
    }

    @Deprecated
    public static LayoutDirectionListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutDirectionListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_direction_list, viewGroup, z, obj);
    }

    public static LayoutDirectionListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutDirectionListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutDirectionListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_direction_list, null, false, obj);
    }
}
