package com.google.android.libraries.navigation.internal.me;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s implements Runnable {
    final /* synthetic */ w a;
    final /* synthetic */ t b;

    public s(t tVar, w wVar) {
        this.a = wVar;
        this.b = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.a) {
            this.b.b.d(this.a.d());
        }
    }
}
