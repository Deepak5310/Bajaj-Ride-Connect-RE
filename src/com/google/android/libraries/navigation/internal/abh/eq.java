package com.google.android.libraries.navigation.internal.abh;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eq implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ es a;

    public eq(es esVar) {
        this.a = esVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        synchronized (this.a) {
            this.a.i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            es esVar = this.a;
            esVar.c.c(esVar.h);
            es esVar2 = this.a;
            esVar2.h = new w(Math.max(1, esVar2.i.getMeasuredWidth()), Math.max(1, this.a.i.getMeasuredHeight()));
            es esVar3 = this.a;
            esVar3.c.b(esVar3.h);
        }
        this.a.ac(1);
    }
}
