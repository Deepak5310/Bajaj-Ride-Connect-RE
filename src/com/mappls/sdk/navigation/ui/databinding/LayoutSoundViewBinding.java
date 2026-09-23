package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSoundViewBinding extends ViewDataBinding {
    public final ImageView soundBtn;
    public final TextView soundText;

    protected LayoutSoundViewBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.soundBtn = imageView;
        this.soundText = textView;
    }

    public static LayoutSoundViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutSoundViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSoundViewBinding bind(View view, Object obj) {
        return (LayoutSoundViewBinding) ViewDataBinding.bind(obj, view, R.layout.layout_sound_view);
    }

    @Deprecated
    public static LayoutSoundViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutSoundViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_sound_view, viewGroup, z, obj);
    }

    public static LayoutSoundViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSoundViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutSoundViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_sound_view, null, false, obj);
    }
}
