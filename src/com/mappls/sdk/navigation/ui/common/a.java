package com.mappls.sdk.navigation.ui.common;

import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends Scroller {
    public a(Context context) {
        super(context, new DecelerateInterpolator());
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, 350);
    }
}
