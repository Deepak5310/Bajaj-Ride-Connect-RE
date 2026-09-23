package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ c b;

    public a(c cVar, b bVar) {
        this.b = cVar;
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c cVar = this.b;
        e eVar = cVar.b;
        if (eVar != null) {
            eVar.a(((d) cVar.a.get(this.a.getAdapterPosition())).a);
        }
    }
}
