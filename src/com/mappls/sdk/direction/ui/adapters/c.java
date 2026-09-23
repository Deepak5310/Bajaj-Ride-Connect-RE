package com.mappls.sdk.direction.ui.adapters;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
final class c implements View.OnClickListener {
    final /* synthetic */ com.mappls.sdk.direction.ui.model.d a;
    final /* synthetic */ d b;

    c(d dVar, com.mappls.sdk.direction.ui.model.d dVar2) {
        this.b = dVar;
        this.a = dVar2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        for (com.mappls.sdk.direction.ui.model.d dVar : this.b.a) {
            if (dVar == this.a) {
                dVar.a(Boolean.TRUE);
                if (this.b.b != null) {
                    this.b.b.a(dVar.a());
                }
            } else {
                dVar.a(Boolean.FALSE);
            }
        }
        this.b.notifyDataSetChanged();
    }
}
