package com.google.android.libraries.navigation.internal.me;

import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements Runnable {
    final /* synthetic */ w a;
    final /* synthetic */ q b;

    public p(q qVar, w wVar) {
        this.a = wVar;
        this.b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.a) {
            r rVar = this.b.b;
            Exception excC = this.a.c();
            be.j(excC);
            rVar.c(excC);
        }
    }
}
