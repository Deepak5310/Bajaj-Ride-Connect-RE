package com.mappls.sdk.direction.ui.fragment;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
final class c implements View.OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getParentFragmentManager().popBackStack(this.a.getClass().getName(), 1);
    }
}
