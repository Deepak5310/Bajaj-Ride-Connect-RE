package com.google.android.apps.gmm.base.views.core;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class a implements View.OnClickListener {
    final /* synthetic */ ExpandableTextView a;

    public a(ExpandableTextView expandableTextView) {
        this.a = expandableTextView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ExpandableTextView expandableTextView = this.a;
        expandableTextView.setExpanded$ar$ds(!expandableTextView.b);
    }
}
