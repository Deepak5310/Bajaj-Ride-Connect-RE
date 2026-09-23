package com.mappls.sdk.direction.ui.fragment;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
final class o implements View.OnClickListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getParentFragmentManager().popBackStack(this.a.getClass().getName(), 1);
    }
}
