package com.google.android.libraries.navigation.internal.b;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements Runnable {
    final /* synthetic */ t a;
    final /* synthetic */ e b;

    public d(e eVar, t tVar) {
        this.a = tVar;
        this.b = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.a.put(this.a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
