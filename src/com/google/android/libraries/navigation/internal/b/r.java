package com.google.android.libraries.navigation.internal.b;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ t c;

    public r(t tVar, String str, long j) {
        this.a = str;
        this.b = j;
        this.c = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.a(this.a, this.b);
        t tVar = this.c;
        tVar.a.b(tVar.toString());
    }
}
