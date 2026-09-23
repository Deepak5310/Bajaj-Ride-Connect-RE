package com.google.android.libraries.navigation.internal.le;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.lc.a a;
    final /* synthetic */ ah b;

    public ag(ah ahVar, com.google.android.libraries.navigation.internal.lc.a aVar) {
        this.a = aVar;
        this.b = ahVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.b;
        ae aeVar = (ae) ahVar.f.m.get(ahVar.b);
        if (aeVar == null) {
            return;
        }
        if (!this.a.c()) {
            aeVar.i(this.a);
            return;
        }
        ah ahVar2 = this.b;
        ahVar2.e = true;
        if (ahVar2.a.n()) {
            this.b.c();
            return;
        }
        try {
            com.google.android.libraries.navigation.internal.ld.i iVar = this.b.a;
            iVar.k(null, iVar.g());
        } catch (SecurityException unused) {
            this.b.a.j("Failed to get service from broker.");
            aeVar.i(new com.google.android.libraries.navigation.internal.lc.a(10));
        }
    }
}
