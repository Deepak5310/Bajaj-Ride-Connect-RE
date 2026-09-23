package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class be implements Runnable {
    final /* synthetic */ bt a;

    public be(bt btVar) {
        this.a = btVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bt btVar = this.a;
        btVar.k = null;
        btVar.d.a(2, "CONNECTING after backoff");
        this.a.d(com.google.android.libraries.navigation.internal.afx.r.CONNECTING);
        this.a.h();
    }
}
