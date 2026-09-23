package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bj implements Runnable {
    final /* synthetic */ bt a;

    public bj(bt btVar) {
        this.a = btVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d.a(2, "Terminated");
        bt btVar = this.a;
        btVar.a.a(btVar);
    }
}
