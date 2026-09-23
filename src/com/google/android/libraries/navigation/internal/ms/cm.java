package com.google.android.libraries.navigation.internal.ms;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cm implements View.OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;

    public cm(View view, Object obj) {
        this.a = view;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (ck.k(this.a) != null) {
            ((cs.b) this.b).a();
        }
    }
}
