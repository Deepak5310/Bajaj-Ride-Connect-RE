package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bf implements Runnable {
    final /* synthetic */ bt a;

    public bf(bt btVar) {
        this.a = btVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.r.a == com.google.android.libraries.navigation.internal.afx.r.IDLE) {
            this.a.d.a(2, "CONNECTING as requested");
            this.a.d(com.google.android.libraries.navigation.internal.afx.r.CONNECTING);
            this.a.h();
        }
    }
}
