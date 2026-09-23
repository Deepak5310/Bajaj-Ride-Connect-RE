package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class ah implements com.google.android.libraries.navigation.internal.rw.c, com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ al a;

    public ah(al alVar) {
        this.a = alVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        com.google.android.libraries.navigation.internal.rw.i iVar = (com.google.android.libraries.navigation.internal.rw.i) bVar;
        this.a.s = iVar.c != com.google.android.libraries.navigation.internal.rw.p.OFF;
        com.google.android.libraries.navigation.internal.tj.h hVar = iVar.e;
        com.google.android.libraries.navigation.internal.tj.j jVarA = com.google.android.libraries.navigation.internal.rw.t.a(bVar);
        if (hVar != null) {
            this.a.r = hVar.e;
        } else if (jVarA != null) {
            this.a.r = jVarA.c().b.j;
        }
        this.a.l();
    }

    @Override // com.google.android.libraries.navigation.internal.rw.c
    public final void i(com.google.android.libraries.navigation.internal.rw.p pVar, com.google.android.libraries.navigation.internal.rw.p pVar2) {
        this.a.s = pVar2 != com.google.android.libraries.navigation.internal.rw.p.OFF;
        if (pVar2 != com.google.android.libraries.navigation.internal.rw.p.GUIDING) {
            this.a.t = com.google.android.libraries.navigation.internal.bp.bh.b;
        }
        al alVar = this.a;
        if (alVar.s) {
            alVar.g.g();
        }
        this.a.l();
    }
}
