package com.google.android.libraries.navigation.internal.ms;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.requestFocus();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        view.clearFocus();
    }
}
