package com.google.android.libraries.navigation.internal.abh;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class de implements AdapterView.OnItemClickListener {
    final /* synthetic */ df a;

    public de(df dfVar) {
        this.a = dfVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a.c(i);
    }
}
