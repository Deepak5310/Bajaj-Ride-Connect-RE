package com.mappls.sdk.direction.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsDirectionWidgetBinding extends ViewDataBinding {
    public final FrameLayout mapplsDirectionContainerFragment;

    protected MapplsDirectionWidgetBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.mapplsDirectionContainerFragment = frameLayout;
    }

    public static MapplsDirectionWidgetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionWidgetBinding bind(View view, Object obj) {
        return (MapplsDirectionWidgetBinding) ViewDataBinding.bind(obj, view, R.layout.mappls_direction_widget);
    }

    public static MapplsDirectionWidgetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    public static MapplsDirectionWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MapplsDirectionWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MapplsDirectionWidgetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_widget, viewGroup, z, obj);
    }

    @Deprecated
    public static MapplsDirectionWidgetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MapplsDirectionWidgetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mappls_direction_widget, null, false, obj);
    }
}
