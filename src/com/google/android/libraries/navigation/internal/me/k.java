package com.google.android.libraries.navigation.internal.me;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements Runnable {
    final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a.a) {
            this.a.b.b();
        }
    }
}
