package com.google.android.libraries.navigation.internal.fl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements Runnable {
    final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            i iVar = this.a;
            iVar.e = false;
            iVar.d.run();
        }
    }
}
