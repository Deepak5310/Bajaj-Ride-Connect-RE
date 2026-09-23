package com.google.android.libraries.navigation.internal.ady;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends bb implements cz {
    public i() {
        super(n.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        n nVar = (n) this.b;
        n nVar2 = n.a;
        bz bzVar = nVar.c;
        if (!bzVar.c()) {
            nVar.c = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, nVar.c);
    }
}
