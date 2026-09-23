package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionListHeaderBinding extends ViewDataBinding {
    public final TextView directionListDesc;
    public final TextView directionListPlaceName;
    public final View directionListSeperator;
    public final ImageView imageIcon;
    public final FrameLayout imageIconContainer;
    public final RelativeLayout mapplsDirectionSteplistContainer;

    protected MapplsDirectionListHeaderBinding(Object obj, View view, int i, TextView textView, TextView textView2, View view2, ImageView imageView, FrameLayout frameLayout, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.directionListDesc = textView;
        this.directionListPlaceName = textView2;
        this.directionListSeperator = view2;
        this.imageIcon = imageView;
        this.imageIconContainer = frameLayout;
        this.mapplsDirectionSteplistContainer = relativeLayout;
    }

    public static MapplsDirectionListHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionListHeaderBinding bind(View view, Object obj) {
        return (MapplsDirectionListHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_list_header);
    }

    public static MapplsDirectionListHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_list_header, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionListHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_list_header, null, false, obj);
    }
}
