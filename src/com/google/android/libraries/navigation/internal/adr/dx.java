package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dx extends com.google.android.libraries.navigation.internal.ael.bb<el, dx> implements com.google.android.libraries.navigation.internal.ael.cz {
    public dx() {
        super(el.a);
    }

    public final void c(gn gnVar) {
        if (!this.b.H()) {
            v();
        }
        el elVar = (el) this.b;
        el elVar2 = el.a;
        gnVar.getClass();
        com.google.android.libraries.navigation.internal.ael.bz bzVar = elVar.f221n;
        if (!bzVar.c()) {
            elVar.f221n = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        elVar.f221n.add(gnVar);
    }

    public final void d(gn gnVar) {
        if (!this.b.H()) {
            v();
        }
        el elVar = (el) this.b;
        el elVar2 = el.a;
        gnVar.getClass();
        com.google.android.libraries.navigation.internal.ael.bz bzVar = elVar.p;
        if (!bzVar.c()) {
            elVar.p = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        elVar.p.add(gnVar);
    }
}
