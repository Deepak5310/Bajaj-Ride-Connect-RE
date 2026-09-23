package com.google.android.libraries.navigation.internal.afz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements Runnable {
    final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.a;
        gVar.b = gVar.a.a(gVar.b);
        this.a.a.c();
    }
}
