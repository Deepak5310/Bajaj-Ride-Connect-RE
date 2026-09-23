package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class di implements Runnable {
    final /* synthetic */ dp a;

    public di(dp dpVar) {
        this.a = dpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        dp dpVar = this.a;
        dpVar.j = null;
        if (dpVar.i.e()) {
            this.a.d();
        }
    }
}
