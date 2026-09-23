package com.mappls.sdk.navigation.ui.navigation.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.ui.databinding.LayoutJunctionViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public class JunctionView extends RelativeLayout {
    LayoutJunctionViewBinding mBinding;

    public JunctionView(Context context) {
        super(context);
        this.mBinding = LayoutJunctionViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setVisibility(4);
        MapplsNavigationHelper.getInstance().setJunctionInfoChangedListener(new a(this));
    }

    public JunctionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBinding = LayoutJunctionViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    public JunctionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBinding = LayoutJunctionViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }
}
