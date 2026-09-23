package com.mappls.sdk.direction.ui.fragment;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
final class j implements View.OnClickListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getParentFragmentManager().popBackStack(this.a.getClass().getName(), 1);
    }
}
