package com.google.android.libraries.navigation.internal.ms;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ cs b;
    final /* synthetic */ ag c;

    public ae(ag agVar, View view, cs csVar) {
        this.a = view;
        this.b = csVar;
        this.c = agVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cs csVar;
        af afVar = this.c.g;
        if (afVar == null || (csVar = this.b) == null) {
            return;
        }
        afVar.a(this.a, csVar);
    }
}
