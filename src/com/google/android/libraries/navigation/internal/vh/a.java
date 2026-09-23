package com.google.android.libraries.navigation.internal.vh;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bt;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends bb implements cz {
    public a() {
        super(b.a);
    }

    public final void a(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        b bVar = (b) this.b;
        b bVar2 = b.a;
        bt btVar = bVar.b;
        if (!btVar.c()) {
            bVar.b = bi.x(btVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, bVar.b);
    }
}
