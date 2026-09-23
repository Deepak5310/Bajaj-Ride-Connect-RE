package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dh implements Runnable {
    final /* synthetic */ dp a;

    public dh(dp dpVar) {
        this.a = dpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        dp dpVar = this.a;
        dpVar.l = null;
        dpVar.i.c();
        this.a.d();
    }
}
