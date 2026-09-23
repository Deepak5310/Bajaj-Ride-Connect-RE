package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av extends com.google.android.libraries.navigation.internal.ael.bb implements cz {
    public av() {
        super(aw.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        aw awVar = (aw) this.b;
        aw awVar2 = aw.a;
        awVar.c();
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, awVar.d);
    }

    public final void d(com.google.android.libraries.navigation.internal.ade.o oVar) {
        if (!this.b.H()) {
            v();
        }
        aw awVar = (aw) this.b;
        com.google.android.libraries.navigation.internal.ade.p pVar = (com.google.android.libraries.navigation.internal.ade.p) oVar.t();
        aw awVar2 = aw.a;
        pVar.getClass();
        awVar.c();
        awVar.d.add(pVar);
    }

    public final void e(com.google.android.libraries.navigation.internal.ade.p pVar) {
        if (!this.b.H()) {
            v();
        }
        aw awVar = (aw) this.b;
        aw awVar2 = aw.a;
        pVar.getClass();
        awVar.c();
        awVar.d.add(pVar);
    }
}
