package com.google.android.apps.gmm.base.views.linear;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends LinearLayout.LayoutParams {
    public final e a;

    public f() {
        super(-2, -2);
        this.a = new e();
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new e();
    }

    public f(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = new e();
    }
}
