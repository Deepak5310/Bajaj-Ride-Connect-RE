package com.google.android.libraries.navigation.internal.me;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements Runnable {
    final /* synthetic */ w a;
    final /* synthetic */ n b;

    public m(n nVar, w wVar) {
        this.a = wVar;
        this.b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.a) {
            this.b.b.a(this.a);
        }
    }
}
