package com.google.android.libraries.navigation.internal.us;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements com.google.android.libraries.navigation.internal.rw.r {
    final /* synthetic */ ah a;

    public ag(ah ahVar) {
        this.a = ahVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.r
    public final void j(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        int iA = com.google.android.libraries.navigation.internal.jk.a.a(oVar.c());
        ah ahVar = this.a;
        if (ahVar.y != iA) {
            ahVar.y = iA;
            ahVar.R(ahVar.ab(iA));
            this.a.aa();
        }
    }
}
