package com.mappls.sdk.direction.ui.fragment;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getParentFragmentManager().popBackStack(this.a.getClass().getName(), 1);
    }
}
