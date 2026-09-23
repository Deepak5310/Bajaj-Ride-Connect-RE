package com.google.android.libraries.navigation.internal.dp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.ql.a a;
    final /* synthetic */ e b;

    public d(e eVar, com.google.android.libraries.navigation.internal.ql.a aVar) {
        this.a = aVar;
        this.b = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.b.a;
        if (gVar.k == null) {
            return;
        }
        gVar.e(this.a);
    }
}
