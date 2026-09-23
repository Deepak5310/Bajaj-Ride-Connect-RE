package com.google.android.libraries.navigation.internal.aah;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends bb implements cz {
    public b() {
        super(c.a);
    }

    public final void a(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        c cVar = (c) this.b;
        c cVar2 = c.a;
        bz bzVar = cVar.d;
        if (!bzVar.c()) {
            cVar.d = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, cVar.d);
    }
}
