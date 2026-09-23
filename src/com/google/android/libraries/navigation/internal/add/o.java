package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends com.google.android.libraries.navigation.internal.ael.bb implements cz {
    public o() {
        super(t.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        t tVar = (t) this.b;
        t tVar2 = t.a;
        bz bzVar = tVar.h;
        if (!bzVar.c()) {
            tVar.h = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, tVar.h);
    }

    public final void d(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        t tVar = (t) this.b;
        t tVar2 = t.a;
        tVar.c();
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, tVar.g);
    }

    public final void e(String str) {
        if (!this.b.H()) {
            v();
        }
        t tVar = (t) this.b;
        t tVar2 = t.a;
        str.getClass();
        tVar.c();
        tVar.g.add(str);
    }
}
