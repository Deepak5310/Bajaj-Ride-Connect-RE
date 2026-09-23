package com.google.android.libraries.navigation.internal.adl;

import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends bb implements cz {
    public t() {
        super(u.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        u uVar = (u) this.b;
        u uVar2 = u.a;
        uVar.c();
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, uVar.i);
    }

    public final void d(ga gaVar) {
        if (!this.b.H()) {
            v();
        }
        u uVar = (u) this.b;
        u uVar2 = u.a;
        uVar.c();
        uVar.i.add(gaVar);
    }
}
