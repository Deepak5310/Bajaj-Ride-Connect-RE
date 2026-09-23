package com.google.android.libraries.navigation.internal.add;

import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends com.google.android.libraries.navigation.internal.ael.bb implements cz {
    public j() {
        super(k.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        k kVar = (k) this.b;
        k kVar2 = k.a;
        kVar.c();
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, kVar.b);
    }

    public final void d(com.google.android.libraries.navigation.internal.afj.b bVar) {
        if (!this.b.H()) {
            v();
        }
        k kVar = (k) this.b;
        k kVar2 = k.a;
        bVar.getClass();
        kVar.c();
        kVar.b.add(bVar);
    }
}
