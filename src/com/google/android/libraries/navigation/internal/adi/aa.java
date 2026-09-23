package com.google.android.libraries.navigation.internal.adi;

import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends com.google.android.libraries.navigation.internal.ael.bb implements cz {
    public aa() {
        super(ab.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        ab abVar = (ab) this.b;
        ab abVar2 = ab.a;
        com.google.android.libraries.navigation.internal.ael.bz bzVar = abVar.q;
        if (!bzVar.c()) {
            abVar.q = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, abVar.q);
    }

    public final void d(int i) {
        if (!this.b.H()) {
            v();
        }
        ab abVar = (ab) this.b;
        ab abVar2 = ab.a;
        abVar.c();
        abVar.m.i(i);
    }
}
