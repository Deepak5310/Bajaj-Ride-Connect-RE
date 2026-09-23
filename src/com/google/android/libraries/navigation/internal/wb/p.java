package com.google.android.libraries.navigation.internal.wb;

import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements com.google.android.libraries.navigation.internal.rw.c {
    final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.c
    public final void i(com.google.android.libraries.navigation.internal.rw.p pVar, com.google.android.libraries.navigation.internal.rw.p pVar2) {
        if (pVar2 == com.google.android.libraries.navigation.internal.rw.p.GUIDING) {
            this.a.b();
            return;
        }
        q qVar = this.a;
        if (qVar.f) {
            qVar.f = false;
            n nVar = qVar.c;
            ar.q(nVar);
            nVar.c = false;
            nVar.a();
            com.google.android.libraries.navigation.internal.ua.a aVar = qVar.d;
            ar.q(aVar);
            bp bpVar = (bp) aVar;
            bpVar.l.ab();
            cy.a(bpVar.l);
            bpVar.k = false;
        }
    }
}
