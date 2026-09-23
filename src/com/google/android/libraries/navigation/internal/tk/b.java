package com.google.android.libraries.navigation.internal.tk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements Runnable {
    final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.a;
        if (cVar.e) {
            cVar.f();
            c cVar2 = this.a;
            cVar2.a.postDelayed(cVar2.k, 1000L);
        }
    }
}
