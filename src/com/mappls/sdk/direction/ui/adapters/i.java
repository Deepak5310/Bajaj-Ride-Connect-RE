package com.mappls.sdk.direction.ui.adapters;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ j.b a;
    final /* synthetic */ j b;

    i(j jVar, j.b bVar) {
        this.b = jVar;
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.b.b(this.a.getBindingAdapterPosition());
    }
}
