package com.google.android.libraries.navigation.internal.tk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements Runnable {
    final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.ut.d dVar = this.a.p;
        if (dVar != null) {
            dVar.c();
            this.a.a();
        }
    }
}
