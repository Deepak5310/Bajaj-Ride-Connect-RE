package com.google.android.libraries.navigation.internal.fl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements Runnable {
    final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            q qVar = this.a;
            if (qVar.c) {
                qVar.c();
            }
        }
    }
}
