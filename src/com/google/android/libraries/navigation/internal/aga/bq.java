package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bq implements Runnable {
    final /* synthetic */ br a;

    public bq(br brVar) {
        this.a = brVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        br brVar = this.a;
        brVar.c.f333n.remove(brVar.a);
        if (this.a.c.r.a == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN && this.a.c.f333n.isEmpty()) {
            this.a.c.f();
        }
    }
}
