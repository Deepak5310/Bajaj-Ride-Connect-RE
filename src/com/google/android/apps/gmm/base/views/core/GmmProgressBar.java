package com.google.android.apps.gmm.base.views.core;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class GmmProgressBar extends ProgressBar {
    public final View[] a;

    public GmmProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new View[0];
        new AnimatorSet();
        new c(new WeakReference(this));
    }
}
